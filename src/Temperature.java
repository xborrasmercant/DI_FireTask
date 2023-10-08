public class Temperature {
    int width;
    int height;
    double percentageColdPoints;
    double percentageSparks;
    int[][] temps;

    public Temperature(int width, int height, double percentageColdPoints, double percentageSparks) {
        this.width = width;
        this.height = height;
        this.percentageColdPoints = percentageColdPoints;
        this.percentageSparks = percentageSparks;
        this.temps = new int[height][width];
    }

    private void sparks() {
        double randPercentage;
        for (int col = 0; col < width; col++) {
            randPercentage = Math.random();
            if (randPercentage <= percentageSparks) {
                temps[height - 1][col] = 255;
            }
        }
    }

    private void calc() {
        int avgTemp;
        for (int row = width-1; row >= 0; row--) {
            System.out.println("hola");
            for (int col = 0; col < height; col++) {
                if (row != 0) {
                    if (col == 0) {
                        avgTemp = (temps[row][col] + temps[row][col+1] + temps[row-1][col]) / 3;
                    }
                    else if ((col == height-1)) {
                        avgTemp = (temps[row][col] + temps[row][col-1] + temps[row-1][col]) / 3;
                    }
                    else {
                        avgTemp = (temps[row][col-1] + temps[row][col] + temps[row][col+1] + temps[row-1][col]) / 4;
                    }

                    System.out.println("CurrentPos: " + temps[row][col]);
                    System.out.println("AvgTemp: " + avgTemp);
                    temps[row-1][col] = avgTemp;
                }
            }
        }
    }

    private void printTemps(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (temps[i][j] != 0) {
                    System.out.print(" " + temps[i][j] + " ");
                } else {
                    System.out.print("  " + temps[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Temperature tempsMap = new Temperature(10,10,0.3, 0.3);

        tempsMap.sparks();
        tempsMap.calc();
        tempsMap.printTemps();
    }
}