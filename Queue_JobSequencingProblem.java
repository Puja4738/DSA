import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Job {
    char id;       // Job ID
    int deadline;  // Deadline of job
    int profit;    // Profit if job is completed before or on deadline

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Queue_JobSequencingProblem {
    public static void scheduleJobs(Job[] jobs, int n) {
        // Sort jobs by decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline to define the number of slots
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }

        // Priority queue to store jobs based on profit (min-heap)
        PriorityQueue<Job> queue = new PriorityQueue<>(Comparator.comparingInt(j -> j.profit));

        // Array to keep track of time slots (false means free)
        boolean[] slot = new boolean[maxDeadline];

        // Iterate over all jobs using a normal for loop
        for (int i = 0; i < n; i++) {
            Job job = jobs[i]; // Get the current job

            // Find a free slot for this job (starting from the last possible slot)
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!slot[j]) {  // If the slot is free
                    queue.add(job); // Add the job to the queue
                    slot[j] = true; // Mark this slot as filled
                    break; // Job scheduled, exit the inner loop
                }
            }
        }

        // Now print jobs from the priority queue
        System.out.print("Scheduled Jobs: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll().id + " "); // Poll the job with the highest priority (profit)
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1
        Job[] jobs1 = {
            new Job('a', 4, 20),
            new Job('b', 1, 10),
            new Job('c', 1, 40),
            new Job('d', 1, 30)
        };
        System.out.println("Test Case 1:");
        scheduleJobs(jobs1, jobs1.length); // Expected Output: c d a
    }
}
