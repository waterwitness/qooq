import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.emoticon.EPRecommendTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class rjc
  implements Runnable
{
  public rjc(EPRecommendTask paramEPRecommendTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(EPRecommendTask.a(), 2, "url:" + this.a.jdField_a_of_type_JavaLangString + ",type:" + this.a.b);
    }
    try
    {
      if (this.a.b == null) {
        return;
      }
      localObject1 = new File(AppConstants.bU + "tab" + this.a.b + ".tmp");
      if ((this.a.b == null) || (!"3".equals(this.a.b))) {
        break label442;
      }
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir() + "/magic_promotion_" + EarlyDownloadManager.a() + ".json");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        HashMap localHashMap;
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, localException.getMessage());
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;) {}
    }
    localObject2 = new ArrayList();
    localHashMap = new HashMap();
    ((List)localObject2).add(this.a.jdField_a_of_type_JavaLangString);
    localHashMap.put(this.a.jdField_a_of_type_JavaLangString, localObject1);
    localObject2 = new DownloadTask((List)localObject2, localHashMap, this.a.b + "_recomdTask");
    ((DownloadTask)localObject2).h = true;
    if (this.a.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      i = DownloaderFactory.a((DownloadTask)localObject2, (AppRuntime)this.a.jdField_a_of_type_MqqUtilWeakReference.get());
      if (i != 0) {}
    }
    else
    {
      try
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (localObject1 == null) {
          return;
        }
        if ((this.a.b != null) && ("3".equals(this.a.b)))
        {
          this.a.jdField_a_of_type_MqqUtilWeakReference = null;
          this.a.a((byte[])localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        long l2;
        for (;;) {}
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;) {}
      }
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        QLog.d(EPRecommendTask.a(), 2, "costTime:" + (l2 - l1) + ",type:" + this.a.b);
        return;
      }
    }
    label442:
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */