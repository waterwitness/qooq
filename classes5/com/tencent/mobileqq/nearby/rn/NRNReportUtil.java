package com.tencent.mobileqq.nearby.rn;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;
import tph;
import tpi;

public class NRNReportUtil
{
  static final int jdField_a_of_type_Int = 0;
  static final String jdField_a_of_type_JavaLangString = "NAReport";
  public static boolean a = true;
  static final int jdField_b_of_type_Int = 0;
  static final String jdField_b_of_type_JavaLangString = "actNAOpenCost";
  static final int jdField_c_of_type_Int = 1;
  static final String jdField_c_of_type_JavaLangString = "actNALoadSo";
  static final int jdField_d_of_type_Int = 2;
  static final String jdField_d_of_type_JavaLangString = "actNALoadBundle";
  static final int jdField_e_of_type_Int = 3;
  static final String jdField_e_of_type_JavaLangString = "actNAUseRN";
  static final int jdField_f_of_type_Int = 4;
  static final String jdField_f_of_type_JavaLangString = "actNAAskUser";
  static final int jdField_g_of_type_Int = 5;
  static final String jdField_g_of_type_JavaLangString = "actNAUserChooseLoadSo";
  static final int h = 6;
  static final int i = 7;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    ThreadManager.a(new tpi(paramString, paramBoolean), 2, null, false);
  }
  
  public static void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (NearbyUtils.a()) {
      NearbyUtils.a("NAReport", "reportRN", new Object[] { Integer.valueOf(paramList.size()) });
    }
    ThreadManager.a(new tph(paramList), 5, null, false);
  }
  
  public static boolean a()
  {
    int j = NetworkUtil.a(null);
    if ((j == 1) || (j == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      if (NearbyUtils.b()) {
        NearbyUtils.a("NAReport", new Object[] { "isDefaultDownloadSo", Integer.valueOf(j) });
      }
      return bool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NRNReportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */