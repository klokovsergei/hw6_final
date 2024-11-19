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
    public static void main(String[] args) {

        Map<Integer, Boolean> changeChoose = new HashMap<>();
        Map<Integer, Boolean> notChangeChoose = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            changeChoose.put(i, new PlayGame(3).play(true));
        }
        for (int i = 0; i < 1000; i++) {
            notChangeChoose.put(i, new PlayGame(3).play(false));
        }

        System.out.println("Кол-во побед, если изменить выбор двери = " +
                changeChoose.values().stream().filter(x -> x == true).count());
        System.out.println("Кол-во побед, если НЕ менять выбор двери = " +
                notChangeChoose.values().stream().filter(x -> x == true).count());
    }
}