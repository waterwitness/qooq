import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class kzw
  implements Runnable
{
  public kzw(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      return;
    }
    ArrayList localArrayList = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    this.a.jdField_a_of_type_AndroidOsHandler.post(new kzx(this, localArrayList));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */