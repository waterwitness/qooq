import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.activity.OlympicSettingActivity;

public class trq
  implements CompoundButton.OnCheckedChangeListener
{
  public trq(OlympicSettingActivity paramOlympicSettingActivity, OlympicManager paramOlympicManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a("olympic_entrance_setting", paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */