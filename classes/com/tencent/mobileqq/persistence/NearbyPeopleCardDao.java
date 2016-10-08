package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyPeopleCardDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public NearbyPeopleCardDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 63;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (NearbyPeopleCard)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.nickname = paramCursor.getString(paramCursor.getColumnIndex("nickname"));
      paramEntity.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramEntity.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
      paramEntity.birthday = paramCursor.getInt(paramCursor.getColumnIndex("birthday"));
      paramEntity.constellation = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("constellation")));
      paramEntity.distance = paramCursor.getString(paramCursor.getColumnIndex("distance"));
      paramEntity.timeDiff = paramCursor.getString(paramCursor.getColumnIndex("timeDiff"));
      paramEntity.likeCount = paramCursor.getInt(paramCursor.getColumnIndex("likeCount"));
      paramEntity.likeCountInc = paramCursor.getInt(paramCursor.getColumnIndex("likeCountInc"));
      paramEntity.oldPhotoCount = paramCursor.getInt(paramCursor.getColumnIndex("oldPhotoCount"));
      paramEntity.dateInfo = paramCursor.getBlob(paramCursor.getColumnIndex("dateInfo"));
      paramEntity.xuanYan = paramCursor.getBlob(paramCursor.getColumnIndex("xuanYan"));
      paramEntity.maritalStatus = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("maritalStatus")));
      paramEntity.job = paramCursor.getInt(paramCursor.getColumnIndex("job"));
      paramEntity.company = paramCursor.getString(paramCursor.getColumnIndex("company"));
      paramEntity.college = paramCursor.getString(paramCursor.getColumnIndex("college"));
      paramEntity.hometownCountry = paramCursor.getString(paramCursor.getColumnIndex("hometownCountry"));
      paramEntity.hometownProvice = paramCursor.getString(paramCursor.getColumnIndex("hometownProvice"));
      paramEntity.hometownCity = paramCursor.getString(paramCursor.getColumnIndex("hometownCity"));
      paramEntity.hometownDistrict = paramCursor.getString(paramCursor.getColumnIndex("hometownDistrict"));
      paramEntity.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramEntity.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramEntity.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramEntity.qzoneFeed = paramCursor.getString(paramCursor.getColumnIndex("qzoneFeed"));
      paramEntity.qzoneName = paramCursor.getString(paramCursor.getColumnIndex("qzoneName"));
      paramEntity.qzonePicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_1"));
      paramEntity.qzonePicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_2"));
      paramEntity.qzonePicUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_3"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isPhotoUseCache")))
      {
        paramBoolean = true;
        paramEntity.isPhotoUseCache = paramBoolean;
        paramEntity.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramEntity.vTempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("vTempChatSig"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchQzone"))) {
          break label1209;
        }
        paramBoolean = true;
        label641:
        paramEntity.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label1214;
        }
        paramBoolean = true;
        label666:
        paramEntity.switchHobby = paramBoolean;
        paramEntity.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramEntity.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label1219;
        }
        paramBoolean = true;
        label745:
        paramEntity.godFlag = paramBoolean;
        paramEntity.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramEntity.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramEntity.lastUpdateNickTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateNickTime"));
        paramEntity.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        paramEntity.switchGiftVisible = paramCursor.getLong(paramCursor.getColumnIndex("switchGiftVisible"));
        paramEntity.vGiftInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vGiftInfo"));
        paramEntity.sayHelloFlag = paramCursor.getInt(paramCursor.getColumnIndex("sayHelloFlag"));
        paramEntity.charm = paramCursor.getLong(paramCursor.getColumnIndex("charm"));
        paramEntity.charmLevel = paramCursor.getInt(paramCursor.getColumnIndex("charmLevel"));
        paramEntity.nextThreshold = paramCursor.getInt(paramCursor.getColumnIndex("nextThreshold"));
        paramEntity.curThreshold = paramCursor.getInt(paramCursor.getColumnIndex("curThreshold"));
        paramEntity.profPercent = paramCursor.getInt(paramCursor.getColumnIndex("profPercent"));
        paramEntity.tagFlag = paramCursor.getLong(paramCursor.getColumnIndex("tagFlag"));
        paramEntity.tagInfo = paramCursor.getString(paramCursor.getColumnIndex("tagInfo"));
        paramEntity.picInfo = paramCursor.getString(paramCursor.getColumnIndex("picInfo"));
        paramEntity.strFreshNewsInfo = paramCursor.getString(paramCursor.getColumnIndex("strFreshNewsInfo"));
        paramEntity.strHotChatInfo = paramCursor.getString(paramCursor.getColumnIndex("strHotChatInfo"));
        paramEntity.uRoomid = paramCursor.getLong(paramCursor.getColumnIndex("uRoomid"));
        paramEntity.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramEntity.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramEntity.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramEntity.collegeId = paramCursor.getLong(paramCursor.getColumnIndex("collegeId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label1224;
        }
      }
      label1209:
      label1214:
      label1219:
      label1224:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.videoHeadFlag = paramBoolean;
        paramEntity.bVideoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("bVideoHeadUrl"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label641;
        paramBoolean = false;
        break label666;
        paramBoolean = false;
        break label745;
      }
    }
    int i = paramCursor.getColumnIndex("tinyId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label3475;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      label1299:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label3490;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nickname", String.class));
      label1334:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label3505;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gender", Byte.TYPE));
      label1369:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3521;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Integer.TYPE));
      label1404:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label3536;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("birthday", Integer.TYPE));
      label1439:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label3551;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("constellation", Byte.TYPE));
      label1474:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label3567;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distance", String.class));
      label1509:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label3582;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timeDiff", String.class));
      label1544:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label3597;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("likeCount", Integer.TYPE));
      label1579:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label3612;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("likeCountInc", Integer.TYPE));
      label1614:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label3627;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label1649:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label3642;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dateInfo", byte[].class));
      label1684:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label3657;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("xuanYan", byte[].class));
      label1719:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label3672;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("maritalStatus", Byte.TYPE));
      label1754:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label3688;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("job", Integer.TYPE));
      label1789:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label3703;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("company", String.class));
      label1824:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label3718;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("college", String.class));
      label1859:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label3733;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownCountry", String.class));
      label1894:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label3748;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownProvice", String.class));
      label1929:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label3763;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownCity", String.class));
      label1964:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label3778;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownDistrict", String.class));
      label1999:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label3793;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCookies", byte[].class));
      label2034:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label3808;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVoted", Byte.TYPE));
      label2069:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label3824;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label2104:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label3839;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneFeed", String.class));
      label2139:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label3854;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneName", String.class));
      label2174:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label3869;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_1", String.class));
      label2209:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label3884;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_2", String.class));
      label2244:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label3899;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_3", String.class));
      label2279:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label3914;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label3941;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vSeed", byte[].class));
      label2349:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label3956;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vTempChatSig", byte[].class));
      label2384:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label3971;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label3998;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label4025;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uiShowControl", Long.TYPE));
      label2489:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label4040;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("userFlag", Long.TYPE));
      label2524:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label4055;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("busiEntry", String.class));
      label2559:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label4070;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label4097;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label2629:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label4112;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProfileUrl", String.class));
      label2664:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label4127;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label2699:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label4142;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label2734:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label4157;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchGiftVisible", Long.TYPE));
      label2769:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label4172;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vGiftInfo", byte[].class));
      label2804:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label4187;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label2839:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label4202;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("charm", Long.TYPE));
      label2874:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label4217;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("charmLevel", Integer.TYPE));
      label2909:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label4232;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nextThreshold", Integer.TYPE));
      label2944:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label4247;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("curThreshold", Integer.TYPE));
      label2979:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label4262;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("profPercent", Integer.TYPE));
      label3014:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label4277;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagFlag", Long.TYPE));
      label3051:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label4292;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagInfo", String.class));
      label3088:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label4307;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("picInfo", String.class));
      label3125:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label4322;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strFreshNewsInfo", String.class));
      label3162:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label4337;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHotChatInfo", String.class));
      label3199:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label4352;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uRoomid", Long.TYPE));
      label3236:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label4367;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label3273:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label4382;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label3310:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label4397;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label3347:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label4412;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("collegeId", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label4427;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label4455;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVideoHeadUrl", String.class));
      return paramEntity;
      paramEntity.tinyId = paramCursor.getLong(i);
      break;
      label3475:
      paramEntity.uin = paramCursor.getString(i);
      break label1299;
      label3490:
      paramEntity.nickname = paramCursor.getString(i);
      break label1334;
      label3505:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label1369;
      label3521:
      paramEntity.age = paramCursor.getInt(i);
      break label1404;
      label3536:
      paramEntity.birthday = paramCursor.getInt(i);
      break label1439;
      label3551:
      paramEntity.constellation = ((byte)paramCursor.getShort(i));
      break label1474;
      label3567:
      paramEntity.distance = paramCursor.getString(i);
      break label1509;
      label3582:
      paramEntity.timeDiff = paramCursor.getString(i);
      break label1544;
      label3597:
      paramEntity.likeCount = paramCursor.getInt(i);
      break label1579;
      label3612:
      paramEntity.likeCountInc = paramCursor.getInt(i);
      break label1614;
      label3627:
      paramEntity.oldPhotoCount = paramCursor.getInt(i);
      break label1649;
      label3642:
      paramEntity.dateInfo = paramCursor.getBlob(i);
      break label1684;
      label3657:
      paramEntity.xuanYan = paramCursor.getBlob(i);
      break label1719;
      label3672:
      paramEntity.maritalStatus = ((byte)paramCursor.getShort(i));
      break label1754;
      label3688:
      paramEntity.job = paramCursor.getInt(i);
      break label1789;
      label3703:
      paramEntity.company = paramCursor.getString(i);
      break label1824;
      label3718:
      paramEntity.college = paramCursor.getString(i);
      break label1859;
      label3733:
      paramEntity.hometownCountry = paramCursor.getString(i);
      break label1894;
      label3748:
      paramEntity.hometownProvice = paramCursor.getString(i);
      break label1929;
      label3763:
      paramEntity.hometownCity = paramCursor.getString(i);
      break label1964;
      label3778:
      paramEntity.hometownDistrict = paramCursor.getString(i);
      break label1999;
      label3793:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label2034;
      label3808:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label2069;
      label3824:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label2104;
      label3839:
      paramEntity.qzoneFeed = paramCursor.getString(i);
      break label2139;
      label3854:
      paramEntity.qzoneName = paramCursor.getString(i);
      break label2174;
      label3869:
      paramEntity.qzonePicUrl_1 = paramCursor.getString(i);
      break label2209;
      label3884:
      paramEntity.qzonePicUrl_2 = paramCursor.getString(i);
      break label2244;
      label3899:
      paramEntity.qzonePicUrl_3 = paramCursor.getString(i);
      break label2279;
      label3914:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isPhotoUseCache = paramBoolean;
        break;
      }
      label3941:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label2349;
      label3956:
      paramEntity.vTempChatSig = paramCursor.getBlob(i);
      break label2384;
      label3971:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.switchQzone = paramBoolean;
        break;
      }
      label3998:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.switchHobby = paramBoolean;
        break;
      }
      label4025:
      paramEntity.uiShowControl = paramCursor.getLong(i);
      break label2489;
      label4040:
      paramEntity.userFlag = paramCursor.getLong(i);
      break label2524;
      label4055:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label2559;
      label4070:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.godFlag = paramBoolean;
        break;
      }
      label4097:
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
      break label2629;
      label4112:
      paramEntity.strProfileUrl = paramCursor.getString(i);
      break label2664;
      label4127:
      paramEntity.lastUpdateNickTime = paramCursor.getLong(i);
      break label2699;
      label4142:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label2734;
      label4157:
      paramEntity.switchGiftVisible = paramCursor.getLong(i);
      break label2769;
      label4172:
      paramEntity.vGiftInfo = paramCursor.getBlob(i);
      break label2804;
      label4187:
      paramEntity.sayHelloFlag = paramCursor.getInt(i);
      break label2839;
      label4202:
      paramEntity.charm = paramCursor.getLong(i);
      break label2874;
      label4217:
      paramEntity.charmLevel = paramCursor.getInt(i);
      break label2909;
      label4232:
      paramEntity.nextThreshold = paramCursor.getInt(i);
      break label2944;
      label4247:
      paramEntity.curThreshold = paramCursor.getInt(i);
      break label2979;
      label4262:
      paramEntity.profPercent = paramCursor.getInt(i);
      break label3014;
      label4277:
      paramEntity.tagFlag = paramCursor.getLong(i);
      break label3051;
      label4292:
      paramEntity.tagInfo = paramCursor.getString(i);
      break label3088;
      label4307:
      paramEntity.picInfo = paramCursor.getString(i);
      break label3125;
      label4322:
      paramEntity.strFreshNewsInfo = paramCursor.getString(i);
      break label3162;
      label4337:
      paramEntity.strHotChatInfo = paramCursor.getString(i);
      break label3199;
      label4352:
      paramEntity.uRoomid = paramCursor.getLong(i);
      break label3236;
      label4367:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label3273;
      label4382:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label3310;
      label4397:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label3347;
      label4412:
      paramEntity.collegeId = paramCursor.getLong(i);
    }
    label4427:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.videoHeadFlag = paramBoolean;
      break;
    }
    label4455:
    paramEntity.bVideoHeadUrl = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (NearbyPeopleCard)paramEntity;
    paramContentValues.put("tinyId", Long.valueOf(paramEntity.tinyId));
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("nickname", paramEntity.nickname);
    paramContentValues.put("gender", Byte.valueOf(paramEntity.gender));
    paramContentValues.put("age", Integer.valueOf(paramEntity.age));
    paramContentValues.put("birthday", Integer.valueOf(paramEntity.birthday));
    paramContentValues.put("constellation", Byte.valueOf(paramEntity.constellation));
    paramContentValues.put("distance", paramEntity.distance);
    paramContentValues.put("timeDiff", paramEntity.timeDiff);
    paramContentValues.put("likeCount", Integer.valueOf(paramEntity.likeCount));
    paramContentValues.put("likeCountInc", Integer.valueOf(paramEntity.likeCountInc));
    paramContentValues.put("oldPhotoCount", Integer.valueOf(paramEntity.oldPhotoCount));
    paramContentValues.put("dateInfo", paramEntity.dateInfo);
    paramContentValues.put("xuanYan", paramEntity.xuanYan);
    paramContentValues.put("maritalStatus", Byte.valueOf(paramEntity.maritalStatus));
    paramContentValues.put("job", Integer.valueOf(paramEntity.job));
    paramContentValues.put("company", paramEntity.company);
    paramContentValues.put("college", paramEntity.college);
    paramContentValues.put("hometownCountry", paramEntity.hometownCountry);
    paramContentValues.put("hometownProvice", paramEntity.hometownProvice);
    paramContentValues.put("hometownCity", paramEntity.hometownCity);
    paramContentValues.put("hometownDistrict", paramEntity.hometownDistrict);
    paramContentValues.put("vCookies", paramEntity.vCookies);
    paramContentValues.put("bVoted", Byte.valueOf(paramEntity.bVoted));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramEntity.feedPreviewTime));
    paramContentValues.put("qzoneFeed", paramEntity.qzoneFeed);
    paramContentValues.put("qzoneName", paramEntity.qzoneName);
    paramContentValues.put("qzonePicUrl_1", paramEntity.qzonePicUrl_1);
    paramContentValues.put("qzonePicUrl_2", paramEntity.qzonePicUrl_2);
    paramContentValues.put("qzonePicUrl_3", paramEntity.qzonePicUrl_3);
    paramContentValues.put("isPhotoUseCache", Boolean.valueOf(paramEntity.isPhotoUseCache));
    paramContentValues.put("vSeed", paramEntity.vSeed);
    paramContentValues.put("vTempChatSig", paramEntity.vTempChatSig);
    paramContentValues.put("switchQzone", Boolean.valueOf(paramEntity.switchQzone));
    paramContentValues.put("switchHobby", Boolean.valueOf(paramEntity.switchHobby));
    paramContentValues.put("uiShowControl", Long.valueOf(paramEntity.uiShowControl));
    paramContentValues.put("userFlag", Long.valueOf(paramEntity.userFlag));
    paramContentValues.put("busiEntry", paramEntity.busiEntry);
    paramContentValues.put("godFlag", Boolean.valueOf(paramEntity.godFlag));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramEntity.nLastGameFlag));
    paramContentValues.put("strProfileUrl", paramEntity.strProfileUrl);
    paramContentValues.put("lastUpdateNickTime", Long.valueOf(paramEntity.lastUpdateNickTime));
    paramContentValues.put("favoriteSource", Integer.valueOf(paramEntity.favoriteSource));
    paramContentValues.put("switchGiftVisible", Long.valueOf(paramEntity.switchGiftVisible));
    paramContentValues.put("vGiftInfo", paramEntity.vGiftInfo);
    paramContentValues.put("sayHelloFlag", Integer.valueOf(paramEntity.sayHelloFlag));
    paramContentValues.put("charm", Long.valueOf(paramEntity.charm));
    paramContentValues.put("charmLevel", Integer.valueOf(paramEntity.charmLevel));
    paramContentValues.put("nextThreshold", Integer.valueOf(paramEntity.nextThreshold));
    paramContentValues.put("curThreshold", Integer.valueOf(paramEntity.curThreshold));
    paramContentValues.put("profPercent", Integer.valueOf(paramEntity.profPercent));
    paramContentValues.put("tagFlag", Long.valueOf(paramEntity.tagFlag));
    paramContentValues.put("tagInfo", paramEntity.tagInfo);
    paramContentValues.put("picInfo", paramEntity.picInfo);
    paramContentValues.put("strFreshNewsInfo", paramEntity.strFreshNewsInfo);
    paramContentValues.put("strHotChatInfo", paramEntity.strHotChatInfo);
    paramContentValues.put("uRoomid", Long.valueOf(paramEntity.uRoomid));
    paramContentValues.put("strVoteLimitedNotice", paramEntity.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramEntity.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramEntity.bAvailVoteCnt));
    paramContentValues.put("collegeId", Long.valueOf(paramEntity.collegeId));
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramEntity.videoHeadFlag));
    paramContentValues.put("bVideoHeadUrl", paramEntity.bVideoHeadUrl);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\NearbyPeopleCardDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */