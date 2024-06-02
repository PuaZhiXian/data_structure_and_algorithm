package DesignPatternJava.Builder;

public class mainClass {
    public static void main(String[] args) {
        EmployeeBuilder builder = new EmployeeBuilder();
        Person helloEmployee = builder.addName("HELLO WORLD").workingAt("HELLO WORLD COMPANY").build();
        System.out.println(helloEmployee.toString());
    }
}
