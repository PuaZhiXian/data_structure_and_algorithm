import java.util.Arrays;

public class SuffixArray {

    public static void main(String[] args) {
        String t = "banana";
        String[] s = {"ana"};
        System.out.println(Arrays.toString(new SuffixArray().binarySearchSuffixArray(t, s)));
    }

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

    public boolean[] binarySearchSuffixArray(String t, String[] s) {
        //create suffix array
        int[] suffixArray = new SuffixArray().suffixArray(t);
        boolean[] result = new boolean[s.length];

        //iterate through all query (s)
        for (int j = 0; j < s.length; j++) {
            String query = s[j];

            //init new & old LCP
            int LCP = 0, oldLCP = 0;
            //set left & right of binary search
            int left = 0, right = suffixArray.length - 1;
            while (left <= right) {
                //init middle
                int middle = left + (right - left) / 2;
                String pivot = t.substring(suffixArray[middle]);
                //store total of same char
                int sameCount = Math.min(LCP, oldLCP);
                //iterate through query
                for (int i = Math.min(LCP, oldLCP); i < query.length(); i++) {
                    if (i > pivot.length() - 1) {
                        //Case 3: pivot length is smaller than query
                        //and all char from pivot match with query
                        left = middle + 1;
                        oldLCP = LCP;
                        LCP = sameCount;
                        sameCount = 0;
                        break;
                    }
                    //Find different between char
                    int charDiff = pivot.charAt(i) - query.charAt(i);
                    if (charDiff < 0) {
                        //Case 1: pivot is smaller than query
                        left = middle + 1;
                        oldLCP = LCP;
                        LCP = sameCount;
                        sameCount = 0;
                        break;
                    } else if (charDiff > 0) {
                        //Case 2: pivot is bigger than query
                        right = middle - 1;
                        oldLCP = LCP;
                        LCP = sameCount;
                        sameCount = 0;
                        break;
                    }
                    sameCount++;
                }
                //Case 4 : A prefix of query is found in pivot
                if (sameCount == query.length()) {
                    result[j] = true;
                    break;
                }
            }
        }

        return result;
    }

}
