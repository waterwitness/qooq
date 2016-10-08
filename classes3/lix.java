import android.os.Message;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class lix
  extends MqqHandler
{
  public lix(FontSettingActivity paramFontSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (16711697 == paramMessage.what)
    {
      FontSettingManager.a(this.a, FontSettingActivity.a(this.a), false);
      this.a.c = true;
      FontSettingActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */