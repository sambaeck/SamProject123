import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by OEM on 3/08/2015.
 */
public class CreateDB {
    private static final Random random = new Random();
    private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public static void main(String[] args) {
        vulDatabase();
    }

    private static void vulDatabase() {
        Transaction tx = session.beginTransaction();

        for (int i = 1; i < 5; i++) {
            Afdeling afdeling = new Afdeling(i + "e afdeling");

            for (int k = 0; k < 16; k++) {
                Ploeg ploeg = new Ploeg(createRandomString());
                afdeling.addPloeg(ploeg);
                
                for (int j = 0; j < 14; j++) {
                    Speler speler = new Speler();
                    speler.setName(createRandomString());
                    speler.setAdres(createRandomString() + " " + random.nextInt(200) + " " + createZipCode() + " " + createRandomString());
                    if(j<11){
                      //  speler.setRol("Basisspeler");
                    }
                    else{
                   //     speler.setRol("Bankzitter");
                    }
                    ploeg.addSpeler(speler);
                    session.saveOrUpdate(speler);
                    //TODO: speler.setGeboorteDatum(new Date());
                }
                session.saveOrUpdate(ploeg);
            }
            session.saveOrUpdate(afdeling);

            List<Wedstrijd> wedstrijden = speelSeizoen(afdeling);
            for(Wedstrijd wedstrijd : wedstrijden){
                session.saveOrUpdate(wedstrijd);
            }


        }

        tx.commit();

    }

    private static String createRandomString() {
        StringBuilder sb = new StringBuilder();
        int length = 8 + random.nextInt(5);

        for (int i = 0; i < length; i++) {
            char letter = (char) (65 + random.nextInt(26));
            sb.append(letter);
        }

        return sb.toString();
    }

    private static String createZipCode() {
        StringBuilder sb = new StringBuilder();
        int length = 4;
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private static List<Wedstrijd> speelSeizoen(Afdeling afdeling){
        List<Wedstrijd> output = new ArrayList<Wedstrijd>();
        List<Ploeg> ploegen = afdeling.getPloegen();

        for(Ploeg ploeg : ploegen){
            for(Ploeg tegenstander : ploegen){
                if(ploeg.getId() != tegenstander.getId()){ // niet tegen jezelf spelen
                    Wedstrijd wed = new Wedstrijd(ploeg, tegenstander);
                    addGebeurtenissen(wed);
                    output.add(wed);
                }
            }
        }

        return output;
    }

    private static void addGebeurtenissen(Wedstrijd w) {
        int getal = random.nextInt(100);

        Ploeg thuisploeg = w.getPloegen().get(0);
        Ploeg uitploeg = w.getPloegen().get(1);
        List<Speler> spelers= new ArrayList<Speler>();
        for (Speler speler : thuisploeg.getSpelers()){
            spelers.add(speler);
        }
        for (Speler speler : uitploeg.getSpelers()){
            spelers.add(speler);
        }
        int spelersIndex = 0;
        if(getal>=0 && getal<6){
            return;
        }
        else if(getal > 5 && getal < 16){
            Speler speler = spelers.get(random.nextInt(22));
            Gebeurtenis gebeurtenis = new Gebeurtenis(GebeurtenisType.DOELPUNT, speler);
            session.saveOrUpdate(gebeurtenis);
            w.addGebeurtenis(gebeurtenis);

        }
        else if(getal > 15 && getal < 31){
            for(int i =0 ; i<2;i++){
                Speler speler = spelers.get(random.nextInt(22));
                Gebeurtenis gebeurtenis = new Gebeurtenis(GebeurtenisType.DOELPUNT, speler);
                session.saveOrUpdate(gebeurtenis);
                w.addGebeurtenis(gebeurtenis);            }
        }
        else if(getal > 30&& getal < 71){
            for(int i = 0; i <3 ; i++){
                Speler speler = spelers.get(random.nextInt(22));
                Gebeurtenis gebeurtenis = new Gebeurtenis(GebeurtenisType.DOELPUNT, speler);
                session.saveOrUpdate(gebeurtenis);
                w.addGebeurtenis(gebeurtenis);            }
        }
        else if(getal >70  && getal < 86){
            for(int i =0 ; i<4;i++){
                Speler speler = spelers.get(random.nextInt(22));
                Gebeurtenis gebeurtenis = new Gebeurtenis(GebeurtenisType.DOELPUNT, speler);
                session.saveOrUpdate(gebeurtenis);
                w.addGebeurtenis(gebeurtenis);            }
        }
        else if(getal >85  && getal < 96){
            for(int i =0 ; i<5;i++){
                Speler speler = spelers.get(random.nextInt(22));
                Gebeurtenis gebeurtenis = new Gebeurtenis(GebeurtenisType.DOELPUNT, speler);
                session.saveOrUpdate(gebeurtenis);
                w.addGebeurtenis(gebeurtenis);            }
        }
        else if(getal >95  && getal < 100){
            for(int i =0 ; i<4;i++){
                Speler speler = spelers.get(random.nextInt(22));
                Gebeurtenis gebeurtenis = new Gebeurtenis(GebeurtenisType.DOELPUNT, speler);
                session.saveOrUpdate(gebeurtenis);
                w.addGebeurtenis(gebeurtenis);            }
        }
    }

  


}
