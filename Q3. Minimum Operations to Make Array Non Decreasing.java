class Solution 
{
    public long minOperations(int[] nums) 
    {
        int []dr=nums;
        long ans=0;
        for(int i=0;i<dr.length-1;i++)
            {
                if(dr[i]>dr[i+1])
                {
                    ans+=dr[i]-dr[i+1];
                }
            }
        return ans;
    }
}©leetcode
