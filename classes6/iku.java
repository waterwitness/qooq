import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iku
  implements View.OnTouchListener
{
  public iku(QQStoryDiscoverActivity paramQQStoryDiscoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      QQStoryDiscoverActivity.a(this.a);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */