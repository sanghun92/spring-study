import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Map;

public class RecordTest {

    @Test
    @DisplayName("test")
    void test() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TestRecord testRecord = new TestRecord("val1", "val2");
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testRecord);
        System.out.println("s = " + s);
    }

    @Test
    @DisplayName("test")
    void test2() throws JsonProcessingException {
        ModelMapper mapper = new ModelMapper();
        TestDTO testDTO = new TestDTO("val1", "val2");
        TestRecord testRecord = new TestRecord("val1", "val2");

//        TestDTO map = mapper.map(testRecord, TestDTO.class);
        TestRecord map = mapper.map(testDTO, TestRecord.class);

        System.out.println("s = " + map);
    }
}
