import android.os.Bundle;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class hil
  implements BusinessObserver
{
  public hil(TroopCardAppInfoHelper paramTroopCardAppInfoHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.a) {
      return;
    }
    if ((!paramBoolean) || (paramBundle == null))
    {
      TroopCardAppInfoHelper.a(this.a);
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      localOIDBSSOPkg.mergeFrom((byte[])paramBundle);
      if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
      {
        TroopCardAppInfoHelper.a(this.a);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCardAppInfoHandler", 2, "handleGetTroopAppBriefList error " + QLog.getStackTraceString(paramBundle));
      }
      TroopCardAppInfoHelper.a(this.a);
      return;
    }
    paramBundle = TroopCardAppInfoHelper.a(this.a, localOIDBSSOPkg);
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      TroopCardAppInfoHelper.a(this.a, paramBundle);
      return;
    }
    TroopCardAppInfoHelper.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */