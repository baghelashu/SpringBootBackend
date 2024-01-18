package com.ashu.SpringBootCrud.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;


@Getter //method allows you to acccess an attribute in given class
@Setter //method that allows you to set or mutate the value of an attribute in class
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")






public class Employee {
    @Id // it helps to uniquely identify the classes
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    // if i didnot specify the column name then JPA automatic define the column name

    @Column(name="first_name")
    private String  firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id")
    private String emailId;


}
