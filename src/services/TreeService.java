package services;

import model.Employee;
import model.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class TreeService {

    public static TreeNode buildLevelOrderTree(java.util.List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return null;
        }

        int limit = Math.min(20, employees.size());

        TreeNode root = new TreeNode(employees.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;

        while (index < limit) {
            TreeNode current = queue.peek();

            if (current.getLeft() == null) {
                TreeNode left = new TreeNode(employees.get(index));
                current.setLeft(left);
                queue.add(left);
                index++;
            } else if (current.getRight() == null) {
                TreeNode right = new TreeNode(employees.get(index));
                current.setRight(right);
                queue.add(right);
                queue.poll();
                index++;
            } else {
                queue.poll();
            }
        }

        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.getEmployee().getFullName() + " | " +
                    current.getEmployee().getManagerType() + " | " +
                    current.getEmployee().getDepartment());

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.getLeft());
        int right = height(root.getRight());
        return Math.max(left, right) + 1;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }
}
