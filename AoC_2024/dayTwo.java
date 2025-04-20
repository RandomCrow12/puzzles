import java.util.Scanner;

public class dayTwo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int res = 0;

        String goofy = "start";        
        while (!goofy.equals("a")) {
            boolean done = false;

            goofy = sc.nextLine();
            if (goofy.equals("a")) break;

            String[] a = goofy.split(" ");
            int[] b = new int[a.length];
            for (int i = 0; i < b.length; i++) {
                b[i] = Integer.parseInt(a[i]);
            }

            String ruleA = "";
            for (int i = 0; i < b.length - 1; i++) {
                if (i == 0) {
                    if (b[i] > b[i + 1]) ruleA = "dec";
                    else ruleA = "inc";
                }

                if ((ruleA.equals("inc") && b[i] > b[i + 1]) || 
                    (ruleA.equals("dec") && b[i] < b[i + 1]) || 
                    (b[i] == b[i + 1]) || 
                    (b[i + 1] > b[i] + 3 || b[i + 1] < b[i] - 3)) {
                    break;
                }

                if (i == b.length - 2) { 
                    res++; 
                    done = true; 
                }
            } 
            
            if (!done) {
                for (int k = 0; k < b.length; k++) {
                    boolean good = true;

                    int[] c = new int[b.length - 1];
                    int on = 0;
                    for (int j = 0; j < b.length; j++) {
                        if (k != j) { 
                            c[on] = b[j];
                            on++;
                        }
                    }

                    String rule = "";
                    for (int i = 0; i < c.length - 1; i++) {
                        if (i == 0) {
                            if (c[i] > c[i + 1]) rule = "dec";
                            else rule = "inc";
                        }

                        if ((rule.equals("inc") && c[i] > c[i + 1]) || 
                            (rule.equals("dec") && c[i] < c[i + 1]) || 
                            (c[i] == c[i + 1]) || 
                            (c[i + 1] > c[i] + 3 || c[i + 1] < c[i] - 3)) {
                            good = false;
                            break;
                        }
                    }

                    if (good) {
                        res++;
                        break;
                    }
                }
            }
        }

        System.out.println(res);
        sc.close();
    }
    // In the future, PLEASE use OOP & good variable names
    // like good should be isValid & there should be a method to check that
    // also make a method for removing a specific index of an array for example

    // probably go back and find optimal solutions to your problems for class or outside to learn how to do things optimally, so that you can first try in the future.
}
