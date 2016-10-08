import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;

public class sug
  implements View.OnClickListener
{
  public sug(HotChatPttStageControl paramHotChatPttStageControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.l();
    if (AppSetting.j) {}
    try
    {
      AccessibilityUtil.a(paramView, "已给房间点赞");
      return;
    }
    catch (Throwable paramView) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */