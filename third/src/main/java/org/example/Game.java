package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    List<Door> list;
    int countDoors;
    public Game(int countDoors) {
        if (countDoors < 3)
            countDoors = 3;

        this.countDoors = countDoors;
        this.list = new ArrayList<>(this.countDoors);
        fillList(this.countDoors);
    }
    public void showDoors() {
        list.stream().forEach(System.out::print);
        System.out.println();
    }
    private void fillList(int i) {
        list.add(new Door(true));
        for (int j = 1; j < i; j++) {
            list.add(new Door(false));
        }
        Collections.shuffle(list);
    }
    public boolean knowResult(int number) {
        if (number < 0 || number >= countDoors)
            throw new RuntimeException("Нет такой двери.");

        return list.get(number).getWin();
    }
    public void dellDoor() {
        int index = list.size();
        while (list.size() > 2) {
            if (list.get(--index).getWin())
                continue;
            list.remove(index);
        }
    }

    private class Door {
        boolean win;
        Door(boolean win) {
            this.win = win;
        }
        boolean getWin() {
            return win;
        }

        @Override
        public String toString() {
            return "[ Door= " + win + " ]";
        }
    }
}
