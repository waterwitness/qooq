package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CardDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public CardDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 161;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Card)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramEntity.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramEntity.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramEntity.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramEntity.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramEntity.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramEntity.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramEntity.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramEntity.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramEntity.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramEntity.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramEntity.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramEntity.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramEntity.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramEntity.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramEntity.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramEntity.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramEntity.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramEntity.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramEntity.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramEntity.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramEntity.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramEntity.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramEntity.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramEntity.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramEntity.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramEntity.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramEntity.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramEntity.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramEntity.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramEntity.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramEntity.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramEntity.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramEntity.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramEntity.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramEntity.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramEntity.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramEntity.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramEntity.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramEntity.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramEntity.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramEntity.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramEntity.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramEntity.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramEntity.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramEntity.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramEntity.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramEntity.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramEntity.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramEntity.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramEntity.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramEntity.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
      paramEntity.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
      paramEntity.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
      paramEntity.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
      paramEntity.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
      paramEntity.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
      paramEntity.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
      paramEntity.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
      paramEntity.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
      paramEntity.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
      paramEntity.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
      paramEntity.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
      paramEntity.strVoiceFilekey = paramCursor.getString(paramCursor.getColumnIndex("strVoiceFilekey"));
      paramEntity.shDuration = paramCursor.getShort(paramCursor.getColumnIndex("shDuration"));
      paramEntity.bRead = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bRead")));
      paramEntity.strUrl = paramCursor.getString(paramCursor.getColumnIndex("strUrl"));
      paramEntity.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
      paramEntity.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
      paramEntity.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
      paramEntity.strGameLogoUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_1"));
      paramEntity.strGameLogoUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_2"));
      paramEntity.strGameLogoUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_3"));
      paramEntity.strGameLogoUrl_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_4"));
      paramEntity.strGameLogoKey_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_1"));
      paramEntity.strGameLogoKey_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_2"));
      paramEntity.strGameLogoKey_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_3"));
      paramEntity.strGameLogoKey_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_4"));
      paramEntity.strGameName_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_1"));
      paramEntity.strGameName_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_2"));
      paramEntity.strGameName_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_3"));
      paramEntity.strGameName_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_4"));
      paramEntity.strGameAppid_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_1"));
      paramEntity.strGameAppid_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_2"));
      paramEntity.strGameAppid_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_3"));
      paramEntity.strGameAppid_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_4"));
      paramEntity.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
      paramEntity.nStarFansFlag = paramCursor.getInt(paramCursor.getColumnIndex("nStarFansFlag"));
      paramEntity.strStarPicUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_0"));
      paramEntity.strStarPicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_1"));
      paramEntity.strStarPicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_2"));
      paramEntity.strStarLvUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_0"));
      paramEntity.strStarLvUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_1"));
      paramEntity.strStarLvUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_2"));
      paramEntity.strStarLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("strStarLogoUrl"));
      paramEntity.starFansJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("starFansJumpUrl"));
      paramEntity.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
      paramEntity.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
      paramEntity.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
      paramEntity.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee")))
      {
        paramBoolean = true;
        paramEntity.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label3145;
        }
        paramBoolean = true;
        label2192:
        paramEntity.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label3150;
        }
        paramBoolean = true;
        label2218:
        paramEntity.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label3155;
        }
        paramBoolean = true;
        label2244:
        paramEntity.showLightalk = paramBoolean;
        paramEntity.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramEntity.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label3160;
        }
        paramBoolean = true;
        label2308:
        paramEntity.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label3165;
        }
        paramBoolean = true;
        label2334:
        paramEntity.isRedDiamond = paramBoolean;
        paramEntity.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label3170;
        }
        paramBoolean = true;
        label2379:
        paramEntity.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label3175;
        }
        paramBoolean = true;
        label2405:
        paramEntity.isYellowDiamond = paramBoolean;
        paramEntity.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label3180;
        }
        paramBoolean = true;
        label2450:
        paramEntity.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label3185;
        }
        paramBoolean = true;
        label2476:
        paramEntity.isGreenDiamond = paramBoolean;
        paramEntity.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramEntity.uAccelerateMultiple = paramCursor.getLong(paramCursor.getColumnIndex("uAccelerateMultiple"));
        paramEntity.strRespMusicInfo = paramCursor.getString(paramCursor.getColumnIndex("strRespMusicInfo"));
        paramEntity.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramEntity.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramEntity.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramEntity.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramEntity.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramEntity.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramEntity.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramEntity.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramEntity.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label3190;
        }
        paramBoolean = true;
        label2749:
        paramEntity.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label3195;
        }
        paramBoolean = true;
        label2775:
        paramEntity.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label3200;
        }
        paramBoolean = true;
        label2801:
        paramEntity.showRedPointMusicPendant = paramBoolean;
        paramEntity.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramEntity.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramEntity.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramEntity.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramEntity.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramEntity.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramEntity.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramEntity.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramEntity.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramEntity.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramEntity.olympicTorch = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("olympicTorch")));
        paramEntity.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramEntity.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramEntity.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramEntity.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label3205;
        }
      }
      label3145:
      label3150:
      label3155:
      label3160:
      label3165:
      label3170:
      label3175:
      label3180:
      label3185:
      label3190:
      label3195:
      label3200:
      label3205:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.videoHeadFlag = paramBoolean;
        paramEntity.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label2192;
        paramBoolean = false;
        break label2218;
        paramBoolean = false;
        break label2244;
        paramBoolean = false;
        break label2308;
        paramBoolean = false;
        break label2334;
        paramBoolean = false;
        break label2379;
        paramBoolean = false;
        break label2405;
        paramBoolean = false;
        break label2450;
        paramBoolean = false;
        break label2476;
        paramBoolean = false;
        break label2749;
        paramBoolean = false;
        break label2775;
        paramBoolean = false;
        break label2801;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label9084;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strNick", String.class));
      label3280:
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label9099;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shGender", Short.TYPE));
      label3315:
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label9114;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shAge", Short.TYPE));
      label3350:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label9129;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nFaceID", Integer.TYPE));
      label3385:
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label9144;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCertificationInfo", String.class));
      label3420:
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label9159;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shType", Short.TYPE));
      label3455:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label9174;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vContent", byte[].class));
      label3490:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label9189;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSign", String.class));
      label3525:
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label9204;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCompany", String.class));
      label3560:
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label9219;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSchool", String.class));
      label3595:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label9234;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      label3630:
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label9249;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vQQFaceID", byte[].class));
      label3665:
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label9264;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strReMark", String.class));
      label3700:
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label9279;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label3735:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label9295;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bQzoneInfo", Byte.TYPE));
      label3770:
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label9311;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      label3805:
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label9326;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCompanySame", String.class));
      label3840:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label9341;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSchoolSame", String.class));
      label3875:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label9356;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCardShowNum", Long.TYPE));
      label3910:
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label9371;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSingle", Byte.TYPE));
      label3945:
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label9387;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lVisitCount", Long.TYPE));
      label3980:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label9402;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lVoteCount", Long.TYPE));
      label4015:
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label9417;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagInfosByte", byte[].class));
      label4050:
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label9432;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("eUserIdentityType", Byte.TYPE));
      label4085:
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label9448;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vBackground", byte[].class));
      label4120:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label9463;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("labelInfoBytes", byte[].class));
      label4155:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label9478;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Byte.TYPE));
      label4190:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label9494;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("constellation", Integer.TYPE));
      label4225:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label9509;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFaceUrl", String.class));
      label4260:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label9524;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("location", String.class));
      label4295:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label9539;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVoted", Byte.TYPE));
      label4330:
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label9555;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bFavorited", Byte.TYPE));
      label4365:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label9571;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iVoteIncrement", Integer.TYPE));
      label4400:
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label9586;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      label4435:
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label9601;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iFaceNum", Integer.TYPE));
      label4470:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label9616;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cSqqLevel", Byte.TYPE));
      label4505:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label9632;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQLevel", Integer.TYPE));
      label4540:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label9647;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProvince", String.class));
      label4575:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label9662;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCity", String.class));
      label4610:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label9677;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCountry", String.class));
      label4645:
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label9692;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lBirthday", Long.TYPE));
      label4680:
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label9707;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLocationCodes", String.class));
      label4715:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label9722;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLocationDesc", String.class));
      label4750:
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label9737;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHometownCodes", String.class));
      label4785:
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label9752;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHometownDesc", String.class));
      label4820:
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label9767;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strEmail", String.class));
      label4855:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label9782;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strPersonalNote", String.class));
      label4890:
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label9797;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iProfession", Integer.TYPE));
      label4925:
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label9812;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bindPhoneInfo", String.class));
      label4960:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label9827;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bCardInfo", byte[].class));
      label4997:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label9842;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strTroopName", String.class));
      label5034:
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label9857;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strTroopNick", String.class));
      label5071:
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label9872;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strMobile", String.class));
      label5108:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label9887;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strContactName", String.class));
      label5145:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label9902;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ulShowControl", Integer.TYPE));
      label5182:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label9917;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label5219:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label9932;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strQzoneFeedsDesc", String.class));
      label5256:
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label9947;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSpaceName", String.class));
      label5293:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label9962;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vQzonePhotos", byte[].class));
      label5330:
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label9977;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStatus", String.class));
      label5367:
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label9992;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strAutoRemark", String.class));
      label5404:
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label10007;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vSeed", byte[].class));
      label5441:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label10022;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCookies", byte[].class));
      label5478:
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label10037;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label5515:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label10053;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQVipType", Integer.TYPE));
      label5552:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label10068;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQVipLevel", Integer.TYPE));
      label5589:
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label10083;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      label5626:
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label10099;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperVipType", Integer.TYPE));
      label5663:
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label10114;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label5700:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label10129;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      label5737:
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label10145;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperQQType", Integer.TYPE));
      label5774:
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label10160;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label5811:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label10175;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      label5848:
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label10191;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      label5885:
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label10206;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      label5922:
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label10221;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strShowName", String.class));
      label5959:
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label10236;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoiceFilekey", String.class));
      label5996:
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label10251;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shDuration", Short.TYPE));
      label6033:
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label10266;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bRead", Byte.TYPE));
      label6070:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label10282;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strUrl", String.class));
      label6107:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label10297;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vRichSign", byte[].class));
      label6144:
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label10312;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lSignModifyTime", Long.TYPE));
      label6181:
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label10327;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label6218:
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label10342;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_1", String.class));
      label6255:
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label10357;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_2", String.class));
      label6292:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label10372;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_3", String.class));
      label6329:
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label10387;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_4", String.class));
      label6366:
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label10402;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_1", String.class));
      label6403:
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label10417;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_2", String.class));
      label6440:
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label10432;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_3", String.class));
      label6477:
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label10447;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_4", String.class));
      label6514:
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label10462;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_1", String.class));
      label6551:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label10477;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_2", String.class));
      label6588:
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label10492;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_3", String.class));
      label6625:
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label10507;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_4", String.class));
      label6662:
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label10522;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_1", String.class));
      label6699:
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label10537;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_2", String.class));
      label6736:
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label10552;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_3", String.class));
      label6773:
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label10567;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_4", String.class));
      label6810:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label10582;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProfileUrl", String.class));
      label6847:
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label10597;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nStarFansFlag", Integer.TYPE));
      label6884:
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label10612;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_0", String.class));
      label6921:
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label10627;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_1", String.class));
      label6958:
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label10642;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_2", String.class));
      label6995:
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label10657;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_0", String.class));
      label7032:
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label10672;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_1", String.class));
      label7069:
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label10687;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_2", String.class));
      label7106:
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label10702;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLogoUrl", String.class));
      label7143:
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label10717;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("starFansJumpUrl", String.class));
      label7180:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label10732;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lUserFlag", Long.TYPE));
      label7217:
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label10747;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lLoginDays", Long.TYPE));
      label7254:
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label10762;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLoginDaysDesc", String.class));
      label7291:
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label10777;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label7328:
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label10792;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label10819;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label10846;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label10873;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label10900;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lightalkNick", String.class));
      label7513:
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label10915;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lightalkId", String.class));
      label7550:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label10930;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label10957;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label10984;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("redLevel", Integer.TYPE));
      label7661:
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label10999;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label11026;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label11053;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("yellowLevel", Integer.TYPE));
      label7772:
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label11068;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label11095;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label11122;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("greenLevel", Integer.TYPE));
      label7883:
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label11137;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      label7920:
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label11152;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strRespMusicInfo", String.class));
      label7957:
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label11167;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("templateRet", Integer.TYPE));
      label7994:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label11182;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCurrentStyleId", Long.TYPE));
      label8031:
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label11197;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCurrentBgId", Long.TYPE));
      label8068:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label11212;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("backgroundUrl", String.class));
      label8105:
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label11227;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("backgroundColor", Long.TYPE));
      label8142:
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label11242;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCurrentBgUrl", String.class));
      label8179:
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label11257;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bgType", byte[].class));
      label8216:
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label11272;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("encId", String.class));
      label8253:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label11287;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("busiEntry", String.class));
      label8290:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label11302;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label8327:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label11317;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label11344;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label11371;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label11398;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("privilegePromptStr", String.class));
      label8475:
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label11413;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("privilegeJumpUrl", String.class));
      label8512:
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label11428;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vOpenPriv", byte[].class));
      label8549:
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label11443;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vClosePriv", byte[].class));
      label8586:
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label11458;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSrcName", String.class));
      label8623:
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label11473;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSrcId", Long.TYPE));
      label8660:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label11488;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSubSrcId", Long.TYPE));
      label8697:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label11503;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label8734:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label11518;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label8771:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label11533;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label8808:
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label11548;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("olympicTorch", Byte.TYPE));
      label8845:
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label11564;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowFlag", Integer.TYPE));
      label8882:
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label11579;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowIconUrl", String.class));
      label8919:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label11594;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowJumpUrl", String.class));
      label8956:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label11609;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCoverInfo", byte[].class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label11624;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label11652;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadUrl", String.class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label9084:
      paramEntity.strNick = paramCursor.getString(i);
      break label3280;
      label9099:
      paramEntity.shGender = paramCursor.getShort(i);
      break label3315;
      label9114:
      paramEntity.shAge = paramCursor.getShort(i);
      break label3350;
      label9129:
      paramEntity.nFaceID = paramCursor.getInt(i);
      break label3385;
      label9144:
      paramEntity.strCertificationInfo = paramCursor.getString(i);
      break label3420;
      label9159:
      paramEntity.shType = paramCursor.getShort(i);
      break label3455;
      label9174:
      paramEntity.vContent = paramCursor.getBlob(i);
      break label3490;
      label9189:
      paramEntity.strSign = paramCursor.getString(i);
      break label3525;
      label9204:
      paramEntity.strCompany = paramCursor.getString(i);
      break label3560;
      label9219:
      paramEntity.strSchool = paramCursor.getString(i);
      break label3595;
      label9234:
      paramEntity.uFaceTimeStamp = paramCursor.getInt(i);
      break label3630;
      label9249:
      paramEntity.vQQFaceID = paramCursor.getBlob(i);
      break label3665;
      label9264:
      paramEntity.strReMark = paramCursor.getString(i);
      break label3700;
      label9279:
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label3735;
      label9295:
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label3770;
      label9311:
      paramEntity.nSameFriendsNum = paramCursor.getInt(i);
      break label3805;
      label9326:
      paramEntity.strCompanySame = paramCursor.getString(i);
      break label3840;
      label9341:
      paramEntity.strSchoolSame = paramCursor.getString(i);
      break label3875;
      label9356:
      paramEntity.lCardShowNum = paramCursor.getLong(i);
      break label3910;
      label9371:
      paramEntity.bSingle = ((byte)paramCursor.getShort(i));
      break label3945;
      label9387:
      paramEntity.lVisitCount = paramCursor.getLong(i);
      break label3980;
      label9402:
      paramEntity.lVoteCount = paramCursor.getLong(i);
      break label4015;
      label9417:
      paramEntity.tagInfosByte = paramCursor.getBlob(i);
      break label4050;
      label9432:
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label4085;
      label9448:
      paramEntity.vBackground = paramCursor.getBlob(i);
      break label4120;
      label9463:
      paramEntity.labelInfoBytes = paramCursor.getBlob(i);
      break label4155;
      label9478:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label4190;
      label9494:
      paramEntity.constellation = paramCursor.getInt(i);
      break label4225;
      label9509:
      paramEntity.pyFaceUrl = paramCursor.getString(i);
      break label4260;
      label9524:
      paramEntity.location = paramCursor.getString(i);
      break label4295;
      label9539:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label4330;
      label9555:
      paramEntity.bFavorited = ((byte)paramCursor.getShort(i));
      break label4365;
      label9571:
      paramEntity.iVoteIncrement = paramCursor.getInt(i);
      break label4400;
      label9586:
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label4435;
      label9601:
      paramEntity.iFaceNum = paramCursor.getInt(i);
      break label4470;
      label9616:
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label4505;
      label9632:
      paramEntity.iQQLevel = paramCursor.getInt(i);
      break label4540;
      label9647:
      paramEntity.strProvince = paramCursor.getString(i);
      break label4575;
      label9662:
      paramEntity.strCity = paramCursor.getString(i);
      break label4610;
      label9677:
      paramEntity.strCountry = paramCursor.getString(i);
      break label4645;
      label9692:
      paramEntity.lBirthday = paramCursor.getLong(i);
      break label4680;
      label9707:
      paramEntity.strLocationCodes = paramCursor.getString(i);
      break label4715;
      label9722:
      paramEntity.strLocationDesc = paramCursor.getString(i);
      break label4750;
      label9737:
      paramEntity.strHometownCodes = paramCursor.getString(i);
      break label4785;
      label9752:
      paramEntity.strHometownDesc = paramCursor.getString(i);
      break label4820;
      label9767:
      paramEntity.strEmail = paramCursor.getString(i);
      break label4855;
      label9782:
      paramEntity.strPersonalNote = paramCursor.getString(i);
      break label4890;
      label9797:
      paramEntity.iProfession = paramCursor.getInt(i);
      break label4925;
      label9812:
      paramEntity.bindPhoneInfo = paramCursor.getString(i);
      break label4960;
      label9827:
      paramEntity.bCardInfo = paramCursor.getBlob(i);
      break label4997;
      label9842:
      paramEntity.strTroopName = paramCursor.getString(i);
      break label5034;
      label9857:
      paramEntity.strTroopNick = paramCursor.getString(i);
      break label5071;
      label9872:
      paramEntity.strMobile = paramCursor.getString(i);
      break label5108;
      label9887:
      paramEntity.strContactName = paramCursor.getString(i);
      break label5145;
      label9902:
      paramEntity.ulShowControl = paramCursor.getInt(i);
      break label5182;
      label9917:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label5219;
      label9932:
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(i);
      break label5256;
      label9947:
      paramEntity.strSpaceName = paramCursor.getString(i);
      break label5293;
      label9962:
      paramEntity.vQzonePhotos = paramCursor.getBlob(i);
      break label5330;
      label9977:
      paramEntity.strStatus = paramCursor.getString(i);
      break label5367;
      label9992:
      paramEntity.strAutoRemark = paramCursor.getString(i);
      break label5404;
      label10007:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label5441;
      label10022:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label5478;
      label10037:
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label5515;
      label10053:
      paramEntity.iQQVipType = paramCursor.getInt(i);
      break label5552;
      label10068:
      paramEntity.iQQVipLevel = paramCursor.getInt(i);
      break label5589;
      label10083:
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label5626;
      label10099:
      paramEntity.iSuperVipType = paramCursor.getInt(i);
      break label5663;
      label10114:
      paramEntity.iSuperVipLevel = paramCursor.getInt(i);
      break label5700;
      label10129:
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label5737;
      label10145:
      paramEntity.iSuperQQType = paramCursor.getInt(i);
      break label5774;
      label10160:
      paramEntity.iSuperQQLevel = paramCursor.getInt(i);
      break label5811;
      label10175:
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label5848;
      label10191:
      paramEntity.iHollywoodVipType = paramCursor.getInt(i);
      break label5885;
      label10206:
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(i);
      break label5922;
      label10221:
      paramEntity.strShowName = paramCursor.getString(i);
      break label5959;
      label10236:
      paramEntity.strVoiceFilekey = paramCursor.getString(i);
      break label5996;
      label10251:
      paramEntity.shDuration = paramCursor.getShort(i);
      break label6033;
      label10266:
      paramEntity.bRead = ((byte)paramCursor.getShort(i));
      break label6070;
      label10282:
      paramEntity.strUrl = paramCursor.getString(i);
      break label6107;
      label10297:
      paramEntity.vRichSign = paramCursor.getBlob(i);
      break label6144;
      label10312:
      paramEntity.lSignModifyTime = paramCursor.getLong(i);
      break label6181;
      label10327:
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
      break label6218;
      label10342:
      paramEntity.strGameLogoUrl_1 = paramCursor.getString(i);
      break label6255;
      label10357:
      paramEntity.strGameLogoUrl_2 = paramCursor.getString(i);
      break label6292;
      label10372:
      paramEntity.strGameLogoUrl_3 = paramCursor.getString(i);
      break label6329;
      label10387:
      paramEntity.strGameLogoUrl_4 = paramCursor.getString(i);
      break label6366;
      label10402:
      paramEntity.strGameLogoKey_1 = paramCursor.getString(i);
      break label6403;
      label10417:
      paramEntity.strGameLogoKey_2 = paramCursor.getString(i);
      break label6440;
      label10432:
      paramEntity.strGameLogoKey_3 = paramCursor.getString(i);
      break label6477;
      label10447:
      paramEntity.strGameLogoKey_4 = paramCursor.getString(i);
      break label6514;
      label10462:
      paramEntity.strGameName_1 = paramCursor.getString(i);
      break label6551;
      label10477:
      paramEntity.strGameName_2 = paramCursor.getString(i);
      break label6588;
      label10492:
      paramEntity.strGameName_3 = paramCursor.getString(i);
      break label6625;
      label10507:
      paramEntity.strGameName_4 = paramCursor.getString(i);
      break label6662;
      label10522:
      paramEntity.strGameAppid_1 = paramCursor.getString(i);
      break label6699;
      label10537:
      paramEntity.strGameAppid_2 = paramCursor.getString(i);
      break label6736;
      label10552:
      paramEntity.strGameAppid_3 = paramCursor.getString(i);
      break label6773;
      label10567:
      paramEntity.strGameAppid_4 = paramCursor.getString(i);
      break label6810;
      label10582:
      paramEntity.strProfileUrl = paramCursor.getString(i);
      break label6847;
      label10597:
      paramEntity.nStarFansFlag = paramCursor.getInt(i);
      break label6884;
      label10612:
      paramEntity.strStarPicUrl_0 = paramCursor.getString(i);
      break label6921;
      label10627:
      paramEntity.strStarPicUrl_1 = paramCursor.getString(i);
      break label6958;
      label10642:
      paramEntity.strStarPicUrl_2 = paramCursor.getString(i);
      break label6995;
      label10657:
      paramEntity.strStarLvUrl_0 = paramCursor.getString(i);
      break label7032;
      label10672:
      paramEntity.strStarLvUrl_1 = paramCursor.getString(i);
      break label7069;
      label10687:
      paramEntity.strStarLvUrl_2 = paramCursor.getString(i);
      break label7106;
      label10702:
      paramEntity.strStarLogoUrl = paramCursor.getString(i);
      break label7143;
      label10717:
      paramEntity.starFansJumpUrl = paramCursor.getString(i);
      break label7180;
      label10732:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label7217;
      label10747:
      paramEntity.lLoginDays = paramCursor.getLong(i);
      break label7254;
      label10762:
      paramEntity.strLoginDaysDesc = paramCursor.getString(i);
      break label7291;
      label10777:
      paramEntity.lQQMasterLogindays = paramCursor.getLong(i);
      break label7328;
      label10792:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowPeopleSee = paramBoolean;
        break;
      }
      label10819:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowCalInteractive = paramBoolean;
        break;
      }
      label10846:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowClick = paramBoolean;
        break;
      }
      label10873:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showLightalk = paramBoolean;
        break;
      }
      label10900:
      paramEntity.lightalkNick = paramCursor.getString(i);
      break label7513;
      label10915:
      paramEntity.lightalkId = paramCursor.getString(i);
      break label7550;
      label10930:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperRedDiamond = paramBoolean;
        break;
      }
      label10957:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRedDiamond = paramBoolean;
        break;
      }
      label10984:
      paramEntity.redLevel = paramCursor.getInt(i);
      break label7661;
      label10999:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label11026:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isYellowDiamond = paramBoolean;
        break;
      }
      label11053:
      paramEntity.yellowLevel = paramCursor.getInt(i);
      break label7772;
      label11068:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label11095:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isGreenDiamond = paramBoolean;
        break;
      }
      label11122:
      paramEntity.greenLevel = paramCursor.getInt(i);
      break label7883;
      label11137:
      paramEntity.uAccelerateMultiple = paramCursor.getLong(i);
      break label7920;
      label11152:
      paramEntity.strRespMusicInfo = paramCursor.getString(i);
      break label7957;
      label11167:
      paramEntity.templateRet = paramCursor.getInt(i);
      break label7994;
      label11182:
      paramEntity.lCurrentStyleId = paramCursor.getLong(i);
      break label8031;
      label11197:
      paramEntity.lCurrentBgId = paramCursor.getLong(i);
      break label8068;
      label11212:
      paramEntity.backgroundUrl = paramCursor.getString(i);
      break label8105;
      label11227:
      paramEntity.backgroundColor = paramCursor.getLong(i);
      break label8142;
      label11242:
      paramEntity.strCurrentBgUrl = paramCursor.getString(i);
      break label8179;
      label11257:
      paramEntity.bgType = paramCursor.getBlob(i);
      break label8216;
      label11272:
      paramEntity.encId = paramCursor.getString(i);
      break label8253;
      label11287:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label8290;
      label11302:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label8327;
      label11317:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.visibleMusicPendant = paramBoolean;
        break;
      }
      label11344:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label11371:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label11398:
      paramEntity.privilegePromptStr = paramCursor.getString(i);
      break label8475;
      label11413:
      paramEntity.privilegeJumpUrl = paramCursor.getString(i);
      break label8512;
      label11428:
      paramEntity.vOpenPriv = paramCursor.getBlob(i);
      break label8549;
      label11443:
      paramEntity.vClosePriv = paramCursor.getBlob(i);
      break label8586;
      label11458:
      paramEntity.addSrcName = paramCursor.getString(i);
      break label8623;
      label11473:
      paramEntity.addSrcId = paramCursor.getLong(i);
      break label8660;
      label11488:
      paramEntity.addSubSrcId = paramCursor.getLong(i);
      break label8697;
      label11503:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label8734;
      label11518:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label8771;
      label11533:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label8808;
      label11548:
      paramEntity.olympicTorch = ((byte)paramCursor.getShort(i));
      break label8845;
      label11564:
      paramEntity.mNowShowFlag = paramCursor.getInt(i);
      break label8882;
      label11579:
      paramEntity.mNowShowIconUrl = paramCursor.getString(i);
      break label8919;
      label11594:
      paramEntity.mNowShowJumpUrl = paramCursor.getString(i);
      break label8956;
      label11609:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
    }
    label11624:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.videoHeadFlag = paramBoolean;
      break;
    }
    label11652:
    paramEntity.videoHeadUrl = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,strSpaceName TEXT ,vQzonePhotos BLOB ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,allowClick INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Card)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("strNick", paramEntity.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramEntity.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramEntity.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramEntity.nFaceID));
    paramContentValues.put("strCertificationInfo", paramEntity.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramEntity.shType));
    paramContentValues.put("vContent", paramEntity.vContent);
    paramContentValues.put("strSign", paramEntity.strSign);
    paramContentValues.put("strCompany", paramEntity.strCompany);
    paramContentValues.put("strSchool", paramEntity.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramEntity.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramEntity.vQQFaceID);
    paramContentValues.put("strReMark", paramEntity.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramEntity.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramEntity.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramEntity.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramEntity.strCompanySame);
    paramContentValues.put("strSchoolSame", paramEntity.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramEntity.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramEntity.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramEntity.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramEntity.lVoteCount));
    paramContentValues.put("tagInfosByte", paramEntity.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramEntity.eUserIdentityType));
    paramContentValues.put("vBackground", paramEntity.vBackground);
    paramContentValues.put("labelInfoBytes", paramEntity.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("constellation", Integer.valueOf(paramEntity.constellation));
    paramContentValues.put("pyFaceUrl", paramEntity.pyFaceUrl);
    paramContentValues.put("location", paramEntity.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramEntity.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramEntity.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramEntity.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramEntity.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramEntity.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramEntity.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramEntity.iQQLevel));
    paramContentValues.put("strProvince", paramEntity.strProvince);
    paramContentValues.put("strCity", paramEntity.strCity);
    paramContentValues.put("strCountry", paramEntity.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramEntity.lBirthday));
    paramContentValues.put("strLocationCodes", paramEntity.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramEntity.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramEntity.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramEntity.strHometownDesc);
    paramContentValues.put("strEmail", paramEntity.strEmail);
    paramContentValues.put("strPersonalNote", paramEntity.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramEntity.iProfession));
    paramContentValues.put("bindPhoneInfo", paramEntity.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramEntity.bCardInfo);
    paramContentValues.put("strTroopName", paramEntity.strTroopName);
    paramContentValues.put("strTroopNick", paramEntity.strTroopNick);
    paramContentValues.put("strMobile", paramEntity.strMobile);
    paramContentValues.put("strContactName", paramEntity.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramEntity.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramEntity.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramEntity.strQzoneFeedsDesc);
    paramContentValues.put("strSpaceName", paramEntity.strSpaceName);
    paramContentValues.put("vQzonePhotos", paramEntity.vQzonePhotos);
    paramContentValues.put("strStatus", paramEntity.strStatus);
    paramContentValues.put("strAutoRemark", paramEntity.strAutoRemark);
    paramContentValues.put("vSeed", paramEntity.vSeed);
    paramContentValues.put("vCookies", paramEntity.vCookies);
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramEntity.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramEntity.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramEntity.iQQVipLevel));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramEntity.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramEntity.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramEntity.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramEntity.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramEntity.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramEntity.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramEntity.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramEntity.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramEntity.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramEntity.strShowName);
    paramContentValues.put("strVoiceFilekey", paramEntity.strVoiceFilekey);
    paramContentValues.put("shDuration", Short.valueOf(paramEntity.shDuration));
    paramContentValues.put("bRead", Byte.valueOf(paramEntity.bRead));
    paramContentValues.put("strUrl", paramEntity.strUrl);
    paramContentValues.put("vRichSign", paramEntity.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramEntity.lSignModifyTime));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramEntity.nLastGameFlag));
    paramContentValues.put("strGameLogoUrl_1", paramEntity.strGameLogoUrl_1);
    paramContentValues.put("strGameLogoUrl_2", paramEntity.strGameLogoUrl_2);
    paramContentValues.put("strGameLogoUrl_3", paramEntity.strGameLogoUrl_3);
    paramContentValues.put("strGameLogoUrl_4", paramEntity.strGameLogoUrl_4);
    paramContentValues.put("strGameLogoKey_1", paramEntity.strGameLogoKey_1);
    paramContentValues.put("strGameLogoKey_2", paramEntity.strGameLogoKey_2);
    paramContentValues.put("strGameLogoKey_3", paramEntity.strGameLogoKey_3);
    paramContentValues.put("strGameLogoKey_4", paramEntity.strGameLogoKey_4);
    paramContentValues.put("strGameName_1", paramEntity.strGameName_1);
    paramContentValues.put("strGameName_2", paramEntity.strGameName_2);
    paramContentValues.put("strGameName_3", paramEntity.strGameName_3);
    paramContentValues.put("strGameName_4", paramEntity.strGameName_4);
    paramContentValues.put("strGameAppid_1", paramEntity.strGameAppid_1);
    paramContentValues.put("strGameAppid_2", paramEntity.strGameAppid_2);
    paramContentValues.put("strGameAppid_3", paramEntity.strGameAppid_3);
    paramContentValues.put("strGameAppid_4", paramEntity.strGameAppid_4);
    paramContentValues.put("strProfileUrl", paramEntity.strProfileUrl);
    paramContentValues.put("nStarFansFlag", Integer.valueOf(paramEntity.nStarFansFlag));
    paramContentValues.put("strStarPicUrl_0", paramEntity.strStarPicUrl_0);
    paramContentValues.put("strStarPicUrl_1", paramEntity.strStarPicUrl_1);
    paramContentValues.put("strStarPicUrl_2", paramEntity.strStarPicUrl_2);
    paramContentValues.put("strStarLvUrl_0", paramEntity.strStarLvUrl_0);
    paramContentValues.put("strStarLvUrl_1", paramEntity.strStarLvUrl_1);
    paramContentValues.put("strStarLvUrl_2", paramEntity.strStarLvUrl_2);
    paramContentValues.put("strStarLogoUrl", paramEntity.strStarLogoUrl);
    paramContentValues.put("starFansJumpUrl", paramEntity.starFansJumpUrl);
    paramContentValues.put("lUserFlag", Long.valueOf(paramEntity.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramEntity.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramEntity.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramEntity.lQQMasterLogindays));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramEntity.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramEntity.allowCalInteractive));
    paramContentValues.put("allowClick", Boolean.valueOf(paramEntity.allowClick));
    paramContentValues.put("showLightalk", Boolean.valueOf(paramEntity.showLightalk));
    paramContentValues.put("lightalkNick", paramEntity.lightalkNick);
    paramContentValues.put("lightalkId", paramEntity.lightalkId);
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramEntity.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramEntity.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramEntity.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramEntity.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramEntity.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramEntity.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramEntity.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramEntity.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramEntity.greenLevel));
    paramContentValues.put("uAccelerateMultiple", Long.valueOf(paramEntity.uAccelerateMultiple));
    paramContentValues.put("strRespMusicInfo", paramEntity.strRespMusicInfo);
    paramContentValues.put("templateRet", Integer.valueOf(paramEntity.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramEntity.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramEntity.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramEntity.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramEntity.backgroundColor));
    paramContentValues.put("strCurrentBgUrl", paramEntity.strCurrentBgUrl);
    paramContentValues.put("bgType", paramEntity.bgType);
    paramContentValues.put("encId", paramEntity.encId);
    paramContentValues.put("busiEntry", paramEntity.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramEntity.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramEntity.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramEntity.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramEntity.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramEntity.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramEntity.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramEntity.vOpenPriv);
    paramContentValues.put("vClosePriv", paramEntity.vClosePriv);
    paramContentValues.put("addSrcName", paramEntity.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramEntity.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramEntity.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramEntity.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramEntity.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramEntity.bAvailVoteCnt));
    paramContentValues.put("olympicTorch", Byte.valueOf(paramEntity.olympicTorch));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramEntity.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramEntity.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramEntity.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramEntity.vCoverInfo);
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramEntity.videoHeadFlag));
    paramContentValues.put("videoHeadUrl", paramEntity.videoHeadUrl);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\CardDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */