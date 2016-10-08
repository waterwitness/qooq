import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kzj
  implements Runnable
{
  public kzj(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (PublicAccountDataManager)this.a.app.getManager(55);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).b(String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.associatePubAccount));; localObject = null)
    {
      if (localObject == null) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(20);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */