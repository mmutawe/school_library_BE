package com.mmutawe.projects.school.library.be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@Entity(name = "Student")
@Table(
        name = "students",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "student_phone_number_unique",
                        columnNames = "phone_number"
                )
        }
)
public class Student {

    // id: unique & not nullable by default
    @Id
    @Column(
            name = "id",
            updatable = false
    )
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    @Column(
            name = "first_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            columnDefinition = "TEXT",
//            unique = true,
            nullable = false
    )
    private String email;

    @Column(
            name = "address",
            columnDefinition = "TEXT",
//            unique = true,
            nullable = false
    )
    private String address;

    @Column(
            name = "phone_number",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String contactNumber;

    @Column(
            name = "dob",
            nullable = false
    )
    private LocalDate birthday;

//    @OneToOne(mappedBy = "students")
//    private CampusCard campusCard;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String address, String contactNumber, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
