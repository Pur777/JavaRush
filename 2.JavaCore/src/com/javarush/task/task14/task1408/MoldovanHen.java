package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 45;
    }
    String s = Country.MOLDOVA;
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + s + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}