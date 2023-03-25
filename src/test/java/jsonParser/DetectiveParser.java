package jsonParser;

import java.util.ArrayList;
import java.util.List;


public class DetectiveParser {

    public static List<Detective.detectives.Categories> getCategories(Detective detective) {
        List<Detective.detectives.Categories> categoriesList = new ArrayList<>();
        for (int i = 0; i < detective.detectives.size(); i++)
            for (int j = 0; j < detective.detectives.get(i).categories.size(); j++) {
                categoriesList.add(detective.detectives.get(i).categories.get(j));
            }
        return categoriesList;
    }

    public static List<Detective.detectives> getDetectives(Detective detective) {
        List<Detective.detectives> detectivesList = new ArrayList<>();
        for (int i = 0; i < detective.detectives.size(); i++)
            detectivesList.add(detective.detectives.get(i));

        return detectivesList;
    }

}
