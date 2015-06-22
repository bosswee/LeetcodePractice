import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/2/1.
 * 字符串操作。把一个英语句子中单词的次序颠倒后输出。
 * 例如程序的输入是“how are you”，则返回“you are how”。
 */

public class StringTest {
    public static void main(String[] args) {
        String start = "a b c d e f g";
        String[] tmp = start.split(" ");
        StringBuilder end = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            end.append(tmp[i] + " ");
        }
        System.out.println(end);
    }
}
