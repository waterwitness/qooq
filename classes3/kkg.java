import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kkg
  implements View.OnClickListener
{
  public kkg(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FontSettingActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */