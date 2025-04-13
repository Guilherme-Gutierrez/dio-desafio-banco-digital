import java.time.LocalDate;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Banco bancoGreen = new Banco("green");

        bancoGreen.criarContaCorrente("Guilherme", "123456789-10", LocalDate.of(2005, 1, 14));

        bancoGreen.criarContaPoupanca("Guilherme", "123456789-10", LocalDate.of(2005, 1, 14));

        Conta cc = bancoGreen.acessarConta("123456789-10", "Corrente");
        Conta poupanca = bancoGreen.acessarConta("123456789-10", "Poupança");

        cc.getCliente().verificarDadosPessoais();

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        System.out.println(bancoGreen.listarContas());
        System.out.println(bancoGreen.listarClientes());
    }
}
