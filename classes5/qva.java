import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class qva
  implements Runnable
{
  public qva(BusinessCardManager paramBusinessCardManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = BusinessCardManager.a(this.a);
    if (localObject != null) {}
    for (int i = ((List)localObject).size();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_Manager", 2, "Init cache from DB,count=" + i);
      }
      this.a.a.clear();
      if (i <= 0) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessCard localBusinessCard = (BusinessCard)((Iterator)localObject).next();
        this.a.a.put(localBusinessCard.cardId, localBusinessCard);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */