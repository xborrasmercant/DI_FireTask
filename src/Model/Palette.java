package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Palette {
    protected Color[] colourPalette = new Color[256];
    protected int[][] matrixPalette = new int[256][4];
    protected ArrayList<int[]> colourTargets = new ArrayList<>();

    public Palette() {
        this.addColourTarget(255, 255, 255, 255, 255); // Spark
        this.addColourTarget(220, 200, 255, 207, 88); // YELLOW
        this.addColourTarget(200, 180, 255, 125, 12); // ORANGE
        this.addColourTarget(180, 100, 255, 9, 9);  // RED
        this.addColourTarget(150, 30, 99, 105, 105);  // Grey
        this.addColourTarget(0, 0, 0, 0, 0); // Transparency

        this.sortColourTargets();
        //this.printColourTargets();
        this.calc();
        //this.printPalette();
    }

    public void printPalette() {
        for (int row = 0; row < matrixPalette.length; row++) {
            for (int col = 0; col < matrixPalette[row].length; col++) {
                System.out.print(" | " + matrixPalette[row][col] + " | ");
            }
            System.out.println();
            System.out.println(row);
            System.out.println();
        }
    }

    public Color[] getColourPalette() {
        return colourPalette;
    }


    public void setColourPalette(Color[] colourPalette) {
        this.colourPalette = colourPalette;
    }

    public int[][] getMatrixPalette() {
        return matrixPalette;
    }

    public void setMatrixPalette(int[][] matrixPalette) {
        this.matrixPalette = matrixPalette;
    }

    public ArrayList<int[]> getColourTargets() {
        return colourTargets;
    }

    public void setColourTargets(ArrayList<int[]> colourTargets) {
        this.colourTargets = colourTargets;
    }

    public void setColourTarget(int i, int a, int r, int g, int b) {
        colourTargets.get(i)[1] = a;
        colourTargets.get(i)[2] = r;
        colourTargets.get(i)[3] = g;
        colourTargets.get(i)[4] = b;
    }

    public void addColourTarget(int temp, int a, int r, int g, int b) {
        int[] colourTarget = {temp, a, r, g, b};
        colourTargets.add(colourTarget);
    }
    public void sortColourTargets() {
        int[] tempOrder = new int[colourTargets.size()];

        for (int i = 0; i < colourTargets.size(); i++) {
            tempOrder[i] = (colourTargets.get(i)[0]);
        }
        Arrays.sort(tempOrder);

        for (int sortedPos = 0; sortedPos < tempOrder.length; sortedPos++) {
            for (int unsortedPos = 0; unsortedPos < colourTargets.size(); unsortedPos++) {
                if (tempOrder[sortedPos] == colourTargets.get(unsortedPos)[0]) {
                    Collections.swap(colourTargets, sortedPos, unsortedPos);
                }
            }
        }
    }
    public void printColourTargets() {
        for (int[] array : colourTargets) {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
    private void intToColor(int[][] matrixPalette, Color[] colourPalette) {
    int R, G, B, A;

        for (int x = 0; x < matrixPalette.length; x++) {
            A = matrixPalette[x][0];
            R = matrixPalette[x][1];
            G = matrixPalette[x][2];
            B = matrixPalette[x][3];

            colourPalette[x] = new Color (R, G, B, A);

            //System.out.println(new Color(R,G,B,A)); // Check if colours are being converted.
        }
    }
    private void calcChannel(int[] colourTarget1, int[] colourTarget2, int channelPos) {
        int A, B, C, step, NSteps, increment;
        A = colourTarget1[channelPos+1];
        B = colourTarget2[channelPos+1];
        step = 0;
        NSteps = colourTarget2[0] - colourTarget1[0];


        for (int paletteColour = colourTarget1[0]; paletteColour < colourTarget2[0]; paletteColour++) {
            increment = (B - A) / NSteps;

            C = A + step * increment;
            matrixPalette[paletteColour][channelPos] = C;
            step++;
        }


    }
    public void calc() {
        for (int colourTarget = 0; colourTarget < colourTargets.size()-1; colourTarget++) {
            for (int channelPos = 0; channelPos < 4; channelPos++) {
                calcChannel(colourTargets.get(colourTarget), colourTargets.get((colourTarget+1)), channelPos);
            }
        }

        matrixPalette[255] = new int[]{255, 255, 255, 255}; // The last position is added manually to prevent index out of bounds.

        this.intToColor(this.matrixPalette, this.colourPalette); // The palette is converted from int to color.
    }
}