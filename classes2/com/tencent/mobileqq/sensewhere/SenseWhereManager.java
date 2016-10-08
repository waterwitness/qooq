package com.tencent.mobileqq.sensewhere;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import uon;
import uoo;
import uop;
import uoq;

public class SenseWhereManager
  implements Manager
{
  private static int jdField_a_of_type_Int = 10;
  public static final String a = "sense_where";
  private static int jdField_b_of_type_Int = 10;
  public static final String b = "sw_upload_time_info";
  private static int jdField_c_of_type_Int = 30;
  private static final String jdField_c_of_type_JavaLangString = "SenseWhere";
  private long jdField_a_of_type_Long = -1L;
  private INetworkApi jdField_a_of_type_ComTencentMapSwlocationApiINetworkApi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new uon(this);
  private uop jdField_a_of_type_Uop;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long = -1L;
  private Runnable jdField_b_of_type_JavaLangRunnable = new uoo(this);
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long = -1L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SenseWhereManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Uop = new uop(this, null);
    this.jdField_a_of_type_ComTencentMapSwlocationApiINetworkApi = new uoq(this, null);
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SenseWhereConfig.name());
    if (QLog.isColorLevel()) {
      QLog.i("SenseWhere", 2, "getDpc value is: " + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length != 3)) {}
    }
    try
    {
      jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
      jdField_b_of_type_Int = Integer.valueOf(localObject[1]).intValue();
      jdField_c_of_type_Int = Integer.valueOf(localObject[2]).intValue();
      if ((l - this.jdField_a_of_type_Long > 86400000L) || (l - this.jdField_a_of_type_Long < 0L))
      {
        localObject = new StringBuilder();
        this.jdField_a_of_type_Long = l;
        ((StringBuilder)localObject).append(l).append("#").append(l).append("#").append(0);
        BaseApplicationImpl.a().getSharedPreferences("sense_where", 0).edit().putString("sw_upload_time_info", ((StringBuilder)localObject).toString()).commit();
        return true;
      }
      if ((this.jdField_c_of_type_Long + 1L > jdField_a_of_type_Int) || (l - this.jdField_b_of_type_Long < jdField_b_of_type_Int * 60 * 1000L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SenseWhere", 2, "not satify.");
        }
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long).append("#").append(l).append("#").append(this.jdField_c_of_type_Long + 1L);
      BaseApplicationImpl.a().getSharedPreferences("sense_where", 0).edit().putString("sw_upload_time_info", ((StringBuilder)localObject).toString()).commit();
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SenseWhere", 4, "init. start");
    }
    Object localObject;
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject = BaseApplicationImpl.a().getSharedPreferences("sense_where", 0).getString("sw_upload_time_info", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("#");
        if ((localObject == null) || (localObject.length != 3)) {}
      }
    }
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(localObject[0]).longValue();
      this.jdField_b_of_type_Long = Long.valueOf(localObject[1]).longValue();
      this.jdField_c_of_type_Long = Integer.valueOf(localObject[2]).intValue();
      this.jdField_b_of_type_Boolean = true;
      SwEngine.creatLocationEngine(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMapSwlocationApiINetworkApi);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void a(byte[] arg1)
  {
    this.jdField_a_of_type_ArrayOfByte = ???;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SenseWhere", 4, "startLocation");
    }
    if (!a())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("SenseWhere", 4, "startLocation not satify.");
      }
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Long += 1L;
    SwEngine.setQQ(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
    SwEngine.startContinousLocationUpdate(new Handler(ThreadManager.b()), 9000, 5000, this.jdField_a_of_type_Uop, null);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SenseWhere", 4, "stoplocation");
    }
    SwEngine.stopContinousLocationUpdate();
    this.jdField_a_of_type_Boolean = false;
    a(null);
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SenseWhere", 4, "destroy");
    }
    c();
    SwEngine.onDestroy();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.b().post(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void onDestroy()
  {
    ThreadManager.b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    try
    {
      d();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\sensewhere\SenseWhereManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */