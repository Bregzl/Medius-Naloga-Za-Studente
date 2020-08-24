package org.medius.matic.bregar.resources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.medius.matic.bregar.entities.Player;
import org.medius.matic.bregar.repositories.PlayerRepository;

@Path("/players")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class PlayerResource {
    @Inject
    private PlayerRepository playerRepository;

    @GET
    public List<Player> getAllPlayers() {
        return playerRepository.listAll();
    }

    @GET
    @Path("{name}")
    public List<Player> getSingle(@PathParam String name) {
        return playerRepository.search(name);
    }


    @POST
    public Response savePlayer(Player player) {
        Player newPlayer = playerRepository.save(player);
        return Response.status(Response.Status.CREATED)
                .entity(newPlayer)
                .build();
    }
}



