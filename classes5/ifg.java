import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ifg
  extends Handler
{
  public ifg(PublicAccountH5AbilityPlugin paramPublicAccountH5AbilityPlugin)
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
    this.a.c = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ifg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */