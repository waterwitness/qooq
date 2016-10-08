import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleDiyText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;

public class qts
  implements Runnable
{
  public qts(BubbleDiyFetcher paramBubbleDiyFetcher, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(BubbleDiyText.class, true, null, null, null, null, " mCreateTime desc ", " 100 ");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BubbleDiyText localBubbleDiyText = (BubbleDiyText)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localBubbleDiyText.mUinAndTextId)) && (!TextUtils.isEmpty(localBubbleDiyText.mText))) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.put(localBubbleDiyText.mUinAndTextId, localBubbleDiyText.mText);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */