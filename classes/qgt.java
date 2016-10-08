import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class qgt
  implements qgw
{
  public qgt(ThreadExcutor paramThreadExcutor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean a()
  {
    return (ThreadExcutor.a) && (UnifiedMonitor.a().whetherReportThisTime(6));
  }
  
  public void a() {}
  
  public void a(Job paramJob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TM.global", 2, "runTimeoutReport " + paramJob.toString());
    }
    if (a())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("priority", "" + paramJob.jdField_a_of_type_Int);
      UnifiedMonitor.a().addEvent(6, paramJob.jdField_a_of_type_JavaLangString, (int)paramJob.c, this.a.d, localHashMap);
      this.a.d = 0;
      return;
    }
    paramJob = this.a;
    paramJob.d += 1;
  }
  
  public void b(Job paramJob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TM.global", 2, "blockingReport " + paramJob.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */