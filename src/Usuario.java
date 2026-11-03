// ============================================================================
// // Enzo: Classe simples com atributos sem private e métodos de saldo
// ============================================================================
public class Usuario {
    // // Enzo: Atributos diretos
    String nome;
    double fichas;


    // // Enzo: Construtor para inicializar o jogador
    public Usuario(String nome, double fichasIniciais) {
        this.nome = nome;
        this.fichas = fichasIniciais;
    }


    // // Enzo: Método para exibir o saldo atual
    public void mostrarSaldo() {
        System.out.println("👤 Jogador: " + this.nome + " | Saldo Atual: $" + this.fichas + " fichas");
    }


    // // Enzo: Método para adicionar fichas ao saldo
    public void adicionarFichas(double quantidade) {
        this.fichas = this.fichas + quantidade;
    }


    // // Enzo: Método para remover fichas do saldo
    public void removerFichas(double quantidade) {
        this.fichas = this.fichas - quantidade;
    }
}