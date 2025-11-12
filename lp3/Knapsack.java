import java.util.*;

class Items{
    double val = 0 ;
    double weight = 0;
    double ratio = 0 ;

    Items(double val,double weight){
        this.val = val;
        this.weight = weight;
        this.ratio = val/weight;
    }
}

class Knapsack{

    static double getMax(Items [] item,double capacity){
        Arrays.sort(item,(a,b)->Double.compare(b.ratio,a.ratio));

        double totalVal = 0;
        for(Items i : item){
            if(capacity >= i.weight){
                capacity -= i.weight;
                totalVal += i.val;
            }else{
                totalVal += i.ratio * capacity;
                break;
            }

        }
        return totalVal;

    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter num of terms");
        int n = sc.nextInt();

        Items item[] = new Items[n];
        for(int i = 0 ;i<n ; i++){
            System.out.println("Enter val");
            int val = sc.nextInt();
            System.out.println("Enter weight");
            int weight = sc.nextInt();
            item[i] = new Items(val,weight);
        }

        System.out.println("Enter Knapsack capacity : ");
        double capacity = sc.nextDouble();

        double getMax = getMax(item,capacity);
        System.out.println("\nMaximum value in Knapsack = " + getMax);
    }

}

