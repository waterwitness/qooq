import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oia
  extends Handler
{
  public oia(SearchBaseActivity paramSearchBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a.clearFocus();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */