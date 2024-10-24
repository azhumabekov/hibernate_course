package java15.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen", sequenceName = "course_gen", allocationSize = 1)

    private Long id;
    private String name;
    private int price;
    private LocalDate dateOfStart;

    // mentor
    @ManyToMany
    private List<Mentor> mentors;
    // student
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // lesson
    @OneToMany(mappedBy = "courses")
    private List<Lesson> lessons;

    public Course(String name, int price, LocalDate dateOfStart) {
        this.name = name;
        this.price = price;
        this.dateOfStart = dateOfStart;
    }
}
