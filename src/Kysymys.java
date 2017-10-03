import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 29.9.2017.
 */
public class Kysymys{

    String kysymysteksti;
    int oikeanVaihtoehdonIndeksi;

    public boolean tarkista(int i, int o){
        if (i == o){
            return true;
        }return false;
    }

    public Kysymys(String kysymysteksti,  int oikeanVaihtoehdonIndeksi) {
        this.kysymysteksti = kysymysteksti;
        this.oikeanVaihtoehdonIndeksi = oikeanVaihtoehdonIndeksi;
    }

    public String getKysymysteksti() {
        return kysymysteksti;
    }

    public void setKysymysteksti(String kysymysteksti) {
        this.kysymysteksti = kysymysteksti;
    }

    public int getOikeanVaihtoehdonIndeksi() {
        return oikeanVaihtoehdonIndeksi;
    }

    public void setOikeanVaihtoehdonIndeksi(int oikeanVaihtoehdonIndeksi) {
        this.oikeanVaihtoehdonIndeksi = oikeanVaihtoehdonIndeksi;
    }

    @Override
    public String toString() {
        return kysymysteksti;
    }
}

