import java.util.Scanner;


// ============================================================================
// // Otavio: Instanciação dos objetos, Scanner e loop principal do programa
// ============================================================================
public class Main {
    public static void main(String[] args) {
        // // Otavio: Scanner para o público interagir no terminal (requisito essencial)
        Scanner scanner = new Scanner(System.in);


        System.out.println("==========================================");
        System.out.println("  🎰 BEM-VINDO AO GRAND LUXE CASINO 🎰");
        System.out.println("==========================================");
        System.out.print("Digite o seu nome para começar: ");
        String nomeJogador = scanner.nextLine();


        // // Otavio: Objeto criado da classe Usuario
        Usuario jogador = new Usuario(nomeJogador, 1000.0);


        // // Otavio: Instanciação dos objetos de jogos
        JogosKaique jogosKaique = new JogosKaique();
        JogosMurilo jogosMurilo = new JogosMurilo();


        int opcao = -1;


        // // Otavio: Laço (while) do menu principal
        while (opcao != 0 && jogador.fichas > 0) {
            System.out.println("\n------------------------------------------");
            jogador.mostrarSaldo();
            System.out.println("------------------------------------------");
            System.out.println("1. 🃏 Blackjack (21)");
            System.out.println("2. 🎡 Roleta Americana");
            System.out.println("3. 🎰 Caça-Níqueis ($50)");
            System.out.println("4. 🏇 Corrida de Cavalos (5x)");
            System.out.println("0. 🚪 Encerrar e Sair do Cassino");
            System.out.print("Escolha a sua opção: ");


            opcao = scanner.nextInt();


            // // Otavio: Controle de fluxo com switch
            switch (opcao) {
                case 1:
                    jogosMurilo.jogarBlackjack(jogador);
                    break;
                case 2:
                    jogosKaique.jogarRoleta(jogador);
                    break;
                case 3:
                    jogosKaique.jogarSlots(jogador);
                    break;
                case 4:
                    jogosMurilo.jogarCorridaCavalos(jogador);
                    break;
                case 0:
                    System.out.println("\nSaindo do cassino...");
                    break;
                default:
                    System.out.println("❌ Opção inválida! Escolha um número de 0 a 4.");
                    break;
            }
        }


        // // Otavio: Encerramento do programa com mensagem de resultado
        System.out.println("\n==========================================");
        System.out.println("🏁 SESSÃO ENCERRADA PARA: " + jogador.nome);
        System.out.println("💰 SALDO FINAL: $" + jogador.fichas + " fichas.");
        if (jogador.fichas > 1000) {
            System.out.println("🎉 PARABÉNS! Você saiu no LUCRO hoje!");
        } else if (jogador.fichas == 0) {
            System.out.println("💥 Você faliu! Mais sorte da próxima vez.");
        } else {
            System.out.println("Obrigado por jogar no Grand Luxe Casino!");
        }
        System.out.println("==========================================");
    }
}