import model.GebeurtenisType;
import model.Wedstrijd;

import java.util.List;

/**
 * Created by OEM on 5/08/2015.
 */
public class MainQueryTest {

    public static void main(String[] args) {
        QueryTest test = new QueryTest();
        List<Wedstrijd> eupla = test.toonWedstrijden("CTQBEUVP", GebeurtenisType.DOELPUNT);

        System.out.println(eupla.size());
    }
}
