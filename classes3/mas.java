import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;

class mas
  implements Runnable
{
  mas(mar parammar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem = this.a.a.d;
    if (TextUtils.isEmpty(ProfileCardMoreActivity.b(this.a.a))) {}
    for (String str = "";; str = ProfileCardMoreActivity.b(this.a.a))
    {
      localFormSimpleItem.setRightText(str);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */