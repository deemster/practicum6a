import java.time.LocalDate;
import java.time.LocalDateTime;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr){
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwprijs = nwpr;
    }

    public String getNaam() {
        return naam;
    }
    public double huidigeWaarde(){
        double i = this.nieuwprijs;
        int a = LocalDate.now().getYear() - releaseJaar;
        for(int b = 0; b < a; b++){
            double c = 0.7;
            i *= c;

        }
        return i;
    }
    public boolean equals(Object andereObject){
        boolean zelfdeObject = false;

        if (andereObject instanceof  Game) {
            Game andereGame = (Game) andereObject;

            if(this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar){
                zelfdeObject = true;
            }
        }
        return zelfdeObject;
    }
    public String toString(){

        return getNaam() + ", uitgegeven in " + releaseJaar + "; nieuwprijs:  €" + nieuwprijs + " nu voor: €" + String.format("%.2f", huidigeWaarde());
    }
}
