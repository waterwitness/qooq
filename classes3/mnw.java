import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;

public class mnw
  extends FriendListObserver
{
  public mnw(SubAccountSettingActivity paramSubAccountSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (SubAccountSettingActivity.a(this.a) != null) && (SubAccountSettingActivity.a(this.a).subuin != null) && (paramString != null) && (SubAccountSettingActivity.a(this.a).subuin.equals(paramString)))
    {
      paramString = ContactUtils.c(this.a.app, paramString, false);
      if ((!TextUtils.isEmpty(paramString)) && ((TextUtils.isEmpty(SubAccountSettingActivity.a(this.a).subname)) || (!paramString.equals(SubAccountSettingActivity.a(this.a).subname))))
      {
        SubAccountSettingActivity.a(this.a).subname = paramString;
        SubAccountSettingActivity.a(this.a).setText(SubAccountSettingActivity.a(this.a).subname);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (SubAccountSettingActivity.a(this.a) == null) || (!paramString.equals(SubAccountSettingActivity.a(this.a).subuin))) {}
    while (SubAccountSettingActivity.a(this.a) == null) {
      return;
    }
    paramString = FaceDrawable.a(this.a.app, 1, SubAccountSettingActivity.a(this.a).subuin);
    SubAccountSettingActivity.a(this.a).setImageDrawable(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */