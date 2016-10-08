package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class StepGroup
  extends AsyncStep
{
  protected AsyncStep[] a;
  protected String[] a;
  protected String c;
  public int j;
  
  public StepGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String a(String paramString)
  {
    Object localObject = paramString.toCharArray();
    int i1 = localObject.length;
    int k;
    int i2;
    int m;
    if (localObject[0] == '{')
    {
      k = 125;
      i2 = localObject[0];
      m = 0;
    }
    int i;
    for (int n = 0;; n = i)
    {
      if (m >= i1) {
        break label140;
      }
      if (localObject[m] == i2) {
        i = n + 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label128;
        }
        localObject = paramString.substring(0, m + 1);
        do
        {
          return (String)localObject;
          if (localObject[0] == '[')
          {
            k = 93;
            break;
          }
          localObject = paramString;
        } while (paramString.indexOf(",") == -1);
        return paramString.substring(0, paramString.indexOf(","));
        i = n;
        if (localObject[m] == k) {
          i = n - 1;
        }
      }
      label128:
      m += 1;
    }
    label140:
    return "";
  }
  
  private String[] a(String paramString)
  {
    int i = 0;
    if (paramString.length() <= 2) {
      return new String[0];
    }
    String str2 = paramString.substring(1, paramString.length() - 1);
    int m = str2.length();
    StringBuilder localStringBuilder = new StringBuilder(50);
    for (paramString = str2; i < m; paramString = str2.substring(i, m))
    {
      int k = i;
      String str1 = paramString;
      if (paramString.startsWith(","))
      {
        k = i + 1;
        str1 = str2.substring(k, m);
      }
      paramString = a(str1);
      localStringBuilder.append(paramString).append("-");
      i = k + paramString.length();
    }
    return localStringBuilder.toString().split("-");
  }
  
  protected AsyncStep a()
  {
    if (this.j < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.j] = StepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, this.jdField_a_of_type_ArrayOfJavaLangString[this.j]);
      AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
      int i = this.j;
      this.j = (i + 1);
      return arrayOfAsyncStep[i];
    }
    return null;
  }
  
  public void a()
  {
    this.b = 2147483647L;
    this.jdField_a_of_type_ArrayOfJavaLangString = a(this.c);
    this.j = 0;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = new AsyncStep[this.jdField_a_of_type_ArrayOfJavaLangString.length];
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 4) {
      super.a(paramInt);
    }
    AsyncStep[] arrayOfAsyncStep;
    int k;
    int i;
    if (((paramInt == 8) || (paramInt == 4)) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep != null))
    {
      arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
      k = arrayOfAsyncStep.length;
      i = 0;
    }
    for (;;)
    {
      AsyncStep localAsyncStep;
      if (i < k)
      {
        localAsyncStep = arrayOfAsyncStep[i];
        if (localAsyncStep != null) {}
      }
      else
      {
        return;
      }
      localAsyncStep.a(paramInt);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\StepGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */