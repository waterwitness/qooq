import android.os.Bundle;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

public final class hgz
  implements BusinessObserver
{
  public hgz(NewIntent paramNewIntent, AsyncBack paramAsyncBack, boolean paramBoolean1, AppRuntime paramAppRuntime, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, "-->offline:checkUpdate,onReceive:isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {}
    while (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack == null) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          OfflinePkg.RspBody localRspBody = new OfflinePkg.RspBody();
          localRspBody.mergeFrom(paramBundle);
          paramBundle = new String(localRspBody.str_offline_pkg.get().toByteArray(), "UTF-8");
          if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
            this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(paramBundle, 0);
          }
          if (this.jdField_a_of_type_Boolean) {
            HtmlOffline.a(paramBundle, this.jdField_a_of_type_MqqAppAppRuntime, this.b);
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a("{\"r\":-1}", -1);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a("{\"r\":-1}", -1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */