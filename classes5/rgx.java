import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class rgx
  extends FavEmoRoamingObserver
{
  public rgx(FavroamingManager paramFavroamingManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList)
  {
    if (this.a.mApp == null) {
      return;
    }
    this.a.mApp.b(FavroamingManager.access$100(this.a));
    ThreadManager.a(new rgy(this, paramList), 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.mApp == null) {}
    while (!paramBoolean) {
      return;
    }
    this.a.syncRoaming();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */