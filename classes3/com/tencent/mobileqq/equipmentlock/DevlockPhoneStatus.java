package com.tencent.mobileqq.equipmentlock;

import android.content.Context;
import android.text.format.Time;
import com.tencent.ims.devlock_mobile_phone.status;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import rli;

public class DevlockPhoneStatus
{
  public static int a = 0;
  private static DevlockPhoneStatus jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus;
  public static final String a = "guard_phone_status";
  public static int b = 0;
  public static final String b = "guard_phone_effect_time";
  public static int c = 0;
  public static final String c = "emergency_phone_status";
  public static int d = 0;
  public static final String d = "emergency_phone_num";
  public static int e = 0;
  public static final String e = "emergency_phone_country_code";
  public static int f = 0;
  private static final String f = "DevlockPhoneStatus";
  public static int g;
  public static int h;
  public static int i = 2;
  public static int j = 3;
  private long jdField_a_of_type_Long;
  private String g;
  private String h;
  private int k = -1;
  private int l = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = -1;
    c = 1;
    d = 2;
    e = 3;
    f = -1;
    jdField_h_of_type_Int = 1;
  }
  
  public static DevlockPhoneStatus a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus == null) {
      jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus = new DevlockPhoneStatus();
    }
    return jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockPhoneStatus", 2, "pre:" + this.k + " now:" + paramInt);
    }
    this.k = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext, String paramString)
  {
    rli localrli = new rli(this);
    String str2 = paramContext.getString(2131370772);
    String str1 = paramContext.getString(2131370776);
    long l1 = this.jdField_a_of_type_Long * 1000L;
    if (l1 > 0L)
    {
      localObject = new Time();
      ((Time)localObject).set(l1);
    }
    for (Object localObject = String.format(paramContext.getString(2131370774), new Object[] { Integer.valueOf(((Time)localObject).year), Integer.valueOf(((Time)localObject).month + 1), Integer.valueOf(((Time)localObject).monthDay), Integer.valueOf(((Time)localObject).hour), Integer.valueOf(((Time)localObject).minute) });; localObject = paramContext.getString(2131370775))
    {
      paramContext = DialogUtil.a(paramContext, 230, str2, String.format(paramContext.getString(2131370773), new Object[] { paramString, localObject }), null, localrli);
      if (paramContext != null)
      {
        paramContext.setNegativeButton(str1, localrli);
        paramContext.show();
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.k = jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = 0L;
    this.l = f;
    this.g = null;
    this.jdField_h_of_type_JavaLangString = null;
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockPhoneStatus", 2, "info is null");
      }
    }
    for (;;)
    {
      return;
      try
      {
        devlock_mobile_phone.status localstatus = new devlock_mobile_phone.status();
        localstatus.mergeFrom(paramArrayOfByte);
        if (localstatus.u32_mb_mobile_state.has()) {
          this.k = localstatus.u32_mb_mobile_state.get();
        }
        if (localstatus.u32_audit_time.has()) {
          this.jdField_a_of_type_Long = localstatus.u32_audit_time.get();
        }
        if (localstatus.u32_bak_mobile_state.has()) {
          this.l = localstatus.u32_bak_mobile_state.get();
        }
        if (localstatus.str_bak_country_code.has()) {
          this.g = localstatus.str_bak_country_code.get();
        }
        if (localstatus.str_bak_mobile.has())
        {
          this.jdField_h_of_type_JavaLangString = localstatus.str_bak_mobile.get();
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevlockPhoneStatus", 2, "exception occurs");
        }
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public int b()
  {
    return this.l;
  }
  
  public String b()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\equipmentlock\DevlockPhoneStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */