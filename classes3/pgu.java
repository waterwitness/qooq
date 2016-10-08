import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class pgu
  implements Parcelable.Creator
{
  public pgu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ResultRecord a(Parcel paramParcel)
  {
    return new ResultRecord(paramParcel, null);
  }
  
  public ResultRecord[] a(int paramInt)
  {
    return new ResultRecord[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */