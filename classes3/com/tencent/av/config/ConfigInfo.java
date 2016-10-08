package com.tencent.av.config;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ConfigInfo
{
  private static volatile ConfigInfo instance;
  
  private ConfigInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    init();
    cacheMethodIds();
  }
  
  private static native void cacheMethodIds();
  
  private native void init();
  
  /* Error */
  public static ConfigInfo instance()
  {
    // Byte code:
    //   0: getstatic 30	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   3: ifnonnull +27 -> 30
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 30	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +13 -> 27
    //   17: new 2	com/tencent/av/config/ConfigInfo
    //   20: dup
    //   21: invokespecial 31	com/tencent/av/config/ConfigInfo:<init>	()V
    //   24: putstatic 30	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   27: ldc 2
    //   29: monitorexit
    //   30: getstatic 30	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   33: areturn
    //   34: astore_0
    //   35: aconst_null
    //   36: putstatic 30	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   39: aload_0
    //   40: invokevirtual 34	java/lang/Exception:printStackTrace	()V
    //   43: goto -16 -> 27
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: astore_0
    //   53: aconst_null
    //   54: putstatic 30	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   57: aload_0
    //   58: invokevirtual 35	java/lang/Error:printStackTrace	()V
    //   61: goto -34 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	localConfigInfo	ConfigInfo
    //   34	6	0	localException	Exception
    //   46	5	0	localObject	Object
    //   52	6	0	localError	Error
    // Exception table:
    //   from	to	target	type
    //   17	27	34	java/lang/Exception
    //   9	13	46	finally
    //   17	27	46	finally
    //   27	30	46	finally
    //   35	43	46	finally
    //   47	50	46	finally
    //   53	61	46	finally
    //   17	27	52	java/lang/Error
  }
  
  public byte[] getConfigInfoFromFile()
  {
    return Common.a(BaseApplicationImpl.getContext(), "VideoConfigInfo");
  }
  
  public String getSharpConfigPayloadFromFile()
  {
    Object localObject = Common.a(BaseApplicationImpl.getContext(), "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "getSharpConfigPayloadFromFile payloadBufTmp: " + str);
      }
      int i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "getSharpConfigPayloadFromFile version: " + (String)localObject + ". payload: " + str);
      }
      return str;
    }
    return "";
  }
  
  public int getSharpConfigVersionFromFile()
  {
    int i = 0;
    Object localObject = Common.a(BaseApplicationImpl.getContext(), "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "getSharpConfigVersionFromFile payloadBufTmp: " + str);
      }
      i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "getSharpConfigVersionFromFile version: " + (String)localObject + ". payload: " + str);
      }
      i = Integer.parseInt((String)localObject);
    }
    return i;
  }
  
  public void writeConfigInfoToFile(byte[] paramArrayOfByte) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\config\ConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */