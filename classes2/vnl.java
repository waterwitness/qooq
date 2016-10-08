import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;

public final class vnl
  implements Parcelable.Creator
{
  public vnl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopTopicDetailInfo a(Parcel paramParcel)
  {
    TroopTopicDetailInfo localTroopTopicDetailInfo = new TroopTopicDetailInfo();
    localTroopTopicDetailInfo.troopUin = paramParcel.readString();
    localTroopTopicDetailInfo.msgSeq = paramParcel.readLong();
    localTroopTopicDetailInfo.bid = paramParcel.readLong();
    localTroopTopicDetailInfo.pid = paramParcel.readString();
    paramParcel.readByteArray(localTroopTopicDetailInfo.detailInfoData);
    if ((localTroopTopicDetailInfo.detailInfoData != null) && (localTroopTopicDetailInfo.detailInfoData.length > 0)) {
      localTroopTopicDetailInfo.detailStructMsg = StructMsgFactory.a(localTroopTopicDetailInfo.detailInfoData, 0);
    }
    localTroopTopicDetailInfo.pVersion = paramParcel.readLong();
    return localTroopTopicDetailInfo;
  }
  
  public TroopTopicDetailInfo[] a(int paramInt)
  {
    return new TroopTopicDetailInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vnl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */