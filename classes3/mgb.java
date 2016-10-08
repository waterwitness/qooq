import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class mgb
  implements Runnable
{
  public mgb(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (RedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    this.a.k = ((RedTouchManager)localObject).a(String.valueOf(100460));
    if ((this.a.k != null) && (this.a.k.iNewFlag.has()) && (this.a.k.iNewFlag.get() == 1)) {}
    for (int i = 1;; i = 0)
    {
      if (QQSettingMe.a(this.a) != i)
      {
        localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */