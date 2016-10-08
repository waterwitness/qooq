import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mwa
  extends ClickableSpan
{
  public mwa(TroopMemberListActivity.ListAdapter paramListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "http://exp.qq.com/ur/?urid=23242");
    paramView.putExtra("hide_operation_bar", true);
    paramView.putExtra("hide_more_button", true);
    this.a.a.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16732929);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */