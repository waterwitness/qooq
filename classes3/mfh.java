import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class mfh
  implements Runnable
{
  public mfh(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RichStatus localRichStatus = QQSettingMe.a(this.a).a(true);
    this.a.a.runOnUiThread(new mfi(this, localRichStatus));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */