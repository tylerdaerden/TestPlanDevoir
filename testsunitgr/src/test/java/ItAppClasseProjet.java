import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import devoirs.iramps.testsunitintger.Projet;
import devoirs.iramps.testsunitintger.Pret;

@DisplayName("TestIntegration pour TotalProjetAchat")

public class ItAppClasseProjet {

@Test
@DisplayName("Validation Meilleur Scenario")
public void happypath() {

    Projet projet = new Projet();
    projet.setPrixHabitation(250000.00);
    projet.setRevenuCadastral(746);
    projet.setFraisNotaireAchat(4100.00);
    projet.setFraisTransformation(150000.00);
    projet.calculTVAFraisTransformation();
    projet.calculDroitEnregistrement();
    double totalProjetAchat = projet.calculTotalProjetAchat();
    double apportPersonnel = projet.calculApportMinimal();
    double montantEmprunt = projet.calculResteAEmprunter();
    Pret pret = new Pret();
    pret.setFraisDossierBancaire(500);
    pret.setFraisNotaireCredit(5475.00);
    pret.setNombreAnnees(15);
    pret.setTauxAnnuel(0.04);

    double apportBancaire = pret.calculRestantDu(montantEmprunt);

    Assertions.assertEquals(totalProjetAchat + apportPersonnel + apportBancaire, 312684.99,0.01);



    


}



}
