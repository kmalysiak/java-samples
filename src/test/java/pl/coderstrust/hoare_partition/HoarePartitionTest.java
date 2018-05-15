package pl.coderstrust.hoare_partition;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class HoarePartitionTest {
    static  HoarePartition part = new HoarePartition();
    
    @Test
    public void shouldReturnCorrectlyPartitionedTableWhenPivotIndexUnchanged() {
        int input[] = new int[]{1, 7, 9, 4, 3, 2, 8, 5};
        TableWithPivot output = part.getPartitioned(input, 3);
        assertTrue(isPartitionedCheck(output));
    }

    @Test
    public void shouldReturnCorrectlyPartitionedTableWhenPivotIndexShiftsRight() {
        int input[] = new int[]{1, 7, 9, 4, 3, 2, 8, 5};
        TableWithPivot output = part.getPartitioned(input, 2);
        assertTrue(isPartitionedCheck(output));
    }

    @Test
    public void shouldReturnCorrectlyPartitionedTableWhenPivotIndexShiftsLeft() {
        int input[] = new int[]{1, 7, 9, 4, 3, 2, 20, 8};
        TableWithPivot output = part.getPartitioned(input, 5);
        assertTrue(isPartitionedCheck(output));
    }

    @Test
    public void shouldReturnPartitionedTableWithNoValuesChanged() {
        int input[] = new int[]{1, 7, 9, 4, 3, 2, 20, 8};
        TableWithPivot output = part.getPartitioned(input, 5);
        Arrays.sort(input);
        Arrays.sort(output.getTable());
        assertArrayEquals(output.getTable(), input);
    }

    private boolean isPartitionedCheck(TableWithPivot table) {
        boolean isPartitioned = true;
        for (int i = 0; (i < table.getPivotIndex() && isPartitioned); i++) {
            if (table.getTable()[i] > table.getPivotValue()) {
                isPartitioned = false;
            }
        }
        if (isPartitioned) {
            for (int i = table.getPivotIndex() + 1; (i < table.getTable().length && isPartitioned); i++) {
                if (table.getTable()[i] < table.getPivotValue()) {
                    isPartitioned = false;
                }
            }
        }
        return isPartitioned;
    }
}