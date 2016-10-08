import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.rmw.RMWControl;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWMessengerObservable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyo
  implements View.OnClickListener
{
  public iyo(RMWControl paramRMWControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    RMWLog.a("RMWControl", "service.send : onClick " + RMWControl.a(this.a).a());
    RMWControl.a(this.a).c();
    RMWControl.a(this.a).a(Message.obtain(null, 7));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */