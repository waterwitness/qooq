package com.tencent.mobileqq.utils.httputils;

import android.os.Bundle;

public abstract interface HttpCommunicator$TransferProgressListener
{
  public static final int a = 0;
  public static final int b = 1;
  
  public abstract void a();
  
  public abstract void a(int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void a(long paramLong);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\httputils\HttpCommunicator$TransferProgressListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */