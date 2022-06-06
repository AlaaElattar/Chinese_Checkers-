

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        State currState=new State();
        Game g=new Game();
        currState.InitializeSystem();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcom in My Game :)\n you Can't bet my AI :)");
        System.out.println("choose \n 1-Easy \n 3-medium \n 5-Hard");
        int level=sc.nextInt();
        currState.gra.printGraph();
        while(true){
            boolean isFirst=true;
            while(true){
                System.out.println("Please Enter Row and Column of the Piece.");
                int r=sc.nextInt();
                int c=sc.nextInt();
                System.out.println("Please Enter Row and Column of the new Place.");
                int newr=sc.nextInt();
                int newc=sc.nextInt();
                State state=g.moveHuman(r,c,newr,newc,currState,isFirst);
                if(state==null){
                    System.out.println("Invalid Move, choose Another :)");
                    continue;
                }
                isFirst=false;
                currState.gra.printGraph();
                while(currState.hasValidMoves(newr,newc,r,c)){
                    System.out.println("Do you want to choose Another Place ?(y/n)");
                    String choose=sc.next();
                    if(choose.equals("n")){
                        break;
                    }
                    r=newr;
                    c=newc;
                    System.out.println("Please Enter Row and Column of the new Place.");
                    newr=sc.nextInt();
                    newc=sc.nextInt();
                    state=g.moveHuman(r,c,newr,newc,currState,isFirst);
                    if(state==null){
                        System.out.println("Invalid Move, choose Another :)");
                        newr=r;
                        newc=c;
                    }
                    currState.gra.printGraph();
                }
                break;
            }
            currState=g.alphaBeta(currState.nextPlayer,level);
            currState.gra.printGraph();
            int win=currState.gra.win();
            if(win==1){
                System.out.println("Computer Has Win :)");
                System.out.println("You are Loser :(");
                break;
            }
            else if(win==-1){
                System.out.println("You Has Win :)");
                System.out.println("Computer are Loser :(");
                break;
            }
            //currState=currState.nextPlayer;
        }
    }
}
