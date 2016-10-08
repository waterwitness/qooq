package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingSubjectItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyConfigUtil;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;
import java.util.List;
import rdw;

public class DatingFilters
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new rdw();
  public static final int a = 0;
  public static final String a = "key_filter_value";
  private static List a;
  public static final int[] a;
  public static final String[] a;
  public static final int b = 1;
  private static final String b = "key_gender";
  public static final int[] b;
  public static final String[] b;
  public static final int c = 2;
  private static final String c = "key_dating_time";
  public static String[] c;
  private static final String d = "key_dating_content";
  private static final String e = "key_age";
  private static final String f = "key_career";
  private static final String g = "key_dest";
  private static final String h = "key_dest_type";
  public appoint_define.LocaleInfo a;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 22, 26, 35, 120 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 18, 23, 27, 36 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "不限", "今天", "明天", "一周内", "一个月内" };
    c = new String[] { "不限", "吃饭", "看电影", "唱歌", "出行", "运动" };
  }
  
  public DatingFilters(Context paramContext)
  {
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (BaseActivity)paramContext;
      if (paramContext.app == null) {
        break label123;
      }
      paramContext = paramContext.app.a().a();
    }
    for (;;)
    {
      if (paramContext != null) {
        jdField_a_of_type_JavaUtilList = paramContext.a();
      }
      if (jdField_a_of_type_JavaUtilList == null) {
        jdField_a_of_type_JavaUtilList = NearbyConfigUtil.b();
      }
      c = new String[jdField_a_of_type_JavaUtilList.size() + 1];
      c[0] = "不限";
      while (k < jdField_a_of_type_JavaUtilList.size())
      {
        c[(k + 1)] = ((DatingSubjectItem)jdField_a_of_type_JavaUtilList.get(k)).name;
        k += 1;
      }
      label123:
      paramContext = (DatingManager)paramContext.getAppInterface().getManager(212);
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = paramContext.a();
      }
    }
  }
  
  private DatingFilters(Parcel paramParcel)
  {
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    paramParcel = paramParcel.readString();
    if ((paramParcel == null) || (paramParcel.equals("")))
    {
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
      return;
    }
    try
    {
      appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
      localLocaleInfo.mergeFrom(paramParcel.getBytes("ISO-8859-1"));
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = localLocaleInfo;
      return;
    }
    catch (Exception paramParcel)
    {
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    }
  }
  
  public static DatingFilters a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      paramContext = null;
    }
    DatingFilters localDatingFilters;
    do
    {
      return paramContext;
      localDatingFilters = new DatingFilters(paramContext);
      paramString = paramContext.getSharedPreferences("dating_pref" + paramString, 0);
      paramContext = localDatingFilters;
    } while (paramString == null);
    localDatingFilters.d = paramString.getInt("key_gender", 0);
    localDatingFilters.h = paramString.getInt("key_age", 0);
    localDatingFilters.e = paramString.getInt("key_dating_time", 0);
    localDatingFilters.g = paramString.getInt("key_dating_content", 0);
    localDatingFilters.f = localDatingFilters.b(localDatingFilters.g);
    localDatingFilters.i = paramString.getInt("key_career", 0);
    localDatingFilters.j = paramString.getInt("key_dest_type", 0);
    paramContext = paramString.getString("key_dest", "");
    if ((paramContext == null) || (paramContext.equals("")))
    {
      localDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
      return localDatingFilters;
    }
    try
    {
      paramString = new appoint_define.LocaleInfo();
      paramString.mergeFrom(paramContext.getBytes("ISO-8859-1"));
      localDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = paramString;
      return localDatingFilters;
    }
    catch (Exception paramContext)
    {
      localDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    }
    return localDatingFilters;
  }
  
  public static void a(Context paramContext, String paramString, DatingFilters paramDatingFilters)
  {
    if ((paramDatingFilters == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences("dating_pref" + paramString, 0);
    } while (paramContext == null);
    paramString = paramContext.edit();
    paramString.putInt("key_gender", paramDatingFilters.d).putInt("key_dating_time", paramDatingFilters.e).putInt("key_dating_content", paramDatingFilters.g).putInt("key_age", paramDatingFilters.h).putInt("key_career", paramDatingFilters.i).putInt("key_dest_type", paramDatingFilters.j);
    for (;;)
    {
      try
      {
        if (paramDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) {
          continue;
        }
        paramContext = "";
        paramString.putString("key_dest", paramContext);
      }
      catch (UnsupportedEncodingException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      paramString.commit();
      return;
      paramContext = new String(paramDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray(), "ISO-8859-1");
    }
  }
  
  public static void a(NearbyAppInterface paramNearbyAppInterface)
  {
    if ((jdField_a_of_type_JavaUtilList != null) || (paramNearbyAppInterface == null)) {}
    do
    {
      return;
      paramNearbyAppInterface = (DatingManager)paramNearbyAppInterface.getManager(212);
      if (paramNearbyAppInterface.a() != null) {
        jdField_a_of_type_JavaUtilList = paramNearbyAppInterface.a().a();
      }
    } while (jdField_a_of_type_JavaUtilList != null);
    jdField_a_of_type_JavaUtilList = NearbyConfigUtil.b();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt == 0) || (jdField_a_of_type_JavaUtilList == null)) {
      return 0;
    }
    return ((DatingSubjectItem)jdField_a_of_type_JavaUtilList.get(paramInt - 1)).id;
  }
  
  public boolean a()
  {
    return (this.d == 0) && (this.e == 0) && (this.f == 0) && (this.h == 0) && (this.i == 0);
  }
  
  public int b(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return 0;
      int k = 0;
      while (k < jdField_a_of_type_JavaUtilList.size())
      {
        if (paramInt == ((DatingSubjectItem)jdField_a_of_type_JavaUtilList.get(k)).id) {
          return k + 1;
        }
        k += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DatingFilters)paramObject;
      if (this.h != ((DatingFilters)paramObject).h) {
        return false;
      }
      if (this.i != ((DatingFilters)paramObject).i) {
        return false;
      }
      if (this.f != ((DatingFilters)paramObject).f) {
        return false;
      }
      if (this.e != ((DatingFilters)paramObject).e) {
        return false;
      }
      if (this.d != ((DatingFilters)paramObject).d) {
        return false;
      }
    } while ((this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == ((DatingFilters)paramObject).jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo) || ((this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (((DatingFilters)paramObject).jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get().equals(((DatingFilters)paramObject).jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get()))));
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DatingFilters [gender=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", datingTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", datingContent=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", career=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", dest=");
    if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    try
    {
      if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == null) {}
      for (String str = "";; str = new String(this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray(), "ISO-8859-1"))
      {
        paramParcel.writeString(str);
        return;
      }
      return;
    }
    catch (UnsupportedEncodingException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingFilters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */