import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qidian.QidianProfileCardActivity;

public class wyi
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  private long b;
  
  public wyi(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (Math.abs(l - this.b) < 1000L);
      this.b = l;
      paramView = (DataTag)paramView.getTag();
      switch (paramView.ah)
      {
      default: 
        return;
      case 4: 
        this.a.b(String.valueOf(paramView.a));
        return;
      case 7: 
        this.a.g();
        return;
      case 20: 
        FriendProfileCardActivity.a(this.a.app, this.a, this.a.a);
        return;
      case 55: 
        this.a.e();
        return;
      case 8: 
        this.a.f();
        return;
      case 52: 
        this.a.a(String.valueOf(paramView.a));
        return;
      case 47: 
        this.a.f(String.valueOf(paramView.a));
        return;
      case 48: 
        Object localObject = (String[])paramView.a;
        paramView = localObject[0];
        localObject = localObject[1];
        this.a.a(paramView, (String)localObject);
        return;
      case 49: 
        this.a.c(String.valueOf(paramView.a));
        return;
      case 50: 
        this.a.d(String.valueOf(paramView.a));
        return;
      case 51: 
        this.a.e(String.valueOf(paramView.a));
        return;
      case 53: 
        this.a.d();
        return;
      }
      paramView = JumpParser.a(this.a.app, this.a, String.valueOf(paramView.a));
    } while (paramView == null);
    paramView.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */