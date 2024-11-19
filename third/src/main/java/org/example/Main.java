package org.example;

/*
В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Подключить зависимость lombok.
Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям

*/

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static int countGames = 1000;
    public static void main(String[] args) {

        Map<Integer, Boolean> changeChoose = new HashMap<>();
        Map<Integer, Boolean> notChangeChoose = new HashMap<>();

        for (int i = 0; i < countGames; i++) {
            changeChoose.put(i, new PlayGame(3).play(true));
        }
        int countWinWithChange = (int)changeChoose.values().stream().filter(x -> x == true).count();
        for (int i = 0; i < countGames; i++) {
            notChangeChoose.put(i, new PlayGame(3).play(false));
        }
        int countWinWithNotChange = (int)notChangeChoose.values().stream().filter(x -> x == true).count();

        System.out.println("Всего игр каждого типа по " + countGames);
        System.out.println("Кол-во побед, если изменить выбор двери = " +
                countWinWithChange + ". Это " +
                (int)(countWinWithChange * 1.0 / countGames * 100)  + "%");
        System.out.println("Кол-во побед, если НЕ менять выбор двери = " +
                countWinWithNotChange + ". Это " +
                (int)(countWinWithNotChange * 1.0 / countGames * 100)  + "%");
    }
}