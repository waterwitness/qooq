package com.tencent.mobileqq.ar.aidl;

import android.os.IInterface;

public abstract interface IArRemoteCallback
  extends IInterface
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(ArConfigInfo paramArConfigInfo, ArEffectConfig paramArEffectConfig);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\aidl\IArRemoteCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */