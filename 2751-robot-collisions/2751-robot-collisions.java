class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][3]; 
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = i;
        }
        Arrays.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>(); 
        List<int[]> survivors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pos = robots[i][0];
            int health = robots[i][1];
            int idx = robots[i][2];
            char dir = directions.charAt(idx);
            if (dir == 'R') {
                stack.push(new int[]{pos, health, idx});
            } else { 
                while (!stack.isEmpty() && health > 0) {
                    int[] top = stack.peek();
                    if (top[1] < health) {
                        stack.pop();
                        health--; 
                    } else if (top[1] == health) {
                        stack.pop();
                        health = 0; 
                    } else {
                        top[1]--; 
                        health = 0; 
                    }
                }
                if (health > 0) {
                    survivors.add(new int[]{pos, health, idx});
                }
            }
        }
        while (!stack.isEmpty()) {
            survivors.add(stack.pop());
        }
        survivors.sort((a, b) -> Integer.compare(a[2], b[2]));
        List<Integer> result = new ArrayList<>();
        for (int[] r : survivors) {
            result.add(r[1]);
        }
        return result;
    }
}