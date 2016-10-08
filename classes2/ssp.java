import com.tencent.ark.ark;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ssp
  implements Runnable
{
  public ssp(GamePartyManager paramGamePartyManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      ark.arkNotify("com.tencent.qqopen.teamup", "update_team_info", this.jdField_a_of_type_JavaLangString, "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(GamePartyManager.a(), 2, "arkNotify failed, .so not loaded");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ssp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */