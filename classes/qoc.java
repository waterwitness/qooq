import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class qoc
  implements Runnable
{
  public qoc(SosoInterface.OnLocationListener paramOnLocationListener, TencentLocationRequest paramTencentLocationRequest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SosoInterface.a(0);
    SosoInterface.a(SystemClock.elapsedRealtime());
    SosoInterface.b(0);
    SosoInterface.OnLocationListener.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener, true);
    if (SosoInterface.a() == null) {
      SosoInterface.a(TencentLocationManager.getInstance(BaseApplicationImpl.getContext()));
    }
    int i = SosoInterface.a().requestLocationUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationRequest, SosoInterface.a(), ThreadManager.b());
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "location manager requestLocationUpdates result is: " + i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qoc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */