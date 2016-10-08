package com.tencent.mobileqq.camera;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CameraManagerFactory
{
  private static CameraManagerImpl a;
  
  public CameraManagerFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static CameraManager a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/tencent/mobileqq/camera/CameraManagerFactory:a	Lcom/tencent/mobileqq/camera/CameraManagerImpl;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 20	com/tencent/mobileqq/camera/CameraManagerFactory:a	Lcom/tencent/mobileqq/camera/CameraManagerImpl;
    //   15: ifnonnull +13 -> 28
    //   18: new 22	com/tencent/mobileqq/camera/CameraManagerImpl
    //   21: dup
    //   22: invokespecial 23	com/tencent/mobileqq/camera/CameraManagerImpl:<init>	()V
    //   25: putstatic 20	com/tencent/mobileqq/camera/CameraManagerFactory:a	Lcom/tencent/mobileqq/camera/CameraManagerImpl;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 20	com/tencent/mobileqq/camera/CameraManagerFactory:a	Lcom/tencent/mobileqq/camera/CameraManagerImpl;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localCameraManagerImpl	CameraManagerImpl
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\CameraManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */