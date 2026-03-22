class Solution 
{
    public boolean uniformArray(int[] nums1) 
    {
        int[] arr=nums1;
        int n=arr.length;
        int minval=Integer.MAX_VALUE;
        boolean odd=false;
        int minodd=Integer.MAX_VALUE;
        for(int num:arr)
        {
            if(num<minval)
            {
                minval=num;
            }
            if(num%2!=0)
            {
                odd=true;
                if(num<minodd)
                {
                    minodd=num;
                }
            }
        }
        if(!odd) return true;
        if(minval%2!=0) return true;
        return false;
    }
}
