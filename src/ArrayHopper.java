import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jay on 12/17/16.
 */
public class ArrayHopper {

    public static final String FAILURE = "failure";
    // apublic static final String SUCCESS = "success";

    public static void main(String[] args) throws IOException, RuntimeException {

        Scanner input = new Scanner(System.in);
        List<Integer> arrayHopped = new ArrayList<>();

        while(input.hasNextInt()) {
            arrayHopped.add(input.nextInt());
        }
        jump(arrayHopped);

    }

    public static ArrayList<String> jump(List<Integer> array) {

        if (array == null || array.get(0)==0) {
            System.out.println(FAILURE);
        }

        ArrayList<String> hopsPath = new ArrayList<>();

        int distanceForCurrentHop = 0;
        int lastHopReached = 0;
        int maximum = 0;
        int nextJump = 0;
        int i;
        for(i=0; i<array.size(); i++) {
            if (i> distanceForCurrentHop) {
                break;
            }
            if (i> lastHopReached) {

                lastHopReached = distanceForCurrentHop;
                hopsPath.add(String.valueOf(nextJump));
            }
            maximum = Math.max(maximum, i+array.get(i));
            if( i == distanceForCurrentHop ) {
                lastHopReached++;
                distanceForCurrentHop = maximum;
            }
        }

        if ( (i > lastHopReached) && (hopsPath.size() >0) && (Integer.parseInt(hopsPath.get(hopsPath.size() - 1)) != nextJump)) {

            hopsPath.add(String.valueOf(nextJump));
        }

        if (nextJump >= array.size() - 1)
            return hopsPath;
        else
            return null;


    }
}
