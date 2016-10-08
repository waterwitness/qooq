import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class kkp
  implements CompoundButton.OnCheckedChangeListener
{
  public kkp(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131367826), "qqsetting_auto_receive_magic_face_key", paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */