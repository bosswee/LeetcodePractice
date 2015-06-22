package String;

/**
 * Created by Wee on 2015/5/7.
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character

 错误思路：误以为是求最大公共子串
 标准Dynamic Programming。思路如下：

 两个String看成两个char数组，分别是x[m]以及y[n]。对于x[1]...x[i]和y[1]...y[j]的edit distance为A[i][j]。那么有如下recursion:

 A[i][j]=A[i-1][j-1] if x[i] = y[j];

 A[i][j]=min(A[i-1][j], A[i][j-1], A[i-1][j-1])+1 if x[i] != y[j]

 其中第二种x[i]!=y[j]的min中的三个元素分别代表insert, delete和replace三种情况，要看哪种最小。

 Base case是A[0][j]=j, A[i][0] = i。
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        //Todo 二维DP的问题先留到最后研究，先知道什么情况下用二维DP,感觉思路差不多，找到递推式有点难度

            int m = word1.length();
            int n = word2.length();
            if (m == 0)
                return n;
            if (n == 0)
                return m;
            int A[][] = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++)
                A[i][0] = i;
            for (int j = 0; j <= n; j++)
                A[0][j] = j;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        A[i][j] = A[i - 1][j - 1];
                    } else {
                        A[i][j] = Math.min(A[i - 1][j], Math.min(A[i][j - 1], A[i - 1][j - 1])) + 1;
                    }
                }
            }
            return A[m][n];
        }
    }

