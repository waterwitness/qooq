package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;

public abstract interface IArConfigListener
{
  public static final int a = 9039;
  public static final int b = -100001;
  public static final int c = -100002;
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(ArConfigInfo paramArConfigInfo);
  
  public abstract void a(ArEffectConfig paramArEffectConfig);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\IArConfigListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */