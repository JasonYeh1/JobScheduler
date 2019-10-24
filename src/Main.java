import java.io.*;
import java.util.ArrayList;

public class Main {
    public static final int TRIALS = 20;
    public static void main(String args[]) {
        //ArrayList declarations for each algorithm. Stores the average turnaround time for each trial. Trials are put in order of 5, 10, and 15 jobs
        ArrayList<Double> fcfsTrials = new ArrayList<>();
        ArrayList<Double> sjfTrials = new ArrayList<>();
        ArrayList<Double> rr2Trials = new ArrayList<>();
        ArrayList<Double> rr5Trials = new ArrayList<>();

        //Randomly generate test case text file with 5, 10, 15 jobs with max burst time 20 seconds, 20 times
        for(int k = 0; k < TRIALS; k++) {
            //Create 3 text files
            for(int i = 1; i < 4; i++) {
                try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test" + i + ".txt"), "utf-8"))) {
                    for(int j = 1; j < (i*5)+1; j++) {
                        writer.write("Job"+j+"\n");
                        //choose a random number between 1-20
                        writer.write((int)(Math.random()*20)+1 + "\n");
                    }
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }

            //Run the 4 schedulers on the test set
            for(int x = 1; x < 4; x++) {
                //get the correct test file
                File file = new File("test" + x + ".txt");
                //test file to test the correctness of the program
                File test = new File("job.txt");
                File test1 = new File("job10.txt");
                File test2 = new File("job15.txt");

                FCFS fcfs = new FCFS();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Trial " + (k+1) + " of First-Come-First-Serve");
                double fcfsAverage = fcfs.execute(file);
                fcfsTrials.add(fcfsAverage);

                SJF sjf = new SJF();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Trial " + (k+1) + " of Shortest-Job-First");
                double sjfAverage = sjf.execute(file);
                sjfTrials.add(sjfAverage);

                RR rr = new RR();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Trial " + (k+1) + " of Round-Robin-2");
                double rr2Average = rr.execute(file, 2);
                rr2Trials.add(rr2Average);

                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Trial " + (k+1) + " of Round-Robin-5");
                double rr5Average = rr.execute(file, 5);
                rr5Trials.add(rr5Average);
            }
        }
        //Algorithms have finished running and now the sums for each trial are summed up and the total average is calculated
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        double fcfsSum5 = 0;
        double fcfsSum10 = 0;
        double fcfsSum15 = 0;
        for(int i = 0; i < fcfsTrials.size(); i+=3) {
            fcfsSum5 += fcfsTrials.get(i);
            fcfsSum10 += fcfsTrials.get(i+1);
            fcfsSum15 += fcfsTrials.get(i+2);
        }
        System.out.println("FCFS " + TRIALS + " trial average for 5 jobs:  " + fcfsSum5/TRIALS);
        System.out.println("FCFS " + TRIALS + " trial average for 10 jobs: " + fcfsSum10/TRIALS);
        System.out.println("FCFS " + TRIALS + " trial average for 15 jobs: " + fcfsSum15/TRIALS);

        System.out.println("");
        double sjfSum5 = 0;
        double sjfSum10 = 0;
        double sjfSum15 = 0;
        for(int i = 0; i < sjfTrials.size(); i+=3) {
            sjfSum5 += sjfTrials.get(i);
            sjfSum10 += sjfTrials.get(i+1);
            sjfSum15 += sjfTrials.get(i+2);
        }
        System.out.println("SJF " + TRIALS + " trial average for 5 jobs:  " + sjfSum5/TRIALS);
        System.out.println("SJF " + TRIALS + " trial average for 10 jobs: " + sjfSum10/TRIALS);
        System.out.println("SJF " + TRIALS + " trial average for 15 jobs: " + sjfSum15/TRIALS);

        System.out.println("");
        double rr2Sum5 = 0;
        double rr2Sum10 = 0;
        double rr2Sum15 = 0;
        for(int i = 0; i < sjfTrials.size(); i+=3) {
            rr2Sum5 += rr2Trials.get(i);
            rr2Sum10 += rr2Trials.get(i+1);
            rr2Sum15 += rr2Trials.get(i+2);
        }
        System.out.println("RR-2 " + TRIALS + " trial average for 5 jobs:  " + rr2Sum5/TRIALS);
        System.out.println("RR-2 " + TRIALS + " trial average for 10 jobs: " + rr2Sum10/TRIALS);
        System.out.println("RR-2 " + TRIALS + " trial average for 15 jobs: " + rr2Sum15/TRIALS);

        System.out.println("");
        double rr5Sum5 = 0;
        double rr5Sum10 = 0;
        double rr5Sum15 = 0;
        for(int i = 0; i < sjfTrials.size(); i+=3) {
            rr5Sum5 += rr5Trials.get(i);
            rr5Sum10 += rr5Trials.get(i+1);
            rr5Sum15 += rr5Trials.get(i+2);
        }
        System.out.println("RR-2 " + TRIALS + " trial average for 5 jobs:  " + rr5Sum5/TRIALS);
        System.out.println("RR-2 " + TRIALS + " trial average for 10 jobs: " + rr5Sum10/TRIALS);
        System.out.println("RR-2 " + TRIALS + " trial average for 15 jobs: " + rr5Sum15/TRIALS);
    }
}
