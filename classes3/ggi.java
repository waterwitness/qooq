import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggi
  extends BroadcastReceiver
{
  public ggi(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentAvVideoController == null);
      if (QLog.isColorLevel()) {
        QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "recv vipfuncall msg broadcast: " + paramIntent.getAction());
      }
    } while (!paramIntent.getAction().equals("tencent.video.q2v.AnnimateDownloadFinish"));
    if (QLog.isColorLevel()) {
      QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "ACTION_ANNIMATE_DOWNLOAD_FINISH");
    }
    int i = paramIntent.getIntExtra("fun_call_id", 0);
    this.a.jdField_a_of_type_ComTencentAvVideoController.i(i);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */