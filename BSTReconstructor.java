package bstreconstruction;

import java.util.ArrayList;
import java.util.List;

public class BSTReconstructor {
    static bstreconstruction.BST<Integer> originalBST;
    static bstreconstruction.BST<Integer> preOrderReconstructedBST = new bstreconstruction.BST<>();
    static bstreconstruction.BST<Integer> postOrderReconstructedBST = new bstreconstruction.BST<>();

    static List<Integer> inOrderOutput;
    static List<Integer> preOrderOutput;
    static List<Integer> postOrderOutput;

    static Integer[] input = { 35, 25, 65, 30, 15, 20, 95, 45, 40, 55, 32, 60, 75 };

    public static void main(String[] args) {

        // Create BST from input
        originalBST = new bstreconstruction.BST<>(input);

        // Generate in/pre/post order traversal lists
        generateBSTTraversalLists();

        // Reconstruct BST from traversal lists of original BST
        System.out.println("Reconstructing BSTs from pre and post order traversal lists.");
        preOrderReconstructor(preOrderOutput);
        postOrderReconstructor(postOrderOutput);

        reconstructionVerificationTests();

    }

    // Generate in/pre/post order traversal lists
    private static void generateBSTTraversalLists() {
        inOrderOutput = originalBST.inorder();
        System.out.println("In-order: " + inOrderOutput);

        preOrderOutput = originalBST.preorder();
        System.out.println("Pre-order: " + preOrderOutput);

        postOrderOutput = originalBST.postorder();
        System.out.println("Post-order: " + postOrderOutput);

    }

    private static void reconstructionVerificationTests() {

        System.out.println("preOrderReconstructedBST should be true: " + originalBST.isEqualTo(preOrderReconstructedBST));
        System.out.println("postOrderReconstructedBST should be true: " + originalBST.isEqualTo(postOrderReconstructedBST));

        System.out.println("Inserting and deleting 65 from original BST");
        originalBST.delete(65);
        originalBST.insert(65);

        System.out.println("preOrderReconstructedBST should be false: " + originalBST.isEqualTo(preOrderReconstructedBST));
        System.out.println("postOrderReconstructedBST should be false: " + originalBST.isEqualTo(postOrderReconstructedBST));

        System.out.println("Inserting and deleting 65 from preOrderReconstructed BST");
        preOrderReconstructedBST.delete(65);
        preOrderReconstructedBST.insert(65);

        System.out.println("preOrderReconstructedBST should be true: " + originalBST.isEqualTo(preOrderReconstructedBST));
        System.out.println("postOrderReconstructedBST should be false: " + originalBST.isEqualTo(postOrderReconstructedBST));

        System.out.println("Inserting and deleting 65 from postOrderReconstructed BST");
        postOrderReconstructedBST.delete(65);
        postOrderReconstructedBST.insert(65);

        System.out.println("preOrderReconstructedBST should be true: " + originalBST.isEqualTo(preOrderReconstructedBST));
        System.out.println("postOrderReconstructedBST should be true: " + originalBST.isEqualTo(postOrderReconstructedBST));
    }

    // Reconstruct BST from pre-order traversal lists of original BST.
    // This method will take an inputArray of pre-order traversal items
    // and re-create the original BST, and save reconstructed tree in the
    // preOrderReconstructedBST variable.
    private static void preOrderReconstructor(List<Integer> inputArray) {
        // TO DO
        /** This method will take an inputArray of pre-order traversal items and create the original
          * BST, and save reconstructed tree in the preOrderReconstructedBST variable.
         */

        /*
        Below is the algorithm to reconstruct the BST with a given pre-order traversal.
            1. The first element in the current input array is the root.
            2. Loop from the second element till the end.
            3. Stop when the element is greater than the root.
            4. Split the array into two sub-arrays, which implies the elements in the left and right
                   sub-trees.
            5. Recursively start from step 1 to reconstruct the left and right subtrees from the two
                   sub-arrays.

        Example:
            Pre-Order traversal input: 35, 25, 15, 20, 30, 32, 65, 45, 40, 55, 60, 95, 75
            Root: 35
            Left-sub-array: 25, 15, 20, 30, 32
            Right-sub-array: 65, 45, 40, 55, 60, 95, 75
            Recursively repeat for left and right sub-arrays.

        Original BST:
            35, 25, 65, 30, 15, 20, 95, 45, 40, 55, 32, 60, 75
         */


    }

    // Reconstruct BST from post-order traversal lists of original BST.
    // This method will take an inputArray of post-order traversal items
    // and re-create the original BST, and save reconstructed tree in the
    // postOrderReconstructedBST variable.
    private static void postOrderReconstructor(List<Integer> inputArray) {
        // TO DO
        /** This method will take an inputArray of post-order traversal items and create the original
          * BST, and save the reconstructed tree in the postOrderReconstructedBST variable.
         */
    }
}
