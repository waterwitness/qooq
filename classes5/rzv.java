import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class rzv
  implements Runnable
{
  public rzv(UniformDownloadMgr paramUniformDownloadMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject4;
    Object localObject5;
    synchronized (UniformDownloadMgr.a(this.a))
    {
      if (UniformDownloadMgr.a(this.a).size() > 0)
      {
        localObject4 = UniformDownloadMgr.a(this.a).entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (sae)((Map.Entry)((Iterator)localObject4).next()).getValue();
          if ((((sae)localObject5).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) && (8 == ((sae)localObject5).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.f()) && (2 == ((sae)localObject5).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.g())) {
            localArrayList.add(localObject5);
          }
        }
      }
    }
    ??? = ((List)localObject2).iterator();
    Object localObject3;
    while (((Iterator)???).hasNext())
    {
      localObject3 = (sae)((Iterator)???).next();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> resumeRuningGenDownloadOfOldApp, url:[" + ((sae)localObject3).jdField_a_of_type_JavaLangString + "]");
      ((sae)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.a();
    }
    if (UniformDownloadMgr.a(this.a))
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. start resume");
      localObject3 = this.a.a();
      this.a.d();
      ??? = new HashMap();
      if ((localObject3 != null) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject3).next();
          localObject4 = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (saf)((Map.Entry)localObject5).getValue();
          if (localObject5 != null)
          {
            if (((saf)localObject5).jdField_a_of_type_Boolean)
            {
              ((Map)???).put(localObject4, localObject5);
            }
            else
            {
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject4 + "]" + " nId:[" + ((saf)localObject5).jdField_a_of_type_Int + "] - 1");
              UniformDownloadMgr.a(this.a, (String)localObject4, ((saf)localObject5).jdField_a_of_type_JavaLangString, ((saf)localObject5).jdField_a_of_type_Long, ((saf)localObject5).jdField_a_of_type_AndroidOsBundle, ((saf)localObject5).jdField_a_of_type_Int, true);
            }
          }
          else {
            QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + (String)localObject4 + "] -1");
          }
        }
      }
      if (((Map)???).size() > 0)
      {
        ??? = ((Map)???).entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)???).next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (saf)((Map.Entry)localObject4).getValue();
          if (localObject4 != null)
          {
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject3 + "]" + " nId:[" + ((saf)localObject4).jdField_a_of_type_Int + "] - 2");
            UniformDownloadMgr.a(this.a, (String)localObject3, ((saf)localObject4).jdField_a_of_type_JavaLangString, ((saf)localObject4).jdField_a_of_type_Long, ((saf)localObject4).jdField_a_of_type_AndroidOsBundle, ((saf)localObject4).jdField_a_of_type_Int, true);
          }
          else
          {
            QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + (String)localObject3 + "] -2");
          }
        }
      }
    }
    else
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. not resume");
      this.a.d();
    }
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */