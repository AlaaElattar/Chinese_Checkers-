

import java.util.ArrayList;

import static java.lang.Math.abs;

public class State {
    public ArrayList<Node>myNodes=new ArrayList<>();
    public Graph gra;
    public State nextPlayer;
    public int alpha=Integer.MIN_VALUE;
    public int beta=Integer.MAX_VALUE;

    /**
     * in main after playing state to alternate players;
     * Player p = curPlayer.nextPlayer
     */
    public State(){
    }
    public void InitializeSystem(){ // initial State, player begins, nextPlayer will have computer values
        gra = new Graph();
        for(int i = 0; i<gra.PlayerNode.size(); i++){
            myNodes.add(new Node(gra.PlayerNode.get(i)));
        }
        nextPlayer=new State();
        nextPlayer.gra=gra;
        nextPlayer.nextPlayer=this;
        for(int i = 0; i<gra.AINode.size(); i++){
            nextPlayer.myNodes.add(new Node(gra.AINode.get(i)));
        }
    }

    public State(ArrayList<Node> myNodes, Graph g, State nextPlayer) {
        for(int i=0;i<myNodes.size();i++){
            Node subNode=new Node();
            subNode.color=myNodes.get(i).color;
            subNode.row=myNodes.get(i).row;
            subNode.column=myNodes.get(i).column;
            subNode.prevRow=myNodes.get(i).prevRow;
            subNode.prevColumn=myNodes.get(i).prevColumn;
            this.myNodes.add(subNode);
        }
        gra=new Graph(g.graph);
        this.nextPlayer = new State();
        this.nextPlayer.gra=gra;
        this.nextPlayer.nextPlayer=this;
        for(int i=0;i<myNodes.size();i++){
            Node subNode=new Node();
            subNode.color=nextPlayer.myNodes.get(i).color;
            subNode.row=nextPlayer.myNodes.get(i).row;
            subNode.column=nextPlayer.myNodes.get(i).column;
            this.nextPlayer.myNodes.add(subNode);
        }
    }

    public boolean Contain(ArrayList<Node>arr){
        for(int i=0;i<10;i++){
            if(!this.myNodes.contains(arr.get(i))){
                return false;
            }
        }
        return true;
    }

    public Node getNode(int r,int c){
        for(int i=0;i<myNodes.size();i++){
            if(myNodes.get(i).row==r&&myNodes.get(i).column==c){
                return myNodes.get(i);
            }
        }
        return null;
    }

    public boolean hasValidMoves(int newRow, int newColumn, int row,int column){
        if((abs(row-newRow)==1&&abs(column-newColumn)==1)||(abs(row-newRow)==0&&abs(column-newColumn)==2)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "State:\n" +
                "myNodes=" + myNodes.size() +"\n"+
                ", alpha=" + alpha +"\n"+
                ", beta=" + beta +"\n"+
                ".";
    }
}