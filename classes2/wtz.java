import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.base.TicketUtils.TicketCallback;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

public class wtz
  extends SSOAccountObserver
{
  public wtz(TicketUtils paramTicketUtils)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback != null) {
      this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback.a();
    }
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 == 0)
    {
      paramBundle = new WloginSimpleInfo();
      if (this.a.jdField_a_of_type_MqqManagerWtloginManager != null) {
        this.a.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, paramBundle);
      }
      paramString = "" + paramBundle._uin;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        util.LOGD("outA1 buff: " + util.buf_to_string(paramArrayOfByte));
        paramArrayOfByte = new RSACrypt(CommonDataAdapter.a().a()).EncryptData(this.a.a(CommonDataAdapter.a().a(), this.a.jdField_a_of_type_Long, 1L), paramArrayOfByte);
        util.LOGD("encrypt buff:" + util.buf_to_string(paramArrayOfByte));
        if (this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback != null) {
          this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback.a(paramString, paramArrayOfByte);
        }
      }
    }
    while (this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback.a();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback != null) {
      this.a.jdField_a_of_type_ComTencentOpenBaseTicketUtils$TicketCallback.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */