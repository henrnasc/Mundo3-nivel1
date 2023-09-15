package Model;

import java.io.Serializable;

public class Pessoajuridica extends Pessoa implements Serializable {
    private String cnpj;

    public Pessoajuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        System.out.println(
                "Id: " + getId() + "\n" +
                        " Nome: " + getNome() + "\n" +
                        " CNPJ: " + getCnpj()
        );
    }
}