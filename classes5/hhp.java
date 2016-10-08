import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.OfflineSecurity.VerifyListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hhp
  extends Handler
{
  public hhp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener != null)
    {
      OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener.a(((Boolean)paramMessage.obj).booleanValue());
      OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener = null;
      OfflineSecurity.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */