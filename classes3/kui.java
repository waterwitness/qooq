import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

public final class kui
  implements ClickableColorSpanTextView.SpanClickListener
{
  public kui(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(this.a, QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14");
    this.a.startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */