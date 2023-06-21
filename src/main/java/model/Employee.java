package model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor

@ToString
@Entity
@Table(name="employee")
@EqualsAndHashCode(of = {"id"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    private String gender;
    private int age;
    @Column(name = "city_id")
    private int city;
}
