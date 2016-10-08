import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter;
import com.tencent.mobileqq.troop.widget.RadarMembersView.OnMemberIconClickListener;
import com.tencent.mobileqq.troop.widget.ScaleGallery;

public class vej
  implements RadarMembersView.OnMemberIconClickListener
{
  public vej(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a(paramLong);
    if (i >= 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setSelectionNew(i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */