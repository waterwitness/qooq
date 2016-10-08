package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class BubbleDiyText
  extends Entity
{
  public static final String TABLE_NAME = "bubble_diytext";
  public long mCreateTime;
  public String mText;
  public String mUinAndTextId;
  
  public BubbleDiyText()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BubbleDiyText(String paramString1, String paramString2, long paramLong)
  {
    this.mUinAndTextId = paramString1;
    this.mText = paramString2;
    this.mCreateTime = paramLong;
  }
  
  public static String makeKey(String paramString, int paramInt)
  {
    return String.valueOf(paramString) + "_" + String.valueOf(paramInt);
  }
  
  public String getTableName()
  {
    return "bubble_diytext";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleDiyText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */