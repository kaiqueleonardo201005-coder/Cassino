import java.util.Random;
import java.util.Scanner;

// ============================================================================
// // Murilo: Implementação do jogo da Corrida de Cavalos
// ============================================================================
public class JogosMurilo {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    // // Murilo: Método para simular a corrida de 5 cavalos no terminal
    public void jogarCorridaCavalos(Usuario usuario) {
        System.out.print("Informe o valor da aposta na Corrida: $");
        double aposta = scanner.nextDouble();

        if (aposta <= 0 || aposta > usuario.fichas) {
            System.out.println("❌ Aposta inválida ou saldo insuficiente!");
            return;
        }

        System.out.print("Escolha o cavalo em que deseja apostar (1 a 5): ");
        int cavaloEscolhido = scanner.nextInt();

        if (cavaloEscolhido < 1 || cavaloEscolhido > 5) {
            System.out.println("❌ Cavalo inválido! Escolha entre 1 e 5.");
            return;
        }

        int[] posicoes = new int[5];
        boolean vencedorDefinido = false;
        int cavaloVencedor = 0;

        System.out.println("\n🏁 A CORRIDA COMEÇOU! 🏁");

        // // Murilo: Laço (while) que faz os cavalos avançarem até atingir 10 pontos
        while (!vencedorDefinido) {
            for (int i = 0; i < 5; i++) {
                if (random.nextBoolean()) {
                    posicoes[i]++;
                }

                // // Murilo: Exibição textual da pista de corrida
                System.out.println("Cavalo C" + (i + 1) + ": " + ".".repeat(posicoes[i]) + " 🏇");

                if (posicoes[i] >= 10) {
                    vencedorDefinido = true;
                    cavaloVencedor = i + 1;
                    break;
                }
            }
            System.out.println("----------------------------------------");
            try { Thread.sleep(600); } catch (Exception e) {}
        }

        System.out.println("\n🏆 O Cavalo C" + cavaloVencedor + " CHEGOU EM PRIMEIRO LUGAR!");

        if (cavaloEscolhido == cavaloVencedor) {
            double premio = aposta * 5;
            usuario.adicionarFichas(premio);
            System.out.println("🎉 PARABÉNS! O seu cavalo venceu! Ganhou $" + premio + " fichas!");
        } else {
            usuario.removerFichas(aposta);
            System.out.println("❌ Que pena! O seu cavalo perdeu. Perdeu $" + aposta + " fichas.");
        }
    }
}