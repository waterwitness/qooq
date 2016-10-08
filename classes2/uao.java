import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService;
import com.tencent.qphone.base.util.QLog;

public class uao
  extends BroadcastReceiver
{
  public uao(QzonePhotoGuideNotifyService paramQzonePhotoGuideNotifyService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.qzonex.localalbum.new_photo_notification_feedback_action".equals(paramIntent.getAction())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzonePhotoGuideNotifyServlet", 2, "QzonePhotoGuideNotifyServlet onReceive");
      }
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      }
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */