public class Patient {
    int id;
    String name;
    int age;
    String symptoms;
    String department;

    public Patient(int id, String name, int age, String symptoms) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.symptoms = symptoms;
        this.department = "Not decided";
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age
                + " | Symptoms: " + symptoms + " | Dept: " + department;
    }
}
