package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Creator {
    private final Map<String, Command> classes;
    private Properties properties;

    public Creator() {
        classes = new HashMap<>();
    }


    // operations Файл свободной конфигурации.
    //IOException Ошибка чтения файла конфигурации.

    public Creator(File operations) throws IOException {
        this();
        if (operations != null)
            loadFromFile(operations);
        Calculator.logger.fine("Factory initialised.");

    }

    private Creator(Map<String, Command> classes) {
        this.classes = classes;
    }

    //Регистрирует операцию и ее класс.
    // name Название операции.
    // clazz Класс-реализация операции.

    public void registerOperation(String name, Command clazz) {
        if (name == null)
            throw new IllegalArgumentException("Operation name cannot be null!");
        if (clazz == null)
            throw new IllegalArgumentException("Operation implementation cannot be null!");
        classes.put(name.toUpperCase(), clazz);
        Calculator.logger.fine("Operation " + name + " registered.");

    }

    // Загружает операции из свободного файла.


    private void loadFromFile(File operations) throws IOException {
        Properties prop = new Properties();
        InputStream targetStream = new FileInputStream(operations);
        prop.load(targetStream);
        this.properties = prop;
        Calculator.logger.fine("Loaded operations");

    }

    void create() {
    }

    public Command getOperation(String name) throws OperationCreateException {
        if (name == null)
            throw new IllegalArgumentException("Name cannot be null!");
        Command clazz = classes.get(name);
        if (clazz == null) {
            Command new_class = null;
            try {
                Class command;
                command = Class.forName(properties.getProperty(name));
                new_class = (Command) command.getDeclaredConstructor().newInstance();
                registerOperation(name, new_class);
                Calculator.logger.fine("Operation " + name + " created.");

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
            if (new_class == null)
                throw new OperationCreateException(name);

            return new_class;
        } else return clazz;
    }

}
