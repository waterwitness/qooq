import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.freshnews.QQInputView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class srn
  implements Runnable
{
  public srn(QQInputView paramQQInputView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQInputView.a(this.a).setVisibility(0);
    QQInputView.a(this.a).setImageResource(2130842147);
    if (AppSetting.j) {
      QQInputView.a(this.a).setContentDescription("表情按钮");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */