import java.util.Stack;

public class Stack_Assign2_SimplifyPath {
    public static String simplifyPaths(String path) {
        // Stack to store directory names (strings, not characters)
        Stack<String> s = new Stack<>();
        
        // Split the path by "/"
        String[] components = path.split("/");
        
        for (int i = 0; i < components.length; i++) {
            String dir = components[i];
            
            if (dir.equals("") || dir.equals(".")) {
                // Ignore empty or current directory '.'
                continue;
            } else if (dir.equals("..")) {
                // Move to the parent directory by popping the stack if it's not empty
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                // Valid directory name, push onto the stack
                s.push(dir);
            }
        }
        
        // If the stack is empty, return "/"
        if (s.isEmpty()) {
            return "/";
        }
        
        // Join the stack elements to form the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (int i = 0; i < s.size(); i++) {
            simplifiedPath.append("/").append(s.get(i));
        }
        
        return simplifiedPath.toString();
    }
    
    public static void main(String[] args) {
        String input1 = "/apnacollege/";
        String input2 = "/a/..";
        
        // Output the simplified paths
        System.out.println("Simplified path 1: " + simplifyPaths(input1));  // Output: /apnacollege
        System.out.println("Simplified path 2: " + simplifyPaths(input2));  // Output: /
    }
}
