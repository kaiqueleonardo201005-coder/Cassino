import java.util.Scanner;

// ============================================================================
// // Otavio: Ponto de entrada (Main), leitura via Scanner e menu principal
// ============================================================================
public class Main {
    public static void main(String[] args) {
        // // Otavio: Instanciação do Scanner para a interação do utilizador
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      🎰 IMPERIAL BET CASINO 🎰");
        System.out.println("==========================================");
        System.out.print("Digite o seu nome para começar: ");
        String nomeJogador = scanner.nextLine();

        // // Otavio: Objeto criado a partir da classe Usuario
        Usuario jogador = new Usuario(nomeJogador, 1000.0);

        // // Otavio: Instanciação das classes de jogos
        JogosKaique jogosKaique = new JogosKaique();
        JogosMurilo jogosMurilo = new JogosMurilo();

        int opcao = -1;

        // // Otavio: Laço (while) do menu principal
        while (opcao != 0 && jogador.fichas > 0) {
            System.out.println("\n------------------------------------------");
            jogador.mostrarSaldo();
            System.out.println("------------------------------------------");
            System.out.println("1. 🎰 Caça-Níqueis ($50 por giro)");
            System.out.println("2. 🏇 Corrida de Cavalos (Paga 5x)");
            System.out.println("0. 🚪 Encerrar e Sair do Cassino");
            System.out.print("Escolha a sua opção: ");

            opcao = scanner.nextInt();

            // // Otavio: Estrutura switch para encaminhar a opção do menu
            switch (opcao) {
                case 1:
                    jogosKaique.jogarSlots(jogador);
                    break;
                case 2:
                    jogosMurilo.jogarCorridaCavalos(jogador);
                    break;
                case 0:
                    System.out.println("\nA sair do cassino...");
                    break;
                default:
                    System.out.println("❌ Opção inválida! Escolha 0, 1 ou 2.");
                    break;
            }
        }

        // // Otavio: Mensagem final e encerramento do jogo
        System.out.println("\n==========================================");
        System.out.println("🏁 SESSÃO ENCERRADA PARA: " + jogador.nome);
        System.out.println("💰 SALDO FINAL: $" + jogador.fichas + " fichas.");
        if (jogador.fichas > 1000) {
            System.out.println("🎉 PARABÉNS! Saiu no LUCRO hoje!");
        } else if (jogador.fichas == 0) {
            System.out.println("💥 Faliu! Mais sorte da próxima vez.");
        } else {
            System.out.println("Obrigado por jogar no Imperial Bet!");
        }
        System.out.println("==========================================");
    }
}