# january2_2025
The work that is done on january 2, 2025

LeetCode Problem-Solving
Problem 1: Count Vowel Strings in Ranges 

Description:  
Given an array of strings, count the number of strings that start and end with a vowel in specified ranges.  

Key Techniques:  
- Use Prefix Sum to efficiently calculate the count for each query.  

Code (Java):  
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

Problem 2: Valid Palindrome

Description:  
Check if a string is a valid palindrome after ignoring case and non-alphanumeric characters.  

Key Techniques:  
- Use the Two Pointers technique to compare characters from both ends.  

Code (Java): 
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

Problem 3: Is Subsequence

Description:  
Determine if a string `s` is a subsequence of another string `t`.  

Key Techniques:  
- Use Two Pointers to traverse both strings simultaneously.  

Code (Java): 
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }
            else
                j++;
        }
        if(i==s.length())
            return true;
        return false;
    }
}

Problem 4: Two Sum II

Description:  
Find two numbers in a sorted array that add up to a target value.  

Key Techniques:  
- Use Two Pointers to adjust the sum until it matches the target.  

Code (Java):  
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j)
        {
            if(numbers[i]+numbers[j]==target)
                return new int[]{i+1,j+1};
            else if(numbers[i]+numbers[j]>target)
                j--;
            else
                i++;
        }
        return new int[0];
    }
}

Problem 5: Container With Most Water

Description:  
Find two lines that form a container to hold the maximum amount of water.  

Key Techniques:  
- Use Two Pointers to calculate the area while narrowing the range.  

Code (Java):  
class Solution {
    public int maxArea(int[] height) {
        int max=0,l=0,r=height.length-1;
        while(l<r)
        {
            int area=(r-l)*Math.min(height[l],height[r]);
            max=Math.max(max,area);
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return max;
    }
}

Problem 6: 3Sum

Description:  
Find unique triplets in an array whose sum equals zero.  

Key Techniques:  
- Sort the array and use Two Pointers for each element to find triplets.  

Code (Java):  
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        int i,j,k,n=nums.length;
        Arrays.sort(nums);
        for(k=0;k<=n-3;k++)
        {
            i=k+1;
            j=n-1;
            while(i<j)
            {
                if(nums[k]+nums[i]+nums[j]==0)
                {
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    i++;
                    j--;
                }
                else if(nums[k]+nums[i]+nums[j]>0)
                    j--;
                else
                    i++;
            }
        }
        return new ArrayList<>(res);
    }
}

Problem 7: Minimum Size Subarray Sum

Description:  
Find the smallest subarray with a sum greater than or equal to the target.  

Key Techniques:  
- Use the Sliding Window technique to adjust the range dynamically.  

Code (Java):  
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,min=Integer.MAX_VALUE,sum=0;
        while(r<nums.length)
        {
            sum+=nums[r];
            while(sum>=target)
            {
                min=Math.min(min,r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}

I am committed to consistent learning and problem-solving to grow as a developer. Feel free to explore the repository and share your thoughts.
