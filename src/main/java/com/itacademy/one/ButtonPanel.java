package com.itacademy.one;

import com.itacademy.one.icon.IconLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// takoder mora biti povezan sa nekim layout manager
// on je po defaultu isto conatainer ovaj JPanel - ButtonPanel
// LayoutManager- FlowLayout -> kaze GUi kako ce slagati kontrole i to mu kaze sljedece >
// -> dodavaj komponente GUI reedoslijedom s lijeva na desno a kad vise ne bude mjesta prijedi u novi red
// GUI kontrole - > JButton
// svaki container ima funkciju add, da moze u sebi skladistit gui kontrole
public class ButtonPanel extends JPanel {
    //ButtonPanel HAS A JButton -> kompozicija
    private final IconLoader iconLoader = new IconLoader(ButtonPanel.class);
    // prosljedujem class objekat ctrl + klik misa na IconLoader
    private final JButton disablebutton;
    private final JButton middleButton;
    private final JButton enableButton;

    public ButtonPanel() {
        DisableActionListener disableActionListener = new DisableActionListener();
        Icon rightIcon = iconLoader.loadIcon("right-arrow.gif");
        this.disablebutton = new JButton("Disable Button", rightIcon);
        this.disablebutton.addActionListener(disableActionListener);
        this.disablebutton.setMnemonic(KeyEvent.VK_D);
        this.disablebutton.setActionCommand("disable");


        Icon middleIcon = iconLoader.loadIcon("middle-arrow.gif");
        this.middleButton = new JButton("Middle Button", middleIcon);


        Icon leftIcon = iconLoader.loadIcon("left-arrow.gif");
        this.enableButton = new JButton("Enable Button", leftIcon);
        ActionListener actionListener = this::enableButton;
        this.enableButton.addActionListener(actionListener);
        this.enableButton.setMnemonic(KeyEvent.VK_E);
        this.disablebutton.setActionCommand("enable");

        add(disablebutton);
        add(middleButton);
        add(enableButton);


    }

    private void  enableButton(ActionEvent event) {
        middleButton.setEnabled(true);
        enableButton.setEnabled(false);
        disablebutton.setEnabled(true);
    }

    private class DisableActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            middleButton.setEnabled(false);
            disablebutton.setEnabled(false);
            enableButton.setEnabled(true);
        }
    }

    /**
     * Ovaj blok koda metode onButtonClick ce se pozvati i na disableButton i na enableButton CLICK
     * Pitanje: kako cemo uraditi distinkciju toga gdje se desio CLICK : na enable ili disable ?
     * <p>
     * Ovaj actionEvent je kanal komunikacije  izmedu listenera, ovog bloka koda i dugmica na kojem se desio click
     *
     * @param actionEvent
     */
//    private void onButtonClick(ActionEvent actionEvent) {
//        String comand = actionEvent.getActionCommand();
//        if ("disable".equals(comand)){
//        this.middleButton.setEnabled(false);
//        this.disablebutton.setEnabled(false);
//        this.enableButton.setEnabled(true);
//        }else {
//            this.middleButton.setEnabled(true);
//            this.disablebutton.setEnabled(true);
//            this.enableButton.setEnabled(false);
//        }
//    }
    }


