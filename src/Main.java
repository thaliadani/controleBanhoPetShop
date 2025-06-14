import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaquinaBanhoPet maquina = new MaquinaBanhoPet();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU MÁQUINA DE BANHO PETSHOP =====");
            System.out.println("1. Colocar pet na máquina");
            System.out.println("2. Dar banho no pet");
            System.out.println("3. Retirar pet da máquina");
            System.out.println("4. Abastecer água");
            System.out.println("5. Abastecer shampoo");
            System.out.println("6. Limpar máquina");
            System.out.println("7. Verificar níveis");
            System.out.println("8. Verificar se tem pet no banho");
            System.out.println("9. Exibir status completo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    maquina.colocarPet();
                    break;
                case 2:
                    maquina.darBanho();
                    break;
                case 3:
                    maquina.retirarPet();
                    break;
                case 4:
                    maquina.abastecerAgua();
                    break;
                case 5:
                    maquina.abastecerShampoo();
                    break;
                case 6:
                    maquina.limparMaquina();
                    break;
                case 7:
                    System.out.println("Nível de água: " + maquina.verificarNivelAgua() + " litros");
                    System.out.println("Nível de shampoo: " + maquina.verificarNivelShampoo() + " litros");
                    break;
                case 8:
                    System.out.println("Tem pet no banho: " + (maquina.verificarPetNoBanho() ? "Sim" : "Não"));
                    break;
                case 9:
                    maquina.exibirStatus();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            // Pausa para visualização
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }
}