public class BinaryTree <E>{
    int size;
    Node<E> root;

    public BinaryTree () {
        size =0;
        root=null;
    }


    public BinaryTree(E val) {
        root = new Node(val);

        // root node only
        size=1;

    }
    public boolean isEmpty() {
        return size==0;
    }


    public Node<E> addLeft(Node<E> node, E val) {
        Node<E> n = new Node(val);
        node.addLeft(n);
        size++;
        return n;
    }


    public Node<E> addRight(Node<E> node, E val) {

        Node<E> n = new Node(val);
        node.addRight(n);
        size++;
        return n ;
    }

    public Node<E> checkLocation(Node<E> n, E val)
    {
        if (n!=null)
        {

            if(n.getLeft() == null){
                if((int)n.getInfo() > (int)val)
                {

                    return n;
                }
                else {
                    System.out.println("lOC: " + checkLocation(n.getLeft(), val));
                    return checkLocation(n.getLeft(), val);
                }
            }


            if(n.getRight() == null)
            {
                if((int)n.getInfo() < (int) val)
                {
                    return n;
                }
                else {
                    System.out.println("lOC: " + checkLocation(n.getRight(), val));

                }
            }


            if(checkLocation(n,val) != null)
            {
                return checkLocation(n.getLeft(),val);
            }
            if(checkLocation(n,val) != null)
            {
                return checkLocation(n.getRight(),val);
            }

        }
        return null;
    }

    public void preOrder(Node<E> n) {

        if (n==null) return;
        System.out.println(n.getInfo());
        preOrder(n.getLeft());
        preOrder(n.getRight());

    }

    public void inOrder(Node<E> n) {

        if (n==null) return;
        inOrder(n.getLeft());
        System.out.println(n.getInfo());
        inOrder(n.getRight());

    }

    public boolean checkValue(Node<E> n, E val )
    {
        if (n!=null)
        {

            if(n.getLeft() != null){
                if(n.getLeft().getInfo() == val)
                {
                    return true;
                }
            }


            if(n.getRight() != null)
            {
                if(n.getRight().getInfo()== val)
                {
                    return true;
                }
            }

            if(checkValue(n.getLeft(),val) == true )
                return true;
            if(checkValue(n.getRight(),val) == true)
                return true;

        }
        return false;

    }
    public E findMin(Node<E> n)
    {
        if( n!= null)
        {
            if(n.getLeft() == null) {
                return  n.getInfo();
            }
            else
                return findMin(n.getLeft());


        }
        return null;
    }
    public E findMax(Node<E> n){
        if( n!= null)
        {
            if(n.getRight() == null) {
                return  n.getInfo();
            }
            else
                return findMax(n.getRight());


        }
        return null;
    }

    public void postOrder(Node<E> n) {

        if (n==null) return;

        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.println(n.getInfo());

    }


/*
    public static void main(String[] args){

        // BinaryTree<String> bt = new BinaryTree<>("cat");
        // bt.addLeft(bt.root,"dog");
        // bt.addRight(bt.root,"mouse");
        BinaryTree<Integer> bt = new BinaryTree<>(23);
        Node<Integer> n1 =bt.addLeft(bt.root,17);
        Node<Integer> n2 = bt.addRight(bt.root,30);
        bt.addLeft(n1,14);
        bt.addRight(n1,20);
        bt.addLeft(n2,25);
        bt.addRight(n2,37);
        bt.inOrder(bt.root);
    }
    */

}
