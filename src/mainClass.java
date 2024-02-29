import java.util.Arrays;

public class mainClass {

    public static void main(String[] args) {
//        mainClass.trieTestCase();
//        mainClass.sortingTestCase();
//        mainClass.suffixArrayTestCase();
//        mainClass.manacheraAlgoTestCase();
        mainClass.binaryIndexedTreeTestCase();
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

    public static void suffixArrayTestCase() {
        System.out.println(Arrays.toString(new SuffixArray().suffixArray("abaab"))); //expected --> {2,3,0,4,1}
        System.out.println(Arrays.toString(new SuffixArray().suffixArray("banana"))); //expected --> {5, 3, 1, 0, 4, 2}
    }

    public static void manacheraAlgoTestCase() {
        ManacheraAlgorithm obj = new ManacheraAlgorithm();
        String s1 = "abababa";
        String s2 = "acncacn";
        String s3 = "abaxabaxabb";
        String s4 = "abb";
        String s5 = "abc";
        String s6 = "aaa";
        System.out.printf("longest palindromic in text {%s} --> {%s}\n", s1, obj.getLongestPalindromic(s1));//abababa
        System.out.printf("longest palindromic in text {%s} --> {%s}\n", s2, obj.getLongestPalindromic(s2));//acnca
        System.out.printf("longest palindromic in text {%s} --> {%s}\n", s3, obj.getLongestPalindromic(s3));//baxabaxab
        System.out.printf("longest palindromic in text {%s} --> {%s}\n", s4, obj.getLongestPalindromic(s4));//aaa

        System.out.printf("number of palindromic in text {%s} --> {%d}\n", s4, obj.getPalindromicCount(s4));//4
        System.out.printf("number of palindromic in text {%s} --> {%d}\n", s5, obj.getPalindromicCount(s5));//3
        System.out.printf("number of palindromic in text {%s} --> {%d}\n", s6, obj.getPalindromicCount(s6));//6
    }

    public static void binaryIndexedTreeTestCase(){
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        BinaryIndexedTree bTree = new BinaryIndexedTree(arr1);
        System.out.printf("Sum of first {%d}  element --> %d\n",4,bTree.getSum(3));
        System.out.printf("Sum of first {%d}  element --> %d\n",6,bTree.getSum(5));
        System.out.printf("Sum of first {%d}  element --> %d\n",15,bTree.getSum(14));
    }
}
