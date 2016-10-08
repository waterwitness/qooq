import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class kzl
  implements View.OnClickListener
{
  public kzl(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = String.format(this.a.getString(2131369440), new Object[] { this.a.a.troopName, this.a.a.troopUin });
      if (Build.VERSION.SDK_INT < 11)
      {
        ((android.text.ClipboardManager)this.a.getSystemService("clipboard")).setText(paramView);
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        paramView = "";
      }
      ((android.content.ClipboardManager)this.a.getSystemService("clipboard")).setText(paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */