import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = source
                .stream()
                .filter(c -> {
                    if (c < threshold) logger.log(String.format("Element \"%d\" does not match", c));
                    else logger.log(String.format("Element \"%d\" match", c));
                    return c > threshold;
                })
                .collect(Collectors.toList());
            logger.log("Logger has added "+result.size()+" elements out of "+source.size());
        return result;
    }
}