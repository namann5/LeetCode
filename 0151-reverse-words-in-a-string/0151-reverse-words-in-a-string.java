class Solution {
    public String reverseWords(String s) {
         //trim
         // l , r, s
         //stringBuilder --> cleaned with multiple spaces to a single place
         //reverse sb
         //reverse word by word

         int left =0;
         int right = s.length()-1;

         while(left < s.length()){
            if(s.charAt(left) == ' '){
                left++;
            }else {
                break;
            }

         }

         while(right >= 0){
            if(s.charAt(right)== ' '){
                right--;
            }else {
                break;
            }
         }

         StringBuilder sb = new StringBuilder();
          while(left <= right){
            if(s.charAt(left) != ' '){
                sb.append(s.charAt(left));
                left++;
            }else {
                 if (sb.charAt(sb.length() - 1) != ' ') {
                 sb.append(' ');
             }
               left++;
            }
          }

          int i =0;
          int j = sb.length() -1;

          while(i < j){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j,temp);
            i++;
            j--;
          }

          //sb --> oleeh eht
          //word by word reverse now

          int start =0;
          int end =0;

          while(start < sb.length()){
            while(end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            int p1 = start;
            int p2 = end -1;
             while(p1 < p2){
            char temp = sb.charAt(p1);
            sb.setCharAt(p1, sb.charAt(p2));
            sb.setCharAt(p2,temp);
            p1++;
            p2--;
          }

          start = end +1;
          end = start;
          }

          return sb.toString();

    }
}