public class Customer {
    private String name;
    private int age;
    private String email;
    private String location;

    public Customer(String name, int age, String email, String location) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }
}
