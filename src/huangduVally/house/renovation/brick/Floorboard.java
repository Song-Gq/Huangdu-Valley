package huangduVally.house.renovation.brick;

import java.util.Scanner;
import java.util.regex.Pattern;
// 创建实现接口的实体类
public class Floorboard implements Brick {
    private static final String textures[] =
            { "木质", "大理石", "瓷质"};
    private int x;
    private int y;
    private String texture;

    public Floorboard(String texture){
        this.texture=texture;
    }

    public void setX(int x) {  this.x = x; }

    public void setY(int y) {
        this.y = y;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    @Override
    public void isDisplay() {
        System.out.println("坐标：【"+x+","+y+"】，材质："+texture);
    }



    }
