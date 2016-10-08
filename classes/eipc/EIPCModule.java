package eipc;

import android.os.Bundle;

public abstract class EIPCModule
{
  EIPCModuleManager a;
  int[] b = new int[0];
  public String name;
  
  public EIPCModule(String paramString)
  {
    this.name = paramString;
  }
  
  public EIPCModule(String paramString, int[] paramArrayOfInt)
  {
    this.name = paramString;
    this.b = paramArrayOfInt;
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    this.a.callbackResult(paramInt, paramEIPCResult);
  }
  
  public abstract EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt);
  
  public void onReceiveMsg(int paramInt, Bundle paramBundle) {}
  
  public String toString()
  {
    return "name:" + this.name;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\eipc\EIPCModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */