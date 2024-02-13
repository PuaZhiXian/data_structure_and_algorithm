import java.util.Arrays;

public class SuffixArray {
    static final int N = 128;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SuffixArray().suffixArray("abaab"))); //expected --> {2,3,0,4,1}
        System.out.println(Arrays.toString(new SuffixArray().suffixArray("banana"))); //expected --> {5, 3, 1, 0, 4, 2}
    }

    public int[] suffixArray(String text) {
        int n = text.length();
        int[] rk = new int[n];
        int[] sa = new int[n];

        // init rk
        for (int i = 0; i < n; i++) {
            rk[i] = text.charAt(i) - 'a' + 1;
        }
        int k = 1;
        while (true) {
            int[][] pairArr = new int[n][3];
            for (int i = 0; i < n; i++) {
                //index
                pairArr[i][2] = i;
                //first key
                pairArr[i][0] = rk[i];
                //second Key
                if (i + k < n) {
                    pairArr[i][1] = rk[i + k];
                }
            }
            //second key counting sort
            int[] countArray = new int[27];
            int[][] outputArray = new int[pairArr.length][3];

            for (int j = 0; j < pairArr.length; j++) {
                countArray[pairArr[j][1]]++;
            }
            for (int j = 0; j < countArray.length - 1; j++) {
                countArray[j + 1] += countArray[j];
            }
            for (int j = pairArr.length - 1; j >= 0; j--) {
                countArray[pairArr[j][1]]--;
                outputArray[countArray[pairArr[j][1]]] = pairArr[j];
            }
            pairArr = outputArray;

            //first key counting sort
            countArray = new int[27];
            outputArray = new int[pairArr.length][3];

            for (int j = 0; j < pairArr.length; j++) {
                countArray[pairArr[j][0]]++;
            }
            for (int j = 0; j < countArray.length - 1; j++) {
                countArray[j + 1] += countArray[j];
            }
            for (int j = pairArr.length - 1; j >= 0; j--) {
                countArray[pairArr[j][0]]--;
                outputArray[countArray[pairArr[j][0]]] = pairArr[j];
            }
            pairArr = outputArray;
            int rank = 1;
            for (int i = 0; i < pairArr.length; i++) {
                sa[pairArr[i][2]] = rank;
                rk[pairArr[i][2]] = rank;
                if (i + 1 < pairArr.length && pairArr[i][0] == pairArr[i + 1][0] && pairArr[i][1] == pairArr[i + 1][1]) {
                    continue;
                }
                rank++;
            }

            if (rank == n + 1) {
                int[] result = new int[n];
                for (int i = 0; i < pairArr.length; i++) {
                    result[i] = pairArr[i][2];
                }
                return result;
            }
            k++;
        }
    }

}
