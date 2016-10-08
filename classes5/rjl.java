import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rjl
  implements Runnable
{
  public rjl(SogouEmoji paramSogouEmoji, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey begins, allPackId:" + this.jdField_a_of_type_JavaUtilList);
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey ends, param packid is null.");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey,size:" + this.jdField_a_of_type_JavaUtilList.size());
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(str);
        if (localObject == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(str, EmojiManager.e);
          if (QLog.isColorLevel()) {
            QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey, packId=" + str + ",fail to search 【the pack】 from db, try get json from svr.");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey, packId=" + str + ",type:" + ((EmoticonPackage)localObject).type + ",json exists in local db.");
          }
          localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(str, true);
          localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a((ArrayList)localObject);
          if ((localObject != null) && (((ArrayList)localObject).size() != 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a(str, (ArrayList)localObject);
            if (QLog.isColorLevel()) {
              QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey ends, packId=" + str + ", try get keys from svr.");
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */