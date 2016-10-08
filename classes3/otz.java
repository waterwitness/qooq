import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;

public class otz
  extends FriendListObserver
{
  public otz(TransactionActivity paramTransactionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    TransactionActivity.a(this.a, ContactUtils.c(this.a.app, TransactionActivity.b(this.a), false));
    TransactionActivity.a(this.a).setText(TransactionActivity.c(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */