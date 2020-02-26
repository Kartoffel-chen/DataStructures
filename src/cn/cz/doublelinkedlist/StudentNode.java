package cn.cz.doublelinkedlist;

/**
 * 学生节点
 * @author Kartoffel
 * @create 2020-02-19-18:17
 */
public class StudentNode {
    private int id;
    private String name;
    private String nikeName;
    public StudentNode pro;   // 指向前一个节点
    public StudentNode next;   // 指向后一个节点

    public StudentNode(int id, String name, String nikeName) {
        this.id = id;
        this.name = name;
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "学生信息 " +
                "学号 : " + id +
                ", 姓名 : '" + name + '\'' +
                ", 外号 : '" + nikeName + '\'';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
}
