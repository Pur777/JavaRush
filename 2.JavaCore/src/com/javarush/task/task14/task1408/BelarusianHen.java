package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 63;
    }
    String s = Country.BELARUS;
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + s + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
