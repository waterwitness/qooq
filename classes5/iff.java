import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityForPtt;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

public class iff
  implements ClickableColorSpanTextView.SpanClickListener
{
  public iff(PublicAccountH5AbilityForPtt paramPublicAccountH5AbilityForPtt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(this.a.a, QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14");
    this.a.a.startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */