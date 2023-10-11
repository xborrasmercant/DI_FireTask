package Logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Palette {
    int[][] colourPalette = new int[255][4];
    ArrayList<int[]> colourTargets = new ArrayList<>();

    public void printPalette() {
        for (int row = 0; row < colourPalette.length - 1; row++) {
            for (int col = 0; col < colourPalette[row].length; col++) {
                System.out.print(" | " + colourPalette[row][col] + " | ");
            }
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
    private void calcChannel(int[] colourTarget1, int[] colourTarget2, int channelPos) {
        int A, B, C, step, NSteps, increment;
        A = colourTarget1[channelPos+1];
        B = colourTarget2[channelPos+1];
        step = 0;
        NSteps = colourTarget2[0] - colourTarget1[0];
        increment = (B - A) / NSteps;

        for (int paletteColour = colourTarget1[0]; paletteColour < colourTarget2[0]; paletteColour++) {
            C = A + step * increment;
            colourPalette[paletteColour][channelPos] = C;
            step++;
        }
    }

    public void calc() {
        for (int colourTarget = 0; colourTarget < colourTargets.size() - 1; colourTarget++) {
            for (int channelPos = 0; channelPos < 4; channelPos++) {
                calcChannel(colourTargets.get(colourTarget), colourTargets.get(colourTarget + 1), channelPos);
            }
        }
    }
}