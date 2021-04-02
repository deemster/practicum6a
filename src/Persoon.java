import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList <Game> mijnGames = new ArrayList <Game>();

    public Persoon(String nm, double bud){
        this.naam = nm;
        this.budget = bud;
    }

    public double getBudget() {
        return budget;
    }
    public boolean koop(Game g) {
        if (getBudget() >= g.huidigeWaarde() && !mijnGames.contains(g)) {
            mijnGames.add(g);
            this.budget = budget - g.huidigeWaarde();
            return true;
        }
        else {
            return false;
        }

    }


    public boolean verkoop(Game g, Persoon koper){
        boolean iets = false;
        if (mijnGames.contains(g) && !koper.mijnGames.contains(g) && koper.budget >= g.huidigeWaarde()) {
            this.mijnGames.remove(g);
            this.budget += g.huidigeWaarde();
            koper.koop(g);
            iets = true;
        }


        return iets;
    }

    public String toString(){
        String alles = naam + " heeft een budget van €" + String.format("%.2f", getBudget()) + " en bezit de volgende games:" ;
        for (Game g : mijnGames){
            alles += "\n" + g.toString();
        }
        return alles;
    }

}
