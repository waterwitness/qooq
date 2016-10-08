import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter;
import com.tencent.mobileqq.troop.widget.RadarMembersView.OnDrawReadyListener;
import com.tencent.mobileqq.troop.widget.RadarView;
import com.tencent.mobileqq.troop.widget.ScaleGallery;

public class vds
  implements RadarMembersView.OnDrawReadyListener
{
  public vds(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.a();
    int i = this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.getSelectedItemPosition();
    int j = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a(paramLong);
    if (j >= 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setSelectionNew(j);
    }
    if ((i == j) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setSelection(paramLong);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */