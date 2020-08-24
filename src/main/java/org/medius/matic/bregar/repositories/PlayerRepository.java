package org.medius.matic.bregar.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.medius.matic.bregar.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlayerRepository implements PanacheRepository<Player> {


    public List<Player> search(String username) {
        return list("username",username);
    }

    @Transactional
    public Player save(Player player){
        player.id=null;
        persistAndFlush(player);
        return player;
    }




}
