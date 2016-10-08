import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;

public class uiz
  implements View.OnClickListener
{
  public uiz(StatusHistoryActivity paramStatusHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (StatusHistoryActivity.ItemViewHolder)paramView.getTag();
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.a);
    this.a.startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uiz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */