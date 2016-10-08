import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.webviewplugin.famous.QzoneFamousShareJsPlugin;

public class ysa
  implements ActionSheet.OnButtonClickListener
{
  public ysa(QzoneFamousShareJsPlugin paramQzoneFamousShareJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (QzoneFamousShareJsPlugin.a(this.a)) {
      return;
    }
    QzoneFamousShareJsPlugin.a(this.a, true);
    QzoneFamousShareJsPlugin.a(this.a).dismiss();
    QzoneFamousShareJsPlugin.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */