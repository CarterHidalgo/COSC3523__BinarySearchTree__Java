import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    private static int[] minData;
    private static int[] maxData;
    private static double[] avgData;
    
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        int startSize = 100_000;
        int endSize = 10_000_000;
        int stepSize = 100_000;
        int sampleSize = 50;

        int min = -1;
        int max = -1;
        int sum = 0;
        double avg = 0;

        maxData = new int[(int) ((endSize - startSize) / stepSize) + 1];
        minData = new int[(int) ((endSize - startSize) / stepSize) + 1];
        avgData = new double[(int) ((endSize - startSize) / stepSize) + 1];
        int index = 0;
        double time;

        System.out.println("Generating " + avgData.length + " data points");

        for(int size = startSize; size <= endSize; size += stepSize) {
            time = System.currentTimeMillis();
            for(int sample = 0; sample < sampleSize; sample++) {
                int height = createBST(size);
                
                if(height < min || min < 0) {
                    min = height;
                }
                
                if(height > max || max < 0) {
                    max = height;
                }
                
                sum += height;
            }
            
            avg = sum / (double) sampleSize;
            
            minData[index] = min;
            maxData[index] = max;
            avgData[index] = avg;
            
            time = System.currentTimeMillis() - time;
            System.out.println((index + 1) + "/" + maxData.length + " " + size + " elements in " + time + " ms  |  " + minData[index] + " " + maxData[index] + " " + avgData[index]);
            
            sum = 0;
            min = -1;
            max = -1;
            index++;
        }
        System.out.println("Program Terminated");

        writeData();
    }

    private static int createBST(int size) {
        Node root = null;
        root = insert(root, (int) (Math.random() * 500_000));

        for(int i = 1; i < size; i++) {
            insert(root, (int) (Math.random() * 500_000));
        }

        return getHeight(root);
    }

    private static void writeData() {
        String outputFile = "data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(">> MIN DATA");
            writer.newLine();

            for(int min : minData) {
                writer.write(String.valueOf(min));
                writer.newLine();
            }

            writer.write("\n>> MAX DATA");
            writer.newLine();

            for(int i : maxData) {
                writer.write(String.valueOf(i));
                writer.newLine();
            }

            writer.write("\n>> AVG DATA");
            writer.newLine();

            for(double i : avgData) {
                writer.write(String.valueOf(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static class Node {
        private int key;
        private Node left, right = null;

        public void setKey(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getLeft() {
            return left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getRight() {
            return right;
        }
    };

    private static Node createNode(int item) {
        Node root = new Node();

        root.setKey(item);
        root.setLeft(null);
        root.setRight(null);

        return root;
    }

    private static Node insert(Node node, int key) {
        if(node == null) {
            return createNode(key);
        }

        if(key < node.getKey()) {
            node.left = insert(node.getLeft(), key);
        } else if(key > node.getKey()) {
            node.right = insert(node.getRight(), key);
        }

        return node;
    }

    private static int getHeight(Node node) { 
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.left); 
            int rightHeight = getHeight(node.right); 
  
            if (leftHeight > rightHeight) {
                return (leftHeight + 1); 
            } else {
                return (rightHeight + 1); 
            }
        } 
    } 
}
