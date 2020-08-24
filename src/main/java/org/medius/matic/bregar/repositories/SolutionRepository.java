package org.medius.matic.bregar.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.medius.matic.bregar.entities.Solution;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SolutionRepository implements PanacheRepository<Solution> {

    public List<Solution> getUserSolutions(String username) {
        //language=JPAQL
        final String sqlquery =
                "SELECT s FROM Solution s " +
                        "LEFT JOIN FETCH s.player pl " +
                        "WHERE pl.username LIKE ?1 ";

        return list(sqlquery,username);
    }


    public List<Solution> getProblemSolutions(Long id) {
        //language=JPAQL
        final String sqlquery =
                "SELECT s FROM Solution s " +
                        "LEFT JOIN FETCH s.problem prob " +
                        "WHERE prob.id = ?1 ";

        return list(sqlquery,id);
    }

    public Solution save (Solution solution){
        solution.id = null;
        persist(solution);
        return solution;
    }
}
