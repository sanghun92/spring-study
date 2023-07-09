
public class TestDTO {
    private String val1;
    private String val2;

    public TestDTO(String val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public String getVal1() {
        return val1;
    }

    public TestDTO setVal1(String val1) {
        this.val1 = val1;
        return this;
    }

    public String getVal2() {
        return val2;
    }

    public TestDTO setVal2(String val2) {
        this.val2 = val2;
        return this;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "val1='" + val1 + '\'' +
                ", val2='" + val2 + '\'' +
                '}';
    }
}
