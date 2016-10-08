import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ipy
  extends GestureDetector.SimpleOnGestureListener
{
  public ipy(QQStoryWatcherListView paramQQStoryWatcherListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent2 != null) && (paramMotionEvent1 != null))
    {
      paramFloat1 = Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX());
      float f = Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY());
      double d = Math.abs(Math.asin(paramFloat1 / Math.sqrt(paramFloat1 * paramFloat1 + f * f)));
      if ((paramFloat2 > 0.0F) && (d < 0.5235987755982988D) && (this.a.jdField_a_of_type_Int == 0)) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.performClick();
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */