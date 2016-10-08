import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rgt
  implements Runnable
{
  public rgt(FavroamingDBManager paramFavroamingDBManager, List paramList, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.a.a().createEntityManager();
    if (localEntityManager == null) {}
    boolean bool2;
    do
    {
      return;
      int i = 0;
      bool2 = false;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)this.jdField_a_of_type_JavaUtilList.get(i);
        boolean bool1;
        switch (this.jdField_a_of_type_Int)
        {
        case 3: 
        default: 
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("FavroamingDBManager", 2, "can not save fav emoticon data, type:" + this.jdField_a_of_type_Int);
            bool1 = bool2;
          }
          break;
        }
        for (;;)
        {
          i += 1;
          bool2 = bool1;
          break;
          localCustomEmotionData.setStatus(1000);
          localEntityManager.a(localCustomEmotionData);
          bool1 = bool2;
          continue;
          bool1 = localEntityManager.a(localCustomEmotionData);
          continue;
          bool1 = localEntityManager.b(localCustomEmotionData);
        }
      }
      localEntityManager.a();
    } while (!QLog.isColorLevel());
    QLog.d("FavroamingDBManager", 2, "updateFavEmotionDataListInDB type:" + this.jdField_a_of_type_Int + ",data size:" + this.jdField_a_of_type_JavaUtilList.size() + " save result: " + bool2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */