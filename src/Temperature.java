import java.awt.*;

public class Temperature {
    int width;
    int height;
    double percentageColdPoints;
    double percentageSparks;
    int[][] tempMap;

    public Temperature(int width, int height, double percentageColdPoints, double percentageSparks) {
        this.width = width;
        this.height = height;
        this.percentageColdPoints = percentageColdPoints;
        this.percentageSparks = percentageSparks;
        this.tempMap = new int[width][height];
    }

    private void cold() {
        double randPercentage;
        for (int col = 0; col < width; col++) {
            randPercentage = Math.random();
            if (randPercentage <= percentageColdPoints) {
                tempMap[col][height - 1] = 0;
            }
        }
    }
    private void sparks() {
        double randPercentage;
        for (int col = 0; col < width; col++) {
            randPercentage = Math.random();
            if (randPercentage <= percentageSparks) {
                tempMap[col][height - 1] = 255;
            }
        }
    }
    private void calc() {
        int avgTemp;
        for (int row = width-2; row > 0; row--) {
            for (int col = 0; col < height; col++) {
                if (row != 0) {
                    if (col == 0) {
                        avgTemp = (tempMap[row][col] + tempMap[row][col+1] + tempMap[row+1][col] + tempMap[row+1][col+1]) / 4;
                    }
                    else if (col == height-1) {
                        avgTemp = (tempMap[row][col] + tempMap[row][col-1] + tempMap[row-1][col] + tempMap[row+1][col-1]) / 4;
                    }
                    else {
                        avgTemp = (tempMap[row][col-1] + tempMap[row][col] + tempMap[row][col+1] + tempMap[row+1][col-1] + tempMap[row+1][col] + tempMap[row+1][col+1]) / 6;
                    }
                    tempMap[row][col] = avgTemp;

                }
            }
        }
    }


    public void printTemps(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tempMap[i][j] != 0) {
                    System.out.print(" " + tempMap[i][j] + " ");
                } else {
                    System.out.print("  " + tempMap[i][j] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void next(){
        this.cold();
        this.sparks();
        this.calc();
    }

}