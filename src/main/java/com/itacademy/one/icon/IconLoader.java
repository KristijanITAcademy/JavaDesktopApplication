package com.itacademy.one.icon;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * mora imati kontekst klase unutar koje se koristi
 *kad kreiras icon loader, moras mi poslat klasu unutar koje se on koristi
 *
 *
 */
public class IconLoader {
    public final Class<?>clazz;

    public IconLoader(Class<?> clazz) {
        this.clazz = clazz;
    }

    /**
     * CLassLoader - Java mehanizam koji
     *  ucitava klase
     *  ucitava i resurse koje klasa koristi iz projekta
     * @param pathIcon
     * @return
     */
    public Icon loadIcon(String pathIcon) {
        ClassLoader classLoader = clazz.getClassLoader(); //
        URL url = classLoader.getResource(pathIcon); // kaze pronadi adresu ovog pathIcon
        if (url == null){
            System.out.println("Ico resource not found: " + pathIcon);
            return null;
        }
       return new  ImageIcon(url);
      }
    }

