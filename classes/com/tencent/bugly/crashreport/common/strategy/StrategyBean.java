package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.proguard.a;
import java.util.Map;

public class StrategyBean
  implements Parcelable
{
  public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator() {};
  public static String a = "http://android.bugly.qq.com/rqd/async";
  public static String b = "http://android.bugly.qq.com/rqd/async";
  public static String c = "http://rqd.uu.qq.com/rqd/sync";
  public static String d;
  public long e = -1L;
  public long f = -1L;
  public boolean g = true;
  public boolean h = true;
  public boolean i = true;
  public boolean j = true;
  public boolean k = false;
  public boolean l = true;
  public boolean m = true;
  public boolean n = true;
  public long o;
  public long p = 30000L;
  public String q = a;
  public String r = b;
  public String s = c;
  public String t;
  public Map<String, String> u;
  public int v = 10;
  public long w = 300000L;
  public long x = -1L;
  private boolean y = true;
  
  public StrategyBean()
  {
    this.f = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("S(@L@L").append("@)");
    d = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("*^@K#K").append("@!");
    this.t = localStringBuilder.toString();
  }
  
  public StrategyBean(Parcel paramParcel)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("S(@L@L").append("@)");
      d = localStringBuilder.toString();
      this.f = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.g = bool1;
        if (paramParcel.readByte() != 1) {
          break label363;
        }
        bool1 = true;
        label174:
        this.h = bool1;
        if (paramParcel.readByte() != 1) {
          break label368;
        }
        bool1 = true;
        label189:
        this.i = bool1;
        this.q = paramParcel.readString();
        this.r = paramParcel.readString();
        this.t = paramParcel.readString();
        this.u = a.b(paramParcel);
        if (paramParcel.readByte() != 1) {
          break label373;
        }
        bool1 = true;
        label236:
        this.j = bool1;
        if (paramParcel.readByte() != 1) {
          break label378;
        }
        bool1 = true;
        label251:
        this.k = bool1;
        if (paramParcel.readByte() != 1) {
          break label383;
        }
        bool1 = true;
        label266:
        this.m = bool1;
        if (paramParcel.readByte() != 1) {
          break label388;
        }
        bool1 = true;
        label281:
        this.n = bool1;
        this.p = paramParcel.readLong();
        if (paramParcel.readByte() != 1) {
          break label393;
        }
        bool1 = true;
        label304:
        this.l = bool1;
        if (paramParcel.readByte() != 1) {
          break label398;
        }
      }
      label363:
      label368:
      label373:
      label378:
      label383:
      label388:
      label393:
      label398:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.y = bool1;
        this.o = paramParcel.readLong();
        this.v = paramParcel.readInt();
        this.w = paramParcel.readLong();
        this.x = paramParcel.readLong();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label174;
        bool1 = false;
        break label189;
        bool1 = false;
        break label236;
        bool1 = false;
        break label251;
        bool1 = false;
        break label266;
        bool1 = false;
        break label281;
        bool1 = false;
        break label304;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeLong(this.f);
    if (this.g)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.h) {
        break label223;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.i) {
        break label228;
      }
      paramInt = 1;
      label49:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.q);
      paramParcel.writeString(this.r);
      paramParcel.writeString(this.t);
      a.b(paramParcel, this.u);
      if (!this.j) {
        break label233;
      }
      paramInt = 1;
      label96:
      paramParcel.writeByte((byte)paramInt);
      if (!this.k) {
        break label238;
      }
      paramInt = 1;
      label111:
      paramParcel.writeByte((byte)paramInt);
      if (!this.m) {
        break label243;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.n) {
        break label248;
      }
      paramInt = 1;
      label141:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.p);
      if (!this.l) {
        break label253;
      }
      paramInt = 1;
      label164:
      paramParcel.writeByte((byte)paramInt);
      if (!this.y) {
        break label258;
      }
    }
    label223:
    label228:
    label233:
    label238:
    label243:
    label248:
    label253:
    label258:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.o);
      paramParcel.writeInt(this.v);
      paramParcel.writeLong(this.w);
      paramParcel.writeLong(this.x);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label34;
      paramInt = 0;
      break label49;
      paramInt = 0;
      break label96;
      paramInt = 0;
      break label111;
      paramInt = 0;
      break label126;
      paramInt = 0;
      break label141;
      paramInt = 0;
      break label164;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\common\strategy\StrategyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */