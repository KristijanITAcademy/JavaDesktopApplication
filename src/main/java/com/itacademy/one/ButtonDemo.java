package com.itacademy.one;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Jav Desktop App
 *  - Swing
 *  - Java FX
 *
 * JFrame - > prozor
 * JPanel -> staviti u prozor
 *
 *  Kada kreiramo u programskom jeziku Java imamo 3 grupe komponenti L
 *      - Containers - skladiste kontrole
 *      -LayoutManager - kazu kako ce controle biti ubacene u container
 *      - GUI controls - JButton, JTextField... - sve ono s cim korisnik aplikacije ostvaruje
 *      konekciju i kontrolira vasu aplikaciju se zove GUI control
 */
public class ButtonDemo {
    public static void main(String[] args) {
        // GUI - treba biti u nekom GUI Thread
        // Thread - dobra praksa da crtanjeGUi startate u novom Threadu
        //kad lambda ne radi nista drugo nego samo poziva static metodu onda referenciramo
        System.out.println(Thread.currentThread().getName());
        Runnable runnable = ButtonDemo::createdAndShowGui;
        SwingUtilities.invokeLater(runnable);
        // OVO SU DVIJE LINIJE KOJE MORAMO KORISTI DA STARTAMO NEKI BLOK KODA
        // U DRUGOM THREADU

    }

    //JFrame je container
    //LayoutManager - svaki container ima predefinisani layout manager
    // Predefinirani layout koji je povezan je BorderLayout
    //- > on govori kako ce se GUI controle slagati u ovaj button
    private static void createdAndShowGui(){
//        System.out.println(Thread.currentThread().getName());
        // ovdje pisemo kod za GUI
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE); // magic number mijenjamo radije za konkretni opis
        jFrame.setTitle("Button Demnonstration");
        ButtonPanel buttonPanel = new ButtonPanel();
        jFrame.setContentPane(buttonPanel);
        jFrame.pack();// iscrtaj ekran da prikazes samo onoliko koliko ti treba
        jFrame.setVisible(true);

    }
}
