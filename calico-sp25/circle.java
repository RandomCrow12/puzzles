import java.util.*;

class Pair {
    protected Double[] d = new Double[2];

    public Pair(Double a, Double b){
        d[0] = a;
        d[1] = b;
    }
    public Double getX(){
        return d[0];
    }
    public Double getY(){
        return d[1];
    }
}

public class circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        for (int x = 0; x < tc; x++) {

            int num = Integer.parseInt(sc.nextLine());
            ArrayList<Pair> ds = new ArrayList<>();


            for (int i = 0; i < num; i++) {
                try {
                    String[] sp = sc.nextLine().split(" ");
//                System.out.println(i);
//                System.out.println(sp[0] + " " + sp[1]);
                    Double a = Double.parseDouble(sp[0]);
                    Double b = Double.parseDouble(sp[1]);

                    ds.add(new Pair(a, b));
                } catch (NumberFormatException e){

                }
            }

            Double area = 0.0;

            // can find slopes and corners???


            Double mL = Double.MAX_VALUE;
            Double mR = -Double.MAX_VALUE;
            Double mU = -Double.MAX_VALUE;
            Double mD = Double.MAX_VALUE;

            for (Pair dp : ds){
                if (dp.getX() < mL){
                    mL = dp.getX();
                }
                if (dp.getX() > mR){
                    mR = dp.getX();
                }
                if (dp.getY() < mD){
                    mD = dp.getY();
                }
                if (dp.getY() > mU){
                    mU = dp.getY();
                }
            }

            Double sideX = Math.abs (mR - mL);
            Double sideY = Math.abs(mU - mD);

            area = sideX * sideY;

            System.out.println(area);
        }
    }
}

