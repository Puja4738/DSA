import java.util.Stack;

public class Stack_Assign3_DecodeString {
    public static String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();  // Stack to store strings
        Stack<Integer> countStack = new Stack<>();  // Stack to store repeat counts
        StringBuilder currString = new StringBuilder();  // StringBuilder to store the current string being processed
        int k = 0;  // Variable to store the current repeat count

        // Traverse the input string character by character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                // If the character is a digit, update the repeat count (k)
                k = k * 10 + (ch - '0');  // Convert character to integer and accumulate for multiple digits
            } else if (ch == '[') {
                // If '[' is encountered, push the current repeat count and current string to stacks
                countStack.push(k);
                stringStack.push(currString);
                
                // Reset the current string and repeat count
                currString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // If ']' is encountered, pop from the stacks to get the repeat count and previous string
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                
                // Repeat the current string 'repeatTimes' times and append to the decodedString
                for (int j = 0; j < repeatTimes; j++) {
                    decodedString.append(currString);
                }
                
                // Set the updated decodedString as the current string
                currString = decodedString;
            } else {
                // If the character is a letter, simply append it to the current string
                currString.append(ch);
            }
        }

        // Return the final decoded string
        return currString.toString();
    }

    public static void main(String[] args) {
        String input1 = "2[cv]";  // Test case 1
        String input2 = "3[b2[v]]L";  // Test case 2
        
        System.out.println("Decoded String 1: " + decodeString(input1));  // Output: cvcv
        System.out.println("Decoded String 2: " + decodeString(input2));  // Output: bvvbvvbvvL
    }
}
