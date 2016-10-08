package com.tencent.arrange.op;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import gcs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MeetingInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new gcs();
  public static final int TYPE_AVGROUPMEETING = 3;
  public static final int TYPE_AVMEETING = 2;
  private long begin_time;
  private String creator_uin;
  private String discuss_uin;
  private int enable;
  private long end_time;
  private String introduction;
  public String notifContent;
  private ArrayList participants;
  private long seq;
  private int type;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MeetingInfo() {}
  
  public MeetingInfo(Parcel paramParcel)
  {
    this.discuss_uin = paramParcel.readString();
    this.creator_uin = paramParcel.readString();
    this.introduction = paramParcel.readString();
    this.notifContent = paramParcel.readString();
    this.begin_time = paramParcel.readLong();
    this.end_time = paramParcel.readLong();
    this.seq = paramParcel.readLong();
    this.enable = paramParcel.readInt();
    this.type = paramParcel.readInt();
    if (this.participants == null) {
      this.participants = new ArrayList();
    }
    paramParcel.readStringList(this.participants);
  }
  
  public static String FormatTime(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong1);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    String str2 = String.format("%d-%02d-%02d %02d:%02d-", new Object[] { Integer.valueOf(i), Integer.valueOf(j + 1), Integer.valueOf(k), Integer.valueOf(localCalendar.get(11)), Integer.valueOf(localCalendar.get(12)) });
    localCalendar.setTimeInMillis(paramLong2);
    String str1;
    if ((i == localCalendar.get(1)) && (j == localCalendar.get(2)))
    {
      str1 = str2;
      if (k == localCalendar.get(5)) {}
    }
    else
    {
      str1 = str2 + String.format("%d-%02d-%02d ", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
    }
    return str1 + String.format("%02d:%02d", new Object[] { Integer.valueOf(localCalendar.get(11)), Integer.valueOf(localCalendar.get(12)) });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getBegin_time()
  {
    return this.begin_time;
  }
  
  public String getCreator_uin()
  {
    return this.creator_uin;
  }
  
  public String getDiscuss_uin()
  {
    return this.discuss_uin;
  }
  
  public int getEnable()
  {
    return this.enable;
  }
  
  public long getEnd_time()
  {
    return this.end_time;
  }
  
  public String getFormatTime()
  {
    return FormatTime(getBegin_time(), getEnd_time());
  }
  
  public String getIntroduction()
  {
    return this.introduction;
  }
  
  public String getNotifContent()
  {
    return this.notifContent;
  }
  
  public ArrayList getParticipants()
  {
    return this.participants;
  }
  
  public long getSeq()
  {
    return this.seq;
  }
  
  public long getShowTimeCount()
  {
    long l = getBegin_time() + 60000L - NetConnInfoCenter.getServerTimeMillis();
    if (l < 5000L) {
      return 5000L;
    }
    if (l > 60000L) {
      return 60000L;
    }
    return l;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setBegin_time(long paramLong)
  {
    this.begin_time = paramLong;
  }
  
  public void setCreator_uin(String paramString)
  {
    this.creator_uin = paramString;
  }
  
  public void setDiscuss_uin(String paramString)
  {
    this.discuss_uin = paramString;
  }
  
  public void setEnable(int paramInt)
  {
    this.enable = paramInt;
  }
  
  public void setEnd_time(long paramLong)
  {
    this.end_time = paramLong;
  }
  
  public void setIntroduction(String paramString)
  {
    this.introduction = paramString;
  }
  
  public void setNotifContent(String paramString)
  {
    this.notifContent = paramString;
  }
  
  public void setParticipants(ArrayList paramArrayList)
  {
    this.participants = paramArrayList;
  }
  
  public void setSeq(long paramLong)
  {
    this.seq = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.discuss_uin);
    paramParcel.writeString(this.creator_uin);
    paramParcel.writeString(this.introduction);
    paramParcel.writeString(this.notifContent);
    paramParcel.writeLong(this.begin_time);
    paramParcel.writeLong(this.end_time);
    paramParcel.writeLong(this.seq);
    paramParcel.writeInt(this.enable);
    paramParcel.writeInt(this.type);
    paramParcel.writeStringList(this.participants);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\arrange\op\MeetingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */