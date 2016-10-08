import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.data.ScheduleReminderMgr;
import cooperation.dingdong.data.ScheduleTipsDialog;

public class ybq
  extends AsyncTask
{
  public ybq(ScheduleReminderMgr paramScheduleReminderMgr, DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(DingdongPluginHelper.b(ScheduleReminderMgr.a(this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr).a().getApplicationContext()));
  }
  
  protected void a(Boolean paramBoolean)
  {
    Intent localIntent = new Intent(ScheduleReminderMgr.a(this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr).a().getApplicationContext(), ScheduleTipsDialog.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("isforeground", paramBoolean);
    localIntent.putExtra("summaryinfo", this.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData);
    ScheduleReminderMgr.a(this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr).a().getApplicationContext().startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */