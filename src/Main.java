public class Main {
    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<>();

        tree.add(5);            //                  5
        tree.add(3);            //             3          8
        tree.add(2);            //         2       4          12
        tree.add(1);            //      1                 9
        tree.add(8);            //
        tree.add(12);           //
        tree.add(4);            //
        // tree.add(9);
        tree.dfs(it -> System.out.print(it + " "));
        System.out.println();
        tree.bfs(it -> System.out.print(it + " "));
        System.out.println();
        System.out.println(tree.contains(9));
    }
}