package com.tencent.mobileqq.data;

import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
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
import org.json.JSONObject;

public class AccountDetail
  extends Entity
{
  public byte[] accountData;
  public int accountFlag;
  public long accountFlag2;
  public String certifiedDescription;
  @notColumn
  public String certifiedEnterprise;
  public int certifiedGrade;
  @notColumn
  public String certifiedWeixin;
  public String configBackgroundColor;
  @notColumn
  public String configBackgroundImg;
  public String displayNumber;
  public int followType;
  public int groupId;
  public List groupInfoList;
  public boolean isAgreeSyncLbs;
  public boolean isConfirmed;
  public boolean isRecvMsg;
  public boolean isRecvPush;
  public boolean isShowFollowButton;
  public boolean isShowShareButton;
  public boolean isSyncLbs;
  public boolean isSyncLbsSelected;
  public String lastHistoryMsg;
  public int mShowMsgFlag;
  public String name;
  public List newGroupInfoList;
  @notColumn
  public List paConfigAttrs;
  public int seqno;
  public int showFlag;
  public String summary;
  @unique
  public String uin;
  @notColumn
  public String unifiedDesrpition;
  
  public AccountDetail()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = "公众帐号";
    this.summary = "挺好的";
    this.displayNumber = "";
    this.mShowMsgFlag = -1;
    this.configBackgroundColor = "3d7fe3";
    this.certifiedDescription = "";
    this.configBackgroundImg = "";
    this.certifiedEnterprise = "";
    this.certifiedWeixin = "";
  }
  
  public AccountDetail(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    this.name = "公众帐号";
    this.summary = "挺好的";
    this.displayNumber = "";
    this.mShowMsgFlag = -1;
    this.configBackgroundColor = "3d7fe3";
    this.certifiedDescription = "";
    this.configBackgroundImg = "";
    this.certifiedEnterprise = "";
    this.certifiedWeixin = "";
    this.uin = ("" + (paramGetPublicAccountDetailInfoResponse.uin.get() & 0xFFFFFFFF));
    this.seqno = paramGetPublicAccountDetailInfoResponse.seqno.get();
    this.name = paramGetPublicAccountDetailInfoResponse.name.get();
    this.summary = paramGetPublicAccountDetailInfoResponse.summary.get();
    this.isRecvMsg = paramGetPublicAccountDetailInfoResponse.is_recv_msg.get();
    this.isShowFollowButton = paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get();
    this.isShowShareButton = paramGetPublicAccountDetailInfoResponse.is_show_share_button.get();
    this.groupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetPublicAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = paramGetPublicAccountDetailInfoResponse.display_number.get();
    this.groupId = paramGetPublicAccountDetailInfoResponse.group_id.get();
    this.isRecvPush = paramGetPublicAccountDetailInfoResponse.is_recv_push.get();
    this.certifiedGrade = paramGetPublicAccountDetailInfoResponse.certified_grade.get();
    this.showFlag = paramGetPublicAccountDetailInfoResponse.show_flag.get();
    this.accountFlag = paramGetPublicAccountDetailInfoResponse.account_flag.get();
    this.accountFlag2 = paramGetPublicAccountDetailInfoResponse.account_flag2.get();
    this.accountData = paramGetPublicAccountDetailInfoResponse.toByteArray();
    this.configBackgroundColor = paramGetPublicAccountDetailInfoResponse.config_background_color.get();
    this.configBackgroundImg = paramGetPublicAccountDetailInfoResponse.config_background_img.get();
    this.newGroupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
    this.certifiedDescription = paramGetPublicAccountDetailInfoResponse.certified_description.get();
    if (paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.has()) {
      this.unifiedDesrpition = paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get();
    }
    parser();
    this.mShowMsgFlag = -1;
    if (this.unifiedDesrpition != null)
    {
      initShowMsgFlag_v5_9();
      initLbsItem_v5_9();
      return;
    }
    initShowMsgFlag(paramGetPublicAccountDetailInfoResponse);
    initLbsItem(paramGetPublicAccountDetailInfoResponse);
  }
  
  public void clone(AccountDetail paramAccountDetail)
  {
    this.uin = paramAccountDetail.uin;
    this.seqno = paramAccountDetail.seqno;
    this.name = paramAccountDetail.name;
    this.summary = paramAccountDetail.summary;
    this.isRecvMsg = paramAccountDetail.isRecvMsg;
    this.followType = paramAccountDetail.followType;
    this.isShowFollowButton = paramAccountDetail.isShowFollowButton;
    this.accountData = paramAccountDetail.accountData;
    this.groupInfoList = paramAccountDetail.groupInfoList;
    this.displayNumber = paramAccountDetail.displayNumber;
    this.groupId = paramAccountDetail.groupId;
    this.isRecvPush = paramAccountDetail.isRecvPush;
    this.isSyncLbs = paramAccountDetail.isSyncLbs;
    this.certifiedGrade = paramAccountDetail.certifiedGrade;
    this.showFlag = paramAccountDetail.showFlag;
    this.accountFlag = paramAccountDetail.accountFlag;
    this.accountFlag2 = paramAccountDetail.accountFlag2;
    this.mShowMsgFlag = paramAccountDetail.mShowMsgFlag;
    this.configBackgroundColor = paramAccountDetail.configBackgroundColor;
    this.configBackgroundImg = paramAccountDetail.configBackgroundImg;
    this.newGroupInfoList = paramAccountDetail.newGroupInfoList;
    this.certifiedDescription = paramAccountDetail.certifiedDescription;
    this.isAgreeSyncLbs = paramAccountDetail.isAgreeSyncLbs;
    this.isSyncLbsSelected = paramAccountDetail.isSyncLbsSelected;
    this.unifiedDesrpition = paramAccountDetail.unifiedDesrpition;
    this.paConfigAttrs = paramAccountDetail.paConfigAttrs;
  }
  
  void initLbsItem(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    int i;
    int k;
    if ((paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) && (!paramGetPublicAccountDetailInfoResponse.config_group_info_new.isEmpty()))
    {
      paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
      if ((paramGetPublicAccountDetailInfoResponse != null) && (paramGetPublicAccountDetailInfoResponse.size() > 0))
      {
        paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.iterator();
        i = 0;
        if (paramGetPublicAccountDetailInfoResponse.hasNext())
        {
          Object localObject = (mobileqq_mp.ConfigGroupInfo)paramGetPublicAccountDetailInfoResponse.next();
          k = i;
          if (((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has())
          {
            k = i;
            if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.isEmpty())
            {
              localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
              int j = i;
              label286:
              do
              {
                k = j;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
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
                        this.isSyncLbs = true;
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
                }
              } while (i == 0);
              label295:
              if (i == 0) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.isSyncLbs = false;
      }
      return;
      this.isSyncLbsSelected = false;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label286;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = true;
      i = 1;
      break label286;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label286;
      break;
      i = k;
      break label295;
      continue;
      i = 0;
    }
  }
  
  void initLbsItem_v5_9()
  {
    if (this.paConfigAttrs == null) {
      return;
    }
    Iterator localIterator = this.paConfigAttrs.iterator();
    int i = 0;
    label21:
    int j;
    while (localIterator.hasNext())
    {
      Object localObject = (PaConfigAttr)localIterator.next();
      if ((((PaConfigAttr)localObject).c != 1) && (((PaConfigAttr)localObject).a != null))
      {
        localObject = ((PaConfigAttr)localObject).a.iterator();
        j = i;
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)((Iterator)localObject).next();
            i = j;
            if (localPaConfigInfo.a == 2)
            {
              i = j;
              if (localPaConfigInfo.e == 3) {
                this.isSyncLbs = true;
              }
            }
            switch (localPaConfigInfo.d)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + localPaConfigInfo.d);
              }
              i = 1;
              label187:
              j = i;
              if (i != 0) {
                label196:
                if (i == 0) {}
              }
              break;
            }
          }
        }
      }
    }
    while (i == 0)
    {
      this.isSyncLbs = false;
      return;
      this.isSyncLbsSelected = false;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label187;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = true;
      i = 1;
      break label187;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label187;
      break label21;
      i = j;
      break label196;
    }
  }
  
  void initShowMsgFlag(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    if (paramGetPublicAccountDetailInfoResponse.config_group_info.has()) {
      parserMsgFlag(paramGetPublicAccountDetailInfoResponse.config_group_info.get());
    }
    if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) {
      parserMsgFlag(paramGetPublicAccountDetailInfoResponse.config_group_info_new.get());
    }
  }
  
  void initShowMsgFlag_v5_9()
  {
    if (this.paConfigAttrs == null) {}
    label21:
    label103:
    label127:
    for (;;)
    {
      return;
      Iterator localIterator = this.paConfigAttrs.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = (PaConfigAttr)localIterator.next();
        if ((((PaConfigAttr)localObject).c != 1) && (((PaConfigAttr)localObject).a != null))
        {
          localObject = ((PaConfigAttr)localObject).a.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)((Iterator)localObject).next();
              if (localPaConfigInfo.e == 5) {
                if (localPaConfigInfo.d == 1)
                {
                  i = 1;
                  this.mShowMsgFlag = i;
                  i = 1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label127;
        }
        break label21;
        break;
        i = 0;
        break label103;
      }
    }
  }
  
  public void parser()
  {
    if (this.unifiedDesrpition == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.unifiedDesrpition);
      this.certifiedDescription = localJSONObject.optString("certified_description");
      this.configBackgroundColor = localJSONObject.optString("background_color");
      this.certifiedEnterprise = localJSONObject.optString("certified_enterprise");
      this.certifiedWeixin = localJSONObject.optString("certified_weixin");
      this.paConfigAttrs = PaConfigAttr.a(localJSONObject.optJSONArray("config_arr"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void parserMsgFlag(List paramList)
  {
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (mobileqq_mp.ConfigGroupInfo)paramList.next();
        if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has()) {
          break label133;
        }
        localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
            if (localConfigInfo.state_id.get() == 5) {
              if (localConfigInfo.state.get() == 1)
              {
                i = 1;
                label109:
                this.mShowMsgFlag = i;
                i = 1;
              }
            }
          }
        }
      }
    }
    label133:
    for (;;)
    {
      if (i != 0)
      {
        return;
        i = 0;
        break label109;
      }
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\AccountDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */