import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
class pos{
    int i, j;
    public pos(int x, int y){
        i=x;j=y;
    }
}
public class MainGUI
{
    public static Color colorPlayer;
    public static Color colorAI;
    public static State currState = new State();
    public static boolean isFirst = true;
    public static int cnt = 0;
    public static int row;
    public static int column;
    public static int newR, newC;
    public static int depth;
    public static Game game = new Game();
    public static HashMap<JButton, pos> buttonPos=new HashMap();
    public static JButton b[][] = new JButton[17][25];//creating instance of JButton
    static JFrame mode = new JFrame("Choose Mode of the Game");
    static JFrame f = new JFrame();
    static JFrame moveAgain = new JFrame();
    static JFrame ChooseColor = new JFrame("Choose Color of the Game");
    public static void changeState(){
        for(int i =0; i<17; i++){
            for(int j=0; j<25; j++){
                setColor(b[i][j], currState.gra.graph[i][j].color);
            }

        }
    }
    public static void setColor(JButton b, int c){
        if(c ==-1){
            b.setBackground(Color.WHITE);
        }else if(c==0)
            b.setBackground(Color.black);
        else if(c==1)
            b.setBackground(colorAI);
        else if(c==2)
            b.setBackground(colorPlayer);
    }
    public static void won(){
        int win = currState.gra.win();
        if(win==1){
            JOptionPane.showMessageDialog(f, "Computer Won", "Match Ended", JOptionPane.CLOSED_OPTION);
            f.dispose();
        }
        else if(win==-1){
            JOptionPane.showMessageDialog(f, "You have Won", "Match Ended", JOptionPane.CLOSED_OPTION);
            f.dispose();
        }
    }
    public static void generateModeFrame(){

        JButton easy = new JButton("Easy");
        easy.setBounds(50, 50, 100, 50);
        JButton medium = new JButton("Medium");
        medium.setBounds(160, 50, 100, 50);
        JButton hard= new JButton("Hard");
        hard.setBounds(270, 50, 100, 50);
        mode.add(easy);
        mode.add(medium);
        mode.add(hard);
        mode.setBackground(Color.WHITE);
        mode.setSize(420, 150);//400 width and 500 height
        mode.setLayout(null);//using no layout managers
        mode.setVisible(true);//making the frame visible
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depth=1;
                f.setVisible(true);
                mode.dispose();
            }
        });
       medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depth=3;
                f.setVisible(true);
                mode.dispose();
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depth=5;
                f.setVisible(true);
                mode.dispose();
            }
        });
    }
    public static void generateColorFrame(){
        JButton red = new JButton("Red");
        red.setBounds(50, 50, 100, 50);
        JButton blue = new JButton("blue");
        blue.setBounds(160, 50, 100, 50);
        ChooseColor.add(red);
        ChooseColor.add(blue);
        ChooseColor.setBackground(Color.WHITE);
        ChooseColor.setSize(420, 150);//400 width and 500 height
        ChooseColor.setLayout(null);//using no layout managers
        ChooseColor.setVisible(true);//making the frame visible
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorPlayer=Color.red;
                colorAI=Color.blue;
                ChooseColor.dispose();
                generateModeFrame();
                changeState();
            }
        });
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorPlayer=Color.blue;
                colorAI=Color.red;
                ChooseColor.dispose();
                generateModeFrame();
                changeState();
            }
        });

    }
    public static void moveAgainFrame(){
        JLabel label = new JLabel("Do you want to hop again?");
        label.setBounds(60, 10, 200, 40);
        moveAgain.add(label);
        JButton easy = new JButton("Yes");
        easy.setBounds(50, 60, 80, 40);
        JButton medium = new JButton("No");
        medium.setBounds(140, 60, 80, 40);
        moveAgain.add(easy);
        moveAgain.add(medium);
        moveAgain.setBackground(Color.WHITE);
        moveAgain.setSize(340, 170);//400 width and 500 height
        moveAgain.setLayout(null);//using no layout managers
        moveAgain.setVisible(false);//making the frame visible
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isFirst=false;
                row = newR;
                column=newC;
                b[row][column].setBackground(Color.green);
                moveAgain.setVisible(false);
            }
        });
        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cnt=0;
                isFirst=true;
                moveAgain.setVisible(false);
                currState = game.alphaBeta(currState.nextPlayer,depth);
                changeState();
                won();

            }
        });
    }
    public static void main(String[] args) {
        currState.InitializeSystem();
        Graph g =new Graph();
        generateColorFrame();
        moveAgainFrame();

        int x =10;
        for(int i =0; i<17; i++){
            int y = 10;
            for(int j=0; j<25; j++){
                b[i][j]=new JButton("");
                b[i][j].setBounds(y, x, 20, 20);
                b[i][j].setBorder(BorderFactory.createEmptyBorder());
                pos p = new pos(i, j);
                buttonPos.put(b[i][j], p);
                setColor(b[i][j],g.graph[i][j].color);
                f.add(b[i][j]);
                y+=21;
            }
            x+=21;
        }

        for(int i =0; i<17; i++){
            for(int j=0; j<25; j++){
                b[i][j].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JButton caller = (JButton)e.getSource();
                        pos clicked=buttonPos.get(caller);
                        if(isFirst&&cnt==0){
                            row= clicked.i;
                            column= clicked.j;
                            cnt++;
                            b[row][column].setBackground(Color.green);

                        }else if(isFirst && cnt==1){

                            newR=clicked.i;
                            newC=clicked.j;
                            cnt++;
                            State temp=game.moveHuman(row, column, newR, newC, currState, isFirst);
                            if (temp==null){
                                changeState();
                                JOptionPane.showMessageDialog(f, "Invalid move", "Error", JOptionPane.INFORMATION_MESSAGE);
                                cnt=0;
                            }else{
                                currState=temp;
                                changeState();
                                won();
                                if(!currState.hasValidMoves(newR,newC, row, column)){
                                    currState = game.alphaBeta(currState.nextPlayer, depth);
                                    changeState();
                                    won();
                                    cnt=0;
                                }
                                else{
                                    b[newR][newC].setBackground(Color.green);
                                    moveAgain.setVisible(true);
                                }
                            }
                        }else if(!isFirst){
                            newR=clicked.i;
                            newC=clicked.j;
                            State temp=game.moveHuman(row, column, newR, newC, currState, isFirst);
                            if (temp==null){
                                JOptionPane.showMessageDialog(null, "Invalid move", "Error", JOptionPane.INFORMATION_MESSAGE);
                                moveAgain.setVisible(true);
                            }else {
                                changeState();
                                b[newR][newC].setBackground(Color.green);
                                moveAgain.setVisible(true);
                                
                            }
                        }

                    }
                });
            }
        }
        f.setBackground(Color.WHITE);
        f.setSize(590, 430);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(false);//making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
