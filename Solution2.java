class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        System.out.println(s);
        int i=0,j=s.length()-1;
        while(i<j)
        {
            char a=s.charAt(i);
            char b=s.charAt(j);
            if(isChar(a) && isChar(b))
            {
                if(a!=b)
                    return false;
                i++;
                j--;
            }
            else if(isChar(a))
                j--;
            else
                i++;
        }
        return true;
    }
    public boolean isChar(char c)
    {
        return (c>='a' && c<='z')||(c>='0' && c<='9');
    }
}