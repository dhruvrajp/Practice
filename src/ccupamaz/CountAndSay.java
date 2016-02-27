package ccupamaz;

public class CountAndSay {
    public String countAndSay(int n) {
        String s="1";
        if(n==1){
            return s;
        }
        int i=1;
        while(i<n){
            StringBuilder sb=new StringBuilder();
            int count=1;
            for(int j=1;j<s.length();j++){
                if(s.charAt(j)==s.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(s.charAt(j-1));
                    count=1;
                }
            }
            sb.append(count);
            sb.append(s.charAt(s.length()-1));
            i++;
            s=sb.toString();
        }
        return s;
    }
}
