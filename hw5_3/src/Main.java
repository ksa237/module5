import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]

    }


    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        ArrayList<int[]> allTeams = new ArrayList<>();

        int[] answer = new int[10];

        for (int[] arNext : teams) { //artInt - одномерный массив, топ-команды одного региона
            int[] preAnswer = merge(answer, arNext);
            answer = preAnswer;
        }
        return answer;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int[] c = new int[teamA.length];
        int ia = 0;
        int ib = 0;
        int ic = 0;

        while (ia < teamA.length && ib < teamB.length && ic < 10) {

            if (teamA[ia] >= teamB[ib]) {
                c[ic] = teamA[ia];
                ia += 1;
            } else {
                c[ic] = teamB[ib];
                ib += 1;
            }
            ic += 1;
        }

        while (ia < teamA.length && ic < 10) {
            c[ic] = teamA[ia];
            ia += 1;
            ic += 1;
        }

        while (ib < teamB.length && ic < 10) {
            c[ic] = teamB[ib];
            ib += 1;
            ic += 1;
        }

        return c;
    }
}
