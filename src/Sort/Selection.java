package Sort;

/**
 * Created by Wee on 2015/2/16.
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
                exch(a, i, min);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            System.out.println();
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
            return true;

    }

    public static Double[] RandomArray(int arrayLength, int maxNum){
        //数组长度和最大随机数以参数形式传入
        Double[] array = new Double[arrayLength];
        for(int i=0;i<array.length;i++){
            array[i] = (Math.random()*maxNum);
        }
        return  array;
    }

    public static void main(String[] args){
        Double[] b = RandomArray(5,100);
        show(b);
        System.out.println("------------------------------------");

      //  Double[] b = {Double.valueOf(1),Double.valueOf(7),Double.valueOf(5),Double.valueOf(2)};
        sort(b);
        assert isSorted(b);
        show(b);

    }
}
