import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mgx
  implements Runnable
{
  public mgx(QQSettingSettingActivity paramQQSettingSettingActivity, FriendsManager paramFriendsManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingSettingActivity.runOnUiThread(new mgy(this, localCard));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */