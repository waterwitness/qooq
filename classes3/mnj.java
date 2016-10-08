import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.adapter.SubAccountMessageAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class mnj
  extends FriendListObserver
{
  public mnj(SubAccountMessageActivity paramSubAccountMessageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (SubAccountMessageActivity.a(this.a) != null) && (SubAccountMessageActivity.a(this.a).subuin != null) && (paramString != null) && (SubAccountMessageActivity.a(this.a).subuin.equals(paramString)))
    {
      paramString = ContactUtils.c(this.a.app, paramString, false);
      if ((!TextUtils.isEmpty(paramString)) && ((TextUtils.isEmpty(SubAccountMessageActivity.a(this.a).subname)) || (!paramString.equals(SubAccountMessageActivity.a(this.a).subname))))
      {
        SubAccountMessageActivity.a(this.a).subname = paramString;
        if (SubAccountMessageActivity.a(this.a) != null) {
          SubAccountMessageActivity.a(this.a).setText(paramString);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (SubAccountMessageActivity.a(this.a) != null)
      {
        int i = 0;
        while (i < SubAccountMessageActivity.a(this.a).getChildCount())
        {
          View localView = SubAccountMessageActivity.a(this.a).getChildAt(i);
          SubAccountMessageActivity.a(this.a).a(paramString, localView);
          i += 1;
        }
      }
    } while ((SubAccountMessageActivity.a(this.a) == null) || (SubAccountMessageActivity.a(this.a).subuin == null) || (!SubAccountMessageActivity.a(this.a).subuin.equals(paramString)));
    paramString = FaceDrawable.a(this.a.app, 1, paramString);
    SubAccountMessageActivity.a(this.a).setImageDrawable(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */