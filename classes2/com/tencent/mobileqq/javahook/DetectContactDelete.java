package com.tencent.mobileqq.javahook;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import sww;

public class DetectContactDelete
{
  static HookMethodCallback a = new sww();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(ContentResolver.class, "delete", new Object[] { Uri.class, String.class, String[].class, a });
      JavaHookBridge.findAndHookMethod(ContentProviderOperation.class, "newDelete", new Object[] { Uri.class, a });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\DetectContactDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */