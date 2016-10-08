package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

public abstract interface WtTicketPromise
{
  public abstract void Done(Ticket paramTicket);
  
  public abstract void Failed(ErrMsg paramErrMsg);
  
  public abstract void Timeout(ErrMsg paramErrMsg);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WtTicketPromise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */