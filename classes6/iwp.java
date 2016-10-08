import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;

public class iwp
  extends GestureDetector.SimpleOnGestureListener
{
  private iwp(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    StoryReportor.a("video_shoot", "camera_clkdouble", 0, 0, new String[0]);
    this.a.a(-1, false);
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.a.a.a(paramMotionEvent);
    paramMotionEvent = new Rect((int)(paramMotionEvent.getX() - paramMotionEvent.getTouchMajor() / 2.0F), (int)(paramMotionEvent.getY() - paramMotionEvent.getTouchMinor() / 2.0F), (int)(paramMotionEvent.getX() + paramMotionEvent.getTouchMajor() / 2.0F), (int)(paramMotionEvent.getY() + paramMotionEvent.getTouchMinor() / 2.0F));
    Rect localRect = new Rect();
    localRect.set(paramMotionEvent.left * 2000 / UIUtils.a(this.a) - 1000, paramMotionEvent.top * 2000 / UIUtils.b(this.a) - 1000, paramMotionEvent.right * 2000 / UIUtils.a(this.a) - 1000, paramMotionEvent.bottom * 2000 / UIUtils.b(this.a) - 1000);
    if (QLog.isColorLevel())
    {
      QLog.i("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "[handleMessage] touchRect = " + paramMotionEvent);
      QLog.i("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "[handleMessage] focusArea = " + localRect);
    }
    NewStoryTakeVideoActivity.a().a(localRect);
    SLog.e("Q.qqstory.record.NewStoryTakeVideoActivity", "cameraFocusView consume the touch event");
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */