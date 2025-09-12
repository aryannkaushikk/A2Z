"""
Approach

For Each Mail mark it to some index
If current email exists in map then union edge between that node and current index node

Then put same parent mails in one place using ArrayList array
Then form the ans nested ArrayList
"""

class Solution {

    int findPar(int[] par, int x){
        if(par[x]==x) return x;
        return par[x] = findPar(par, par[x]);
    }

    void union(int[] par, int[] size, int a, int b){
        int pa = findPar(par, a);
        int pb = findPar(par, b);
        if(pa==pb) return;
        else if(size[pa] > size[pb]){
            par[pb] = pa;
            size[pa] += size[pb];
        }else{
            par[pa] = pb;
            size[pb] += size[pa];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, Integer> map = new HashMap<>();
        int[] par = new int[n];
        int[] size = new int[n];
        Arrays.fill(size, 1);
        for(int i = 0; i<n; i++) par[i] = i;
        for(int j = 0; j<n; j++){
            for(int i = 1; i<accounts.get(j).size(); i++){
                String mail = accounts.get(j).get(i);
                if(map.containsKey(mail)){
                    union(par, size, map.get(mail), j);
                }else{
                    map.put(mail, j);
                }
            }
        }

        List<String>[] map2 = new ArrayList[n];
        for(int i = 0; i<n; i++) map2[i] = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int parent = findPar(par, entry.getValue());
            map2[parent].add(entry.getKey());
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(map2[i].size()==0) continue;
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            Collections.sort(map2[i]);
            list.addAll(map2[i]);
            ans.add(list);
        }
        return ans;
    }
}
