public class SuffixArray {
    public int[] suffixArray(String text) {
        int n = text.length();
        int[] rk = new int[n]; // store ranking of each suffix
        int[] sa = new int[n]; // sort suffix based on their ranking.
        // sa[0] = 4 indicate suffix start from text.chartAt(4) have the lowest ranking

        // init rk
        for (int i = 0; i < n; i++) {
            rk[i] = text.charAt(i) - 'a' + 1;
        }
        int k = 1;
        while (true) {
            int[][] pairArr = new int[n][3];
            for (int i = 0; i < n; i++) {
                //store this pair is origin from which index of text
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

            //Ranking the pair
            int rank = 1;
            for (int i = 0; i < pairArr.length; i++) {
                sa[i] = pairArr[i][2];
                rk[sa[i]] = rank;
                if (i + 1 < pairArr.length && pairArr[i][0] == pairArr[i + 1][0] && pairArr[i][1] == pairArr[i + 1][1]) {
                    continue;
                }
                rank++;
            }
            //There is not have same ranking elements
            if (rank == n + 1) {
                return sa;
            }
            k++;
        }
    }

}
