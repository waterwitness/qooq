import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.C2BUtils;
import java.util.HashMap;
import java.util.Map;
import mqq.observer.BusinessObserver;

public final class yce
  implements BusinessObserver
{
  public yce(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Map paramMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2BUtils", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {}
    for (;;)
    {
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, "from_internal", this.jdField_a_of_type_JavaUtilMap);
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() != 0) {
          continue;
        }
        paramBundle = new AccountDetail(localGetPublicAccountDetailInfoResponse);
        C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
        try
        {
          if (C2BUtils.a() == null) {
            C2BUtils.a(new HashMap());
          }
          C2BUtils.a().put(paramBundle.uin, paramBundle.name);
        }
        finally {}
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */