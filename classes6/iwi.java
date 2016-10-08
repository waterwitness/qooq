import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iwi
  implements MessageQueue.IdleHandler
{
  public iwi(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a = true;
    this.a.a(true);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    if (this.a.w)
    {
      this.a.w = false;
      this.a.a(1, false);
    }
    SLog.c("PEAK_CAMERA", "Added camera view.");
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */