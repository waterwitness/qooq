import android.os.Handler;
import android.telephony.PhoneStateListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.PstnCallbackWaitingUi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gxy
  extends PhoneStateListener
{
  public gxy(PstnCallbackWaitingUi paramPstnCallbackWaitingUi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("PstnCallbackWaitingUi", 2, "WL_DEBUG onCallStateChanged state = " + paramInt);
      QLog.d("PstnCallbackWaitingUi", 2, "WL_DEBUG onCallStateChanged incomingNumber = " + paramString);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().x != 1) || (this.a.jdField_a_of_type_AndroidOsHandler == null) || (this.a.jdField_a_of_type_JavaLangRunnable == null) || (paramString == null) || (!paramString.equals("03162412023")));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("PstnCallbackWaitingUi", 2, "WL_DEBUG onCallStateChanged CALL_STATE_OFFHOOK");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */