class Solution 
{
    public List<Integer> findValidElements(int[] nums) 
    {
        int n=nums.length;
        int []lm=new int[n];
        int []rm=new int[n];
        lm[0]=Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
            {
                lm[i]=Math.max(lm[i-1],nums[i-1]);
            }
        rm[n-1]=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--)
            {
                rm[i]=Math.max(rm[i+1],nums[i+1]);
            }
        List<Integer> r=new ArrayList<>();
        for(int i=0;i<n;i++)
            {
                if(nums[i]>lm[i]||nums[i]>rm[i])
                {
                    r.add(nums[i]);
                }
            }
        return r;
    }
}
