import java.util.Arrays;

public class mainClass {

    public static void main(String[] args) {
        mainClass.trieTestCase();
        mainClass.sortingTestCase();
    }

    public static void trieTestCase() {
        System.out.println("\nTrie Test Case --------------");
        TrieNode trie = new TrieNode();
        //Test Case
        //Insert word to trie
        System.out.println("insert word 'and' to Trie");
        System.out.println("insert word 'ant' to Trie");
        System.out.println("insert word 'andrew' to Trie");
        System.out.println("insert word 'border' to Trie");
        trie.insert("and");
        trie.insert("ant");
        trie.insert("andrew");
        trie.insert("border");

        //search complete word
        System.out.println("\nword 'and' is present in Trie " + trie.search("and"));
        System.out.println("word 'ants' is present in Trie " + trie.search("ants"));
        System.out.println("word 'border' is present in Trie " + trie.search("border"));
        //search prefix
        System.out.println("\nprefix 'an' is present in Trie " + trie.isPrefixExist("an"));
        System.out.println("prefix 'cat' is present in Trie " + trie.isPrefixExist("car"));
        System.out.println("prefix 'dr' is present in Trie " + trie.isPrefixExist("dr"));

        //delete word
        System.out.println("\ndelete word 'and' from Trie " + trie.deleteKey("and"));
        System.out.println("delete word 'an' from Trie " + trie.deleteKey("an"));
        System.out.println("delete word 'angle' from Trie " + trie.deleteKey("angle"));

        //Check delete status
        System.out.println("word 'and' is present in Trie " + trie.search("and"));
    }

    public static void sortingTestCase() {
        System.out.println("\nSorting Test Case --------------");
        Sorting obj = new Sorting();

        //radix sorting
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println(Arrays.toString(obj.radixSort(arr)));

        //counting sort
        int[] singleNumberArr = {2, 5, 3, 0, 2, 3, 0, 3, 90};
        System.out.println(Arrays.toString(obj.countingSort(singleNumberArr)));
    }

}
