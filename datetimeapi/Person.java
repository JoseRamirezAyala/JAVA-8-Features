package datetimeapi;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
      return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
    }
    
    public Person(String name, LocalDate localDate) {
        this.name = name;
        this.dateOfBirth = localDate;
    }

    public String toString() {
        return "Person [" + this.name + ", " + this.dateOfBirth + "]";
    }
}
