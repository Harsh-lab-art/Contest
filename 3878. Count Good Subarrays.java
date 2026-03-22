class Solution 
{
    public long countGoodSubarrays(int[] nums) 
    {
        int[] arr=nums;
        int n=arr.length;
        long t=0;
        int [][] aa=new int[32][2];
        int as=0;
        Map<Integer,Integer> ls=new HashMap<>();
        for(int j=0;j<n;j++)
        {
            int cv=arr[j];
            ls.put(cv,j);
            for(int k=0;k<as;k++)
            {
                aa[k][0]|=cv;
            }
            aa[as++]=new int[]{cv,j};
            int u=0;
            for(int k=1;k<as;k++)
            {
                if(aa[k][0]!=aa[u][0])
                {
                    u++;
                    aa[u]=aa[k];
                }
                else
                {
                    aa[u][1]=Math.min(aa[u][1],aa[k][1]);
                }
            }
            as=u+1;
            for(int k=0;k<as;k++)
            {
                int os=aa[k][0];
                int lb=aa[k][1];
                int rb=(k+1<as)?aa[k+1][1]-1:j;
                Integer pos=ls.get(os);
                if(pos!=null && pos>=lb)
                {
                    int ve=Math.min(pos,rb);
                    if(ve>=lb)
                    {
                        t+=(ve-lb+1);
                    }
                }
            }
        }
        return t;
        
    }
}
