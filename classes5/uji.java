import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusJsHandler;

public class uji
  implements Runnable
{
  public uji(StatusJsHandler paramStatusJsHandler, LocationManager paramLocationManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = new Criteria();
    ((Criteria)localObject1).setAltitudeRequired(false);
    ((Criteria)localObject1).setBearingRequired(false);
    ((Criteria)localObject1).setCostAllowed(true);
    ((Criteria)localObject1).setPowerRequirement(1);
    try
    {
      ((Criteria)localObject1).setAccuracy(1);
      Object localObject2 = this.jdField_a_of_type_AndroidLocationLocationManager.getBestProvider((Criteria)localObject1, true);
      localObject2 = this.jdField_a_of_type_AndroidLocationLocationManager.getLastKnownLocation((String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.b, ((Location)localObject2).getLongitude() + "," + ((Location)localObject2).getLatitude());
      return;
    }
    catch (Exception localException2)
    {
      try
      {
        ((Criteria)localObject1).setAccuracy(2);
        localObject1 = this.jdField_a_of_type_AndroidLocationLocationManager.getBestProvider((Criteria)localObject1, true);
        localObject1 = this.jdField_a_of_type_AndroidLocationLocationManager.getLastKnownLocation((String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.b, ((Location)localObject1).getLongitude() + "," + ((Location)localObject1).getLatitude());
        return;
      }
      catch (Exception localException1)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.b, "0, 0");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */