import android.os.Message;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class mnp
  extends MqqHandler
{
  public mnp(SubAccountSettingActivity paramSubAccountSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */