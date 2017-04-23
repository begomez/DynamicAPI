package fake;

import com.myapps.data.PadelClub;
import com.myapps.data.PlaceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bernatgomez on 22/4/17.
 */

public class FakeUtils {
    public static ArrayList<PlaceModel> getFakePlaces() {
        PlaceModel place1 = new PlaceModel();
        PlaceModel place2 = new PlaceModel();

        place1.setTitle("Title1");
        place1.setSubtitle("Subtitle1");
        place1.setDescrip("Descrip1");

        place2.setTitle("Title1");
        place2.setSubtitle("Subtitle1");
        place2.setDescrip("Descrip1");

        ArrayList<PlaceModel> places = new ArrayList<PlaceModel>();
        places.add(place1);
        places.add(place2);
        return places;
    }

    public static ArrayList<PadelClub> getFakeClubs() {
        ArrayList<PadelClub> clubs = new ArrayList<PadelClub>();

        PadelClub club1 = new PadelClub();
        club1.setName("Club 1");

        PadelClub club2 = new PadelClub();
        club2.setName("Club 2");

        clubs.add(club1);
        clubs.add(club2);

        return clubs;
    }
}
