package br.com.valverde.dao;

import br.com.valverde.domain.Pokemon;

import java.util.Collection;

public interface IPokemonDAO {

    public Boolean cadastrar(Pokemon pokemon);

    public void excluir(Integer num);

    public Object alterar(Pokemon pokemon);

    public Pokemon consultar(Integer num);

    public Collection<Pokemon> buscarTodos();
}
