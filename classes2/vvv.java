import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;

public class vvv
  extends ClickableSpan
{
  public vvv(TroopRewardDetailActivity paramTroopRewardDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "http://qun.qq.com/qunpay/reward/read_terms.html?_wv=1039&platform=14");
    this.a.a.startActivity(paramView);
    this.a.c("Clk_provision");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#f64e78"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */