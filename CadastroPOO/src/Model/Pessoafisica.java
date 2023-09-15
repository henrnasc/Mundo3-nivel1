package Model;

import java.io.Serializable;

public class Pessoafisica extends Pessoa implements Serializable {
    private String cpf;
    private int idade;

    public Pessoafisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf(){
        return cpf;
    }

    public int getIdade(){
        return idade;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    @Override
    public void exibir() {
        System.out.println(
                "Id: " + getId() + "\n" +
                        " Nome: " + getNome() + "\n" +
                        " CPF: " + getCpf() + "\n" +
                        " Idade: " + getIdade()
        );
    }
}