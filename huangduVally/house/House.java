package huangduVally.house;

import java.io.Serializable;

/**
 * @project: HappyFarm
 * @description:
 * @designPattern: CompositeEntity, Visitor, Singleton, DoubleCheckLocking,Proxy
 **/
public class House implements Serializable {
    private static House instance;
    public static House getInstance() {
        if (instance == null) {
            // 双重检查锁定//////////
            // 保证了同一时间只能只能有一个对象访问此同步块
            synchronized (House.class) {
                if(instance==null){
                    instance=new House();
                }
            }
        }
        return instance;
    }

    // house name
    public static String houseName="尚未设置房屋名称";

    public static String getHouseName(){
        return houseName;
    }

    public static void showHouseName(){
        System.out.println("房屋的名称为："+ houseName);
    }

    public static void setHouseName(String newHouseName){
       houseName = newHouseName;
       showHouseName();
    }



//    Memento memento = new Memento();
//    memento.setState(clonedRurnitureList);
//    Memento.addState(memento);

    //空调
//    private building.house.airconditioner.AirConditioner airConditioner = (building.house.airconditioner.AirConditioner) new building.house.airconditioner.ProxyConditioner();

    // Adds furniture in the room
//    private ArrayList<AbstractFurniture> furnitures = new ArrayList<>();

//    public void addFurniture(AbstractFurniture abstractFurniture) {
//        if (null == furnitures) {
//            furnitures = new ArrayList<>();
//        }
//        furnitures.add(abstractFurniture);
//        System.out.println("Success to add the " + abstractFurniture.getName() + " to the " + getName());
//    }

//    public void showFurnitures(){
//        System.out.println("the furnitures are:");
//        for(AbstractFurniture f:furnitures){
//            System.out.println(f.getName());
//        }
//        if(furnitures.size()==0)
//            System.out.println("nothing");
//        System.out.println("**********");
//    }
//    public void addFurniture(AbstractFurniture furniture){
//        furnitures.add(furniture);
//    }
//    public void removeFuniture(Furniture furniture){
//        for(int i=furnitures.size()-1;i>=0;i--){
//
//            if(furnitures.get(i).getName()==furniture.getName()){
//                furnitures.remove(i);
//            }
//        }
//    }

//    public void showFurnitures(){
//        System.out.println("the furnitures are:");
//        for(Furniture f:furnitures){
//            System.out.println(f.getName());
//        }
//        if(furnitures.size()==0)
//            System.out.println("nothing");
//        System.out.println("**********");
//    }
////    public void addFurniture(AbstractFurniture furniture){
////        furnitures.add(furniture);
////    }
//    public void removeFuniture(Furniture furniture){
//        for(int i=furnitures.size()-1;i>=0;i--){
//
//            if(furnitures.get(i).getName()==furniture.getName()){
//                furnitures.remove(i);
//            }
//        }
//    }
//




}
