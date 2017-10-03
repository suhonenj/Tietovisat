import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Paaohjelma {


    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Valitse peli 0, 1 tai 2.");
        int vastaus = Integer.parseInt(lukija.nextLine());
        if (vastaus == 0){

        Kysyja kysyja = new Kysyja();
        kysyja.sekoitetaanKysymykset();
        int pisteet = 0;
        int indeksi = 0;

        for (int i = 0; i < 10; i++) {
            Kysymys3 kysymys = kysyja.tulostaKysymys(indeksi);
            System.out.print("Anna vastauksen numero: ");
            int vastauus = Integer.parseInt(lukija.nextLine());
            if (vastauus == kysymys.getOikeavastausindeksi()) {
                System.out.println("\n" + "Oikein! Sait pisteen!");
                pisteet++;
                System.out.println("Pisteesi: " + pisteet + "\n");
                indeksi++;
            } else {
                System.out.println("Väärä vastaus! Peli päättyi!");
                System.out.println("Pisteesi: " + pisteet);
                break;
            }
        }
        } else if (vastaus == 2) {

                Kysyjä kysyjä = new Kysyjä();

                kysyjä.teeKysymyslista(); // Tekee kysymyslistan ja sekoittaa sen.
                int pisteit = 0;

                kysyjä.aloitaPeli();

                try {
                    for (int i = 0; i <= 9; i++) {               // Kysyy 10 ensimmäistä kysymystä listalta.
                        Kysymys kysymys = kysyjä.haeKysymys(i);
                        System.out.println(kysymys);
                        if (kysyjä.tarkista(kysymys)) pisteit++;
                    }
                    System.out.println("Peli loppui.\n Pisteitä tuli " + pisteit + "/10");
                }catch (InputMismatchException i){
                    System.out.println("Sössit. Vain numerovastaukset kelpaa.\n Joudut avaamaan koko pelin uudestaan.");
                }

            }

            else if(vastaus == 1){

                Visailu visa = new Visailu();
                // tervehdys
                System.out.println("Tervetuloa Yleistieto2017-visaan!");
                System.out.println("Visassa on kymmenen kysymystä, joista jokaisessa on kolme vastausvaihtoehtoa.");
                System.out.println("Syötä vastaukseksi oikean vaihtoehdon numero (0, 1, tai 2).");


                while (visa.hasNextQuestion()) {
                    System.out.println(visa.getKysymysTeksti());
                    ArrayList vastaukset = visa.getVastausVaihtoehdot();
                    for (int i=0; i<vastaukset.size(); i++) {
                        System.out.print(i + ") " + vastaukset.get(i) + "  ");
                    }
                    String vastauss = lukija.nextLine();
                    visa.tarkistaVastaus(vastauss);
                    //??? printtaa oikein tai väärin
                }
                System.out.println("Onnea! Sait " + visa.getPisteet() + " oikein" +
                        " 10 kysymyksestä.");
            } else {
            System.out.println("Sössit. Valitse 0, 1 tai 2.");

        }
            }

        }



