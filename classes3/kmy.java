import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kmy
  implements Runnable
{
  public kmy(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b.setText(this.a.a.d);
    if (AppSetting.j)
    {
      String str = this.a.b.getText().toString();
      this.a.b.setContentDescription(str);
      this.a.a().setTitle(this.a.b.getText());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */