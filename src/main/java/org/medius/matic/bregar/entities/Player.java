package org.medius.matic.bregar.entities;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="player_id")
    public Long id;
    public String username;
    public int age;


    @JsonbTransient
    @OneToMany(
            targetEntity = Problem.class,
            cascade = CascadeType.ALL,
            mappedBy = "player",
            fetch = FetchType.LAZY
    )
    public List<Problem> problems;
/*
    @JsonbTransient
    @OneToMany(
            targetEntity = Solution.class,
            cascade = CascadeType.ALL,
            mappedBy = "player",
            fetch = FetchType.LAZY
    )
    public List<Solution> solutions;

*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }
}
