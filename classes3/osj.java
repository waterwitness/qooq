import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;

public class osj
  implements MessageQueue.IdleHandler
{
  public osj(SendPhotoActivity paramSendPhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "queueIdle", "start");
    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask = new SendPhotoActivity.sendPhotoTask(this.a, null);
    ThreadManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask, 8, null, false);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */