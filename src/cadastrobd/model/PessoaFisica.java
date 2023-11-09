package cadastrobd.model;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String cpf, Integer id, String nome, String endereco, String cidade, String estado,
                        String telefone, String email) {
        super(id, nome, endereco, cidade, estado, telefone, email);
        this.cpf = cpf;
    }

    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + getCpf());
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
