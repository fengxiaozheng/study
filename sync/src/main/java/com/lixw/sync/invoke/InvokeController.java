package com.lixw.sync.invoke;

/**
 * @author lixw
 * @date 2020/11/18
 */
public class InvokeController {

    public InvokeService getInvokeService() {
        return invokeService;
    }

    public void setInvokeService(InvokeService invokeService) {
        this.invokeService = invokeService;
    }

    @AutoWired
    private InvokeService invokeService;
}
