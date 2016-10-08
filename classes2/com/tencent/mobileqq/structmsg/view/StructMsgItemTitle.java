package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemTitle
  extends AbsStructMsgTextElement
{
  public boolean d;
  public boolean e;
  public int i;
  
  public StructMsgItemTitle()
  {
    this(null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StructMsgItemTitle(String paramString)
  {
    super(paramString, "title");
  }
  
  protected Class a()
  {
    if (this.e) {
      return StructMsgItemTitle.TitleTextView.class;
    }
    return super.a();
  }
  
  public String a()
  {
    return "Title";
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.d = paramBoolean;
    this.i = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  protected int c()
  {
    return 2131296360;
  }
  
  public int d()
  {
    if ((this.d) && (this.i != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int e()
  {
    return 28;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */