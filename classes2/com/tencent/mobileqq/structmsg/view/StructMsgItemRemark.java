package com.tencent.mobileqq.structmsg.view;

import android.graphics.Color;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemRemark
  extends AbsStructMsgTextElement
{
  public StructMsgItemRemark()
  {
    this(null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StructMsgItemRemark(String paramString)
  {
    super(paramString, "remark");
  }
  
  public String a()
  {
    return "Remark";
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2131296366;
  }
  
  public int d()
  {
    return Color.rgb(128, 128, 128);
  }
  
  public int e()
  {
    return 24;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemRemark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */