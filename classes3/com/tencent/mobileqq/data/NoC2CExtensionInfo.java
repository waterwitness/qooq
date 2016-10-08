package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;

public class NoC2CExtensionInfo
  extends Entity
{
  public static final int TYPE_EXT_C2C = 0;
  public static final int TYPE_EXT_COUNT = 3;
  public static final int TYPE_EXT_DISCUSSION = 2;
  public static final int TYPE_EXT_GROUP = 1;
  @defaultValue(a=-1)
  public int audioPanelType;
  public int chatInputType;
  @notColumn
  public boolean isDataChanged;
  public int pttChangeVoiceType;
  public int showC2CPanel;
  public int type;
  public String uin;
  
  public NoC2CExtensionInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.chatInputType = 0;
    this.showC2CPanel = 1;
    this.pttChangeVoiceType = 0;
    this.audioPanelType = -1;
  }
  
  public static String getNoC2Ckey(int paramInt, String paramString)
  {
    return paramInt + "_" + paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\NoC2CExtensionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */