import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimPluginLoadRunnable.IPluginLoadListener;
import cooperation.qqpim.QQPimPluginProxyService;

public class yiq
  implements QQPimPluginLoadRunnable.IPluginLoadListener
{
  public yiq(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.hasInstalled() ");
    }
    QQPimPluginProxyService.a(QQPimGetTipsInfoIPC.a(this.a));
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.downloading() " + paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.downloadError() " + paramInt);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.downloadBegin()");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yiq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */