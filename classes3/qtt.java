import android.text.TextUtils;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleDiyText;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class qtt
  implements Runnable
{
  public qtt(BubbleDiyFetcher paramBubbleDiyFetcher, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator1.hasNext())
      {
        BubbleDiyText localBubbleDiyText = (BubbleDiyText)localIterator1.next();
        if (!TextUtils.isEmpty(localBubbleDiyText.mUinAndTextId))
        {
          List localList = (List)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.get(localBubbleDiyText.mUinAndTextId);
          if (localList != null)
          {
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext())
            {
              SoftReference localSoftReference = (SoftReference)localIterator2.next();
              if (localSoftReference.get() != null) {
                ((VipBubbleDrawable)localSoftReference.get()).a(localBubbleDiyText.mUinAndTextId, localBubbleDiyText.mText);
              }
            }
            localList.clear();
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.a.remove(localBubbleDiyText.mUinAndTextId);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qtt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */