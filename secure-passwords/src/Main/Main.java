package Main;

import validator.PasswordValidator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator("src/resources/common_passwords.txt");
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenu dans notre Vérificateur de Mot de Passe Sécurisé avec Détection de Parties Mémorisables : \n ");
        System.out.println("========================" + "\n" +
                "VéRiPass" + "\n" +
        "========================");

        boolean reesaye = true;

        while (reesaye) {
            System.out.println("Entrez un mot de passe :");
            String password = "";
            if (sc.hasNextLine()) {
                password = sc.nextLine();
            }

            boolean check = validator.validate(password);

            if (!check) {
                System.out.println("Voulez vous réessayer ? \n Oui/Non");
                String response = "";
                if (sc.hasNextLine()) {
                    response = sc.nextLine();
                }

                if (response.equalsIgnoreCase("non")) {
                    reesaye = false;
                }
            } else {
                System.out.println("Votre mot de passe est sécure ! Félicitations");
                break;
            }
        }

        sc.close();
    }
}
