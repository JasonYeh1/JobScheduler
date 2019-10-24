import java.io.File;
import java.util.*;

//Class representing the Shortest-Job-First job scheduling algorithm
public class SJF {

    //Method taking in a file parameter that executes the SJF algorithm
    //returns the average turnaround time for this file
    public double execute(File file) {
        int totalTime = 0;
        double totalJobs = 0;
        int cumulativeTime = 0;
        //LinkedHashMap with job name as the key and the burst time as its value
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        try {
            Scanner sc = new Scanner(file);
            //initial loop to store contents of file in a hashmap
            while(sc.hasNextLine()) {
                String currentJob = sc.nextLine();
                int burstTime = Integer.parseInt(sc.nextLine());
                map.put(currentJob, burstTime);
            }
            System.out.println("Jobs and their burst times: " + map.toString());
            totalJobs = map.size();
            //create a LinkedList that holds each map entry in an index
            List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
            //sort the LinkedList by each entry's burst time
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });
            System.out.print("Gantt Chart: |");
            //Loop to go through the sorted LinkList and print out the Gantt Chart
            for(Map.Entry<String, Integer> aa : list) {
                String currentJob = aa.getKey();
                int burstTime = aa.getValue();
                totalTime += cumulativeTime+burstTime;
                cumulativeTime += burstTime;
                for(int i = 0; i < burstTime; i++) {
                    if(i == 0) {
                        System.out.print(currentJob);
                        System.out.print("=");
                    } else {
                        System.out.print("=");
                    }
                    if(i==burstTime-1) System.out.print(cumulativeTime);
                }
                System.out.print("|");
            }
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
