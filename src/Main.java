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
public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        vulDatabase();
        speelSpeeldag(1);
    }

    private static void vulDatabase() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Random random = new Random();

        for (int i = 1; i < 5; i++) {
            Afdeling afdeling = new Afdeling(i + "e afdeling");

            for (int k = 0; k < 16; k++) {
                Ploeg ploeg = new Ploeg(createRandomString());

                afdeling.addPloeg(ploeg);
                for (int j = 0; j < 14; j++) {
                    Speler speler = new Speler();
                    speler.setName(createRandomString());
                    speler.setAdres(createRandomString() + " " + random.nextInt(200) + " " + createZipCode() + " " + createRandomString());
                    ploeg.addSpeler(speler);
                    session.saveOrUpdate(speler);
                    //TODO: speler.setGeboorteDatum(new Date());
                }
                session.saveOrUpdate(ploeg);
            }
            session.saveOrUpdate(afdeling);

            /*for(Ploeg ploeg : afdeling.getPloegen()){
                for(int l = 0; l < 30; l++){

                    Ploeg tegenstander = afdeling.getPloegen().get(random.nextInt(16));
                    while(ploeg.getId() == tegenstander.getId()){
                      tegenstander = afdeling.getPloegen().get(random.nextInt(16));
                    }
                    Wedstrijd wedstrijd = new Wedstrijd();
                    wedstrijd.addPloegen(ploeg,tegenstander);

                }
            }*/
            for(int x = 0; x<30;x++){
                for(Ploeg p: afdeling.getPloegen()){
                    Ploeg tegenstander = afdeling.getPloegen().get(random.nextInt(16));
                    if(p.getId()!=tegenstander.getId() && p.getAantalGespeeldeMatchen()<2 && tegenstander.getAantalGespeeldeMatchen()<2){
                        speelWedstrijd(new Wedstrijd(),p, tegenstander);
                    }
                }
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

    private static void speelSeizoen(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        //Query queryPloegen = session.createQuery("from Ploeg");
    }

    private static void speelSpeeldag(int afdeling){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("SELECT a.ploegen FROM Afdeling a WHERE a.id = :afdeling");
        query.setInteger("afdeling", afdeling);
        Collection lijst = query.list();
        System.out.println(lijst.size() + " PLOEGEN GEVONDEN");
        ArrayList<String> lijstje = new ArrayList<String>(lijst);
        //ArrayList<Ploeg> ploegen =  (ArrayList) ploegenPerAfdeling.list();
        tx.commit();
    }

    private static void speelWedstrijd(Wedstrijd w, Ploeg p, Ploeg tegenstander){
        w.addPloegen(p,tegenstander);

        int getal = random.nextInt(100);
       /* if(getal>=0 && getal<6){
            return;
        }
        else if(getal > 5 && getal < 16){
            w.addGebeurtenis(new Gebeurtenis(GebeurtenisType.DOELPUNT));
        }
        else if(getal > 15 && getal < 31){
            for(int i =0 ; i<2;i++){
                w.addGebeurtenis(new Gebeurtenis(GebeurtenisType.DOELPUNT));
            }
        }
        else if(getal > 30&& getal < 71){
            for(int i = 0; i <3 ; i++){
                w.addGebeurtenis(new Gebeurtenis(GebeurtenisType.DOELPUNT));
            }
        }


        w.addGebeurtenis(new Gebeurtenis().);*/
    }


}
