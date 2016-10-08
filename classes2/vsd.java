import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfoManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicObserver;
import java.util.concurrent.ConcurrentHashMap;

public class vsd
  implements Runnable
{
  public vsd(TroopTopicMgr paramTroopTopicMgr, String paramString, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    TroopTopicDetailInfo localTroopTopicDetailInfo = (TroopTopicDetailInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    localObject = localTroopTopicDetailInfo;
    if (localTroopTopicDetailInfo == null)
    {
      localObject = new TroopTopicDetailInfo();
      ((TroopTopicDetailInfo)localObject).troopUin = this.jdField_a_of_type_JavaLangString;
      ((TroopTopicDetailInfo)localObject).msgSeq = this.jdField_a_of_type_Long;
    }
    ((TroopTopicDetailInfo)localObject).pVersion = this.b;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.b((TroopTopicDetailInfo)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.jdField_a_of_type_ComTencentMobileqqTroopDataTroopTopicDetailInfoManager.a((TroopTopicDetailInfo)localObject, true);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("ret", 0);
    ((Bundle)localObject).putString("troopUin", this.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putLong("msgSeq", this.jdField_a_of_type_Long);
    ((Bundle)localObject).putLong("pVersion", this.b);
    TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr).notifyObservers(TroopTopicObserver.class, 3, true, (Bundle)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */