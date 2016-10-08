import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

public class qwn
  extends TransProcessorHandler
{
  public qwn(FlowCameraPhotoActivity paramFlowCameraPhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    this.a.d = true;
    switch (paramMessage.what)
    {
    default: 
    case 1003: 
      do
      {
        do
        {
          return;
        } while (localFileMsg == null);
        paramMessage = localFileMsg.a;
        if (paramMessage != null)
        {
          this.a.a = CardOCRInfo.a(paramMessage);
          this.a.runOnUiThread(new qwo(this));
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("BusinessCard_FlowCameraPhotoActivity", 2, "extraInfo is null");
      return;
    }
    paramMessage = localFileMsg.a;
    if (paramMessage != null) {
      this.a.a = CardOCRInfo.a(paramMessage);
    }
    if (this.a.a != null) {
      BusinessCardUtils.a(this.a.app.a(), this.a.a.a, -1, false, 0L);
    }
    this.a.runOnUiThread(new qwp(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */