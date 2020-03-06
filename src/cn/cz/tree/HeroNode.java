package cn.cz.tree;

/**
 * @author Kartoffel
 * @create 2020-03-05-14:44
 */
public class HeroNode {
    private int no;   //英雄排序
    private String name;   //英雄名称
    private HeroNode left;   //树左节点
    private HeroNode right;   //树右节点

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //前序遍历方法
    public void preOrder(){
        System.out.println(this);
        //递归向左遍历
        if(this.left != null){
            this.left.preOrder();
        }
        //递归向右遍历
        if(this.right!= null){
            this.right.preOrder();
        }
    }

    //中序遍历方法
    public void infixOrder(){
        //递归向左遍历
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        //递归向右遍历
        if(this.right!= null){
            this.right.infixOrder();
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        //如果就是当前,直接返回
        if(this.no == no){
            return this;
        }

        //借助辅助变量存放是否找到
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        //如果resNode不为空,说明向左递归时候已经找到
        if(resNode != null){
            //找到,直接返回
            return resNode;
        }

        //如果没找,向右递归查找
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }

        //当递归结束直接放回resNode
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        //借助辅助变量存放是否找到
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        //如果resNode不为空,说明向左递归时候已经找到
        if(resNode != null){
            //找到,直接返回
            return resNode;
        }
        //如果就是当前,直接返回
        if(this.no == no){
            return this;
        }

        //如果没找,向右递归查找
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }

        //当递归结束直接放回resNode
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        //借助辅助变量存放是否找到
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        //如果resNode不为空,说明向左递归时候已经找到
        if(resNode != null){
            //找到,直接返回
            return resNode;
        }

        //如果没找,向右递归查找
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }

        //如果就是当前,直接返回
        if(this.no == no){
            return this;
        }
        //当递归结束直接放回resNode
        return resNode;
    }
    //后续遍历方法
    public void postOrder(){
        //递归向左遍历
        if(this.left != null){
            this.left.postOrder();
        }
        //递归向右遍历
        if(this.right!= null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //删除节点方法
    // 由于此时二叉树是一个单项二叉树
    // 所以删除节点的节点应该是当前节点的子节点,然后把当前节点的左右节点置null
    public void delete(int no){
        //首先遍历左边节点
        //首先必须满足当前节点的左节点不为空
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        //首先必须满足当前节点的左节点不为空
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //条件结束,不满足条件,那就像左递归继续判断
        if(this.left!= null){
            this.left.delete(no);
        }
        //右递归继续判断
        if (this.right!= null){
            this.right.delete(no);
        }

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
