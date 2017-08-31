package treesandgraphs;

public class BT {
    private BTNode root;

    public BT(){
        root = null;
    }

    public boolean add(int value){
        if(root == null){
            root = new BTNode(value);
            return true;
        }
        else
            return root.add(value);
    }

    public boolean search(int value){
        if(root==null)
            return false;
        else
            return root.search(value);
    }

    public boolean remove(int value){
        if(root==null)
            return false;
        else if(root.getData()==value){
            BTNode dummyRoot = new BTNode(0);
            dummyRoot.setLeft(root);
            boolean result = root.remove(value,dummyRoot);
            root = dummyRoot.getLeft();
            return result;
        }
        else{
            return root.remove(value,null);
        }
    }

    public void inOrder(BTNode node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.getData());
            inOrder(node.right);
        }
    }

    public void preOrder(BTNode node){
        if(node!=null){
            System.out.print(node.getData());
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(BTNode node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.getData());
        }
    }

    public static void main(String[] args) {
        BT tree = new BT();
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.inOrder(tree.root);
    }
}

class BTNode{
    private int data;
    BTNode left,right;

    public BTNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public int getData(){
        return data;
    }

    public BTNode getLeft(){
        return left;
    }

    public BTNode getRight(){
        return right;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public boolean add(int value){
        if(data==value)
            return false;
        else if(value<data){
            if(left==null){
                left = new BTNode(value);
                return true;
            }
            else{
                return left.add(value);
            }
        }
        else if(value>data){
            if(right==null){
                right = new BTNode(value);
                return true;
            }
            else{
                return right.add(value);
            }
        }
        return false;
    }

    public boolean search(int value){
        if(data==value)
            return true;
        else if(value<data){
            if(left==null)
                return false;
            else
                return left.search(value);
        }
        else if(value>data){
            if(right==null)
                return false;
            else
                return right.search(value);
        }
        return false;
    }

    public boolean remove(int value,BTNode parent){
        if(value<data){
            if(left!=null)
                return left.remove(value,this);
            else
                return false;
        }
        else if(value>data){
            if(right!=null)
                return right.remove(value,this);
            else
                return false;
        }
        else{
            if(left!=null && right!=null){
                this.data = getMinValue(right);
                right.remove(this.data,this);
            }
            else if(parent.left==this)
                parent.left=(left!=null)?left:right;
            else if(parent.right==this)
                parent.right=(left!=null)?left:right;
            return true;
        }
    }

    private int getMinValue(BTNode node) {
        if(node.left==null)
            return this.data;
        else
            return getMinValue(node.left);
    }

}
