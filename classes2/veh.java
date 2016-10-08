import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter;
import com.tencent.mobileqq.troop.utils.NearbyTroopMemMgr;
import com.tencent.mobileqq.troop.utils.NearbyTroopMemMgr.RadarInstanceState;
import com.tencent.mobileqq.troop.widget.RadarView;
import com.tencent.mobileqq.troop.widget.ScaleGallery;

public class veh
  extends Handler
{
  public veh(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    if (paramMessage.what == 1)
    {
      long l = ((Long)paramMessage.obj).longValue();
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setSelection(l);
    }
    do
    {
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          NearbyMemberActivity localNearbyMemberActivity = this.a;
          if (paramMessage.arg1 == 1) {}
          for (double d = 10.0D;; d = this.a.a())
          {
            localNearbyMemberActivity.a(d);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a(this.a.jdField_a_of_type_JavaUtilList);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setMyselfGps(this.a.jdField_b_of_type_Double, this.a.c);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setNearbyMembers(this.a.jdField_a_of_type_JavaUtilList);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setShowRange(10000.0D);
            return;
          }
        }
        if (paramMessage.what != 3) {
          break;
        }
        this.a.g();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 500L);
        if (this.a.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8) {
          this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      } while (this.a.jdField_b_of_type_AndroidWidgetTextView == null);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    } while (paramMessage.what != 4);
    if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a()) {
      i = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a().a);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setSelectionNew(i);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.getItemId(i));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\veh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */