package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import org.json.JSONObject;

public class IndividuationABTestManager
  implements Manager
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 0;
  public static final String b = "individuationABTestFile_";
  QQAppInterface a;
  public boolean a;
  public boolean b;
  public int c;
  public String c;
  public int d = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = IndividuationABTestManager.class.getSimpleName();
  }
  
  public IndividuationABTestManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson jsonStr empty");
      }
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_c_of_type_Int = paramString.optInt("personalSwitch");
        this.jdField_c_of_type_JavaLangString = paramString.optString("enterUrl");
        if (paramString.has("isShowRed"))
        {
          i = paramString.getInt("isShowRed");
          this.d = i;
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "parseJson error e = " + paramString.getMessage());
        this.jdField_c_of_type_Int = 0;
        this.jdField_c_of_type_JavaLangString = "";
        this.d = -1;
        paramString.printStackTrace();
        return;
      }
      int i = -1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handlePostTask version = " + paramInt);
    }
    paramString = new File(BaseApplicationImpl.getContext().getFilesDir(), "individuationABTestFile_" + paramString);
    try
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      this.jdField_c_of_type_Int = 0;
      this.jdField_c_of_type_JavaLangString = "";
      this.d = -1;
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        Object localObject = null;
        File localFile = new File(BaseApplicationImpl.getContext().getFilesDir(), "individuationABTestFile_" + paramString);
        this.b = true;
        paramString = (String)localObject;
        try
        {
          if (localFile.exists()) {
            paramString = FileUtils.a(localFile);
          }
          if (TextUtils.isEmpty(paramString))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJsonFromFile jsont str is empty");
          }
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJsonFromFile fileStr = " + paramString);
      }
    } while (this.jdField_a_of_type_Boolean);
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateJsonInfo jsonStr or uin empty");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateJsonInfo jsonStr = " + paramString1);
      }
      this.jdField_a_of_type_Boolean = true;
      b(paramString1);
      String str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "individuationABTestFile_" + paramString2;
      try
      {
        boolean bool = FileUtils.a(str, paramString1);
        if (!bool) {
          continue;
        }
        SharedPreUtils.e(BaseApplicationImpl.getContext(), paramInt, paramString2);
        return;
      }
      finally {}
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationABTestManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */