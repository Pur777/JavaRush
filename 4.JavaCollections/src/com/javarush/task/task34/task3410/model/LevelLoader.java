package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        if (level > 60) {
            level %= 60;
            if (level == 0) {
                level = 60;
            }
        }
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        List<String> list = readLevelsFile(level);
        for (int i = 0; i < list.size(); i++) {
            char[] c = list.get(i).toCharArray();
            for (int j = 0; j < c.length; j++) {
                switch (c[j]) {
                    case 'X':
                        walls.add(new Wall(Model.FIELD_CELL_SIZE * j + Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE * i + Model.FIELD_CELL_SIZE/2));
                        break;
                    case '*':
                        boxes.add(new Box(Model.FIELD_CELL_SIZE * j + Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE * i + Model.FIELD_CELL_SIZE/2));
                        break;
                    case '.':
                        homes.add(new Home(Model.FIELD_CELL_SIZE * j + Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE * i + Model.FIELD_CELL_SIZE/2));
                        break;
                    case '&':
                        homes.add(new Home(Model.FIELD_CELL_SIZE * j + Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE * i + Model.FIELD_CELL_SIZE/2));
                        boxes.add(new Box(Model.FIELD_CELL_SIZE * j + Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE * i + Model.FIELD_CELL_SIZE/2));
                        break;
                    case '@':
                        player = new Player(Model.FIELD_CELL_SIZE * j + Model.FIELD_CELL_SIZE/2, Model.FIELD_CELL_SIZE * i + Model.FIELD_CELL_SIZE/2);
                        break;
                }
            }
        }
        return new GameObjects(walls, boxes, homes, player);
    }

    public List<String> readLevelsFile(int level) {
        List<String> list = new ArrayList<>();
        String needLevel = String.format("Maze: %d", level);
        String endSearch = "*************************************";
        try (BufferedReader bufferedReader = Files.newBufferedReader(levels)) {
            String s;
            boolean searchStart = false;
            while ((s = bufferedReader.readLine()) != null) {
                if (searchStart) {
                    if (s.equals(endSearch)) {
                        break;
                    }
                    list.add(s);
                }
                if (s.equals(needLevel)) {
                    list.add(s);
                    searchStart = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.subList(0, 7).clear();
        list.remove(list.size() - 1);
        return list;
    }
}
//Осталось дописать реализацию загрузчика уровней.
//16.1. Открой файл levels.txt и внимательно изучи структуру файла. Символ 'X' - означает стену, '*' - ящик, '.' - дом, '&' - ящик который стоит в доме, а '@' -
// игрока. Всего в файле 60 уровней.
//16.2. Реализуй метод GameObjects getLevel(int level). Он должен:
//16.2.1. Вычитывать из файла данные уровня level. Уровни должны повторяться циклически, если пользователь прошел все 60 уровней и попал на 61 уровень, то ему
// нужно вернуть 1, вместо 62 уровня вернуть 2 и т.д.
//16.2.2. Создать все игровые объекты, описанные в указанном уровне. Координаты каждого игрового объекта должны быть рассчитаны согласно следующей логике:
//16.2.2.1. Самый верхний левый объект (если такой есть) должен иметь координаты x = x0 = FIELD_CELL_SIZE / 2 и y = y0 = FIELD_CELL_SIZE / 2.
//16.2.2.2. Объект, который находится на одну позицию правее от него должен иметь координаты x = x0 + FIELD_CELL_SIZE и y = y0.
//16.2.2.3. Объект, который находится на одну позицию ниже от самого верхнего левого должен иметь координаты x = x0 и y = y0 + FIELD_CELL_SIZE.
//16.2.2.4. Аналогично должны рассчитываться координаты любого объекта на поле.
//16.2.3. Создать новое хранилище объектов GameObjects и поместить в него все объекты.
//16.2.4. Вернуть созданное хранилище.
//
//Игра должна быть полностью рабочей. Проверь, если есть какие-то проблемы исправь их.
//
//
//Требования:
//1. Реализуй метод GameObjects getLevel(int level) согласно условию задачи.
