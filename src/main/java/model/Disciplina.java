package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disciplina {

    private int codigo;
    private String nome;
    private Professor professor;

    @Override
    public String toString() {
        return codigo + " - " + nome + " - " + professor;
    }
}
