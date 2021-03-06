package dev.dhoncrisley.javecommerce.entity;




import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import java.util.ArrayList;
// import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
// import javax.persistence.OneToMany;

@Entity
public
class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private double subtotal;
    @Column(nullable = false)
    private double total;
    @Column(nullable = false)
    private double desconto;
    @Column(nullable = true)
    private String cupom_ativo;

    @OneToMany
    private List<PedidoProdutos> carrinho = new ArrayList<>();


    public Pedidos() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getCupom_ativo() {
        return cupom_ativo;
    }

    public void setCupom_ativo(String cupom_ativo) {
        this.cupom_ativo = cupom_ativo;
    }



}