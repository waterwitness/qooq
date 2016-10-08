import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class yhq
  implements Runnable
{
  public yhq(ShowNodeTaskManager paramShowNodeTaskManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager)
    {
      if (!((QQAppInterface)BaseApplicationImpl.a().a()).isLogin())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShowNodeTaskManager", 2, "startShowNodeTask() app is not login");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "startShowNodeTask() From: " + String.valueOf(this.jdField_a_of_type_Int));
      }
      if (this.jdField_a_of_type_Int == ShowNodeTaskManager.jdField_a_of_type_Int)
      {
        if (!ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager)) {
          break label134;
        }
        return;
      }
    }
    if (ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager).get())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "hasTaskRuning");
      }
      return;
    }
    label134:
    if (((this.jdField_a_of_type_Int == ShowNodeTaskManager.b) || (this.jdField_a_of_type_Int == ShowNodeTaskManager.c) || (this.jdField_a_of_type_Int == ShowNodeTaskManager.d)) && (ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager).hasMessages(1))) {
      ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager).removeMessages(1);
    }
    ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager).set(true);
    ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager).clear();
    if (ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager) != -1)
    {
      this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager.a(false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "getCurLocation()");
    }
    HotSpotNodeUtil.a(ShowNodeTaskManager.a(this.jdField_a_of_type_CooperationQqhotspotHotspotnodeShowNodeTaskManager));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */