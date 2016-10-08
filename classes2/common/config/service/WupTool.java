package common.config.service;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class WupTool
{
  public WupTool()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static JceStruct a(Class paramClass, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    try
    {
      paramClass = (JceStruct)paramClass.newInstance();
      paramClass.readFrom(new JceInputStream(paramArrayOfByte));
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\common\config\service\WupTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */