package Model.Gerenciadores;

import Model.Pessoajuridica;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<Pessoajuridica> listaPessoasJuridicas;

    public PessoaJuridicaRepo() {
        listaPessoasJuridicas = new ArrayList<>();
    }

    public void inserir(Pessoajuridica pessoaJuridica) {
        listaPessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(int id, Pessoajuridica pessoaJuridica) {
        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
            Pessoajuridica p = listaPessoasJuridicas.get(i);
            if (p.getId() == id) {
                listaPessoasJuridicas.set(i, pessoaJuridica);
                break;
            }
        }
    }

    public void excluir(int id) {
        listaPessoasJuridicas.removeIf(p -> p.getId() == id);
    }

    public Pessoajuridica obter(int id) {
        for (Pessoajuridica pessoaJuridica : listaPessoasJuridicas) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    public ArrayList<Pessoajuridica> obterTodos() {
        return new ArrayList<>(listaPessoasJuridicas);
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(nomeArquivo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Pessoajuridica pessoaJuridica : listaPessoasJuridicas) {
                bufferedWriter.write(
                        pessoaJuridica.getId() + "," +
                                pessoaJuridica.getNome() + "," +
                                pessoaJuridica.getCnpj() + ",");
                bufferedWriter.newLine();
            }
        }
    }

    public void recuperar(String nomeArquivo) throws IOException {
        try (FileReader fileReader = new FileReader(nomeArquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            listaPessoasJuridicas.clear();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String cnpj = campos[2];
                Pessoajuridica pessoaJuridica = new Pessoajuridica(id, nome, cnpj);
                listaPessoasJuridicas.add(pessoaJuridica);
            }
        }
        System.out.println("Dados das pessoas jurídicas foram recuperados do arquivo " + nomeArquivo);
    }
    public Pessoajuridica procurarPorId(int idProcurado) {
        for (Pessoajuridica pessoa : listaPessoasJuridicas) {
            if (pessoa.getId() == idProcurado) {
                return pessoa;
            }
        }
        return null;
    }
}