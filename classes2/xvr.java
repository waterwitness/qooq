import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XCursorAdapter;

public class xvr
  extends ContentObserver
{
  public xvr(XCursorAdapter paramXCursorAdapter)
  {
    super(new Handler());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */