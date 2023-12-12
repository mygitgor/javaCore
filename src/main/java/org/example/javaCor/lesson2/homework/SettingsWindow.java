package org.example.javaCor.lesson2.homework;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow {
    public static final String BTN_START = "Start New Game";
    public static final String LABEL_CHOICE_MODEL = "Вибери режим игры";
    public static final String BTN_HUMAN_VERSUS_AI = "Человек против компьютера";
    public static final String BTN_HUMAN_VERSION_HUMAN = "Человек против Человекa";
    public static final String SIZE_PREFIX = "Установленный размер поля: ";
    public static final String WIN_LENGTH_PREFIX = "Установленная длина: ";
    public static final String LABEL_CHOICE_SIZE = "Выберите размеры поля";
    public static final String LABEL_CHOICE_WIN_LENGTH = "Выберите длину для победы";
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 10;

    private static final int WITH = 230;
    private static final int HEIGHT = 350;

    GameWindow gameWindow;
    JButton btnStart;
    JRadioButton humanVHuman, humanVAI;
    Label labelCurSize, labelWinLength;
    JSlider sizeSlider, winSlider;

    SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;

        int centerGameWindowX = gameWindow.getX() + gameWindow.getWidth()/2;
        int centerGameWindowY = gameWindow.getY() + gameWindow.getWidth()/2;
        gameWindow.setLocation(centerGameWindowX - WITH/2, centerGameWindowY - HEIGHT/2);
        gameWindow.setSize(WITH,HEIGHT);

        gameWindow.add(createMainPanel());
        gameWindow.add(createButtonStart(), BorderLayout.SOUTH);
    }

    private Component createMainPanel(){
        JPanel jPanel = new JPanel(new GroupLayout(3,1));

        jPanel.add(createChoiceModePanel());
        jPanel.add(createChoiceSizePanel());
        jPanel.add(createChoiceWinLengthPanel());
        return jPanel;
    }

    private Component createButtonStart(){
        btnStart = new JButton(BTN_START);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                startGame();
            }
        });
        return btnStart;
    }

    private void startGame(){
        int mode;
        if(humanVAI.isSelected()){
            mode = MODE_HVA;
        } else if (humanVHuman.isSelected()) {
            mode = MODE_HVH;
        }else {
            throw new RuntimeException("Unknown game mode");
        }
        int size = sizeSlider.getValue();
        int winLength = winSlider.getValue();
        gameWindow.startNewGame(mode,size,size,winLength);
    }

    private Component createChoiceModePanel(){
        JPanel jPanel = new JPanel(new GroupLayout(3,1));
        Label label = new Label(LABEL_CHOICE_MODEL);
        ButtonGroup buttonGroup = new ButtonGroup();
        humanVAI = new JRadioButton(BTN_HUMAN_VERSION_HUMAN);
        humanVHuman = new JRadioButton(BTN_HUMAN_VERSION_HUMAN);
        buttonGroup.add(humanVAI);
        buttonGroup.add(humanVHuman);
        humanVAI.isSelected(true);

        jPanel.add(label);
        jPanel.add(humanVAI);
        jPanel.add(humanVHuman);

        return jPanel;
    }

    private Component createChoiceSizePanel(){
        JPanel jPanel = new JPanel(new GroupLayout(3,1));
        Label label = new Label(LABEL_CHOICE_SIZE);
        labelCurSize = new Label(SIZE_PREFIX + MAX_SIZE);
        sizeSlider = new JSlider(MIN_SIZE,MAX_SIZE,MIN_SIZE);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int curSize = sizeSlider.getValue();
                labelCurSize.setText(SIZE_PREFIX + curSize);
                winSlider.setMaximum(curSize);
            }
        });

        jPanel.add(label);
        jPanel.add(labelCurSize);
        jPanel.add(sizeSlider);
        return jPanel;
    }

    private Component createChoiceWinLengthPanel(){
        JPanel jPanel = new JPanel(new GroupLayout(3,1));
        Label label = new Label(LABEL_CHOICE_WIN_LENGTH);
        labelWinLength = new Label(WIN_LENGTH_PREFIX + MIN_SIZE);
        winSlider = new JSlider(MIN_SIZE,MAX_SIZE,MIN_SIZE);
        winSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(SIZE_PREFIX + winSlider.getValue());
            }
        });
        jPanel.add(label);
        jPanel.add(labelWinLength);
        jPanel.add(winSlider);
        return jPanel;
    }
}
