import android.os.Bundle;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.PublicAccountHandler;
import cooperation.qqhotspot.hotspotnode.PublicAccountHandler.PublicAccountInfo;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;
import mqq.observer.BusinessObserver;

public class yia
  implements BusinessObserver
{
  public yia(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQHotSpotRemoteManager", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (!QLog.isColorLevel()) {
        break label460;
      }
      QLog.d("QQHotSpotRemoteManager", 2, "getPublicAccountResp uin: " + this.jdField_a_of_type_JavaLangString + " isSuccess: false");
      paramBundle = null;
    }
    for (;;)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("notify_cmd", "BusinessHandler_get_public_account_info");
      ((Bundle)localObject).putInt("listinfoprotoex_seq", this.jdField_a_of_type_Int);
      PublicAccountHandler.PublicAccountInfo localPublicAccountInfo = new PublicAccountHandler.PublicAccountInfo();
      if (paramBundle != null)
      {
        localPublicAccountInfo.mUin = this.jdField_a_of_type_JavaLangString;
        localPublicAccountInfo.mName = paramBundle.name;
        if (paramBundle.followType == 1)
        {
          paramBoolean = true;
          label149:
          localPublicAccountInfo.mIsFollow = paramBoolean;
          localPublicAccountInfo.mBrief = paramBundle.summary;
          localPublicAccountInfo.mAccountFlag = paramBundle.accountFlag;
          ((Bundle)localObject).putBoolean("result", true);
          ((Bundle)localObject).putSerializable("publicaccount_info", localPublicAccountInfo);
        }
      }
      for (;;)
      {
        QQHotSpotRemoteManager.a(this.jdField_a_of_type_CooperationQqhotspotIpcQQHotSpotRemoteManager, (Bundle)localObject, true);
        return;
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null)
          {
            if (!QLog.isColorLevel()) {
              break label465;
            }
            QLog.d("QQHotSpotRemoteManager", 2, "getPublicAccountResp uin: " + this.jdField_a_of_type_JavaLangString + " data == null");
            break label465;
          }
          localObject = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          ((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get() != 0)
          {
            if (!QLog.isColorLevel()) {
              break label470;
            }
            QLog.d("QQHotSpotRemoteManager", 2, "getPublicAccountResp uin: " + this.jdField_a_of_type_JavaLangString + " response.ret_info.get().ret_code.get(): " + ((mobileqq_mp.RetInfo)((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get());
            break label470;
          }
          paramBundle = new AccountDetail((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject);
          try
          {
            PublicAccountHandler.a(this.jdField_a_of_type_CooperationQqhotspotIpcQQHotSpotRemoteManager.a, paramBundle);
          }
          catch (Exception localException) {}
        }
        catch (Exception paramBundle)
        {
          paramBundle = null;
        }
        paramBoolean = false;
        break label149;
        localPublicAccountInfo.mUin = this.jdField_a_of_type_JavaLangString;
        localException.putBoolean("result", false);
        localException.putSerializable("publicaccount_info", localPublicAccountInfo);
        if (QLog.isColorLevel()) {
          QLog.d("QQHotSpotRemoteManager", 2, "getPublicAccountResp uin: " + this.jdField_a_of_type_JavaLangString + " accountDetail == null");
        }
      }
      continue;
      label460:
      paramBundle = null;
      continue;
      label465:
      paramBundle = null;
      continue;
      label470:
      paramBundle = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */