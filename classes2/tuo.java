import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.data.PrecoverResourceBusiness;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.precover.PrecoverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class tuo
  implements Runnable
{
  public tuo(PrecoverManager paramPrecoverManager, String paramString, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager))
    {
      Object localObject1 = (List)PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).remove(this.jdField_a_of_type_JavaLangString);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (PrecoverResource)((Iterator)localObject1).next();
          PrecoverManager.b(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).remove(PrecoverManager.a((PrecoverResource)localObject4));
        }
      }
    }
    PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager, this.jdField_a_of_type_JavaLangString, PrecoverResourceBusiness.class);
    Object localObject3 = PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager, this.jdField_a_of_type_JavaLangString, PrecoverResource.class);
    Object localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
    PrecoverResource localPrecoverResource;
    while (((Iterator)localObject4).hasNext())
    {
      localPrecoverResource = (PrecoverResource)((Iterator)localObject4).next();
      PrecoverManager.b(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).put(PrecoverManager.a(localPrecoverResource), localPrecoverResource);
      PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager, localPrecoverResource);
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = ((List)localObject3).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localPrecoverResource = (PrecoverResource)((Iterator)localObject4).next();
        PrecoverManager.b(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).put(PrecoverManager.a(localPrecoverResource), localPrecoverResource);
      }
    }
    localObject4 = new ArrayList();
    ((List)localObject4).addAll(this.jdField_a_of_type_JavaUtilList);
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localPrecoverResource = (PrecoverResource)((Iterator)localObject3).next();
        if (!((List)localObject4).contains(localPrecoverResource)) {
          ((List)localObject4).add(localPrecoverResource);
        }
      }
    }
    PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).put(this.jdField_a_of_type_JavaLangString, localObject4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tuo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */