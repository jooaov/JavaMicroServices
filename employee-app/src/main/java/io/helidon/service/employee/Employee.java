package io.helidon.service.employee;

import java.util.UUID;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public final class Employee {


    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String birthDate;
    private final String title;
    private final String department;

//    constructor
    private Employee(String id, String firstName, String lastName, String email, String phone, String birthDate,
                     String title, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.title = title;
        this.department = department;
    }


//    JsonbProperty define um 'alias' para a propiedade que esta em json
    @JsonbCreator
    public static Employee of(@JsonbProperty("id") String id, @JsonbProperty("firstName") String firstName,
                              @JsonbProperty("lastName") String lastName, @JsonbProperty("email") String email,
                              @JsonbProperty("phone") String phone, @JsonbProperty("birthDate") String birthDate,
                              @JsonbProperty("title") String title, @JsonbProperty("department") String department) {
        //    se o ID for null ou vazio
        if (id == null || id.trim().equals("")) {
//    cria um random UUID e define como string

            id = UUID.randomUUID().toString();
        }
//        cria um employye e retorna
        Employee e = new Employee(id, firstName, lastName, email, phone, birthDate, title, department);
        return e;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }
}
