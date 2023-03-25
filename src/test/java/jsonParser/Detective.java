package jsonParser;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;


@Getter

public class Detective {

    public List<detectives> detectives;


    public static class detectives {
        public int MainId;
        public String firstName;
        public String lastName;
        public Boolean violinPlayer;
        public List<Categories> categories;


        public static class Categories {
            public int CategoryID;
            public String CategoryName;
            public Extra extra;

            public static class Extra {
                public List<extraArray> extraArray;

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class extraArray {
                    public int violin;
                    public int cap;
                }
            }
        }
    }

    public boolean success;
}
