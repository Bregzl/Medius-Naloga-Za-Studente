package org.medius.matic.bregar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Problem {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="problem_id")
    private Long id;
    @ElementCollection
    private List<Integer> matrix;

    @JsonIgnore
    @JoinColumn(name = "player_id_fk")
    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Player.class
            //optional = false
    )
    private Player player;

    @JsonIgnore
    @JsonbTransient
    @OneToMany(
            targetEntity = Solution.class,
            cascade = CascadeType.ALL,
            mappedBy = "problem",
            fetch = FetchType.LAZY
    )
    private List<Solution> solutions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Integer> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<Integer> problem) {
        this.matrix = problem;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }


/*
    public static List<Problem> userProblems(String name) {
        //SELECT p FROM problem p JOIN player ON player_id_fk = player_id WHERE username LIKE 'matic'
        return list("SELECT p FROM Problem p JOIN Player ON player_id_fk = player_id WHERE username LIKE ?1", "matic");
    }

*/




}
