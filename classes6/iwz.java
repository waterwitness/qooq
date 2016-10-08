import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.TakeVideoButtonSubPart;
import com.tencent.biz.qqstory.takevideo.TakeVideoButtonSubPart.exitRecodeModeRunnable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iwz
  implements View.OnTouchListener
{
  public iwz(TakeVideoButtonSubPart paramTakeVideoButtonSubPart)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    SLog.b("TakeVideoButtonSubPart", "record button onTouch : " + paramMotionEvent);
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.g) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c))
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        return true;
        int i = paramMotionEvent.getActionIndex();
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a(paramMotionEvent, i);
        continue;
        this.a.d();
        TakeVideoButtonSubPart.a(this.a, SystemClock.uptimeMillis());
        if (TakeVideoButtonSubPart.a(this.a) != null)
        {
          this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(TakeVideoButtonSubPart.a(this.a));
          TakeVideoButtonSubPart.a(this.a, null);
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.k();
        continue;
        long l = SystemClock.uptimeMillis() - TakeVideoButtonSubPart.a(this.a);
        TakeVideoButtonSubPart.a(this.a, new TakeVideoButtonSubPart.exitRecodeModeRunnable(this.a, this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity));
        if ((l > 0L) && (l < 200L)) {
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(TakeVideoButtonSubPart.a(this.a), 200L - l);
        } else {
          TakeVideoButtonSubPart.a(this.a).run();
        }
      }
    }
    SLog.a("TakeVideoButtonSubPart", "state invalid, mIsCameraSetup = %s, mIsVideoMode = %s", Boolean.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.g), Boolean.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.c));
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */