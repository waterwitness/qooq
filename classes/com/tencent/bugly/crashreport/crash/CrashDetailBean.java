package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.a;
import java.util.Map;
import java.util.UUID;

public class CrashDetailBean
  implements Parcelable, Comparable<CrashDetailBean>
{
  public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator() {};
  public String A = "";
  public long B = -1L;
  public long C = -1L;
  public long D = -1L;
  public long E = -1L;
  public long F = -1L;
  public long G = -1L;
  public String H = "";
  public String I = "";
  public String J = "";
  public String K = "";
  public long L = -1L;
  public boolean M = false;
  public Map<String, String> N = null;
  public int O = -1;
  public int P = -1;
  public Map<String, String> Q = null;
  public Map<String, String> R = null;
  public byte[] S = null;
  public String T = "";
  public String U = null;
  private String V = "";
  public long a = -1L;
  public int b = 0;
  public String c = UUID.randomUUID().toString();
  public boolean d = false;
  public String e = "";
  public String f = "";
  public String g = "";
  public Map<String, PlugInBean> h = null;
  public Map<String, PlugInBean> i = null;
  public boolean j = false;
  public boolean k = false;
  public int l = 0;
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public long r = -1L;
  public String s = null;
  public int t = 0;
  public String u = "";
  public String v = "";
  public String w = null;
  public byte[] x = null;
  public Map<String, String> y = null;
  public String z = "";
  
  public CrashDetailBean() {}
  
  public CrashDetailBean(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.d = bool1;
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      this.g = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label697;
      }
      bool1 = true;
      label352:
      this.j = bool1;
      if (paramParcel.readByte() != 1) {
        break label702;
      }
      bool1 = true;
      label367:
      this.k = bool1;
      this.l = paramParcel.readInt();
      this.m = paramParcel.readString();
      this.n = paramParcel.readString();
      this.o = paramParcel.readString();
      this.p = paramParcel.readString();
      this.q = paramParcel.readString();
      this.r = paramParcel.readLong();
      this.s = paramParcel.readString();
      this.t = paramParcel.readInt();
      this.u = paramParcel.readString();
      this.v = paramParcel.readString();
      this.w = paramParcel.readString();
      this.y = a.b(paramParcel);
      this.z = paramParcel.readString();
      this.A = paramParcel.readString();
      this.B = paramParcel.readLong();
      this.C = paramParcel.readLong();
      this.D = paramParcel.readLong();
      this.E = paramParcel.readLong();
      this.F = paramParcel.readLong();
      this.G = paramParcel.readLong();
      this.H = paramParcel.readString();
      this.V = paramParcel.readString();
      this.I = paramParcel.readString();
      this.J = paramParcel.readString();
      this.K = paramParcel.readString();
      this.L = paramParcel.readLong();
      if (paramParcel.readByte() != 1) {
        break label707;
      }
    }
    label697:
    label702:
    label707:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.M = bool1;
      this.N = a.b(paramParcel);
      this.h = a.a(paramParcel);
      this.i = a.a(paramParcel);
      this.O = paramParcel.readInt();
      this.P = paramParcel.readInt();
      this.Q = a.b(paramParcel);
      this.R = a.b(paramParcel);
      this.S = paramParcel.createByteArray();
      this.x = paramParcel.createByteArray();
      this.T = paramParcel.readString();
      this.U = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label352;
      bool1 = false;
      break label367;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    if (this.d)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      if (!this.j) {
        break label412;
      }
      paramInt = 1;
      label66:
      paramParcel.writeByte((byte)paramInt);
      if (!this.k) {
        break label417;
      }
      paramInt = 1;
      label81:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.l);
      paramParcel.writeString(this.m);
      paramParcel.writeString(this.n);
      paramParcel.writeString(this.o);
      paramParcel.writeString(this.p);
      paramParcel.writeString(this.q);
      paramParcel.writeLong(this.r);
      paramParcel.writeString(this.s);
      paramParcel.writeInt(this.t);
      paramParcel.writeString(this.u);
      paramParcel.writeString(this.v);
      paramParcel.writeString(this.w);
      a.b(paramParcel, this.y);
      paramParcel.writeString(this.z);
      paramParcel.writeString(this.A);
      paramParcel.writeLong(this.B);
      paramParcel.writeLong(this.C);
      paramParcel.writeLong(this.D);
      paramParcel.writeLong(this.E);
      paramParcel.writeLong(this.F);
      paramParcel.writeLong(this.G);
      paramParcel.writeString(this.H);
      paramParcel.writeString(this.V);
      paramParcel.writeString(this.I);
      paramParcel.writeString(this.J);
      paramParcel.writeString(this.K);
      paramParcel.writeLong(this.L);
      if (!this.M) {
        break label422;
      }
    }
    label412:
    label417:
    label422:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      a.b(paramParcel, this.N);
      a.a(paramParcel, this.h);
      a.a(paramParcel, this.i);
      paramParcel.writeInt(this.O);
      paramParcel.writeInt(this.P);
      a.b(paramParcel, this.Q);
      a.b(paramParcel, this.R);
      paramParcel.writeByteArray(this.S);
      paramParcel.writeByteArray(this.x);
      paramParcel.writeString(this.T);
      paramParcel.writeString(this.U);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label66;
      paramInt = 0;
      break label81;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\crash\CrashDetailBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */