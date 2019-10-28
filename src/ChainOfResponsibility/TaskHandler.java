package ChainOfResponsibility;

/**
 * the base class of handler
 */

public abstract class TaskHandler {
    protected TaskHandler nextHandler;//the next handler of the chain

    /**
     * add handler to the chain
     * @param nextHandler
     */
    public final void setNextHandler(TaskHandler nextHandler) {
        if(this.nextHandler==null)
            this.nextHandler = nextHandler;
        else
            this.nextHandler.setNextHandler(nextHandler);
    }

    /**
     * get the type of the handler to know whether it can handle the request.
     * @return the type of handler
     */
    protected abstract String getType();

    /**
     * the concrete method to handle the request
     * @param request
     */
    protected abstract void handle(Request request);

    /**
     * the base method of handling request
     * the template method of the pattern
     * @param request
     */
    public final void handleRequest(Request request){
        if(!request.isParsed()){//parse request firstly
            request.parse();
        }

        if(this.getType()==request.requestType())//type match,handle
            this.handle(request);
        else{                                     //not match,pass it to the next handler of the chain (if it exists)
            if(this.nextHandler!=null)
                this.nextHandler.handleRequest(request);
            else
                System.out.println("All of our handlers cannot handle this task(request)!");
        }
    }
}
