package ccf;

import java.util.*;

/**
 * Created by yujian on 2017/11/17.
 */
public class AllocationSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] seats = new int[20][5];
        Map<Integer,List<Integer>> arrange = new HashMap<>();

        int i=0;
        while (i++<n){
            int requestNums = scanner.nextInt();
            lableA:
            for (int j = 0; j < 20; j++) {
                int sequence = 0;
                for (int k = 0; k < 5; k++) {
                    if (seats[j][k]==0){
                        sequence++;
                    }

                    if (sequence==requestNums){
                        List<Integer> arrangeSeats = new LinkedList<>();
                        for (int l = k-sequence+1; l <=k ; l++) {
                            seats[j][l]=1;
                            arrangeSeats.add(j*5+(l+1));
                        }
                        arrange.put(i,arrangeSeats);
                        break lableA;
                    }
                }
            }
            if (!arrange.containsKey(i)){
                List<Integer> arrangeSeats = new LinkedList<>();
                lableB:
                for (int j = 0; j < 20; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (seats[j][k]==0){
                            seats[j][k] = 0;
                            arrangeSeats.add(j*5+(k+1));
                        }
                        if (arrangeSeats.size()==requestNums){
                            arrange.put(i,arrangeSeats);
                            break lableB;
                        }
                    }
                }
            }
        }
        for (Map.Entry<Integer,List<Integer>> entry:arrange.entrySet()){
            List<Integer> arrangeSeats = entry.getValue();
            for (int j = 0; j < arrangeSeats.size(); j++) {
                if (j==arrangeSeats.size()-1){
                    System.out.println(arrangeSeats.get(j));
                }
                else {
                    System.out.print(arrangeSeats.get(j)+" ");
                }
            }
        }
    }
}
