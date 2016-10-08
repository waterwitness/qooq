package com.tencent.mobileqq.pic.compress;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CompressOperator$Test
{
  public static final String a = "Test_";
  
  public CompressOperator$Test()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      paramBundle = CompressOperator.a(paramBundle);
    } while (paramBundle == null);
    CompressOperator.b(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\compress\CompressOperator$Test.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */