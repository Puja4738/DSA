import java.util.*;

public class Greedy_ChocolaProblem {
    public static void main(String[] args) {
        // int n = 4, m = 6; // Dimensions of the chocolate bar
        Integer costVer[] = {2, 1, 3,1, 4}; // Vertical cut costs (for n-1 cuts)
        Integer costHor[] = {4, 1, 2};    // Horizontal cut costs (for m-1 cuts)

        // Sort the cost arrays in descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // Pointers for horizontal and vertical cost arrays
        int hp = 1, vp = 1; // Initial counts of horizontal and vertical pieces
        int totalCost = 0;

        // Process cuts until one of the arrays is exhausted
        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] >= costVer[v]) { // Use '>=' to break ties in favor of horizontal cuts
                totalCost += costHor[h] * vp; // Multiply by current vertical pieces
                hp++; // Increase horizontal pieces
                h++; // Move to the next horizontal cut
            } else {
                totalCost += costVer[v] * hp; // Multiply by current horizontal pieces
                vp++; // Increase vertical pieces
                v++; // Move to the next vertical cut
            }
        }

        // Handle any remaining horizontal cuts
        while (h < costHor.length) {
            totalCost += costHor[h] * vp; // Remaining horizontal cuts affect all vertical pieces
            h++; // Move to the next horizontal cut
        }

        // Handle any remaining vertical cuts
        while (v < costVer.length) {
            totalCost += costVer[v] * hp; // Remaining vertical cuts affect all horizontal pieces
            v++; // Move to the next vertical cut
        }

        // Output the minimum cost of cutting
        System.out.println("Minimum cost of cuts: " + totalCost); // Expected output is 42
    }
}
