package com.blackburn.rovers.commands;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

import org.reflections.Reflections;

import com.blackburn.rovers.exception.CommandInitializationException;

public class CommandFactory {

    public static RoverCommand createCommand(String commandCode) throws CommandInitializationException {
        return (RoverCommand) getCommandByCode(commandCode);
    }

    // TODO Refactor this
    private static Object getCommandByCode(String commandCode) throws CommandInitializationException {
        Object obj = null;

        Reflections reflections = new Reflections("com.n11.rovers.commands");

        Set<Class<? extends RoverCommand>> allClasses =
                 reflections.getSubTypesOf(RoverCommand.class);

        for (Iterator<Class<? extends RoverCommand>> iterator = allClasses.iterator(); iterator.hasNext();) {
            Class<? extends Object> commandClass = (Class<? extends Object>) iterator.next();

            Field codeField = null;
            try {
                codeField = commandClass.getDeclaredField("CODE");
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                continue;
            }

            try {
                codeField.setAccessible(true);

                if(commandCode.equals(codeField.get(null))) {
                    obj =  commandClass.newInstance();
                    break;
                }
            } catch (Exception e) {
                throw new CommandInitializationException();
            }
        }

        return obj;
    }
}
