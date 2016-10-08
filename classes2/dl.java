import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class dl
  extends ClickableSpan
{
  public dl(DatalineSessionAdapter paramDatalineSessionAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(DatalineSessionAdapter.a(this.a), DatalineSessionAdapter.a(this.a).a(), "我的电脑", "我的电脑");
    ReportController.b(DatalineSessionAdapter.a(this.a), "CliOper", "", "", "0X800513D", "0X800513D", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#00a5e0"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */