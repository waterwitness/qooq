package com.tencent.mobileqq.profile.view;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.MD5;
import java.util.Map;

public class QzonePhotoView$PhotoInfo
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 100;
  public static final int e = 101;
  public static final int f = 102;
  public String a;
  public Map a;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public QzonePhotoView$PhotoInfo(int paramInt1, int paramInt2, Map paramMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = 0;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_JavaLangString = null;
    this.j = paramInt2;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      paramMap = new StringBuilder();
      paramMap.append(paramInt1);
      paramInt1 = 0;
      while (paramInt1 <= 4)
      {
        String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
        if (str != null) {
          paramMap.append(str);
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaLangString = paramMap.toString();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = MD5.toMD5(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private String b(int paramInt)
  {
    Object localObject = null;
    int k = 1;
    while ((TextUtils.isEmpty((CharSequence)localObject)) && (k < 5))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf((paramInt + k) % 5));
      k += 1;
    }
    return (String)localObject;
  }
  
  public String a()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = b(1);
      }
    }
    return (String)localObject;
  }
  
  public String a(int paramInt)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      if (paramInt > 100) {
        break label51;
      }
    }
    label51:
    for (paramInt = 3;; paramInt = 2)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = b(paramInt);
      }
      return (String)localObject;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof PhotoInfo)) {
      bool = Utils.a(((PhotoInfo)paramObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\QzonePhotoView$PhotoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */