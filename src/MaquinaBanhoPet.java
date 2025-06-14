import java.util.Scanner;

public class MaquinaBanhoPet {
    private int nivelAgua; // em litros
    private int nivelShampoo; // em litros
    private boolean temPet;
    private boolean petLimpo;
    private boolean maquinaLimpa;

    // Capacidades máximas
    private static final int CAPACIDADE_MAX_AGUA = 30;
    private static final int CAPACIDADE_MAX_SHAMPOO = 10;

    // Consumos
    private static final int CONSUMO_BANHO_AGUA = 10;
    private static final int CONSUMO_BANHO_SHAMPOO = 2;
    private static final int CONSUMO_LIMPEZA_AGUA = 3;
    private static final int CONSUMO_LIMPEZA_SHAMPOO = 1;

    // Abastecimento
    private static final int QUANTIDADE_ABASTECIMENTO = 2;

    public MaquinaBanhoPet() {
        this.nivelAgua = 0;
        this.nivelShampoo = 0;
        this.temPet = false;
        this.petLimpo = false;
        this.maquinaLimpa = true;
    }

    // Métodos principais

    public void darBanho() {
        if (!temPet) {
            System.out.println("Erro: Não há pet na máquina para dar banho.");
            return;
        }

        if (nivelAgua < CONSUMO_BANHO_AGUA || nivelShampoo < CONSUMO_BANHO_SHAMPOO) {
            System.out.println("Erro: Nível insuficiente de água ou shampoo para dar banho.");
            return;
        }

        // Consumir recursos
        nivelAgua -= CONSUMO_BANHO_AGUA;
        nivelShampoo -= CONSUMO_BANHO_SHAMPOO;

        petLimpo = true;
        maquinaLimpa = false;

        System.out.println("Banho realizado com sucesso! Pet está limpo.");
    }

    public void abastecerAgua() {
        if (nivelAgua + QUANTIDADE_ABASTECIMENTO > CAPACIDADE_MAX_AGUA) {
            System.out.println("Erro: Não é possível abastecer, capacidade máxima de água atingida.");
            return;
        }

        nivelAgua += QUANTIDADE_ABASTECIMENTO;
        System.out.println("Água abastecida. Nível atual: " + nivelAgua + " litros.");
    }

    public void abastecerShampoo() {
        if (nivelShampoo + QUANTIDADE_ABASTECIMENTO > CAPACIDADE_MAX_SHAMPOO) {
            System.out.println("Erro: Não é possível abastecer, capacidade máxima de shampoo atingida.");
            return;
        }

        nivelShampoo += QUANTIDADE_ABASTECIMENTO;
        System.out.println("Shampoo abastecido. Nível atual: " + nivelShampoo + " litros.");
    }

    public void colocarPet() {
        if (temPet) {
            System.out.println("Erro: Já existe um pet na máquina.");
            return;
        }

        if (!maquinaLimpa) {
            System.out.println("Erro: Máquina precisa ser limpa antes de colocar outro pet.");
            return;
        }

        temPet = true;
        petLimpo = false;
        System.out.println("Pet colocado na máquina com sucesso.");
    }

    public void retirarPet() {
        if (!temPet) {
            System.out.println("Erro: Não há pet na máquina para retirar.");
            return;
        }

        if (!petLimpo) {
            System.out.println("Aviso: Pet retirado sem estar limpo. Máquina ficará suja e precisará ser limpa.");
            maquinaLimpa = false;
        }

        temPet = false;
        System.out.println("Pet retirado da máquina.");
    }

    public void limparMaquina() {
        if (temPet) {
            System.out.println("Erro: Não é possível limpar a máquina com pet dentro.");
            return;
        }

        if (maquinaLimpa) {
            System.out.println("Aviso: Máquina já está limpa.");
            return;
        }

        if (nivelAgua < CONSUMO_LIMPEZA_AGUA || nivelShampoo < CONSUMO_LIMPEZA_SHAMPOO) {
            System.out.println("Erro: Nível insuficiente de água ou shampoo para limpeza.");
            return;
        }

        // Consumir recursos para limpeza
        nivelAgua -= CONSUMO_LIMPEZA_AGUA;
        nivelShampoo -= CONSUMO_LIMPEZA_SHAMPOO;

        maquinaLimpa = true;
        System.out.println("Máquina limpa com sucesso.");
    }

    // Métodos de verificação

    public int verificarNivelAgua() {
        return nivelAgua;
    }

    public int verificarNivelShampoo() {
        return nivelShampoo;
    }

    public boolean verificarPetNoBanho() {
        return temPet;
    }

    // Método para exibir status completo
    public void exibirStatus() {
        System.out.println("\n=== Status da Máquina de Banho ===");
        System.out.println("Nível de Água: " + nivelAgua + "/" + CAPACIDADE_MAX_AGUA + " litros");
        System.out.println("Nível de Shampoo: " + nivelShampoo + "/" + CAPACIDADE_MAX_SHAMPOO + " litros");
        System.out.println("Tem pet na máquina: " + (temPet ? "Sim" : "Não"));
        System.out.println("Pet está limpo: " + (petLimpo ? "Sim" : "Não"));
        System.out.println("Máquina está limpa: " + (maquinaLimpa ? "Sim" : "Não"));
        System.out.println("===============================\n");
    }
}