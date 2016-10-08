import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;
import mqq.os.MqqHandler;

public class mmq
  extends FriendListObserver
{
  public mmq(SubAccountBindActivity paramSubAccountBindActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void a(String paramString, int paramInt)
  {
    ThreadManager.a().post(new mmr(this, paramString, paramInt));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (SubAccountBindActivity.a(this.a) != null) {
        i = SubAccountBindActivity.a(this.a).getChildCount();
      }
      while (j < SubAccountBindActivity.a(this.a).size())
      {
        if ((i > j) && (SubAccountBindActivity.a(this.a).get(j) != null) && (paramString.equals(((SimpleAccount)SubAccountBindActivity.a(this.a).get(j)).getUin())))
        {
          TextView localTextView1 = (TextView)SubAccountBindActivity.a(this.a).getChildAt(j).findViewById(2131296829);
          TextView localTextView2 = (TextView)SubAccountBindActivity.a(this.a).getChildAt(j).findViewById(2131296830);
          localTextView1.setText(ContactUtils.i(this.a.app, paramString));
          localTextView2.setText(this.a.app.b(paramString));
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (SubAccountBindActivity.a(this.a) != null) {
        i = SubAccountBindActivity.a(this.a).getChildCount();
      }
      while (j < SubAccountBindActivity.a(this.a).size())
      {
        if ((i > j) && (SubAccountBindActivity.a(this.a).get(j) != null) && (paramString.equals(((SimpleAccount)SubAccountBindActivity.a(this.a).get(j)).getUin())))
        {
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */