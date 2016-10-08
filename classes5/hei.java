import android.os.Handler;
import android.os.Message;
import com.tencent.biz.JoinGroupHandler;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class hei
  extends Handler
{
  private WeakReference a;
  
  public hei(JoinGroupTransitActivity paramJoinGroupTransitActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramJoinGroupTransitActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    JoinGroupTransitActivity localJoinGroupTransitActivity = (JoinGroupTransitActivity)this.a.get();
    if ((paramMessage == null) || (localJoinGroupTransitActivity == null) || (localJoinGroupTransitActivity.isFinishing())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      JoinGroupTransitActivity.a(localJoinGroupTransitActivity).a(JoinGroupTransitActivity.a(localJoinGroupTransitActivity));
      return;
    }
    localJoinGroupTransitActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */