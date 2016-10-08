import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.sensewhere.SenseWhereHandler;
import com.tencent.mobileqq.sensewhere.SenseWhereManager;
import com.tencent.qphone.base.util.QLog;

public class uoq
  implements INetworkApi
{
  private uoq(SenseWhereManager paramSenseWhereManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public byte[] httpRequest(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  public byte[] httpRequest(byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SenseWhere", 4, "httpRequest.");
    }
    synchronized (SenseWhereManager.a(this.a))
    {
      ((SenseWhereHandler)SenseWhereManager.a(this.a).a(77)).a(paramArrayOfByte);
      try
      {
        SenseWhereManager.a(this.a).wait(SenseWhereManager.a() * 1000L);
        paramArrayOfByte = SenseWhereManager.a(this.a);
        return paramArrayOfByte;
      }
      catch (InterruptedException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramArrayOfByte.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uoq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */