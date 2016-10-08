import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class oht
  extends Handler
{
  private WeakReference a;
  
  public oht(PublicView paramPublicView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramPublicView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PublicView localPublicView = (PublicView)this.a.get();
    if (localPublicView == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      PublicView.a(localPublicView).H();
      return;
    case 2: 
      PublicView.a(localPublicView).H();
      PublicView.a(localPublicView, 1, 2131368597);
      return;
    case 3: 
      PublicView.a(localPublicView, true);
      return;
    }
    PublicView.b(localPublicView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */