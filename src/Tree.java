import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;

public class Tree<T extends Comparable<T>> {

    private Node root;

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Objects.requireNonNull(value);
        root = appendNote(root, value);
    }

    private Node appendNote(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }
        int compare = value.compareTo(current.value);
        if (compare < 0) {
            current.left = appendNote(current.left, value);
        } else if (compare > 0) {
            current.right = appendNote(current.right, value);
        }
        return current;
    }

    public void dfs(Consumer<T> valueAcceptor) {
        dfs(root, valueAcceptor);
    }

    private void dfs(Node current, Consumer<T> valueAcceptor) {
        valueAcceptor.accept(current.value);
        if (current.left != null) {
            dfs(current.left, valueAcceptor);
        }
        if (current.right != null) {
            dfs(current.right, valueAcceptor);
        }
    }

    public void bfs(Consumer<T> valueAcceptor) {
        bfs(root, valueAcceptor);
    }

    private void bfs(Node current, Consumer<T> valueAcceptor) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Node next = queue.poll();
            valueAcceptor.accept(next.value);

            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
            }
        }
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node current, T value) {
        if (current.value.compareTo(value) == 0) {
            return true;
        } else if (current.value.compareTo(value) > 0) {
            if (current.left != null) {
                current = current.left;
                contains(current, value);
            } else {
                return false;
            }
        } else {
            if (current.right != null) {
                current = current.right;
                contains(current, value);
            } else {
                return false;
            }
        }
        return contains(current, value);
    }
}
