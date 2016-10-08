import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qeg
  implements Runnable
{
  public qeg(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a.a()).edit();
    localEditor.putString("LastScreenShotUri", "");
    localEditor.commit();
    this.a.p();
    try
    {
      QQAppInterface.j(this.a).unregisterReceiver(QQAppInterface.b(this.a));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */