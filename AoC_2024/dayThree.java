import java.util.*;

public class dayThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        boolean enabled = true;

        String input = "";

        String addition = "";
        while (!addition.equals("ENDOFINPUT")){
            addition = sc.nextLine();
            input = input + addition;
        }
       
        for (int i = 0; i < input.length()-4; i++){
            if (input.substring(i,i+4).equals("do()")) enabled = true;
            try {
            if (input.substring(i,i+7).equals("don't()")) enabled = false;
            } catch (Exception e){
                // do nothing
            }

            if (enabled){
                if (input.substring(i,i+4).equals("mul(")){
                // System.out.println("AAAAAAAAAAAA");

                int forward = i+5;
                String inFunction = ""; // hello
                while (input.charAt(forward) != ')'){
                    
                    inFunction = inFunction + input.charAt(forward);

                    forward++;
                }
                int num1 = i+4;
                String number1 = "";
                while (input.charAt(num1) != ',' && num1 < i+8){
                    
                    number1 = number1 + input.charAt(num1);
                    num1++;
                }

                int num2 = num1 + 1;
                String number2 = "";
                while (input.charAt(num2) != ')' && num2 < num1+5){
                    
                    number2 = number2 + input.charAt(num2);
                    num2++;
                }
                // System.out.println(number1);
                // System.out.println(number2);

                try {
                    int toAdd = 0;
                    int left = Integer.parseInt(number1);
                    int right = Integer.parseInt(number2);
                    toAdd = multiply(left, right);
                    result = result + toAdd;

                } catch (Exception e){
                    continue;
                }

            }
        }
        }


        System.out.println(result);
        sc.close();
    }

    public static int multiply(int x, int y){
        return x * y;
    }
}
