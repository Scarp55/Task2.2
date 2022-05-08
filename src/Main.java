import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];

        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите угол поворта кратный 90 градусов");
        int deg = scn.nextInt();
        PrintMatrix(colors);
        PrintMatrix(Rotated(colors, deg));
    }

    public static void PrintMatrix(int[][] arr) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("_________________________________");
    }

    public static int[][] Rotated(int[][] arr, int deg) {
        int[][] rotatedColors = new int[SIZE][SIZE];
        for (int k = 0; k < deg / 90; k++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    rotatedColors[i][j] = arr[SIZE - 1 - j][i];
                }
            }
            for (int i = 0; i < SIZE; i++) {
                System.arraycopy(rotatedColors[i], 0, arr[i], 0, SIZE);
            }
        }
        return rotatedColors;
    }
}
