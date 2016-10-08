import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;

class wed
  implements Runnable
{
  wed(wec paramwec)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.a();
    if (localQQAppInterface != null)
    {
      IndividualRedPacketManager localIndividualRedPacketManager = (IndividualRedPacketManager)localQQAppInterface.getManager(130);
      String str = "0";
      if (localIndividualRedPacketManager.a()) {
        str = "1";
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800612B", "0X800612B", 0, 0, str, "1", "", "");
      localIndividualRedPacketManager.a().a(true, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */