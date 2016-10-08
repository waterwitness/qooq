import android.support.v4.util.LruCache;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class tfa
  implements Runnable
{
  public tfa(EmoticonManager paramEmoticonManager, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Emoticon localEmoticon = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { this.jdField_a_of_type_JavaLangString, this.b });
    if (localEmoticon != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localEmoticon.getMapKey(), localEmoticon);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "hit db, put into cache");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */