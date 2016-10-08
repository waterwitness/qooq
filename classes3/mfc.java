import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.data.OfficeCenterSharedPref;

public class mfc
  implements Runnable
{
  public mfc(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + localQQAppInterface.getLongAccountUin(), false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */