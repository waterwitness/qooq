import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPublicAccountMessageReceiptResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class hqv
  implements BusinessObserver
{
  public hqv(PublicAccountManager paramPublicAccountManager, NewIntent paramNewIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      mobileqq_mp.SendPublicAccountMessageReceiptResponse localSendPublicAccountMessageReceiptResponse = new mobileqq_mp.SendPublicAccountMessageReceiptResponse();
      localSendPublicAccountMessageReceiptResponse.mergeFrom(paramBundle);
      boolean bool = paramBoolean;
      if (localSendPublicAccountMessageReceiptResponse.ret_info.has())
      {
        bool = paramBoolean;
        if (localSendPublicAccountMessageReceiptResponse.ret_info.ret_code.has())
        {
          paramInt = localSendPublicAccountMessageReceiptResponse.ret_info.ret_code.get();
          bool = paramBoolean;
          if (paramInt != 0L) {
            bool = false;
          }
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("PublicAccountManager", 2, "sendMsgArriveReceipt response :" + String.valueOf(false));
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountManager", 2, "sendMsgArriveReceipt response :" + String.valueOf(paramBoolean));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */