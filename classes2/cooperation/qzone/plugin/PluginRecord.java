package cooperation.qzone.plugin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import ynt;

public class PluginRecord
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new ynt();
  public static final int a = 1;
  public static final String a = "qzone_live_video_plugin_hack.apk";
  public static final int b = 2;
  public static final String b = "com.tencent.mobileqq:qzonelive";
  public static final int c = 3;
  public static final int d = 4;
  public float a;
  public long a;
  boolean a;
  public String c = "";
  public String d = "";
  public int e;
  public String e;
  public int f;
  public String f;
  public String g = "";
  public String h = "";
  public String i = "";
  public String j;
  public String k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PluginRecord()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PluginRecord(Parcel paramParcel)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public PluginRecord(PluginRecord paramPluginRecord)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Int = paramPluginRecord.jdField_e_of_type_Int;
    this.jdField_a_of_type_Float = paramPluginRecord.jdField_a_of_type_Float;
    this.c = paramPluginRecord.c;
    this.d = paramPluginRecord.d;
    this.jdField_e_of_type_JavaLangString = paramPluginRecord.jdField_e_of_type_JavaLangString;
    this.jdField_f_of_type_JavaLangString = paramPluginRecord.jdField_f_of_type_JavaLangString;
    this.g = paramPluginRecord.g;
    this.h = paramPluginRecord.h;
    this.i = paramPluginRecord.i;
    this.jdField_f_of_type_Int = paramPluginRecord.jdField_f_of_type_Int;
    this.jdField_a_of_type_Long = paramPluginRecord.jdField_a_of_type_Long;
    this.j = paramPluginRecord.j;
    this.k = paramPluginRecord.k;
    this.jdField_a_of_type_Boolean = paramPluginRecord.jdField_a_of_type_Boolean;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  protected PluginRecord a()
  {
    return new PluginRecord(this);
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.jdField_e_of_type_Int);
      localJSONObject.put("progress", this.jdField_a_of_type_Float);
      localJSONObject.put("url", this.c);
      localJSONObject.put("app", this.d);
      localJSONObject.put("ver", this.jdField_e_of_type_JavaLangString);
      localJSONObject.put("name", this.jdField_f_of_type_JavaLangString);
      localJSONObject.put("id", this.g);
      localJSONObject.put("mainVersion", this.h);
      localJSONObject.put("md5", this.i);
      localJSONObject.put("mProcesses", this.j);
      localJSONObject.put("mInstalledPath", this.k);
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "toJson :" + localJSONObject);
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.c = "";
    this.d = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "fromJson :" + paramString);
      }
      paramString = new JSONObject(paramString);
      this.jdField_e_of_type_Int = paramString.optInt("state");
      this.jdField_a_of_type_Float = ((float)paramString.optDouble("progress", 0.0D));
      this.c = paramString.optString("url");
      this.d = paramString.optString("app");
      this.jdField_e_of_type_JavaLangString = paramString.optString("ver");
      this.jdField_f_of_type_JavaLangString = paramString.optString("name");
      this.g = paramString.optString("id");
      this.h = paramString.optString("mainVersion");
      this.i = paramString.optString("md5");
      this.j = paramString.optString("mProcesses");
      this.k = paramString.optString("mInstalledPath");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.g);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PluginRecord))) {}
    do
    {
      return false;
      paramObject = (PluginRecord)paramObject;
    } while ((this.jdField_f_of_type_Int != ((PluginRecord)paramObject).jdField_f_of_type_Int) || (!a(this.c, ((PluginRecord)paramObject).c)) || (!a(this.d, ((PluginRecord)paramObject).d)) || (!a(this.jdField_e_of_type_JavaLangString, ((PluginRecord)paramObject).jdField_e_of_type_JavaLangString)) || (!a(this.jdField_f_of_type_JavaLangString, ((PluginRecord)paramObject).jdField_f_of_type_JavaLangString)) || (!a(this.g, ((PluginRecord)paramObject).g)) || (!a(this.h, ((PluginRecord)paramObject).h)) || (!a(this.i, ((PluginRecord)paramObject).i)));
    return true;
  }
  
  public int hashCode()
  {
    int n = 0;
    int m;
    if (this.g == null)
    {
      m = 0;
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label40;
      }
    }
    for (;;)
    {
      return (m + 527) * 31 + n;
      m = this.g.hashCode();
      break;
      label40:
      n = this.jdField_e_of_type_JavaLangString.hashCode();
    }
  }
  
  public String toString()
  {
    return "PluginRecord{" + this.g + " " + this.jdField_e_of_type_JavaLangString + " " + this.jdField_e_of_type_Int + " }";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\PluginRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */