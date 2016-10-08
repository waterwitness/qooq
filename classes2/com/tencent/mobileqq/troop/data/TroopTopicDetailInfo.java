package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import vnl;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="troopUin,msgSeq")
public class TroopTopicDetailInfo
  extends Entity
  implements Parcelable, Cloneable, Comparable
{
  public static final Parcelable.Creator CREATOR = new vnl();
  public static final String[] QUERY_TABLE_ALL_FIELDS;
  public static final String[] QUERY_TABLE_BASIC_FIELDS;
  public long bid;
  public byte[] detailInfoData;
  @notColumn
  public AbsStructMsg detailStructMsg;
  public int mCommentNum;
  public boolean mIsZan;
  public int mLikeNum;
  public long mOldVersion;
  public String mViewCommentUrl;
  public long msgSeq;
  public long pVersion;
  @unique
  public String pid;
  public String troopUin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    QUERY_TABLE_BASIC_FIELDS = new String[] { "_id", "troopUin", "msgSeq", "bid", "pid", "null as detailInfoData", "pVersion" };
    QUERY_TABLE_ALL_FIELDS = new String[] { "_id", "troopUin", "msgSeq", "bid", "pid", "detailInfoData", "pVersion" };
  }
  
  public static TroopTopicDetailInfo copyFrom(MessageForTroopTopic paramMessageForTroopTopic)
  {
    if (paramMessageForTroopTopic == null) {
      return null;
    }
    TroopTopicDetailInfo localTroopTopicDetailInfo = new TroopTopicDetailInfo();
    localTroopTopicDetailInfo.troopUin = paramMessageForTroopTopic.frienduin;
    localTroopTopicDetailInfo.msgSeq = paramMessageForTroopTopic.shmsgseq;
    localTroopTopicDetailInfo.bid = paramMessageForTroopTopic.bid;
    localTroopTopicDetailInfo.pid = paramMessageForTroopTopic.pid;
    localTroopTopicDetailInfo.pVersion = paramMessageForTroopTopic.pVersion;
    return localTroopTopicDetailInfo;
  }
  
  public int compareTo(TroopTopicDetailInfo paramTroopTopicDetailInfo)
  {
    if (this.pVersion > paramTroopTopicDetailInfo.pVersion) {
      return 1;
    }
    if (this.pVersion == paramTroopTopicDetailInfo.pVersion) {
      return 0;
    }
    return -1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof TroopTopicDetailInfo))) {}
    do
    {
      return false;
      paramObject = (TroopTopicDetailInfo)paramObject;
    } while ((!this.troopUin.equals(((TroopTopicDetailInfo)paramObject).troopUin)) || (this.msgSeq != ((TroopTopicDetailInfo)paramObject).msgSeq));
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.troopUin);
    paramParcel.writeLong(this.msgSeq);
    paramParcel.writeLong(this.bid);
    paramParcel.writeString(this.pid);
    paramParcel.writeByteArray(this.detailInfoData);
    paramParcel.writeLong(this.pVersion);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopTopicDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */