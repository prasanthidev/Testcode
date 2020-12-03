package helper;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BSTTest {

    @Test
    public void testBST (){
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorder();
    }

}