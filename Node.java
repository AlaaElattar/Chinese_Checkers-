

import java.util.Objects;

public class Node {
    protected int row;
    protected int column;
    protected int color;
    protected int prevRow;
    protected int prevColumn;

    public Node() {
    }

    public Node(Node node){
        this.color=node.color;
        this.column=node.column;
        this.row=node.row;
        prevColumn=node.prevColumn;
        prevRow= node.prevRow;
    }
    public Node(int row, int column, int color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return row == node.row && column == node.column && color == node.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, color, prevRow, prevColumn);
    }

    @Override
    public String toString() {
        return "Node:" +"\n"+
                "row=" + row +"\n"+
                ", column=" + column +"\n"+
                ", color=" + color +"\n"+
                '}';
    }
}