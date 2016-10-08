package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FetchInfoReq
{
  public static final int a = 1;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 4;
  public Bundle a;
  public Object a;
  public String a;
  public String b;
  public int g;
  
  public FetchInfoReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FetchInfoReq(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    this.g = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    this.g = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public boolean a()
  {
    if ((this.g < 1) || (this.g > 4)) {}
    while ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim())) || ((this.g == 3) && ((this.b == null) || ("".equals(this.b))) && ((this.jdField_a_of_type_JavaLangObject == null) || ("".equals(this.jdField_a_of_type_JavaLangObject))))) {
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof FetchInfoReq))
    {
      paramObject = (FetchInfoReq)paramObject;
      if ((((FetchInfoReq)paramObject).g == this.g) && (Utils.a(this.jdField_a_of_type_JavaLangString, ((FetchInfoReq)paramObject).jdField_a_of_type_JavaLangString)) && ((3 != this.g) || ((Utils.a(this.b, ((FetchInfoReq)paramObject).b)) && (Utils.a(this.jdField_a_of_type_JavaLangObject, ((FetchInfoReq)paramObject).jdField_a_of_type_JavaLangObject)) && (Utils.a(this.jdField_a_of_type_AndroidOsBundle, ((FetchInfoReq)paramObject).jdField_a_of_type_AndroidOsBundle))))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.g;
    int i;
    int j;
    label27:
    int k;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      i = 0;
      if (this.b != null) {
        break label66;
      }
      j = 0;
      if (this.jdField_a_of_type_JavaLangObject != null) {
        break label77;
      }
      k = 0;
      label36:
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break label88;
      }
    }
    for (;;)
    {
      return k + (n + i + j) + m;
      i = this.jdField_a_of_type_JavaLangString.hashCode();
      break;
      label66:
      j = this.b.hashCode();
      break label27;
      label77:
      k = this.jdField_a_of_type_JavaLangObject.hashCode();
      break label36;
      label88:
      m = this.jdField_a_of_type_AndroidOsBundle.hashCode();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[iType = ").append(this.g).append(", strKey = ").append(this.jdField_a_of_type_JavaLangString).append(", strSubKey = ").append(this.b).append(", obj = ").append(this.jdField_a_of_type_JavaLangObject).append(", extraUpdateTargetParams = ").append(this.jdField_a_of_type_AndroidOsBundle).append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FetchInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */