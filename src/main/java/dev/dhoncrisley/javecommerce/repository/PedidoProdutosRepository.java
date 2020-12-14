package dev.dhoncrisley.javecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;

import dev.dhoncrisley.javecommerce.entity.PedidoProdutos;
import dev.dhoncrisley.javecommerce.entity.Pedidos;

//Remove @RepositoryRestResource below to disable auto REST api:
@RepositoryRestResource
public interface PedidoProdutosRepository extends CrudRepository<PedidoProdutos, Long>{
//    Iterable<PedidoProdutos> findByPedido(Pedidos pedidos);
}