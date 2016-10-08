package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopInfoDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public TroopInfoDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 70;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool = true;
    paramBoolean = true;
    paramEntity = (TroopInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramEntity.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramEntity.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramEntity.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramEntity.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramEntity.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramEntity.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramEntity.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramEntity.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramEntity.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramEntity.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramEntity.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramEntity.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramEntity.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramEntity.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramEntity.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramEntity.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramEntity.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramEntity.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramEntity.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramEntity.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramEntity.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramEntity.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramEntity.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramEntity.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramEntity.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramEntity.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramEntity.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramEntity.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramEntity.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramEntity.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramEntity.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramEntity.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramEntity.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramEntity.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramEntity.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag"))) {}
      for (;;)
      {
        paramEntity.mMemberInvitingFlag = paramBoolean;
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramEntity.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramEntity.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramEntity.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramEntity.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramEntity.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramEntity.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramEntity.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramEntity.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramEntity.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramEntity.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramEntity.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramEntity.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramEntity.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramEntity.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramEntity.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramEntity.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramEntity.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramEntity.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        return paramEntity;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label3811;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timeSec", Long.TYPE));
      label1378:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label3826;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopuin", String.class));
      label1413:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label3841;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopcode", String.class));
      label1448:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label3856;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopowneruin", String.class));
      label1483:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label3871;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopname", String.class));
      label1518:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label3886;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopface", Short.TYPE));
      label1553:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label3901;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopmemo", String.class));
      label1588:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label3916;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("fingertroopmemo", String.class));
      label1623:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label3931;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mRichFingerMemo", String.class));
      label1658:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label3946;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopmask", Integer.TYPE));
      label1693:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label3961;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("trooptype", Integer.TYPE));
      label1728:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label3976;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopCreateTime", Long.TYPE));
      label1763:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label3991;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupFlag", Long.TYPE));
      label1798:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label4006;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cGroupOption", Short.TYPE));
      label1833:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label4021;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wMemberMax", Integer.TYPE));
      label1868:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label4036;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("maxAdminNum", Integer.TYPE));
      label1903:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label4051;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wSpecialClass", Integer.TYPE));
      label1938:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label4066;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cGroupLevel", Short.TYPE));
      label1973:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label4081;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wMemberNum", Integer.TYPE));
      label2008:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label4096;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("Administrator", String.class));
      label2043:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label4111;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label2078:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label4126;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mGroupClassExtText", String.class));
      label2113:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label4141;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label2148:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label4156;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label2183:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label4171;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopAuthenticateInfo", String.class));
      label2218:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label4186;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label2253:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label4201;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label2288:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label4216;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label2323:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label4231;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label2358:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label4246;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label2393:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label4261;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label2428:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label4276;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label2463:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label4292;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label2498:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label4308;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopLevelMap", String.class));
      label2533:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label4323;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("joinTroopQuestion", String.class));
      label2568:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label4338;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("joinTroopAnswer", String.class));
      label2603:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label4353;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cAlbumResult", Byte.TYPE));
      label2638:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label4369;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwTimeStamp", Long.TYPE));
      label2673:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label4384;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strQZonePhotoUrls", String.class));
      label2708:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label4399;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label2743:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label4414;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLocation", String.class));
      label2778:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label4429;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopLat", Integer.TYPE));
      label2813:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label4444;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopLon", Integer.TYPE));
      label2848:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label4459;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label4487;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label2918:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label4502;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mCompareSpell", String.class));
      label2953:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label4517;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mSomeMemberUins", String.class));
      label2988:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label4532;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTags", String.class));
      label3023:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label4547;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label3058:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label4562;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nTroopGrade", Integer.TYPE));
      label3093:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label4577;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label3128:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label4592;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label3165:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label4607;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label3202:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label4622;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label3239:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label4637;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label3276:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label4652;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopTypeExt", Integer.TYPE));
      label3313:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label4667;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ownerNameShow", String.class));
      label3350:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label4682;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("adminNameShow", String.class));
      label3387:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label4697;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwOfficeMode", Long.TYPE));
      label3424:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label4712;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label3461:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label4727;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label3498:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label4742;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopCreditLevel", Long.TYPE));
      label3535:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label4757;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label3572:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label4772;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label3609:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label4787;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("topicId", String.class));
      label3646:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label4802;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("associatePubAccount", Long.TYPE));
      label3683:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label4817;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label3720:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label4832;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label4847;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTribeStatus", Integer.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label3811:
      paramEntity.timeSec = paramCursor.getLong(i);
      break label1378;
      label3826:
      paramEntity.troopuin = paramCursor.getString(i);
      break label1413;
      label3841:
      paramEntity.troopcode = paramCursor.getString(i);
      break label1448;
      label3856:
      paramEntity.troopowneruin = paramCursor.getString(i);
      break label1483;
      label3871:
      paramEntity.troopname = paramCursor.getString(i);
      break label1518;
      label3886:
      paramEntity.troopface = paramCursor.getShort(i);
      break label1553;
      label3901:
      paramEntity.troopmemo = paramCursor.getString(i);
      break label1588;
      label3916:
      paramEntity.fingertroopmemo = paramCursor.getString(i);
      break label1623;
      label3931:
      paramEntity.mRichFingerMemo = paramCursor.getString(i);
      break label1658;
      label3946:
      paramEntity.troopmask = paramCursor.getInt(i);
      break label1693;
      label3961:
      paramEntity.trooptype = paramCursor.getInt(i);
      break label1728;
      label3976:
      paramEntity.troopCreateTime = paramCursor.getLong(i);
      break label1763;
      label3991:
      paramEntity.dwGroupFlag = paramCursor.getLong(i);
      break label1798;
      label4006:
      paramEntity.cGroupOption = paramCursor.getShort(i);
      break label1833;
      label4021:
      paramEntity.wMemberMax = paramCursor.getInt(i);
      break label1868;
      label4036:
      paramEntity.maxAdminNum = paramCursor.getInt(i);
      break label1903;
      label4051:
      paramEntity.wSpecialClass = paramCursor.getInt(i);
      break label1938;
      label4066:
      paramEntity.cGroupLevel = paramCursor.getShort(i);
      break label1973;
      label4081:
      paramEntity.wMemberNum = paramCursor.getInt(i);
      break label2008;
      label4096:
      paramEntity.Administrator = paramCursor.getString(i);
      break label2043;
      label4111:
      paramEntity.dwGroupClassExt = paramCursor.getLong(i);
      break label2078;
      label4126:
      paramEntity.mGroupClassExtText = paramCursor.getString(i);
      break label2113;
      label4141:
      paramEntity.dwGroupFlagExt = paramCursor.getLong(i);
      break label2148;
      label4156:
      paramEntity.dwAuthGroupType = paramCursor.getLong(i);
      break label2183;
      label4171:
      paramEntity.troopAuthenticateInfo = paramCursor.getString(i);
      break label2218;
      label4186:
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(i);
      break label2253;
      label4201:
      paramEntity.mMemberNumSeq = paramCursor.getLong(i);
      break label2288;
      label4216:
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(i);
      break label2323;
      label4231:
      paramEntity.mMemberCardSeq = paramCursor.getLong(i);
      break label2358;
      label4246:
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(i);
      break label2393;
      label4261:
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(i);
      break label2428;
      label4276:
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label2463;
      label4292:
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label2498;
      label4308:
      paramEntity.troopLevelMap = paramCursor.getString(i);
      break label2533;
      label4323:
      paramEntity.joinTroopQuestion = paramCursor.getString(i);
      break label2568;
      label4338:
      paramEntity.joinTroopAnswer = paramCursor.getString(i);
      break label2603;
      label4353:
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label2638;
      label4369:
      paramEntity.dwTimeStamp = paramCursor.getLong(i);
      break label2673;
      label4384:
      paramEntity.strQZonePhotoUrls = paramCursor.getString(i);
      break label2708;
      label4399:
      paramEntity.mQZonePhotoNum = paramCursor.getInt(i);
      break label2743;
      label4414:
      paramEntity.strLocation = paramCursor.getString(i);
      break label2778;
      label4429:
      paramEntity.troopLat = paramCursor.getInt(i);
      break label2813;
      label4444:
      paramEntity.troopLon = paramCursor.getInt(i);
      break label2848;
      label4459:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramEntity.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label4487:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label2918;
      label4502:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label2953;
      label4517:
      paramEntity.mSomeMemberUins = paramCursor.getString(i);
      break label2988;
      label4532:
      paramEntity.mTags = paramCursor.getString(i);
      break label3023;
      label4547:
      paramEntity.mTroopAvatarId = paramCursor.getInt(i);
      break label3058;
      label4562:
      paramEntity.nTroopGrade = paramCursor.getInt(i);
      break label3093;
      label4577:
      paramEntity.isShowInNearbyTroops = paramCursor.getInt(i);
      break label3128;
      label4592:
      paramEntity.dwGagTimeStamp = paramCursor.getLong(i);
      break label3165;
      label4607:
      paramEntity.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label3202;
      label4622:
      paramEntity.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label3239;
      label4637:
      paramEntity.dwAdditionalFlag = paramCursor.getLong(i);
      break label3276;
      label4652:
      paramEntity.troopTypeExt = paramCursor.getInt(i);
      break label3313;
      label4667:
      paramEntity.ownerNameShow = paramCursor.getString(i);
      break label3350;
      label4682:
      paramEntity.adminNameShow = paramCursor.getString(i);
      break label3387;
      label4697:
      paramEntity.dwOfficeMode = paramCursor.getLong(i);
      break label3424;
      label4712:
      paramEntity.troopPrivilegeFlag = paramCursor.getLong(i);
      break label3461;
      label4727:
      paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label3498;
      label4742:
      paramEntity.troopCreditLevel = paramCursor.getLong(i);
      break label3535;
      label4757:
      paramEntity.troopCreditLevelInfo = paramCursor.getLong(i);
      break label3572;
      label4772:
      paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label3609;
      label4787:
      paramEntity.topicId = paramCursor.getString(i);
      break label3646;
      label4802:
      paramEntity.associatePubAccount = paramCursor.getLong(i);
      break label3683;
      label4817:
      paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label3720;
      label4832:
      paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(i);
    }
    label4847:
    paramEntity.mTribeStatus = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,troopPrivilegeFlag INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramEntity.timeSec));
    paramContentValues.put("troopuin", paramEntity.troopuin);
    paramContentValues.put("troopcode", paramEntity.troopcode);
    paramContentValues.put("troopowneruin", paramEntity.troopowneruin);
    paramContentValues.put("troopname", paramEntity.troopname);
    paramContentValues.put("troopface", Short.valueOf(paramEntity.troopface));
    paramContentValues.put("troopmemo", paramEntity.troopmemo);
    paramContentValues.put("fingertroopmemo", paramEntity.fingertroopmemo);
    paramContentValues.put("mRichFingerMemo", paramEntity.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramEntity.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramEntity.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramEntity.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramEntity.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramEntity.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramEntity.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramEntity.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramEntity.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramEntity.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramEntity.wMemberNum));
    paramContentValues.put("Administrator", paramEntity.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramEntity.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramEntity.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramEntity.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramEntity.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramEntity.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramEntity.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramEntity.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramEntity.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramEntity.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramEntity.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramEntity.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramEntity.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramEntity.cGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramEntity.troopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramEntity.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramEntity.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramEntity.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramEntity.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramEntity.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramEntity.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramEntity.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramEntity.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramEntity.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramEntity.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramEntity.mSomeMemberUins);
    paramContentValues.put("mTags", paramEntity.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramEntity.mTroopAvatarId));
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramEntity.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramEntity.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramEntity.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramEntity.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramEntity.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramEntity.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramEntity.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramEntity.ownerNameShow);
    paramContentValues.put("adminNameShow", paramEntity.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramEntity.dwOfficeMode));
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramEntity.troopPrivilegeFlag));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramEntity.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramEntity.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramEntity.troopCreditLevelInfo));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramEntity.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramEntity.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramEntity.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramEntity.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramEntity.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramEntity.mTribeStatus));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\TroopInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */