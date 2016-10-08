package com.tencent.qidian.data;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qidian.proto.mobileqq_qidian.ExternalInfo;
import com.tencent.qidian.proto.mobileqq_qidian.GroupItem;
import com.tencent.qidian.proto.mobileqq_qidian.PubAccItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QidianExternalInfo
  extends Entity
{
  private static final String TAG = "QidianExternalInfo";
  public long city;
  public long country;
  public long district;
  public int gender;
  public String icon;
  public byte[] infoByte;
  public int isShowCall;
  public String job;
  public List mGroupItems;
  public List mPubAccItems;
  public String mail;
  public String masterUin;
  public String mobile;
  public String nickname;
  public long province;
  public String sign;
  public String tel;
  @unique
  public String uin;
  public int verity;
  
  public QidianExternalInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uin = "";
    this.masterUin = "";
    this.nickname = "";
    this.icon = "";
    this.sign = "";
    this.job = "";
    this.tel = "";
    this.mobile = "";
    this.mail = "";
  }
  
  private void initList()
  {
    Object localObject;
    try
    {
      if (this.infoByte != null)
      {
        mobileqq_qidian.ExternalInfo localExternalInfo = new mobileqq_qidian.ExternalInfo();
        localExternalInfo.mergeFrom(this.infoByte);
        if (localExternalInfo.rpt_msg_pubacc_item.has())
        {
          this.mPubAccItems = new ArrayList();
          localObject = localExternalInfo.rpt_msg_pubacc_item.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            mobileqq_qidian.PubAccItem localPubAccItem = (mobileqq_qidian.PubAccItem)((Iterator)localObject).next();
            this.mPubAccItems.add(new PublicAccountItem(localPubAccItem));
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      if (localException.rpt_msg_group_item.has())
      {
        this.mGroupItems = new ArrayList();
        Iterator localIterator = localException.rpt_msg_group_item.get().iterator();
        while (localIterator.hasNext())
        {
          localObject = (mobileqq_qidian.GroupItem)localIterator.next();
          this.mGroupItems.add(new GroupItem((mobileqq_qidian.GroupItem)localObject));
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    paramObject = (QidianExternalInfo)paramObject;
    return Arrays.equals(this.infoByte, ((QidianExternalInfo)paramObject).infoByte);
  }
  
  public void from(mobileqq_qidian.ExternalInfo paramExternalInfo)
  {
    this.infoByte = paramExternalInfo.toByteArray();
    if (paramExternalInfo.uint64_uin.has()) {
      this.uin = String.valueOf(paramExternalInfo.uint64_uin.get());
    }
    if (paramExternalInfo.str_external_nick.has()) {
      this.nickname = paramExternalInfo.str_external_nick.get();
    }
    if (paramExternalInfo.str_external_icon.has()) {
      this.icon = paramExternalInfo.str_external_icon.get();
    }
    if (paramExternalInfo.str_external_sign.has()) {
      this.sign = paramExternalInfo.str_external_sign.get();
    }
    if (paramExternalInfo.uint32_external_gender.has()) {
      this.gender = paramExternalInfo.uint32_external_gender.get();
    }
    if (paramExternalInfo.uint64_external_country.has()) {
      this.country = paramExternalInfo.uint64_external_country.get();
    }
    if (paramExternalInfo.uint64_external_province.has()) {
      this.province = paramExternalInfo.uint64_external_province.get();
    }
    if (paramExternalInfo.uint64_external_city.has()) {
      this.city = paramExternalInfo.uint64_external_city.get();
    }
    if (paramExternalInfo.uint64_external_district.has()) {
      this.district = paramExternalInfo.uint64_external_district.get();
    }
    if (paramExternalInfo.str_external_job.has()) {
      this.job = paramExternalInfo.str_external_job.get();
    }
    if (paramExternalInfo.str_external_tel.has()) {
      this.tel = paramExternalInfo.str_external_tel.get();
    }
    if (paramExternalInfo.str_external_mobile.has()) {
      this.mobile = paramExternalInfo.str_external_mobile.get();
    }
    if (paramExternalInfo.str_external_mail.has()) {
      this.mail = paramExternalInfo.str_external_mail.get();
    }
    if (paramExternalInfo.uint64_master_uin.has()) {
      this.masterUin = String.valueOf(paramExternalInfo.uint64_master_uin.get());
    }
    if (paramExternalInfo.uint32_verity.has()) {
      this.verity = paramExternalInfo.uint32_verity.get();
    }
    if (paramExternalInfo.uint32_entcallshow.has()) {
      this.isShowCall = paramExternalInfo.uint32_entcallshow.get();
    }
    initList();
    if (QLog.isColorLevel()) {
      QLog.d("QidianExternalInfo", 2, "Load from server: " + toString());
    }
  }
  
  public List getGroupItems()
  {
    if (this.mGroupItems == null)
    {
      initList();
      if (this.mGroupItems == null) {
        this.mGroupItems = new ArrayList();
      }
    }
    return this.mGroupItems;
  }
  
  public List getPublicAccountItems()
  {
    if (this.mPubAccItems == null)
    {
      initList();
      if (this.mPubAccItems == null) {
        this.mPubAccItems = new ArrayList();
      }
    }
    return this.mPubAccItems;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.infoByte);
  }
  
  public mobileqq_qidian.ExternalInfo to()
  {
    mobileqq_qidian.ExternalInfo localExternalInfo = new mobileqq_qidian.ExternalInfo();
    localExternalInfo.uint64_uin.set(Long.parseLong(this.uin));
    localExternalInfo.str_external_nick.set(this.nickname);
    localExternalInfo.str_external_icon.set(this.icon);
    localExternalInfo.str_external_sign.set(this.sign);
    localExternalInfo.uint32_external_gender.set(this.gender);
    localExternalInfo.uint64_external_country.set(this.country);
    localExternalInfo.uint64_external_province.set(this.province);
    localExternalInfo.uint64_external_city.set(this.city);
    localExternalInfo.uint64_external_district.set(this.district);
    localExternalInfo.str_external_job.set(this.job);
    localExternalInfo.str_external_tel.set(this.tel);
    localExternalInfo.str_external_mobile.set(this.mobile);
    localExternalInfo.str_external_mail.set(this.mail);
    Iterator localIterator;
    Object localObject;
    if (this.mPubAccItems != null)
    {
      localIterator = this.mPubAccItems.iterator();
      while (localIterator.hasNext())
      {
        localObject = (PublicAccountItem)localIterator.next();
        localExternalInfo.rpt_msg_pubacc_item.add(((PublicAccountItem)localObject).a());
      }
    }
    if (this.mGroupItems != null)
    {
      localIterator = this.mGroupItems.iterator();
      while (localIterator.hasNext())
      {
        localObject = (GroupItem)localIterator.next();
        localExternalInfo.rpt_msg_group_item.add(((GroupItem)localObject).a());
      }
    }
    localExternalInfo.uint64_master_uin.set(Long.parseLong(this.masterUin));
    localExternalInfo.uint32_verity.set(this.verity);
    localExternalInfo.uint32_entcallshow.set(this.isShowCall);
    return localExternalInfo;
  }
  
  public void update(QidianExternalInfo paramQidianExternalInfo)
  {
    if ((paramQidianExternalInfo != null) && (this.uin.equals(paramQidianExternalInfo.uin)))
    {
      if (!TextUtils.isEmpty(paramQidianExternalInfo.masterUin)) {
        this.masterUin = paramQidianExternalInfo.masterUin;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.nickname)) {
        this.nickname = paramQidianExternalInfo.nickname;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.icon)) {
        this.icon = paramQidianExternalInfo.icon;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.sign)) {
        this.sign = paramQidianExternalInfo.sign;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.job)) {
        this.job = paramQidianExternalInfo.job;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.tel)) {
        this.tel = paramQidianExternalInfo.tel;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.mobile)) {
        this.mobile = paramQidianExternalInfo.mobile;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.mail)) {
        this.mail = paramQidianExternalInfo.mail;
      }
      if (paramQidianExternalInfo.country > 0L) {
        this.country = paramQidianExternalInfo.country;
      }
      if (paramQidianExternalInfo.province > 0L) {
        this.province = paramQidianExternalInfo.province;
      }
      if (paramQidianExternalInfo.city > 0L) {
        this.city = paramQidianExternalInfo.city;
      }
      if (paramQidianExternalInfo.district > 0L) {
        this.district = paramQidianExternalInfo.district;
      }
      this.isShowCall = paramQidianExternalInfo.isShowCall;
      if (paramQidianExternalInfo.mPubAccItems != null) {
        this.mPubAccItems = paramQidianExternalInfo.mPubAccItems;
      }
      if (paramQidianExternalInfo.mGroupItems != null) {
        this.mGroupItems = paramQidianExternalInfo.mGroupItems;
      }
      this.infoByte = to().toByteArray();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\data\QidianExternalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */