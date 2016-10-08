package com.tencent.open.downloadnew;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import org.json.JSONException;
import org.json.JSONObject;
import wvg;

public class DownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new wvg();
  public static final int a = 0;
  protected static final String a;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public long a;
  public Intent a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public boolean c;
  public String d;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public volatile int k;
  public String k;
  public volatile int l;
  public String l;
  public int m;
  public String m;
  public int n = 0;
  public int o;
  public int p = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = DownloadInfo.class.getName();
  }
  
  public DownloadInfo()
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 1;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_l_of_type_JavaLangString = "";
  }
  
  public DownloadInfo(String paramString1, String paramString2)
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 1;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.d = paramString2;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, String paramString6, String paramString7, int paramInt1, String paramString8, String paramString9, int paramInt2, int paramInt3, String paramString10, int paramInt4, long paramLong2, boolean paramBoolean, int paramInt5, String paramString11, int paramInt6, int paramInt7, String paramString12)
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 1;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.jdField_f_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_g_of_type_JavaLangString = paramString6;
    this.jdField_h_of_type_JavaLangString = paramString7;
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_i_of_type_JavaLangString = paramString8;
    this.jdField_j_of_type_JavaLangString = paramString9;
    this.jdField_g_of_type_Int = paramInt2;
    this.jdField_h_of_type_Int = paramInt3;
    this.jdField_k_of_type_JavaLangString = paramString10;
    this.jdField_j_of_type_Int = paramInt4;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.n = paramInt5;
    this.jdField_l_of_type_JavaLangString = paramString11;
    this.o = paramInt6;
    this.p = paramInt7;
    this.m = paramString12;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 1;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.jdField_f_of_type_JavaLangString = ("_" + paramString1);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_k_of_type_Int = 1;
    this.jdField_g_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_j_of_type_Int = paramInt;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int a()
  {
    try
    {
      int i1 = this.jdField_k_of_type_Int;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("state", this.jdField_k_of_type_Int);
      localJSONObject.put("pro", this.jdField_l_of_type_Int);
      localJSONObject.put("packagename", this.d);
      localJSONObject.put("ismyapp", this.jdField_h_of_type_Int);
      localJSONObject.put("download_from", this.n);
      localJSONObject.put("realDownloadType", this.jdField_i_of_type_Int);
      localJSONObject.put("via", this.jdField_g_of_type_JavaLangString);
      localJSONObject.put("writecodestate", this.p);
      localJSONObject.put("writecodestate", this.p);
      localJSONObject.put("extraInfo", this.m);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "onNetworkConnect " + localJSONException.getMessage(), localJSONException);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_k_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DownloadInfo [appId=" + this.jdField_b_of_type_JavaLangString + ", urlStr=" + this.jdField_c_of_type_JavaLangString + ", packageName=" + this.d + ", push_title=" + this.e + ", sendTime=" + this.jdField_f_of_type_JavaLangString + ", progress=" + this.jdField_l_of_type_Int + ", time=" + this.jdField_a_of_type_Long + ", filePath=" + this.jdField_k_of_type_JavaLangString + ", state=" + this.jdField_k_of_type_Int + ", urlPatch=" + this.jdField_h_of_type_JavaLangString + ", updateType=" + this.jdField_f_of_type_Int + ", myAppId=" + this.jdField_i_of_type_JavaLangString + ", apkId=" + this.jdField_f_of_type_Int + ", versionCode=" + this.jdField_g_of_type_Int + ", lastDownloadSize=" + this.jdField_b_of_type_Long + ", isApk=" + this.jdField_c_of_type_Boolean + ", iconUrl=" + this.jdField_l_of_type_JavaLangString + ", isShowNotification=" + this.o + ", writeCodeState=" + this.p + ", extraInfo =" + this.m + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_k_of_type_Int);
    paramParcel.writeInt(this.jdField_l_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    if (this.jdField_c_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeInt(this.o);
      paramParcel.writeInt(this.p);
      paramParcel.writeString(this.m);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\DownloadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */