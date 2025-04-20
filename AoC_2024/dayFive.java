import java.util.*;

public class dayFive {
 
        public static ArrayList<int[]> badOrd = new ArrayList<>();
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<int[]> orders = new ArrayList<>();
        

        String input = "";
        int res = 0;
        int res2 = 0;
        

        while (!input.equals("ENDOFINPUT")){
            input = sc.nextLine();
            if (!input.equals("ENDOFINPUT")) lines.add(input);
        }

            int i = 0;
            while (!lines.get(i).trim().equals("")){
                rules.add(lines.get(i));
                i++;
            }
            
            i++;

            for (int k = i; k < lines.size(); k++){
                String[] a = lines.get(k).split(",");
                int[] b = new int[a.length];
                    for (int h = 0; h < a.length; h++){
                        b[h] = Integer.parseInt(a[h]);
                    }
                orders.add(b);
            }

            for (int z = 0; z < orders.size(); z++){
                if (valid(orders.get(z), rules)) res = res + findMid(orders.get(z));
            }


            for (int v = 0; v < badOrd.size(); v++){
                //System.out.println(badOrd.size());
                res2 = res2 + findMid(findGood(badOrd.get(v), rules));
            }


        System.out.println(res);
        System.out.println(res2);
        sc.close();
    }


    public static int findMid(int[] input){
        int a = (input.length/2);
        // [1, 2, 3, 4, 5]

        return input[a];
    }

    public static boolean valid(int[] input, ArrayList<String> rules){
        
        for (int i = 0; i < rules.size(); i++){
            int before = -1;
            int after = -1;

            String[] ba = rules.get(i).split("\\|");
            int[] nums = new int[2];
            nums[0] = Integer.parseInt(ba[0]);
            nums[1] = Integer.parseInt(ba[1]);

            for (int x = 0; x < input.length; x++){
                if (input[x] == nums[0]) before = x;
                if (input[x] == nums[1]) after = x;
            }

            if (before == -1 || after == -1) continue;

            if (before > after) {
                badOrd.add(input);
                return false;
            }

        }
        
        return true;
    }

    public static int[] findGood(int[] input, ArrayList<String> rules){

        while (!valid2(input, rules)){ // while the input doesn't follow the rules, apply the rules
        for (int i = 0; i < rules.size(); i++){
            int before = -1;
            int after = -1;

            String[] ba = rules.get(i).split("\\|");
            int[] nums = new int[2];
            nums[0] = Integer.parseInt(ba[0]);
            nums[1] = Integer.parseInt(ba[1]);

            for (int x = 0; x < input.length; x++){
                if (input[x] == nums[0]) before = x;
                if (input[x] == nums[1]) after = x;
            }
            if (before == -1 || after == -1) continue;
            ArrayList<String> cur = new ArrayList<>();
            cur.add(rules.get(i));
            if (!valid2(input, cur)) {
            
            ArrayList<Integer> a = new ArrayList<>();
            for (int k = 0; k < input.length; k++){
                a.add(input[k]);
            }

            a.add(after, a.get(before));
            
             if (before < after) {
                a.remove(before);
            } else {
                a.remove(before + 1);
            }


            for (int k = 0; k < input.length; k++){
                input[k] = a.get(k);
            }
            }
        }
    }
        //System.out.println(Arrays.toString(input));
        return input;
    }

    public static boolean valid2(int[] input, ArrayList<String> rules){
        
        for (int i = 0; i < rules.size(); i++){
            int before = -1; // note: these are INDEXES of before and after
            int after = -1;

            String[] ba = rules.get(i).split("\\|"); 
            int[] nums = new int[2];
            nums[0] = Integer.parseInt(ba[0]);
            nums[1] = Integer.parseInt(ba[1]);

            for (int x = 0; x < input.length; x++){
                if (input[x] == nums[0]) before = x;
                if (input[x] == nums[1]) after = x;
            }

            if (before == -1 || after == -1) continue;

            if (before > after) {
                //badOrd.add(input);
                return false;
            }

        }
        
        return true;
    }
}

// Note to self: learn sets & maps