import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class psg
  implements Runnable
{
  public psg(ApolloActionManager paramApolloActionManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.a.a.get();
    if (localBaseChatPie != null) {
      localBaseChatPie.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */