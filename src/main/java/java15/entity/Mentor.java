package java15.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mentors")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_gen")
    @SequenceGenerator(name = "mentor_gen", sequenceName = "mentor_seq", allocationSize = 1)
    private Long id;
    @Column(name = "firts_name")
    private String name;
    @Column(unique = true)
    private String email;
    @Column(name = "year_of_birth")
    private int yearOfBirth;



}