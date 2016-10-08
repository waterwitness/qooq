import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;

public class oee
  implements Runnable
{
  public oee(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.b(str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */