class Pair {
    String first;
    int second;
    public Pair(String first,int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.get(wordList.size() - 1).equals(endWord));
        
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(beginWord,1));
        int n = wordList.size();
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(wordList.get(i));
        }

        while(!qu.isEmpty()) {
            String word = qu.peek().first;
            int steps = qu.peek().second;
            qu.poll();
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++) {
                for(char ch='a';ch<='z';ch++) {
                    char[] replacechar = word.toCharArray();
                    replacechar[i] = ch;
                    String replaceWord = new String(replacechar);
                    if(set.contains(replaceWord)) {
                        set.remove(replaceWord);
                        qu.offer(new Pair(replaceWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}