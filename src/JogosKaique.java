import java.util.Random;

// ============================================================================
// // Kaique: Implementação do jogo Caça-Níqueis (Slots)
// ============================================================================
public class JogosKaique {
    Random random = new Random();

    // // Kaique: Método que executa a rodada do Caça-Níqueis ($50 por giro)
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

        // // Kaique: Estruturas condicionais (if/else) para premiar o jogador
        if (s1.equals(s2) && s2.equals(s3)) {
            if (s1.equals("7️⃣")) {
                usuario.adicionarFichas(1000);
                System.out.println("🎉 JACKPOT MÁXIMO (777)! Ganhou $1.000 fichas!");
            } else {
                usuario.adicionarFichas(500);
                System.out.println("🎉 TRINCA DE SÍMBOLOS! Ganhou $500 fichas!");
            }
        } else if (s1.equals(s2) || s2.equals(s3) || s1.equals(s3)) {
            usuario.adicionarFichas(100);
            System.out.println("✨ PAR IGUAL! Ganhou $100 fichas!");
        } else {
            System.out.println("❌ Nenhuma combinação premiada nesta rodada.");
        }
    }
}