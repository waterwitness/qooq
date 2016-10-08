package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Set;

public class ForwardHyperTextOption
  extends ForwardPluginShareStructMsgOption
{
  public ForwardHyperTextOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (i()) {
      this.a.add(d);
    }
    if (j()) {
      this.a.add(c);
    }
    if (k()) {
      this.a.add(b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardHyperTextOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */