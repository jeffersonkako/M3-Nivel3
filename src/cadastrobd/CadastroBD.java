package cadastrobd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;

public class CadastroBD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();

        while (true) {
            System.out.println("================================");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("0 - Sair");
            System.out.println("================================");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) {
                System.out.println("Finalizando...");
                break;
            }

            System.out.println("Escolha o tipo:");
            System.out.println("1 - Física");
            System.out.println("2 - Jurídica");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        if (tipo == 1) {
                            System.out.println("Digite o nome:");
                            String nome = scanner.nextLine();
                            System.out.println("Digite o CPF:");
                            String cpf = scanner.nextLine();
                            System.out.println("Digite o endereço:");
                            String endereco = scanner.nextLine();
                            System.out.println("Digite a cidade:");
                            String cidade = scanner.nextLine();
                            System.out.println("Digite o estado:");
                            String estado = scanner.nextLine();
                            System.out.println("Digite o telefone:");
                            String telefone = scanner.nextLine();
                            System.out.println("Digite o email:");
                            String email = scanner.nextLine();
                            PessoaFisica pf = new PessoaFisica(cpf, null, nome, endereco, cidade, estado, telefone, email);
                            pfDAO.incluir(pf);
                        } else {
                            System.out.println("Digite o nome:");
                            String nome = scanner.nextLine();
                            System.out.println("Digite o CNPJ:");
                            String cnpj = scanner.nextLine();
                            System.out.println("Digite o endereço:");
                            String endereco = scanner.nextLine();
                            System.out.println("Digite a cidade:");
                            String cidade = scanner.nextLine();
                            System.out.println("Digite o estado:");
                            String estado = scanner.nextLine();
                            System.out.println("Digite o telefone:");
                            String telefone = scanner.nextLine();
                            System.out.println("Digite o email:");
                            String email = scanner.nextLine();
                            PessoaJuridica pj = new PessoaJuridica(cnpj, null, nome, endereco, cidade, estado, telefone, email);
                            pjDAO.incluir(pj);
                        }
                        break;

                    case 2:
                        System.out.println("Digite o ID da pessoa:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        if (tipo == 1) {
                            PessoaFisica pf = pfDAO.getPessoa(id);
                            System.out.println("Digite o novo nome:");
                            pf.setNome(scanner.nextLine());
                            System.out.println("Digite o novo CPF:");
                            pf.setCpf(scanner.nextLine());
                            System.out.println("Digite o novo endereço:");
                            pf.setEndereco(scanner.nextLine());
                            System.out.println("Digite a nova cidade:");
                            pf.setCidade(scanner.nextLine());
                            System.out.println("Digite o novo estado:");
                            pf.setEstado(scanner.nextLine());
                            System.out.println("Digite o novo telefone:");
                            pf.setTelefone(scanner.nextLine());
                            System.out.println("Digite o novo email:");
                            pf.setEmail(scanner.nextLine());
                            pfDAO.alterar(pf);
                        } else {
                            PessoaJuridica pj = pjDAO.getPessoa(id);
                            System.out.println("Digite o novo nome:");
                            pj.setNome(scanner.nextLine());
                            System.out.println("Digite o novo CNPJ:");
                            pj.setCnpj(scanner.nextLine());
                            System.out.println("Digite o novo endereço:");
                            pj.setEndereco(scanner.nextLine());
                            System.out.println("Digite a nova cidade:");
                            pj.setCidade(scanner.nextLine());
                            System.out.println("Digite o novo estado:");
                            pj.setEstado(scanner.nextLine());
                            System.out.println("Digite o novo telefone:");
                            pj.setTelefone(scanner.nextLine());
                            System.out.println("Digite o novo email:");
                            pj.setEmail(scanner.nextLine());
                            pjDAO.alterar(pj);
                        }
                        break;

                    case 3:
                        System.out.println("Digite o ID da pessoa:");
                        int idExcluir = scanner.nextInt();
                        scanner.nextLine();
                        if (tipo == 1) {
                            PessoaFisica pf = pfDAO.getPessoa(idExcluir);
                            pfDAO.excluir(pf);
                        } else {
                            PessoaJuridica pj = pjDAO.getPessoa(idExcluir);
                            pjDAO.excluir(pj);
                        }
                        break;

                    case 4:
                        System.out.println("Digite o ID da pessoa:");
                        int idBuscar = scanner.nextInt();
                        scanner.nextLine();
                        if (tipo == 1) {
                            PessoaFisica pf = pfDAO.getPessoa(idBuscar);
                            if (pf != null) {
                                pf.exibir();
                            } else {
                                System.out.println("Pessoa física não encontrada com o ID: " + idBuscar);
                            }
                        } else {
                            PessoaJuridica pj = pjDAO.getPessoa(idBuscar);
                            if (pj != null) {
                                pj.exibir();
                            } else {
                                System.out.println("Pessoa jurídica não encontrada com o ID: " + idBuscar);
                            }
                        }
                        break;

                    case 5:
                        if (tipo == 1) {
                            ArrayList<PessoaFisica> pessoasFisicas = pfDAO.getPessoas();
                            for (PessoaFisica pf : pessoasFisicas) {
                                pf.exibir();
                            }
                        } else {
                            ArrayList<PessoaJuridica> pessoasJuridicas = pjDAO.getPessoas();
                            for (PessoaJuridica pj : pessoasJuridicas) {
                                pj.exibir();
                            }
                        }
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Erro ao realizar operação: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
