package cooperation.plugin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.AbstractPluginCommunicationChannel;
import mqq.app.AppRuntime;

public class QQPluginCommunicationChannel
  extends AbstractPluginCommunicationChannel
{
  public QQPluginCommunicationChannel()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String getNickName()
  {
    String str = null;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      str = localQQAppInterface.b();
    }
    return str;
  }
  
  public String getSKey()
  {
    String str = null;
    if (a() != null) {
      str = "getSKey";
    }
    return str;
  }
  
  public String getSid()
  {
    throw new RuntimeException("NotSupported!");
  }
  
  public long getUin()
  {
    long l = 0L;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      l = localQQAppInterface.getLongAccountUin();
    }
    return l;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\QQPluginCommunicationChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */