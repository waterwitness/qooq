import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class otm
  implements Runnable
{
  public otm(PreloadImgManager paramPreloadImgManager, Set paramSet, String paramString1, String paramString2, AppInterface paramAppInterface, List paramList, String paramString3, Map paramMap, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager).evictAll();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        Object localObject1 = localObject2;
        if (!((String)localObject2).endsWith("@xhdpi.png")) {
          localObject1 = (String)localObject2 + "@xhdpi.png";
        }
        String str = MD5.toMD5((String)localObject1);
        Object localObject3 = new File(this.jdField_a_of_type_JavaLangString, str);
        localObject2 = localObject3;
        if (!((File)localObject3).exists()) {
          localObject2 = new File(this.b, str);
        }
        if (((File)localObject2).exists())
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager;
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
          if (PreloadImgManager.a((PreloadImgManager)localObject3, MobileQQ.getContext(), ((File)localObject2).getPath(), (String)localObject1) != null) {}
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          localObject2 = new File(this.c, str);
          this.jdField_a_of_type_JavaUtilMap.put(localObject1, localObject2);
          this.jdField_a_of_type_AndroidOsBundle.putString((String)localObject1, ((File)localObject2).getPath());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */