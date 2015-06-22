
/**
 * Created by Wee on 2015/3/4.
 */
public class Qsort {
    public static void main(String[] args) {
        int[] array = {1,3,4,5,643,43};
        qsort(array,array.length);
        System.out.print(array.toString());
    }

    private static void qsort(int[] array, int len) {
        int value,start,end;
        if(len<=1)
            return;
        value=array[0];
        start =0;
        end = len-1;
        while(start<end){
            for ( ; start<end;--end) {
                if(array[end]<value){
                    array[start++]=array[end];
                    break;
                }
            }
        for(;start<end;++start)
            if(array[start]>value)
            {
            array[end--]=array[start];
                break;
            }
        }
        array[start] =value;
        qsort(array,start);
        //qsort(array+start+1,len-start-1);
    }
}
