package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class StructMsgItemTips
  extends AbsStructMsgTextElement
{
  public StructMsgItemTips()
  {
    this(null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StructMsgItemTips(String paramString)
  {
    super(paramString, "tips");
  }
  
  public TextView a(Context paramContext)
  {
    paramContext = super.a(paramContext);
    paramContext.setBackgroundResource(2130840531);
    paramContext.setPadding(20, 5, 20, 5);
    paramContext.setGravity(17);
    return paramContext;
  }
  
  public String a()
  {
    return "tips";
  }
  
  protected int c()
  {
    return 2131296362;
  }
  
  public int d()
  {
    return -1;
  }
  
  public int e()
  {
    return 28;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgItemTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */