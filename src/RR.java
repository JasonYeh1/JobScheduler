import java.io.File;
import java.util.*;

//Class representing the Round-Robin job scheduling algorithm
public class RR {

    //Method that takes in a file and integer timeSlice parameter
    //returns the average turnaround time for this file
    public double execute(File file, int timeSlice) {
        int totalTime = 0;
        double totalJobs = 0;
        int finishedJobs = 0;
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
            totalJobs = map.size();
            System.out.println("Jobs and their burst times: " + map.toString());
            System.out.print("Gantt Chart: ");
            ArrayList<Integer> times = new ArrayList<>();
            //loop to iterate through the map until all jobs are finished
            while(finishedJobs < map.size()) {
                //for each loop that iterates through each entry of the hashmap
                for(Map.Entry<String, Integer> aa : map.entrySet()) {
                    String currentJob = aa.getKey();
                    int burstTime = aa.getValue();
                    //Checks if the current job is finished
                    if(burstTime != 0){
                        //case that burst time of job is larger than the time slice
                        if(burstTime > timeSlice) {
                            System.out.print("|");
                            System.out.print(currentJob);
                            for(int i = 0; i < timeSlice; i++) {
                                System.out.print("=");
                            }
                            cumulativeTime += timeSlice;
                            System.out.print(cumulativeTime);
                            //update job's value
                            map.put(currentJob, burstTime - timeSlice);
                        //terminal case where burst time of job is the same as the time slice
                        } else if(burstTime == timeSlice) {
                            System.out.print("|");
                            System.out.print(currentJob);
                            for(int i = 0; i < timeSlice; i++) {
                                System.out.print("=");
                            }
                            cumulativeTime += timeSlice;
                            System.out.print(cumulativeTime);
                            finishedJobs++;
                            //update job's value to 0
                            map.put(currentJob, burstTime - timeSlice);
                            //terminal case so we add to times array
                            times.add(cumulativeTime);
                        //terminal case where burst time is less than the time slice
                        } else {
                            System.out.print("|");
                            System.out.print(currentJob);
                            //in this loop we only want to iterate for the rest of the job, not time slice
                            for(int i = 0; i < burstTime; i++) {
                                System.out.print("=");
                            }
                            cumulativeTime += burstTime;
                            System.out.print(cumulativeTime);
                            finishedJobs++;
                            map.put(currentJob, 0);
                            times.add(cumulativeTime);
                        }
                    }

                }
            }
            //Summation loop to get the total cumulative time
            System.out.print("|");
            for(Integer i: times){
                totalTime += i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println("Jobsize: " + map.size());
        System.out.println("Total Time: " + totalTime);
        System.out.println("Average Turnaround Time: " + totalTime/totalJobs);
        return totalTime/totalJobs;
    }
}
