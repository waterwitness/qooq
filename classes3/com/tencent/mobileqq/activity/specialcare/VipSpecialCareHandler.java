package com.tencent.mobileqq.activity.specialcare;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.web.IPCConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pmq;

public class VipSpecialCareHandler
  extends QvipSpecialCareObserver
  implements IPCConstants
{
  public static final String a = "specialcare_already_set";
  private volatile int D;
  private final int E;
  private final int F;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Bundle b;
  
  public VipSpecialCareHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.a("special-timer", 0);
    this.E = 1;
    this.F = 90000;
    ThreadManager.a(new pmq(this), 8, null, true);
  }
  
  private final void a(int paramInt)
  {
    int i = this.D - 1;
    this.D = i;
    if (i != 0)
    {
      a("-->warning:special care set,uncorrect state,seq=" + this.D);
      this.D = 0;
    }
    try
    {
      Bundle localBundle = this.b;
      i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      localBundle.putInt("error", i);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", this.b);
      a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareHandler", 2, paramString);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Bundle paramBundle) {}
  
  public final void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle1;
    this.b = paramBundle2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (this.D != 0)
    {
      a("-->current request is ongoing,can't do request yet");
      paramBundle2.putInt("error", -1);
      paramBundle1.putBundle("response", paramBundle2);
      a(paramBundle1);
      return;
    }
    this.D += 1;
    a("-->do request,seq=" + this.D);
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        a(paramBundle1, paramBundle2);
        if ((!"sepcial_care_delete_ring".equals(paramString)) && (!"special_care_set_ring".equals(paramString))) {
          break;
        }
        paramBundle1 = paramBundle1.getBundle("request");
        int i = paramBundle1.getInt("id", 1);
        paramBundle2 = paramBundle1.getString("uin");
        paramBundle1 = paramBundle2;
        if (paramBundle2 == null) {
          paramBundle1 = "";
        }
        paramBundle2 = new ArrayList();
        paramBundle2.add(paramBundle1);
        localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(i));
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 90000L);
        }
        if (!"special_care_set_ring".equals(paramString)) {
          break label288;
        }
        if (i == 1)
        {
          QvipSpecialCareManager.a(paramBundle2, 2, localArrayList, paramQQAppInterface);
          paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
          paramString = "specialcare_already_set" + paramBundle1;
          paramQQAppInterface.edit().putBoolean(paramString, true).commit();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        this.D = 0;
        return;
      }
      QvipSpecialCareManager.a(paramBundle2, 3, localArrayList, paramQQAppInterface);
    }
    label288:
    QvipSpecialCareManager.a(paramBundle2, 4, localArrayList, paramQQAppInterface);
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null) {
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      a(0);
      return;
      a("-->method_type_open_switch");
      continue;
      a("-->method_type_set_sound");
      continue;
      a("-->method_type_delete_sound");
    }
  }
  
  public void b(Object paramObject)
  {
    int i = -1;
    if (paramObject != null)
    {
      i = ((Integer)paramObject).intValue();
      if (i != 10010) {
        break label48;
      }
      a("-->error:set quota limit");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      a(i);
      return;
      label48:
      a("-->error:" + i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\specialcare\VipSpecialCareHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */