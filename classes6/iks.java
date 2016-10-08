import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem.OnItemTouchListener;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iks
  implements DiscoverItem.OnItemTouchListener
{
  public iks(QQStoryDiscoverActivity paramQQStoryDiscoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.a.a != null) {
        this.a.a.recycle();
      }
      this.a.a = BitmapUtils.a(paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */