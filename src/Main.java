import java.util.HashMap;

public class Main {
    public static void main(String args[]) {
        System.out.println("Hello World");
    }

//    FCFS(TextFile input) {
//        while(input.hasNext()) {
//            String currentJob = input.nextString();
//            int burstTime = input.nextInt();
//            for(int i = 0; i < burstTime; i++) {
//                process(currentJob);
//            }
//        }
//    }
//
//    SJF(TextFile input) {
//        HashMap<String, Integer> map = new HashMap<>();
//        while(input.hasNext()) {
//            String currentJob = input.nextString();
//            int burstTime = input.nextInt();
//            map.put(currentJob, burstTime);
//        }
//        Collections.sortByValue(map);
//
//        for(entry : map) {
//            String currentJob = entry.getKey();
//            int burstTime = entry.getValue();
//            for(int i = 0; i < burstTime; i++) {
//                process(currentJob);
//            }
//        }
//    }
//
//    RR(TextFile input, int timeSlice) {
//        int finishedJobs = 0;
//        HashMap<String, Integer> map = new HashMap<>();
//        while(input.hasNext()) {
//            String currentJob = input.nextString();
//            int burstTime = input.nextInt(0);
//            map.put(currentJob, burstTime);
//        }
//        while(finishedJobs < map.size()) {
//            for(entry : map) {
//                String currentJob = entry.getKey();
//                int timeBurst = entry.getValue();
//                if(timeBurst > timeSlice) {
//                    for(int i = 0; i < timeSlice; i++) {
//                        process(currentJob);
//                    }
//                    map.put(currentJob, timeBurst - timeSlice);
//                } else if(timeBurst == timeSlice) {
//                    for(int i = 0; i < timeSlice; i++) {
//                        process(currentJob);
//                    }
//                    finishedJobs++;
//                    map.put(currentJob, timeBurst - timeSlice);
//                } else {
//                    for(int i = 0; i < entry.getValue(); i++) {
//                        process(currentJob);
//                    }
//                    finishedJobs++;
//                    map.put(currentJob, 0);
//                }
//            }
//        }
//    }
}
