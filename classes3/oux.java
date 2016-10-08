import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class oux
  implements Runnable
{
  public oux(PreloadManager paramPreloadManager, Set paramSet, List paramList, Map paramMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_JavaUtilList.add(str);
      this.jdField_a_of_type_JavaUtilMap.put(str, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.b(str)));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oux.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */