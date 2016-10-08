package com.tencent.mobileqq.unifiedname;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class MQQProfileNameTranslator
{
  public static final int a = 0;
  public static final int b = 6;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public static final int n = 4;
  public static final int o = 5;
  public static final int p = 6;
  public static final int q = 7;
  public static final int r = 8;
  public static final int s = 9;
  public static final int t = 10;
  public static final int u = 11;
  public static final int v = 1;
  public static final int w = 2;
  
  public MQQProfileNameTranslator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    switch (paramInt1)
    {
    default: 
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, paramMQQProfileName);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    }
    h(paramInt2, paramArrayOfString, paramMQQProfileName);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 1;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 4;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
    }
    while (paramInt != 1)
    {
      do
      {
        do
        {
          return;
          if (TextUtils.isEmpty(paramArrayOfString[4])) {
            break;
          }
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 3;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        return;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      MQQName localMQQName = new MQQName();
      localMQQName.jdField_a_of_type_Int = 3;
      localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 1;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 6;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 3;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      }
    }
    do
    {
      return;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    MQQName localMQQName = new MQQName();
    localMQQName.jdField_a_of_type_Int = 3;
    localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    while (paramInt != 1) {
      return;
    }
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 6;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      MQQName localMQQName = new MQQName();
      localMQQName.jdField_a_of_type_Int = 2;
      localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 2;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      MQQName localMQQName = new MQQName();
      localMQQName.jdField_a_of_type_Int = 3;
      localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 3;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    while (paramInt != 1) {
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    while (paramInt != 1) {
      return;
    }
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 5;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    while (paramInt != 1) {
      return;
    }
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 3;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    while (paramInt != 1) {
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedname\MQQProfileNameTranslator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */