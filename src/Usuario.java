// ============================================================================
// // Enzo: Classe simples com atributos e métodos para gerir o saldo
// ============================================================================
public class Usuario {
    // // Enzo: Atributos diretos do jogador
    String nome;
    double fichas;

    // // Enzo: Construtor para inicializar o perfil do jogador
    public Usuario(String nome, double fichasIniciais) {
        this.nome = nome;
        this.fichas = fichasIniciais;
    }

    // // Enzo: Método para exibir o saldo atual no terminal
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