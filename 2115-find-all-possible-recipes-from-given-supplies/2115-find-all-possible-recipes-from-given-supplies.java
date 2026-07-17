class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, ArrayList<String>> adj = new HashMap<>();

        for(int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];

            for(String ingredient : ingredients.get(i)) {
                adj.putIfAbsent(ingredient, new ArrayList<>());
                adj.get(ingredient).add(recipe);
            }
        }

        HashMap<String, Integer> indegree = new HashMap<>();
        for(int i = 0; i < recipes.length; i++) {
            indegree.put(recipes[i], ingredients.get(i).size());
        }

        Queue<String> q = new LinkedList<>();
        for(String supply : supplies) {
            q.offer(supply);
        }

        List<String> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            String item = q.poll();

            if(!adj.containsKey(item)) {
                continue;
            }

            for(String recipe : adj.get(item)) {
                indegree.put(recipe, indegree.get(recipe) - 1);

                if(indegree.get(recipe) == 0) {
                    q.offer(recipe);
                    ans.add(recipe);
                }
            }
        }

        return ans;
    }
}