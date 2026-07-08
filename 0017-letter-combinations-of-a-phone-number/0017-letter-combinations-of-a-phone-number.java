class Solution {
    public List<String> letterCombinations(String digits) {
        List <String> res = new ArrayList<>();
        int idx =0;
        int n= digits.length();

        StringBuilder dairy = new StringBuilder();

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(res,digits,n,idx,dairy,map);

        return res;

    }

    void backtrack(List <String> res ,String digits, int n, int idx, StringBuilder diary, HashMap <Character,String> map){
        if(idx == n){
            res.add(diary.toString());
            return;
        }

        String t = map.get(digits.charAt(idx));

        for(int i=0;i < t.length();i++){
            diary.append(t.charAt(i));
            backtrack(res,digits,n,idx+1,diary,map);
            diary.deleteCharAt(diary.length() - 1);
        }
    }
}