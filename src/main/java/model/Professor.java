package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor {

    private int codigo;
    private String nome;
    private String titulacao;
    @Override
    public String toString() {
        return nome;
    }
}
