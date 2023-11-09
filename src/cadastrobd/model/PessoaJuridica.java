
package cadastrobd.model;


public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String cnpj, Integer _id, String _nome, String _endereco, String _cidade, String _estado, String _telefone, String _email) {
        super(_id, _nome, _endereco, _cidade, _estado, _telefone, _email);
        this.cnpj = cnpj;
    }

    public PessoaJuridica(String number, String companyXLtda, String s, String fortaleza, String ce, String number1, String mail) {
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + this.getCnpj().toString());
    }


    public String getCnpj() {
        return cnpj;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
