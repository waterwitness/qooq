package com.tencent.biz.qqstory.takevideo.rmw;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.view.WindowManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iys;
import iyt;

public class RMWService
  extends Service
{
  private static RMWService jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService;
  private static final String jdField_a_of_type_JavaLangString = "RMWService";
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private RMWControl jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWControl;
  
  public RMWService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(new iys(this));
  }
  
  public static RMWService a()
  {
    return jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService;
  }
  
  public RMWControl a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWControl;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    RMWLog.c("RMWService", "ON-BIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    RMWLog.c("RMWService", "ON-CREATE : " + System.identityHashCode(this));
    jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService = this;
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWControl == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWControl = new RMWControl(this, this.jdField_a_of_type_AndroidViewWindowManager);
    }
    new iyt(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    RMWLog.c("RMWService", "ON-DESTROY : " + System.identityHashCode(this));
    jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWControl.c();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    RMWLog.b("RMWService", "onStartCommand : " + paramIntent);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    RMWLog.c("RMWService", "ON-UNBIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return super.onUnbind(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */