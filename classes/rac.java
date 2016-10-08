import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rac
  implements Runnable
{
  public rac(AboutConfig paramAboutConfig)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = AboutConfig.a(this.a).a().createEntityManager();
    List localList = ResourcePluginInfo.getAll(localEntityManager, 32, false);
    localEntityManager.a();
    if ((localList != null) && (localList.size() > 0))
    {
      AboutConfig.a(this.a);
      AboutConfig.a(this.a, localList);
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "Load about config from DB = " + AboutConfig.a(this.a));
      }
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */