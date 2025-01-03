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