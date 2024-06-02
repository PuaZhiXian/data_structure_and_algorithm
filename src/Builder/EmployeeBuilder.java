package DesignPatternJava.Builder;

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    public EmployeeBuilder workingAt(String company) {
        person.setCompany(company);
        return getSelf();
    }

    @Override
    protected EmployeeBuilder getSelf() {
        return this;
    }
}
