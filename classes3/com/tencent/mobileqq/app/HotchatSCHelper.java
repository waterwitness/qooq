package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import pyy;

public class HotchatSCHelper
  implements Handler.Callback, HotchatSCMng.HCSCObserver
{
  static final int jdField_a_of_type_Int = 0;
  static final long jdField_a_of_type_Long = 60000L;
  static final int b = 2;
  public Handler a;
  HotchatSCHelper.OnShowNoteListener jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper$OnShowNoteListener;
  public HotchatSCMng a;
  public QQAppInterface a;
  public String a;
  public boolean a;
  public long b;
  public boolean b;
  
  public HotchatSCHelper(QQAppInterface paramQQAppInterface, HotchatSCHelper.OnShowNoteListener paramOnShowNoteListener, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng = ((HotchatSCMng)paramQQAppInterface.getManager(122));
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper$OnShowNoteListener = paramOnShowNoteListener;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "HotchatSCHelper", new Object[] { paramString, this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper$OnShowNoteListener });
    }
  }
  
  public static long a()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, new Object[] { "getCurTime", Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(Math.abs(l2 - l1)) });
    }
    return l1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.b(this);
    if (HotchatSCMng.jdField_a_of_type_Boolean) {
      NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "stopCheck", new Object[0]);
    }
  }
  
  public void a(long paramLong)
  {
    if (HotchatSCMng.jdField_a_of_type_Boolean) {
      NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "startCheckDelay", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.b) });
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper$OnShowNoteListener = null;
    if (HotchatSCMng.jdField_a_of_type_Boolean) {
      NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "destroy", new Object[0]);
    }
  }
  
  public void b(long paramLong)
  {
    if (HotchatSCMng.jdField_a_of_type_Boolean) {
      NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "startCheck", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.b) });
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.b)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramLong);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.a(this);
      return;
      ThreadManager.a(new pyy(this, paramLong, System.currentTimeMillis()), 8, null, true);
    }
  }
  
  public void c()
  {
    if (HotchatSCMng.jdField_a_of_type_Boolean) {
      NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "onConfigUpdate", new Object[0]);
    }
    b(500L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    long l2;
    if (paramMessage.what == 0)
    {
      l2 = a();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.a(this.jdField_a_of_type_JavaLangString, 0, l2);
      if (HotchatSCMng.jdField_a_of_type_Boolean) {
        NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "MSG_GET_NOTE_TOSHOW", new Object[] { "cur", paramMessage });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper$OnShowNoteListener != null) {
        if (paramMessage != null)
        {
          paramMessage.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper$OnShowNoteListener.a(paramMessage);
          label88:
          if (paramMessage == null) {
            break label281;
          }
        }
      }
    }
    label281:
    for (long l1 = paramMessage.b - l2;; l1 = 0L)
    {
      if (l1 > 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1 + 100L);
        return true;
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper$OnShowNoteListener.a(null);
        break label88;
        if (!HotchatSCMng.jdField_a_of_type_Boolean) {
          break label88;
        }
        NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "MSG_GET_NOTE_TOSHOW", new Object[] { "listener is null" });
        break label88;
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.a(this.jdField_a_of_type_JavaLangString, 2, l2);
      if (HotchatSCMng.jdField_a_of_type_Boolean) {
        NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "MSG_GET_NOTE_TOSHOW", new Object[] { "next", paramMessage });
      }
      if (paramMessage != null)
      {
        l1 = Math.max(60000L, paramMessage.jdField_a_of_type_Long - l2);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      if (!HotchatSCMng.jdField_a_of_type_Boolean) {
        break;
      }
      NearbyUtils.a(HotchatSCMng.jdField_a_of_type_JavaLangString, "MSG_GET_NOTE_TOSHOW", new Object[] { "stop check" });
      return true;
      if (paramMessage.what != 2) {
        break;
      }
      b(100L);
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotchatSCHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */