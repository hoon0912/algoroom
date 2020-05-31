class Solution{
        public int solution(String arrangement) {
            int answer = 0;
            int pipe = 0;
            for(int i = 0, len =arrangement.length(); i< len; i++){
                if(arrangement.charAt(i)=='('){ pipe++; }
                else if(arrangement.charAt(i) == ')'){//´ÝÈû
                    pipe--;
                    answer += (arrangement.charAt(i-1) == '(' ? pipe : 1);
                }
            }
            return answer;
        }
    }