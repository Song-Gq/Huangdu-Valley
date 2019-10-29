package huangduValley.farm.taskHandler;

/**
 * the Request class:each task will be expressed as a request
 * before the request is parsed,nobody knows its type so that we cannot be ware of the handler
 * to handle it.
 */
public class Request {
    private String text;//the concrete information of the request
    private String type;//the type of the request,which can only be known after parsing
    private boolean isParsed;//whether the request is parsed

    /**
     * constructor
     * @param command
     */
    public Request(String command){
        this.text=command;
        this.isParsed=false;
    }

    /**
     * method:parse the request to get its type
     */
    public void parse(){
        if(text.indexOf("animal")!=-1||text.indexOf("Animal")!=-1)
            this.type="Animal";
        else if(text.indexOf("Plant")!=-1||text.indexOf("plant")!=-1)
            this.type="Plant";
        else if(text.indexOf("shop")!=-1||text.indexOf("Shop")!=-1)
            this.type="Shop";
        else if(text.indexOf("warehouse")!=-1||text.indexOf("WareHouse")!=-1)
            this.type="WareHouse";
        else if(text.indexOf("Tools")!=-1||text.indexOf("tools")!=-1)
            this.type="Tools";
        else
        {
            this.type="Unknown";
            System.out.println("This request has something wrong.We can not handle it!");
        }

        this.isParsed=true;
    }

    /**
     * get the parsing type of request
     * @return isParsed
     */
    public boolean isParsed(){
        return this.isParsed;
    }

    /**
     * get the type of request
     * @return request type
     */
    public String requestType(){
        return this.type;
    }
}
