package cooperation.dingdong.data;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.utils.DingdongSoundUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleNotificationData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import ybp;
import ybq;

public class ScheduleReminderMgr
{
  private static final String jdField_a_of_type_JavaLangString = "ScheduleReminderMgr";
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DingdongPluginBizObserver.ScheduleNotificationData jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$ScheduleNotificationData;
  private ScheduleReminderMgr.onScheduleTipsListener jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr$onScheduleTipsListener;
  
  public ScheduleReminderMgr(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getBaseContext();
    a();
  }
  
  private void a()
  {
    QQAppInterface localQQAppInterface;
    if (!DingdongSoundUtil.a("dingdong_schedule_notify.mp3"))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ScheduleReminderMgr", 2, "initSound");
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
      if (localQQAppInterface != null) {
        break label51;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ScheduleReminderMgr", 2, "initSound tempApp is null ");
      }
    }
    return;
    label51:
    DingdongSoundUtil.a(localQQAppInterface);
  }
  
  private void a(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    new ybq(this, paramScheduleSummaryData).execute(new Void[] { null, null, null });
  }
  
  public void a(DingdongPluginBizObserver.ScheduleNotificationData paramScheduleNotificationData)
  {
    if (paramScheduleNotificationData != null)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("ScheduleReminderMgr", 1, "HandlerScheduleOfflineNotify.endTime = " + paramScheduleNotificationData.a.endTime + " nowTime = " + l);
      }
      if ((paramScheduleNotificationData.a.endTime > l) && (this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$ScheduleNotificationData == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$ScheduleNotificationData = paramScheduleNotificationData;
        paramScheduleNotificationData = new Handler(Looper.myLooper());
        if (paramScheduleNotificationData != null) {
          paramScheduleNotificationData.postDelayed(new ybp(this), 8000L);
        }
      }
    }
  }
  
  public void a(ScheduleReminderMgr.onScheduleTipsListener paramonScheduleTipsListener)
  {
    this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr$onScheduleTipsListener = paramonScheduleTipsListener;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr$onScheduleTipsListener != null) && (this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr$onScheduleTipsListener.a());
  }
  
  public void b(DingdongPluginBizObserver.ScheduleNotificationData paramScheduleNotificationData)
  {
    if (paramScheduleNotificationData == null) {
      return;
    }
    if (this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr$onScheduleTipsListener == null)
    {
      a(paramScheduleNotificationData.a);
      return;
    }
    this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr$onScheduleTipsListener.a(paramScheduleNotificationData.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\data\ScheduleReminderMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */