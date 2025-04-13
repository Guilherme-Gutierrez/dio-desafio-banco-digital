import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

    public Cliente(String nome, String cpf, LocalDate dataNascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(int ano, int mes, int dia){
        this.dataNascimento = LocalDate.of(ano, mes, dia);
    }

    public void verificarDadosPessoais(){
        System.out.println("======= Dados Pessoais =======");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Data de Nascimento: " + getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("==============================");
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
