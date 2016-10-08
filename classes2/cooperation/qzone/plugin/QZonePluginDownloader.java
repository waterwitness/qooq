package cooperation.qzone.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import yoa;
import yob;

public class QZonePluginDownloader
  implements Handler.Callback
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map jdField_a_of_type_JavaUtilMap;
  
  QZonePluginDownloader(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
  }
  
  private void a(yob paramyob)
  {
    PluginRecord localPluginRecord = yob.a(paramyob);
    Object localObject = yob.a(paramyob);
    yob.a(paramyob).e = 1;
    ((QZonePluginDownloader.OnPluginDownloadListner)localObject).a(localPluginRecord);
    localObject = QZonePluginUtils.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.g);
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "downloadPluginInner url:" + localPluginRecord.c + "     path:" + localObject);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.c, ((File)localObject).getAbsolutePath(), new yoa(this, paramyob));
  }
  
  private void b(yob paramyob)
  {
    PluginRecord localPluginRecord = yob.a(paramyob);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(localPluginRecord.c, new yoa(this, paramyob));
  }
  
  public void a(PluginRecord paramPluginRecord)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    yob localyob = new yob(null);
    yob.a(localyob, paramPluginRecord.g);
    yob.a(localyob, paramPluginRecord);
    localMessage.obj = paramPluginRecord;
  }
  
  public void a(PluginRecord paramPluginRecord, QZonePluginDownloader.OnPluginDownloadListner paramOnPluginDownloadListner)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    yob localyob = new yob(null);
    yob.a(localyob, paramPluginRecord.g);
    yob.a(localyob, paramPluginRecord);
    yob.a(localyob, paramOnPluginDownloadListner);
    localMessage.obj = localyob;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (yob)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(yob.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(yob.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      Object localObject = (yob)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(yob.a((yob)localObject)))
      {
        this.jdField_a_of_type_JavaUtilMap.remove(yob.a((yob)localObject));
        b((yob)localObject);
      }
      paramMessage = (yob)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(yob.a(paramMessage)))
      {
        this.jdField_a_of_type_JavaUtilMap.remove(yob.a(paramMessage));
        localObject = yob.a(paramMessage);
        if (localObject != null)
        {
          ((QZonePluginDownloader.OnPluginDownloadListner)localObject).b(yob.a(paramMessage));
          continue;
          paramMessage = (yob)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(yob.a(paramMessage)))
          {
            this.jdField_a_of_type_JavaUtilMap.remove(yob.a(paramMessage));
            localObject = yob.a(paramMessage);
            if (localObject != null)
            {
              ((QZonePluginDownloader.OnPluginDownloadListner)localObject).c(yob.a(paramMessage));
              continue;
              paramMessage = (yob)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(yob.a(paramMessage)))
              {
                this.jdField_a_of_type_JavaUtilMap.remove(yob.a(paramMessage));
                localObject = yob.a(paramMessage);
                if (localObject != null)
                {
                  yob.a(paramMessage).e = 2;
                  ((QZonePluginDownloader.OnPluginDownloadListner)localObject).d(yob.a(paramMessage));
                  continue;
                  paramMessage = (yob)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(yob.a(paramMessage)))
                  {
                    localObject = yob.a(paramMessage);
                    if (localObject != null) {
                      ((QZonePluginDownloader.OnPluginDownloadListner)localObject).e(yob.a(paramMessage));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZonePluginDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */