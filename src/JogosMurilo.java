import java.util.Random;
import java.util.Scanner;


// ============================================================================
// // Murilo: Jogos de Blackjack e Corrida de Cavalos
// ============================================================================
public class JogosMurilo {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);


    // // Murilo: Método para o Blackjack
    public void jogarBlackjack(Usuario usuario) {
        System.out.print("Informe o valor da aposta no Blackjack: $");
        double aposta = scanner.nextDouble();


        if (aposta <= 0 || aposta > usuario.fichas) {
            System.out.println("❌ Aposta inválida ou saldo insuficiente!");
            return;
        }


        int jogadorPontos = random.nextInt(10) + 2 + random.nextInt(10) + 2;
        int mesaPontos = random.nextInt(10) + 2;


        System.out.println("\n🃏 Suas cartas somam: " + jogadorPontos + " pontos.");
        System.out.println("🃏 A carta visível da mesa é: " + mesaPontos + " pontos.");


        System.out.print("Deseja (1) Comprar mais uma carta ou (2) Parar? ");
        int decisao = scanner.nextInt();


        if (decisao == 1) {
            int novaCarta = random.nextInt(10) + 1;
            jogadorPontos += novaCarta;
            System.out.println("🃏 Você tirou um " + novaCarta + ". Total: " + jogadorPontos + " pontos.");
        }


        while (mesaPontos < 17) {
            mesaPontos += random.nextInt(10) + 1;
        }


        System.out.println("Mesa finalizou com: " + mesaPontos + " pontos.");


        if (jogadorPontos > 21) {
            usuario.removerFichas(aposta);
            System.out.println("💥 Você estourou 21! Perdeu $" + aposta + " fichas.");
        } else if (mesaPontos > 21 || jogadorPontos > mesaPontos) {
            usuario.adicionarFichas(aposta);
            System.out.println("🎉 PARABÉNS! Você venceu a mesa e ganhou $" + aposta + " fichas!");
        } else if (jogadorPontos == mesaPontos) {
            System.out.println("🤝 Empate! Sua aposta foi devolvida.");
        } else {
            usuario.removerFichas(aposta);
            System.out.println("❌ A mesa venceu. Você perdeu $" + aposta + " fichas.");
        }
    }


    // // Murilo: Método da Corrida de Cavalos
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


        // // Murilo: Laço (while) que executa a simulação rodada por rodada
        while (!vencedorDefinido) {
            for (int i = 0; i < 5; i++) {
                if (random.nextBoolean()) {
                    posicoes[i]++;
                }


                System.out.println("Cavalo C" + (i + 1) + ": " + ".".repeat(posicoes[i]) + " 🏇");


                if (posicoes[i] >= 5) {
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
            System.out.println("🎉 PARABÉNS! Seu cavalo venceu! Você ganhou $" + premio + " fichas!");
        } else {
            usuario.removerFichas(aposta);
            System.out.println("❌ Que pena! Seu cavalo perdeu. Você perdeu $" + aposta + " fichas.");
        }
    }
 }