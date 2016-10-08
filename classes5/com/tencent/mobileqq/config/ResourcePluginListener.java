package com.tencent.mobileqq.config;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class ResourcePluginListener
{
  public static final byte a = 1;
  public static final int a = 1;
  public static final byte b = 2;
  public static final int b = 2;
  public static final byte c = -1;
  public static final byte d = 3;
  public static final byte e = 4;
  public static final byte f = 5;
  
  public ResourcePluginListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    BaseApplicationImpl.a.post(new ResourcePluginListener.CallbackRunner(paramResourcePluginListener, paramByte, paramInt));
  }
  
  public void a(byte paramByte) {}
  
  public void b(byte paramByte) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\ResourcePluginListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */