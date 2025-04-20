import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class dayOne{
    public static void main(String[] args) {
     
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int add = sc.nextInt();
        int first = 1;

        while(add > 1){
            if (first == 1){
                a.add(add);
                b.add(sc.nextInt());

                first = 0;
            } else {
                add = sc.nextInt();
                a.add(add);
                b.add(sc.nextInt());
            }
        }
        
            int[] a2 = new int[a.size()];
        for (int i = 0; i < a.size(); i++){
            a2[i] = a.get(i);
        }

        int[] b2 = new int[b.size()];
        for (int i = 0; i < b.size(); i++){
            b2[i] = b.get(i);
        }


        Arrays.sort(a2);
        Arrays.sort(b2);


        int res = 0;
        // for (int i = 0; i < a2.length; i++){
        //     int dif = Math.abs(a2[i] - b2[i]);
        //     res = res + dif;
        // }


        for (int i = 0; i < a2.length; i++){
            int sim = 0;
            for (int j = 0; j < b2.length; j++){
                if (a2[i] == b2[j]){
                    sim++;
                }
            }
            sim = sim * a2[i];
            res = res + sim;
        }

        System.out.println(res);
        sc.close();
    }

    // both of these only work when you add 1 1 at the end of the input
    // on the second solution, make sure you subtract 1 at the end
}