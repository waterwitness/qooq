import android.content.Intent;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter.OnClickOnMemberListener;
import com.tencent.mobileqq.troop.data.NearbyMember;
import com.tencent.mobileqq.troop.widget.ScaleGallery;

public class vef
  implements NearbyMemberAdapter.OnClickOnMemberListener
{
  public vef(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong)
  {
    if (!(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.getSelectedItem() instanceof NearbyMember)) {}
    while (paramLong != ((NearbyMember)this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.getSelectedItem()).a) {
      return;
    }
    Intent localIntent = new Intent(this.a, TroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localIntent.putExtra("memberUin", String.valueOf(paramLong));
    this.a.startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */