package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class QQUserUIItem
  extends BaseUIItem
  implements Copyable
{
  public String headUrl;
  public boolean isVip;
  public String nickName;
  public String remark;
  public boolean specialCare;
  public String symbolUrl;
  public long uid;
  public String unionId;
  
  public QQUserUIItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.unionId = "";
  }
  
  public QQUserUIItem(UserEntry paramUserEntry)
  {
    this.unionId = "";
    this.uid = paramUserEntry.uid;
    this.nickName = paramUserEntry.nickName;
    this.headUrl = paramUserEntry.headUrl;
    this.remark = paramUserEntry.remark;
    this.isVip = paramUserEntry.isVip;
    this.unionId = paramUserEntry.unionId;
    this.symbolUrl = paramUserEntry.symbolUrl;
  }
  
  public UserEntry convert2UserEntry()
  {
    UserEntry localUserEntry = new UserEntry();
    localUserEntry.uid = this.uid;
    localUserEntry.nickName = this.nickName;
    localUserEntry.headUrl = this.headUrl;
    localUserEntry.remark = this.remark;
    localUserEntry.isVip = this.isVip;
    localUserEntry.unionId = this.unionId;
    localUserEntry.symbolUrl = this.symbolUrl;
    return localUserEntry;
  }
  
  public void convertFrom(qqstory_struct.UserInfo paramUserInfo)
  {
    boolean bool = true;
    this.uid = paramUserInfo.uid.get();
    this.nickName = paramUserInfo.nick.get().toStringUtf8();
    this.headUrl = paramUserInfo.head_url.get().toStringUtf8();
    this.remark = paramUserInfo.remark.get().toStringUtf8();
    if (paramUserInfo.is_vip.get() == 1) {}
    for (;;)
    {
      this.isVip = bool;
      this.unionId = paramUserInfo.union_id.get().toStringUtf8();
      this.symbolUrl = paramUserInfo.symbol.get().toStringUtf8();
      return;
      bool = false;
    }
  }
  
  public void copy(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (QQUserUIItem)paramObject;
      this.uid = ((QQUserUIItem)paramObject).uid;
      if (!TextUtils.isEmpty(((QQUserUIItem)paramObject).unionId)) {
        this.unionId = ((QQUserUIItem)paramObject).unionId;
      }
      if (!TextUtils.isEmpty(((QQUserUIItem)paramObject).nickName)) {
        this.nickName = ((QQUserUIItem)paramObject).nickName;
      }
      if (!TextUtils.isEmpty(((QQUserUIItem)paramObject).headUrl)) {
        this.headUrl = ((QQUserUIItem)paramObject).headUrl;
      }
      if (!TextUtils.isEmpty(((QQUserUIItem)paramObject).remark)) {
        this.remark = ((QQUserUIItem)paramObject).remark;
      }
      if (((QQUserUIItem)paramObject).isVip == true) {
        this.isVip = true;
      }
      if (!TextUtils.isEmpty(((QQUserUIItem)paramObject).symbolUrl)) {
        this.symbolUrl = ((QQUserUIItem)paramObject).symbolUrl;
      }
    } while (!((QQUserUIItem)paramObject).specialCare);
    this.specialCare = ((QQUserUIItem)paramObject).specialCare;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (QQUserUIItem)paramObject;
    return getUnionId().equals(((QQUserUIItem)paramObject).getUnionId());
  }
  
  public String getUnionId()
  {
    if (TextUtils.isEmpty(this.unionId)) {
      return "";
    }
    return this.unionId;
  }
  
  public int hashCode()
  {
    return (int)(this.uid ^ this.uid >>> 32);
  }
  
  public void setUnionId(String paramString)
  {
    this.unionId = paramString;
  }
  
  public String toString()
  {
    return "QQUserUIItem{nickName='" + this.nickName + '\'' + ", uid=" + this.uid + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\item\QQUserUIItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */