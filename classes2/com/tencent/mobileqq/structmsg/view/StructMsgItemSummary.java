package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemSummary
  extends AbsStructMsgTextElement
{
  public boolean d;
  public int i;
  public int j = 3;
  
  public StructMsgItemSummary()
  {
    this(null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StructMsgItemSummary(String paramString)
  {
    super(paramString, "summary");
  }
  
  public String a()
  {
    return "Summary";
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.d = paramBoolean;
    this.i = paramInt;
  }
  
  public int b()
  {
    return this.j;
  }
  
  public int c()
  {
    return 2131296361;
  }
  
  public int d()
  {
    if ((this.d) && (this.i != 0)) {
      return -1;
    }
    return -8355712;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int e()
  {
    return 28;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */