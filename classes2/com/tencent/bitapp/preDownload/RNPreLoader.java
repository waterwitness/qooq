package com.tencent.bitapp.preDownload;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class RNPreLoader
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "RNPreLoader";
  private static String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = "";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libbitmaps.so", "libfb.so", "libfbjni.so", "libfolly_json.so", "libgifimage.so", "libglog.so", "libgnustl_shared.so", "libicu_common.so", "libimagepipeline.so", "libjsc.so", "libmemchunk.so", "libreactnativejni.so" };
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(b))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label60;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (TextUtils.isEmpty(b)) {
        b = ((File)localObject).getParent() + "/txlib/";
      }
    }
    for (;;)
    {
      return b;
      label60:
      if (QLog.isColorLevel()) {
        QLog.d("RNPreLoader", 2, "getSoLibPath but context is null");
      }
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      a();
      if ((!a()) && (!TextUtils.isEmpty(b))) {
        FileUtils.a(paramString, b, false);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    a();
    File localFile1 = new File(b);
    int j = jdField_a_of_type_ArrayOfJavaLangString.length;
    int i = 0;
    while (i < j)
    {
      File localFile2 = new File(localFile1, jdField_a_of_type_ArrayOfJavaLangString[i]);
      if ((!localFile2.exists()) || (!localFile2.isFile())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\preDownload\RNPreLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */