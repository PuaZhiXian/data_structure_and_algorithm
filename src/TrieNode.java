import java.util.Locale;

public class TrieNode {

    public TrieNode[] children;
    public boolean isEndWord;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public void insert(String key) {
        // Initialize the currentNode pointer with the root node
        TrieNode currentNode = this;
        key = key.toLowerCase(Locale.ROOT);

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            // Create new node if not exist in currentNode pointer
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }

            //Move to next children node
            currentNode = currentNode.children[index];
        }
        //Indicate the word end here
        currentNode.isEndWord = true;
    }

    public boolean isPrefixExist(String key) {
        //convert string to lowercase and init currentNode to root
        key = key.toLowerCase(Locale.ROOT);
        TrieNode currentNode = this;

        // Iterate across the length of the string
        for (char c : key.toCharArray()) {
            //Get childNode from currentNode
            TrieNode childNode = currentNode.children[c - 'a'];
            if (childNode == null) {
                return false;
            }
            //step forward to next childNode
            currentNode = childNode;
        }
        //Prefix exist in the Trie
        return true;
    }

    public boolean search(String key) {
        // Initialize the currentNode  with the root node
        key = key.toLowerCase(Locale.ROOT);
        TrieNode currentNode = this;

        // Iterate across the length of the string
        for (char c : key.toCharArray()) {
            //Get childNode from currentNode
            TrieNode childNode = currentNode.children[c - 'a'];
            if (childNode == null) {
                return false;
            }
            //step forward to next childNode
            currentNode = childNode;
        }

        return (currentNode.isEndWord);
    }

    public boolean deleteKey(String word) {
        TrieNode currentNode = this;
        TrieNode lastBranchNode = null;
        char lastBranchChar = 'a';
        //At the end will get currentNode as last character in word, and get last node which have multiple children
        for (char c : word.toCharArray()) {
            TrieNode childNode = currentNode.children[c - 'a'];
            if (childNode == null) {
                // The word is not present in Trie
                return false;
            } else {
                //Store lastBranchNode if found multiple children
                int count = 0;
                for (int i = 0; i < currentNode.children.length; i++) {
                    if (currentNode.children[i] != null) {
                        count++;
                    }
                    if (count > 1) {
                        lastBranchNode = currentNode;
                        lastBranchChar = c;
                        break;
                    }
                }
                currentNode = childNode;
            }
        }
        //Check whether last node have children or not
        int count = 0;
        for (int i = 0; i < currentNode.children.length; i++) {
            if (currentNode.children[i] != null) {
                count++;
            }
        }

        // Case 1: The deleted word is a prefix of other words in Trie.
        if (count > 0) {
            if (currentNode.isEndWord){
                currentNode.isEndWord =  false;
                return true;
            }else{
                return false;
            }
        }

        // Case 2: The deleted word shares a common prefix with other words in Trie.
        if (lastBranchNode != null) {
            // Remove the link to the deleted word
            lastBranchNode.children[lastBranchChar - 'a'] = null;
        } else {  // Case 3: The deleted word does not share any common prefix with other words in Trie.
            // Remove the link to the deleted word from the root
            this.children[word.charAt(0) - 'a'] = null;
        }
        return true;
    }
}
