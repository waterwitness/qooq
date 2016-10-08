import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;

public class hua
  implements Runnable
{
  public hua(EcShopAssistantManager paramEcShopAssistantManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a.b)
    {
      Object[] arrayOfObject = this.a.jdField_a_of_type_JavaUtilSet.toArray();
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        SharedPreferencesHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit(), "ec_shop_assist_new_unread_list", arrayOfObject).commit();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */