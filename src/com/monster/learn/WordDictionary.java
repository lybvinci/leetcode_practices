package com.monster.learn;

//87.46%
class WordDictionary {

    TrieNode root = null;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int j = c - 'a';
            if(node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String word, TrieNode node, int index) {
        //若到达word末尾，判断字典树当前节点是否有对应字符串
        if(index == word.length()) return node.isWord;
        if(word.charAt(index) == '.') {
            //回溯该节点所有分支
            for(TrieNode temp : node.children) {
                if(temp != null && find(word, temp, index+1)) return true;
            }
            return false;
        }else{
            int j = word.charAt(index) - 'a';
            TrieNode temp = node.children[j];
            return temp != null && find(word, temp, index+1);
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
    
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}