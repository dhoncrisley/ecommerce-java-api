package dev.dhoncrisley.javecommerce.entity;

import java.util.Set;

import javax.persistence.OneToMany;

public class Carrinho {
    @OneToMany(mappedBy="cart")
    private Set<PedidoProdutos> items;
}
