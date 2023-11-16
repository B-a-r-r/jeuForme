package jeuforme;
import java.util.Scanner; 

/**
 *
 * @author clbarriere
 */

public class JeuForme {

    public static void main(String[] args) {        
        jeuForme();
    }
    
    
    // LES LANCEURS
        
        
        static void jeuForme() {

            /** 
             * Rôle : fonction principale du programme. Permet d'initier le jeu et de géner les affichages grâce
             *        à l'embriquement des fonctions.
             * Paramètre : aucun
             * Return : aucun
            */

            messageAccueil();
            int n = saisirNombreValide(1,5);
            messageFinDeJeu(jouerUnNiveau(n), n);
        }
        
        
        static boolean jouerUnNiveau(int n) {

            /**
             * Rôle : Permet de jouer au niveau dont la valeur est passé en paramètre.
             * Paramètre : un entier n, numéro du niveau.
             * Return : un booléen, vrai si le niveau est réussi, faux sinon.
            */


            if (n != -1) {
                if (n==5) {
                    return modeDessinMaison();
                } else {
                    afficherFormeNiveau(n);
                } if (saisieReponseForme() == formeCorrecte(n)) {
                    return (saisieReponseSurface() == surfaceCorrecte(n));
                }
            }  
            return false;
        }


        static boolean modeDessinMaison() {

            /**
             * Rôle : un niveau secret qui affiche une maison en fonction de caractéristiques saisies 
             *        par l'utilisateur, comme les caractères à afficher, le nombre de fenêtres ou encore
             *        l'emplacement de la porte.
             * Paramètre : aucun
             * Return : aucun
             */

            System.out.println("~~ Mode dessin maison ~~");

            System.out.println(" ~ Combien de fenêtres (3 à 5) ?");
            int fenetres = saisirNombreValide(3,5);

            if (fenetres != -1) {

                System.out.println(" ~ Porte sous quelle fenêtre (1 à 3) ?");
                int placePorte = saisirNombreValide(1,3);
                
                if (placePorte != -1) {

                    System.out.println(" ~ Caractère du toit :");
                    char toit = saisirCaractere();

                    System.out.println(" ~ Caractère des murs :");
                    char murs = saisirCaractere();

                    System.out.println(" ~ Caractère des volets :");
                    char volets = saisirCaractere();
                    
                    afficheToit(toit, (fenetres*5)+1);
                    afficheLigne(murs, 1, (fenetres*5)+1);
                    afficheFenetres(fenetres, volets, murs);
                    afficheLigne(murs, 1, (fenetres*5)+1);
                    afficheMursEtPorte(fenetres, placePorte, murs);

                    return true;
                 }
            } else {
                messageErreur();
            }
            return false;
        }


        // LES VERIFICATEURS

        static int surfaceCorrecte(int n) {

            /**
             * Rôle : renvoie la surface correcte associée à la forme affichée dans un niveau donné.
             * Paramètre : un entier n, numéro du niveau en question.
             * Return : un entier, la surface de la forme du niveau n.
            */

            if (n==1) {
                return 9;
            } else if (n==2) {
                return 25;
            } else if (n==3) {
                return 3;
            }
            return 14;  // par conséquent, si n==4.
            }


        static char formeCorrecte(int n) {

            /** 
             * Rôle : renvoie 'c' ou 't' suivant que la forme affichée dans le niveau n soit
             *        un carré ou un triangle.
             * Paramètre : un entier n, le numéro du niveau en question.
             * Return : un caractère, initiale de la forme correcte.
            */

            if (n==1 || n==2) {
                return 'c';
            }     
            return 't';  // par conséquent, si n==3 ou n==4. 
        }


        static int saisirNombreValide(int min, int max) {
            
            /**
             * Rôle : renvoit l'entier saisie par l'utilisateur, seulement si il est présent dans l'interval 
             *        [min;max] passé en paramètre.
             * Paramètre : deux entiers, min et max, bornes de l'interval valide.
             * Return : l'entier saisie par l'utilisateur s'il est dans l'interval, -1 sinon.
             */
            
            if (min==1 && max==5) { 
                System.out.println("Saisir un niveau de difficulté entre 1 et 4");
                /* permet de n'afficher ce message que lors de la sélection du niveau, cet évenement étant 
                   reconnaissable par la selection unique de l'interval [1;5] dans le programme */   
            }

            int n = saisirNombre();

            if (n>=min && n<=max) {
                return n;
            }
            return -1;
        }


        // LES AFFICHEURS

        static void messageFinDeJeu(boolean niveauReussi, int n) {

            /** 
             * Rôle : affiche un message de réussite ou un message d'échec selon la valeur du booléen niveauReussi;
             *        peut également afficher un message d'erreur si le paramètre n vaut -1 (c'est à dire si l'entier
             *        saisie pour indiquer le niveau n'est pas valide).
             * Paramètre : un booléen niveauReussi, true si le niveau est réussi, false sinon;
                           un entier n, numéro du niveau en question.
             * Return : aucun
            */
            
            if (n != -1) {
                if (niveauReussi) {
                    System.out.println("Bravo, vous avez validé le niveau " + n + ".");
                } else {
                    System.out.println("Vous avez échoué au niveau " + n + ".");
                }
            } else {
                messageErreur();
            } 
        }


        static void messageAccueil() {

            /** 
             * Rôle : affiche un message d'accueil au début du jeu.
             * Paramètre : aucun
             * Return : aucun
            */

            System.out.println("Bienvenue dans le programme de révision des formes géométriques");
        }


        static void messageErreur() {

            /** 
             * Rôle : affiche un message d'erreur si l'utilisateur saisie une valeur non-valide.
             * Paramètre : aucun
             * Return : aucun
            */

            System.out.println("Votre choix n'est pas conforme aux options possibles, jeu terminé.");
        }


        static void afficherFormeNiveau(int n) {

            /** 
             * Rôle : affiche la forme correspondante au niveau n.
             * Paramètre : un entier n, le numéro du niveau en question.
             * Return : aucun
            */

            if (n==1) {
                afficheLigne('#', 0, 3);
                afficheLigne('#', 0, 3);
                afficheLigne('#', 0, 3);

            } else if (n==2) {
                afficheLigne('#', 0, 5);
                afficheLigne('#', 0, 5);
                afficheLigne('#', 0, 5);
                afficheLigne('#', 0, 5);
                afficheLigne('#', 0, 5);

            } else if (n==3) {
                afficheLigne('#', 1, 1);
                afficheLigne('#', 0, 2);
                
            } else if (n==4) {
                afficheLigne('#', 3, 1);
                afficheLigne('#', 2, 3);
                afficheLigne('#', 1, 5);
                afficheLigne('#', 0, 7);
            }
        }
        
        
        static void afficheLigne(char car, int min, int taille) {

            /**
             * Rôle : affiche sur une même ligne le caractère car passé en paramètre taille fois, 
             *        éloigné de min espace du début de la ligne.
             * Paramètres : car, le caractère à afficher.
             *              un entier min, le nombre d'espace à précéder de l'affichage du caractère.
             *              un entier taille, le nombre de fois que l'on affiche le caractère.
             * Return : aucun
             */

            afficheCar(' ', min);
            afficheCar(car, taille);
            System.out.println("");
        }
        
        
        static void afficheCar(char car, int taille) {

            /**
             * Rôle : affiche sur une même ligne taille fois le caractère car passé en paramètre.
             * Paramètres : car, le caractère à afficher.
             *              un entier taille, le nombre de fois que l'on affiche car
             * Return : aucun
             */

            for (int i = 1; i <= taille; i++) {
                System.out.print(car);
            }
        }


        static void afficheToit(char toit, int longueur) {

            /**
             * Rôle : affiche le toit de la maison du niveau 5.
             * Paramètres : car, le caractère q'ue l'on utilise pour construire le toit.
             *              un entier longueur, la longueur du toit (en fonction du nombre de fenetres de la maison).
             * Return : aucun.
             */

             afficheLigne(toit, 2, longueur-2);
             afficheLigne(toit, 1, longueur);
             afficheLigne(toit, 0, longueur+2);

        }


        static void afficheFenetres(int nb, char volets, char murs) {

            /**
             * Rôle : affiche nb fenêtres sur la maison du niveau 5.
             * Paramètres : un entier nb, le nombre de fenêtre sur la maison.
             *              volets, le caractère symbolisant les volets.
             *              murs, le caractère symbolysant les murs.
             * Return : aucun.
             */

            afficheCar(' ', 1);

            afficheCar(murs, 1);
            afficheCar(volets, 1);
            afficheCar(' ', 2);
            afficheCar(volets, 1);

            afficheCar(murs, 1);
            afficheCar(volets, 1);
            afficheCar(' ', 2);
            afficheCar(volets, 1);

            afficheCar(murs, 1);
            afficheCar(volets, 1);
            afficheCar(' ', 2);
            afficheCar(volets, 1);

            if (nb>3) {
                afficheCar(murs, 1);
                afficheCar(volets, 1);
                afficheCar(' ', 2);
                afficheCar(volets, 1);
            } if (nb>4) {
                afficheCar(murs, 1);
                afficheCar(volets, 1);
                afficheCar(' ', 2);
                afficheCar(volets, 1);
            }   
            afficheLigne(murs, 0, 1);

            afficheCar(' ', 1);
            
            afficheCar(murs, 1);
            afficheCar(volets, 1);
            afficheCar(' ', 2);
            afficheCar(volets, 1);

            afficheCar(murs, 1);
            afficheCar(volets, 1);
            afficheCar(' ', 2);
            afficheCar(volets, 1);

            afficheCar(murs, 1);
            afficheCar(volets, 1);
            afficheCar(' ', 2);
            afficheCar(volets, 1);

            if (nb>3) {
                afficheCar(murs, 1);
                afficheCar(volets, 1);
                afficheCar(' ', 2);
                afficheCar(volets, 1);
            } if (nb>4) {
                afficheCar(murs, 1);
                afficheCar(volets, 1);
                afficheCar(' ', 2);
                afficheCar(volets, 1);
            }   
            afficheLigne(murs, 0, 1);
        }


        static void afficheMursEtPorte(int nombreFenetre, int fenetre, char murs) {
            /**
             * Rôle : affiche les deux dernières lignes de murs, en laissant béant l'espace pour la porte
             *        sous la fenêtre passé en paramètre.*
             * Paramètres : un entier nombreFenetre, le nombre de fenêtres sur la maison.
             *              un entier fenetre, le numéro de la fenêtre sous laquelle est la porte.
             *              murs, le caractère symbolysant les murs de la maison.
             * Return : aucun.
             */  

             afficheCar(' ', 1);
             afficheCar(murs, (fenetre-1)*5);
             afficheCar(murs, 1);
             afficheLigne(murs, 4, (nombreFenetre-fenetre)*5 +1);

             afficheCar(' ', 1);
             afficheCar(murs, (fenetre-1)*5);
             afficheCar(murs, 1);
             afficheLigne(murs, 4, (nombreFenetre-fenetre)*5 +1);
        }


        // LES ACCESSEURS

        static int saisirNombre() {

            /** 
             * Rôle : demande la saisie d'un entier à l'utilisateur et le renvoie. 
             * Paramètre : aucun
             * Return : aucun
            */
            
            System.out.println("Veuillez saisir un nombre :");
            
            Scanner scanner = new Scanner(System.in);
            int res = scanner.nextInt();
            return res;
        }


        static char saisirCaractere() {

            /**
             * Rôle : demande à l'utilisateur de saisir un caractère et le renvoie.
             * Paramètre : aucun
             * Return : aucun
            */
            
                System.out.println("Veuillez saisir un caractère :");

                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                return str.charAt(0);
        }


        static char saisieReponseForme() {

            /** 
             * Rôle : demande à l'utilisateur de choisir si la forme du niveau en cours est un
             *        carré ou un triangle en saisissant soit 'c', soit 't'.
             * Paramètre : aucun
             * Return : le caractère sélectionner par l'utilisateur.
            */

            System.out.println("Cette forme géométrique est-elle un (c)arré ou un (t)riangle ?");
            return saisirCaractere();
        } 
        
        
        static int saisieReponseSurface() {

            /** 
             * Rôle : demande à l'utilisateur de saisir la surface de la forme du niveau en cours.
             * Paramètre : aucun
             * Return : l'entier sélectionner par l'utilisateur.
            */

            System.out.println("Quelle est la surface de cette forme géométrique ? (chaque # est de taille 1)");
            return saisirNombre();
        }


        @Override
        public String toString() {
            return "JeuForme []";
        }
    }
