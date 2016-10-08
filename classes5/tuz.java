import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;

public class tuz
  extends Handler
{
  public tuz(VipProfileCardBaseActivity paramVipProfileCardBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.a(paramMessage)) {}
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
      return;
    case 6: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)))
      {
        Toast.makeText(this.a.a.getApplicationContext(), (String)paramMessage.obj, 0).show();
        return;
      }
      Toast.makeText(this.a.a.getApplicationContext(), 2131370897, 0).show();
      return;
    case 7: 
      Toast.makeText(this.a.a.getApplicationContext(), 2131370899, 0).show();
      return;
    }
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tuz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */