import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class hfv
  implements Runnable
{
  public hfv(TroopRedTouchManager paramTroopRedTouchManager, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new File(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager.a.getApplication().getFilesDir(), "TroopRedTouchManager" + this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager.a.a()).getAbsolutePath();
    try
    {
      FileUtils.a((String)localObject, this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.toByteArray(), false);
      localObject = new StringBuilder("saveLocalFile==>");
      int i = 0;
      while (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
      {
        ((StringBuilder)localObject).append(TroopRedTouchManager.a((oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i)));
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager.b + "Q.qqstory.redPoint", 2, localException.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */