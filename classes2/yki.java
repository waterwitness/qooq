import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.LeakInspector.DumpMemInfoHandler;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LeakHelper;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

class yki
  implements Runnable
{
  yki(ykh paramykh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = DumpMemInfoHandler.a("mobileqzone_leak");
    if (((Boolean)localObject1[0]).booleanValue())
    {
      Object localObject2 = (String)localObject1[1];
      LeakHelper.b((String)localObject2);
      localObject1 = new ConcurrentHashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("fileObj1", localObject2);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("plugin", String.valueOf(7));
      ((ConcurrentHashMap)localObject1).put("fileObj", localHashMap);
      ((ConcurrentHashMap)localObject1).put("clientinfo", localObject2);
      localObject1 = new ResultObject(0, "testcase", true, 1L, 1L, (ConcurrentHashMap)localObject1, true, true, BaseApplicationImpl.a().a().getLongAccountUin());
      ReporterMachine.a(BaseApplicationImpl.a(), (ResultObject)localObject1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */