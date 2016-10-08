import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.takevideo.rmw.RMWControl;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWMessengerObservable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyq
  implements View.OnTouchListener
{
  public iyq(RMWControl paramRMWControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 2) {
      return RMWControl.c(this.a).a() > 0;
    }
    RMWLog.a("RMWControl", "service.send : onTouch " + paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      RMWControl.c(this.a).c();
      if (RMWControl.c(this.a).a(Message.obtain(null, 9, paramMotionEvent)) > 0) {
        break;
      }
      return false;
      RMWControl.a(this.a, true);
      continue;
      RMWControl.a(this.a, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */