class Solution 
{
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;
        int[] minr=new int[n];
        minr[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
            {
                minr[i]=Math.min(minr[i+1],nums[i]);
            }
        int maxl=nums[0];
        for(int i=0;i<n;i++)
            {
                if(i>0)
                    maxl=Math.max(maxl,nums[i]);
                if(maxl<=minr[i]+k)
                {
                    return i;
                }
            }
        return -1;
    }
}
