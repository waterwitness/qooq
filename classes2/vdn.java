import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.ContactsTroopActivity;

public class vdn
  implements Runnable
{
  public vdn(ContactsTroopActivity paramContactsTroopActivity, TroopInfo paramTroopInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqTroopActivityContactsTroopActivity.app.getManager(51);
    if (localObject != null)
    {
      TroopInfo localTroopInfo = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      if (localTroopInfo != null)
      {
        localTroopInfo.dwOfficeMode = 1L;
        ((TroopManager)localObject).b(localTroopInfo);
        localObject = Message.obtain();
        ((Message)localObject).what = 102;
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityContactsTroopActivity.a.sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */