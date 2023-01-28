package br.com.valverde.domain;

import java.util.Objects;

public class Pokemon {

    private String nome;
    private Integer num;
    private String genero;
    private String categoria;
    private String tipo;

    public Pokemon(String nome, String num, String genero, String categoria, String tipo) {
        this.nome = nome;
        this.num = Integer.valueOf(num.trim());
        this.genero = genero;
        this.categoria = categoria;
        this.tipo = tipo;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(num, pokemon.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return "Pokémon(" +
                "num: " + num +
                ", nome: " + nome +
                ", sexo: " + genero +
                ", tipo: " + tipo +
                ", categoria: " + categoria +
                ')';
    }

}
