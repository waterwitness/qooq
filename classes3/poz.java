import android.os.Bundle;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.MqqNearbyGdt.ExposeResponse;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class poz
  implements BusinessObserver
{
  public poz(PeopleAroundAdapter paramPeopleAroundAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        MqqNearbyGdt.ExposeResponse localExposeResponse = new MqqNearbyGdt.ExposeResponse();
        localExposeResponse.mergeFrom(paramBundle);
        if ((localExposeResponse.retcode.get() == 0) && (QLog.isColorLevel())) {
          QLog.d("PeopleAroundAdapter", 2, "mAdExposeObserver success");
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PeopleAroundAdapter", 2, "mAdExposeObserver error, " + paramBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\poz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */