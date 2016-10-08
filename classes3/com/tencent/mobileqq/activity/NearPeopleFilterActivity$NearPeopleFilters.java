package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.NearbyProfileUtil;

public class NearPeopleFilterActivity$NearPeopleFilters
{
  public static final int a = 0;
  public static final int[] a;
  public static final String[] a;
  public static final int b = 1;
  public static final String b = "byuser";
  public static final int[] b;
  public static final String[] b;
  public static final int c = 2;
  public static final String c = "gender";
  public static final String[] c;
  public static final int d = 3;
  public static final String d = "time";
  public static final int e = 0;
  public static final String e = "age";
  public static final int f = 1;
  public static final String f = "interest";
  public static final int g = 2;
  public static final String g = "xingzuo";
  public static final int h = 4;
  public static final String h = "key_career";
  public static final String i = "key_hometown_country";
  public static final String j = "key_hometown_province";
  public static final String k = "key_hometown_city";
  public static final String l = "key_hometown_string";
  public String a;
  public boolean a;
  public String[] d = { "0", "0", "0", "0" };
  public int i = 0;
  public int j = 4;
  public int k;
  public int l;
  public int m;
  public int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "不限", "爱旅游", "爱美食", "爱时尚", "爱运动", "爱电影", "爱音乐", "爱游戏" };
    c = new String[] { "不限", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 2130840971, 2130840967, 2130840966, 2130840972, 2130840969, 2130840970, 2130840968 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
  }
  
  public NearPeopleFilterActivity$NearPeopleFilters()
  {
    this.jdField_a_of_type_JavaLangString = "不限";
  }
  
  public static NearPeopleFilters a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "nearpeople_filters");
  }
  
  public static NearPeopleFilters a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      do
      {
        return null;
        paramContext = BaseApplicationImpl.a().getSharedPreferences(paramString2 + paramString1, 4);
      } while (paramContext == null);
      paramString1 = new NearPeopleFilters();
      paramString1.i = paramContext.getInt("gender", -1);
    } while (paramString1.i == -1);
    paramString1.jdField_a_of_type_Boolean = paramContext.getBoolean("byuser", false);
    paramString1.k = paramContext.getInt("age", 0);
    paramString1.l = paramContext.getInt("interest", 0);
    paramString1.j = paramContext.getInt("time", 3);
    paramString1.m = paramContext.getInt("xingzuo", 0);
    paramString1.n = paramContext.getInt("key_career", 0);
    paramString1.d[0] = paramContext.getString("key_hometown_country", "0");
    paramString1.d[1] = paramContext.getString("key_hometown_province", "0");
    paramString1.d[2] = paramContext.getString("key_hometown_city", "0");
    paramString1.jdField_a_of_type_JavaLangString = paramContext.getString("key_hometown_string", "不限");
    if ("-1".equals(paramString1.d[0])) {
      paramString1.d[0] = "0";
    }
    if ("-1".equals(paramString1.d[1])) {
      paramString1.d[1] = "0";
    }
    if ("-1".equals(paramString1.d[2])) {
      paramString1.d[2] = "0";
    }
    return paramString1;
  }
  
  public static void a(String paramString, NearPeopleFilters paramNearPeopleFilters)
  {
    a(paramString, paramNearPeopleFilters, "nearpeople_filters");
  }
  
  public static void a(String paramString1, NearPeopleFilters paramNearPeopleFilters, String paramString2)
  {
    if ((paramNearPeopleFilters == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      paramString1 = BaseApplicationImpl.a().getSharedPreferences(paramString2 + paramString1, 4);
    } while (paramString1 == null);
    paramString1.edit().putBoolean("byuser", paramNearPeopleFilters.jdField_a_of_type_Boolean).putInt("gender", paramNearPeopleFilters.i).putInt("time", paramNearPeopleFilters.j).putInt("age", paramNearPeopleFilters.k).putInt("xingzuo", paramNearPeopleFilters.m).putInt("key_career", paramNearPeopleFilters.n).putString("key_hometown_country", paramNearPeopleFilters.d[0]).putString("key_hometown_province", paramNearPeopleFilters.d[1]).putString("key_hometown_city", paramNearPeopleFilters.d[2]).putString("key_hometown_string", paramNearPeopleFilters.jdField_a_of_type_JavaLangString).putInt("interest", paramNearPeopleFilters.l).commit();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    String[] arrayOfString = this.d;
    int i3 = arrayOfString.length;
    int i2 = 0;
    int i1 = 1;
    while (i2 < i3)
    {
      if (!arrayOfString[i2].equals("0")) {
        i1 = 0;
      }
      i2 += 1;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("不限")) {
      i1 = 0;
    }
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      bool1 = bool2;
      if (this.i == 0) {
        if (this.j != 4)
        {
          bool1 = bool2;
          if (this.j != 3) {}
        }
        else
        {
          bool1 = bool2;
          if (this.k == 0)
          {
            bool1 = bool2;
            if (this.m == 0)
            {
              bool1 = bool2;
              if (this.n == 0)
              {
                bool1 = bool2;
                if (this.l == 0) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    int i1 = 0;
    boolean bool1;
    if ((paramObject == null) || (!(paramObject instanceof NearPeopleFilters)))
    {
      bool1 = false;
      return bool1;
    }
    paramObject = (NearPeopleFilters)paramObject;
    if ((this.i == ((NearPeopleFilters)paramObject).i) && ((this.j == ((NearPeopleFilters)paramObject).j) || (((this.j == 4) || (this.j == 3)) && ((((NearPeopleFilters)paramObject).j == 4) || (((NearPeopleFilters)paramObject).j == 3)))) && (this.k == ((NearPeopleFilters)paramObject).k) && (this.m == ((NearPeopleFilters)paramObject).m) && (this.n == ((NearPeopleFilters)paramObject).n) && (this.l == ((NearPeopleFilters)paramObject).l)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i1 >= 3) {
          break;
        }
        bool2 &= this.d[i1].equalsIgnoreCase(paramObject.d[i1]);
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        i1 += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("筛选：");
    String str1;
    int i1;
    switch (this.i)
    {
    case 0: 
    default: 
      if ((this.k != 0) && (this.k < jdField_a_of_type_ArrayOfJavaLangString.length)) {
        localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[this.k]).append(',');
      }
      if ((this.l != 0) && (this.l < jdField_b_of_type_ArrayOfJavaLangString.length)) {
        localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[this.l]).append(',');
      }
      if ((this.n != 0) && (this.n < NearbyProfileUtil.e.length))
      {
        String str2 = NearbyProfileUtil.e[this.n];
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "其他";
        }
        localStringBuilder.append(str1).append(',');
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals("不限")))
      {
        i1 = this.jdField_a_of_type_JavaLangString.lastIndexOf("-");
        if (i1 > 0)
        {
          str1 = this.jdField_a_of_type_JavaLangString.substring(i1 + 1);
          label216:
          localStringBuilder.append(str1).append(',');
        }
      }
      else
      {
        if ((this.m != 0) && (this.m < c.length)) {
          localStringBuilder.append(c[this.m]).append(',');
        }
        switch (this.j)
        {
        }
      }
      break;
    }
    for (;;)
    {
      str1 = localStringBuilder.toString();
      if (TextUtils.isEmpty(str1)) {
        break label392;
      }
      i1 = localStringBuilder.lastIndexOf(",");
      if (i1 <= 0) {
        break label392;
      }
      return str1.substring(0, i1);
      localStringBuilder.append("男,");
      break;
      localStringBuilder.append("女,");
      break;
      str1 = this.jdField_a_of_type_JavaLangString;
      break label216;
      localStringBuilder.append("30分钟内,");
      continue;
      localStringBuilder.append("1个小时内,");
      continue;
      localStringBuilder.append("4小时内,");
    }
    label392:
    return "全部";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\NearPeopleFilterActivity$NearPeopleFilters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */