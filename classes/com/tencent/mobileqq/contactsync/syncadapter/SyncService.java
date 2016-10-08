package com.tencent.mobileqq.contactsync.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public class SyncService
  extends Service
{
  private static SyncAdapter jdField_a_of_type_ComTencentMobileqqContactsyncSyncadapterSyncAdapter;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "ContactSync.SyncService";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return jdField_a_of_type_ComTencentMobileqqContactsyncSyncadapterSyncAdapter.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    ??? = (MobileQQ)super.getApplicationContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("k_start_mode", 2);
    ((MobileQQ)???).onActivityCreate(this, localIntent);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqContactsyncSyncadapterSyncAdapter == null) {
        jdField_a_of_type_ComTencentMobileqqContactsyncSyncadapterSyncAdapter = new SyncAdapter(getApplicationContext(), true);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\contactsync\syncadapter\SyncService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */