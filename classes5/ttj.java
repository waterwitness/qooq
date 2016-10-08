import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.ReportInfo;

public final class ttj
  implements Parcelable.Creator
{
  public ttj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReportInfo a(Parcel paramParcel)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.e = paramParcel.readInt();
    localReportInfo.f = paramParcel.readInt();
    localReportInfo.g = paramParcel.readInt();
    localReportInfo.j = paramParcel.readInt();
    localReportInfo.h = paramParcel.readInt();
    localReportInfo.i = paramParcel.readInt();
    localReportInfo.a = paramParcel.readLong();
    localReportInfo.b = paramParcel.readLong();
    localReportInfo.c = paramParcel.readLong();
    return localReportInfo;
  }
  
  public ReportInfo[] a(int paramInt)
  {
    return new ReportInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ttj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */