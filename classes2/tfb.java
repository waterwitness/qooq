import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import java.util.Iterator;
import java.util.List;

public class tfb
  implements Runnable
{
  public tfb(EmoticonManager paramEmoticonManager, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
      if (localEmoticonPackage != null) {
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(localEmoticonPackage);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */