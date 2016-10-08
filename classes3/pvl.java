import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;

public class pvl
  implements Runnable
{
  public pvl(ClubContentUpdateHandler paramClubContentUpdateHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.a();
    if (localQQAppInterface != null) {
      ((IndividualRedPacketManager)localQQAppInterface.getManager(130)).a().a(false, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */