package org.medius.matic.bregar.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.medius.matic.bregar.entities.SolutionStep;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SolutionStepRepository implements PanacheRepository<SolutionStep> {


}
