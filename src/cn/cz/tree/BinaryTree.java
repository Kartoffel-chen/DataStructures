package cn.cz.tree;

/**
 * @author Kartoffel
 * @create 2020-03-05-14:46
 */
public class BinaryTree {
    //定义一个节点
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delete(int no){
        //首先判断当前二叉树是否为空
        if(this.root!=null){
            //在判断当前节点是否已经满足删除条件
            if(this.root.getNo() == no){
                root = null;
            }else{
                this.root.delete(no);
            }
        }else{
            System.out.println("二叉树为空,不能遍历");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,不能遍历");
        }
    }
    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,不能遍历");
        }
    }
    //前序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空,不能遍历");
        }
    }

    //前序遍历查找
    public void preOrderSearch(int no){
        HeroNode temp = this.root.preOrderSearch(no);
        if(temp!=null){
            System.out.println("找到英雄 " + temp);
        }else{
            System.out.println("要找到英雄不存在");
        }
    }
    //中序遍历查找
    public void infixOrderSearch(int no){
        HeroNode temp = this.root.infixOrderSearch(no);
        if(temp!=null){
            System.out.println("找到英雄 " + temp);
        }else{
            System.out.println("要找到英雄不存在");
        }
    }
    //后序遍历查找
    public void postOrderSearch(int no){
        HeroNode temp = this.root.postOrderSearch(no);
        if(temp!=null){
            System.out.println("找到英雄 " + temp);
        }else{
            System.out.println("要找到英雄不存在");
        }
    }
}
