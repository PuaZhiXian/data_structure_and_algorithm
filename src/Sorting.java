import java.util.Arrays;

public class Sorting {


    public static int getMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    public int[] radixSort(int[] arr) {

        // Get the maximum number in arr
        int max = getMax(arr);

        //counting sort for each decimal place
        for (int i = 1; max / i > 0; i *= 10) {
           arr = radixSort_countingSort(arr, i);
        }


        return arr;
    }

    public static int[] radixSort_countingSort(int arr[], int decimalPlace) {
        int originalArrayLength = arr.length;
        int[] countArray = new int[10];
        int[] outputArray = new int[originalArrayLength];
        //count occurrences of elements
        for (int num : arr) {
            countArray[num % (decimalPlace * 10) / decimalPlace]++;
        }
        //cumulative sum
        for (int i = 0; i < 9; i++) {
            countArray[i + 1] += countArray[i];
        }

        for (int i = originalArrayLength - 1; i >= 0; i--) {
            countArray[arr[i] % (decimalPlace * 10) / decimalPlace]--;
            outputArray[countArray[arr[i] % (decimalPlace * 10) / decimalPlace]] = arr[i];
        }
        return outputArray;
    }

    public int[] countingSort(int arr[]) {
        int max = getMax(arr);
        int[] countArray = new int[max + 1];
        int[] outputArray = new int[arr.length];
        // count occurrences  of element
        for (int num : arr) {
            countArray[num]++;
        }
        //cumulative sum
        for (int i = 0; i < countArray.length - 1; i++) {
            countArray[i + 1] += countArray[i];
        }
        //rearrange array
        for (int i = arr.length - 1; i >= 0; i--) {
            countArray[arr[i]]--;
            outputArray[countArray[arr[i]]] = arr[i];
        }
        return outputArray;
    }


}
