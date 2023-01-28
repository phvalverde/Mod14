package br.com.valverde.dao;

import br.com.valverde.domain.Pokemon;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PokemonMapDAO implements IPokemonDAO {

    private Map<Integer, Pokemon> map;

    public PokemonMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    /*
    Método Cadastrar - Eu crio um boolean pra checar se já existe aquele pokemon,
    no caso aqui eu uso o numero, se não encontrar, eu adiciono ele ao map.
     */
    public Boolean cadastrar(Pokemon pokemon) {
        if (this.map.containsKey(pokemon.getNum())) {
            return false;
        }
        this.map.put(pokemon.getNum(), pokemon);
        return true;
    }

    @Override
    /*
    Método Excluir - Eu checo com o clienteCadastrado se existe algum com o CPF que
    eu digitar, se o resultado for diferente de nulo(no caso, existe cadastro feito) eu
    o removo do map usando o próprio CPF.
     */
    public void excluir(Integer num) {
        Pokemon pokemonCadastrado = this.map.get(num);

        if (pokemonCadastrado != null) {
            this.map.remove(pokemonCadastrado.getNum(), pokemonCadastrado);
        }

    }

    @Override
    /*
    Método Alterar - Checo se existe algum clienteCadastrado com as informações que
    eu adicionei na tela(pokemon), caso exista(clienteCadastrado != null), eu posso
    alterar todas as informações dele.
     */
    public Object alterar(Pokemon pokemon) {
        Pokemon pokemonCadastrado = this.map.get(pokemon.getNum());
        if (pokemonCadastrado != null) {
            pokemonCadastrado.setNome(pokemon.getNome());
            pokemonCadastrado.setNum(pokemon.getNum());
            pokemonCadastrado.setGenero(pokemon.getGenero());
            pokemonCadastrado.setCategoria(pokemon.getCategoria());
            pokemonCadastrado.setTipo(pokemon.getTipo());

        }
        return null;
    }

    @Override
    /*
    Método Consultar - O num que eu digitar na tela, se houver no map, ele me retorna.
     */
    public Pokemon consultar(Integer num) {
        return this.map.get(num);
    }

    @Override
    /*
    Método Buscar todos - Retorna todos os valores dessa coleção.
     */
    public Collection<Pokemon> buscarTodos() {
        return this.map.values();
    }
}
