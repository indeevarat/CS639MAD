package com.example.firebaseemployee;

public class Employee {
    private String lastName, firstName;
    Employee(){
        this.firstName ="empty";
        this.lastName = "empty";
    }
    Employee(String lName, String fName){
        this.lastName =lName;
        this.firstName =fName;
    }
    public String getLastName(){return lastName;}
    public String getFirstName(){return firstName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
