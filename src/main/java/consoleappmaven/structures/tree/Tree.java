package consoleappmaven.structures.tree;

/**
 * @author atsikhamirau on 12.02.2019
 */
public class Tree {

    private int value;

    private Tree right;

    private Tree left;

    public Tree(int value) {
        this.value = value;
    }

    public void insert(int value) {
        if (value <= this.value) {
            if (left == null) {
                left = new Tree(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Tree(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == this.value) {
            return true;
        } else if (value < this.value) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

}
