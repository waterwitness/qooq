package com.tencent.mobileqq.emosm;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class Client$onRemoteRespObserver
{
  private static int seed;
  public int key;
  
  public Client$onRemoteRespObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    int i = seed;
    seed = i + 1;
    this.key = i;
  }
  
  public abstract void onBindedToClient();
  
  public abstract void onDisconnectWithService();
  
  public abstract void onPushMsg(Bundle paramBundle);
  
  public abstract void onResponse(Bundle paramBundle);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\Client$onRemoteRespObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */