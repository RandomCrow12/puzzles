import java.util.*;

public class doubleit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        for (int x = 0; x < tc; x++) {

            int total = 0;
            int num = Integer.parseInt(sc.nextLine());


            String eee = sc.nextLine();
            String[] all = new String[num];

            for (int i = 0; i < eee.length(); i++) {
                all[i] = "" + eee.charAt(i);
            }

            int val = 1;
            for (String s : all){
                if (s.equals("T")) {
                    total = total + val;
                    val = 1;
                } else {
                    val = val * 2;
                }
            }

            System.out.println(total);
        }


    }
}
