package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;
import vlx;

public class TroopBarPOI
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new vlx();
  protected static final String a = "uid";
  protected static final String b = "catalog";
  protected static final String c = "name";
  protected static final String d = "longitude";
  protected static final String e = "addr";
  protected static final String f = "latitude";
  protected static final String g = "dist";
  public final int a;
  public final int b;
  public final String h;
  public final String i;
  public final String j;
  public final String k;
  public final String l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopBarPOI(TroopBarPOI paramTroopBarPOI)
  {
    this.h = paramTroopBarPOI.h;
    this.i = paramTroopBarPOI.i;
    this.j = paramTroopBarPOI.j;
    this.a = paramTroopBarPOI.a;
    this.k = paramTroopBarPOI.k;
    this.b = paramTroopBarPOI.b;
    this.l = paramTroopBarPOI.l;
  }
  
  public TroopBarPOI(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.a = paramInt1;
    this.k = paramString4;
    this.b = paramInt2;
    this.l = paramString5;
  }
  
  public TroopBarPOI(JSONObject paramJSONObject)
  {
    this.h = paramJSONObject.optString("uid", "");
    this.i = paramJSONObject.optString("catalog", "");
    this.j = paramJSONObject.optString("name", "");
    this.a = ((int)(paramJSONObject.optDouble("longitude", -1.0D) * 1000000.0D));
    this.k = paramJSONObject.optString("addr", "");
    this.b = ((int)(paramJSONObject.optDouble("latitude", -1.0D) * 1000000.0D));
    this.l = paramJSONObject.optString("dist", "");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof TroopBarPOI))
    {
      paramObject = (TroopBarPOI)paramObject;
      bool1 = bool2;
      if (TextUtils.equals(((TroopBarPOI)paramObject).j, this.j))
      {
        bool1 = bool2;
        if (TextUtils.equals(((TroopBarPOI)paramObject).k, this.k)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.l);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopBarPOI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */