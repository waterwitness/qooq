import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.PredownloadTest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kki
  implements View.OnClickListener
{
  public kki(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, PredownloadTest.class);
    this.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */