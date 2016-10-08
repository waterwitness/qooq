import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class lqu
  implements Runnable
{
  public lqu(Leba paramLeba, LebaViewItem paramLebaViewItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.a().createEntityManager();
    ResourcePluginInfo.persistOrReplace(localEntityManager, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a);
    localEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */