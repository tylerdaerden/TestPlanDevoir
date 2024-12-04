package devoirs.iramps.testsunitintger;


public class Projet {
    /*
     * Cette classe couvre l'ensemble des méthodes nécessaires au calcul d'un pret
     * hypothecaire.
     */
    private int revenuCadastral;
    private Double prixHabitation;
    private Double fraisNotaireAchat;
    private Double fraisTransformation; // Aka travaux de rénovation
    private Double fraisDossierBancaire;
    private Double fraisNotaireCredit;
    private int nombreAnnees;
    private Double tauxAnnuel;


    /**
     * Calcule le total à emprunter à la banque pour le projet.
     * 
     * @return double emprunt
     */
    public Double calculResteAEmprunter() {
        return this.calculTotalProjetAchat() -
                this.calculApportMinimal();
    }

    /**
     * Calcule l'apport minimal nécessaire pour le projet d'achat.
     * 
     * @return doube apport minimal
     */
    public Double calculApportMinimal() {
        if(prixHabitation == null || fraisNotaireAchat == null || calculDroitEnregistrement() == null || fraisTransformation == null || calculTVAFraisTransformation() == null )
        {
            throw new IllegalStateException("Cannot proceed with null datas");
        }

        else if(prixHabitation <= 0.00)
        {
            throw new IllegalStateException("HousePrice can't be set to 0 or be negative");
        }
        else
        return 0.10d *
                (this.prixHabitation +
                        this.fraisTransformation +
                        this.calculTVAFraisTransformation())
                +
                this.calculDroitEnregistrement() +
                this.fraisNotaireAchat;
    }

    /**
     * Calcule le coût total du projet d'Achat
     * 
     * @return double total
     */
    public Double calculTotalProjetAchat() {
        if(prixHabitation == null || fraisNotaireAchat == null || calculDroitEnregistrement() == null || fraisTransformation == null || calculTVAFraisTransformation() == null )
        {
            throw new IllegalStateException("Cannot proceed with null datas");
        }

        else if(prixHabitation <= 0.00)
        {
            throw new IllegalStateException("HousePrice can't be set to 0 or be negative");
        }
        else
        return this.prixHabitation +
                this.fraisNotaireAchat +
                this.calculDroitEnregistrement() +
                this.fraisTransformation +
                this.calculTVAFraisTransformation();
    }

    /**
     * Calcule le montant du droit d'enregistrement.
     * 
     * @return double droit d'enregistrement
     */
    public Double calculDroitEnregistrement() {
        float taux = 0.125f;
        if (this.revenuCadastral <= 745) {
            taux = 0.06f;
        }
        return (double) taux * (this.prixHabitation - this.calculAbattement());
    }

    
    /**
     * Calcule le montant total du projet.
     * @param montantEmprunt
     * @return montantTotal
     */
    public Double calculTotalProjet(double montantEmprunt){
        return montantEmprunt +
                this.fraisDossierBancaire +
                this.fraisNotaireCredit +
                this.calculTotalInterets(montantEmprunt);
    }

    /**
     * Calcule l'abattement fiscal possible.
     * 
     * @return double abattement
     */
    public Double calculAbattement() {
        if (this.prixHabitation < 350_000)
            return 40000.00;
        if (this.prixHabitation >= 500_000)
            return 20000.00;
        return 40000 - (20000 * (this.prixHabitation - 350000) / (500000 - 350000));
    }

        /**
     * Calcule le montant total des intérêts payés sur l'emprunt.
     * @return montantInterets
     */
    public Double calculTotalInterets(double montantEmprunt){
        return this.calculMensualites(montantEmprunt) *
                this.getMensualites() -
                montantEmprunt;
    }

        /**
     * Calcule le montant par mensualité suivant le montant emprunté
     * , le nombre de mensualité et le taux annuel.
     * @param montantEmprunt Montant de l'emprunt.
     * @return double montantMensualite
     */
    public Double calculMensualites(double montantEmprunt){
        double tauxPeriodique = this.calculTauxPeriodique();
        int mensualites = this.getMensualites();
        return (montantEmprunt * 
                tauxPeriodique *
                Math.pow(1 + tauxPeriodique , mensualites)
            ) / (
                Math.pow(1 + tauxPeriodique, mensualites) -
                1
            );
    }

        /**
     * Calcule le taux périodique (par mois).
     * @return double tauxPeriodique
     */
    private Double calculTauxPeriodique(){
        return  Math.pow((1 + this.tauxAnnuel), (1.0f / 12.0f)) -1;
    }


    /**
     * Renvoie le nombre de mensualité.
     * @return int mensualite
     */
    private int getMensualites(){
        return nombreAnnees * 12;
    }

    /**
     * Calcule la tva sur les frais de transformation
     * 
     * @return doube TVA
     */
    public Double calculTVAFraisTransformation() {
        return 0.06 * this.fraisTransformation;
    }

    public int getRevenuCadastral() {
        return revenuCadastral;
    }

    public void setRevenuCadastral(int revenuCadastral) {
        this.revenuCadastral = revenuCadastral;
    }

    public Double getPrixHabitation() {
        return prixHabitation;
    }

    public void setPrixHabitation(Double prixHabitation) {
        this.prixHabitation = prixHabitation;
    }

    public Double getFraisNotaireAchat() {
        return fraisNotaireAchat;
    }

    public void setFraisNotaireAchat(Double fraisNotaireAchat) {
        this.fraisNotaireAchat = fraisNotaireAchat;
    }

    public Double getFraisTransformation() {
        return fraisTransformation;
    }

    public void setFraisTransformation(Double fraisTransformation) {
        this.fraisTransformation = fraisTransformation;
    }

}
