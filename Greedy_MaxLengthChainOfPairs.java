import java.util.*;

public class Greedy_MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        int newpair[][] = new int[pairs.length][3];

        // Copy pairs into the pair array with original indices
        for (int i = 0; i < pairs.length; i++) {
            newpair[i][0] = i; // Store the original index
            newpair[i][1] = pairs[i][0]; // Store the first element of the pair
            newpair[i][2] = pairs[i][1]; // Store the second element of the pair
        }

        // Sort the 'pair' array based on the second element of each pair
        Arrays.sort(newpair, Comparator.comparingInt(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        int chainLength = 1;
        ans.add(newpair[0][0]); // Add the index of the first pair
        int chainEnd = newpair[0][2]; // Store the end value of the first pair

        // Loop through the pairs to find the maximum chain length
        for (int i = 1; i < newpair.length; i++) {
            if (newpair[i][1] > chainEnd) {
                chainLength++;
                ans.add(newpair[i][0]);
                chainEnd = newpair[i][2];
            }
        }

        // Output the maximum length of the chain
        System.out.println("Max Length of chain : " + chainLength);

        // Print out the pairs forming the chain using a normal for loop
        for (int i = 0; i < ans.size(); i++) {
            int index = ans.get(i);
            System.out.print(Arrays.toString(pairs[index]) + " ");
        }
        System.out.println();
    }
}
