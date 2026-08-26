class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String[] letters = {
            "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        backtrack(list,new StringBuilder(),digits,0,letters);
        return list;
    }
    private void backtrack(List<String>list,StringBuilder current,String digits,int index,String[] letters){
        if(index == digits.length()) {
            list.add(current.toString());
            return;
        }
        int dig = digits.charAt(index)-'0';
        String posletter = letters[dig-2];
        for(int i =0;i<posletter.length();i++) {
            current.append(posletter.charAt(i));
            backtrack(list,current,digits,index+1,letters);
            current.deleteCharAt(current.length()-1);
        }
    }
}