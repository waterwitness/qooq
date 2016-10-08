import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class uqb
  implements Runnable
{
  public uqb(PtvTemplateManager paramPtvTemplateManager, File paramFile, Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, String.format("双人挂件加载 start, rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    ??? = new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    if (((File)???).exists())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(null, (File)???);
      break label121;
      label61:
      if (QLog.isColorLevel()) {
        QLog.i(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "initLocalTemplateConfigInfoWithExtra, after rebuildTemplateInfos, size = " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_a_of_type_JavaUtilArrayList.size());
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
      if (!TextUtils.isEmpty((CharSequence)???)) {
        break label140;
      }
    }
    for (;;)
    {
      label121:
      return;
      if (!QLog.isColorLevel()) {
        break label61;
      }
      QLog.d(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "initLocalTemplateConfigInfoWithExtra, CACHE_TEMPLATE_CONFIG_NAME config file not exist.");
      break label61;
      label140:
      Object localObject5 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager, (String)???);
      if ((localObject5 == null) || (((List)localObject5).isEmpty())) {
        break;
      }
      ArrayList localArrayList = new ArrayList();
      synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_b_of_type_JavaLangObject)
      {
        localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_a_of_type_JavaUtilArrayList);
        ??? = new ArrayList();
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo1;
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo2;
        do
        {
          localObject5 = ((List)localObject5).iterator();
          Iterator localIterator;
          while (!localIterator.hasNext())
          {
            do
            {
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              localPtvTemplateInfo1 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject5).next();
            } while ((localPtvTemplateInfo1.platform != 0) && (localPtvTemplateInfo1.platform != 109));
            localIterator = localArrayList.iterator();
          }
          localPtvTemplateInfo2 = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
        } while (!localPtvTemplateInfo2.id.equals(localPtvTemplateInfo1.id));
        ((List)???).add(localPtvTemplateInfo2);
      }
      boolean bool;
      if (QLog.isDevelopLevel())
      {
        ??? = PtvTemplateManager.jdField_a_of_type_JavaLangString;
        int i = ((List)???).size();
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          break label421;
        }
        bool = true;
        QLog.d((String)???, 2, String.format("双人挂件加载 size[%s], onInitFinishSink[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_b_of_type_JavaUtilArrayList.addAll((Collection)???);
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          continue;
        }
        this.jdField_a_of_type_JavaLangRunnable.run();
        return;
        label421:
        bool = false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */