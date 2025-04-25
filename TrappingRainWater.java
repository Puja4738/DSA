import java.util.Stack;

public class TrappingRainWater {
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int waterTrapped = 0;

        for (int i = 0; i < n; i++) {
            // While the current bar is greater than the bar at stack's top
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // Get the index of the top bar

                if (stack.isEmpty()) {
                    break; // No boundary to trap water
                }

                int distance = i - stack.peek() - 1; // Calculate the width
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top]; // Calculate the height

                waterTrapped += distance * boundedHeight; // Water trapped in this portion
            }

            stack.push(i); // Push the current bar index to the stack
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println("Trapped water: " + trap(height)); // Output: 25
    }
}
