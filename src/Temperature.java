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

    public void printTemps(){
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
        Temperature tempsMap = new Temperature(10,10,0.3, 0.9);

        tempsMap.sparks();
        tempsMap.printTemps();
    }
}