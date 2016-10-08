import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.ItemViewGestureListener;
import com.tencent.biz.qqstory.takevideo.NewStoryPartManager;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iuy
  implements NewStoryFilterViewPagerController.ItemViewGestureListener
{
  public iuy(NewStoryFilterViewPagerController paramNewStoryFilterViewPagerController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.a.a.a.a.a().a(paramMotionEvent);
  }
  
  public void a(View paramView)
  {
    this.a.a.a.a.a().c();
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    boolean bool1 = false;
    if (paramMotionEvent2 != null)
    {
      boolean bool2 = this.a.a.a.a.a().a(paramMotionEvent2);
      bool1 = bool2;
      if (bool2)
      {
        a(paramMotionEvent1);
        a(paramMotionEvent2);
        bool1 = bool2;
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */