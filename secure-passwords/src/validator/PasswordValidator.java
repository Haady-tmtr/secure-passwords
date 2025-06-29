package validator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    private List<String> passwords;

    public PasswordValidator(String path) {
        this.passwords = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String ligne;
            while ((ligne = reader.readLine()) != null){
                passwords.add(ligne); // je remplie les mots courants dans cette liste
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Erreur de chargement de carte : " + e.getMessage());
        }
    }


    public boolean validate(String password) {
        if (password == null || password.isEmpty()){
            return erreur("Le password est obligatoire, veuillez entrer une mot de passe");

            // Séquences évidentes, via la liste qui contient les mots de passe communs
        } else if (passwords.contains(password)) {
            return erreur("Votre mot de passe est un peu trop commun.");
        }
        // vérification taille
        else if (password.length() < 8 || password.length() > 32) {
            return erreur("La longueur de votre mot de passe doit être comprise entre 8 et 32 caractères.");
        }

        // au moins 1 majuscule
        else if (!password.matches(".*[A-Z].*")) {
            return erreur("Votre mot de passe doit contenir au moins 1 majuscule.");
        }

        // au moins 1 minuscule
        else if (!password.matches(".*[a-z].*")) {
            return erreur("Votre mot de passe doit contenir au moins 1 minuscule.");
        }

        // au moins 1 chiffre
        else if (!password.matches(".*[0-9].*")) {
            return erreur("Votre mot de passe doit contenir au moins 1 chiffre.");
        }

        // au moins 1 caractère spécial donc qui n'est pas maj/min/chiffre.
        else if (!password.matches(".*[^A-Za-z0-9].*")) {
            return erreur("Votre mot de passe doit contenir au moins 1 caractère spécial.");
        }

        // Répétition excessive de caractères, ici 3 caractères identiques consécutifs
        else if (password.matches(".*(\\w)\\1{3,}.*")) {
            return erreur("Répétition excessive détectée");

        } else if (searchSequence(password)) {
            return erreur("Le mot de passe contient une séquence évidente.");
        }

        return true;
    }



    private boolean searchSequence(String password) {
        String[] sequences = {
                "abcdefghijklmnopqrstuvwxyz",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "0123456789"
        };
        for (String seq : sequences) {
            for (int i = 0; i < seq.length() -4 ; i++) {
                String sub = seq.substring(i, i + 4); // extrait 4 caractères
                if (password.contains(sub)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean erreur(String message) {
        System.out.println("Erreur : " + message);
        return false;
    }

}
