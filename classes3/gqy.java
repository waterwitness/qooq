import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.text.TextUtils;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.BaseCallbackUI;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class gqy
  extends PhoneStateListener
{
  public gqy(CallbackWaitingActivityExt paramCallbackWaitingActivityExt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    int i = 0;
    super.onCallStateChanged(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d(CallbackWaitingActivityExt.a(), 2, "WL_DEBUG onCallStateChanged state = " + paramInt);
      QLog.d(CallbackWaitingActivityExt.a(), 2, "WL_DEBUG onCallStateChanged incomingNumber = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      CallbackWaitingActivityExt.j = paramString;
    }
    switch (paramInt)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return;
          if ((CallbackWaitingActivityExt.a(this.a) != null) && (CallbackWaitingActivityExt.a(this.a).a().e))
          {
            CallbackWaitingActivityExt.a(this.a).a().a().b = -1;
            CallbackWaitingActivityExt.a(this.a).a().e = false;
            CallbackWaitingActivityExt.a(this.a).a().f = false;
            if (this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo != null) {
              CallbackWaitingActivityExt.a(this.a).a().a(this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.a, 0);
            }
            PSTNNotification.a(CallbackWaitingActivityExt.a(this.a).getApplication().getApplicationContext()).d();
            if (this.a.jdField_a_of_type_AndroidContentIntent != null)
            {
              CallbackWaitingActivityExt.a(this.a).a().stopService(this.a.jdField_a_of_type_AndroidContentIntent);
              this.a.jdField_a_of_type_AndroidContentIntent = null;
            }
          }
        } while (CallbackWaitingActivityExt.a(this.a).a().a().b != -1);
        this.a.finish();
        return;
        paramInt = i;
        if (!TextUtils.isEmpty(CallbackWaitingActivityExt.i))
        {
          paramInt = i;
          if (!TextUtils.isEmpty(CallbackWaitingActivityExt.j))
          {
            paramInt = i;
            if (CallbackWaitingActivityExt.i.equals(CallbackWaitingActivityExt.j)) {
              paramInt = 1;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(CallbackWaitingActivityExt.a(), 2, "callBackphone:" + CallbackWaitingActivityExt.j + ", csNumber:" + CallbackWaitingActivityExt.i);
        }
        this.a.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a.removeCallbacksAndMessages(null);
        paramString = new Message();
        paramString.what = 2;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramString, 1000L);
      } while (CallbackWaitingActivityExt.a(this.a) == null);
      if ((paramInt != 0) && (!CallbackWaitingActivityExt.a(this.a).a().f))
      {
        paramString = new Message();
        paramString.what = 1;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramString, 1000L);
      }
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 8000L);
      CallbackWaitingActivityExt.a(this.a).a().e = true;
      return;
    }
    if (CallbackWaitingActivityExt.a(this.a) != null) {
      CallbackWaitingActivityExt.a(this.a).a().e = true;
    }
    AudioUtil.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */