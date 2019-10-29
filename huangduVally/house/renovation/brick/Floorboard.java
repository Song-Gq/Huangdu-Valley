package huangduVally.house.renovation.brick;

import java.util.Scanner;
import java.util.regex.Pattern;
// 创建实现接口的实体类
public class Floorboard implements Brick {
    private static final String textures[] =
            { "wooden", "marble", "ceramic"};

    private int x;
    private int y;
    private String texture;

    public Floorboard(String texture){ this.texture=texture;}

    public void setX(int x) {  this.x = x; }

    public void setY(int y) {
        this.y = y;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    @Override
    public void isDisplay() {
        System.out.println("display floorboard: [texture :" + texture
                + ", x : " + x +", y :" + y);
    }

    @Override
    public void changeTexture() {
        for (; ; ) {
            System.out.println("你想要把什么材质的地砖呢？(请输入以下数字进行选择)");
            System.out.println("[1]木质 [2]大理石 [3]瓷质");

            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            Pattern pattern = Pattern.compile("[1-3]"); //正则表达式，Pattern和match
            if (pattern.matcher(key).matches()) {
                switch (key) {
                    case "1":
                        setTexture(textures[0]);
                        break;
                    case "2":
                        setTexture(textures[1]);
                        break;
                    case "3":
                        setTexture(textures[2]);
                        break;

                    default:
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("error! 错误输入!");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("\n");
                }
            } else {
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Error! 请重新输入! ");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("\n");

            }
        }


    }
}