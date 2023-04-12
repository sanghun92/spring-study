import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class LSPExample {

    public void sample() {
        Collection<String> strings = new LinkedList<>();

        // 중간에 다른 타입으로 변경
        strings = new HashSet<>();
    }
}
