

import java.util.ArrayList;
//not in graph =-1,Empty=0,Green=1,purple=2,red=3,yellow=4,black=5,blue=6
//green red purple player
// yellow black blue AI
public class Graph {

    public  Node[][] graph=new Node[17][25];
    public static ArrayList<Node> AINode =new ArrayList<>();
    public static ArrayList<Node> PlayerNode =new ArrayList<>();

    public Graph() {
        for(int i=0;i<17;i++){
            for(int j=0;j<25;j++){
                graph[i][j]=new Node();
                graph[i][j].row=i;
                graph[i][j].column=j;
            }
        }
        graph[0][0].color=-1;
        graph[0][1].color=-1;
        graph[0][2].color=-1;
        graph[0][3].color=-1;
        graph[0][4].color=-1;
        graph[0][5].color=-1;
        graph[0][6].color=-1;
        graph[0][7].color=-1;
        graph[0][8].color=-1;
        graph[0][9].color=-1;
        graph[0][10].color=-1;
        graph[0][11].color=-1;
        graph[0][12].color=1;
        graph[0][13].color=-1;
        graph[0][14].color=-1;
        graph[0][15].color=-1;
        graph[0][16].color=-1;
        graph[0][17].color=-1;
        graph[0][18].color=-1;
        graph[0][19].color=-1;
        graph[0][20].color=-1;
        graph[0][21].color=-1;
        graph[0][22].color=-1;
        graph[0][23].color=-1;
        graph[0][24].color=-1;

//========================================
//row 1
        graph[1][0].color=-1;
        graph[1][1].color=-1;
        graph[1][2].color=-1;
        graph[1][3].color=-1;
        graph[1][4].color=-1;
        graph[1][5].color=-1;
        graph[1][6].color=-1;
        graph[1][7].color=-1;
        graph[1][8].color=-1;
        graph[1][9].color=-1;
        graph[1][10].color=-1;
        graph[1][11].color=1;
        graph[1][12].color=-1;
        graph[1][13].color=1;
        graph[1][14].color=-1;
        graph[1][15].color=-1;
        graph[1][16].color=-1;
        graph[1][17].color=-1;
        graph[1][18].color=-1;
        graph[1][19].color=-1;
        graph[1][20].color=-1;
        graph[1][21].color=-1;
        graph[1][22].color=-1;
        graph[1][23].color=-1;
        graph[1][24].color=-1;

//========================================
//row 2

        graph[2][0].color=-1;
        graph[2][1].color=-1;
        graph[2][2].color=-1;
        graph[2][3].color=-1;
        graph[2][4].color=-1;
        graph[2][5].color=-1;
        graph[2][6].color=-1;
        graph[2][7].color=-1;
        graph[2][8].color=-1;
        graph[2][9].color=-1;
        graph[2][10].color=1;
        graph[2][11].color=-1;
        graph[2][12].color=1;
        graph[2][13].color=-1;
        graph[2][14].color=1;
        graph[2][15].color=-1;
        graph[2][16].color=-1;
        graph[2][17].color=-1;
        graph[2][18].color=-1;
        graph[2][19].color=-1;
        graph[2][20].color=-1;
        graph[2][21].color=-1;
        graph[2][22].color=-1;
        graph[2][23].color=-1;
        graph[2][24].color=-1;

//========================================
//row 3

        graph[3][0].color=-1;
        graph[3][1].color=-1;
        graph[3][2].color=-1;
        graph[3][3].color=-1;
        graph[3][4].color=-1;
        graph[3][5].color=-1;
        graph[3][6].color=-1;
        graph[3][7].color=-1;
        graph[3][8].color=-1;
        graph[3][9].color=1;
        graph[3][10].color=-1;
        graph[3][11].color=1;
        graph[3][12].color=-1;
        graph[3][13].color=1;
        graph[3][14].color=-1;
        graph[3][15].color=1;
        graph[3][16].color=-1;
        graph[3][17].color=-1;
        graph[3][18].color=-1;
        graph[3][19].color=-1;
        graph[3][20].color=-1;
        graph[3][21].color=-1;
        graph[3][22].color=-1;
        graph[3][23].color=-1;
        graph[3][24].color=-1;
        //----------------------------------------
        graph[7][0].color=-1;
        graph[7][1].color=-1;
        graph[7][2].color=-1;
        graph[7][3].color= 0;
        graph[7][4].color=-1;
        graph[7][5].color=0;
        graph[7][6].color=-1;
        graph[7][7].color=0;
        graph[7][8].color=-1;
        graph[7][9].color=0;
        graph[7][10].color=-1;
        graph[7][11].color=0;
        graph[7][12].color=-1;
        graph[7][13].color=0;
        graph[7][14].color=-1;
        graph[7][15].color=0;
        graph[7][16].color=-1;
        graph[7][17].color=0;
        graph[7][18].color=-1;
        graph[7][19].color=0;
        graph[7][20].color=-1;
        graph[7][21].color=0;
        graph[7][22].color=-1;
        graph[7][23].color=-1;
        graph[7][24].color=-1;

        graph[6][0].color=-1;
        graph[6][1].color=-1;
        graph[6][2].color=0;
        graph[6][3].color=-1;
        graph[6][4].color=0;
        graph[6][5].color=-1;
        graph[6][6].color=0;
        graph[6][7].color=-1;
        graph[6][8].color=0;
        graph[6][9].color=-1;
        graph[6][10].color=0;
        graph[6][11].color=-1;
        graph[6][12].color=0;
        graph[6][13].color=-1;
        graph[6][14].color=-0;
        graph[6][15].color=-1;
        graph[6][16].color=0;
        graph[6][17].color=-1;
        graph[6][18].color=0;
        graph[6][19].color=-1;
        graph[6][20].color=0;
        graph[6][21].color=-1;
        graph[6][22].color=0;
        graph[6][23].color=-1;
        graph[6][24].color=-1;

        graph[5][0].color=-1;
        graph[5][1].color=0;
        graph[5][2].color=-1;
        graph[5][3].color=0;
        graph[5][4].color=-1;
        graph[5][5].color=0;
        graph[5][6].color=-1;
        graph[5][7].color=0;
        graph[5][8].color=-1;
        graph[5][9].color=0;
        graph[5][10].color=-1;
        graph[5][11].color=0;
        graph[5][12].color=-1;
        graph[5][13].color=0;
        graph[5][14].color=-1;
        graph[5][15].color=0;
        graph[5][16].color=-1;
        graph[5][17].color=0;
        graph[5][18].color=-1;
        graph[5][19].color=0;
        graph[5][20].color=-1;
        graph[5][21].color=0;
        graph[5][22].color=-1;
        graph[5][23].color=0;
        graph[5][24].color=-1;

        graph[4][0].color=0;
        graph[4][1].color=-1;
        graph[4][2].color=0;
        graph[4][3].color=-1;
        graph[4][4].color=0;
        graph[4][5].color=-1;
        graph[4][6].color=0;
        graph[4][7].color=-1;
        graph[4][8].color=0;
        graph[4][9].color=-1;
        graph[4][10].color=0;
        graph[4][11].color=-1;
        graph[4][12].color=0;
        graph[4][13].color=-1;
        graph[4][14].color=-0;
        graph[4][15].color=-1;
        graph[4][16].color=0;
        graph[4][17].color=-1;
        graph[4][18].color=0;
        graph[4][19].color=-1;
        graph[4][20].color=0;
        graph[4][21].color=-1;
        graph[4][22].color=0;
        graph[4][23].color=-1;
        graph[4][24].color=0;
        //------------------------------------------
        graph[8][0].color=-1;
        graph[8][1].color=-1;
        graph[8][2].color=-1;
        graph[8][3].color=-1;
        graph[8][4].color=0;
        graph[8][5].color=-1;
        graph[8][6].color=0;
        graph[8][7].color=-1;
        graph[8][8].color=0;
        graph[8][9].color=-1;
        graph[8][10].color=0;
        graph[8][11].color=-1;
        graph[8][12].color=0;
        graph[8][13].color=-1;
        graph[8][14].color=-0;
        graph[8][15].color=-1;
        graph[8][16].color=0;
        graph[8][17].color=-1;
        graph[8][18].color=0;
        graph[8][19].color=-1;
        graph[8][20].color=0;
        graph[8][21].color=-1;
        graph[8][22].color=-1;
        graph[8][23].color=-1;
        graph[8][24].color=-1;

        graph[9][0].color=-1;
        graph[9][1].color=-1;
        graph[9][2].color=-1;
        graph[9][3].color=0;
        graph[9][4].color=-1;
        graph[9][5].color=0;
        graph[9][6].color=-1;
        graph[9][7].color=0;
        graph[9][8].color=-1;
        graph[9][9].color=0;
        graph[9][10].color=-1;
        graph[9][11].color=0;
        graph[9][12].color=-1;
        graph[9][13].color=0;
        graph[9][14].color=-1;
        graph[9][15].color=0;
        graph[9][16].color=-1;
        graph[9][17].color=0;
        graph[9][18].color=-1;
        graph[9][19].color=0;
        graph[9][20].color=-1;
        graph[9][21].color=0;
        graph[9][22].color=-1;
        graph[9][23].color=-1;
        graph[9][24].color=-1;

        graph[10][0].color=-1;
        graph[10][1].color=-1;
        graph[10][2].color=0;
        graph[10][3].color=-1;
        graph[10][4].color=0;
        graph[10][5].color=-1;
        graph[10][6].color=0;
        graph[10][7].color=-1;
        graph[10][8].color=0;
        graph[10][9].color=-1;
        graph[10][10].color=0;
        graph[10][11].color=-1;
        graph[10][12].color=0;
        graph[10][13].color=-1;
        graph[10][14].color=-0;
        graph[10][15].color=-1;
        graph[10][16].color=0;
        graph[10][17].color=-1;
        graph[10][18].color=0;
        graph[10][19].color=-1;
        graph[10][20].color=0;
        graph[10][21].color=-1;
        graph[10][22].color=0;
        graph[10][23].color=-1;
        graph[10][24].color=-1;

        graph[11][0].color=-1;
        graph[11][1].color=0;
        graph[11][2].color=-1;
        graph[11][3].color=0;
        graph[11][4].color=-1;
        graph[11][5].color=0;
        graph[11][6].color=-1;
        graph[11][7].color=0;
        graph[11][8].color=-1;
        graph[11][9].color=0;
        graph[11][10].color=-1;
        graph[11][11].color=0;
        graph[11][12].color=-1;
        graph[11][13].color=0;
        graph[11][14].color=-1;
        graph[11][15].color=0;
        graph[11][16].color=-1;
        graph[11][17].color=0;
        graph[11][18].color=-1;
        graph[11][19].color=0;
        graph[11][20].color=-1;
        graph[11][21].color=0;
        graph[11][22].color=-1;
        graph[11][23].color=0;
        graph[11][24].color=-1;

        graph[12][0].color=0;
        graph[12][1].color=-1;
        graph[12][2].color=0;
        graph[12][3].color=-1;
        graph[12][4].color=0;
        graph[12][5].color=-1;
        graph[12][6].color=0;
        graph[12][7].color=-1;
        graph[12][8].color=0;
        graph[12][9].color=-1;
        graph[12][10].color=0;
        graph[12][11].color=-1;
        graph[12][12].color=0;
        graph[12][13].color=-1;
        graph[12][14].color=-0;
        graph[12][15].color=-1;
        graph[12][16].color=0;
        graph[12][17].color=-1;
        graph[12][18].color=0;
        graph[12][19].color=-1;
        graph[12][20].color=0;
        graph[12][21].color=-1;
        graph[12][22].color=0;
        graph[12][23].color=-1;
        graph[12][24].color=0;
        //------------------------------------------
        graph[13][0].color=-1;
        graph[13][1].color=-1;
        graph[13][2].color=-1;
        graph[13][3].color=-1;
        graph[13][4].color=-1;
        graph[13][5].color=-1;
        graph[13][6].color=-1;
        graph[13][7].color=-1;
        graph[13][8].color=-1;
        graph[13][9].color=2;
        graph[13][10].color=-1;
        graph[13][11].color=2;
        graph[13][12].color=-1;
        graph[13][13].color=2;
        graph[13][14].color=-1;
        graph[13][15].color=2;
        graph[13][16].color=-1;
        graph[13][17].color=-1;
        graph[13][18].color=-1;
        graph[13][19].color=-1;
        graph[13][20].color=-1;
        graph[13][21].color=-1;
        graph[13][22].color=-1;
        graph[13][23].color=-1;
        graph[13][24].color=-1;
        //------------------------------------------
        graph[14][0].color=-1;
        graph[14][1].color=-1;
        graph[14][2].color=-1;
        graph[14][3].color=-1;
        graph[14][4].color=-1;
        graph[14][5].color=-1;
        graph[14][6].color=-1;
        graph[14][7].color=-1;
        graph[14][8].color=-1;
        graph[14][9].color=-1;
        graph[14][10].color=2;
        graph[14][11].color=-1;
        graph[14][12].color=2;
        graph[14][13].color=-1;
        graph[14][14].color=2;
        graph[14][15].color=-1;
        graph[14][16].color=-1;
        graph[14][17].color=-1;
        graph[14][18].color=-1;
        graph[14][19].color=-1;
        graph[14][20].color=-1;
        graph[14][21].color=-1;
        graph[14][22].color=-1;
        graph[14][23].color=-1;
        graph[14][24].color=-1;
        //--------------------------------------------
        graph[15][0].color=-1;
        graph[15][1].color=-1;
        graph[15][2].color=-1;
        graph[15][3].color=-1;
        graph[15][4].color=-1;
        graph[15][5].color=-1;
        graph[15][6].color=-1;
        graph[15][7].color=-1;
        graph[15][8].color=-1;
        graph[15][9].color=-1;
        graph[15][10].color=-1;
        graph[15][11].color=2;
        graph[15][12].color=-1;
        graph[15][13].color=2;
        graph[15][14].color=-1;
        graph[15][15].color=-1;
        graph[15][16].color=-1;
        graph[15][17].color=-1;
        graph[15][18].color=-1;
        graph[15][19].color=-1;
        graph[15][20].color=-1;
        graph[15][21].color=-1;
        graph[15][22].color=-1;
        graph[15][23].color=-1;
        graph[15][24].color=-1;
//------------------------------------
        graph[16][0].color=-1;
        graph[16][1].color=-1;
        graph[16][2].color=-1;
        graph[16][3].color=-1;
        graph[16][4].color=-1;
        graph[16][5].color=-1;
        graph[16][6].color=-1;
        graph[16][7].color=-1;
        graph[16][8].color=-1;
        graph[16][9].color=-1;
        graph[16][10].color=-1;
        graph[16][11].color=-1;
        graph[16][12].color=2;
        graph[16][13].color=-1;
        graph[16][14].color=-1;
        graph[16][15].color=-1;
        graph[16][16].color=-1;
        graph[16][17].color=-1;
        graph[16][18].color=-1;
        graph[16][19].color=-1;
        graph[16][20].color=-1;
        graph[16][21].color=-1;
        graph[16][22].color=-1;
        graph[16][23].color=-1;
        graph[16][24].color=-1;
        InitiPos();
    }
    public void printGraph(){
        System.out.print("  ");
        for(int i=0;i<25;i++){
            System.out.print(i+" ");
            if(i<10){
                System.out.print(" ");
            }
        }
        System.out.print('\n');
        for(int i=0;i<17;i++)
        {
            System.out.print(i+" ");
            for (int j = 0; j < 25; j++) {
                //System.out.println(i+" ");
                if (graph[i][j].color == -1)
                    System.out.print("  ");
                if (graph[i][j].color == 1) {
                    System.out.print("R");
                    System.out.print(" ");
                }
                if (graph[i][j].color == 2) {
                    System.out.print("B");
                    System.out.print(" ");
                }
                if (graph[i][j].color == 0) {
                    System.out.print("_");
                    System.out.print(" ");
                }
                System.out.print(" ");

            }
            System.out.print('\n');
        }
    }
    public void InitiPos(){
        for(int i=0;i<17;i++){
            for(int j=0;j<25;j++){
                Node subNode=new Node();
                subNode.row=i;
                subNode.column=j;
                if(graph[i][j].color==1){
                    subNode.color=1;
                    AINode.add(subNode);
                }
                else if(graph[i][j].color==2){
                    subNode.color=2;
                    PlayerNode.add(subNode);
                }

            }
        }
    }

    public Graph(Node[][] graph) {
        for(int i=0;i<17;i++){
            for(int j=0;j<25;j++){
                this.graph[i][j]=new Node();
                this.graph[i][j].color=graph[i][j].color;
                this.graph[i][j].row=graph[i][j].row;
                this.graph[i][j].column=graph[i][j].column;
                this.graph[i][j].prevRow=graph[i][j].prevRow;
                this.graph[i][j].prevColumn=graph[i][j].prevColumn;
            }
        }
    }

    public int playerWin(){
        int Sum =0;
        for(int i=0;i<10;i++){
            if(graph[AINode.get(i).row][AINode.get(i).column].color==2){
                Sum++;
            }
        }
        return Sum;
    }
    public int aiWin(){
        int Sum =0;
        for(int i=0;i<10;i++){
            if(graph[PlayerNode.get(i).row][PlayerNode.get(i).column].color==1){
                Sum++;
            }
        }
        return Sum;
    }

    public int win(){
        int playerSum =0,aiSum=0;
        aiSum= aiWin();
        playerSum= playerWin();
        if(playerSum==10){
            return -1;
        }
        else if(aiSum==10){
            return 1;
        }
        else{
            return 0;
        }
    }

}