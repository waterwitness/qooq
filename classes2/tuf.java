import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class tuf
  extends FriendListObserver
{
  public tuf(PortalManager paramPortalManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManagerhead", 2, "onUpdateCustomHead isSuccess = " + paramBoolean + ", mobileNumber = " + paramString);
    }
    if (this.a.a.containsKey(paramString)) {
      ThreadManager.b().post(new tug(this, paramString, paramBoolean));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */