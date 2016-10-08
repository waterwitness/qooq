package com.tencent.mobileqq.nearpeople;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import appoint.define.appoint_define.CommonLabel;
import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.InterestTag;
import appoint.define.appoint_define.RptInterestTag;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo.OneUinHeadInfo;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class EncounterHolder
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String commonComplete;
  public int commonId;
  public String commonPrefix;
  public String commonSuffix;
  public transient DynamicAvatar dynamicAvatarInfo;
  public RespEncounterInfo encounter;
  public String secondLine;
  public boolean showCommon;
  public boolean showDeclaration;
  public String thirdLine;
  
  public EncounterHolder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.secondLine = "";
    this.thirdLine = "";
    this.commonSuffix = "";
    this.commonPrefix = "";
    this.commonComplete = "";
    this.showDeclaration = true;
  }
  
  private static void a(boolean paramBoolean, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    if (paramBoolean)
    {
      if (paramStringBuilder1.length() > 0)
      {
        paramStringBuilder3.append("去过").append(paramStringBuilder1);
        if (paramStringBuilder2.length() > 0) {
          paramStringBuilder3.append("；");
        }
      }
      if (paramStringBuilder2.length() > 0) {
        paramStringBuilder3.append("喜欢").append(paramStringBuilder2);
      }
    }
    do
    {
      return;
      if (paramStringBuilder2.length() > 0)
      {
        paramStringBuilder3.append("喜欢").append(paramStringBuilder2);
        if (paramStringBuilder1.length() > 0) {
          paramStringBuilder3.append("；");
        }
      }
    } while (paramStringBuilder1.length() <= 0);
    paramStringBuilder3.append(paramStringBuilder1);
  }
  
  public static List getEncHolderOpts(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    Object localObject1;
    EncounterHolder localEncounterHolder;
    EncounterHolder.EncounterHolderOpt localEncounterHolderOpt;
    if (i < paramList.size())
    {
      localObject1 = paramList.get(i);
      if ((localObject1 instanceof EncounterHolder))
      {
        localEncounterHolder = (EncounterHolder)localObject1;
        localEncounterHolderOpt = new EncounterHolder.EncounterHolderOpt();
        localEncounterHolderOpt.jdField_a_of_type_ComTencentMobileqqNearpeopleEncounterHolder = localEncounterHolder;
        if ((localEncounterHolder.encounter.richState == null) || (localEncounterHolder.encounter.richState.vState.length <= 0)) {
          break label274;
        }
        localObject1 = RichStatus.parseStatus(localEncounterHolder.encounter.richState.vState);
        ((RichStatus)localObject1).time = localEncounterHolder.encounter.richState.uModifyTime;
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((RichStatus)localObject1).isEmpty()))
      {
        localEncounterHolderOpt.jdField_a_of_type_Int = ((RichStatus)localObject1).actionId;
        localEncounterHolderOpt.jdField_a_of_type_JavaLangString = ((RichStatus)localObject1).actionText;
        localEncounterHolderOpt.jdField_a_of_type_AndroidTextSpannableString = ((RichStatus)localObject1).toSpannableString(null);
      }
      if ((localEncounterHolder.dynamicAvatarInfo == null) && (localEncounterHolder.encounter.vDateVideoInfo != null) && (localEncounterHolder.encounter.vDateVideoInfo.length > 0)) {
        localObject1 = new oidb_0x74b.OneUinHeadInfo();
      }
      for (;;)
      {
        try
        {
          ((oidb_0x74b.OneUinHeadInfo)localObject1).mergeFrom(localEncounterHolder.encounter.vDateVideoInfo);
          localObject1 = DynamicAvatarInfo.OneUinHeadInfo.a((oidb_0x74b.OneUinHeadInfo)localObject1);
          localEncounterHolderOpt.jdField_a_of_type_ComTencentMobileqqNearpeopleEncounterHolder.dynamicAvatarInfo = DynamicAvatar.convertFrom((DynamicAvatarInfo.OneUinHeadInfo)localObject1);
          localArrayList.add(localEncounterHolderOpt);
          i += 1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          localInvalidProtocolBufferMicroException.printStackTrace();
          continue;
        }
        localArrayList.add(localInvalidProtocolBufferMicroException);
      }
      return localArrayList;
      label274:
      Object localObject2 = null;
    }
  }
  
  public static EncounterHolder getHolder(RespEncounterInfo paramRespEncounterInfo, EncounterHolder paramEncounterHolder, boolean paramBoolean, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramEncounterHolder.encounter = paramRespEncounterInfo;
    paramStringBuilder1.setLength(0);
    paramStringBuilder2.setLength(0);
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    Object localObject4;
    int i;
    boolean bool1;
    Object localObject3;
    switch (paramRespEncounterInfo.cSex)
    {
    default: 
      if (paramRespEncounterInfo.cAge > 0) {
        paramStringBuilder1.append(' ').append(paramRespEncounterInfo.cAge).append('岁');
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = new StringBuilder();
      if (paramRespEncounterInfo.vTheSameLabels == null) {
        break;
      }
    case 0: 
    case 1: 
      for (;;)
      {
        try
        {
          localObject1 = new appoint_define.CommonLabel();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          Object localObject1;
          Object localObject2 = null;
          continue;
        }
        catch (Exception localException1)
        {
          localObject3 = null;
        }
        try
        {
          ((appoint_define.CommonLabel)localObject1).mergeFrom(paramRespEncounterInfo.vTheSameLabels);
          if ((localObject1 == null) || (!((appoint_define.CommonLabel)localObject1).uint32_lable_id.has()) || (((appoint_define.CommonLabel)localObject1).uint32_lable_id.get() <= 0)) {
            break label508;
          }
          if (((appoint_define.CommonLabel)localObject1).uint32_lable_id.get() != 5) {
            break label850;
          }
          if ((paramBoolean) || (!((appoint_define.CommonLabel)localObject1).rpt_interst_name.has()) || (!((appoint_define.CommonLabel)localObject1).rpt_interst_type.has())) {
            break label508;
          }
          paramEncounterHolder.showDeclaration = false;
          paramStringBuilder2.append("共同爱好：");
          localObject4 = ((appoint_define.CommonLabel)localObject1).rpt_interst_name.get();
          localObject1 = ((appoint_define.CommonLabel)localObject1).rpt_interst_type.get();
          paramBoolean = false;
          i = 0;
          if (i >= ((List)localObject4).size()) {
            break label498;
          }
          bool1 = paramBoolean;
          if (i == 0)
          {
            bool1 = paramBoolean;
            if (((Integer)((List)localObject1).get(0)).intValue() == 1) {
              bool1 = true;
            }
          }
          if (((Integer)((List)localObject1).get(i)).intValue() != 1) {
            break label366;
          }
          if (localStringBuilder1.length() > 0) {
            localStringBuilder1.append("、");
          }
          localStringBuilder1.append(((ByteStringMicro)((List)localObject4).get(i)).toStringUtf8());
          i += 1;
          paramBoolean = bool1;
          continue;
          paramStringBuilder1.append("男");
        }
        catch (Exception localException3)
        {
          String str;
          for (;;) {}
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
        {
          continue;
        }
        paramStringBuilder1.append("女");
        break;
        continue;
        label366:
        if (((Integer)((List)localObject3).get(i)).intValue() == 2)
        {
          if (localStringBuilder2.length() > 0) {
            localStringBuilder2.append("、");
          }
          str = ((ByteStringMicro)((List)localObject4).get(i)).toStringUtf8();
          if (str.startsWith("爱")) {
            localStringBuilder2.append(str.substring("爱".length()));
          } else {
            localStringBuilder2.append(str);
          }
        }
        else
        {
          if (localStringBuilder2.length() > 0) {
            localStringBuilder2.append("、");
          }
          localStringBuilder2.append(((ByteStringMicro)((List)localObject4).get(i)).toStringUtf8());
        }
      }
      label498:
      a(paramBoolean, localStringBuilder1, localStringBuilder2, paramStringBuilder2);
    }
    for (;;)
    {
      label508:
      if (paramRespEncounterInfo.constellation != 0)
      {
        localObject3 = ProfileCardUtil.a(paramRespEncounterInfo.constellation);
        if (!paramEncounterHolder.showCommon) {
          paramStringBuilder1.append(' ').append((String)localObject3);
        }
      }
      label559:
      boolean bool2;
      if ((paramRespEncounterInfo.profession_id <= 0) || (paramRespEncounterInfo.profession_id >= 14))
      {
        paramEncounterHolder.secondLine = paramStringBuilder1.toString();
        if (paramStringBuilder2.length() != 0) {
          break label1104;
        }
        bool2 = false;
        paramBoolean = false;
        localStringBuilder1.setLength(0);
        localStringBuilder2.setLength(0);
        bool1 = bool2;
        if (paramRespEncounterInfo.vInterestInfo == null) {
          break label1093;
        }
        paramStringBuilder1 = new appoint_define.RptInterestTag();
      }
      try
      {
        paramStringBuilder1.mergeFrom(paramRespEncounterInfo.vInterestInfo);
        paramStringBuilder1 = paramStringBuilder1.rpt_interest_tags.get();
        bool1 = bool2;
        if (paramStringBuilder1 != null)
        {
          bool1 = bool2;
          if (paramStringBuilder1.size() > 0)
          {
            if (1 == ((appoint_define.InterestTag)paramStringBuilder1.get(0)).uint32_tag_type.get()) {
              paramBoolean = true;
            }
            i = 0;
            for (;;)
            {
              bool1 = paramBoolean;
              if (i >= paramStringBuilder1.size()) {
                break label1093;
              }
              localObject3 = (appoint_define.InterestTag)paramStringBuilder1.get(i);
              if ((((appoint_define.InterestTag)localObject3).uint32_tag_type.has()) && (((appoint_define.InterestTag)localObject3).rpt_msg_tag_list.has()))
              {
                int k = ((appoint_define.InterestTag)localObject3).uint32_tag_type.get();
                if ((k >= 1) && (k <= 7))
                {
                  localObject3 = ((appoint_define.InterestTag)localObject3).rpt_msg_tag_list.get();
                  if (((List)localObject3).size() > 0)
                  {
                    paramEncounterHolder.showDeclaration = false;
                    int m = ((List)localObject3).size();
                    int j = 0;
                    label783:
                    if (j < m)
                    {
                      localObject4 = (appoint_define.InterestItem)((List)localObject3).get(j);
                      if (1 == k)
                      {
                        if (localStringBuilder1.length() > 0) {
                          localStringBuilder1.append('、');
                        }
                        localStringBuilder1.append(((appoint_define.InterestItem)localObject4).str_tag_name.get());
                      }
                      for (;;)
                      {
                        j += 1;
                        break label783;
                        label850:
                        paramEncounterHolder.showCommon = true;
                        if (((appoint_define.CommonLabel)localObject3).bytes_lable_msg_pre.has())
                        {
                          localObject4 = new String(((appoint_define.CommonLabel)localObject3).bytes_lable_msg_pre.get().toByteArray());
                          label886:
                          paramEncounterHolder.commonPrefix = ((String)localObject4);
                          if (!((appoint_define.CommonLabel)localObject3).bytes_lable_msg_pre.has()) {
                            break label979;
                          }
                        }
                        label979:
                        for (localObject4 = new String(((appoint_define.CommonLabel)localObject3).bytes_lable_msg_last.get().toByteArray());; localObject4 = "")
                        {
                          paramEncounterHolder.commonSuffix = ((String)localObject4);
                          paramEncounterHolder.commonComplete = (paramEncounterHolder.commonPrefix + paramEncounterHolder.commonSuffix);
                          paramEncounterHolder.commonId = ((appoint_define.CommonLabel)localObject3).uint32_lable_id.get();
                          break;
                          localObject4 = "";
                          break label886;
                        }
                        localObject3 = com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRespEncounterInfo.profession_id];
                        paramStringBuilder1.append(' ').append((String)localObject3);
                        break label559;
                        if (localStringBuilder2.length() > 0) {
                          localStringBuilder2.append('、');
                        }
                        localObject4 = ((appoint_define.InterestItem)localObject4).str_tag_name.get();
                        if (localObject4 != null) {
                          if (((String)localObject4).startsWith("爱吃")) {
                            localStringBuilder2.append(((String)localObject4).substring("爱".length()));
                          } else {
                            localStringBuilder2.append((String)localObject4);
                          }
                        }
                      }
                    }
                  }
                }
              }
              i += 1;
            }
          }
        }
        label1093:
        a(bool1, localStringBuilder1, localStringBuilder2, paramStringBuilder2);
        label1104:
        paramEncounterHolder.thirdLine = paramStringBuilder2.toString();
        if (paramRespEncounterInfo.vDateVideoInfo != null) {
          paramStringBuilder1 = new oidb_0x74b.OneUinHeadInfo();
        }
        try
        {
          paramStringBuilder1.mergeFrom(paramRespEncounterInfo.vDateVideoInfo);
          paramEncounterHolder.dynamicAvatarInfo = DynamicAvatar.convertFrom(DynamicAvatarInfo.OneUinHeadInfo.a(paramStringBuilder1));
          return paramEncounterHolder;
        }
        catch (InvalidProtocolBufferMicroException paramRespEncounterInfo)
        {
          while (!QLog.isDevelopLevel()) {}
          paramRespEncounterInfo.printStackTrace();
          return paramEncounterHolder;
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        for (;;) {}
      }
    }
  }
  
  public static List getHolders(List paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      EncounterHolder localEncounterHolder = new EncounterHolder();
      getHolder((RespEncounterInfo)paramList.get(i), localEncounterHolder, paramBoolean, localStringBuilder1, localStringBuilder2);
      localArrayList.add(localEncounterHolder);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearpeople\EncounterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */