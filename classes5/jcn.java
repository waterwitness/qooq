import android.app.Dialog;
import android.content.res.Resources;
import android.text.SpannableString;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

public class jcn
  implements Runnable
{
  public jcn(ScannerActivity paramScannerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(this.a.getString(2131367660));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.a.getResources().getColor(2131427492), this.a.getResources().getColor(2131427493)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    ScannerActivity.a(this.a, DialogUtil.a(this.a, this.a.getString(2131367659), localSpannableString, 0, 2131367974, null, null, new jco(this)));
    ScannerActivity.a(this.a).show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */