package DesignPatternJava.Builder;

public class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF addName(String name) {
        person.setName(name);
        return getSelf();
    }

    protected SELF getSelf() {
        return (SELF) this;
    }

    public Person build(){
        return person;
    }
}
