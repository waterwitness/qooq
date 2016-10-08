import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class otk
  implements Runnable
{
  public otk(PreloadImgManager paramPreloadImgManager, AppInterface paramAppInterface, Set paramSet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    Object localObject = new File(str, "urlList.cfg");
    if ((this.jdField_a_of_type_JavaUtilSet == null) || (this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      return;
    }
    localObject = new StringBuilder();
    int j = this.jdField_a_of_type_JavaUtilSet.size();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append((String)localIterator.next());
      if (i < j - 1) {
        ((StringBuilder)localObject).append(",");
      }
      i += 1;
    }
    FileUtils.a(str, "urlList.cfg", new String(Base64.encode(((StringBuilder)localObject).toString().getBytes(), 0)));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */