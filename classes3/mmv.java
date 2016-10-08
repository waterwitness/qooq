import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SubAccountInfoListActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.List;

public class mmv
  extends FriendListObserver
{
  public mmv(SubAccountInfoListActivity paramSubAccountInfoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    label237:
    for (;;)
    {
      return;
      if (SubAccountInfoListActivity.a(this.a) != null) {}
      for (int i = SubAccountInfoListActivity.a(this.a).getChildCount();; i = 0)
      {
        if (SubAccountInfoListActivity.a(this.a) == null) {
          break label237;
        }
        while (j < SubAccountInfoListActivity.a(this.a).size())
        {
          if ((i > j) && (SubAccountInfoListActivity.a(this.a).get(j) != null) && (paramString.equals(((SubAccountInfo)SubAccountInfoListActivity.a(this.a).get(j)).subuin)))
          {
            TextView localTextView1 = (TextView)SubAccountInfoListActivity.a(this.a).getChildAt(j).findViewById(2131299254);
            TextView localTextView2 = (TextView)SubAccountInfoListActivity.a(this.a).getChildAt(j).findViewById(2131305051);
            localTextView1.setText(ContactUtils.i(this.a.app, paramString));
            localTextView2.setText(this.a.app.b(paramString));
            paramString = FaceDrawable.a(this.a.app, 1, paramString);
            ((ImageView)SubAccountInfoListActivity.a(this.a).getChildAt(j).findViewById(2131296821)).setImageDrawable(paramString);
            return;
          }
          j += 1;
        }
        break;
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
      if (SubAccountInfoListActivity.a(this.a) != null) {
        i = SubAccountInfoListActivity.a(this.a).getChildCount();
      }
      while (j < SubAccountInfoListActivity.a(this.a).size())
      {
        if ((i > j) && (SubAccountInfoListActivity.a(this.a).get(j) != null) && (paramString.equals(((SubAccountInfo)SubAccountInfoListActivity.a(this.a).get(j)).subuin)))
        {
          paramString = FaceDrawable.a(this.a.app, 1, paramString);
          ((ImageView)SubAccountInfoListActivity.a(this.a).getChildAt(j).findViewById(2131296821)).setImageDrawable(paramString);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */