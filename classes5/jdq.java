import android.os.Handler;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import org.json.JSONObject;

public class jdq
  implements Runnable
{
  public jdq(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = TroopFeedsDataManager.TroopNotify.a(this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.c, this.jdField_a_of_type_OrgJsonJSONObject);
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidOsHandler.post(new jdr(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */