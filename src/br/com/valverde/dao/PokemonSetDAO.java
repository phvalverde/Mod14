package br.com.valverde.dao;

import br.com.valverde.domain.Pokemon;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ph_valverde
 * @created 23/01/2023 - 11:13
 * @project CadastroProjetoMod14
 */
public class PokemonSetDAO implements IPokemonDAO {

    private Set<Pokemon> set;

    public PokemonSetDAO() {
        this.set = new HashSet<>();
    }
    @Override
    public Boolean cadastrar(Pokemon pokemon) {
        return this.set.add(pokemon);
    }

    @Override
    public void excluir(Integer num) {
        Pokemon pokemonEncontrado = null;
        for (Pokemon pokemon : this.set) {
            if (pokemon.getNum().equals(num)) {
                pokemonEncontrado = pokemon;
                break;
            }
        }

        if (pokemonEncontrado != null) {
            this.set.remove(pokemonEncontrado);
        }
    }

    @Override
    public Object alterar(Pokemon pokemon) {
        if (this.set.contains(pokemon)) {
            for (Pokemon pokemonCadastrado : this.set) {
                if (pokemonCadastrado.equals(pokemon)) {
                    pokemonCadastrado.setNome(pokemon.getNome());
                    pokemonCadastrado.setNum(pokemon.getNum());
                    pokemonCadastrado.setGenero(pokemon.getGenero());
                    pokemonCadastrado.setCategoria(pokemon.getCategoria());
                    pokemonCadastrado.setTipo(pokemon.getTipo());
                    break;
                }
            }

        }

        return null;
    }

    public Pokemon consultar(Integer num) {
        for (Pokemon pokemonCadastrado : this.set) {
            if (pokemonCadastrado.getNum().equals(num)) {
                return pokemonCadastrado;
            }
        }
        return null;
    }

    public Collection<Pokemon> buscarTodos() {
        return this.set;
    }
}