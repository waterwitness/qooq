package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PstnSwitchConfig
{
  public static final int a = 1;
  public static final String a = "key_pstn_c2c_aio_flag";
  public static final int b = 0;
  public static final String b = "key_pstn_c2c_profile_card_flag";
  public static final String c = "key_pstn_c2c_ip_call_flag";
  public static final String d = "key_pstn_multi_aio_flag";
  public static final String e = "key_pstn_auto_trans_time";
  public static final String f = "key_pstn_miss_delay_time";
  public static final String g = "key_pstn_miss_show_time";
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public PstnSwitchConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PstnSwitchConfig : ");
    localStringBuilder.append("pstn_c2c_aio_flag | ").append(this.c).append(",pstn_c2c_profile_card_flag | ").append(this.d).append(",pstn_c2c_ip_call_flag | ").append(this.e).append(",pstn_multi_aio_flag | ").append(this.f).append(",pstn_multi_auto_trans_time | ").append(this.g).append(",pstn_miss_delay_time | ").append(this.h).append(",pstn_miss_show_time | ").append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\PstnSwitchConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */