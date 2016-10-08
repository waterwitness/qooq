import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mlp
  implements CompoundButton.OnCheckedChangeListener
{
  public mlp(SoundAndVibrateActivity paramSoundAndVibrateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SoundAndVibrateActivity.a(this.a, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mlp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */