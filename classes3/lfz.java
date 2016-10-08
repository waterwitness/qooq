import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lfz
  implements View.OnClickListener
{
  lfz(lfy paramlfy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, DiscussionMemberActivity.class);
    paramView.putExtra("uin", DiscussionInfoCardActivity.a(this.a.a));
    this.a.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */