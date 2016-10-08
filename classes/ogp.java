import android.content.Intent;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class ogp
  extends AnimateUtils.AnimationAdapter
{
  ogp(ogo paramogo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a = true;
    paramAnimation = new Intent(this.a.a, SearchContactsActivity.class);
    paramAnimation.putExtra("from_key", this.a.a.a());
    paramAnimation.putExtra("fromType", 13);
    this.a.a.startActivity(paramAnimation);
    this.a.a.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ogp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */