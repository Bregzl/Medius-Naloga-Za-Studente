package org.medius.matic.bregar.resources;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.medius.matic.bregar.entities.Solution;
import org.medius.matic.bregar.repositories.SolutionRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/solutions")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class SolutionResource {

    @Inject
    private SolutionRepository solutionRepository;

    @GET
    public List<Solution> getAllSolutions() {
        return solutionRepository.listAll();
    }

    @GET
    @Path("/solver/{username}")
    public List<Solution> getUserSolutions(@PathParam String username) {
        return solutionRepository.getUserSolutions(username);
    }

    @GET
    @Path("/problem/{id}")
    public List<Solution> getUserSolutions(@PathParam Long id) {
        return solutionRepository.getProblemSolutions(id);
    }

    @Transactional
    @POST
    public Response saveSolution(Solution solution) {
        Solution newSolution = solutionRepository.save(solution);
        return Response.status(Response.Status.CREATED)
                .entity(solution)
                .build();
    }




}
