import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class nfr
  extends Handler
{
  public nfr(CommonRecordSoundPanel paramCommonRecordSoundPanel, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16711687: 
      this.a.b(102);
      return;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      CommonRecordSoundPanel.a(this.a).c();
      AudioUtil.b(2131165201, false);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(16711686);
      AudioUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false);
      return;
    }
    this.a.b(1);
    this.a.d();
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367635), 1).a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */