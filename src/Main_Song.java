
// this includes main method for testing scene "The Farm" by Song Guanqun
public class Main_Song {

    public static void main(String[] args) throws Exception
    {
        Storage storage = Storage.getInstance();

        storage.addItems("carrotSeed", 1);
        storage.addItems("potatoSeed", 2);
        storage.addBag("myLittleBag");
        storage.into("myLittleBag");
        storage.addBag("testBag");
        //storage.addBag("testBag");
        storage.into("testBag");
        //storage.addItems("testItems", -1);
        storage.addItems("testItems", 100);
        storage.addItems("testItems", 3);
        storage.getItems("testItems").setCount(99);
        //storage.deleteItems("testItems");
        storage.back();
        storage.deleteBag("testBag");
        storage.back();
        //storage.back();
        //storage.deleteBag("noBag");
        //storage.deleteItems("noItems");
        storage.getBag("myLittleBag").getItems("testItems");

    }

}
