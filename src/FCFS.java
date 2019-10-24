import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

//Class representing the First-Come-First-Serve job scheduling algorithm
public class FCFS {

    //Method taking in a file parameter that executes the FCFS algorithm
    //returns the average turnaround time for this file
    public double execute(File file) {
        int totalTime = 0;
        double totalJobs = 0;
        int cumulativeTime = 0;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        try {
            Scanner initial = new Scanner(file);
            Scanner sc = new Scanner(file);
            //initial loop to store contents of file in a hashmap
            while(initial.hasNextLine()) {
                String currentJob = initial.nextLine();
                int burstTime = Integer.parseInt(initial.nextLine());
                map.put(currentJob, burstTime);
            }
            System.out.println("Jobs and their burst times: " + map.toString());
            System.out.print("Gantt Chart: ");
            //loop to print out the Gantt Chart
            while(sc.hasNextLine()) {
                String currentJob = sc.nextLine();
                int burstTime = Integer.parseInt(sc.nextLine());
                System.out.print("|");
                totalTime += cumulativeTime+burstTime;
                cumulativeTime += burstTime;
                for(int i = 0; i < burstTime; i++) {
                    if(i == 0) {
                        System.out.print(currentJob);
                        totalJobs++;
                        System.out.print("=");
                    } else {
                        System.out.print("=");
                    }
                    if(i==burstTime-1) System.out.print(cumulativeTime);
                }

            }
            System.out.print("|");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println("Jobsize: " + totalJobs);
        System.out.println("Total Time: " + totalTime);
        System.out.println("Average Turnaround Time: " + totalTime/totalJobs);
        return totalTime/totalJobs;
    }
}
