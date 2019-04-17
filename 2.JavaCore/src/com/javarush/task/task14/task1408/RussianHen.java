package com.javarush.task.task14.task1408;

public class RussianHen extends Hen implements Country{


    @Override
    public int getCountOfEggsPerMonth() {
        return 100;
    }
    String s = Country.RUSSIA;
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + s + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}