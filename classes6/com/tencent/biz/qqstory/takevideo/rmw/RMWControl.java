package com.tencent.biz.qqstory.takevideo.rmw;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iyo;
import iyp;
import iyq;
import java.util.HashSet;
import java.util.Set;

public class RMWControl
{
  private static final String jdField_a_of_type_JavaLangString = "RMWControl";
  private int jdField_a_of_type_Int;
  private RMWMessengerObservable jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWMessengerObservable;
  private RMWPopupHelper jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper;
  private Set jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private RMWMessengerObservable b;
  private RMWMessengerObservable c;
  private RMWMessengerObservable d;
  
  public RMWControl(Context paramContext, WindowManager paramWindowManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWMessengerObservable = new RMWMessengerObservable();
    this.b = new RMWMessengerObservable();
    this.c = new RMWMessengerObservable();
    this.d = new RMWMessengerObservable();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper = new RMWPopupHelper(paramContext, paramWindowManager);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.a(new iyo(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.a(new iyp(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.a(new iyq(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.a();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    int i = 1;
    if (paramInt != this.jdField_a_of_type_Int) {}
    switch (paramInt)
    {
    default: 
      RMWLog.b("RMWControl", "ignore illegal visibility " + paramInt);
      return;
    case 0: 
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.e();
      paramInt = i;
    }
    while (paramInt != 0)
    {
      RMWLog.a("RMWControl", "service.send : visibility change " + this.jdField_a_of_type_Int);
      this.d.c();
      this.d.a(Message.obtain(null, 10, this.jdField_a_of_type_Int, 0));
      return;
      if (this.jdField_a_of_type_JavaUtilSet.size() <= 0)
      {
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.d();
        paramInt = i;
        continue;
        this.jdField_a_of_type_JavaUtilSet.clear();
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.d();
        paramInt = i;
      }
      else
      {
        paramInt = 0;
      }
    }
  }
  
  public void a(IBinder paramIBinder)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramIBinder);
  }
  
  public void a(Messenger paramMessenger)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWMessengerObservable.a(new RMWMessengerObserver(paramMessenger));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.b();
  }
  
  public void b(IBinder paramIBinder)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramIBinder);
  }
  
  public void b(Messenger paramMessenger)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWMessengerObservable.b(new RMWMessengerObserver(paramMessenger));
  }
  
  public void c()
  {
    RMWLog.b("RMWControl", "service.tearDown");
    if (this.jdField_a_of_type_Int != 8)
    {
      this.jdField_a_of_type_Int = 8;
      RMWLog.b("RMWControl", "service.send : visibility change " + this.jdField_a_of_type_Int);
      this.d.c();
      this.d.a(Message.obtain(null, 10, this.jdField_a_of_type_Int, 0));
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWMessengerObservable.b();
    this.b.b();
    this.d.b();
    this.c.b();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWPopupHelper.c();
  }
  
  public void c(Messenger paramMessenger)
  {
    this.b.a(new RMWMessengerObserver(paramMessenger));
  }
  
  public void d(Messenger paramMessenger)
  {
    this.b.b(new RMWMessengerObserver(paramMessenger));
  }
  
  public void e(Messenger paramMessenger)
  {
    this.c.a(new RMWMessengerObserver(paramMessenger));
  }
  
  public void f(Messenger paramMessenger)
  {
    this.c.b(new RMWMessengerObserver(paramMessenger));
  }
  
  public void g(Messenger paramMessenger)
  {
    this.d.a(new RMWMessengerObserver(paramMessenger));
  }
  
  public void h(Messenger paramMessenger)
  {
    this.d.b(new RMWMessengerObserver(paramMessenger));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */