import java.util.*;
public class daySeven {

    public static ArrayList<String> lines = new ArrayList<>();
    public static ArrayList<Long> nums = new ArrayList<>();
   
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String input = "";
        long res = 0;
        long res2 = 0;
        

        while (!input.equals("END")){
            input = sc.nextLine();
            if (!input.equals("END")) lines.add(input);
        }

        for (int i = 0; i < lines.size(); i++){
           nums.clear();
           String[] sp = lines.get(i).split(" ");

           for (int j = 0; j < sp.length; j++){
               if (j != 0) nums.add(Long.parseLong(sp[j]));
               else nums.add(Long.parseLong(sp[j].substring(0,sp[j].length()-1)));
           }
           // now nums has all the numbers that I want to try * & + with
           long target = nums.get(0);
           nums.remove(0);

           // now finally we have our numbers
           // nums.size() - 1 is how many operations are done

           
       
        boolean[] ops = new boolean[nums.size()-1];
        for (int g = 0; g < nums.size()-1; g++){
                ops[g] = false;
        }
        
        ArrayList<boolean[]> perms = genPerm(ops);
        
        for (int f = 0; f < perms.size(); f++){
            long tester = nums.get(0);

            for (int t = 0; t < ops.length; t++){
                if(perms.get(f)[t] == false) tester = tester + nums.get(t+1);
                else tester = tester * nums.get(t+1);
            }
        
            if (tester == target) {
                res = res + target;
                break;
            };
        }


        }


        // with 3 options
        for (int i = 0; i < lines.size(); i++){
            nums.clear();
            String[] sp = lines.get(i).split(" ");
 
            for (int j = 0; j < sp.length; j++){
                if (j != 0) nums.add(Long.parseLong(sp[j]));
                else nums.add(Long.parseLong(sp[j].substring(0,sp[j].length()-1)));
            }
        
            long target = nums.get(0);
            nums.remove(0);

 
         int[] ops = new int[nums.size()-1];
         for (int g = 0; g < nums.size()-1; g++){
                 ops[g] = 0;
         }
         
         ArrayList<int[]> perms = genPerm3(ops);
         
         for (int f = 0; f < perms.size(); f++){
             long tester = nums.get(0);
 
             for (int t = 0; t < ops.length; t++){
                 if(perms.get(f)[t] == 0) tester = tester + nums.get(t+1);
                 else if (perms.get(f)[t] == 1) tester = tester * nums.get(t+1);
                 else tester = concat(tester, nums.get(t+1));
             }
         
             if (tester == target) {
                 res2 = res2 + target;
                 break;
             };
         }
 
 
         }


        System.out.println(res); 
        System.out.println(res2); 
        sc.close();
    }

    public static ArrayList<boolean[]> genPerm(boolean[] arr) {
        ArrayList<boolean[]> result = new ArrayList<>();
        genPermHelper(arr, 0, result);
        return result;
    }

    private static void genPermHelper(boolean[] arr, int index, ArrayList<boolean[]> result) {
        if (index == arr.length) {
            result.add(Arrays.copyOf(arr, arr.length));
            return;
        }

        // Try both true and false values at the current index
        arr[index] = true;
        genPermHelper(arr, index + 1, result);

        arr[index] = false;
        genPermHelper(arr, index + 1, result);
    }


    public static ArrayList<int[]> genPerm3(int[] arr) {
        ArrayList<int[]> result3 = new ArrayList<>();
        genPermHelper3(arr, 0, result3);
        return result3;
    }

    private static void genPermHelper3(int[] arr, int index, ArrayList<int[]> result3) {
        if (index == arr.length) {
            result3.add(Arrays.copyOf(arr, arr.length));
            return;
        }

        // Try 0,1,2 values at the current index
        arr[index] = 0;
        genPermHelper3(arr, index + 1, result3);

        arr[index] = 1;
        genPermHelper3(arr, index + 1, result3);

        arr[index] = 2;
        genPermHelper3(arr, index + 1, result3);
    }

    public static Long concat(long a, long b){
        String v1 = ""+a;
        String v2 = ""+b;

        String v3 = v1+v2;

        long v4 = Long.parseLong(v3);
        return v4;
    }

}

/**
 *  Basically this is how you find all permutations recursively :3 
 * 
 * import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooleanArrayPermutations {

    public static List<boolean[]> generatePermutations(boolean[] arr) {
        List<boolean[]> result = new ArrayList<>();
        generatePermutationsHelper(arr, 0, result);
        return result;
    }

    private static void generatePermutationsHelper(boolean[] arr, int index, List<boolean[]> result) {
        if (index == arr.length) {
            result.add(Arrays.copyOf(arr, arr.length));
            return;
        }

        // Try both true and false values at the current index
        arr[index] = true;
        generatePermutationsHelper(arr, index + 1, result);

        arr[index] = false;
        generatePermutationsHelper(arr, index + 1, result);
    }

    public static void main(String[] args) {
        boolean[] arr = {true, false};
        List<boolean[]> permutations = generatePermutations(arr);

        for (boolean[] permutation : permutations) {
            System.out.println(Arrays.toString(permutation));
        }
    }
}
 * 
 */