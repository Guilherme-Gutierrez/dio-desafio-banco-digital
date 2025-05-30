public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected String tipo;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, String tipo){
        this.tipo = tipo;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public String getTipo(){
        return tipo;
    }

    public int getAgencia(){
        return agencia;
    }

    public int getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public String toString() {
        return "Conta{" +
                "tipo='" + tipo + '\'' +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }
}
