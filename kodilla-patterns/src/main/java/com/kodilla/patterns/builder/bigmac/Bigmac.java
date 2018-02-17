package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    public final static String SESAME = "sesame";
    public final static String PLAIN = "plain";
    public final static String STANDARD = "standard";
    public final static String THOUSAND_ISLANDS = "thousand islands";
    public final static String BARBECUE = "barbecue";
    public final static String LETTUCE = "lettuce";
    public final static String ONION = "onion";
    public final static String BACON = "bacon";
    public final static String CUCUMBER = "cucumber";
    public final static String CHILI = "chili";
    public final static String MUSHROOM = "mushroom";
    public final static String SHRIMP = "shrimp";
    public final static String CHEESE = "cheese";

    private final String roll;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String roll;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        BigmacBuilder roll(String roll) throws BigmacException {
            if(roll.equals(Bigmac.PLAIN) || roll.equals(Bigmac.SESAME)){
                this.roll = roll;
                return this;
            } else if(roll.length() == 0) {
                throw new BigmacException("You have to choose 'plain' roll or 'sesame' roll");
            } else {
                throw new BigmacException("You can choose: 'plain' roll or 'sesame' roll");
            }
        }

        BigmacBuilder burgers(int burgers) throws BigmacException {
            if (burgers > 0 && burgers < 3) {
                this.burgers = burgers;
                return this;
            } else {
                throw new BigmacException("You have to choose at least one burger" +
                        ", but no more than two");
            }
        }

        BigmacBuilder sauce(String sauce) throws BigmacException {
            if(sauce.equals(Bigmac.STANDARD) || sauce.equals(Bigmac.THOUSAND_ISLANDS)
                    || sauce.equals(Bigmac.BARBECUE)) {

                this.sauce = sauce;
                return this;
            } else if(sauce.length() == 0) {
                throw new BigmacException("You have to choose one of three sauces: " +
                        "'standard', 'thousand islands' or 'barbecue'");
            } else {
                throw new BigmacException("You can choose: " +
                        "'standard' sauce, " +
                        "'thousand islands' sauce or " +
                        "'barbecue' sauce");
            }
        }

        BigmacBuilder ingredient(String ingredient) throws BigmacException {
            if(ingredient.equals(Bigmac.LETTUCE) || ingredient.equals(Bigmac.ONION) ||
                    ingredient.equals(Bigmac.BACON) || ingredient.equals(Bigmac.CUCUMBER) ||
                    ingredient.equals(Bigmac.CHILI) || ingredient.equals(Bigmac.MUSHROOM) ||
                    ingredient.equals(Bigmac.SHRIMP) || ingredient.equals(Bigmac.CHEESE)) {

                ingredients.add(ingredient);
                return this;
            } else if(ingredients.size() == 0 || ingredients.size() > 3) {
                throw new BigmacException("You have to choose at least one ingredient" +
                        "but no more than 3");
            } else {
                throw new BigmacException("You can choose max three ingrediends, " +
                        "from the following list: " +
                        "lettuce, onion, bacon, cucumber, " +
                        "chili, mushroom, shrimp, cheese");
            }
        }

        public Bigmac build() throws BigmacException {
            if(roll != null && burgers != 0 && sauce != null && !ingredients.isEmpty()) {
                return new Bigmac(roll, burgers, sauce, ingredients);
            } else {
                throw new BigmacException("You have to choose: " +
                        "roll, burger, sauce and at least one ingredient " +
                        "to complete the order");
            }
        }
    }

    private Bigmac(String roll, int burgers, String sauce, List<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}