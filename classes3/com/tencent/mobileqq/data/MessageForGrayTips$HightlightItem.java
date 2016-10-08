package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForGrayTips$HightlightItem
{
  public int actionType;
  public int color;
  public int end;
  public String icon;
  public String iconAlt;
  public String mMsgActionData;
  public String mMsg_A_ActionData;
  public boolean needUpdateNick;
  public int start;
  public int textColor;
  public long uin;
  
  MessageForGrayTips$HightlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.start = paramInt1;
    this.end = paramInt2;
    this.uin = paramLong;
    if (paramInt3 != 0) {}
    for (bool = true;; bool = false)
    {
      this.needUpdateNick = bool;
      this.actionType = paramInt4;
      this.mMsgActionData = paramString1;
      this.mMsg_A_ActionData = paramString2;
      return;
    }
  }
  
  public MessageForGrayTips$HightlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2);
    this.icon = paramString3;
    this.iconAlt = paramString4;
    this.textColor = paramInt5;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForGrayTips$HightlightItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */