import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        compare(1);
        compare(2);
        compare(5);
        compare(15);
    }

    public static void compare(int day) {
        System.out.println("=== Day " + day + " ===");
        int[] startNumbers = {21, 1, 20, 23};
        int iterative = chooseHobbyIterative(startNumbers, day);
        int recursive = chooseHobbyRecursive(startNumbers, day, new int[day]);
        System.out.println("Iterative = " + iterative + " | Recursive = " + recursive);
        System.out.println();
    }

    public static int chooseHobbyRecursive(int[] startNumbers, int day, int[] memory) {
        System.out.println(">>> " + day);
        int hobby = 0;
        //day - глубина рекурсии
        int prev = startNumbers[3];
        int prePrevPrev = startNumbers[1];
        if (day == 1) {
            hobby = (prev * prePrevPrev) % 10 + 1;
        } else {
            day--;
            hobby = (prev * prePrevPrev) % 10 + 1;
            int[] startNumbersR = new int[4];
            startNumbersR[0] = startNumbers[1];
            startNumbersR[1] = startNumbers[2];
            startNumbersR[2] = startNumbers[3];
            startNumbersR[3] = hobby;

            hobby = chooseHobbyRecursive(startNumbersR, day, new int[day]);
        }

        return hobby;

    }

    public static int chooseHobbyIterative(int[] startNumbers, int day) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(startNumbers[0]);
        numbers.add(startNumbers[1]);
        numbers.add(startNumbers[2]);
        numbers.add(startNumbers[3]);

        for (int d = 0; d < day; d++) {
            int index = d + 4; // индексы дней в массиве сдвинуты на 4
            int prev = numbers.get(index - 1); // предыдущее значение
            int prePrePrev = numbers.get(index - 3); // пре-пре-предыдущее значение
            numbers.add((prev * prePrePrev) % 10 + 1);
        }

        return numbers.get(numbers.size() - 1);
    }
}