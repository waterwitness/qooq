import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;

public class veg
  implements AdapterView.OnItemSelectedListener
{
  public veg(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView == null) {}
    while (!this.a.jdField_a_of_type_Boolean) {
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    paramAdapterView = Message.obtain();
    paramAdapterView.what = 1;
    paramAdapterView.obj = Long.valueOf(paramLong);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramAdapterView, 200L);
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\veg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */