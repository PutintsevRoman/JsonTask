package test;

import jsonParser.Detective;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static jsonParser.DetectiveParser.getCategories;
import static jsonParser.DetectiveParser.getDetectives;


public class Tests extends TestBase {

    @Test
    @Tag("Positive")
    @Tag("All")
    @DisplayName("Тест на количество объектов detectives и значение MainId <10")
    void countDetectivesTest() {
        List<Detective.detectives> detectivesList = getDetectives(detective);

        for (int i = 0; i < detectivesList.size(); i++)
            Assertions.assertTrue((detectivesList.get(i).MainId <= 10) &&
                    (detectivesList.get(i).MainId >= 0));
    }

    @Test
    @Tag("Positive")
    @Tag("All")
    @DisplayName("Тест на значение CategoryID")
    void categoryIdNumTest() {
        List<Detective.detectives.Categories> categoriesList = getCategories(detective);

        for (int i = 0; i < categoriesList.size(); i++) {
            Assertions.assertTrue((categoriesList.get(i).CategoryID == 1) ||
                    (categoriesList.get(i).CategoryID == 2));
        }
    }

    @Test
    @Tag("Positive")
    @Tag("All")
    @DisplayName("Тест на значение extra при CategoryID = 2")
    void extraNullTest() {
        List<Detective.detectives.Categories> categoriesList = getCategories(detective);

        for (int i = 0; i < categoriesList.size(); i++) {
            if (categoriesList.get(i).CategoryID == 2)
                Assertions.assertNull(categoriesList.get(i).extra);
        }
    }

    @Test
    @Tag("Positive")
    @Tag("All")
    @DisplayName("Тест на размер  extraArray при CategoryID = 1")
    void extraArrayCountTest() {
        List<Detective.detectives.Categories> categoriesList = getCategories(detective);

        for (int i = 0; i < categoriesList.size(); i++) {
            if (categoriesList.get(i).CategoryID == 1)
                Assertions.assertTrue(categoriesList.get(i).extra.extraArray.size() > 0);
        }
    }

    @Test
    @Tag("Positive")
    @Tag("All")
    @DisplayName("Тест на success = tue")
    void successFirstNameTest() {
        if(detective.success){
            int flag =0;
            List<Detective.detectives> detectivesList = getDetectives(detective);
            for (int i = 0; i < detectivesList.size(); i++)
                if(detectivesList.get(i).firstName.equals("Sherlock"))
                    flag =1;
            Assertions.assertTrue(flag==1);
        }
    }

    @Test
    @Tag("Negative")
    @Tag("All")
    @DisplayName("Проверка текстовых полей на наличие допустимых символов")
    void textFieldsContainsTest() {
        List<Detective.detectives> detectivesList = getDetectives(detective);

        for (int i =0;i<detectivesList.size();i++){
            Assertions.assertTrue( detectivesList.get(i).firstName.matches("^[a-zA-Z]*$"));
            Assertions.assertTrue( detectivesList.get(i).lastName.matches("^[a-zA-Z]*$"));
        }
    }

    @Test
    @Tag("Negative")
    @Tag("All")
    @DisplayName("Проверка того, что все поля в detectives не равно null")
    void fieldsDetectivesNotNull() {
        List<Detective.detectives> detectivesList = getDetectives(detective);
        for (int i =0;i<detectivesList.size();i++){
            Assertions.assertNotNull( detectivesList.get(i).firstName);
            Assertions.assertNotNull( detectivesList.get(i).lastName);
            Assertions.assertNotNull( detectivesList.get(i).violinPlayer);
            Assertions.assertNotNull( detectivesList.get(i).categories);
        }
    }

    @Test
    @Tag("Negative")
    @Tag("All")
    @DisplayName("Проверка того, что все поля в categories не равно null")
    void fieldsCategoriesNotNull() {
        List<Detective.detectives.Categories> categoriesList = getCategories(detective);
        for (int i =0;i<categoriesList.size();i++){
            Assertions.assertNotNull( categoriesList.get(i).CategoryID);
            Assertions.assertNotNull( categoriesList.get(i).CategoryName);
        }
    }
}
