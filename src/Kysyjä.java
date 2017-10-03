import java.util.*;

/**
 */
public class Kysyjä {
    List<Kysymys> kysymyslista = new ArrayList<Kysymys>();

    private void lisaaKysymys(Kysymys kysymys){
        kysymyslista.add(kysymys);
    }

    private void teeKysymyslista(){

        kysymyslista.add(new Kysymys("Kumpi tulee aakkosissa ensin?\n 1. 'b', 2. 'a'", 2));
        kysymyslista.add(new Kysymys("Onko Jake kovin jätkä kaikista?\n 1. On, 2. Ei", 1));
        kysymyslista.add(new Kysymys("Prätkähiirien Lallin sukunimi?\n 1. Leipäjuusto, 2. Juustohöylä", 1));
        kysymyslista.add(new Kysymys("Mikä on Suomen pääkaupunki?\n 1. Hankasalmi, 2. Helsinki", 2));
        kysymyslista.add(new Kysymys("Mikä on Jaken oikea etunimi?\n 1. Jarkko, 2. Jaakko, 3. Jake", 3));
        kysymyslista.add(new Kysymys("Mikä ei kuulu joukkoon?\n 1. Tupu. 2. Hupu, 3. Lupu, 4. Zubu",4));
        kysymyslista.add(new Kysymys("Mikä näistä on limonadi?\n 1. Dr. Pöppör, 2. Dr. Pepper, 3. Dr. Popper", 2));
        kysymyslista.add(new Kysymys("1 + 2 = ? \n 1. 1, 2. 2, 3. 3", 3));
        kysymyslista.add(new Kysymys("Kumpi on väkiluvultaan suurempi?\n 1. Hankasalmi, 2. Helsinki", 2));
        kysymyslista.add(new Kysymys("Kumpi on automerkki?\n 1. BWM, 2. BMW",2));
        kysymyslista.add(new Kysymys("Kumpi näistä on musiikkifestivaali?\n 1. Kihveli soikoon!, 2. Kehveli soikoon!",1));
        Collections.shuffle(kysymyslista); // Sekoittaa listan jotta kysymykset eivät ole aina samoja.
    }

    private Kysymys haeKysymys(int i){
        return kysymyslista.get(i);
    }

    private boolean tarkista(Kysymys kysymys){
        Scanner lukija = new Scanner(System.in);
        int vastaus = lukija.nextInt();
        if (vastaus == kysymys.getOikeanVaihtoehdonIndeksi()){
            System.out.println("Oikein meni.\n");
            return true;
        } else {
            System.out.println("Väärin meni\n");
            return false;
        }
    }

    private void aloitaPeli(){
        System.out.println("\nTervetuloa pelaamaan huikeaa kysymyspeliä.\n\n" +
                "Peli kysyy sinulta kymmenen kysymystä ja tulostaa päätteeksi sinun pisteesi.\n\n" +
                "Vastaukseksi kelpaa vain numerot, valitse vaihtoehdoista oikea numeroita käyttäen\n\n" +
                "Paina enter aloittaaksesi pelin.");
                for (int i = 0; i < 1;) {
                    Scanner lukija = new Scanner(System.in);
                    String enter = lukija.nextLine();
                    if (!enter.equals("")) {
                        System.out.println("Pelkkä enter, idiootti.");
                    } else if (enter.equals("")) i++;
                }

    }

    public static void main(String[] args) {
        Kysyjä kysyjä = new Kysyjä();

        kysyjä.teeKysymyslista(); // Tekee kysymyslistan ja sekoittaa sen.
        int pisteet = 0;

        kysyjä.aloitaPeli();

        try {
            for (int i = 0; i <= 9; i++) {               // Kysyy 10 ensimmäistä kysymystä listalta.
                Kysymys kysymys = kysyjä.haeKysymys(i);
                System.out.println(kysymys);
                if (kysyjä.tarkista(kysymys)) pisteet++;
            }
            System.out.println("Peli loppui.\n Pisteitä tuli " + pisteet + "/10");
        }catch (InputMismatchException i){
            System.out.println("Sössit. Vain numerovastaukset kelpaa.\n Joudut avaamaan koko pelin uudestaan.");
        }
    }

}
