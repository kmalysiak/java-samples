package pl.coderstrust.hoare_partition;

public class TableWithPivot {
    private int[] table;
    private int pivotIndex;

    public int[] getTable() {
        return table;
    }

    public void setTable(int[] table) {
        this.table = table;
    }

    public int getPivotIndex() {
        return pivotIndex;
    }

    public void setPivotIndex(int pivotIndex) {
        this.pivotIndex = pivotIndex;
    }

    public int getPivotValue(){
        if(pivotIndex>0 && pivotIndex<table.length){
            return table[pivotIndex];
        }
        else return -1;
    }
}
