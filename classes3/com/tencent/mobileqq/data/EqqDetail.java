package com.tencent.mobileqq.data;

import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.EqqAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EqqDetail
  extends Entity
{
  public byte[] accountData;
  public String address;
  @notColumn
  public String certifiedDescription;
  public int certifiedGrade;
  public String displayNumber;
  public long eqqAccountFlag;
  public int followType;
  public List groupInfoList;
  public boolean isConfirmed;
  public boolean isRecvMsg;
  public String latitude;
  public String longitude;
  public boolean mIsAgreeSyncLbs;
  public boolean mIsSyncLbs;
  public boolean mIsSyncLbsSelected;
  public int mShowMsgFlag;
  public String name;
  public String phoneNumber;
  public String realSummary;
  public int seqno;
  public String summary;
  @unique
  public String uin;
  
  public EqqDetail()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = "公众帐号";
    this.summary = "挺好的";
    this.realSummary = "";
    this.displayNumber = "";
    this.latitude = "";
    this.longitude = "";
    this.phoneNumber = "";
    this.address = "";
    this.mShowMsgFlag = -1;
    this.certifiedDescription = "腾讯认证公众号";
  }
  
  public EqqDetail(mobileqq_mp.GetEqqAccountDetailInfoResponse paramGetEqqAccountDetailInfoResponse)
  {
    this.name = "公众帐号";
    this.summary = "挺好的";
    this.realSummary = "";
    this.displayNumber = "";
    this.latitude = "";
    this.longitude = "";
    this.phoneNumber = "";
    this.address = "";
    this.mShowMsgFlag = -1;
    this.certifiedDescription = "腾讯认证公众号";
    Object localObject = (mobileqq_mp.EqqAccountInfo)paramGetEqqAccountDetailInfoResponse.accountInfo.get();
    this.uin = ("" + (((mobileqq_mp.EqqAccountInfo)localObject).uin.get() & 0xFFFFFFFF));
    this.seqno = paramGetEqqAccountDetailInfoResponse.seqno.get();
    this.name = ((mobileqq_mp.EqqAccountInfo)localObject).name.get();
    this.summary = ((mobileqq_mp.EqqAccountInfo)localObject).summary.get();
    this.realSummary = paramGetEqqAccountDetailInfoResponse.introduce.get();
    this.isRecvMsg = paramGetEqqAccountDetailInfoResponse.is_recv_msg.get();
    this.groupInfoList = paramGetEqqAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetEqqAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = ((mobileqq_mp.EqqAccountInfo)localObject).display_number.get();
    this.phoneNumber = paramGetEqqAccountDetailInfoResponse.phone_number.get();
    this.certifiedGrade = ((mobileqq_mp.EqqAccountInfo)localObject).certified_grade.get();
    long l;
    int i;
    int j;
    label343:
    int n;
    int k;
    if (((mobileqq_mp.EqqAccountInfo)localObject).account_flag.has())
    {
      l = ((mobileqq_mp.EqqAccountInfo)localObject).account_flag.get();
      this.eqqAccountFlag = l;
      this.latitude = paramGetEqqAccountDetailInfoResponse.lat.get();
      this.longitude = paramGetEqqAccountDetailInfoResponse.lng.get();
      this.address = paramGetEqqAccountDetailInfoResponse.address.get();
      this.accountData = paramGetEqqAccountDetailInfoResponse.toByteArray();
      this.mShowMsgFlag = -1;
      if ((!paramGetEqqAccountDetailInfoResponse.config_group_info.has()) || (paramGetEqqAccountDetailInfoResponse.config_group_info.isEmpty())) {
        break label760;
      }
      paramGetEqqAccountDetailInfoResponse = paramGetEqqAccountDetailInfoResponse.config_group_info.get();
      if ((paramGetEqqAccountDetailInfoResponse == null) || (paramGetEqqAccountDetailInfoResponse.size() <= 0)) {
        break label760;
      }
      paramGetEqqAccountDetailInfoResponse = paramGetEqqAccountDetailInfoResponse.iterator();
      i = 0;
      j = 0;
      if (!paramGetEqqAccountDetailInfoResponse.hasNext()) {
        break label757;
      }
      localObject = (mobileqq_mp.ConfigGroupInfo)paramGetEqqAccountDetailInfoResponse.next();
      n = i;
      k = j;
      if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has()) {
        break label746;
      }
      n = i;
      k = j;
      if (((mobileqq_mp.ConfigGroupInfo)localObject).config_info.isEmpty()) {
        break label746;
      }
      localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
      int m = j;
      j = i;
      label475:
      label632:
      do
      {
        do
        {
          n = j;
          k = m;
          if (!((Iterator)localObject).hasNext()) {
            break label746;
          }
          mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
          k = m;
          if (localConfigInfo.state_id.get() == 5)
          {
            if (localConfigInfo.state.get() != 1) {
              break;
            }
            i = 1;
            this.mShowMsgFlag = i;
            k = 1;
          }
          i = j;
          if (localConfigInfo.type.has())
          {
            i = j;
            if (localConfigInfo.type.get() == 2)
            {
              i = j;
              if (localConfigInfo.state_id.has())
              {
                i = j;
                if (localConfigInfo.state_id.get() == 3)
                {
                  this.mIsSyncLbs = true;
                  if (!localConfigInfo.state.has()) {}
                }
              }
            }
          }
          switch (localConfigInfo.state.get())
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + localConfigInfo.state.get());
            }
            i = 1;
            j = i;
            m = k;
          }
        } while (k == 0);
        j = i;
        m = k;
      } while (i == 0);
      j = k;
      label662:
      if ((j == 0) || (i == 0)) {
        break label743;
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.mIsSyncLbs = false;
      }
      return;
      l = 0L;
      break;
      i = 0;
      break label475;
      this.mIsSyncLbsSelected = false;
      this.mIsAgreeSyncLbs = false;
      i = 1;
      break label632;
      this.mIsSyncLbsSelected = true;
      this.mIsAgreeSyncLbs = true;
      i = 1;
      break label632;
      this.mIsSyncLbsSelected = true;
      this.mIsAgreeSyncLbs = false;
      i = 1;
      break label632;
      label743:
      break label343;
      label746:
      i = n;
      j = k;
      break label662;
      label757:
      continue;
      label760:
      i = 0;
    }
  }
  
  public void clone(EqqDetail paramEqqDetail)
  {
    this.uin = paramEqqDetail.uin;
    this.seqno = paramEqqDetail.seqno;
    this.name = paramEqqDetail.name;
    this.summary = paramEqqDetail.summary;
    this.realSummary = paramEqqDetail.realSummary;
    this.isRecvMsg = paramEqqDetail.isRecvMsg;
    this.followType = paramEqqDetail.followType;
    this.latitude = paramEqqDetail.latitude;
    this.longitude = paramEqqDetail.longitude;
    this.accountData = paramEqqDetail.accountData;
    this.groupInfoList = paramEqqDetail.groupInfoList;
    this.displayNumber = paramEqqDetail.displayNumber;
    this.certifiedGrade = paramEqqDetail.certifiedGrade;
    this.address = paramEqqDetail.address;
    this.phoneNumber = paramEqqDetail.phoneNumber;
    this.mShowMsgFlag = paramEqqDetail.mShowMsgFlag;
    this.mIsSyncLbs = paramEqqDetail.mIsSyncLbs;
    this.mIsAgreeSyncLbs = paramEqqDetail.mIsAgreeSyncLbs;
    this.mIsSyncLbsSelected = paramEqqDetail.mIsSyncLbsSelected;
  }
  
  public boolean hasIvrAbility()
  {
    if (!CrmUtils.a) {
      if (QLog.isDevelopLevel()) {
        QLog.d("EqqDetail", 4, "Don't support sharp");
      }
    }
    while ((this.eqqAccountFlag & 0x100) != 256L) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\EqqDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */