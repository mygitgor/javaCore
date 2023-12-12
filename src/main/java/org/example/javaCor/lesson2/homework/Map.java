package org.example.javaCor.lesson2.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

public class Map extends JPanel {
    public static final Random random = new Random();
    public static final int HUMAN_DOT = 1;
    public static final int AI_DOT = 2;
    public static final int EMPTY_DOT = 0;
    public static final int PADDING = 10;
    private int gameStartType;
    public static final int STATE_GAME = 0;
    public static final int STATE_WIN_HUMAN = 1;
    public static final int STATE_WIN_AI = 2;
    public static final int STATE_DRAW = 3;

    public static final String MSG_WIN_HUMAN = "Победил игрок!";
    public static final String MSG_WIN_AI = "Победил компьютер!";
    public static final String MSG_DRAW = "Ничья!";

    private int width, height, cellWith, cellHeight;
    private int mode, fieldSizeX, fieldSizeY, winLen;
    private  int[][] field;
    private boolean gameWork;

    Map(){
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(gameWork){
                    update(e);
                }
            }
        });
    }

    private  void  initMap(){
        field = new int[fieldSizeX][fieldSizeY];
    }

    void startNewGame(int mode, int sizeX, int sizeY,int winLen){
        this.mode = mode;
        this.fieldSizeX = sizeX;
        this.fieldSizeY = sizeY;
        this.winLen = winLen;

        initMap();
        gameWork = true;
        gameStartType = STATE_GAME;

        repaint();
    }

    private  void update(MouseEvent mouseEvent){
        int x = mouseEvent.getX()/ cellWith;
        int y = mouseEvent.getY()/ cellHeight;
        if(!isValidCell(x,y) || !isEmptyCell(x,y)){
            return;
        }
        field[x][y] = HUMAN_DOT;
        if(checkEndGame(HUMAN_DOT,STATE_WIN_HUMAN)){
            return;
        }
        aiTurn();
        repaint();
        checkEndGame(AI_DOT,STATE_WIN_AI);
    }

    private  void testBoard(){
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
        System.out.println();
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y <= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[x][y] == EMPTY_DOT;
    }

    private void  aiTurn(){
        int x,y;
        do{
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }while (!isEmptyCell(x,y));{
            field[x][y] = AI_DOT;
        }
    }

    private boolean isMapFull(){
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(field[i][j] == EMPTY_DOT){
                    return false;
                }
            }
        }
        return true;
    }

    private  boolean checkEndGame(int dot, int gameOverType){
        if(checkWin(dot)){
            this.gameStartType = gameOverType;
            repaint();
            return true;
        }else if(isMapFull()){
            this.gameStartType = STATE_DRAW;
            repaint();
            return true;
        }
        return false;
    }

    private boolean checkWin(int dot) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if(checkLine(i, j, 1, 0, winLen, dot))return true;
                if(checkLine(i, j, 1, 1, winLen, dot))return true;
                if(checkLine(i, j, 0, 1, winLen, dot))return true;
                if(checkLine(i, j, 1, -1, winLen, dot))return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int winLen, int dot) {
        int far_x = x + (winLen - 1) * vx;
        int far_y = y + (winLen - 1) * vy;
        if(!isValidCell(far_x, far_y)){
            return false;
        }
        for (int i = 0; i < winLen ; i++) {
            if(field[y + i * vy][x + i * vx] != dot){
                return false;
            }
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(gameWork){
            render(g);
        }
    }

    private void render(Graphics g) {

    }

}
