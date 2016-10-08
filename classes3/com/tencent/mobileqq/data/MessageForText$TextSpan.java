package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForText$TextSpan
{
  public int end;
  public int index;
  public int start;
  public int type;
  
  public MessageForText$TextSpan(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = paramInt1;
    this.index = paramInt2;
    this.start = paramInt3;
    this.end = paramInt4;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForText$TextSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */