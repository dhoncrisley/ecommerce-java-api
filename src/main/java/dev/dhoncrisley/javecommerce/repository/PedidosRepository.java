package dev.dhoncrisley.javecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.dhoncrisley.javecommerce.entity.Pedidos;

//Remove @RepositoryRestResource below to disable auto REST api:
@RepositoryRestResource
public interface PedidosRepository extends CrudRepository<Pedidos, Long>{}