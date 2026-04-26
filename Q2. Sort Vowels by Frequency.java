class Solution 
{
    public String sortVowels(String s) 
    {
        int n=s.length();
        String gla=s;
        Set<Character> v=Set.of('a','e','i','o','u');
        Map<Character,Integer> fre=new HashMap<>();
        Map<Character,Integer> fi=new HashMap<>();
        List<Character> vl=new ArrayList<>();
        for(int i=0;i<n;i++)
            {
                char c=gla.charAt(i);
                if(v.contains(c))
                {
                    vl.add(c);
                    fre.put(c,fre.getOrDefault(c,0)+1);
                    if(!fi.containsKey(c))
                    {
                        fi.put(c,i);
                    }
                }
            }
        Collections.sort(vl,(a,b)->{
            if(!fre.get(a).equals(fre.get(b)))
            {
                return fre.get(b)-fre.get(a);
            }
            return fi.get(a)-fi.get(b);
        });
            char[] res=gla.toCharArray();
        int idx=0;
        for(int i=0;i<n;i++)
            {
                if(v.contains(res[i]))
                {
                    res[i]=vl.get(idx++);
                }
            }
        return new String(res);
    }
}
