package com.tencent.mobileqq.jump;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class JumpOptionBuilder
{
  public JumpOptionBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static JumpBaseOption a(Intent paramIntent)
  {
    return null;
  }
  
  public static JumpBaseOption a(Intent paramIntent, Context paramContext)
  {
    JumpBaseOption localJumpBaseOption = a(paramIntent);
    if (localJumpBaseOption != null) {
      paramContext = localJumpBaseOption;
    }
    do
    {
      return paramContext;
      localJumpBaseOption = b(paramIntent, paramContext);
      paramContext = localJumpBaseOption;
    } while (localJumpBaseOption != null);
    return b(paramIntent);
  }
  
  private static JumpBaseOption b(Intent paramIntent)
  {
    return null;
  }
  
  private static JumpBaseOption b(Intent paramIntent, Context paramContext)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jump\JumpOptionBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */