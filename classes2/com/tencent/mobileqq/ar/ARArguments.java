package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class ARArguments
  implements Serializable
{
  public boolean alreadyIsTorchbearer;
  
  public ARArguments(boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.alreadyIsTorchbearer = paramBoolean;
  }
  
  public String toString()
  {
    return "ARArguments{alreadyIsTorchbearer=" + this.alreadyIsTorchbearer + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARArguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */