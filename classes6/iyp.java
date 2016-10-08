import android.os.Message;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.takevideo.rmw.RMWControl;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWMessengerObservable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyp
  implements View.OnLongClickListener
{
  public iyp(RMWControl paramRMWControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    RMWLog.a("RMWControl", "service.send : onLongClick " + RMWControl.b(this.a).a());
    RMWControl.b(this.a).c();
    return RMWControl.b(this.a).a(Message.obtain(null, 8)) > 0;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */