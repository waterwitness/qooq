package com.tencent.device.datadef;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SDKDef
{
  public SDKDef()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1000000008: 
    case 1000000009: 
    default: 
      return "智能设备";
    case 1000000004: 
    case 1000000011: 
    case 1000000012: 
    case 1000000013: 
      return "vstar摄像头";
    case 1000000005: 
      return "全志摄像头";
    case 1000000006: 
      return "大华摄像头";
    case 1000000007: 
      return "康佳电视";
    }
    return "NXP摄像头";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\datadef\SDKDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */