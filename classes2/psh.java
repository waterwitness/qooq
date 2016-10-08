import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class psh
  implements Runnable
{
  public psh(ApolloActionManager paramApolloActionManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131372342), 1).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */