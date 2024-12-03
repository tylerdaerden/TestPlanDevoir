package devoirs.iramps.testsunitintger;


import java.math.BigDecimal;
import java.math.RoundingMode;


public class ConsoleCalculs {


    private static int revenuCadastral;
    private static double prixHabitation;
    private static double fraisNotaireAchat;
    private static double fraisTransformation; // Aka travaux de rénovation


    public static double calculAbattement(double prixHabitation ) {
        if (prixHabitation < 350_000)
            return 40_000;
        if (prixHabitation >= 500_000)
            return 20_000;
        return 40_000 - (20_000 * (prixHabitation - 350_000) / (500_000 - 350_000));
    }


    public static double calculDroitEnregistrement(double revenuCadastral) {
        float taux = 0.125f;
        if (revenuCadastral <= 745) {
            taux = 0.06f;
        }
        double resultat = taux * (prixHabitation - calculAbattement(prixHabitation));
    return new BigDecimal(resultat)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
    }

    public static double calculApportMinimal() {
        return 0.1 *
                (   prixHabitation +
                    fraisTransformation +
                    calculTVAFraisTransformation(fraisTransformation))+
                    calculDroitEnregistrement(revenuCadastral) +
                    fraisNotaireAchat;
    }

    public int getRevenuCadastral() {
        return revenuCadastral;
    }

    // public void setRevenuCadastral(int revenuCadastral) {
    //     revenuCadastral = revenuCadastral;
    // }

    public double getPrixHabitation() {
        return prixHabitation;
    }

    // public void setPrixHabitation(double prixHabitation) {
    //     prixHabitation = prixHabitation;
    // }


    public static double calculTVAFraisTransformation(double fraisTransformation) {
        return 0.06 * fraisTransformation;
    }

    public double getFraisTransformation() {
        return fraisTransformation;
    }

    // public void setFraisTransformation(double fraisTransformation) {
    //     this.fraisTransformation = fraisTransformation;
    // }

    public static double calculTotalProjetAchat() {
        //if(prixHabitation >= 0 && prixHabitation != null ){

            return prixHabitation +
            fraisNotaireAchat +
            calculDroitEnregistrement(revenuCadastral) +
            fraisTransformation +
            calculTVAFraisTransformation(fraisTransformation);
        //}
    }

    public double getFraisNotaireAchat() {
        return fraisNotaireAchat;
    }

    // public void setFraisNotaireAchat(double fraisNotaireAchat) {
    //     fraisNotaireAchat = fraisNotaireAchat;
    // }



    public static void main(String[] args) {

    revenuCadastral = 800;
    prixHabitation = 500001 ; //PH
    fraisNotaireAchat = 11000; //N
    fraisTransformation = 210000; //FT
    System.out.println("\n");
    System.out.println("Revenu Cadastral : " + revenuCadastral);
    System.out.print("PrixHabitation - PH : " + prixHabitation + "\n");
    System.out.println("Frais Fransformations - FT : " + fraisTransformation );
    System.out.println("TVA des Frais Transformation - CT : " + calculTVAFraisTransformation(fraisTransformation) );
    System.out.println("Calcul Droits Enregistrement - CD : " + calculDroitEnregistrement(revenuCadastral));
    System.out.println("FraisNotaireAchat - N : " +fraisNotaireAchat +"\n");

    //System.out.println("Total Projet Achat : " +calculTotalProjetAchat()+"\n");
    System.out.println("CalculApportMinimal : " + calculApportMinimal()+"\n" );
        





    }


}
