package com.tencent.open.appcommon.js;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;

public class AsyncMethodMap
{
  public static ArrayList a;
  public static HashMap a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilArrayList.add("getQueryDownloadAction");
    jdField_a_of_type_JavaUtilArrayList.add("checkUpdate");
    jdField_a_of_type_JavaUtilArrayList.add("picUpload");
    jdField_a_of_type_JavaUtilArrayList.add("gSetPackageScanSetting");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface." + paramString1 + "',{'guid':'" + paramString2 + "','r':'" + paramString3 + "','data':'" + paramString4 + "'});}void(0);";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\js\AsyncMethodMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */