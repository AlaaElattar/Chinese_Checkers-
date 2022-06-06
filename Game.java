

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Math.*;

enum direction {
    left, right, upLeft, upRight, downLeft, downRight
}

class Pair<T, U> {
    public final T t;
    public final U u;

    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }
}

public class Game {
    public static Node[] playerGoal=new Node[10];
    public static Node[] aiGoal=new Node[10];
    public static int aiIndex=0;
    public static int playerIndex=0;
    public Game() {
        for (int i = 0; i < 10; i++) {
            playerGoal[i] = new Node();
            aiGoal[i] = new Node();
        }
        playerGoal[0].row=0;
        playerGoal[0].column=12;
        playerGoal[1].row=1;
        playerGoal[1].column=11;
        playerGoal[2].row=1;
        playerGoal[2].column=13;
        playerGoal[3].row=2;
        playerGoal[3].column=10;
        playerGoal[4].row=2;
        playerGoal[4].column=12;
        playerGoal[5].row=2;
        playerGoal[5].column=14;
        playerGoal[6].row=3;
        playerGoal[6].column=9;
        playerGoal[7].row=3;
        playerGoal[7].column=11;
        playerGoal[8].row=3;
        playerGoal[8].column=13;
        playerGoal[9].row=3;
        playerGoal[9].column=15;
        aiGoal[0].row=16;
        aiGoal[0].column=12;
        aiGoal[1].row=15;
        aiGoal[1].column=11;
        aiGoal[2].row=15;
        aiGoal[2].column=13;
        aiGoal[3].row=14;
        aiGoal[3].column=10;
        aiGoal[4].row=14;
        aiGoal[4].column=12;
        aiGoal[5].row=14;
        aiGoal[5].column=14;
        aiGoal[6].row=13;
        aiGoal[6].column=9;
        aiGoal[7].row=13;
        aiGoal[7].column=11;
        aiGoal[8].row=13;
        aiGoal[8].column=13;
        aiGoal[9].row=13;
        aiGoal[9].column=15;

    }

    public State moveHuman(int row, int column, int newRow, int newColumn, State pl, boolean isFirst) {
        Node node = new Node();
        boolean exist = false;
        for (int i = 0; i < pl.myNodes.size(); i++) {
            if (pl.myNodes.get(i).row == row && pl.myNodes.get(i).column == column) {
                exist = true;
                node = pl.myNodes.get(i);
                break;
            }
        }
        if (!exist) {
            return null;
        }
        if (isFirst) {
            if ((abs(row - newRow) == 1 && abs(column - newColumn) == 1) || (abs(row - newRow) == 0 && abs(column - newColumn) == 2)) {
                if (pl.gra.graph[newRow][newColumn].color != 0) {
                    return null;
                }
                pl.gra.graph[newRow][newColumn].color = node.color;
                node.row = newRow;
                node.column = newColumn;
                pl.gra.graph[row][column].color = 0;
                return pl;
            }
        }

        if ((abs(row - newRow) == 2 && abs(column - newColumn) == 2) || (abs(row - newRow) == 0 && abs(column - newColumn) == 4)) {
            int middleRow = (row + newRow) / 2;
            int middleColumn = (column + newColumn) / 2;
            try {
                if (pl.gra.graph[middleRow][middleColumn].color == 0 || pl.gra.graph[middleRow][middleColumn].color == -1)
                    return null;
            } catch (Exception e) {
                return null;
            }
            pl.gra.graph[newRow][newColumn].color = node.color;
            node.row = newRow;
            node.column = newColumn;
            pl.gra.graph[row][column].color = 0;
            return pl;
        }
        return null;
    }

    public ArrayList<State> moveAI(State startState) {
        // System.out.println("hi");
        ArrayList<State> generateState = new ArrayList<>();
        for (int i = 0; i < startState.myNodes.size(); i++) {
            Node state = startState.myNodes.get(i);
            Graph gr = startState.gra;
            try {
                if (gr.graph[state.row - 1][state.column + 1].color == 0) {
                    if (state.row - 1 != state.prevRow || state.column + 1 != state.prevColumn)
                        generateState.add(changeState(startState, state.row, state.column, state.row - 1, state.column + 1).t);
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (gr.graph[state.row - 1][state.column - 1].color == 0) {
                    if (state.row - 1 != state.prevRow && state.column - 1 != state.prevColumn)
                        generateState.add(changeState(startState, state.row, state.column, state.row - 1, state.column - 1).t);
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (gr.graph[state.row + 1][state.column - 1].color == 0) {
                    if (state.row + 1 != state.prevRow && state.column - 1 != state.prevColumn)
                        generateState.add(changeState(startState, state.row, state.column, state.row + 1, state.column - 1).t);
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (gr.graph[state.row + 1][state.column + 1].color == 0) {
                    if (state.row + 1 != state.prevRow && state.column + 1 != state.prevColumn)
                        generateState.add(changeState(startState, state.row, state.column, state.row + 1, state.column + 1).t);
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (gr.graph[state.row][state.column + 2].color == 0) {
                    if (state.row != state.prevRow && state.column + 2 != state.prevColumn)
                        generateState.add(changeState(startState, state.row, state.column, state.row, state.column + 2).t);
                }

            } catch (Exception e) {
            }
            ;
            try {
                if (gr.graph[state.row][state.column - 2].color == 0) {
                    if (state.row != state.prevRow && state.column - 2 != state.prevColumn)
                        generateState.add(changeState(startState, state.row, state.column, state.row, state.column - 2).t);
                }
            } catch (Exception e) {
            }
            ;
            Hop(generateState, startState, state);
        }
        return generateState;
    }

    public void Hop(ArrayList<State> s, State state, Node node) {
        Stack<Pair<State, Node>> generated = new Stack<>();
        Pair<State, Node> initial = new Pair<>(state, node);
        generated.push(initial);
        while (!generated.empty()) {

            Pair<State, Node> current = generated.pop();
            Pair<State, Node> temp = hopRight(current.t, current.u);
            if (temp != null) {
                boolean flag = false;
                for (int i = 0; i < s.size(); i++) {
                    if (s.get(i).Contain(temp.t.myNodes)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && !state.Contain(temp.t.myNodes)) {
                    generated.push(temp);
                    s.add(temp.t);
                }
            }
            temp = hopLeft(current.t, current.u);
            if (temp != null) {
                boolean flag = false;
                for (int i = 0; i < s.size(); i++) {
                    if (s.get(i).Contain(temp.t.myNodes)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && !state.Contain(temp.t.myNodes)) {
                    generated.push(temp);
                    s.add(temp.t);
                }
            }
            temp = hopUpLeft(current.t, current.u);
            if (temp != null) {
                boolean flag = false;
                for (int i = 0; i < s.size(); i++) {
                    if (s.get(i).Contain(temp.t.myNodes)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && !state.Contain(temp.t.myNodes)) {
                    generated.push(temp);
                    s.add(temp.t);
                }
            }
            temp = hopDownLeft(current.t, current.u);
            if (temp != null) {
                boolean flag = false;
                for (int i = 0; i < s.size(); i++) {
                    if (s.get(i).Contain(temp.t.myNodes)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && !state.Contain(temp.t.myNodes)) {
                    generated.push(temp);
                    s.add(temp.t);
                }
            }
            temp = hopUpRight(current.t, current.u);
            if (temp != null) {
                boolean flag = false;
                for (int i = 0; i < s.size(); i++) {
                    if (s.get(i).Contain(temp.t.myNodes)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && !state.Contain(temp.t.myNodes)) {
                    generated.push(temp);
                    s.add(temp.t);
                }
            }
            temp = hopDownRight(current.t, current.u);
            if (temp != null) {
                boolean flag = false;
                for (int i = 0; i < s.size(); i++) {
                    if (s.get(i).Contain(temp.t.myNodes)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && !state.Contain(temp.t.myNodes)) {
                    generated.push(temp);
                    s.add(temp.t);
                }
            }
        }
    }

    public Pair<State, Node> changeState(State currState, int row, int column, int newRow, int newColumn) {
        boolean flag = false;
        State newState = new State(currState.myNodes, currState.gra, currState.nextPlayer);
        Node node = new Node();
        for (int i = 0; i < newState.myNodes.size(); i++) {
            if (newState.myNodes.get(i).row == row && newState.myNodes.get(i).column == column) {
                node = newState.myNodes.get(i);
                flag = true;
                break;
            }
        }
        if (flag) {
            node.row = newRow;
            node.column = newColumn;
            node.prevColumn = column;
            node.prevRow = row;
            newState.gra.graph[row][column].color = 0;
            newState.gra.graph[newRow][newColumn].color = node.color;
            newState.myNodes.remove(node);
            newState.myNodes.add(node);
        } else {
            return null;
        }
        return new Pair<>(newState, node);
    }

    public State alphaBeta(State state, int depth) {
        State temp = Max_Value(state, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);

        temp.alpha = Integer.MIN_VALUE;
        temp.beta = Integer.MAX_VALUE;
        temp.nextPlayer.alpha = Integer.MIN_VALUE;
        temp.nextPlayer.beta = Integer.MAX_VALUE;
        return temp.nextPlayer;
    }

    public State Max_Value(State state, int depth, int alpha, int beta) {

        if (depth == 0) {
            state.alpha = playerHeuristic(state);
            return state;
        }
        int win = state.gra.win();
        if (win == -1 || win == 1) {
            state.alpha = playerHeuristic(state);
            return state;
        }
        ArrayList<State> children = moveAI(state);
        //for(int i=0;i<children.size();i++){
        //System.out.println(children.size());
        //}
        if (children.size() == 0) {
            state.alpha = playerHeuristic(state);
            return state;
        }
        int v = Integer.MIN_VALUE;
        State bestState = null;
        for (int i = 0; i < children.size(); i++) {
            State child = Min_Value(children.get(i).nextPlayer, depth - 1, alpha, beta);
            int childHer = child.beta;
            if (v < childHer) {
                bestState = children.get(i);
                bestState.alpha = childHer;
            }
            v = Math.max(v, childHer);
            alpha = Math.max(alpha, v);
            if (alpha >= beta) {
                return bestState;
            }
        }
        return bestState;
    }

    public State Min_Value(State state, int depth, int alpha, int beta) {
        if (depth == 0) {
            state.beta = playerHeuristic(state);
            return state;
        }
        int win = state.gra.win();
        if (win == -1 || win == 1) {
            state.beta = playerHeuristic(state);
            return state;
        }
        ArrayList<State> children = moveAI(state);
        if (children.size() == 0) {
            state.beta = playerHeuristic(state);
            return state;
        }
        int v = Integer.MAX_VALUE;
        State bestState = null;
        for (int i = 0; i < children.size(); i++) {
            State child = Max_Value(children.get(i).nextPlayer, depth - 1, alpha, beta);
            int childHer = child.alpha;
            if (childHer < v) {
                bestState = children.get(i);
                bestState.beta=childHer;
            }
            v = Math.min(v, childHer);
            beta = Math.min(beta, v);

            if (alpha >= beta) {
                return bestState;
            }

        }
        return bestState;
    }

    /*
    * We calculate index of player and AI.
    * There's a special case when all nodes reach goal, playerIndex/aiIndex = 10.
    * */
    public void indexGoal(State s){
        aiIndex=0;
        playerIndex=0;
        for(int i=0;i<10;i++){
            if(s.gra.graph[playerGoal[i].row][playerGoal[i].column].color==2){
                playerIndex++;
            }
            else{
                break;
            }
        }
        for(int i=0;i<10;i++){
            if(s.gra.graph[aiGoal[i].row][aiGoal[i].column].color==1){
                aiIndex++;
            }
            else{
                break;
            }
        }
    }

    public int playerHeuristic(State s1) {
        indexGoal(s1);
        int sumPlayer = 0, aiSUm = 0;
        for (int i = 0; i < s1.myNodes.size(); i++) {
            int max;
            double distance;
            Node mynode = s1.myNodes.get(i);
            max = 14;   //max is the maximum distance.
            if (mynode.color == 1) {
                if(aiIndex==10){    //All nodes reach goal, distance is zero.
                    aiSUm=14*10;    //distance is zero, calculate aiSum for all nodes (max*numOfNodes)
                    break;
                }
                if(mynode.row>aiGoal[aiIndex].row||(mynode.row==aiGoal[aiIndex].row&&mynode.column<aiGoal[aiIndex].column)){
                    distance=0;
                }
                else{
                    distance = sqrt(pow(mynode.row - aiGoal[aiIndex].row, 2) + pow(mynode.column - aiGoal[aiIndex].column, 2));
                }
                aiSUm += max - distance;
            }
            else {
                if(playerIndex==10){
                    sumPlayer=14*10;
                    break;
                }
                if(mynode.row<playerGoal[playerIndex].row||(mynode.row==playerGoal[playerIndex].row&&mynode.column<playerGoal[playerIndex].column)){
                    distance=0;
                }
                else{
                    distance = sqrt(pow(mynode.row - playerGoal[playerIndex].row, 2) + pow(mynode.column - playerGoal[playerIndex].column, 2));
                }
                sumPlayer += max - distance;
            }
        }
        for (int i = 0; i < s1.nextPlayer.myNodes.size(); i++) {
            int max;
            double distance;
            Node mynode = s1.nextPlayer.myNodes.get(i);
            max = 14;
            if (mynode.color == 1) {
                if(aiIndex==10){
                    aiSUm=14*10;
                    break;
                }
                if(mynode.row>aiGoal[aiIndex].row||(mynode.row==aiGoal[aiIndex].row&&mynode.column<aiGoal[aiIndex].column)){
                    distance=0;
                }
                else{
                    distance = sqrt(pow(mynode.row - aiGoal[aiIndex].row, 2) + pow(mynode.column - aiGoal[aiIndex].column, 2));
                }
                aiSUm += max - distance;
            } else {
                if(playerIndex==10){
                    sumPlayer=14*10;
                    break;
                }
                if(mynode.row<playerGoal[playerIndex].row||(mynode.row==playerGoal[playerIndex].row&&mynode.column<playerGoal[playerIndex].column)){
                    distance=0;
                }
                else{
                    distance = sqrt(pow(mynode.row - playerGoal[playerIndex].row, 2) + pow(mynode.column - playerGoal[playerIndex].column, 2));
                }
                sumPlayer += max - distance;
            }
        }
        //System.out.println((aiSUm - sumPlayer));
        return aiSUm - sumPlayer;
    }

    public Pair<State, Node> hopRight(State state, Node node) {
        int r = node.row;
        int c = node.column + 4;
        try {
            if ((state.gra.graph[node.row][node.column + 2].color == 0 || state.gra.graph[node.row][node.column + 2].color == -1)) {
                return null;
            }
            if (state.gra.graph[node.row][node.column + 4].color != 0) {
                return null;
            }
            if (node.prevColumn == c && node.prevRow == r) {
                return null;
            }
            return changeState(state, node.row, node.column, r, c);
        } catch (Exception e) {
            return null;
        }
    }

    public Pair<State, Node> hopLeft(State state, Node node) {
        int r = node.row;
        int c = node.column - 4;
        try {
            if ((state.gra.graph[node.row][node.column - 2].color == 0 || state.gra.graph[node.row][node.column - 2].color == -1)) {
                return null;
            }
            if (state.gra.graph[node.row][node.column - 4].color != 0) {
                return null;
            }
            if (node.prevColumn == c && node.prevRow == r) {
                return null;
            }
            return changeState(state, node.row, node.column, r, c);
        } catch (Exception e) {
            return null;
        }
    }

    public Pair<State, Node> hopUpRight(State state, Node node) {
        int r = node.row - 2;
        int c = node.column + 2;
        try {
            if ((state.gra.graph[node.row - 1][node.column + 1].color == 0 || state.gra.graph[node.row - 1][node.column + 1].color == -1)) {
                return null;
            }
            if (state.gra.graph[node.row - 2][node.column + 2].color != 0) {
                return null;
            }
            if (node.prevColumn == c && node.prevRow == r) {
                return null;
            }
            return changeState(state, node.row, node.column, r, c);
        } catch (Exception e) {
            return null;
        }
    }

    public Pair<State, Node> hopUpLeft(State state, Node node) {
        int r = node.row - 2;
        int c = node.column - 2;
        try {
            if ((state.gra.graph[node.row - 1][node.column - 1].color == 0 || state.gra.graph[node.row - 1][node.column - 1].color == -1)) {
                return null;
            }
            if (state.gra.graph[node.row - 2][node.column - 2].color != 0) {
                return null;
            }
            if (node.prevColumn == c && node.prevRow == r) {
                return null;
            }
            return changeState(state, node.row, node.column, r, c);
        } catch (Exception e) {
            return null;
        }
    }

    public Pair<State, Node> hopDownRight(State state, Node node) {
        int r = node.row + 2;
        int c = node.column + 2;
        try {
            if ((state.gra.graph[node.row + 1][node.column + 1].color == 0 || state.gra.graph[node.row + 1][node.column + 1].color == -1)) {
                return null;
            }
            if (state.gra.graph[node.row + 2][node.column + 2].color != 0) {
                return null;
            }
            if (node.prevColumn == c && node.prevRow == r) {
                return null;
            }
            return changeState(state, node.row, node.column, r, c);
        } catch (Exception e) {
            return null;
        }
    }

    public Pair<State, Node> hopDownLeft(State state, Node node) {
        int r = node.row + 2;
        int c = node.column - 2;
        try {
            if ((state.gra.graph[node.row + 1][node.column - 1].color == 0 || state.gra.graph[node.row + 1][node.column - 1].color == -1)) {
                return null;
            }
            if (state.gra.graph[node.row + 2][node.column - 2].color != 0) {
                return null;
            }
            if (node.prevColumn == c && node.prevRow == r) {
                return null;
            }
            return changeState(state, node.row, node.column, r, c);
        } catch (Exception e) {
            return null;
        }
    }

}