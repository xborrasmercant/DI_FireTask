package Model;

import java.awt.*;

    public class Temperature {
        private int width;
        private int height;
        private int percentageColdPoints;
        private int percentageSparks;
        private int[][] tempMap;
        private Boolean isInverted;
        private int divisor;

        public Temperature(int width, int height, int percentageColdPoints, int percentageSparks, Boolean isInverted, int divisor) {
            this.width = width;
            this.height = height;
            this.tempMap = new int[this.height][this.width];
            this.percentageColdPoints = percentageColdPoints;
            this.percentageSparks = percentageSparks;
            this.isInverted = isInverted;
            this.divisor = divisor;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public double getPercentageColdPoints() {
            return percentageColdPoints;
        }

        public void setPercentageColdPoints(int percentageColdPoints) {
            this.percentageColdPoints = percentageColdPoints;
        }

        public double getPercentageSparks() {
            return percentageSparks;
        }

        public void setPercentageSparks(int percentageSparks) {
            this.percentageSparks = percentageSparks;
        }

        public int[][] getTempMap() {
            return tempMap;
        }

        public void setTempMap(int[][] tempMap) {
            this.tempMap = tempMap;
        }

        public Boolean getIsInverted() {
            return isInverted;
        }

        public void setIsInverted(Boolean inverted) {
            isInverted = inverted;
        }


        public int getDivisor() {
            return divisor;
        }

        public void setDivisor(int divisor) {
            this.divisor = divisor;
        }

        private void cold() {
            double randPercentage;

            if (!isInverted) {
                for (int col = 0; col < width; col++) {
                    randPercentage = Math.random()*100;
                    if (randPercentage <= percentageColdPoints) {
                        tempMap[height - 1][col] = 0;
                    }
                }
            }
            else {
                for (int col = 0; col < width; col++) {
                    randPercentage = Math.random()*100;
                    if (randPercentage <= percentageColdPoints) {
                        tempMap[0][col] = 0;
                    }
                }
            }
        }
        private void sparks() {
            double randPercentage;

            if (!isInverted) {
                for (int col = 0; col < width; col++) {
                    randPercentage = Math.random()*100;
                    if (randPercentage <= percentageSparks) {
                        tempMap[height - 1][col] = 255;
                    }
                }
            }
            else {
                for (int col = 0; col < width; col++) {
                    randPercentage = Math.random()*100;
                    if (randPercentage <= percentageSparks) {
                        tempMap[0][col] = 255;
                    }
                }
            }

        }
        private void calc() {
            int avgTemp;

            if (!isInverted) {
                for (int row = height-2; row > 0; row--) {
                    for (int col = 0; col < width; col++) {
                        if (col == 0) {
                            avgTemp = (tempMap[row][col] + tempMap[row+1][col] + tempMap[row][col+1] + tempMap[row+1][col+1]) / 4;
                        }
                        else if (col == width-1) {
                            avgTemp = (tempMap[row][col] + tempMap[row+1][col] + tempMap[row][col-1] + tempMap[row+1][col-1]) / 4;
                        }
                        else {
                            avgTemp = (tempMap[row][col-1] + tempMap[row][col] + tempMap[row][col+1] + tempMap[row+1][col] + tempMap[row+1][col-1] + tempMap[row+1][col+1]) / 6;
                        }
                        tempMap[row][col] = avgTemp;
                    }
                }
            }
            else {

                for (int row = 1; row < height; row++) {
                    for (int col = 0; col < width; col++) {
                        if (col == 0) {
                            avgTemp = (tempMap[row][col] + tempMap[row-1][col] + tempMap[row][col+1] + tempMap[row-1][col+1]) / 4;
                        }
                        else if (col == width-1) {
                            avgTemp = (tempMap[row][col] + tempMap[row-1][col] + tempMap[row][col-1] + tempMap[row-1][col-1]) / 4;
                        }
                        else {
                            avgTemp = (tempMap[row][col-1] + tempMap[row][col] + tempMap[row][col+1] + tempMap[row-1][col] + tempMap[row-1][col-1] + tempMap[row-1][col+1]) / 6;
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