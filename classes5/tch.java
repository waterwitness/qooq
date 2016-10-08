import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class tch
  implements Runnable
{
  public tch(VipMapRoamActivity paramVipMapRoamActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    View localView = this.a.findViewById(16908290);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = localView.getHeight();
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
    if (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null)
    {
      this.a.b = this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
      this.a.a(true, false);
      this.a.g = true;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler != null) && (this.a.b != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(false, true, this.a.b.getLatitudeE6(), this.a.b.getLongitudeE6());
      }
    }
    VipMapRoamActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */