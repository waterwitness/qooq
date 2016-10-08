package com.tencent.util;

import android.os.Debug;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.IOException;

public class ImageTestUtil
{
  private static boolean jdField_a_of_type_Boolean;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "35872667", "354653668", "270749863", "279242625", "1849510872" };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      Object localObject = jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].equals(paramString))
        {
          localObject = AppConstants.bo + "dump_";
          try
          {
            Debug.dumpHprofData((String)localObject + paramString + System.currentTimeMillis());
            jdField_a_of_type_Boolean = true;
            return;
          }
          catch (IOException paramString)
          {
            return;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\ImageTestUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */