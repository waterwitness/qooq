package com.tencent.open.agent.datamodel;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QZonePortraitData
{
  public static final short a = 100;
  
  public QZonePortraitData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return String.format("http://q.qlogo.cn/qqapp/%s/%s/%d", new Object[] { paramString1, paramString2, Short.valueOf(100) });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\datamodel\QZonePortraitData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */