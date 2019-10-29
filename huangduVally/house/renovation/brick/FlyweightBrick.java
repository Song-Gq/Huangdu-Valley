package huangduVally.house.renovation.brick;

// 使用工厂，通过传递砖的材质信息来获取实体类的对象。
public class FlyweightBrick {
    private static final String textures[] =
            { "wooden", "marble", "ceramic"};

    public static void FlyweightBrick() {
        for(int i=0; i < 20; ++i) {
            Floorboard floorboard =
                    (Floorboard) BrickFactory.getFloorboard(getRandomTexture());
            floorboard.setX(getRandomX());
            floorboard.setY(getRandomY());
            floorboard.setTexture(getRandomTexture());
            floorboard.isDisplay();
        }
    }
    // 随机生成
    private static String getRandomTexture() {
        return textures[(int)(Math.random()*textures.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}