package Model.Gerenciadores;

import Model.Pessoafisica;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<Pessoafisica> listaPessoas;

    public PessoaFisicaRepo() {
        listaPessoas = new ArrayList<>();
    }

    public void inserir(Pessoafisica pessoaFisica) {
        listaPessoas.add(pessoaFisica);
    }

    public void alterar(int id, Pessoafisica pessoaFisica) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoafisica p = listaPessoas.get(i);
            if (p.getId() == id) {
                listaPessoas.set(i, pessoaFisica);
                break;
            }
        }
    }

    public void excluir(int id) {
        listaPessoas.removeIf(p -> p.getId() == id);
    }

    public Pessoafisica obter(int id) {
        for (Pessoafisica pessoaFisica : listaPessoas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    public ArrayList<Pessoafisica> obterTodos() {
        return new ArrayList<>(listaPessoas);
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(nomeArquivo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Pessoafisica pessoa : listaPessoas) {
                bufferedWriter.write(pessoa.getId() + "," + pessoa.getNome() + "," + pessoa.getCpf() + "," + pessoa.getIdade());
                bufferedWriter.newLine();
            }
        }
    }

    public void recuperar(String nomeArquivo) throws IOException {
        try (FileReader fileReader = new FileReader(nomeArquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            listaPessoas.clear();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String cpf = campos[2];
                int idade = Integer.parseInt(campos[3]);
                Pessoafisica pessoa = new Pessoafisica(id, nome, cpf, idade);
                listaPessoas.add(pessoa);
            }
        }
    }
    public Pessoafisica procurarPorId(int idProcurado) {
        for (Pessoafisica pessoa : listaPessoas) {
            if (pessoa.getId() == idProcurado) {
                return pessoa;
            }
        }
        return null;
    }
}