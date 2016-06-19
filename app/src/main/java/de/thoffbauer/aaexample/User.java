package de.thoffbauer.aaexample;


public class User {

    private final String name;
    private final String address;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
