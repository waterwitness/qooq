import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kix
  implements View.OnClickListener
{
  public kix(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    AddFriendVerifyActivity.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */