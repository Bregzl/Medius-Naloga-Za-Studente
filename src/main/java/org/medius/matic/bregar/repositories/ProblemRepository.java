package org.medius.matic.bregar.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.medius.matic.bregar.entities.Problem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProblemRepository implements PanacheRepository<Problem> {
    @Inject
    PlayerRepository playerRepository;

    public List<Problem> userProblems(String username) {
        //language=JPAQL
        final String sqlquery =
                "SELECT p FROM Problem p " +
                        "LEFT JOIN FETCH p.player pl " +
                        "WHERE pl.username LIKE ?1 ";

        return list(sqlquery,username);
    }


    @Transactional
    public Problem save(Problem problem, Long userId){
        problem.setId(null);
        problem.setPlayer(playerRepository.findById(userId));
        persist(problem);
        return problem;
    }


    private boolean checkProblem(Problem problem){
        List<Integer> newMatrix = problem.getMatrix();
        double dimensions = Math.sqrt(newMatrix.size());
        if(dimensions != Math.round(dimensions)) {
            return false;
        }

        return true;

    }





}
