import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Palette {
    int[][] colourPalette = new int[255][4];
    ArrayList<int[]> colourTargets = new ArrayList<>();

    private void printPalette() {
        for (int row = 0; row < colourPalette.length - 1; row++) {
            for (int col = 0; col < colourPalette[row].length; col++) {
                System.out.print(" | " + colourPalette[row][col] + " | ");
            }
            System.out.println();
        }
    }

    private void addColourTarget(int temp, int a, int r, int g, int b) {
        int[] colourTarget = {temp, a, r, g, b};
        colourTargets.add(colourTarget);
    }

    private void sortColourTargets() {
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

    /*
    System.out.println("============TEMP ORDER===========");
    for (int i = 0; i < tempOrder.length; i++) {
        System.out.print(tempOrder[i] + " ");
    }
    System.out.println();
    System.out.println("=================================");
    System.out.println();
    */

    }

    private void calcChannel(int[] colourTarget1, int[] colourTarget2, int channelPos) {
        int A, B, C, step, NSteps, increment;
        A = colourTarget1[channelPos];
        B = colourTarget2[channelPos];
        step = 1;
        NSteps = colourTarget1[0] - colourTarget2[0];
        increment = B / NSteps;

        for (int paletteColour = colourTarget1[0]; paletteColour < colourTarget2[0]; paletteColour++) {
            C = A + step * increment;
        colourPalette[paletteCoªlour][channelPos] = C;
            step++;
        }
    }

    private void calc() {
        for (int colourTarget = 0; colourTarget < colourTargets.size()-1; colourTarget++) {
            for (int channelPos = 0; channelPos < 4; channelPos++) {
                calcChannel(colourTargets.get(colourTarget), colourTargets.get(colourTarget + 1), channelPos);
            }
        }
    }

    private void printColourTargets() {
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

    public static void main (String[]args){
        Palette palette = new Palette();


        palette.addColourTarget(255, 255, 255, 255, 255); // Spark
        palette.addColourTarget(150, 255, 242, 125, 12); // ORANGE
        palette.addColourTarget(200, 255, 253, 207, 88); // YELLOW
        palette.addColourTarget(0, 0, 0, 0, 0);      // Transparency
        palette.addColourTarget(75, 255, 128, 9, 9);  // RED
        palette.sortColourTargets();
        palette.printColourTargets();

        palette.calc();

        palette.printPalette();

    }
}



