package com.toad.beyondcompare.helper.tool;

public class ConsloeMenu {

    public interface ConsloeMenuInterface{
        public boolean select(int level, int index);
        public String showMenu(int level, int index);
    }

    ConsloeMenuInterface menuInterface;
    int selectLevel = 0;
    int selectIndex = 0;
    public void exitMenu(){

    }
    public void showMenu(){
        if (null != this.menuInterface) {

        }
    }
}
