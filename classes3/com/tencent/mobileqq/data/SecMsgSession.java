package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_IDMap;
import java.util.Iterator;
import java.util.List;
import rcj;

public class SecMsgSession
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new rcj();
  public long activeTime;
  public boolean complete;
  public long createTime;
  public long creatorSuid;
  @unique
  public String id;
  public boolean isOpen;
  @notColumn
  public boolean isShield;
  public boolean localDeleted;
  @notColumn
  public long localSeq;
  @notColumn
  public int msgCount;
  public long mySuid;
  public long paperId;
  @notColumn
  public String receiverName;
  public String receiverUin;
  public String subject;
  public int unreadCount;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SecMsgSession() {}
  
  private SecMsgSession(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.creatorSuid = paramParcel.readLong();
    this.mySuid = paramParcel.readLong();
    this.subject = paramParcel.readString();
    this.paperId = paramParcel.readLong();
    this.createTime = paramParcel.readLong();
    this.activeTime = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SecMsgSession)paramObject;
    return this.id.equals(((SecMsgSession)paramObject).id);
  }
  
  public String getReceiverName(QQAppInterface paramQQAppInterface)
  {
    if ((!isCreator()) || (paramQQAppInterface == null)) {
      return null;
    }
    if (this.receiverName == null) {
      this.receiverName = ContactUtils.a(paramQQAppInterface, this.receiverUin);
    }
    return this.receiverName;
  }
  
  public boolean isCreator()
  {
    return this.creatorSuid == this.mySuid;
  }
  
  public void resolveReceiverUin(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SecMsgComu.SecMsg_IDMap localSecMsg_IDMap = (SecMsgComu.SecMsg_IDMap)paramList.next();
        if ((localSecMsg_IDMap != null) && (localSecMsg_IDMap.suid.get() != this.mySuid)) {
          this.receiverUin = String.valueOf(localSecMsg_IDMap.uin.get());
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeLong(this.creatorSuid);
    paramParcel.writeLong(this.mySuid);
    paramParcel.writeString(this.subject);
    paramParcel.writeLong(this.paperId);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeLong(this.activeTime);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\SecMsgSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */