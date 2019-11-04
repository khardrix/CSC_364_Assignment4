package bstreconstruction;

// IMPORTS of needed tools and plug-ins
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
        // get and insert the current root or TreeNode
        preOrderReconstructedBST.insert(inputArray.get(0));

        // set i to 1 and loop until the index of the first value larger than the root
        int i = 1;
        for(;i < inputArray.size() && inputArray.get(i) < inputArray.get(0); i++){ }

        // check that the index is valid in the current sub-list and recusively call this method with that list
        if(i > 1) {
            List<Integer> leftArray = inputArray.subList(1, i);
            preOrderReconstructor(leftArray);
        }
        // check that the index is valid in the current sub-list and recusively call this method with that list
        if(i < inputArray.size()) {
            List<Integer> rightArray = inputArray.subList(i, inputArray.size());
            preOrderReconstructor(rightArray);
        }
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
        // get and insert the current root or TreeNode
        postOrderReconstructedBST.insert(inputArray.get(inputArray.size() - 1));

        // set i to 0 and loop until the index of the first value larger than the root
        int i = 0;
        for(;i < inputArray.size() - 1 && inputArray.get(i) < inputArray.get(inputArray.size() - 1); i++){ }

        // check that the index is valid in the current sub-list and recusively call this method with that list
        if(i > 0) {
            List<Integer> leftArray = inputArray.subList(0, i);
            postOrderReconstructor(leftArray);
        }
        // check that the index is valid in the current sub-list and recusively call this method with that list
        if(i < inputArray.size() - 1) {
            List<Integer> rightArray = inputArray.subList(i, inputArray.size() - 1);
            postOrderReconstructor(rightArray);
        }
    }
}
