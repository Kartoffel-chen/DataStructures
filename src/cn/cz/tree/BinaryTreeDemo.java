package cn.cz.tree;

/**
 * @author Kartoffel
 * @create 2020-03-05-14:33
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree by = new BinaryTree();
        HeroNode heroNode1 = new HeroNode(1,"宋江");
        HeroNode heroNode2 = new HeroNode(2,"吴用");
        HeroNode heroNode3 = new HeroNode(3,"玉麒麟");
        HeroNode heroNode4 = new HeroNode(4,"林冲");
        HeroNode heroNode5 = new HeroNode(5,"李逵");

        //手动添加树节点
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);

        by.setRoot(heroNode1);

//        System.out.println("未删除前的二叉树");
//        by.preOrder();
//        System.out.println("删除后的节点信息");
//        by.delete(3);
//        by.preOrder();

//        by.preOrderSearch(1);
//        by.infixOrderSearch(1);
//        by.postOrderSearch(1);

        //前序遍历测试
        System.out.println("前序遍历,顺序应该为 : 1 , 2 , 3 , 5 , 4");
        by.preOrder();

        //中序遍历测试
        System.out.println("中序测试,顺序应该为 : 2 , 1 , 5 , 3 , 4");
        by.infixOrder();

        //后续遍历测试
        System.out.println("后续测试,顺序应该为 : 2 , 5 , 4 , 3 , 1");
        by.postOrder();
    }
}
