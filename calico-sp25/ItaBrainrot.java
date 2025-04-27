import java.util.*;
public class ItaBrainrot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        for (int x = 0; x < tc; x++) {


        ArrayList<String> names = new ArrayList<>();
        HashMap<String, Integer> powers = new HashMap<>();



            int num = Integer.parseInt(sc.nextLine());
            String[] name = sc.nextLine().split(" ");
            String[] pow = sc.nextLine().split(" ");

            for (int i = 0; i < num; i++) {
                powers.put(name[i], Integer.parseInt(pow[i]));
                names.add(name[i]);
            }


            while (names.size() > 1) {
                int t = 0;
                while (t+1 < names.size() && names.size() > 1) {

                    if (powers.get(names.get(t)) > powers.get(names.get(t + 1))) {
                        int before = powers.get(names.get(t));

                        powers.remove(names.get(t));
                        powers.put(names.get(t), before + powers.get(names.get(t + 1))); // new entry

                        names.remove(t + 1);
                    } else if (powers.get(names.get(t)) < powers.get(names.get(t + 1))) {
                        int before = powers.get(names.get(t + 1));

                        powers.remove(names.get(t + 1));
                        powers.put(names.get(t + 1), before + powers.get(names.get(t))); // new entry

                        names.remove(t);
                    } else {
                        powers.put(names.get(t) + names.get(t + 1), powers.get(names.get(t)) + powers.get(names.get(t + 1)));

                        names.set(t, names.get(t) + names.get(t + 1));
                        names.remove(t + 1);
                    }

                    t++; // works bc we will always be removing something
                }


            }

            // only one left
            System.out.println(names.get(0));
        }
    }

}