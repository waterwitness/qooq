package mqq.observer;

import java.util.HashMap;

public abstract interface HttpVerifyHandler
{
  public abstract void cancelVerifyCode(String paramString, HashMap paramHashMap);
  
  public abstract void refreVerifyCode(String paramString, HashMap paramHashMap);
  
  public abstract void submitVerifyCode(String paramString1, HashMap paramHashMap, String paramString2);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\observer\HttpVerifyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */