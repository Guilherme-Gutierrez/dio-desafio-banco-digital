import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;

    private List<Conta> contas;

    private List<Cliente> clientes;

    public Banco(String nome){
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public List<Conta> listarContas(){
        return contas;
    }

    private void adicionarConta(Conta conta){
        this.contas.add(conta);
    }

    public List<Cliente> listarClientes(){
        return clientes;
    }

    private void adicionarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void criarContaCorrente(String nome, String cpf, LocalDate dataNascimento){
        Cliente cliente;
        if(clientes.stream().anyMatch(c -> c.getCpf().equals(cpf))){
            cliente = clientes.stream().filter(c -> c.getCpf().equals(cpf)).toList().get(0);
        } else {
            cliente = new Cliente(nome, cpf, dataNascimento);
            adicionarCliente(cliente);
        }
        Conta contaCorrente = new ContaCorrente(cliente);
        adicionarConta(contaCorrente);
    }

    public void criarContaPoupanca(String nome, String cpf, LocalDate dataNascimento){
        Cliente cliente;
        if(clientes.stream().anyMatch(c -> c.getCpf().equals(cpf))){
            cliente = clientes.stream().filter(c -> c.getCpf().equals(cpf)).toList().get(0);
        } else {
            cliente = new Cliente(nome, cpf, dataNascimento);
            adicionarCliente(cliente);
        }
        Conta contaPoupanca = new ContaPoupanca(cliente);
        adicionarConta(contaPoupanca);
    }

    public Conta acessarConta(String cpf, String tipo){
        Conta contaRequerida = null;
        for(Conta c : contas){
            if(c.getCliente().getCpf().equals(cpf) && c.getTipo().equals(tipo)){
                contaRequerida = c;
            }
        }
        if(contaRequerida != null){
            return contaRequerida;
        } else {
            throw new RuntimeException("Conta não encontrada");
        }
    }
}