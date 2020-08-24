package org.medius.matic.bregar.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Solution {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="solution_id")
    public Long id;

    @JoinColumn(name = "player_id_fk")
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    public Player player;

    @JoinColumn(name = "problem_id_fk")
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    public Problem problem;

    @OneToMany(
            targetEntity = SolutionStep.class,
            cascade = CascadeType.ALL,
            mappedBy = "solution",
            fetch = FetchType.LAZY
    )
    public List<SolutionStep> steps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public List<SolutionStep> getSteps() {
        return steps;
    }

    public void setSteps(List<SolutionStep> steps) {
        this.steps = steps;
    }
}
