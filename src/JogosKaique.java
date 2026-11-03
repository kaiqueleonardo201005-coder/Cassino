import java.util.Random;
import java.util.Scanner;


// ============================================================================
// // Kaique: Jogos de Caça-Níqueis e Roleta sem variáveis private
// ============================================================================
public class JogosKaique {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);


    // // Kaique: Método do Caça-Níqueis
    public void jogarSlots(Usuario usuario) {
        if (usuario.fichas < 50) {
            System.out.println("❌ Saldo insuficiente! Cada giro custa $50.");
            return;
        }


        usuario.removerFichas(50);
        String[] simbolos = {"🍒", "🔔", "💎", "7️⃣"};
        String s1 = simbolos[random.nextInt(simbolos.length)];
        String s2 = simbolos[random.nextInt(simbolos.length)];
        String s3 = simbolos[random.nextInt(simbolos.length)];


        System.out.println("\n🎰 Giro dos Caça-Níqueis: [ " + s1 + " | " + s2 + " | " + s3 + " ]");


        // // Kaique: Estrutura condicional (if/else) para prêmios
        if (s1.equals(s2) && s2.equals(s3)) {
            if (s1.equals("7️⃣")) {
                usuario.adicionarFichas(1000);
                System.out.println("🎉 JACKPOT MÁXIMO (777)! Você ganhou $1.000 fichas!");
            } else {
                usuario.adicionarFichas(500);
                System.out.println("🎉 TRINCA DE SÍMBOLOS! Você ganhou $500 fichas!");
            }
        } else if (s1.equals(s2) || s2.equals(s3) || s1.equals(s3)) {
            usuario.adicionarFichas(100);
            System.out.println("✨ PAR IGUAL! Você ganhou $100 fichas!");
        } else {
            System.out.println("❌ Nenhuma combinação premiada nesta rodada.");
        }
    }


    // // Kaique: Método da Roleta
    public void jogarRoleta(Usuario usuario) {
        System.out.print("Informe o valor da aposta na Roleta: $");
        double aposta = scanner.nextDouble();


        if (aposta <= 0 || aposta > usuario.fichas) {
            System.out.println("❌ Aposta inválida ou saldo insuficiente!");
            return;
        }


        System.out.println("Opções de Aposta na Roleta:");
        System.out.println("1 - Cor (1: Vermelho | 2: Preto) [Paga 2x]");
        System.out.println("2 - Número Exato (0 a 36) [Paga 36x]");
        System.out.print("Escolha o tipo de aposta: ");
        int tipoAposta = scanner.nextInt();


        int numeroSorteado = random.nextInt(37);
        System.out.println("\n🎡 A roleta gira... A bola caiu no número: " + numeroSorteado + "!");


        if (tipoAposta == 1) {
            System.out.print("Aposte na cor (1 para Vermelho, 2 para Preto): ");
            int corEscolhida = scanner.nextInt();
            boolean ehPar = (numeroSorteado % 2 == 0);
            int corSorteada = (ehPar && numeroSorteado != 0) ? 1 : 2;


            if (corEscolhida == corSorteada && numeroSorteado != 0) {
                double ganho = aposta * 2;
                usuario.adicionarFichas(ganho);
                System.out.println("🎉 ACERTOU A COR! Você ganhou $" + ganho + " fichas!");
            } else {
                usuario.removerFichas(aposta);
                System.out.println("❌ Perdeu a aposta da cor.");
            }
        } else if (tipoAposta == 2) {
            System.out.print("Digite o número exato (0 a 36): ");
            int numEscolhido = scanner.nextInt();


            if (numEscolhido == numeroSorteado) {
                double ganho = aposta * 36;
                usuario.adicionarFichas(ganho);
                System.out.println("🎉 INCRÍVEL! Acertou o número exato e ganhou $" + ganho + " fichas!");
            } else {
                usuario.removerFichas(aposta);
                System.out.println("❌ O número sorteado foi diferente. Perdeu a aposta.");
            }
        }
    }
}