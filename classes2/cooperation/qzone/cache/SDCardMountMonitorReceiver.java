package cooperation.qzone.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SDCardMountMonitorReceiver
  extends BroadcastReceiver
{
  private static SDCardMountMonitorReceiver jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  private SDCardMountMonitorReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static SDCardMountMonitorReceiver a()
  {
    if (jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver == null) {
      jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver = new SDCardMountMonitorReceiver();
    }
    return jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver;
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      SDCardMountMonitorReceiver.SDCardMountStateListener[] arrayOfSDCardMountStateListener = new SDCardMountMonitorReceiver.SDCardMountStateListener[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfSDCardMountStateListener);
      if (arrayOfSDCardMountStateListener != null)
      {
        int j = arrayOfSDCardMountStateListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfSDCardMountStateListener[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  private boolean b()
  {
    if (!this.d) {
      if ((!Environment.getExternalStorageDirectory().canWrite()) || (!CacheManager.c(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.d = true;
      return this.c;
    }
  }
  
  private boolean c()
  {
    if (!this.e)
    {
      this.b = "mounted".equals(Environment.getExternalStorageState());
      this.e = true;
    }
    return this.b;
  }
  
  public void a()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
      localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
      localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addDataScheme("file");
      BaseApplicationImpl.getContext().registerReceiver(this, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(SDCardMountMonitorReceiver.SDCardMountStateListener paramSDCardMountStateListener)
  {
    if (paramSDCardMountStateListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramSDCardMountStateListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramSDCardMountStateListener);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return (c()) && (b());
  }
  
  public void b()
  {
    if ((jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver != null) && (jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver.jdField_a_of_type_Boolean == true))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver);
      jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b(SDCardMountMonitorReceiver.SDCardMountStateListener paramSDCardMountStateListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramSDCardMountStateListener);
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.b = "mounted".equals(Environment.getExternalStorageState());
    if (this.b) {
      if ((!Environment.getExternalStorageDirectory().canWrite()) || (!CacheManager.c(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.d = true;
      this.e = true;
      CacheManager.a();
      a(this.b);
      QLog.i(CacheManager.a, 1, "SDCardMountMonitorReceiver onReceive mIsSDCardMount:" + this.b + ",canWrite" + this.c);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\cache\SDCardMountMonitorReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */