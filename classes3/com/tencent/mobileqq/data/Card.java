package com.tencent.mobileqq.data;

import GameCenter.GameLogoUrl;
import GameCenter.RespLastGameInfo;
import QQService.EVIPSPEC;
import QQService.TagInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCard.AlbumInfo;
import SummaryCard.PhotoInfo;
import SummaryCardTaf.SLabelInfo;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import android.os.Parcel;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.UinPhotoListInfo;

public class Card
  extends Entity
{
  public static final long BIRTHDAY_INVALID = 0L;
  public static final int CONSTELLATION_INVALID = 0;
  public static final short FEMALE = 1;
  public static final short MALE = 0;
  public static final int PROFESSION_DEFAULT = -1;
  public static final short UNKNOWN_MALE = -1;
  public long addSrcId;
  public String addSrcName;
  public long addSubSrcId;
  public byte age;
  public boolean allowCalInteractive;
  public boolean allowClick;
  public boolean allowPeopleSee;
  public boolean autoPlayMusicPendant;
  public short bAvailVoteCnt;
  public byte[] bCardInfo;
  public byte bFavorited;
  public short bHaveVotedCnt;
  public byte bHollywoodVipOpen;
  public byte bQQVipOpen;
  public byte bQzoneInfo;
  public byte bRead;
  public byte bSingle;
  public byte bSuperQQOpen;
  public byte bSuperVipOpen;
  public byte bVoted;
  public byte bWeiboInfo;
  public long backgroundColor;
  public String backgroundUrl;
  public byte[] bgType;
  public String bindPhoneInfo;
  public String busiEntry;
  public byte cSqqLevel;
  public int constellation;
  public byte eUserIdentityType;
  public String encId;
  public int favoriteSource;
  public long feedPreviewTime;
  public int greenLevel;
  public int iFaceNum;
  public int iHollywoodVipLevel;
  public int iHollywoodVipType;
  public int iProfession;
  public int iQQLevel;
  public int iQQVipLevel;
  public int iQQVipType;
  public int iSuperQQLevel;
  public int iSuperQQType;
  public int iSuperVipLevel;
  public int iSuperVipType;
  public int iVoteIncrement;
  public boolean isGreenDiamond;
  public boolean isRedDiamond;
  public boolean isSuperGreenDiamond;
  public boolean isSuperRedDiamond;
  public boolean isSuperYellowDiamond;
  public boolean isYellowDiamond;
  public long lBirthday;
  public long lCardShowNum;
  public long lCurrentBgId;
  public long lCurrentStyleId;
  public long lLoginDays;
  public long lQQMasterLogindays;
  public long lSignModifyTime;
  public long lUserFlag;
  public long lVisitCount;
  public long lVoteCount;
  public byte[] labelInfoBytes;
  public String lightalkId;
  public String lightalkNick;
  public String location;
  public int mNowShowFlag;
  public String mNowShowIconUrl;
  public String mNowShowJumpUrl;
  public int nFaceID;
  public int nLastGameFlag;
  public int nSameFriendsNum;
  public int nStarFansFlag;
  public byte olympicTorch;
  public String privilegeJumpUrl;
  public String privilegePromptStr;
  @notColumn
  public List profileBusiEntry;
  public String pyFaceUrl;
  @notColumn
  public ArrayList qzonePhotoList;
  public int redLevel;
  @Deprecated
  public short shAge;
  public short shDuration;
  public short shGender;
  public short shType;
  public boolean showLightalk;
  public boolean showRedPointMusicPendant;
  public String starFansJumpUrl;
  public String strAutoRemark;
  public String strCertificationInfo;
  public String strCity;
  public String strCompany;
  public String strCompanySame;
  public String strContactName;
  public String strCountry;
  public String strCurrentBgUrl;
  public String strEmail;
  public String strGameAppid_1;
  public String strGameAppid_2;
  public String strGameAppid_3;
  public String strGameAppid_4;
  public String strGameLogoKey_1;
  public String strGameLogoKey_2;
  public String strGameLogoKey_3;
  public String strGameLogoKey_4;
  public String strGameLogoUrl_1;
  public String strGameLogoUrl_2;
  public String strGameLogoUrl_3;
  public String strGameLogoUrl_4;
  public String strGameName_1;
  public String strGameName_2;
  public String strGameName_3;
  public String strGameName_4;
  public String strHometownCodes;
  public String strHometownDesc;
  public String strJoinHexAlbumFileKey;
  public String strLocationCodes;
  public String strLocationDesc;
  public String strLoginDaysDesc;
  public String strMobile;
  public String strNick;
  public String strPersonalNote;
  public String strProfileUrl;
  public String strProvince;
  public String strQzoneFeedsDesc;
  public String strReMark;
  public String strRespMusicInfo;
  public String strSchool;
  public String strSchoolSame;
  public String strShowName;
  public String strSign;
  public String strSpaceName;
  public String strStarLogoUrl;
  public String strStarLvUrl_0;
  public String strStarLvUrl_1;
  public String strStarLvUrl_2;
  public String strStarPicUrl_0;
  public String strStarPicUrl_1;
  public String strStarPicUrl_2;
  public String strStatus;
  public String strTroopName;
  public String strTroopNick;
  public String strUrl;
  public String strVoiceFilekey;
  public String strVoteLimitedNotice;
  @notColumn
  public short switch_comic;
  @notColumn
  public short switch_eat;
  @notColumn
  public short switch_interest;
  @notColumn
  public short switch_joined_troop;
  @notColumn
  public short switch_ktv;
  @notColumn
  public short switch_music;
  @notColumn
  public short switch_now;
  @notColumn
  public short switch_radio;
  @notColumn
  public short switch_reader;
  @notColumn
  public short switch_recent_activity;
  @notColumn
  public short switch_star;
  public byte[] tagInfosByte;
  public int templateRet;
  public long uAccelerateMultiple;
  public int uFaceTimeStamp;
  @unique
  public String uin;
  public int ulShowControl;
  public byte[] vBackground;
  public byte[] vClosePriv;
  public byte[] vContent;
  public byte[] vCookies;
  public byte[] vCoverInfo;
  public byte[] vOpenPriv;
  public byte[] vQQFaceID;
  public byte[] vQzonePhotos;
  public byte[] vRichSign;
  public byte[] vSeed;
  public boolean videoHeadFlag;
  public String videoHeadUrl;
  public boolean visibleMusicPendant;
  public int yellowLevel;
  
  public Card()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.shGender = -1;
    this.constellation = 0;
    this.lBirthday = 0L;
    this.iProfession = -1;
    this.switch_interest = -1;
    this.switch_music = -1;
    this.switch_recent_activity = -1;
    this.switch_star = -1;
    this.switch_joined_troop = -1;
    this.switch_ktv = -1;
    this.switch_eat = -1;
    this.switch_reader = -1;
    this.switch_radio = -1;
    this.switch_now = -1;
    this.switch_comic = -1;
    this.bRead = 2;
    this.strUrl = "";
    this.lCurrentStyleId = -1L;
    this.lCurrentBgId = -1L;
    this.backgroundUrl = "";
    this.qzonePhotoList = new ArrayList();
  }
  
  public void addHeadPortrait(byte[] paramArrayOfByte)
  {
    String str2 = HexUtil.bytes2HexStr(paramArrayOfByte);
    if (noAlbumPics()) {}
    for (String str1 = ""; !noAlbumPics(); str1 = this.strJoinHexAlbumFileKey)
    {
      this.strJoinHexAlbumFileKey = (HexUtil.bytes2HexStr(paramArrayOfByte) + ";" + str1);
      return;
    }
    this.strJoinHexAlbumFileKey = str2;
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
  
  public void addQzonePhotoList(AlbumInfo paramAlbumInfo)
  {
    int i = 0;
    while (i < paramAlbumInfo.vPhotos.size())
    {
      this.qzonePhotoList.add(((PhotoInfo)paramAlbumInfo.vPhotos.get(i)).strPicUrl);
      i += 1;
    }
    if (this.qzonePhotoList.size() != 0)
    {
      paramAlbumInfo = Parcel.obtain();
      paramAlbumInfo.setDataPosition(0);
      paramAlbumInfo.writeList(this.qzonePhotoList);
      this.vQzonePhotos = paramAlbumInfo.marshall();
      paramAlbumInfo.recycle();
      return;
    }
    this.vQzonePhotos = null;
  }
  
  public void appendPortrait(List paramList)
  {
    if (!noAlbumPics())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.strJoinHexAlbumFileKey = (this.strJoinHexAlbumFileKey + ";" + str);
      }
    }
    this.strJoinHexAlbumFileKey = CardHandler.b(paramList);
  }
  
  public void appendPortrait(byte[] paramArrayOfByte)
  {
    String str2 = HexUtil.bytes2HexStr(paramArrayOfByte);
    if (noAlbumPics()) {}
    for (String str1 = ""; !noAlbumPics(); str1 = this.strJoinHexAlbumFileKey)
    {
      this.strJoinHexAlbumFileKey = (str1 + ";" + HexUtil.bytes2HexStr(paramArrayOfByte));
      return;
    }
    this.strJoinHexAlbumFileKey = str2;
  }
  
  public boolean checkCoverUrl(byte[] paramArrayOfByte)
  {
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo = new cmd0x703.UinPhotoListInfo();
    try
    {
      localUinPhotoListInfo.mergeFrom(paramArrayOfByte);
      return true;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SummaryCard", 2, "checkCoverUrl " + paramArrayOfByte.toString());
      }
    }
    return false;
  }
  
  public ArrayList getBgTypeArray()
  {
    if (this.bgType != null) {
      try
      {
        ArrayList localArrayList = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.bgType)).readObject();
        return localArrayList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
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
            break label173;
          }
          ProfileBusiEntry localProfileBusiEntry = new ProfileBusiEntry();
          localProfileBusiEntry.jdField_a_of_type_Int = localJSONObject.getInt("nBusiEntryType");
          localProfileBusiEntry.jdField_a_of_type_JavaLangString = localJSONObject.getString("strLogoUrl");
          localProfileBusiEntry.b = localJSONObject.getString("strTitle");
          localProfileBusiEntry.c = localJSONObject.getString("strContent");
          localProfileBusiEntry.d = localJSONObject.getString("strJumpUrl");
          if (localProfileBusiEntry.a()) {
            break label173;
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
      label173:
      i += 1;
    }
  }
  
  public BusinessCard getCardInfo()
  {
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    BusinessCard localBusinessCard = new BusinessCard();
    if (this.bCardInfo != null) {}
    try
    {
      localCardInfo.mergeFrom(this.bCardInfo);
      BusinessCardServlet.a(localBusinessCard, localCardInfo);
      return localBusinessCard;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SummaryCard", 2, "getCardInfo " + localInvalidProtocolBufferMicroException.toString());
      }
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    return localBusinessCard;
  }
  
  public Object[] getCoverData(int paramInt)
  {
    Object localObject3 = null;
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo;
    if (this.vCoverInfo != null) {
      localUinPhotoListInfo = new cmd0x703.UinPhotoListInfo();
    }
    for (;;)
    {
      try
      {
        localUinPhotoListInfo.mergeFrom(this.vCoverInfo);
        if ((localUinPhotoListInfo != null) && (localUinPhotoListInfo.rpt_msg_photo_info.get() != null))
        {
          Object localObject4 = localUinPhotoListInfo.rpt_msg_photo_info.get();
          Object localObject1 = localUinPhotoListInfo.rpt_selected_id_list.get();
          if (QLog.isColorLevel()) {
            QLog.d("SummaryCard", 2, "getCoverData infoList:" + ((List)localObject4).size());
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            i = ((Integer)((List)localObject1).get(0)).intValue();
            j = 0;
            if (j >= ((List)localObject4).size()) {
              continue;
            }
            localObject3 = (cmd0x703.PhotoInfo)((List)localObject4).get(j);
            if ((((cmd0x703.PhotoInfo)localObject3).uint32_id.get() != i) || (paramInt >= ((cmd0x703.PhotoInfo)localObject3).uint32_timestamp.get())) {
              continue;
            }
            localObject1 = ((cmd0x703.PhotoInfo)localObject3).str_url.get();
            j = ((cmd0x703.PhotoInfo)localObject3).uint32_timestamp.get();
            if ((!localUinPhotoListInfo.str_default_photo.has()) || (TextUtils.isEmpty(localUinPhotoListInfo.str_default_photo.get()))) {
              continue;
            }
            localObject1 = localUinPhotoListInfo.str_default_photo.get();
            m = i;
            k = j;
            localObject3 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              m = i;
              k = j;
              localObject3 = localObject1;
              if (((List)localObject4).size() > 0)
              {
                localObject4 = (cmd0x703.PhotoInfo)((List)localObject4).get(((List)localObject4).size() - 1);
                m = i;
                k = j;
                localObject3 = localObject1;
                if (paramInt < ((cmd0x703.PhotoInfo)localObject4).uint32_timestamp.get())
                {
                  localObject3 = ((cmd0x703.PhotoInfo)localObject4).str_url.get();
                  k = ((cmd0x703.PhotoInfo)localObject4).uint32_timestamp.get();
                  m = i;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("SummaryCard", 2, "getCoverData selectedId:" + m + " retTime:" + k + " retUrl:" + (String)localObject3);
            }
            return new Object[] { localObject3, Integer.valueOf(k) };
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SummaryCard", 2, "getCoverData " + localInvalidProtocolBufferMicroException.toString());
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SummaryCard", 2, "getCoverData idList is empty!");
        }
        int i = -1;
        continue;
        j += 1;
        continue;
        continue;
        int j = 0;
        Object localObject2 = null;
        continue;
      }
      int m = -1;
      int k = 0;
    }
  }
  
  public String getHeadFileHexKey()
  {
    String str = null;
    LinkedList localLinkedList = CardHandler.a(this.strJoinHexAlbumFileKey);
    if (localLinkedList.size() > 0) {
      str = (String)localLinkedList.get(0);
    }
    return str;
  }
  
  public List getLabelList()
  {
    Object localObject2 = null;
    if (this.labelInfoBytes != null) {}
    for (;;)
    {
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.labelInfoBytes);
        ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        ((Exception)localObject2).printStackTrace();
      }
      catch (Exception localException2)
      {
        try
        {
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          if (localObject1 == null) {
            break label76;
          }
          return (List)localObject1;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      continue;
      label76:
      return new ArrayList();
      Object localObject1 = null;
    }
  }
  
  public int getLocalPicKeysCount()
  {
    if ((this.strJoinHexAlbumFileKey == null) || (this.strJoinHexAlbumFileKey.length() == 0)) {
      return 0;
    }
    return CardHandler.a(this.strJoinHexAlbumFileKey).size();
  }
  
  public int getPicCountInAlbum()
  {
    return this.iFaceNum;
  }
  
  public List getPrivilegeCloseInfo()
  {
    Object localObject2 = null;
    if (this.vClosePriv != null) {}
    for (;;)
    {
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.vClosePriv);
        ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        ((Exception)localObject2).printStackTrace();
      }
      catch (Exception localException2)
      {
        try
        {
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          if (localObject1 == null) {
            break label76;
          }
          return (List)localObject1;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      continue;
      label76:
      return new ArrayList();
      Object localObject1 = null;
    }
  }
  
  public List getPrivilegeOpenInfo()
  {
    Object localObject2 = null;
    if (this.vOpenPriv != null) {}
    for (;;)
    {
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.vOpenPriv);
        ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        ((Exception)localObject2).printStackTrace();
      }
      catch (Exception localException2)
      {
        try
        {
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          if (localObject1 == null) {
            break label76;
          }
          return (List)localObject1;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      continue;
      label76:
      return new ArrayList();
      Object localObject1 = null;
    }
  }
  
  public String getProfileCardDesc()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->templateRet=" + this.templateRet);
    localStringBuilder.append(",styleId=" + this.lCurrentStyleId);
    localStringBuilder.append(",backgroundId=" + this.lCurrentBgId);
    localStringBuilder.append(",backgroundUrl=" + this.backgroundUrl);
    localStringBuilder.append(",backgroundColor=" + this.backgroundColor);
    return localStringBuilder.toString();
  }
  
  public List getQZonePhotoList()
  {
    if ((this.qzonePhotoList.size() == 0) && (this.vQzonePhotos != null)) {}
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(this.vQzonePhotos, 0, this.vQzonePhotos.length);
      localParcel.setDataPosition(0);
      this.qzonePhotoList = localParcel.readArrayList(getClass().getClassLoader());
      localParcel.recycle();
      return this.qzonePhotoList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, localException.toString());
        }
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, localError.toString());
        }
      }
    }
  }
  
  public RichStatus getRichStatus()
  {
    if ((this.vRichSign == null) || (this.vRichSign.length == 0))
    {
      if ((this.lSignModifyTime <= 0L) && (!TextUtils.isEmpty(this.strSign)))
      {
        localRichStatus = new RichStatus(this.strSign);
        localRichStatus.time = this.lSignModifyTime;
        return localRichStatus;
      }
      return null;
    }
    RichStatus localRichStatus = RichStatus.parseStatus(this.vRichSign);
    localRichStatus.time = this.lSignModifyTime;
    return localRichStatus;
  }
  
  public String getStrJoinHexAlbumFileKey()
  {
    return this.strJoinHexAlbumFileKey;
  }
  
  public ArrayList getTagInfoArray()
  {
    if (this.tagInfosByte != null) {
      try
      {
        ArrayList localArrayList3 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.tagInfosByte)).readObject();
        if (localArrayList3 != null)
        {
          int i = 0;
          for (;;)
          {
            ArrayList localArrayList1 = localArrayList3;
            if (i >= localArrayList3.size()) {
              break;
            }
            ((TagInfo)localArrayList3.get(i)).iTagId = new BigInteger(Long.toString(((TagInfo)localArrayList3.get(i)).iTagId)).longValue();
            i += 1;
          }
        }
        localArrayList2 = new ArrayList();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ArrayList localArrayList2;
    return localArrayList2;
  }
  
  public int getVipLevel(EVIPSPEC paramEVIPSPEC)
  {
    int i = -1;
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      i = this.iQQVipLevel;
    }
    do
    {
      return i;
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ) {
        return this.iSuperQQLevel;
      }
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) {
        return this.iSuperVipLevel;
      }
    } while (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD);
    return this.iHollywoodVipLevel;
  }
  
  public int getVipType(EVIPSPEC paramEVIPSPEC)
  {
    int i = -1;
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      i = this.iQQVipType;
    }
    do
    {
      return i;
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ) {
        return this.iSuperQQType;
      }
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) {
        return this.iSuperVipType;
      }
    } while (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD);
    return this.iHollywoodVipType;
  }
  
  public boolean hasCardInfo()
  {
    return this.bCardInfo != null;
  }
  
  public boolean hasGotPhotoUrl()
  {
    return this.vQzonePhotos != null;
  }
  
  public boolean isOpenRecentPlayingGamesByNative()
  {
    return (this.nLastGameFlag & 0x2) == 2;
  }
  
  public boolean isPhotoUseCache()
  {
    return (this.ulShowControl & 0x20) != 0;
  }
  
  public boolean isShowFeeds()
  {
    return (this.ulShowControl & 0x4) != 0;
  }
  
  public boolean isShowPhoto()
  {
    return (this.ulShowControl & 0x10) != 0;
  }
  
  public boolean isShowQStarFans()
  {
    return true;
  }
  
  public boolean isShowRecentPlayingGames()
  {
    return (this.nLastGameFlag & 0x1) == 1;
  }
  
  public boolean isShowVoice()
  {
    return (this.ulShowControl & 0x8) != 0;
  }
  
  public boolean isShowXMan()
  {
    return (this.ulShowControl & 0x10) != 0;
  }
  
  public boolean isShowZan()
  {
    return (this.ulShowControl & 0x1) != 0;
  }
  
  public boolean isVipOpen(EVIPSPEC paramEVIPSPEC)
  {
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      if (this.bQQVipOpen != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (paramEVIPSPEC != EVIPSPEC.E_SP_SUPERQQ) {
            break;
          }
        } while (this.bSuperQQOpen == 1);
        return false;
        if (paramEVIPSPEC != EVIPSPEC.E_SP_SUPERVIP) {
          break;
        }
      } while (this.bSuperVipOpen == 1);
      return false;
      if (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD) {
        break;
      }
    } while (this.bHollywoodVipOpen == 1);
    return false;
    return false;
  }
  
  public boolean noAlbumPics()
  {
    return getPicCountInAlbum() == 0;
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
  
  public void removePortrait(byte[] paramArrayOfByte)
  {
    LinkedList localLinkedList = CardHandler.a(this.strJoinHexAlbumFileKey);
    if (localLinkedList.remove(HexUtil.bytes2HexStr(paramArrayOfByte)))
    {
      this.iFaceNum -= 1;
      this.strJoinHexAlbumFileKey = CardHandler.b(localLinkedList);
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
        break label206;
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
        label206:
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
  
  public void saveCardInfo(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    localCardInfo.card_id.set(ByteStringMicro.copyFromUtf8(paramBusinessCard.cardId));
    if (!TextUtils.isEmpty(paramBusinessCard.picUrl)) {
      localCardInfo.pic_url.set(paramBusinessCard.picUrl);
    }
    if (!TextUtils.isEmpty(paramBusinessCard.cardName)) {
      localCardInfo.name.set(paramBusinessCard.cardName);
    }
    if (!TextUtils.isEmpty(paramBusinessCard.company)) {
      localCardInfo.company.set(paramBusinessCard.company);
    }
    Object localObject = paramBusinessCard.qqNum.iterator();
    String str;
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localCardInfo.uins.add(Long.valueOf(Long.parseLong(str)));
    }
    localObject = paramBusinessCard.mobilesNum.iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localCardInfo.mobiles.add(str);
    }
    paramBusinessCard = paramBusinessCard.descs.iterator();
    while (paramBusinessCard.hasNext())
    {
      localObject = (String)paramBusinessCard.next();
      localCardInfo.descs.add(localObject);
    }
    this.bCardInfo = localCardInfo.toByteArray();
  }
  
  public void savePrivilegeClosedInfo(List paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramList);
      this.vClosePriv = localByteArrayOutputStream.toByteArray();
      localObjectOutputStream.flush();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void savePrivilegeOpenedInfo(List paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramList);
      this.vOpenPriv = localByteArrayOutputStream.toByteArray();
      localObjectOutputStream.flush();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public byte[] setBgType(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      this.bgType = localByteArrayOutputStream.toByteArray();
      paramObject = this.bgType;
      return (byte[])paramObject;
    }
    catch (IOException paramObject)
    {
      ((IOException)paramObject).printStackTrace();
    }
    return null;
  }
  
  public void setFeedsShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x4;
      return;
    }
    this.ulShowControl &= 0xFFFFFFFB;
  }
  
  public void setLabelList(Map paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject2 = (Map.Entry)paramMap.next();
        localObject1 = (Long)((Map.Entry)localObject2).getKey();
        localObject2 = (SLabelInfo)((Map.Entry)localObject2).getValue();
        localArrayList.add(new ProfileLabelInfo((Long)localObject1, Long.valueOf(((SLabelInfo)localObject2).likeit), ((SLabelInfo)localObject2).name));
      }
    }
    try
    {
      paramMap = new ByteArrayOutputStream();
      localObject1 = new ObjectOutputStream(paramMap);
      ((ObjectOutputStream)localObject1).writeObject(localArrayList);
      this.labelInfoBytes = paramMap.toByteArray();
      ((ObjectOutputStream)localObject1).flush();
      paramMap.close();
      ((ObjectOutputStream)localObject1).close();
      paramMap.close();
      ((ObjectOutputStream)localObject1).close();
      return;
    }
    catch (IOException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public void setPhotoShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x10;
      return;
    }
    this.ulShowControl &= 0xFFFFFFEF;
  }
  
  public void setPhotoUseCacheFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x20;
      return;
    }
    this.ulShowControl &= 0xFFFFFFDF;
  }
  
  public void setStrJoinHexAlbumFileKey(String paramString)
  {
    this.strJoinHexAlbumFileKey = paramString;
    if ((paramString == null) || ("".equals(paramString))) {
      this.strJoinHexAlbumFileKey = ";";
    }
  }
  
  public byte[] setTagInfosByte(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      this.tagInfosByte = localByteArrayOutputStream.toByteArray();
      paramObject = this.tagInfosByte;
      return (byte[])paramObject;
    }
    catch (IOException paramObject)
    {
      ((IOException)paramObject).printStackTrace();
    }
    return null;
  }
  
  public void setVipInfo(VipBaseInfo paramVipBaseInfo)
  {
    byte b2 = 1;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label233;
        }
        b1 = 1;
        this.bQQVipOpen = b1;
        this.iQQVipType = localVipOpenInfo.iVipType;
        this.iQQVipLevel = localVipOpenInfo.iVipLevel;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(2));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label238;
        }
        b1 = 1;
        label102:
        this.bSuperQQOpen = b1;
        this.iSuperQQType = localVipOpenInfo.iVipType;
        this.iSuperQQLevel = localVipOpenInfo.iVipLevel;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label243;
        }
        b1 = 1;
        label158:
        this.bSuperVipOpen = b1;
        this.iSuperVipType = localVipOpenInfo.iVipType;
        this.iSuperVipLevel = localVipOpenInfo.iVipLevel;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(4));
      if (paramVipBaseInfo != null) {
        if (!paramVipBaseInfo.bOpen) {
          break label248;
        }
      }
    }
    label233:
    label238:
    label243:
    label248:
    for (byte b1 = b2;; b1 = 0)
    {
      this.bHollywoodVipOpen = b1;
      this.iHollywoodVipType = paramVipBaseInfo.iVipType;
      this.iHollywoodVipLevel = paramVipBaseInfo.iVipLevel;
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label102;
      b1 = 0;
      break label158;
    }
  }
  
  public void setVoiceShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x8;
      return;
    }
    this.ulShowControl &= 0xFFFFFFF7;
  }
  
  public void setXManFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x10;
      return;
    }
    this.ulShowControl &= 0xFFFFFFEF;
  }
  
  public void setZanShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x1;
      return;
    }
    this.ulShowControl &= 0xFFFFFFFE;
  }
  
  public boolean shouldShowJoinedTroop()
  {
    return (this.ulShowControl & 0x40) == 0;
  }
  
  public void updateCardTemplate(QQAppInterface paramQQAppInterface, String paramString, SSummaryCardRsp paramSSummaryCardRsp)
  {
    HashMap localHashMap = new HashMap();
    if (paramSSummaryCardRsp != null)
    {
      this.templateRet = paramSSummaryCardRsp.res;
      this.lCurrentStyleId = paramSSummaryCardRsp.styleid;
      this.backgroundUrl = paramSSummaryCardRsp.bgurl;
      this.lCurrentBgId = paramSSummaryCardRsp.bgid;
      this.backgroundColor = paramSSummaryCardRsp.color;
      ArrayList localArrayList = paramSSummaryCardRsp.bgtype;
      if (localArrayList != null) {
        setBgType(localArrayList);
      }
      if ((paramSSummaryCardRsp.label != null) && (paramSSummaryCardRsp.label.label != null)) {
        setLabelList(paramSSummaryCardRsp.label.label);
      }
      localHashMap.put("param_FailCode", "0");
      localHashMap.put("param_templateRet", String.valueOf(paramSSummaryCardRsp.res));
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "updateCardTemplate templateInfo-->" + getProfileCardDesc());
      }
      StatisticCollector.a(paramQQAppInterface.a()).a(paramString, "profileCardGet", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    this.templateRet = 0;
    this.lCurrentStyleId = 0L;
    this.backgroundUrl = "";
    this.lCurrentBgId = 0L;
    this.backgroundColor = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "updateCardTemplate templateInfo is null");
    }
    localHashMap.put("param_FailCode", "-101");
    localHashMap.put("param_templateRet", "0");
    StatisticCollector.a(paramQQAppInterface.a()).a(paramString, "profileCardGet", false, 0L, 0L, localHashMap, "", false);
  }
  
  public void updateLastGameInfo(RespLastGameInfo paramRespLastGameInfo)
  {
    int k = 0;
    if ((paramRespLastGameInfo == null) || (paramRespLastGameInfo.iResult != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "handleGetSummaryCard|updateLastGameInfo|info = null or info.iResult = 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bShowGameLogo = " + paramRespLastGameInfo.bShowGameLogo);
    }
    if (paramRespLastGameInfo.bShowGameLogo)
    {
      this.nLastGameFlag |= 0x1;
      if (paramRespLastGameInfo.bNative) {
        this.nLastGameFlag |= 0x2;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bNative = " + paramRespLastGameInfo.bNative);
        }
        this.strProfileUrl = paramRespLastGameInfo.sProfileUrl;
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, "updateLastGameInfo|info.stGameLogoInfo = " + paramRespLastGameInfo.stGameLogoInfo);
        }
        int i;
        label197:
        int j;
        label275:
        GameLogoUrl localGameLogoUrl;
        label301:
        String str1;
        String str2;
        String str3;
        String str4;
        if (paramRespLastGameInfo.stGameLogoInfo != null)
        {
          i = paramRespLastGameInfo.stGameLogoInfo.size();
          if (QLog.isColorLevel()) {
            QLog.i("SummaryCard", 2, "updateLastGameInfo|size = " + i);
          }
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.i("SummaryCard", 2, "updateLastGameInfo|info.sLogoUrl = " + paramRespLastGameInfo.sLogoUrl);
            j = k;
          }
          if (j >= 4) {
            break;
          }
          if (j >= i) {
            break label530;
          }
          localGameLogoUrl = (GameLogoUrl)paramRespLastGameInfo.stGameLogoInfo.get(j);
          k = j + 1;
          str1 = "strGameLogoUrl_" + String.valueOf(k);
          str2 = "strGameLogoKey_" + String.valueOf(k);
          str3 = "strGameName_" + String.valueOf(k);
          str4 = "strGameAppid_" + String.valueOf(k);
          if (localGameLogoUrl == null) {
            break label535;
          }
        }
        try
        {
          getClass().getField(str1).set(this, paramRespLastGameInfo.sLogoUrl + localGameLogoUrl.sLogoName);
          getClass().getField(str2).set(this, localGameLogoUrl.sLogoMd5);
          getClass().getField(str3).set(this, localGameLogoUrl.sGameName);
          getClass().getField(str4).set(this, localGameLogoUrl.sAppid);
          for (;;)
          {
            j += 1;
            break label275;
            this.nLastGameFlag &= 0xFFFFFFFD;
            break;
            i = 0;
            break label197;
            label530:
            localGameLogoUrl = null;
            break label301;
            label535:
            if (QLog.isColorLevel()) {
              QLog.i("SummaryCard", 2, "updateLastGameInfo index" + j + "logo is null reset game info");
            }
            getClass().getField(str1).set(this, "");
            getClass().getField(str2).set(this, "");
            getClass().getField(str3).set(this, "");
            getClass().getField(str4).set(this, "");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SummaryCard", 2, "updateLastGameInfo get logo index=" + j + " exception");
            }
            localException.printStackTrace();
          }
        }
      }
    }
    this.nLastGameFlag &= 0xFFFFFFFE;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\Card.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */