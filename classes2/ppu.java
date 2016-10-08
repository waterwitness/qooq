import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ppu
  implements Runnable
{
  public ppu(ApolloManager paramApolloManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null)
    {
      long l = 0L;
      if (QLog.isColorLevel()) {
        l = System.currentTimeMillis();
      }
      ApolloManager.a(this.a.a.getApplication());
      ApolloManager.a(this.a);
      ApolloManager.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "init apollo data from db done cost: " + (System.currentTimeMillis() - l));
      }
      ApolloActionManager.a();
      this.a.a(BaseApplicationImpl.getContext());
      ApolloManager.c = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ppu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */