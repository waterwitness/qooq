import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicBoolean;

public class pqm
  implements Runnable
{
  public pqm(ApolloSurfaceView paramApolloSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ApolloActionManager.a().a.get()) {
      this.a.a().d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */