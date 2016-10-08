import android.os.Bundle;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import java.util.Iterator;
import java.util.LinkedList;

public class pvg
  extends FriendListObserver
{
  public pvg(CircleManager paramCircleManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Bundle paramBundle)
  {
    if ((paramBundle.getBoolean("isHighPriority", false)) && (this.a.c != null))
    {
      paramBundle = this.a.c.iterator();
      while (paramBundle.hasNext()) {
        ((IFriendObserver)paramBundle.next()).a(paramBoolean, paramArrayOfString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */