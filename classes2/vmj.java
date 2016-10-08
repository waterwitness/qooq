import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class vmj
  implements Runnable
{
  public vmj(TroopFeedsDataManager paramTroopFeedsDataManager, List paramList, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = ((TicketManager)localObject2).getSkey(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("qid", "" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("fnum", "1");
    ((Bundle)localObject2).putString("bkn", "" + TroopUtils.b(str));
    ((Bundle)localObject2).putString("fids", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a(this.jdField_a_of_type_JavaUtilList));
    ((Bundle)localObject2).putString("ver", "6.5.5");
    ((Bundle)localObject2).putString("src", "1");
    ((Bundle)localObject2).putString("platform", "android");
    ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("http://web.qun.qq.com/cgi-bin/notice/get_data_new", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, this.jdField_a_of_type_Int, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsDataManager", 2, "get feed from server start: " + System.currentTimeMillis());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */