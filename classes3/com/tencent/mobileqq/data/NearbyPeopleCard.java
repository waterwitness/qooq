package com.tencent.mobileqq.data;

import GameCenter.RespLastGameInfo;
import SummaryCard.TVideoHeadInfo;
import android.text.TextUtils;
import appoint.define.appoint_define.FeedContent;
import appoint.define.appoint_define.FeedInfo;
import appoint.define.appoint_define.InterestTag;
import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardConstants;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.RspBody;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.UinHeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class NearbyPeopleCard
  extends Entity
{
  public int age;
  public short bAvailVoteCnt;
  public short bHaveVotedCnt;
  public String bVideoHeadUrl;
  public byte bVoted;
  public int birthday;
  public String busiEntry;
  public long charm;
  public int charmLevel;
  public String college;
  public long collegeId;
  public String company;
  public byte constellation;
  public int curThreshold;
  public byte[] dateInfo;
  public String distance;
  public int favoriteSource;
  public long feedPreviewTime;
  @notColumn
  public FreshNewsInfo freshNewsInfo;
  public byte gender;
  public boolean godFlag;
  public String hometownCity;
  public String hometownCountry;
  public String hometownDistrict;
  public String hometownProvice;
  @notColumn
  public HotChatInfo hotInfo;
  @notColumn
  public List interestTags;
  public boolean isPhotoUseCache;
  public int job;
  public long lastUpdateNickTime;
  public int likeCount;
  public int likeCountInc;
  public byte maritalStatus;
  public int nLastGameFlag;
  public int nextThreshold;
  public String nickname;
  public int oldPhotoCount;
  public String picInfo;
  @notColumn
  public List picList;
  public int profPercent;
  @notColumn
  public List profileBusiEntry;
  public String qzoneFeed;
  public String qzoneName;
  public String qzonePicUrl_1;
  public String qzonePicUrl_2;
  public String qzonePicUrl_3;
  public int sayHelloFlag;
  public String strFreshNewsInfo;
  public String strHotChatInfo;
  public String strProfileUrl;
  public String strVoteLimitedNotice;
  public long switchGiftVisible;
  public boolean switchHobby;
  public boolean switchQzone;
  public long tagFlag;
  public String tagInfo;
  public String timeDiff;
  public long tinyId;
  public long uRoomid;
  public long uiShowControl;
  public String uin;
  public long userFlag;
  public byte[] vCookies;
  public byte[] vGiftInfo;
  public byte[] vSeed;
  public byte[] vTempChatSig;
  public boolean videoHeadFlag;
  public byte[] xuanYan;
  
  public NearbyPeopleCard()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.gender = -1;
  }
  
  public void addOrUpdateBuisEntry(ProfileBusiEntry paramProfileBusiEntry)
  {
    int k = 0;
    if (paramProfileBusiEntry == null) {
      return;
    }
    int m = paramProfileBusiEntry.jdField_a_of_type_Int;
    if (this.profileBusiEntry == null) {
      getBusiEntrys();
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.profileBusiEntry.size())
      {
        if (((ProfileBusiEntry)this.profileBusiEntry.get(i)).jdField_a_of_type_Int == m)
        {
          j = 1;
          this.profileBusiEntry.remove(i);
          this.profileBusiEntry.add(paramProfileBusiEntry);
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        this.profileBusiEntry.add(paramProfileBusiEntry);
        return;
      }
      i += 1;
    }
  }
  
  public List getBusiEntrys()
  {
    if (this.profileBusiEntry == null)
    {
      this.profileBusiEntry = new ArrayList();
      if (TextUtils.isEmpty(this.busiEntry)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.busiEntry);
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label167;
          }
          ProfileBusiEntry localProfileBusiEntry = new ProfileBusiEntry();
          localProfileBusiEntry.jdField_a_of_type_Int = localJSONObject.getInt("nBusiEntryType");
          localProfileBusiEntry.jdField_a_of_type_JavaLangString = localJSONObject.getString("strLogoUrl");
          localProfileBusiEntry.b = localJSONObject.getString("strTitle");
          localProfileBusiEntry.c = localJSONObject.getString("strContent");
          localProfileBusiEntry.d = localJSONObject.getString("strJumpUrl");
          if (localProfileBusiEntry.a()) {
            break label167;
          }
          this.profileBusiEntry.add(localProfileBusiEntry);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        }
      }
      return this.profileBusiEntry;
      label167:
      i += 1;
    }
  }
  
  public List getQZonePhotoList()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.qzonePicUrl_1)) {
      localArrayList.add(this.qzonePicUrl_1);
    }
    if (!TextUtils.isEmpty(this.qzonePicUrl_2)) {
      localArrayList.add(this.qzonePicUrl_2);
    }
    if (!TextUtils.isEmpty(this.qzonePicUrl_3)) {
      localArrayList.add(this.qzonePicUrl_3);
    }
    return localArrayList;
  }
  
  public InterestTag getTagInfos(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 7) || (this.interestTags == null) || (this.interestTags.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.interestTags.iterator();
    while (localIterator.hasNext())
    {
      InterestTag localInterestTag = (InterestTag)localIterator.next();
      if ((localInterestTag != null) && (localInterestTag.jdField_a_of_type_Int == paramInt)) {
        return localInterestTag;
      }
    }
    return null;
  }
  
  public void getTagInfos(InterestTag[] paramArrayOfInterestTag)
  {
    if ((paramArrayOfInterestTag == null) || (paramArrayOfInterestTag.length <= 0)) {
      return;
    }
    int j = paramArrayOfInterestTag.length;
    int i = 0;
    label17:
    InterestTag localInterestTag1;
    if (i < j)
    {
      localInterestTag1 = paramArrayOfInterestTag[i];
      if (localInterestTag1 != null) {
        break label42;
      }
    }
    for (;;)
    {
      i += 1;
      break label17;
      break;
      label42:
      InterestTag localInterestTag2 = getTagInfos(localInterestTag1.jdField_a_of_type_Int);
      localInterestTag1.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((localInterestTag2 != null) && (localInterestTag2.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localInterestTag1.jdField_a_of_type_JavaUtilArrayList.addAll(localInterestTag2.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public boolean hasInterestTag()
  {
    if ((this.interestTags == null) || (this.interestTags.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.interestTags.iterator();
    while (localIterator.hasNext())
    {
      InterestTag localInterestTag = (InterestTag)localIterator.next();
      if ((localInterestTag.jdField_a_of_type_JavaUtilArrayList != null) && (!localInterestTag.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasInterestTag(int paramInt, long paramLong)
  {
    Object localObject = getTagInfos(paramInt);
    if (localObject != null)
    {
      localObject = ((InterestTag)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((InterestTagInfo)((Iterator)localObject).next()).tagId == paramLong) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasQzonePhotoUrl()
  {
    return (!StringUtil.b(this.qzonePicUrl_1)) || (!StringUtil.b(this.qzonePicUrl_2)) || (!StringUtil.b(this.qzonePicUrl_3));
  }
  
  public boolean isAuthUser()
  {
    return (this.userFlag & 0x20) != 0L;
  }
  
  public boolean isFuXiaoJin()
  {
    return (this.userFlag & 0x200) != 0L;
  }
  
  public boolean isOpenRecentPlayingGamesByNative()
  {
    return (this.nLastGameFlag & 0x2) == 2;
  }
  
  public boolean isPhotoUseCache()
  {
    return this.isPhotoUseCache;
  }
  
  protected void postRead()
  {
    super.postRead();
    if (TextUtils.isEmpty(this.tagInfo))
    {
      this.interestTags = null;
      if (TextUtils.isEmpty(this.picInfo))
      {
        this.picList = null;
        label34:
        if (!TextUtils.isEmpty(this.strFreshNewsInfo)) {
          break label182;
        }
        this.freshNewsInfo = null;
        label49:
        if (!TextUtils.isEmpty(this.strHotChatInfo)) {
          break label193;
        }
        this.hotInfo = null;
      }
    }
    else
    {
      this.interestTags = new ArrayList();
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.tagInfo);
        i = 0;
        if (i >= localJSONArray.length()) {
          break;
        }
        Object localObject = localJSONArray.getJSONObject(i);
        if (localObject == null) {
          break label202;
        }
        localObject = InterestTag.a((JSONObject)localObject);
        if (localObject == null) {
          break label202;
        }
        this.interestTags.add(localObject);
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          break;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.nearby_people_card.", 2, localException.toString());
      break;
      this.picList = PicInfo.a(this.picInfo);
      break label34;
      label182:
      updateFreshNewsInfo(this.strFreshNewsInfo);
      break label49;
      label193:
      updateHotChatInfo(this.strHotChatInfo);
      return;
      label202:
      i += 1;
    }
  }
  
  protected void prewrite()
  {
    super.prewrite();
  }
  
  public void removeBuisEntry(ProfileBusiEntry paramProfileBusiEntry)
  {
    if (paramProfileBusiEntry == null) {}
    for (;;)
    {
      return;
      int j = paramProfileBusiEntry.jdField_a_of_type_Int;
      if (this.profileBusiEntry == null) {
        getBusiEntrys();
      }
      int i = 0;
      while (i < this.profileBusiEntry.size())
      {
        if (((ProfileBusiEntry)this.profileBusiEntry.get(i)).jdField_a_of_type_Int == j)
        {
          this.profileBusiEntry.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void saveBusiEntrys(List paramList)
  {
    JSONStringer localJSONStringer = new JSONStringer();
    int i;
    if (paramList == null)
    {
      i = 0;
      if (i <= 0) {
        break label201;
      }
    }
    for (;;)
    {
      try
      {
        localJSONStringer.array();
        int j = 0;
        if (j < i)
        {
          ProfileBusiEntry localProfileBusiEntry = (ProfileBusiEntry)paramList.get(j);
          if ((localProfileBusiEntry != null) && (!localProfileBusiEntry.a())) {
            localJSONStringer.object().key("nBusiEntryType").value(localProfileBusiEntry.jdField_a_of_type_Int).key("strLogoUrl").value(localProfileBusiEntry.jdField_a_of_type_JavaLangString).key("strTitle").value(localProfileBusiEntry.b).key("strContent").value(localProfileBusiEntry.c).key("strJumpUrl").value(localProfileBusiEntry.d).endObject();
          }
          j += 1;
          continue;
          i = paramList.size();
          break;
        }
        localJSONStringer.endArray();
        this.busiEntry = localJSONStringer.toString();
      }
      catch (JSONException localJSONException)
      {
        label201:
        this.busiEntry = "";
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        continue;
      }
      if (this.profileBusiEntry != null)
      {
        this.profileBusiEntry.clear();
        if ((paramList != null) && (paramList.size() > 0)) {
          this.profileBusiEntry.addAll(paramList);
        }
      }
      return;
      this.busiEntry = "";
    }
  }
  
  public void setPhotoUseCache(long paramLong)
  {
    if ((1L & paramLong) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.isPhotoUseCache = bool;
      return;
    }
  }
  
  public boolean shouldShowHobby()
  {
    return (this.uiShowControl & 0x20) == 0L;
  }
  
  public boolean shouldShowLikeBtn()
  {
    return (this.uiShowControl & 0x4) != 0L;
  }
  
  public boolean shouldShowQzoneFeed()
  {
    return (this.uiShowControl & 1L) != 0L;
  }
  
  public List updateDisplayPicInfos(byte[] paramArrayOfByte, TVideoHeadInfo paramTVideoHeadInfo, boolean paramBoolean)
  {
    int i = -1;
    int j = i;
    Object localObject;
    if (paramTVideoHeadInfo != null)
    {
      if ((!this.videoHeadFlag) && (paramTVideoHeadInfo.iNearbyFlag == 1))
      {
        this.videoHeadFlag = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos|set videoHeadFlag true");
        }
      }
      j = i;
      if (paramTVideoHeadInfo.vMsg != null) {
        localObject = new oidb_0x74b.RspBody();
      }
    }
    for (;;)
    {
      try
      {
        ((oidb_0x74b.RspBody)localObject).mergeFrom(paramTVideoHeadInfo.vMsg);
        j = i;
        if (!((oidb_0x74b.RspBody)localObject).rpt_msg_uin_head_list.has()) {
          break label906;
        }
        paramTVideoHeadInfo = ((oidb_0x74b.OneUinHeadInfo)((oidb_0x74b.RspBody)localObject).rpt_msg_uin_head_list.get().get(0)).rpt_msg_head_list.get();
        j = i;
        if (paramTVideoHeadInfo == null) {
          break label906;
        }
        paramTVideoHeadInfo = paramTVideoHeadInfo.iterator();
        j = i;
        if (!paramTVideoHeadInfo.hasNext()) {
          break label906;
        }
        localObject = (oidb_0x74b.HeadInfo)paramTVideoHeadInfo.next();
        if (((oidb_0x74b.HeadInfo)localObject).uint32_type.get() != 17) {
          continue;
        }
        if (((oidb_0x74b.HeadInfo)localObject).uint32_id.has()) {
          i = ((oidb_0x74b.HeadInfo)localObject).uint32_id.get();
        }
        if (((oidb_0x74b.HeadInfo)localObject).rpt_videoheadlist.has())
        {
          paramTVideoHeadInfo = ((oidb_0x74b.HeadInfo)localObject).rpt_videoheadlist.get();
          j = i;
          if (paramTVideoHeadInfo == null) {
            break label906;
          }
          paramTVideoHeadInfo = paramTVideoHeadInfo.iterator();
          j = i;
          if (!paramTVideoHeadInfo.hasNext()) {
            break label906;
          }
          localObject = (oidb_0x74b.VideoHeadInfo)paramTVideoHeadInfo.next();
          if (((oidb_0x74b.VideoHeadInfo)localObject).uint32_video_size.get() != 640) {
            continue;
          }
          paramTVideoHeadInfo = ((oidb_0x74b.VideoHeadInfo)localObject).str_url.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos|basicVideoUrl: " + paramTVideoHeadInfo + " ,basicVideoId:" + i + ",videoHeadFlag:" + this.videoHeadFlag + ",isMySelf:" + paramBoolean);
          }
          if (!TextUtils.isEmpty(paramTVideoHeadInfo)) {
            this.bVideoHeadUrl = paramTVideoHeadInfo;
          }
          if (paramArrayOfByte != null) {
            continue;
          }
          return null;
        }
      }
      catch (InvalidProtocolBufferMicroException paramTVideoHeadInfo)
      {
        paramTVideoHeadInfo.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.nearby_people_card.", 2, ".onNearbyCardDownload(), parse vedio head info fail.");
        continue;
        paramTVideoHeadInfo = null;
        continue;
        paramTVideoHeadInfo = new GetPhotoList.RspBody();
        if (paramArrayOfByte != null) {}
        try
        {
          paramTVideoHeadInfo.mergeFrom(paramArrayOfByte);
          if (!paramTVideoHeadInfo.rpt_msg_uin_heads.has()) {
            continue;
          }
          paramTVideoHeadInfo = ((GetPhotoList.UinHeadInfo)paramTVideoHeadInfo.rpt_msg_uin_heads.get().get(0)).rpt_msg_headinfo.get();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("head size = ");
            if (paramTVideoHeadInfo == null)
            {
              paramArrayOfByte = "null";
              QLog.d("Q.nearby_people_card.", 2, paramArrayOfByte);
            }
          }
          else
          {
            if ((paramTVideoHeadInfo == null) || (paramTVideoHeadInfo.isEmpty())) {
              continue;
            }
            this.picList = new ArrayList();
            localObject = new JSONArray();
            int k = Math.min(18, paramTVideoHeadInfo.size());
            i = 0;
            if (i >= k) {
              continue;
            }
            GetPhotoList.HeadInfo localHeadInfo = (GetPhotoList.HeadInfo)paramTVideoHeadInfo.get(i);
            PicInfo localPicInfo = new PicInfo();
            localPicInfo.jdField_a_of_type_Int = localHeadInfo.uint32_headid.get();
            localPicInfo.jdField_a_of_type_JavaLangString = localHeadInfo.str_headurl.get();
            localPicInfo.b = (localPicInfo.jdField_a_of_type_JavaLangString + "250");
            if ((i == 0) || (paramBoolean))
            {
              if (!localHeadInfo.str_video_url.has()) {
                continue;
              }
              paramArrayOfByte = localHeadInfo.str_video_url.get();
              localPicInfo.d = paramArrayOfByte;
              if (!localHeadInfo.str_video_id.has()) {
                continue;
              }
              paramArrayOfByte = localHeadInfo.str_video_id.get();
              localPicInfo.f = paramArrayOfByte;
              if (!localHeadInfo.uint32_video_size.has()) {
                continue;
              }
              j = localHeadInfo.uint32_video_size.get();
              if (!TextUtils.isEmpty(localPicInfo.d)) {
                localPicInfo.e = DynamicAvatarDownloadManager.b(localPicInfo.d);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, videoUrlSize:" + j);
              }
            }
            this.picList.add(localPicInfo);
            paramArrayOfByte = localPicInfo.a();
            if (paramArrayOfByte != null) {
              ((JSONArray)localObject).put(paramArrayOfByte);
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, picInfo:" + localPicInfo);
            }
            i += 1;
            continue;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.nearby_people_card.", 2, ".onNearbyCardDownload(), parse head info fail.");
          continue;
          paramArrayOfByte = Integer.valueOf(paramTVideoHeadInfo.size());
          continue;
          paramArrayOfByte = null;
          continue;
          paramArrayOfByte = null;
          continue;
          j = 0;
          continue;
        }
        if (((JSONArray)localObject).length() > 0) {}
      }
      for (paramArrayOfByte = "";; paramArrayOfByte = ((JSONArray)localObject).toString())
      {
        this.picInfo = paramArrayOfByte;
        return this.picList;
      }
      label906:
      paramTVideoHeadInfo = null;
      i = j;
    }
  }
  
  public List updateEditPicInfos(byte[] paramArrayOfByte, PicInfo paramPicInfo)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return null;
      Object localObject = new UpdatePhotoList.RspBody();
      try
      {
        ((UpdatePhotoList.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (((UpdatePhotoList.RspBody)localObject).rpt_msg_headinfo.has())
        {
          paramArrayOfByte = ((UpdatePhotoList.RspBody)localObject).rpt_msg_headinfo.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.isEmpty())) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.", 2, "edit head size = " + paramArrayOfByte.size() + ",extraPicInfo:" + paramPicInfo);
          }
          this.picList = new ArrayList();
          localObject = new JSONArray();
          i = 0;
          Iterator localIterator = paramArrayOfByte.iterator();
          if (localIterator.hasNext())
          {
            UpdatePhotoList.HeadInfo localHeadInfo = (UpdatePhotoList.HeadInfo)localIterator.next();
            PicInfo localPicInfo = new PicInfo();
            if (!localHeadInfo.uint32_headid.has()) {
              break label617;
            }
            j = localHeadInfo.uint32_headid.get();
            localPicInfo.jdField_a_of_type_Int = j;
            if (!localHeadInfo.str_headurl.has()) {
              break label623;
            }
            paramArrayOfByte = localHeadInfo.str_headurl.get();
            localPicInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (TextUtils.isEmpty(localPicInfo.jdField_a_of_type_JavaLangString)) {}
            for (paramArrayOfByte = "";; paramArrayOfByte = localPicInfo.jdField_a_of_type_JavaLangString + "250")
            {
              localPicInfo.b = paramArrayOfByte;
              if ((!localHeadInfo.str_video_url.has()) || (!localHeadInfo.str_video_id.has())) {
                break;
              }
              localPicInfo.d = localHeadInfo.str_video_url.get();
              localPicInfo.e = DynamicAvatarDownloadManager.b(localPicInfo.d);
              localPicInfo.f = localHeadInfo.str_video_id.get();
              if ((paramPicInfo == null) || (paramPicInfo.jdField_a_of_type_Int != localPicInfo.jdField_a_of_type_Int) || (TextUtils.isEmpty(localPicInfo.d))) {
                break label630;
              }
              boolean bool = localPicInfo.e.equals(paramPicInfo.e);
              if (bool) {
                break label630;
              }
              try
              {
                FileUtils.d(paramPicInfo.e, localPicInfo.e);
                i = 1;
                this.picList.add(localPicInfo);
                paramArrayOfByte = localPicInfo.a();
                if (paramArrayOfByte != null) {
                  ((JSONArray)localObject).put(paramArrayOfByte);
                }
                if (!QLog.isColorLevel()) {
                  break label609;
                }
                QLog.d("Q.nearby_people_card.", 2, "picInfo = " + localPicInfo);
              }
              catch (Exception paramArrayOfByte)
              {
                if (!QLog.isColorLevel()) {
                  break label630;
                }
              }
            }
            QLog.d("Q.nearby_people_card.", 2, "copy videoHead exception:" + paramArrayOfByte.getMessage());
            break label630;
          }
          if ((!this.videoHeadFlag) && (i != 0))
          {
            this.videoHeadFlag = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby_people_card.", 2, "rsp_5ea,set videoHeadFlag true");
            }
          }
          if (((JSONArray)localObject).length() <= 0) {}
          for (paramArrayOfByte = "";; paramArrayOfByte = ((JSONArray)localObject).toString())
          {
            this.picInfo = paramArrayOfByte;
            return this.picList;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
            QLog.d("Q.nearby_people_card.", 2, "rsp_5ea" + paramArrayOfByte.toString());
          }
          this.picInfo = "";
          continue;
          continue;
          label609:
          continue;
          paramArrayOfByte = null;
          continue;
          label617:
          int j = -1;
          continue;
          label623:
          paramArrayOfByte = "";
          continue;
          label630:
          int i = 1;
        }
      }
    }
  }
  
  public void updateFreshNewsInfo(appoint_define.FeedInfo paramFeedInfo)
  {
    if (paramFeedInfo == null)
    {
      this.strFreshNewsInfo = "";
      this.freshNewsInfo = null;
      return;
    }
    if (paramFeedInfo.msg_feed_content.has()) {}
    for (paramFeedInfo = (appoint_define.FeedContent)paramFeedInfo.msg_feed_content.get(); paramFeedInfo == null; paramFeedInfo = null)
    {
      this.strFreshNewsInfo = "";
      this.freshNewsInfo = null;
      return;
    }
    this.strFreshNewsInfo = "";
    this.freshNewsInfo = new FreshNewsInfo();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int j;
      int i;
      try
      {
        String str1;
        if (paramFeedInfo.msg_text.has())
        {
          str1 = FreshNewsUtil.a((appoint_define.RichText)paramFeedInfo.msg_text.get());
          if (!TextUtils.isEmpty(str1))
          {
            localJSONObject.put("feedContent", str1);
            this.freshNewsInfo.feedContent = str1;
          }
        }
        if (paramFeedInfo.rpt_str_pic_url.has())
        {
          paramFeedInfo = paramFeedInfo.rpt_str_pic_url.get();
          if ((paramFeedInfo != null) && (!paramFeedInfo.isEmpty()))
          {
            j = Math.min(paramFeedInfo.size(), 3);
            i = 0;
            if (i < j)
            {
              str1 = "photoUrls_" + i;
              String str2 = (String)paramFeedInfo.get(i);
              if (TextUtils.isEmpty(str2)) {
                break label334;
              }
              localJSONObject.put(str1, str2);
              this.freshNewsInfo.photoUrls.add(str2);
            }
          }
        }
      }
      catch (JSONException paramFeedInfo)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_people_card.", 4, "convertFreshNewsInfo2Json error.");
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.i("Q.nearby_people_card.", 4, "convertFreshNewsInfo2Json : " + localJSONObject.toString());
        return;
        localJSONObject.put("photoUrlsCount", j);
        this.strFreshNewsInfo = localJSONObject.toString();
      }
      break;
      label334:
      i += 1;
    }
  }
  
  public void updateFreshNewsInfo(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      this.freshNewsInfo = null;
    }
    this.freshNewsInfo = new FreshNewsInfo();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("feedContent")) {
          this.freshNewsInfo.feedContent = paramString.getString("feedContent");
        }
        if (paramString.has("photoUrlsCount"))
        {
          i = paramString.getInt("photoUrlsCount");
          if (j < i)
          {
            String str = "photoUrls_" + j;
            if (paramString.has(str))
            {
              str = paramString.getString(str);
              this.freshNewsInfo.photoUrls.add(str);
            }
            j += 1;
            continue;
          }
        }
        int i = 0;
      }
      catch (JSONException paramString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_people_card.", 4, "convert2FreshNewsInfoFromJson error.");
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_people_card.", 4, "convert2FreshNewsInfoFromJson: " + this.freshNewsInfo.toString());
        }
        return;
      }
    }
  }
  
  public void updateHotChatInfo(HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {
      this.hotInfo = null;
    }
    for (;;)
    {
      return;
      this.hotInfo = paramHotChatInfo;
      paramHotChatInfo = new JSONObject();
      try
      {
        paramHotChatInfo.put("name", this.hotInfo.name);
        paramHotChatInfo.put("subType", this.hotInfo.subType);
        paramHotChatInfo.put("joinUrl", this.hotInfo.joinUrl);
        paramHotChatInfo.put("troopUin", this.hotInfo.troopUin);
        paramHotChatInfo.put("troopCode", this.hotInfo.troopCode);
        this.strHotChatInfo = paramHotChatInfo.toString();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.nearby_people_card.", 2, "convertHotChatInfo2Json : " + paramHotChatInfo.toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.nearby_people_card.", 2, "convertHotChatInfo2Json error.");
          }
        }
      }
    }
  }
  
  public void updateHotChatInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.hotInfo = null;
    }
    this.hotInfo = new HotChatInfo();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("name")) {
        this.hotInfo.name = paramString.getString("name");
      }
      if (paramString.has("subType")) {
        this.hotInfo.subType = paramString.getInt("subType");
      }
      if (paramString.has("joinUrl")) {
        this.hotInfo.joinUrl = paramString.getString("joinUrl");
      }
      if (paramString.has("troopUin")) {
        this.hotInfo.troopUin = paramString.getString("troopUin");
      }
      if (paramString.has("troopCode")) {
        this.hotInfo.troopCode = paramString.getString("troopCode");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "convert2HotChatInfoFromJson error.");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.", 2, "convert2HotChatInfoFromJson: " + this.hotInfo);
    }
  }
  
  public void updateInterestTags(long paramLong, List paramList)
  {
    this.tagFlag = paramLong;
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (this.interestTags != null) {
        this.interestTags.clear();
      }
      if ((this.interestTags != null) && (this.interestTags.size() != 0)) {
        break label255;
      }
      this.tagInfo = "";
    }
    for (;;)
    {
      if (QLog.isDevelopLevel())
      {
        paramList = new StringBuilder();
        paramList.append("updateInterestTags,");
        if ((this.interestTags != null) && (this.interestTags.size() > 0))
        {
          paramList.append(this.interestTags.size()).append(", {");
          Object localObject1 = this.interestTags.iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              paramList.append(((InterestTag)((Iterator)localObject1).next()).toString()).append(",");
              continue;
              if (this.interestTags == null) {
                this.interestTags = new ArrayList(paramList.size());
              }
              for (;;)
              {
                paramList = paramList.iterator();
                while (paramList.hasNext())
                {
                  localObject1 = InterestTag.a((appoint_define.InterestTag)paramList.next());
                  if (localObject1 != null) {
                    this.interestTags.add(localObject1);
                  }
                }
                break;
                this.interestTags.clear();
              }
              try
              {
                label255:
                paramList = new JSONArray();
                localObject1 = this.interestTags.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  Object localObject2 = (InterestTag)((Iterator)localObject1).next();
                  if ((localObject2 != null) && (((InterestTag)localObject2).jdField_a_of_type_JavaUtilArrayList.size() != 0))
                  {
                    localObject2 = ((InterestTag)localObject2).a();
                    if (localObject2 != null) {
                      paramList.put(localObject2);
                    }
                  }
                }
              }
              catch (OutOfMemoryError paramList)
              {
                System.gc();
                this.tagInfo = "";
              }
              this.tagInfo = paramList.toString();
              break;
            }
          }
          paramList.append("}");
        }
        QLog.i("InterestTag", 4, paramList.toString());
      }
    }
  }
  
  public void updateInterestTags(List paramList)
  {
    updateInterestTags(this.tagFlag, paramList);
  }
  
  public void updateLastGameInfo(RespLastGameInfo paramRespLastGameInfo)
  {
    if ((paramRespLastGameInfo == null) || (paramRespLastGameInfo.iResult != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "handleGetSummaryCard|updateLastGameInfo|info = null or info.iResult != 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bShowGameLogo = " + paramRespLastGameInfo.bShowGameLogo + "|info.bNative = " + paramRespLastGameInfo.bNative + "|info.sLogoUrl = " + paramRespLastGameInfo.sLogoUrl);
    }
    if (paramRespLastGameInfo.bShowGameLogo)
    {
      this.nLastGameFlag |= 0x1;
      if (paramRespLastGameInfo.bNative) {}
      for (this.nLastGameFlag |= 0x2;; this.nLastGameFlag &= 0xFFFFFFFD)
      {
        this.strProfileUrl = paramRespLastGameInfo.sProfileUrl;
        return;
      }
    }
    this.nLastGameFlag &= 0xFFFFFFFE;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\NearbyPeopleCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */