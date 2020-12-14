package dev.dhoncrisley.javecommerce.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public
class Cupons {


    @Id
    private String id;

    @Column(nullable = false)
    private double desconto;
    @Column(nullable = true)
    private String validade;


    public Cupons() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }


    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

}