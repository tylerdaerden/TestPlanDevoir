

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import devoirs.iramps.testsunitintger.Projet;


@DisplayName("Test de la classe Projet")

public class TestClasseProjet {

    private static Projet mockedProjet;
    private static Projet projet;

    @BeforeAll

    static void setup(){
        TestClasseProjet.projet = new Projet();
        TestClasseProjet.mockedProjet=Mockito.spy(projet);
    }


    @Nested
    @DisplayName("Calcul de Total Projet Achat et Calcul Apport Minimal")
    public class calcul{

        @Test
        @DisplayName("calculTotalProjetAchatHabitation250K")
        public void calculTotalProjetAchatHabitation250K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(250000.00);
                mockedProjet.setFraisNotaireAchat(4100.00);
                Mockito.doReturn(12600.00).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisTransformation(15000.00);
                Mockito.doReturn(900.00).when(mockedProjet).calculTVAFraisTransformation();
                Assertions.assertEquals(282600.00, mockedProjet.calculTotalProjetAchat());
            } );
        }

        @Test
        @DisplayName("calculTotalProjetAchatHabitation600K")
        public void calculTotalProjetAchatHabitation600K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(600000.00);
                mockedProjet.setFraisNotaireAchat(12000.00);
                Mockito.doReturn(72500.00).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisTransformation(50000.00);
                Mockito.doReturn(3000.00).when(mockedProjet).calculTVAFraisTransformation();
                Assertions.assertEquals(737500.00, mockedProjet.calculTotalProjetAchat());
            } );
        }

        @Test
        @DisplayName("calculTotalProjetAchatHabitation100K")
        public void calculTotalProjetAchatHabitation100K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(100000.00);
                mockedProjet.setFraisNotaireAchat(2000.00);
                Mockito.doReturn(3600.00).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisTransformation(150000.00);
                Mockito.doReturn(9000.00).when(mockedProjet).calculTVAFraisTransformation();
                Assertions.assertEquals(264600.00, mockedProjet.calculTotalProjetAchat());
            } );
        }   

        @Test
        @DisplayName("calculTotalProjetAchatHabitation349K")
        public void calculTotalProjetAchatHabitation349K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(349999.00);
                mockedProjet.setFraisNotaireAchat(6080.00);
                Mockito.doReturn(18599.94).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisTransformation(80000.00);
                Mockito.doReturn(4800.00).when(mockedProjet).calculTVAFraisTransformation();
                Assertions.assertEquals(459478.94, mockedProjet.calculTotalProjetAchat());
            } );
        }

        @Test
        @DisplayName("calculTotalProjetAchatHabitation351K")
        public void calculTotalProjetAchatHabitation351K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(350001.00);
                mockedProjet.setFraisNotaireAchat(7500.00);
                Mockito.doReturn(38750.14).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisTransformation(150000.00);
                Mockito.doReturn(9000.00).when(mockedProjet).calculTVAFraisTransformation();
                Assertions.assertEquals(555251.14, mockedProjet.calculTotalProjetAchat());
            } );
        }

        @Test
        @DisplayName("calculTotalProjetAchatHabitation499K")
        public void calculTotalProjetAchatHabitation499K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(499999.00);
                mockedProjet.setFraisNotaireAchat(10050.00);
                Mockito.doReturn(59999.86).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisTransformation(170000.00);
                Mockito.doReturn(10200.00).when(mockedProjet).calculTVAFraisTransformation();
                Assertions.assertEquals(750248.86, mockedProjet.calculTotalProjetAchat());
            } );
        }

        @Test
        @DisplayName("calculTotalProjetAchatHabitation501K")
        public void calculTotalProjetAchatHabitation501K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(500001.00);
                mockedProjet.setFraisNotaireAchat(11000.00);
                Mockito.doReturn(60000.13).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisTransformation(210000.00);
                Mockito.doReturn(12600.00).when(mockedProjet).calculTVAFraisTransformation();
                Assertions.assertEquals(793601.13, mockedProjet.calculTotalProjetAchat());
            } );
        }

        
        @Test
        @DisplayName("calculTotalProjetAchatHabitationZERO")
        public void calculTotalProjetAchatHabitationZERO() {
            // Configurer les données pour forcer l'exception
            mockedProjet.setPrixHabitation(0.0);
            mockedProjet.setFraisNotaireAchat(1.0);
            Mockito.doReturn(1.0).when(mockedProjet).calculDroitEnregistrement();
            mockedProjet.setFraisTransformation(1.0);
            Mockito.doReturn(1.0).when(mockedProjet).calculTVAFraisTransformation();
            
            // Vérifier que l'exception est levée
            IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
                mockedProjet.calculTotalProjetAchat();
            });
            
            // Vérifier le message de l'exception
            Assertions.assertEquals("HousePrice can't be set to 0 or be negative", exception.getMessage());
        }
        
        @Test
        @DisplayName("calculTotalProjetAchatHabitationNegative")
        public void calculTotalProjetAchatHabitationNegative() {
            // Configurer les données pour forcer l'exception
            mockedProjet.setPrixHabitation(-10.00);
            mockedProjet.setFraisNotaireAchat(1.0);
            Mockito.doReturn(1.0).when(mockedProjet).calculDroitEnregistrement();
            mockedProjet.setFraisTransformation(1.0);
            Mockito.doReturn(1.0).when(mockedProjet).calculTVAFraisTransformation();
            
            // Vérifier que l'exception est levée
            IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
                mockedProjet.calculTotalProjetAchat();
            });
            
            // Vérifier le message de l'exception
            Assertions.assertEquals("HousePrice can't be set to 0 or be negative", exception.getMessage());
        }

        @Test
        @DisplayName("calculTotalProjetAchatHabitationNULL")
        public void calculTotalProjetAchatHabitationNULL() {
            // Configurer les données pour forcer l'exception
            mockedProjet.setPrixHabitation(null);
            mockedProjet.setFraisNotaireAchat(null);
            Mockito.doReturn(null).when(mockedProjet).calculDroitEnregistrement();
            mockedProjet.setFraisTransformation(null);
            Mockito.doReturn(null).when(mockedProjet).calculTVAFraisTransformation();
        
            // Vérifier que l'exception est levée
            IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
                mockedProjet.calculTotalProjetAchat();
            });
        
            // Vérifier le message de l'exception
            Assertions.assertEquals("Cannot proceed with null datas", exception.getMessage());
        }
        

        @Test
        @DisplayName("calculApportMinimalHabitation250K")
        public void calculApportMinimalHabitation250K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(250000.00);
                mockedProjet.setFraisTransformation(15000.00);
                Mockito.doReturn(900.00).when(mockedProjet).calculTVAFraisTransformation();
                Mockito.doReturn(12600.00).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisNotaireAchat(4100.00);
                Assertions.assertEquals(43290.00, mockedProjet.calculApportMinimal());
            } );
        }

        @Test
        @DisplayName("calculApportMinimalHabitation600K")
        public void calculApportMinimalHabitation600K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(600000.00);
                mockedProjet.setFraisTransformation(50000.00);
                Mockito.doReturn(3000.00).when(mockedProjet).calculTVAFraisTransformation();
                Mockito.doReturn(72500.00).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisNotaireAchat(12000.00);
                Assertions.assertEquals(149800.00, mockedProjet.calculApportMinimal());
            } );
        }

        @Test
        @DisplayName("calculApportMinimalHabitation100K")
        public void calculApportMinimalHabitation100K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(100000.00);
                mockedProjet.setFraisTransformation(150000.00);
                Mockito.doReturn(9000.00).when(mockedProjet).calculTVAFraisTransformation();
                Mockito.doReturn(3600.00).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisNotaireAchat(2000.00);
                Assertions.assertEquals(31500.00, mockedProjet.calculApportMinimal());
            } );
        }

        @Test
        @DisplayName("calculApportMinimalHabitation349K")
        public void calculApportMinimalHabitation349K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(349999.00);
                mockedProjet.setFraisTransformation(80000.00);
                Mockito.doReturn(4800.00).when(mockedProjet).calculTVAFraisTransformation();
                Mockito.doReturn(18599.94).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisNotaireAchat(6080.00);
                Assertions.assertEquals(68159.84, mockedProjet.calculApportMinimal());
            } );
        }

        @Test
        @DisplayName("calculApportMinimalHabitation351K")
        public void calculApportMinimalHabitation351K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(350001.00);
                mockedProjet.setFraisTransformation(15000.00);
                Mockito.doReturn(9000.00).when(mockedProjet).calculTVAFraisTransformation();
                Mockito.doReturn(38750.14).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisNotaireAchat(7500.00);
                Assertions.assertEquals(83650.23999999999, mockedProjet.calculApportMinimal());
            } );
        }

        @Test
        @DisplayName("calculApportMinimalHabitation499K")
        public void calculApportMinimalHabitation499K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(499999.00);
                mockedProjet.setFraisTransformation(170000.00);
                Mockito.doReturn(10200.00).when(mockedProjet).calculTVAFraisTransformation();
                Mockito.doReturn(59999.86).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisNotaireAchat(10050.00);
                Assertions.assertEquals(138069.76, mockedProjet.calculApportMinimal());
            } );
        }

        @Test
        @DisplayName("calculApportMinimalHabitation501K")
        public void calculApportMinimalHabitation501K(){
            Assertions.assertAll( () -> {
                mockedProjet.setPrixHabitation(500001.00);
                mockedProjet.setFraisTransformation(210000.00);
                Mockito.doReturn(12600.00).when(mockedProjet).calculTVAFraisTransformation();
                Mockito.doReturn(60000.13).when(mockedProjet).calculDroitEnregistrement();
                mockedProjet.setFraisNotaireAchat(11000.00);
                Assertions.assertEquals(143260.23, mockedProjet.calculApportMinimal());
            } );
        }

        @Test
        @DisplayName("calculApportMinimalHabitationZERO")
        public void calculApportMinimalHabitationZEROK(){
            // Configurer les données pour forcer l'exception
            mockedProjet.setPrixHabitation(0.0);
            mockedProjet.setFraisTransformation(1.0);
            Mockito.doReturn(1.0).when(mockedProjet).calculTVAFraisTransformation();
            Mockito.doReturn(1.0).when(mockedProjet).calculDroitEnregistrement();
            mockedProjet.setFraisNotaireAchat(1.0);
            
            // Vérifier que l'exception est levée
            IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
                mockedProjet.calculTotalProjetAchat();
            });
            
            // Vérifier le message de l'exception
            Assertions.assertEquals("HousePrice can't be set to 0 or be negative", exception.getMessage());
        }

        @Test
        @DisplayName("calculApportMinimalHabitationNEGATIVE")
        public void calculApportMinimalHabitationNEGATIVE(){
            // Configurer les données pour forcer l'exception
            mockedProjet.setPrixHabitation(-10.0);
            mockedProjet.setFraisTransformation(1.0);
            Mockito.doReturn(1.0).when(mockedProjet).calculTVAFraisTransformation();
            Mockito.doReturn(1.0).when(mockedProjet).calculDroitEnregistrement();
            mockedProjet.setFraisNotaireAchat(1.0);
            
            // Vérifier que l'exception est levée
            IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
                mockedProjet.calculTotalProjetAchat();
            });
            
            // Vérifier le message de l'exception
            Assertions.assertEquals("HousePrice can't be set to 0 or be negative", exception.getMessage());
        }

        @Test
        @DisplayName("calculApportMinimalHabitationNULL")
        public void calculApportMinimalHabitationNULL(){
            // Configurer les données pour forcer l'exception
            mockedProjet.setPrixHabitation(null);
            mockedProjet.setFraisTransformation(1.0);
            Mockito.doReturn(1.0).when(mockedProjet).calculTVAFraisTransformation();
            Mockito.doReturn(1.0).when(mockedProjet).calculDroitEnregistrement();
            mockedProjet.setFraisNotaireAchat(1.0);
            
            // Vérifier que l'exception est levée
            IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
                mockedProjet.calculTotalProjetAchat();
            });
            
            // Vérifier le message de l'exception
            Assertions.assertEquals("Cannot proceed with null datas", exception.getMessage());
        }
        
        





    }



}
