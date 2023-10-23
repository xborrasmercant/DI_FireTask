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
            this.tempMap = new int[this.height][this.width];
            this.percentageColdPoints = percentageColdPoints;
            this.percentageSparks = percentageSparks;
        }

        private void cold() {
            double randPercentage;
            for (int x = 0; x < width; x++) {
                randPercentage = Math.random();
                if (randPercentage <= percentageColdPoints) {
                    tempMap[height - 1][x] = 0;
                }
            }
        }
        private void sparks() {
            double randPercentage;
            for (int x = 0; x < width; x++) {
                randPercentage = Math.random();
                if (randPercentage <= percentageSparks) {
                    tempMap[height - 1][x] = 255;
                }
            }
        }
        private void calc() {
            int avgTemp;
            for (int y = height-2; y > 0; y--) {
                for (int x = 0; x < width; x++) {
                        if (x == 0) {
                            avgTemp = (tempMap[y][x] + tempMap[y+1][x] + tempMap[y][x+1] + tempMap[y+1][x+1]) / 4;
                        }
                        else if (x == width-1) {
                            avgTemp = (tempMap[y][x] + tempMap[y+1][x] + tempMap[y][x-1] + tempMap[y+1][x-1]) / 4;
                        }
                        else {
                            avgTemp = (tempMap[y][x-1] + tempMap[y][x] + tempMap[y][x+1] + tempMap[y+1][x] + tempMap[y+1][x-1] + tempMap[y+1][x+1]) / 6;
                        }
                        tempMap[y][x] = avgTemp;
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