import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mfsdk.LeakInspector.DumpMemInfoHandler;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectorListener;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class kfy
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private LeakInspector.InspectUUID jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID;
  
  public kfy(LeakInspector paramLeakInspector, LeakInspector.InspectUUID paramInspectUUID, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID = paramInspectUUID;
  }
  
  public void run()
  {
    for (;;)
    {
      Object localObject4;
      String str;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("LeakInspector", 2, new Object[] { "Inspecting ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), " Time=", Long.valueOf(System.currentTimeMillis()), " count=", Integer.valueOf(this.jdField_a_of_type_Int) });
        }
        if (this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
          break;
        }
        int i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        if (i < LeakInspector.a())
        {
          System.runFinalization();
          Runtime.getRuntime().gc();
          LeakInspector.a(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector).postDelayed(this, 5000L);
          return;
        }
        if (AppSetting.k)
        {
          Object localObject1 = LeakInspector.a(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector).a(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString());
          localObject3 = this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.jdField_a_of_type_JavaLangString + "_leak";
          Object[] arrayOfObject = DumpMemInfoHandler.b((String)localObject3);
          localObject4 = (Boolean)arrayOfObject[0];
          str = "";
          if (((Boolean)localObject4).booleanValue())
          {
            localObject4 = new ArrayList();
            ((List)localObject4).add((String)arrayOfObject[1]);
            if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
              ((List)localObject4).addAll((Collection)localObject1);
            }
            localObject1 = DumpMemInfoHandler.a((List)localObject4, (String)localObject3);
            localObject4 = (Boolean)localObject1[0];
            str = (String)localObject1[1];
            localObject3 = localObject4;
            localObject1 = str;
            if (QLog.isColorLevel())
            {
              QLog.d("LeakInspector", 2, new Object[] { "leakFlag=true,ZipFile=", localObject4, ",leakName=", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), ",dumpPath=", str });
              localObject1 = str;
              localObject3 = localObject4;
            }
            LeakInspector.a(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector).a(((Boolean)localObject3).booleanValue(), this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), (String)localObject1);
            localObject3 = new ConcurrentHashMap(2);
            localObject4 = new HashMap(1);
            ((HashMap)localObject4).put("fileObj1", localObject1);
            localObject1 = new HashMap(7);
            ((HashMap)localObject1).put("plugin", String.valueOf(7));
            ((ConcurrentHashMap)localObject3).put("fileObj", localObject4);
            ((ConcurrentHashMap)localObject3).put("clientinfo", localObject1);
            ReporterMachine.a(null, new ResultObject(0, "testcase", true, 1L, 1L, (ConcurrentHashMap)localObject3, true, true, MagnifierSDK.a));
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("LeakInspector", 2, new Object[] { "inspect ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), " leaked" });
          }
          if (LeakInspector.a(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector).a(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID)) {
            return;
          }
          LeakInspector.a().recycle(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeakInspector", 2, localThrowable, new Object[] { "error, ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), " Time=", Long.valueOf(System.currentTimeMillis()), " count=", Integer.valueOf(this.jdField_a_of_type_Int) });
        }
        LeakInspector.a().recycle(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID);
        return;
      }
      Object localObject3 = localObject4;
      Object localObject2 = str;
      if (QLog.isColorLevel())
      {
        QLog.e("LeakInspector", 2, new Object[] { "generateHprof error ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString() });
        localObject3 = localObject4;
        localObject2 = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, new Object[] { "inspect ", this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID.toString(), " finished no leak" });
    }
    LeakInspector.a().recycle(this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */