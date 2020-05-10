import java.util.LinkedHashMap;
class Solution {
    public boolean solution(String[] phone_book) {
        Trie trie = new Trie();
        boolean answer = true;
        for(int i = 0, len = phone_book.length; answer && i<len; i++)
            answer = answer && trie.insert(phone_book[i]);
        return answer;
    }
}

class Trie{
    private TrieNode root = new TrieNode((char)0);

    boolean insert(String word){
        TrieNode current = root;
        boolean hasPrefix = false;

        char[] children = word.toCharArray();
        for(int index = 0, wordLen = word.length(); !hasPrefix && index < wordLen; index++){
            char child = children[index];

            if(current.hasChild(child)){
                current = current.getChild(child);
                hasPrefix = (current.isLastNode && index <= wordLen-1);
            }else{
                TrieNode newChild = new TrieNode(child);
                current = current.addChild(newChild);
            }
        }

        if(!current.isLastNode && current.hasAnyChild()) return false;//뒤에 Prefix 가 오는 경우
        current.isLastNode = true;
        return !hasPrefix;
    }
}

class TrieNode {
    char _char;
    boolean isLastNode = false;
    LinkedHashMap<Character, TrieNode> children = new LinkedHashMap<>();

    TrieNode(char _char){ this._char = _char;}

    TrieNode addChild(TrieNode child){
        children.put(child._char, child);
        return child;
    }

    boolean hasChild(char childChar){ return children.containsKey(childChar);}
    boolean hasAnyChild(){return !children.isEmpty();}
    TrieNode getChild(char childChar){ return children.get(childChar);}

}