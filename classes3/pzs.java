import android.content.SharedPreferences;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pzs
  implements Runnable
{
  public pzs(MayknowRecommendManager paramMayknowRecommendManager, boolean paramBoolean, long paramLong)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((Math.abs(MayknowRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager).getLong("sp_get_mayknow_timestamp", 0L) - System.currentTimeMillis()) >= 86400000L) || (this.jdField_a_of_type_Boolean)) {
      ((FriendListHandler)MayknowRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager).a(1)).a((short)MayknowRecommendManager.c(), this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */