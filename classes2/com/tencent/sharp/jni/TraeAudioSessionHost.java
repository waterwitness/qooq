package com.tencent.sharp.jni;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public TraeAudioSessionHost()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  }
  
  public TraeAudioSessionHost.SessionInfo a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    TraeAudioSessionHost.SessionInfo localSessionInfo;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localSessionInfo = (TraeAudioSessionHost.SessionInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localSessionInfo.a != paramLong) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return localSessionInfo;
      i += 1;
      break;
      localSessionInfo = null;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((TraeAudioSessionHost.SessionInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a == paramLong) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return;
      }
      i += 1;
    }
  }
  
  public void a(long paramLong, Context paramContext)
  {
    if (a(paramLong) != null) {
      return;
    }
    paramContext = new TraeAudioSessionHost.SessionInfo(this);
    paramContext.a = paramLong;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\sharp\jni\TraeAudioSessionHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */