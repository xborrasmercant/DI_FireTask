import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Palette {
    Color[] colourPalette = new Color[256];
    int[][] matrixPalette = new int[256][4];

    ArrayList<int[]> colourTargets = new ArrayList<>();

    public Palette() {
        this.addColourTarget(255, 255, 255, 255, 255); // Spark
        this.addColourTarget(150, 200, 242, 125, 12); // ORANGE
        this.addColourTarget(200, 255, 253, 207, 88); // YELLOW
        this.addColourTarget(0, 0, 0, 0, 0);      // Transparency
        this.addColourTarget(75, 150, 128, 9, 9);  // RED
        this.addColourTarget(25, 75, 99, 105, 105);  // Grey
        this.sortColourTargets();
        this.printColourTargets();
        this.calc();
        this.printPalette();

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
    int R = 0, G = 0, B = 0, A = 0;

        for (int x = 0; x < matrixPalette.length; x++) {
            A = matrixPalette[x][0];
            R = matrixPalette[x][1];
            G = matrixPalette[x][2];
            B = matrixPalette[x][3];

            colourPalette[x] = new Color (R, G, B, A);
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