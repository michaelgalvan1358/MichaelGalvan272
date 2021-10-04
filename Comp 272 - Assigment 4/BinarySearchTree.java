

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    BinaryTree<E> bt;
    public BinarySearchTree() {
        bt= new BinaryTree<>();

    }
    public BinarySearchTree(E val) {
        BinaryTree<E> bt1= new BinaryTree<E>(val);

        bt = bt1;


    }

    // returns true if BST has val else false.
    public boolean contains (E val) {
        Node<E> temp = bt.root.getLeft();
        Node<E> temp1 = bt.root.getRight();
        if(bt.checkValue(bt.root, val) == true){
            return true;
        }

        return false;

    }

    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
// if value is already there then donâ€™t insert it again
    public void insert(E val) {
        boolean status = true;
        if(bt.isEmpty()) {
        BinaryTree<E> bt1 = new BinaryTree<E>(val);
        bt = bt1;
        status = false;

    }
    //need to check this first instance to make sure it stops
    Node <E> currentNode = bt.root;
    Node<E> newNode = new Node<>(val);


    while(status = true)
    {
        if(currentNode.getLeft() != null && val.compareTo(currentNode.getInfo()) < 0)
        {
            currentNode = currentNode.getLeft();
        }
        else if(currentNode.getRight() != null && val.compareTo(currentNode.getInfo()) > 0)
        {

            currentNode = currentNode.getRight();
        }
        else if( currentNode.getLeft() == null && val.compareTo(currentNode.getInfo()) < 0 && this.contains(val) != true)
        {

            currentNode.addLeft(newNode);
            status = false;
            break;
        }
        else if(currentNode.getRight() == null && val.compareTo(currentNode.getInfo()) > 0 && this.contains(val) != true)
        {

            currentNode.addRight(newNode);
            status = false;
            break;

        }
        else break;
    }/*
    int v1 = (Integer)val;

    if( (Integer)bt.checkLocation(bt.root,val).getInfo()> v1)
    {
        bt.addLeft(checkLocation(bt.root, val),val);
    }


    if( (Integer)bt.checkLocation(bt.root,val).getInfo() < v1)
    {
        bt.addRight(checkLocation(bt.root ,val),val);
    }
    */
    }

    // returns the minimum value stored in the tree
    public E findMin() {


       return findMin(bt.root);
    }

    // returns the maximum value stored in the tree
    public E findMax() {
        return findMax(bt.root);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> lt= new BinarySearchTree<>(23);

        //System.out.println(lt.bt.root.getInfo() == 23);
        Node<Integer> n1 =lt.bt.addLeft(lt.bt.root,17);
        Node<Integer> n2 = lt.bt.addRight(lt.bt.root,30);
        lt.bt.addLeft(n1,14);
        lt.bt.addRight(n1,20);
        lt.bt.addLeft(n2,25);
        lt.bt.addRight(n2,37);
        lt.bt.inOrder(lt.bt.root);
        System.out.println(lt.contains(14));
        System.out.println("Max: " + lt.bt.findMax(lt.bt.root));
        System.out.println("Min: " + lt.bt.findMin(lt.bt.root));

        lt.insert(16);
        lt.insert(11);
        lt.insert(5);
        lt.insert(10);
        lt.insert(3);
        lt.insert(21);
        lt.insert(8);
        lt.insert(8);

        lt.bt.inOrder(lt.bt.root);
        ///System.out.println(lt.bt.checkLocation(lt.bt.root,20));

        //if(lt.bt.root.getRight().getInfo() > 13)
          //  System.out.println("hi");
       /* ;*/
    }
}
