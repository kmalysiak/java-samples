package pl.coderstrust.hoare_partition;

public class HoarePartition {
    public TableWithPivot getPartitioned(int[] input, int pivotIndex) {
        TableWithPivot result = new TableWithPivot();
        result.setTable(input.clone());
        if (pivotIndex != 0) {
            swap(result.getTable(), 0, pivotIndex);
        }
        int pivotValue = result.getTable()[0];
        int firstNumGreaterThanPivot = 1;
        for (int i = 1; i < result.getTable().length; i++) {
            if (result.getTable()[i] < pivotValue) {
                swap(result.getTable(), i, firstNumGreaterThanPivot);
                firstNumGreaterThanPivot++;
            }
        }
        swap(result.getTable(), 0, firstNumGreaterThanPivot - 1);
        result.setPivotIndex(firstNumGreaterThanPivot - 1);
        return result;
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
}
