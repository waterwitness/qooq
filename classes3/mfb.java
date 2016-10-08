import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class mfb
  implements Runnable
{
  public mfb(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null) {}
    String str;
    do
    {
      return;
      str = this.a.a.a();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.b(str, System.currentTimeMillis());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */