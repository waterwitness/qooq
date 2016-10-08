import android.widget.TextView;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class tco
  implements Runnable
{
  public tco(VipMapRoamActivity paramVipMapRoamActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
    {
      GeoPoint localGeoPoint = this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
      if ((this.a.b == null) || (localGeoPoint == null) || (Math.abs(this.a.b.getLatitudeE6() - localGeoPoint.getLatitudeE6()) <= 1) || (Math.abs(this.a.b.getLongitudeE6() - localGeoPoint.getLongitudeE6()) <= 1)) {
        break label226;
      }
      i = 1;
      if ((this.a.b != null) && (i == 0)) {
        break label231;
      }
      this.a.b = localGeoPoint;
      this.a.d = false;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler != null) && (this.a.b != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipMapRoamActivity", 2, "mRefreshBubbleView run start to getLocationInfo lat=" + this.a.b.getLatitudeE6() + ",lng=" + this.a.b.getLongitudeE6());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(false, true, this.a.b.getLatitudeE6(), this.a.b.getLongitudeE6());
      }
    }
    label226:
    label231:
    do
    {
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "mRefreshBubbleView run start map is not move show last address");
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() != 1) || (!this.a.d));
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */