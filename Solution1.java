class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int[] prefix=new int[n];
        prefix[0]=(isVowel(words[0].charAt(0)) && isVowel(words[0].charAt(words[0].length()-1)))?1:0;
        int i;
        for(i=1;i<n;i++)
        {
            String s=words[i];
            prefix[i]=(isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1)))?1:0;
            prefix[i]+=prefix[i-1];
        }
        int[] res=new int[queries.length];
        for(i=0;i<queries.length;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];
            if(l==0)
                res[i]=prefix[r];
            else
                res[i]=prefix[r]-prefix[l-1];
        }
        return res;
    }
    public boolean isVowel(char c)
    {
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}