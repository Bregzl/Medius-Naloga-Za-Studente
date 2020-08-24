package org.medius.matic.bregar.resources;



import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.medius.matic.bregar.entities.Problem;
import org.medius.matic.bregar.repositories.PlayerRepository;
import org.medius.matic.bregar.repositories.ProblemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/problems")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ProblemResource {
    @Inject
    private ProblemRepository problemRepository;

    @GET
    public List<Problem> getAllProblems() {
        return problemRepository.listAll();
    }

    @GET
    @Path("/creator/{username}")
    public List<Problem> getAllUserProblems (@PathParam String username){
        return problemRepository.userProblems(username);
    }
/*
    @GET
    @Path("/creator/{id}")
    public List<Problem> getAllUserProblemsId (@PathParam Long id){
        return Problem.userProblemsId(id);
    }
*/
    @GET
    @Path("/{id}")
    public Problem getProblemById (@PathParam Long id){
        return problemRepository.findById(id);
    }

    @POST
    @Path("/{id}")
    public Response saveProblem (@PathParam Long id, Problem problem){
        Problem newProblem = problemRepository.save(problem, id);
        return Response.status(Response.Status.CREATED)
                .entity(newProblem)
                .build();
    }


}
