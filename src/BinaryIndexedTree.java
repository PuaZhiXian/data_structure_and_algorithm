public class BinaryIndexedTree {

    int[] tree;
    int n;

    public BinaryIndexedTree(int[] arr) {
        n = arr.length;
        tree = new int[n];
        for (int i = 1; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    public void update(int index, int value) {
        for (; index <= n; index += index & -index) {
            tree[index] += value;
        }
    }

    public int getSum(int index) {
        int sum = 0;
        for (; index > 0; index -= index & -index)
            sum += tree[index];
        return sum;
    }

}
