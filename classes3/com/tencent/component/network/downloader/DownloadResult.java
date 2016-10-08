package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.component.network.utils.AssertUtil;

public final class DownloadResult
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadResult> CREATOR = new DownloadResult.1();
  private String a;
  private String b;
  private Status c = new Status();
  private Process d = new Process();
  private Content e = new Content();
  private DownloadReport f;
  private String g;
  private String h;
  
  public DownloadResult(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((Status)paramParcel.readParcelable(Status.class.getClassLoader()));
    this.d = ((Process)paramParcel.readParcelable(Process.class.getClassLoader()));
    this.e = ((Content)paramParcel.readParcelable(Content.class.getClassLoader()));
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public DownloadResult(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      AssertUtil.assertTrue(bool);
      this.a = paramString;
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Content getContent()
  {
    return this.e;
  }
  
  public final String getDescInfo()
  {
    return this.g;
  }
  
  public final String getDetailDownloadInfo()
  {
    return this.h;
  }
  
  public final String getPath()
  {
    return this.b;
  }
  
  public final Process getProcess()
  {
    return this.d;
  }
  
  public final DownloadReport getReport()
  {
    return this.f;
  }
  
  public final Status getStatus()
  {
    return this.c;
  }
  
  public final String getUrl()
  {
    return this.a;
  }
  
  public final void reset()
  {
    this.c.reset();
    this.d.reset();
    this.e.reset();
  }
  
  public final void setDescInfo(String paramString)
  {
    this.g = paramString;
  }
  
  public final void setDetailDownloadInfo(String paramString)
  {
    this.h = paramString;
  }
  
  public final void setPath(String paramString)
  {
    this.b = paramString;
  }
  
  public final void setReport(DownloadReport paramDownloadReport)
  {
    this.f = paramDownloadReport;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, 0);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeParcelable(this.e, 0);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
  
  public static final class Content
    implements Parcelable
  {
    public static final Parcelable.Creator<Content> CREATOR = new DownloadResult.Content.1();
    public String clientip;
    public Object content;
    public String encoding;
    public String lastModified;
    public long length;
    public boolean noCache;
    public long realsize;
    public long size;
    public String type;
    
    Content() {}
    
    public Content(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.type = paramParcel.readString();
      this.encoding = paramParcel.readString();
      this.length = paramParcel.readLong();
      this.size = paramParcel.readLong();
      this.realsize = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.noCache = bool;
        this.clientip = paramParcel.readString();
        this.lastModified = paramParcel.readString();
        return;
        bool = false;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void reset()
    {
      this.type = null;
      this.encoding = null;
      this.length = 0L;
      this.size = 0L;
      this.realsize = -1L;
      this.noCache = false;
      this.content = null;
      this.clientip = null;
      this.lastModified = null;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.encoding);
      paramParcel.writeLong(this.length);
      paramParcel.writeLong(this.size);
      paramParcel.writeLong(this.realsize);
      if (this.noCache) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.clientip);
        paramParcel.writeString(this.lastModified);
        return;
      }
    }
  }
  
  public static final class Process
    implements Parcelable
  {
    public static final Parcelable.Creator<Process> CREATOR = new DownloadResult.Process.1();
    public long duration;
    public long endTime;
    public long startTime;
    
    Process() {}
    
    public Process(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.startTime = paramParcel.readLong();
      this.endTime = paramParcel.readLong();
      this.duration = paramParcel.readLong();
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void reset()
    {
      this.startTime = 0L;
      this.endTime = 0L;
      this.duration = 0L;
    }
    
    public final void setDuration(long paramLong1, long paramLong2)
    {
      this.startTime = paramLong1;
      this.endTime = paramLong2;
      this.duration = (paramLong2 - paramLong1);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeLong(this.startTime);
      paramParcel.writeLong(this.endTime);
      paramParcel.writeLong(this.duration);
    }
  }
  
  public static final class Status
    implements Parcelable
  {
    public static final Parcelable.Creator<Status> CREATOR = new DownloadResult.Status.1();
    public static final int REASON_FAIL_CONTENT = 5;
    public static final int REASON_FAIL_EXCEPTION = 4;
    public static final int REASON_FAIL_META = 7;
    public static final int REASON_FAIL_NETWORK = 3;
    public static final int REASON_FAIL_NETWORK_UNAVAILABLE = 6;
    public static final int REASON_FAIL_NONE = 0;
    public static final int REASON_FAIL_STORAGE = 2;
    public static final int REASON_FAIL_UNKNOWN = 1;
    public static final int STATE_CANCELED = 4;
    public static final int STATE_FAILED = 2;
    public static final int STATE_RETRYING = 3;
    public static final int STATE_SUCCEED = 1;
    public int exception2Code = 0;
    public Throwable failException = null;
    public int failReason = 1;
    public int httpStatus;
    public int state = 2;
    
    public Status() {}
    
    public Status(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.state = paramParcel.readInt();
      this.failReason = paramParcel.readInt();
      this.httpStatus = paramParcel.readInt();
      this.exception2Code = paramParcel.readInt();
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final Throwable getFailException()
    {
      if (isFailed()) {
        return this.failException;
      }
      return null;
    }
    
    public final int getFailReason()
    {
      if (isFailed()) {
        return this.failReason;
      }
      return 0;
    }
    
    public final boolean isFailed()
    {
      return this.state == 2;
    }
    
    public final boolean isRetrying()
    {
      return this.state == 3;
    }
    
    public final boolean isSucceed()
    {
      return this.state == 1;
    }
    
    public final void reset()
    {
      this.state = 2;
      this.failReason = 1;
      this.failException = null;
      this.exception2Code = 0;
      this.httpStatus = 0;
    }
    
    public final void setFailed(int paramInt)
    {
      this.state = 2;
      this.failReason = paramInt;
    }
    
    public final void setFailed(Throwable paramThrowable)
    {
      this.state = 2;
      this.failReason = 4;
      this.failException = paramThrowable;
      this.exception2Code = ImageDownloadReporter.getRetCodeFrom(this.failException, 0);
    }
    
    public final void setSucceed()
    {
      this.state = 1;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeInt(this.state);
      paramParcel.writeInt(this.failReason);
      paramParcel.writeInt(this.httpStatus);
      paramParcel.writeInt(this.exception2Code);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\DownloadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */