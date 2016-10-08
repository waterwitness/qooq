package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iyr;

public class RMWMessengerObserver
{
  public final Messenger a;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public RMWMessengerObserver(Messenger paramMessenger)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_AndroidOsMessenger = paramMessenger;
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.getBinder().linkToDeath(new iyr(this), 0);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (RemoteException paramMessenger)
    {
      RMWLog.c(this.jdField_a_of_type_JavaLangString, "linkToDeath failed : " + paramMessenger);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public boolean a(RMWMessengerObservable paramRMWMessengerObservable, Message paramMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramMessage);
      bool = true;
      return bool;
    }
    catch (RemoteException paramRMWMessengerObservable)
    {
      RMWLog.c(this.jdField_a_of_type_JavaLangString, "notify failed : " + paramRMWMessengerObservable);
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (RMWMessengerObserver)paramObject;
    return this.jdField_a_of_type_AndroidOsMessenger.equals(((RMWMessengerObserver)paramObject).jdField_a_of_type_AndroidOsMessenger);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_AndroidOsMessenger.hashCode();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWMessengerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */