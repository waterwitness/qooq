import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qqpim.QQPimBridgeActivity;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimPluginLoadRunnable.IPluginLoadListener;

public class yip
  implements QQPimPluginLoadRunnable.IPluginLoadListener
{
  public yip(QQPimBridgeActivity paramQQPimBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimBridgeActivity.hasInstalled()");
    }
    QQPimBridgeActivity.a(this.a).sendEmptyMessage(1);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimBridgeActivity.downloadError()");
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    QQPimBridgeActivity.a(this.a).sendMessage(localMessage);
  }
  
  public void b()
  {
    QQPimBridgeActivity.a(this.a).sendEmptyMessage(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */