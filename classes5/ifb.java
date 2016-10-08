import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ABTestControlMsgResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class ifb
  implements BusinessObserver
{
  public ifb(NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = true;
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean) {
      return;
    }
    for (;;)
    {
      try
      {
        mobileqq_mp.ABTestControlMsgResponse localABTestControlMsgResponse = new mobileqq_mp.ABTestControlMsgResponse();
        localABTestControlMsgResponse.mergeFrom(paramBundle.getByteArray("data"));
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "getPaManageABTestInfo->cuin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + ", ret_code:" + localABTestControlMsgResponse.ret_info.ret_code.get() + ", abtest_switch:" + localABTestControlMsgResponse.abtest_switch.get() + ", extra_info:" + localABTestControlMsgResponse.extra_info.get());
        }
        if (localABTestControlMsgResponse.ret_info.has())
        {
          paramInt = localABTestControlMsgResponse.ret_info.ret_code.get();
          if (paramInt != 0) {
            break;
          }
          if (!localABTestControlMsgResponse.abtest_switch.has()) {
            break label459;
          }
          paramInt = localABTestControlMsgResponse.abtest_switch.get();
          continue;
          PublicAccountConfigUtil.d = paramBoolean;
          if (localABTestControlMsgResponse.extra_info.has())
          {
            paramBundle = localABTestControlMsgResponse.extra_info.get();
            paramBoolean = TextUtils.isEmpty(paramBundle);
            if (paramBoolean) {}
          }
          try
          {
            paramBundle = new JSONObject(paramBundle);
            if (paramBundle.has("pa_manage_count_limit")) {
              PublicAccountConfigUtil.j = paramBundle.getInt("pa_manage_count_limit");
            }
            if (paramBundle.has("pa_manage_day_limit")) {
              PublicAccountConfigUtil.k = paramBundle.getInt("pa_manage_day_limit");
            }
          }
          catch (Exception paramBundle)
          {
            long l;
            continue;
          }
          paramBundle = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
          paramBundle.putBoolean("public_account_manage_enable", PublicAccountConfigUtil.d);
          paramBundle.putInt("public_account_manage_count_limit", PublicAccountConfigUtil.j);
          paramBundle.putInt("public_account_manage_day_limit", PublicAccountConfigUtil.k);
          l = NetConnInfoCenter.getServerTimeMillis();
          paramBundle.putLong("public_account_manage_abtest_load_time", l);
          paramBundle.commit();
          if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
            QLog.d("PublicAccountConfigUtil", 2, "getPaManageABTestInfo->cuin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + ", PUBLIC_ACCOUNT_MANAGE_ENABLE:" + PublicAccountConfigUtil.d + ", PUBLIC_ACCOUNT_MANAGE_RED_COUNT_LIMIT:" + PublicAccountConfigUtil.j + ", PUBLIC_ACCOUNT_MANAGE_RED_DAY_LIMIT:" + PublicAccountConfigUtil.k + ", nowTime:" + l);
          }
          paramBundle = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if (paramBundle == null) {
            break;
          }
          paramBundle.c();
          return;
          paramBundle = "";
          continue;
          if (paramInt != 1) {
            break label464;
          }
          paramBoolean = bool;
          continue;
        }
        paramInt = -1;
      }
      catch (Exception paramBundle)
      {
        return;
      }
      continue;
      label459:
      paramInt = 0;
      continue;
      label464:
      paramBoolean = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ifb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */