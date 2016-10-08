import android.view.Window;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class nfu
  implements Runnable
{
  public nfu(CommonRecordSoundPanel paramCommonRecordSoundPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.setRequestedOrientation4Recording(true);
    this.a.a.getWindow().clearFlags(128);
    QQToast.a(this.a.a, 2131368055, 1).b(this.a.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */