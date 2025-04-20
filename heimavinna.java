import java.util.*;
public class heimavinna{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] inputArray = input.split(";");

        int result = 0;

        for (int i = 0; i < inputArray.length; i++){

            if (inputArray[i].contains("-")){
                String[] currentNums = inputArray[i].split("-");

                int after = Integer.parseInt(currentNums[1]);
                int before = Integer.parseInt(currentNums[0]);

                result += (after - before);
                result += 1;

            } else {
                result++;
            }

        }
            System.out.println(result);

    }
}