package com.tencent.mobileqq.activity.messagesearch;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HistoryItem
{
  public String a;
  
  public HistoryItem(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keyword = ").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\messagesearch\HistoryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */