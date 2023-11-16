/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeuforme;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author cleme
 */
public class NewClass {

    public static void main(String[] args) throws Exception {
        jeuAventure_menuPrincipal();
    }


    /**
     * Rôle : affiche le menu principal, demande à l'utilisateur à quel jeu il veu jouer et le lance. Si 
     *        l'utilisateur choisi de quitter l'application, lance l'affichage d'un message de fin avec le
     *        nombre de partie(s) jouée(s) et le nombre de partie(s) gagnée(s).
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuAventure_menuPrincipal() {
        int partiesGagnees = 0;
        int partiesJouees = 0;
        int jeu;

        do {
            jeuAventure_afficheMenu();
            System.out.println("Sélectionnez un des jeux ci-dessus :");
            jeu = jeuAventure_saisirNombreIntervalle(1, 5);

            switch (jeu) {
                case 1 :
                    if (jeuDevin_principal()) {
                        partiesGagnees++;
                    }
                    partiesJouees++;
                    break;
                case 2 :
                    if (jeuSuite_principal()) {
                        partiesGagnees++;
                    }
                    partiesJouees++;
                    break;
                case 3 :
                    if (jeuCourse_principal()) {
                        partiesGagnees++;
                    }
                    partiesJouees++;
                    break;
                case 4 :
                    if (jeuTrain_principal()) {
                        partiesGagnees++;
                    }
                    partiesJouees++;
                    break;
                }
        } while (jeu!=5);

        jeuAventure_afficheMessageDeFin(partiesJouees, partiesGagnees);  
    }


    /**
     * Rôle : affiche le menu d'acceuil des mini jeux.
     * Pramètre : aucun
     * Return : aucun 
     */
    static void jeuAventure_afficheMenu() {
        System.out.println("\n           \\\\\\||||||////\n"
                + "            \\\\  ~ ~  //\n"
                + "             (  @ @  )\n"
                + "    ______ oOOo-(_)-oOOo___________\n"
                + "\n"
                + "              \n"
                + "\t (1) le devin " + "\n"
                + "\t (2) trouver la suite " + "\n"
                + "\t (3) la course en ligne " + "\n"
                + "\t (4) le train " + "\n"
                + "\t (5) quitter " + "\n"
                + "\n"
                + "    _____________Oooo._____________\n"
                + "       .oooO     (   )\n"
                + "        (   )     ) /\n"
                + "         \\ (     (_/\n"
                + "          \\_)\n");
    }


    /** 
     * Rôle : affiche un menu de fin sur lequel on peut voir le nombre de parties jouées et de parties gagnées, ainsi que 
     *        "VICTOIRE" si le ratio entre les parties jouées et les victoires est supérieur ou égale à 1, "GAME OVER" sinon.
     * Paramètres : deux entiers, partiesJouees et partieGagnees.
     * Return : aucun
     */
    static void jeuAventure_afficheMessageDeFin(int partiesJouees, int partieGagnees) {
        String resultat;

        if (partieGagnees < partiesJouees) {
            resultat = "GAME OVER";
        } else {
            resultat = "VICTOIRE";
        }

        System.out.println("   .____________________.\n" +
                            "   |.------------------.|\n" +
                            "   ||                  ||\n" +
                            "   ||    " + resultat + "     ||\n" +
                            "   ||Parties jouées: " + partiesJouees + "  ||\n" +
                            "   ||                  ||\n" +
                            "   ||Parties gagnées: " + partieGagnees + " ||\n" +
                            "   ||__________________||\n" +
                            "   /.-.-.-.-.-.-.-.-.-.-\\\n" +
                            "  /.-.-.-.-.-.-.-.-.-.-.-\\\n" +
                            " /.-.-.-.-.-.-.-.-.-.-.-.-\\\n" +
                            "/______/__________\\___o____\\    \n" +
                            "\\__________________________"
                                    + "/");
    }



    /**
     * Rôle : demande à l'utilisateur de choisir un niveau de difficulté et renvoie la saisie.
     * Paramètre : aucun
     * Return : l'entier sélectionné.
     */
    static int jeuAventure_saisirNiveauDifficulte() {
        System.out.println("Veuillez sélectionner un niveau de difficulté entre : 1 et 3");
        return jeuAventure_saisirNombreIntervalle(1,3);
    }


    /**
     * Rôle : permet à l'utilisateur de saisir un entier, le renvoie seulement si celui ci se trouve dans l'intervalle [min;max].
     * Paramètres : min et max, les entiers bornes de l'intervalle.
     * Return : l'entier saisi par l'utilisateur, s'il est correct.
     */
    static int jeuAventure_saisirNombreIntervalle(int min, int max) {
        int n;
        do {
            System.out.println("Saisir un nombre entre " + min + " et " + max + " :");
            n = jeuAventure_saisirNombre();
        } while (n<min || max<n);
        return n;
    }


    /**
     * Rôle : récupère un entier saisi par l'utilisateur et le renvoie.
     * Paramètre : aucun
     * Return : l'entier saisi.
     */
    static int jeuAventure_saisirNombre() {
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        return res;
    }


    /** 
     * Rôle : récupère un caractère saisi par l'utilisateur.
     * Paramètre : aucun
     * Return : le caractère saisi.
     */
    static char jeuAventure_saisirCaractere() {
        Scanner scanner = new Scanner(System.in);
        char res = scanner.nextLine().charAt(0);
        return res;
    }


    // JEU 1 : DEVIN
    
    /**
     * Rôle : affiche les règle du jeu du devin.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuDevin_afficheRegles() {
        System.out.println("\nBienvenue dans le jeu du devin ! \nNiveaux de difficulté disponible : \n"
        + "1 : 5 coups pour trouver un nombre entre 0 et 10. \n"
        + "2 : 10 coups pour trouver un nombre entre 0 et 50. \n"
        + "3 : 10 coups pour trouver un nombre entre 0 et 100. \n");
    }


    /**
     * Rôle : fonction princiaple du jeu du devin, lance l'affichege des règles, lance le jeu selon le niveau de difficulté 
     *        saisi par l'utilisateur et renvoie true si le niveau est réussi, false sinon.
     * Paramètre : aucun
     * Return : un booléen.
     */
    static boolean jeuDevin_principal() {
        jeuDevin_afficheRegles();
        
        int difficulte = jeuAventure_saisirNiveauDifficulte();
        Random random = new Random();
        int valeur;

        switch (difficulte) {
            case 1 :
                valeur = random.nextInt(10);
                break;
            case 2 :
                valeur = random.nextInt(50);
                break;
            default :
                valeur = random.nextInt(100);
        }

        boolean resultat = jeuDevin_joueurChercheValeur(jeuDevin_nbMax(difficulte), jeuDevin_nbCoupsMax(difficulte), valeur);
        if (resultat) {
            System.out.println("Bien joué ! Tu as battu le devin !");
        } else {
            System.out.println("Dommage, c'est perdu.");
        }
        return resultat;
    }


    /**
     * Rôle : dérouyle une partie du jeu du devin en fonction d'une limite entre 0 et laquelle l'utilisateur doit rechercher 
     *        le nombre à trouver, d'un nombre de coups maximum auxquels a droit l'utilisateur, et du nombre à trouver.
     * Paramètres : - nbMax, un entier, la limite de l'intervalle de recherche de l'utilisateur tel que [0,nbMax].
     *              - nbCoupsMax, un entier, soit le nombre de coup auxquels l'utilisateur a droit.
     *              - nombreATrouver, un entier, le nombre solution du jeu.
     * Return : un booléen, vrai si le niveau est réussi, false sinon.
     */
    static boolean jeuDevin_joueurChercheValeur(int nbMax, int nbCoupsMax, int nombreATrouver) {
        int nbCoups = 0;
        boolean resultat = false;

        do {
            System.out.println("******************** \n"
                                + "Vous devez trouver un nombre entre 0 et " + nbMax + ". \n"
                                + "Il reste " + (nbCoupsMax-nbCoups) + " coups à jouer. \n"
                                + "Veuillez saisir un nombre entre : " + 0 + " et " + nbMax);
            int tentative = jeuAventure_saisirNombreIntervalle(0, nbMax);
            if (tentative == nombreATrouver) {
                resultat = true;
                break;
            } else if (tentative < nombreATrouver) {
                System.out.println("Nombre proposé trop petit.");
            } else {
                System.out.println("Nombre proposé trop grand.");
            }
            nbCoups++;
        } while (nbCoups < nbCoupsMax);

         return resultat;
    }


    /**
     * Rôle : renvoie le nombre maximal à chercher pour un niveau de difficulté donné.
     * Paramètre : difficulte, un entier.
     * Return : un entier.
     */
    static int jeuDevin_nbMax(int difficulte) {     
        switch (difficulte) {
            case 2 :
                return 50;
            case 3 :
                return 100;
            default :
                return 10;
        }
    }


    /**
     * Rôle : renvoie le nombre de coups maximum que l'utilisateur peut jouer selon le niveau
     *        de difficulté.
     * Paramètre : difficulte, un entier.
     * Return : un entier.
     */
    static int jeuDevin_nbCoupsMax(int difficulte) {
        switch (difficulte) {
            case 1 :
                return 5;
            default :
                return 10;
        }
    }


    /// JEU 2 : SUITES

    /**
     * Rôle : fonction principale du jeu Suite, lance l'affichage les règles, permet de saisir le niveau de difficulté, de lancer
     *        le jeu et d'afficher les résultats.
     * Paramètre : aucun 
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuSuite_principal() {
        jeuSuite_afficheRegles();
        
        int difficulte = jeuAventure_saisirNiveauDifficulte();         

        boolean resultat = jeuSuite_partie(difficulte);
        if (resultat) {
            System.out.println("Bien joué ! Tu as compléter la suite !");
        } else {
            System.out.println("Dommage, c'est perdu.");
        }
        return resultat;
    }


    /**
     * Rôle : affiche les règles du jeu des suites.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuSuite_afficheRegles() {
        System.out.println("\nBienvenue dans le jeu des suites ! \nLes règles sont simples : "
        + "comprendre la suite logique et indiquer quelle est la prochaine forme. \n");
    }


    /**
     * Rôle : démarre une session de jeu selon le niveau de difficulté passé en paramètre.
     * Paramètre : un entier, le niveau de difficulté
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuSuite_partie(int niveauDifficulte) {
        switch (niveauDifficulte) {
            case 1 :
                jeuSuite_afficheFormes('♣', '♥', '♣', '♥', ' ');
                break;
            case 2 :
                jeuSuite_afficheFormes('♥', '♥', '♣', '♣', ' ');
                break;
            default :
                jeuSuite_afficheFormes('♣', '♥', '♠', '♣', ' ');
        }
        return jeuSuite_saisirForme() == jeuSuite_formeCorrecte(niveauDifficulte);
    }


    /**
     * Rôle : affiche et présente la suite de caractères que l'utilisateur doit compléter.
     * Paramètres : 5 caractères, les qutres premiers de la suite plus un espace vide pour signifier visuellement 
     *              que l'utilisateur doit la compléter.
     * Return : aucun
     */
    static void jeuSuite_afficheFormes(char c1, char c2, char c3, char c4, char c5) {
        System.out.println(" - - - - - \n"
                         + "|" + c1 + "|" + c2 + "|" + c3 + "|" + c4 + "|" + c5 + "|"
                         + "\n - - - - - ");
    }


    /**
     * Rôle : demande à l'utilisateur de saisir un caractère pour compléter la liste.
     * Paramètre : aucun
     * Return : le caractère saisi par l'utilisateur.
     */
    static char jeuSuite_saisirForme() {
       System.out.println("Le symbole manquant, est-ce un (t)rèfle, un (c)oeur ou un (p)ique ?");
       char entree = jeuAventure_saisirCaractere();
       return entree;
    }

    /** 
     * Rôle : renvoie, pour un niveau de difficulté donné, le caractère attendu pour compléter la suite.
     * Paramètre : un entier, le niveau de difficulté.
     * Return : le caractère attendu pour compléter la suite.
     */
    static char jeuSuite_formeCorrecte(int niveauDifficulte) {
        switch (niveauDifficulte) {
            case 2 :
            case 3 :
                return 'c';
            default :
                return 't';
        }
    }


    /// JEU 3 : COURSE

    /** 
     * Rôle : fonction principale du jeu de course, lance l'affchage des règles, lance le jeu et affiche les résultats.
     * Paramètre : aucun
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuCourse_principal() {
        boolean resultat = true;

        jeuCourse_afficheRegles();

        int joueurGagnant = jeuCourse_partie();

        if (joueurGagnant != 1) {
            resultat = false;  
        }
        
        System.out.println("Le joueur " + joueurGagnant + " a remporté la course");
        
        return resultat;
    }


    /** 
     * Rôle : affiche les règles du jeu de course.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuCourse_afficheRegles() {
        System.out.println("\nBienvenue dans le jeu de course ! \n"
                            + "Ce jeu se joue à deux. Le premier joueur qui fait passer la ligne d'arrivée à un courreur gagne. \n"
                            + "A chaque tour, un seul courreur peut être déplacé de 1, 2 ou 3 cases \n"
                            + "Excepté au démarrage, deux courreurs ne peuvent pas se trouver positionnés côte à côte. \n");
    }


    /**
     * Rôle : déroule une course, fait tourner le joueurs à chaque tour et demande au joueur en cours le courreur qu'il 
     *        souhaite déplacer et jusqu'où. Lance également l'actualisation de la piste en fonction des choix de l'utilisateur.
     * Paramètre : aucun
     * Return : un entier, le numéro du joueur ayant remporté la course
     */
    static int jeuCourse_partie() {
        int joueur = 0;
        int posJ1 = 0;
        int posJ2 = 0;
        int posJ3 = 0; 
        int ligne = 0;

        do {
            if ((posJ1 == posJ2 || posJ1 == posJ3 || posJ2 == posJ3) && (posJ1 != 0 && posJ2 != 0 && posJ3 != 0)) {
                System.out.println("Vous ne pouvez pas vous déplacer ici, un autre courreur est déjà en place à ce niveau.");
            } else {
                joueur = jeuCourse_joueurSuivant(joueur);

                jeuCourse_afficheCourse(posJ1,posJ2,posJ3);

                System.out.println("\nJoueur " + joueur + ", à vous de jouer. \n"
                                    + "Sur quelle ligne voulez vous faire avancer un courreur ? (1, 2 ou 3)");
                ligne = jeuAventure_saisirNombreIntervalle(1, 3);
            }
                System.out.println("De combien voulez vous faire avancer votre courreur ?");
            switch (ligne) {
                case (1) :
                    posJ1 += jeuAventure_saisirNombreIntervalle(1, 3);
                    break;
                case (2) :
                    posJ2 += jeuAventure_saisirNombreIntervalle(1, 3);
                    break;
                default :
                    posJ3 += jeuAventure_saisirNombreIntervalle(1, 3);
                    break;
            }
        } while(posJ1!=9 && posJ2!=9 && posJ3!=9);
        return joueur;
    }


    /** 
     * Rôle : passe d'un joueur à l'autre en fonction du joueur en cours passé en paramètre
     * Paramètre : un entier, le numéro du joueur en cours.
     * Return : un entier, le numéro du joueur qui rentre en jeu.
     */
    static int jeuCourse_joueurSuivant(int joueurActif) {
        switch (joueurActif) {
            case 1 :
                return 2;
            default :
                return 1;
        }
    }


    /** 
     * Rôle : affiche la piste de la course, actualisé en fonction du placement des coureurs.
     * Paramètres : 3 entiers, les positions respectives des trois coureurs.
     * Return : aucun
     */
    static void jeuCourse_afficheCourse(int posJ1, int posJ2, int posJ3) {
        System.out.println(" - - - - - - - - - ARRIVEE");
        jeuCourse_afficheLigne(posJ1, '♥');
        jeuCourse_afficheLigne(posJ2, '♣');
        jeuCourse_afficheLigne(posJ3, '♠');
        System.out.println(" - - - - - - - - - ARRIVEE");
    }


    /**
     * Rôle : affiche une ligne de la piste de course, sur laquelle se trouve un coureur, selon son symbole et
     *        sa position récupérée en paramètre.
     * Paramètres : - un entier, position du coureur sur la ligne.
     *              - un caractère, représentant le coureur en question (un coeur, un pmique ou un trèfle).
     * Return : aucun
     */
    static void jeuCourse_afficheLigne(int position, char symbole) {
        for(int i=0; i<=9; i++){
            if(position==i){
                System.out.print("|" + symbole);
            }
            else{
                System.out.print("| ");
            }
        }
        System.out.println();
    }


    /// JEU 4 : TRAIN

    /** 
     * Rôle : fonction principale du jeu du train, gère l'affichage des règles, permet de saisir un niveau de 
     *        difficulté et de lancer le jeu.
     * Paramètre : aucun
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuTrain_principal() {
        jeuTrain_afficheRegles();

        int difficulte = jeuAventure_saisirNiveauDifficulte();

        return jeuTrain_partie(difficulte);
    }


    /**
     * Rôle : affiche les règles du jeu du train.
     * Parmètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheRegles() {
        System.out.println("\nBienvenue dans le jeu du train ! \n"
                            + "Les règles sont simples : comptez les usagers à quai et saisissez le nombre "
                            +"de wagons nécessaires pour les accueillir." );        
    }


    /**
     * Rôle : tire un nombre aléatoire d'usagers en fonction du niveau de difficulté et demande à l'utilisateur de chosir
     *        le nombre de wagons nécessaires. Gère aussi l'affichagedes usagers (smileys), du train, et des résultats.
     * Paramètre : un entier, le niveau de difficulté.
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuTrain_partie(int niveauDifficulte) {
        Random random = new Random();
        boolean resultat = true;
        int usagers;

        switch (niveauDifficulte) {
            case 1 :
                usagers = random.nextInt(1,3);
                break;
            case 2 :
                usagers = random.nextInt(1,4);
                break;
            default :
                usagers = random.nextInt(1,5);
        }   
        
        System.out.println();

        int i = usagers;
        for (; i>0; i--) {
            System.out.print("☺");
        }
        System.out.println("\nVoici le nombre d'usager sur le quais, combien de wagons faut il ajouter ?");

        int wagons = jeuAventure_saisirNombre();
        for (; wagons>0; wagons--) {
            if (wagons > usagers) {
                jeuTrain_afficheWagonVide();
                resultat = false;
            } else {
                jeuTrain_afficheWagonOccupe();
                usagers--;  // si un wagon occupé est afficher, alors un usger est défaussé du quai.
            }
        } 
        jeuTrain_afficheLocomotive();
        
        if (usagers>0) {
            System.out.println("C'est perdu.. . Vous avez laissez " + usagers + " usagers sur le quais !");
            for (; usagers>0; usagers--) {
                System.out.print("☺");
            } 
            resultat = false;
        } else if (!resultat) {
            System.out.println("C'est perdu.. . Vous avez prévu trop de wagons !");  // si un wagon vide a été afficher, resultat vaut déjà false.
        } else {
            System.out.println("C'est gagné ! Vous avez parfaitement remplit le train !");
        }
        return resultat;
    }


    /** 
     * Rôle : affiche un wagon vide du train.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheWagonVide() {
        System.out.println(""
                    + "  —————\n"
                    + "  |   |\n"
                    + "  |   |\n"
                    + "  |   |\n"
                    + "  —————\n"
                    + "    |  "
            );
    }


    /** 
     * Rôle : affiche un wagon occupé du train.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheWagonOccupe() {
        System.out.println(""
                    + "  —————\n"
                    + "  |   |\n"
                    + "  | ☺ |\n"
                    + "  |   |\n"
                    + "  —————\n"
                    + "    |  "
            );
    }


    /** 
     * Rôle : affiche la locomotive du train.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheLocomotive() {
        System.out.println("    |\n"
                + "   |||\n"
                + " .-----.\n"
                + " |o< >o|\n"
                + "//// \\\\\\\\\n"
                + "  /---\\ \n"
                + " /-----\\\n"
        );
    }
}

