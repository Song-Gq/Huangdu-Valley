package huangduValley.farm.taskHandler;

import huangduValley.farm.Stdout;

/**
 * the base class of handler
 */

public abstract class TaskHandler {
    private TaskHandler nextHandler;//the next handler of the chain

    /**
     * add handler to the chain
     * @param nextHandler:the next handler of chain
     */
    public final void setNextHandler(TaskHandler nextHandler) {
        if(this.nextHandler==null)
            this.nextHandler = nextHandler;
        else
            this.nextHandler.setNextHandler(nextHandler);
    }

    /**
     * set a default chain of handlers
     */
    public final void setHandlerChain(){
        this.setNextHandler(new AnimalTaskHandler());
        this.setNextHandler(new ShopTaskHandler());
        this.setNextHandler(new ToolsTaskHandler());
        this.setNextHandler(new StorageTaskHandler());
        this.setNextHandler(new PlantTaskHandler());
    }
    /**
     * get the type of the handler to know whether it can handle the request.
     * @return the type of handler
     */
    protected abstract String getType();

    /**
     * the concrete method to handle the request
     * @param request:the request to handle
     */
    protected abstract void handle(Request request) throws Exception;

    /**
     * the base method of handling request
     * the template method of the pattern
     * @param request:the request to handle
     */
    public final void handleRequest(Request request) throws Exception {
        if(!request.isParsed()){//parse request firstly
            request.parse();
        }

        if(this.getType().equals(request.requestType()))//type match,handle
            this.handle(request);
        else{                                     //not match,pass it to the next handler of the chain (if it exists)
            if(this.nextHandler!=null)
                this.nextHandler.handleRequest(request);
            else
                Stdout.print(this, "All of our handlers cannot handle this task(request)!");
        }
    }
}
