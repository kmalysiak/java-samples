package pl.coderstrust.christmas_tree;

public class ChristmasTree {
    void printChristmasTree(int treeSize) {
        if (treeSize > 0) {
            for (int i = 1; i <= treeSize + 1; i++) {
                int treeMaxWidth = treeSize * 2 - 1;
                int treeWidth = (i * 2 - 1);

                if (i == treeSize + 1) {
                    treeWidth = 2;
                }
                int treeStartPosition = (treeMaxWidth - treeWidth) / 2;

                for (int j = 0; j < treeStartPosition + treeWidth; j++) {
                    if (j < treeStartPosition) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
                System.out.print(System.getProperty("line.separator"));
            }
        }
    }
}
