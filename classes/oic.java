import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oic
  extends Handler
{
  public oic(SearchBaseFragment paramSearchBaseFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (SearchBaseFragment.a(this.a) != null) {
      SearchBaseFragment.a(this.a).sendMessage(Message.obtain(paramMessage));
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.a();
      return;
    case 1: 
      this.a.a((String)paramMessage.obj);
      return;
    case 2: 
      this.a.f();
      return;
    }
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */