package huangduValley.farm.taskHandler;

import huangduValley.farm.Stdout;

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
     * @param command:concrete command sentence
     */
    public Request(String command){
        this.text=command;
        this.isParsed=false;
    }

    /**
     * method:parse the request to get its type
     */
    void parse(){
        if(text.contains("animal") || text.contains("Animal"))
            this.type="Animal";
        else if(text.contains("Plant") || text.contains("plant"))
            this.type="Plant";
        else if(text.contains("shop") || text.contains("Shop"))
            this.type="Shop";
        else if(text.contains("storage") || text.contains("Storage"))
            this.type="storage";
        else if(text.contains("Tools") || text.contains("tools"))
            this.type="Tools";
        else
        {
            this.type="Unknown";
            Stdout.print(this, "This request has something wrong.We can not handle it!");
        }

        this.isParsed=true;
    }

    /**
     * get the parsing type of request
     * @return isParsed
     */
    boolean isParsed(){
        return this.isParsed;
    }

    /**
     * get the type of request
     * @return request type
     */
    String requestType(){
        return this.type;
    }

    /**
     * get the concrete information of request
     * @return request text
     */
    String requestText(){return this.text;}
}
