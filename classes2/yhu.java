import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheckResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class yhu
  implements Runnable
{
  public yhu(ShowNodeTaskManager paramShowNodeTaskManager, APNodeCheckResult paramAPNodeCheckResult, Map paramMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "stepReceiveWiFiListFromSvr() APNodeCheckResult size() :" + String.valueOf(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeProtocolPbsrcAPNodeCheckResult.arrApInfo.size()));
    }
    HotSpotNodeUtil.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeProtocolPbsrcAPNodeCheckResult, this.jdField_a_of_type_JavaUtilMap);
    int i = 0;
    while (i < this.jdField_a_of_type_CooperationQqhotspotHotspotnodeProtocolPbsrcAPNodeCheckResult.arrApInfo.size())
    {
      ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager).add(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeProtocolPbsrcAPNodeCheckResult.arrApInfo.get(i));
      i += 1;
    }
    this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */