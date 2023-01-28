package br.com.valverde;

import br.com.valverde.dao.PokemonMapDAO;
import br.com.valverde.dao.IPokemonDAO;
import br.com.valverde.dao.PokemonSetDAO;
import br.com.valverde.domain.Pokemon;

import javax.swing.*;

public class App {
    
    private static IPokemonDAO iPokemonDAO;

        public static void main(String[] args) {
            iPokemonDAO = new PokemonMapDAO();

            String opcao = JOptionPane.showInputDialog(null,
                "Olá, bem vindo ao sistema de Cadastro Pokémon,\npara começar, digite:\n1) CADASTRO\n2) CONSULTAR" +
                        "\n3) EXCLUSÃO\n4) ALTERAÇÃO\n5) SAIR",
                "Cadastro",
                JOptionPane.INFORMATION_MESSAGE);

            while (!isOpcaoValida(opcao)) {
                if ("".equals(opcao)) {
                    sair();
                }
                opcao = JOptionPane.showInputDialog(null, "Opção inválida, digite:\n1 para CADASTRO\n2 para CONSULTAR\" +\n" +
                        "                        \n3 para EXCLUSÃO\n4 para ALTERAÇÃO\n5 para SAIR", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            while (isOpcaoValida(opcao)) {

                if (isOpcaoSair(opcao)) {
                    sair();

                } else if (isCadastro(opcao)) {
                        String dados = JOptionPane.showInputDialog(null,
                            "Digite os dados do Pokémon, separando por vírgula, ex: Nome, Numero, Gênero, Categoria e Tipo",
                            "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                        cadastrar(dados);
                    } else if (isConsulta(opcao)) {
                        String dados = JOptionPane.showInputDialog(null,
                            "Digite o número do Pokémon",
                            "Consulta", JOptionPane.INFORMATION_MESSAGE);
                        consultar(dados);
                    } else if (isExclusao(opcao)) {
                        String dados = JOptionPane.showInputDialog(null,
                            "Digite o número do Pokémon que deseja excluir",
                            "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                        excluir(dados);
                    } else {
                        String dados = JOptionPane.showInputDialog(null,
                            "Digite os dados do Pokémon, separando por vírgula, ex: Nome, Numero, Gênero, Categoria e Tipo",
                            "Alteração", JOptionPane.INFORMATION_MESSAGE);
                        alterar(dados);
                    }
                opcao = JOptionPane.showInputDialog(null,
                        "Olá, bem vindo ao sistema de Cadastro Pokémon,\npara começar, digite:\n1 para CADASTRO\n2 para CONSULTAR" +
                                "\n3 para EXCLUSÃO\n4 para ALTERAÇÃO\n5 para SAIR",
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }

    private static void cadastrar(String dados) {
             String[] dadosSeparados = dados.split(",");      


            Pokemon pokemon = new Pokemon(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4]);

        Boolean isCadastrado = iPokemonDAO.cadastrar(pokemon);
            if (isCadastrado) {
                JOptionPane.showInputDialog(null, "Pokémon cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showInputDialog(null, "Pokémon já está cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
    }


    private static void consultar(String dados) {
        Pokemon pokemon = iPokemonDAO.consultar(Integer.parseInt(dados));
        if (pokemon != null) {
            JOptionPane.showInputDialog(null, "Pokémon catalogado: " + pokemon.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showInputDialog(null, "Pokémon não catalogado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private static void excluir(String dados) {
            iPokemonDAO.excluir(Integer.parseInt(dados));
        JOptionPane.showMessageDialog(null, "Pokémon excluído com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);

    }
    private static void alterar(String dados) {
            String[] dadosSeparados = dados.split(",");
            Pokemon pokemon = new Pokemon(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4]);
            iPokemonDAO.alterar(pokemon);

    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return  true;
        }
        return false;
    }

    private static boolean isConsulta(String opcao) {
        if ("2".equals(opcao)) {
            return  true;
        }
        return false;

    }
    private static boolean isExclusao(String opcao) {
        if ("3".equals(opcao)) {
            return  true;
        }
        return false;

    }
    private static boolean isAlteracao(String opcao) {
        if ("4".equals(opcao)) {
            return  true;
        }
        return false;
    }
    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return  true;
        }
        return false;
    }
    private static void sair() {
        String pokemonsCadastrados = "";
        for (Pokemon pokemon : iPokemonDAO.buscarTodos()) {
            pokemonsCadastrados += pokemon.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,
                "Pokémons cadastrados: " + pokemonsCadastrados,
                "Até logo",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) ||
            "2".equals(opcao) ||
            "3".equals(opcao) ||
            "4".equals(opcao) ||
            "5".equals(opcao)) {
            return true;
        }
        return false;
    }
}
