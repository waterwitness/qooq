import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TroopAdmin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mwe
  implements Parcelable.Creator
{
  public mwe()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopMemberListActivity.TroopAdmin a(Parcel paramParcel)
  {
    return new TroopMemberListActivity.TroopAdmin(paramParcel, null);
  }
  
  public TroopMemberListActivity.TroopAdmin[] a(int paramInt)
  {
    return new TroopMemberListActivity.TroopAdmin[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */