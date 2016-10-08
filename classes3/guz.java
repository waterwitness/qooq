import android.os.Handler;
import android.os.Message;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.utils.QAVNotification;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class guz
  extends Handler
{
  public guz(MultiIncomingCallsActivity paramMultiIncomingCallsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      return;
    }
    if (!this.a.a(0))
    {
      if (this.a.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.a.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.b);
      }
      this.a.b(2);
      this.a.a(true, SessionMgr.a().a(), 8);
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */