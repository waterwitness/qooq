import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryPartManager;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.NewStoryViewController;
import com.tencent.biz.qqstory.takevideo.TakeVideoButtonSubPart;
import com.tencent.biz.qqstory.takevideo.rmw.RMWClientControl;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicInteger;

public class iwy
  implements Runnable
{
  public iwy(TakeVideoButtonSubPart paramTakeVideoButtonSubPart)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TakeVideoButtonSubPart.a(this.a))
    {
      TakeVideoButtonSubPart.a(this.a, false);
      if (!TakeVideoButtonSubPart.b(this.a)) {
        break label155;
      }
    }
    label155:
    for (this.a.jdField_a_of_type_Boolean = TakeVideoButtonSubPart.a(this.a).isPressed();; this.a.jdField_a_of_type_Boolean = TakeVideoButtonSubPart.a(this.a).a())
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.b(this.a.jdField_a_of_type_Boolean);
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 1))
      {
        SLog.b("TakeVideoButtonSubPart", "autoStartTakeVideoIfPressed onTouch down trigger");
        MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
        this.a.jdField_a_of_type_AndroidViewView$OnTouchListener.onTouch(null, localMotionEvent);
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        break;
      }
      StoryReportor.a("home_page", "press_shoot", 0, 0, new String[0]);
      return;
    }
    StoryReportor.a("home_page", "clk_shoot", 0, 0, new String[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */