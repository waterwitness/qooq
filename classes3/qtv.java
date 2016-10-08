import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleDiyHandler;
import com.tencent.mobileqq.bubble.BubbleDiyText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class qtv
  implements Runnable
{
  public qtv(BubbleDiyFetcher paramBubbleDiyFetcher, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a)
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a);
        int j = ((ArrayList)localObject1).size();
        if (j <= 0) {
          return;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        i = 0;
        if (i < j)
        {
          BubbleDiyText localBubbleDiyText = (BubbleDiyText)((EntityManager)localObject2).a(BubbleDiyText.class, " mUinAndTextId=? ", new String[] { (String)((ArrayList)localObject1).get(i) });
          if (localBubbleDiyText == null) {
            break label252;
          }
          localArrayList.add(localBubbleDiyText);
          break label252;
        }
        if ((localArrayList != null) && (!localArrayList.isEmpty()))
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (BubbleDiyText)((Iterator)localObject1).next();
            this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.remove(((BubbleDiyText)localObject2).mUinAndTextId);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, localList);
        return;
      }
      ((BubbleDiyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(70)).a(new ArrayList(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a), null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.clear();
      return;
      label252:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qtv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */