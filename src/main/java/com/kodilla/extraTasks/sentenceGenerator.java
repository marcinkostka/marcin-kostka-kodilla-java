package com.kodilla.extraTasks;

import java.util.*;
import java.lang.*;

class SentencePart{
    public String generate(){
        return "";
    }
}

class Subject extends SentencePart{
    String[] words = {"Człowiek", "Ryba", "Pies", "Roślina", "Piłka", "Małpa", "Zając", "Ptak"};

    Random random = new Random();
    public String generate() {
        return words[random.nextInt(words.length)];
    }
}

class Predicate extends SentencePart{
    String[] words = {"pływa", "skacze", "tańczy", "rośnie", "lata" , "pije", "pracuje"};

    Random random = new Random();
    public String generate() {
        return words[random.nextInt(words.length)];
    }
}

class Adverbial extends SentencePart{
    public String generate(){
        return "";
    }
}

class PlaceAdverbial extends Adverbial{
    String[] words = {"nad rzeką", "w domu", "w ogrodzie", "na basenie", "w kosomosie", "w szkole"};
    Random random = new Random();
    public String generate() {
        return words[random.nextInt(words.length)];
    }
}

class TimeAdverbial extends Adverbial{
    String[] words = {"wczoraj", "dzisiaj", "codziennie", "od tygodnia", "za kilka dni", "rzadko"};
    Random random = new Random();
    public String generate() {
        return words[random.nextInt(words.length)];
    }
}

class MannerAdverbial extends Adverbial{
    String[] words = {"krótko", "wysoko", "radośnie", "ciekawie", "po polsku"};
    Random random = new Random();
    public String generate() {
        return words[random.nextInt(words.length)];
    }
}

class Sentence{
    SentencePart subject;
    SentencePart predicate;
    SentencePart adverbial;

    public Sentence(){
        subject = new Subject();
        predicate = new Predicate();
        Random random = new Random();

        switch(random.nextInt(3)) {
            case 0: adverbial = new PlaceAdverbial();
                break;
            case 1: adverbial = new TimeAdverbial();
                break;
            default: adverbial = new MannerAdverbial();
        }
    }

    public String generate(){
        return subject.generate()+" "+predicate.generate()+" "+adverbial.generate()+".";
    }
}

class PoemGenerator{
    List<String> generate(int numberOfLines){
        List<String> sentenceList = new ArrayList<>();
        for(int i=0; i<numberOfLines;i++){
            Sentence s = new Sentence();
            sentenceList.add(s.generate());
            //System.out.println(row.get(i));
        }
        return sentenceList;
    }
}

class sentenceGenerator {
    public static void main(String[] args) {

        PoemGenerator poem = new PoemGenerator();
        for(String row : poem.generate(15)){
            System.out.println(row);
        }

    }
}