package ru.devray.school.examplesolutions.compassproc;

public class CompassProcedural {

    //объявили массив градусов, описывающих основные направления компасса
    static int[] directions = {0, 90, 180, 270};
    //объявили массив названий направлений
    //обратите внимание, что позиции (индексы) названий направлений в массиве
    //совпадают с соотетствующими позициями (индексами) значений градусов
    static String[] directionLetters = {"N", "E", "S", "W"};

    public static void printCompassDirection(int degrees) {

        //индекс нашего искомого направления в массиве, по умолчанию = 0
        int targetDirection = 0;

        //перебираем все стороны света, и для каждой по очереди проверяем, входит ли
        //в нее введенный градус.
        for (int i = 0; i < directions.length; i++){
            //здесь мы нормализуем значение градусов, введенных пользователем
            //т.е. degrees % 360 для любого значения degrees вернет значение в диапазоне
            //от 0 до 359
            if (degreesBelongsToDirection(degrees % 360, directions[i])){
                //если градус попал в диапазон - сохраняем индекс нарпавления
                //и досрочно завершаем цикл - ведь сторону мы уже нашли:)
                targetDirection = i;
                break;
            }
        }
        System.out.println(directionLetters[targetDirection]);
    }

    //проверяем что градус пользователя меньше чем (градус текущей стороны света + 45 градусов)
    private static boolean degreesBelongsToDirection(int degrees, int directionDegrees){
        return degrees < directionDegrees + 45;
    }

    public static void main(String[] args) {
        printCompassDirection(560);
    }
}
