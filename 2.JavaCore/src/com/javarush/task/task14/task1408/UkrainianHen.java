package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 77;
    }
    String s = Country.UKRAINE;
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + s + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}