import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qlink.QQProxyForQlink;

public class yei
  implements Runnable
{
  public yei(QQProxyForQlink paramQQProxyForQlink)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((QQProxyForQlink.a(this.a) == null) || (QQProxyForQlink.a(this.a).a() == null)) {}
    do
    {
      return;
      QQProxyForQlink.a(this.a, new yej(this));
    } while ((QQProxyForQlink.a(this.a) == null) || (QQProxyForQlink.a(this.a).a() == null));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qlink.finishworkingdlg");
    QQProxyForQlink.a(this.a).a().registerReceiver(QQProxyForQlink.a(this.a), localIntentFilter);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */