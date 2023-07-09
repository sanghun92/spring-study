public class EmployeeFacade {

    private final PayCalculator payCalculator;
    private final HourReporter hourReporter;
    private final EmployeeSaver employeeSaver;

    public EmployeeFacade() {
        this.payCalculator = new PayCalculator();
        this.hourReporter = new HourReporter();
        this.employeeSaver = new EmployeeSaver();
    }

    public void calculatePay(Employee employee) {
        this.payCalculator.calculatePay(employee);
    }

    public void reportHours(Employee employee) {
        this.hourReporter.reportHours(employee);
    }

    public void save(Employee employee) {
        this.employeeSaver.save(employee);
    }
}
