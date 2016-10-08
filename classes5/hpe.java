import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hpe
  implements View.OnClickListener
{
  public hpe(PublicAccountBrowser paramPublicAccountBrowser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.leftView)
    {
      paramView = this.a.leftView.getText().toString();
      if (paramView.equals(this.a.getIntent().getStringExtra("leftViewText"))) {
        this.a.onBackPressed();
      }
    }
    while (paramView != this.a.rightViewText)
    {
      return;
      this.a.a.loadUrl("javascript:onLeftBtn(\"" + paramView + "\")");
      return;
    }
    paramView = this.a.rightViewText.getText().toString();
    this.a.a.loadUrl("javascript:onRightBtn(\"" + paramView + "\")");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */