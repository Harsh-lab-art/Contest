class Solution 
{
    public int minRemovals(int[] nums, int target) 
    {
        int [] arr=nums;
        int n=arr.length;
        int maxor=16384;
        int[] dp=new int[maxor];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int x: arr)
        {
            int [] dpp=dp.clone();
            for(int val=0;val<maxor;val++)
            {
                if(dp[val]!=-1)
                {
                    int nval=val^x;
                    dpp[nval]=Math.max(dpp[nval],dp[val]+1);
                }
            }
            dp=dpp;
        }
        if(target >=maxor || dp[target]==-1)
        {
            return -1;
        }
        return n-dp[target];
    }
}
