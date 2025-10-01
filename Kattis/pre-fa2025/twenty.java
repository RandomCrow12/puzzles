// https://open.kattis.com/problems/2048
import java.util.*;

public class twenty {  // [r][c]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] game = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                game[i][j] = sc.nextInt();
            }
        }

        int input = sc.nextInt();

// try to move them all in a direction, if there is ever a combination, go through again
        switch (input) {
            case 0: //l
                left(game);
                break;
            case 1: //u
                up(game);
                break;
            case 2: //r
                right(game);
                break;
            case 3: //d
                down(game);
                break;
        }

        System.out.print(game[0][0] + " " + game[0][1] + " " + game[0][2] + " " + game[0][3] + "\n");
        System.out.print(game[1][0] + " " + game[1][1] + " " + game[1][2] + " " + game[1][3] + "\n");
        System.out.print(game[2][0] + " " + game[2][1] + " " + game[2][2] + " " + game[2][3] + "\n");
        System.out.print(game[3][0] + " " + game[3][1] + " " + game[3][2] + " " + game[3][3] + "\n");

    }
    // clear methods get rid of 0s in between, the actiual combinations happen in between an initial 0 clear and a final 0 clear

    private static void left(int[][] game) {

        for (int k = 0; k < 4; k++) {
            lclear(game, k);
            for (int i = 0; i < 3; i++) {
                if (game[k][i] == game[k][i + 1]) {
                    game[k][i] = game[k][i] + game[k][i + 1];
                    game[k][i + 1] = 0;
                }
            }
            lclear(game, k);
        }

    }

    private static void lclear(int[][] game, int k) {
        int runs = 4;
        while (runs > 0) {
            for (int i = 0; i < 3; i++) {
                if (game[k][i] == 0) {
                    game[k][i] = game[k][i] + game[k][i + 1];
                    game[k][i + 1] = 0;
                }
            }
            runs--;
        }
    }

    private static void up(int[][] game) {

        for (int k = 0; k < 4; k++) {
            uclear(game, k);
            for (int i = 0; i < 3; i++) {
                if (game[i][k] == game[i + 1][k]) {
                    game[i][k] = game[i][k] + game[i + 1][k];
                    game[i + 1][k] = 0;
                }
            }
            uclear(game, k);
        }
    }

    private static void uclear(int[][] game, int k) {
        int runs = 4;
        while (runs > 0) {
            for (int i = 0; i < 3; i++) {
                if (game[i][k] == 0) {
                    game[i][k] = game[i][k] + game[i + 1][k];
                    game[i + 1][k] = 0;
                }
            }
            runs--;
        }
    }

    private static void right(int[][] game) {

        for (int k = 0; k < 4; k++) {
            rclear(game, k);
            for (int i = 3; i > 0; i--) {
                if (game[k][i] == game[k][i - 1]) {
                    game[k][i] = game[k][i] + game[k][i - 1];
                    game[k][i - 1] = 0;
                }
            }
            rclear(game, k);
        }

    }

    private static void rclear(int[][] game, int k) {
        int runs = 4;
        while (runs > 0) {
            for (int i = 3; i > 0; i--) {
                if (game[k][i] == 0) {
                    game[k][i] = game[k][i] + game[k][i - 1];
                    game[k][i - 1] = 0;
                }
            }
            runs--;
        }
    }

    private static void down(int[][] game) {

        for (int k = 0; k < 4; k++) {
            dclear(game, k);
            for (int i = 3; i > 0; i--) {
                if (game[i][k] == game[i - 1][k]) {
                    game[i][k] = game[i][k] + game[i - 1][k];
                    game[i - 1][k] = 0;
                }
            }
            dclear(game, k);
        }

    }

    private static void dclear(int[][] game, int k) {
        int runs = 4;
        while (runs > 0) {
            for (int i = 3; i > 0; i--) {
                if (game[i][k] == 0) {
                    game[i][k] = game[i][k] + game[i - 1][k];
                    game[i - 1][k] = 0;
                }
            }
            runs--;
        }
    }

}
