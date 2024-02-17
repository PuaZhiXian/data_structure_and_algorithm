public class ManacheraAlgorithm {

    public int[] palindromicLengthArray(String text) {
        //Add special char to s
        String s = "";
        int[] result = new int[text.length() * 2 + 1];
        for (int i = 0; i < text.length(); i++) {
            s = s + "." + text.charAt(i);
        }
        s = s + '.';

        int d = 1;
        int cnt = 0;
        for (int i = 1; i < s.length() - 1; i = i) {
            if (result[i] > 0) {
                continue;
            }
            while (i - d >= 0 && i + d < s.length() && s.charAt(i - d) == s.charAt(i + d)) {
                cnt++;
                d++;
            }
            result[i] = cnt;
            if (cnt != 0) {
                int r = i + cnt;
                int move = 1;
                while (i + move <= r) {
                    int cloneTargetIndex = i + move;
                    int cloneSourceIndex = i - move;
                    if (result[cloneSourceIndex] < r - cloneTargetIndex) {
                        result[cloneTargetIndex] = result[cloneSourceIndex];
                    } else {
                        d = r - cloneTargetIndex + 1;
                        cnt = d - 1;
                        i = cloneTargetIndex;
                        break;
                    }
                    move++;
                }
            } else {
                d = 1;
                cnt = 0;
                i++;
            }
        }
        return result;
    }

    public String getLongestPalindromic(String text) {
        //get palindromic length array
        int[] arr = new ManacheraAlgorithm().palindromicLengthArray(text);
        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxLength < arr[i]) {
                maxLength = arr[i];
                maxIndex = i;
            }
        }

        String s = "";
        for (int i = 0; i < text.length(); i++) {
            s = s + "." + text.charAt(i);
        }
        s = s + '.';

        String result = s.substring(maxIndex - maxLength, maxIndex + maxLength + 1);
        return result.replace(".", "");
    }

    public int getPalindromicCount(String text) {
        int[] arr = new ManacheraAlgorithm().palindromicLengthArray(text);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ;
                result += Math.ceil(arr[i] / 2.0);
            }
        }
        return result;
    }

}
