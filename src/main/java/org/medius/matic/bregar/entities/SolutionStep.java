package org.medius.matic.bregar.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class SolutionStep {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="solution_step_id")
    public Long id;
    int onOff;
    @Column(name="ordering")
    int order;

    @JoinColumn(name = "solution_id_fk")
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    public Solution solution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}
