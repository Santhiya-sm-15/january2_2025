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