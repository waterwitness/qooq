import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnManager;

public class kke
  implements CompoundButton.OnCheckedChangeListener
{
  public kke(AssistantSettingActivity paramAssistantSettingActivity, PstnManager paramPstnManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.b(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */