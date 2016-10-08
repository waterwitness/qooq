import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.PstnCallbackWaitingUi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class gxx
  implements Runnable
{
  public gxx(PstnCallbackWaitingUi paramPstnCallbackWaitingUi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BaseApplication localBaseApplication = this.a.a.a();
    Intent localIntent = new Intent(localBaseApplication, AVActivity.class);
    localIntent.setFlags(268566528);
    localBaseApplication.startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */