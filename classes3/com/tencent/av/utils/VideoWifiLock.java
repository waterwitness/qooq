package com.tencent.av.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VideoWifiLock
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  WifiManager.WifiLock jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock;
  String jdField_a_of_type_JavaLangString;
  
  public VideoWifiLock(Context paramContext, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (b())
    {
      this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock.release();
      this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock = null;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock == null) {
      this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock = ((WifiManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("wifi")).createWifiLock(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock != null)
    {
      if (!this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock.isHeld()) {
        this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock.acquire();
      }
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock != null) && (this.jdField_a_of_type_AndroidNetWifiWifiManager$WifiLock.isHeld());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\VideoWifiLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */