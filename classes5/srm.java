import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.freshnews.QQInputView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.InputMethodUtil;

public class srm
  implements Runnable
{
  public srm(QQInputView paramQQInputView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQInputView.a(this.a).setVisibility(8);
    QQInputView.a(this.a).setImageResource(2130842146);
    if (AppSetting.j) {
      QQInputView.a(this.a).setContentDescription("键盘按钮");
    }
    InputMethodUtil.a(QQInputView.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */