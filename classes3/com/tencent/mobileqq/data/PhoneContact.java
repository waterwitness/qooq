package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

public class PhoneContact
  extends Entity
  implements Cloneable
{
  public int ability;
  public long abilityBits;
  public long bindingDate;
  public int contactID;
  public byte detalStatusFlag;
  public int eNetworkType;
  public String faceUrl;
  public boolean hasSendAddReq;
  public long highLightTimeStamp;
  public int iTermType;
  public boolean isHiden;
  public boolean isNewRecommend;
  public int isRecommend;
  public boolean isUploaded;
  public String label;
  @Deprecated
  public long lastScanTime;
  public String md5;
  @Deprecated
  public String mobileCode;
  @unique
  public String mobileNo;
  public String name;
  @Deprecated
  public String nationCode;
  @notColumn
  public int netTypeIconId;
  @notColumn
  public int netTypeIconIdIphoneOrWphoneNoWifi;
  public String nickName;
  @Deprecated
  public long originBinder;
  public String pinyinAll;
  @notColumn
  public String pinyinFirst;
  public String pinyinInitial;
  public String remark;
  public byte[] richBuffer;
  @notColumn
  private RichStatus richStatus;
  public long richTime;
  public int sortWeight;
  @notColumn
  public String strTermDesc;
  public int type;
  public String uin;
  public String unifiedCode;
  
  public PhoneContact()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.netTypeIconIdIphoneOrWphoneNoWifi = 0;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("PhoneContact.Manager", 2, "PhoneContact clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
  
  public int getNetWorkType()
  {
    int j = 2;
    int i;
    if ((this.detalStatusFlag == -55) && ((this.iTermType == 67586) || (this.iTermType == 66566) || (this.iTermType == 72194) || (this.iTermType == 65804) || (this.iTermType == 72706)) && ((this.abilityBits & 1L) == 0L))
    {
      i = j;
      switch (this.netTypeIconIdIphoneOrWphoneNoWifi)
      {
      default: 
        i = this.netTypeIconId;
      }
    }
    OnlineStatusIconHelper localOnlineStatusIconHelper;
    do
    {
      return i;
      return 3;
      return 4;
      if (((this.detalStatusFlag == -55) && (this.iTermType == 68361) && ((this.abilityBits & 1L) == 0L)) || (this.iTermType == 68104) || (this.iTermType == 65805)) {
        return 0;
      }
      localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
      if (this.eNetworkType != 0) {
        break;
      }
      if ((this.iTermType == 69378) || (this.iTermType == 73474) || (this.iTermType == 73730)) {
        return 0;
      }
      i = j;
    } while (1 != localOnlineStatusIconHelper.a(this.iTermType, 1));
    if (1 != localOnlineStatusIconHelper.a(this.iTermType, 1)) {
      i = j;
    }
    switch (this.netTypeIconId)
    {
    case 2: 
    default: 
      return this.eNetworkType;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  public RichStatus getRichStatus()
  {
    return new RichStatus("test");
  }
  
  public RichStatus getRichStatus(boolean paramBoolean)
  {
    if (this.richStatus == null)
    {
      if (paramBoolean) {
        return RichStatus.getEmptyStatus();
      }
      this.richStatus = RichStatus.parseStatus(this.richBuffer);
    }
    return this.richStatus;
  }
  
  public void setRichBuffer(byte[] paramArrayOfByte, long paramLong)
  {
    this.richStatus = null;
    this.richBuffer = paramArrayOfByte;
    this.richTime = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\PhoneContact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */