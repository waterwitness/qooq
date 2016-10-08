import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class hta
  implements BusinessObserver
{
  public hta(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoUIController", 2, "getPublicAccountName() isSuccess=" + paramBoolean);
      }
      if (paramBundle != null)
      {
        mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
        {
          paramBundle = new AccountDetail(localGetPublicAccountDetailInfoResponse);
          if (!TextUtils.isEmpty(paramBundle.name)) {
            VideoUIController.a(this.a, paramBundle.name);
          }
          for (;;)
          {
            if (paramBundle.followType == 1) {
              this.a.f();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.pubaccount.video.VideoUIController", 2, "getPublicAccountName() detail.name=" + paramBundle.name);
            return;
            VideoUIController.a(this.a, this.a.a.getString("VIDEO_PUB_ACCOUNT_UIN"));
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.pubaccount.video.VideoUIController", 2, "response.ret_info.get().ret_code.get()=" + ((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get());
        }
        VideoUIController.a(this.a, this.a.a.getString("VIDEO_PUB_ACCOUNT_UIN"));
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */