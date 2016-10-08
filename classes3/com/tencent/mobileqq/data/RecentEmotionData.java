package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class RecentEmotionData
  extends Entity
{
  public static final int TYPE_CUSTOM_EMO = 3;
  public static final int TYPE_EMOJI_EMO = 4;
  public static final int TYPE_MARKET_FACE = 5;
  public static final int TYPE_SMALL_EMO = 6;
  public static final int TYPE_SYS_EMO = 0;
  public int emoId;
  public int emoIndex;
  public String emoPath;
  public int type;
  public String uin;
  
  public RecentEmotionData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RecentEmotionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */