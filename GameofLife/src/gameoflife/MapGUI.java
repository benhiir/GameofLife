package gameoflife;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapGUI extends JFrame {

    public final int map_width = 500;
    public final int map_length = 600;
    public final int cell_column = map_width / 10;
    public final int cell_row = map_length / 10;

    JLabel cells[][] = new JLabel[map_width][map_length];

    public MapGUI() throws InterruptedException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = this.getContentPane();

        pane.setLayout(new GridLayout(cell_column, cell_row));
        
        // creating Random game table
        for (int i = 0; i < cell_column; i++) {
            for (int j = 0; j < cell_row; j++) {
                cells[i][j] = new JLabel();
                if (Math.random() * 10 < 2) {
                    cells[i][j].setText("*");
                }
                pane.add(cells[i][j]);
            }
        }

        this.setSize(map_width, map_length);
        this.setVisible(true);
        while (true) {
            Thread.sleep(1000);
            Step();
        }
    }

    public void Step() {

        int k1 = 0;
        int l1 = 0;
        //Using Class newint to let the array accepts negative values
        newint k = new newint(k1);
        k.setTreshold(cell_column);
        newint l = new newint(l1);
        l.setTreshold(cell_row);

        for (int i = 0; i < cell_column; i++) {
            for (int j = 0; j < cell_row; j++) {
                int counter1 = 0;
                int counter2 = 0;

                for (k1 = i - 1; k1 <= i + 1; k1++) {
                    for (l1 = j - 1; l1 <= j + 1; l1++) {
                        if ("*".equals(cells[i][j].getText())) //situation of a living Cell
                        {
                            k.set(k1);
                            l.set(l1);
                            if ("*".equals(cells[k.get()][l.get()].getText())) {
                                counter1++;                     //number of alive cells in the field including the alive cell
                            }
                        }
                        if ("".equals(cells[i][j].getText())) //situation of a dead cell
                        {
                            k.set(k1);
                            l.set(l1);
                            if ("*".equals(cells[k.get()][l.get()].getText())) {
                                counter2++;                     // number of alive cells around the dead cell
                            }
                        }

                    }
                }
                //Determine if the cell lives or dies
                if (counter1 != 3 && counter1 != 4) //live cell
                {
//                    cells[i][j].setOpaque(true);
                    cells[i][j].setBackground(Color.red);
                }
                if (counter2 == 3) //dead cell
                {
//                    cells[i][j].setOpaque(true);
                    cells[i][j].setBackground(Color.green);
                }
            }
        }
        //Repaint the map based on the determinations 
        for (int i = 0; i < cell_column; i++) {
            for (int j = 0; j < cell_row; j++) {
                if (cells[i][j].getBackground() == Color.red) {
                    cells[i][j].setText("");
                } else if (cells[i][j].getBackground() == Color.green) {
                    cells[i][j].setText("*");
                }
            }
        }
    }

}
