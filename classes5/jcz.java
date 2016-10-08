import android.os.Bundle;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class jcz
  implements BusinessObserver
{
  public jcz(EditUniqueTitleActivity paramEditUniqueTitleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, onReceive. type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    if (!paramBoolean)
    {
      EditUniqueTitleActivity.a(this.a, -1);
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      localOIDBSSOPkg.mergeFrom(paramBundle);
      paramInt = localOIDBSSOPkg.uint32_result.get();
      EditUniqueTitleActivity.a(this.a, paramInt);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      EditUniqueTitleActivity.a(this.a, -1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */