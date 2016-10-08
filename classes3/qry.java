import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.debug.ArkDebugSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qry
  implements View.OnClickListener
{
  public qry(ArkDebugSettingActivity paramArkDebugSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */