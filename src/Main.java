import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Start program");
        int listSize = inputReader("Enter list size");
        int maxValue = inputReader("Enter upper threshold for values");
        Random random = new Random();
        List<Integer> list = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(maxValue));
        }
        logger.log("Here is a random list: " + list);
        int upperThreshold = inputReader("Enter the threshold for the filter: ");
        logger.log("Start filter...");
        Filter filter = new Filter(upperThreshold);
        List<Integer> resultList = filter.filterOut(list);
        logger.log("Filtered list: "+resultList);
    }

    public static int inputReader(String msg) {
        Logger logger = Logger.getInstance();
        logger.log(msg);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        try {
            input = Integer.parseInt(bufferedReader.readLine());
        } catch (IllegalArgumentException | IOException exception) {
            exception.printStackTrace();
        }
        System.out.println(input);
        return input;
    }
}
