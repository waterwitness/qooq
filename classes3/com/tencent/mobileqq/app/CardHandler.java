package com.tencent.mobileqq.app;

import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import KQQ.SetUserInfoResp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.MakeFriendsCard;
import QQService.PushVoteIncreaseInfo;
import QQService.RespAddFace;
import QQService.RespDelFace;
import QQService.RespFaceInfo;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFace;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHYMakeFriendsCard;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
import QQService.RespVote;
import QQService.UserCntlData;
import QQService.UserProfile;
import QQService.Visitor;
import SummaryCard.RespVoiceManage;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.olympic.OlympicHandler;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import cooperation.qzone.UploadEnv;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import pur;
import pus;
import put;
import puu;
import tencent.im.ilive.photo.NowLiveGallary.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspPansocialInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp;

public class CardHandler
  extends BusinessHandler
{
  public static final int A = 30;
  public static final String A = "hometown_desc";
  public static final int B = 31;
  public static final String B = "email";
  public static final int C = 32;
  public static final String C = "personalNote";
  public static final int D = 33;
  public static final String D = "key_xuan_yan";
  public static final String E = "key_new_nickname";
  public static final String F = "key_marital_status";
  public static final String G = "key_qzone_switch";
  public static final int H = 34;
  public static final String H = "key_hobby_switch";
  public static final int I = 35;
  public static final String I = "key_flower_visible_switch";
  public static final int J = 36;
  public static final String J = "key_new_profile_modified_flag";
  public static final int K = 37;
  public static final String K = "key_is_nearby_people_card";
  public static final int L = 38;
  public static final String L = "key_interest_switch";
  public static final int M = 39;
  public static final String M = "key_music_switch";
  public static final int N = 40;
  public static final String N = "key_recent_activity_switch";
  public static final int O = 41;
  public static final String O = "key_star_switch";
  public static final int P = 42;
  public static final String P = "key_joined_group_switch";
  public static final int Q = 43;
  public static final String Q = "key_ktv_switch";
  public static final int R = 44;
  public static final String R = "key_eat_switch";
  public static final int S = 45;
  public static final String S = "key_reader_switch";
  public static final String T = "key_radio_switch";
  public static final int U = 46;
  public static final String U = "key_now_switch";
  public static final int V = 47;
  public static final String V = "key_comic_switch";
  public static final int W = 48;
  public static final String W = "key_nearby_people_card_force_update";
  public static final int X = 49;
  private static final String X = "CardHandler";
  public static final int Y = 50;
  public static final int Z = 51;
  public static final int a = 0;
  public static final String a = "PubAccountSvc.get_detail_info";
  public static final Vector a;
  static final boolean jdField_a_of_type_Boolean = true;
  public static final int aA = 640;
  public static final int aB = 960;
  public static final int aC = 120;
  public static final int aD = 1000277;
  public static final int aa = 52;
  public static final int ab = 53;
  public static final int ac = 54;
  public static final int ad = 55;
  public static final int ae = 56;
  public static final int af = 57;
  public static final int ag = 58;
  public static final int ah = 59;
  public static final int ai = 60;
  public static final int aj = 61;
  public static final int ak = 62;
  public static final int al = 63;
  public static final int am = 64;
  public static final int an = 65;
  public static final int ao = 66;
  public static final int ap = 67;
  public static final int aq = 68;
  public static final int ar = 69;
  public static final int as = 70;
  public static final int at = 71;
  public static final int au = 72;
  public static final int av = 73;
  public static final int aw = 0;
  public static final int ax = 60;
  public static final int ay = 100;
  public static final int az = 160;
  public static final int b = 1;
  public static final String b = "SQQShopFolderSvc.GetAcctBindPuin";
  public static final Vector b;
  public static final int c = 2;
  public static final String c;
  public static final int d = 3;
  public static final String d = "background";
  public static final int e = 5;
  public static final String e = "temp";
  public static final int f = 6;
  public static final String f = "HDAvatar";
  public static final int g = 7;
  public static final String g = "voice";
  public static final int h = 8;
  public static final String h = ";";
  public static final int i = 9;
  public static final String i = "_TIMESTAMP";
  public static final int j = 10;
  public static final String j = "_TEMP_COVER_FILEKEY";
  public static final int k = 11;
  public static final String k = "com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive";
  public static final int l = 12;
  public static final String l = "com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive";
  public static final int m = 13;
  public static final String m = "ilive.photo_wall";
  public static final int n = 17;
  public static final int o = 19;
  public static final String o = "nick";
  public static final int p = 20;
  public static final String p = "sex";
  public static final int q = 20;
  public static final String q = "birthday";
  public static final int r = 21;
  public static final String r = "age";
  public static final int s = 22;
  public static final String s = "key_constellation";
  public static final int t = 23;
  public static final String t = "profession";
  public static final int u = 24;
  public static final String u = "company";
  public static final int v = 25;
  public static final String v = "college";
  public static final int w = 26;
  public static final String w = "location";
  public static final int x = 27;
  public static final String x = "locationo_desc";
  public static final int y = 28;
  public static final String y = "location_name";
  public static final int z = 29;
  public static final String z = "hometown";
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  short jdField_a_of_type_Short = 9;
  short b;
  short c;
  public String n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = AppConstants.bj + "portrait/";
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
  }
  
  public CardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Short = 40492;
    this.jdField_c_of_type_Short = 40529;
    if (jdField_a_of_type_JavaUtilVector.size() == 0)
    {
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
    }
    if (jdField_b_of_type_JavaUtilVector.size() == 0)
    {
      jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(960));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(120));
    }
  }
  
  protected static int a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i1 = paramContext.widthPixels;
    int i2 = paramContext.heightPixels;
    if (i1 > i2) {
      return i1;
    }
    return i2;
  }
  
  private static final SongInfo a(JSONObject paramJSONObject)
  {
    long l2 = 0L;
    SongInfo localSongInfo = new SongInfo();
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("ringurl")) {
          break label258;
        }
        str = paramJSONObject.getString("ringurl");
        if (TextUtils.isEmpty(str))
        {
          if (!paramJSONObject.has("url")) {
            break label265;
          }
          str = paramJSONObject.getString("url");
          localSongInfo.jdField_a_of_type_JavaLangString = str;
          if (paramJSONObject.has("songid"))
          {
            l1 = paramJSONObject.getLong("songid");
            localSongInfo.jdField_a_of_type_Long = l1;
            if (!paramJSONObject.has("songname")) {
              break label242;
            }
            str = paramJSONObject.getString("songname");
            localSongInfo.jdField_b_of_type_JavaLangString = str;
            localSongInfo.jdField_b_of_type_JavaLangString = a(localSongInfo.jdField_b_of_type_JavaLangString);
            if (!paramJSONObject.has("singername")) {
              break label272;
            }
            str = paramJSONObject.getString("singername");
            localSongInfo.g = str;
            localSongInfo.g = a(localSongInfo.g);
            l1 = l2;
            if (paramJSONObject.has("singeruin")) {
              l1 = paramJSONObject.getLong("singeruin");
            }
            localSongInfo.jdField_b_of_type_Long = l1;
            if (!paramJSONObject.has("albumname")) {
              break label249;
            }
            paramJSONObject = paramJSONObject.getString("albumname");
            localSongInfo.f = paramJSONObject;
            localSongInfo.f = a(localSongInfo.f);
            return localSongInfo;
          }
        }
        else
        {
          localSongInfo.jdField_a_of_type_JavaLangString = str;
          continue;
        }
        long l1 = 0L;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("CardHandler", 1, "MusicGeneWebViewPlugin.convertJSonObject2MusicGeneSongInfo exception", paramJSONObject);
        return localSongInfo;
      }
      continue;
      label242:
      String str = "";
      continue;
      label249:
      paramJSONObject = "";
      continue;
      return localSongInfo;
      label258:
      str = "";
      continue;
      label265:
      str = "";
      continue;
      label272:
      str = "";
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0).getString(paramString + "_TEMP_COVER_FILEKEY", null);
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new String(Base64.a(paramString), "UTF-8");
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString)) || (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      return "";
    }
    return jdField_c_of_type_JavaLangString + paramInt + "/" + paramString + ".jpg";
  }
  
  public static String a(List paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.clear();
    if (paramList.size() > 0)
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        localLinkedList.add(HexUtil.a(((FaceInfo)paramList.get(i1)).vFaceID));
        i1 += 1;
      }
      return b(localLinkedList);
    }
    return ";";
  }
  
  public static LinkedList a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int i1 = 0;
      while (i1 < paramString.length)
      {
        if ((paramString[i1] != null) && (!"".equals(paramString[i1]))) {
          localLinkedList.add(paramString[i1]);
        }
        i1 += 1;
      }
    }
    return localLinkedList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, "_TEMP_COVER_FILEKEY", paramString2);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    if ((paramString3 == null) || ("".equals(paramString3))) {
      paramContext.remove(paramString1 + paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + paramString2, paramString3);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = (RespVote)paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
    paramBundle.putString("targetUin", paramFromServiceMsg);
    paramBundle.putString("selfUin", paramToServiceMsg);
    if ((paramObject != null) && (((RespVote)paramObject).stHeader.iReplyCode == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (!TextUtils.isEmpty(paramFromServiceMsg)))
      {
        paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.lVoteCount -= 1L;
          paramFromServiceMsg.bVoted = 0;
          paramToServiceMsg.a(paramFromServiceMsg);
        }
      }
      a(5, bool, paramBundle);
      return;
    }
  }
  
  public static void a(String paramString, List paramList) {}
  
  private void a(List paramList, Bundle paramBundle)
  {
    a(paramList, paramBundle, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private void a(List paramList, Bundle paramBundle, String paramString)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramList.size() * 2 + 7);
    localByteBuffer.putInt((int)Long.parseLong(paramString));
    localByteBuffer.put((byte)0);
    localByteBuffer.putShort((short)paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localByteBuffer.putShort(((Short)paramList.next()).shortValue());
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramList = a("OidbSvc.0x480_9");
    paramList.putWupBuffer(localOIDBSSOPkg.toByteArray());
    if (paramBundle != null) {
      paramList.extraData.putAll(paramBundle);
    }
    paramList.extraData.putBoolean("reqFromCardHandler", true);
    b(paramList);
  }
  
  public static int b(Context paramContext)
  {
    return 640;
  }
  
  public static String b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuffer.append((String)paramList.get(i1));
      if (i1 < i2 - 1) {
        localStringBuffer.append(";");
      }
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    paramObject = paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int i1 = paramToServiceMsg.extraData.getInt("favoriteSource");
    int i2 = paramToServiceMsg.extraData.getInt("iCount");
    int i3 = paramToServiceMsg.extraData.getInt("from");
    paramBundle.putString("targetUin", Long.toString(l1));
    paramBundle.putString("selfUin", Long.toString(l2));
    paramBundle.putInt("favoriteSource", i1);
    paramBundle.putInt("iCount", i2);
    paramBundle.putInt("from", i3);
    if ((paramObject != null) && ((paramObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)paramObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramFromServiceMsg.put("param_FailCode", "0");
        StatisticCollector.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramFromServiceMsg, "", false);
        if (!bool1) {
          break label649;
        }
        if (l1 > 0L)
        {
          paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          paramFromServiceMsg = paramToServiceMsg.a(String.valueOf(l1));
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg.lVoteCount += i2;
            paramFromServiceMsg.bVoted = 1;
            paramFromServiceMsg.bAvailVoteCnt = ((short)(paramFromServiceMsg.bAvailVoteCnt - i2));
            if (paramFromServiceMsg.bAvailVoteCnt < 0) {
              paramFromServiceMsg.bAvailVoteCnt = 0;
            }
            paramToServiceMsg.a(paramFromServiceMsg);
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.profilecard.", 4, "back reqFavorite| save card = " + paramFromServiceMsg.uin + "," + paramFromServiceMsg.lVoteCount);
            }
          }
          VoteUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l1, i2);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + bool1 + "," + l1 + "," + i2);
      }
      a(32, bool1, paramBundle);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramToServiceMsg.stHeader.iReplyCode);
      }
      paramFromServiceMsg.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      break;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
        if (paramObject != null)
        {
          paramToServiceMsg = "not RespFavorite";
          label566:
          QLog.i("Q.profilecard.", 2, paramToServiceMsg);
        }
      }
      else
      {
        if (paramObject == null) {
          break label642;
        }
      }
      label642:
      for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
      {
        paramFromServiceMsg.put("param_FailCode", paramToServiceMsg);
        StatisticCollector.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramFromServiceMsg, "", false);
        bool1 = bool2;
        break;
        paramToServiceMsg = "null";
        break label566;
      }
      label649:
      if (l1 <= 0L) {}
    }
  }
  
  public static int c(Context paramContext)
  {
    int i1 = a(paramContext);
    if (i1 <= 240) {
      return 60;
    }
    if (i1 <= 320) {
      return 100;
    }
    return 160;
  }
  
  public static void c()
  {
    int i3 = 0;
    Object localObject = new File(jdField_c_of_type_JavaLangString);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!((File)localObject).exists()) {}
    try
    {
      bool1 = ((File)localObject).mkdirs();
      if (bool1)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add("background");
        ((ArrayList)localObject).add("temp");
        ((ArrayList)localObject).add("HDAvatar");
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= jdField_a_of_type_JavaUtilVector.size()) {
            break;
          }
          ((ArrayList)localObject).add(String.valueOf(((Integer)jdField_a_of_type_JavaUtilVector.get(i1)).intValue()));
          i1 += 1;
        }
        if (i2 < ((ArrayList)localObject).size())
        {
          localFile = new File(jdField_c_of_type_JavaLangString + "/" + (String)((ArrayList)localObject).get(i2));
          if (localFile.exists()) {}
        }
      }
    }
    catch (SecurityException localSecurityException1)
    {
      try
      {
        for (;;)
        {
          int i2;
          File localFile;
          localFile.mkdir();
          i2 += 1;
        }
        localSecurityException1 = localSecurityException1;
        bool1 = bool2;
      }
      catch (SecurityException localSecurityException2)
      {
        for (;;) {}
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin());
      paramFromServiceMsg = (RespGetFavoriteList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a(3, 7);
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        a(42, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        return;
      }
      Iterator localIterator = paramFromServiceMsg.vFavoriteInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      while (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        if (QLog.isDevelopLevel()) {
          QLog.d("favolist", 4, "bConstellation=" + localUserProfile.bConstellation + " vipInfo=" + localUserProfile.stVipInfo + " richSign=" + localUserProfile.vRichSign);
        }
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.type = 3;
        if (QLog.isColorLevel()) {
          QLog.i("CardHandler", 2, "handleReqFavoriteList," + localCardProfile.toString());
        }
        localArrayList.add(localCardProfile);
      }
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      if (paramToServiceMsg.extraData.getLong("nextMid", -1L) == 0L) {
        a(3);
      }
      b(paramToServiceMsg.getUin(), localArrayList);
      new StringBuilder().append(paramToServiceMsg.extraData.getLong("targetUin")).append("").toString();
      a(42, true, new Object[] { paramObject, paramBundle, localArrayList });
      DatingUtil.a("handleReqFavoriteList", new Object[] { localArrayList });
      return;
    }
    paramToServiceMsg = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    a(42, false, new Object[] { paramToServiceMsg, paramBundle, a(3, 7) });
  }
  
  private void c(String paramString, List paramList)
  {
    b(paramString, paramList);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin());
      paramFromServiceMsg = (RespGetVoterList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a(2, 7);
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        a(6, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        return;
      }
      Object localObject1 = paramFromServiceMsg.vVoterInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom((UserProfile)localObject2);
        localCardProfile.type = 2;
        if (QLog.isColorLevel()) {
          QLog.i("CardHandler", 2, "handleReqVoterList," + localCardProfile.toString());
        }
        localArrayList.add(localCardProfile);
      }
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      long l1 = paramToServiceMsg.extraData.getLong("nextMid", -1L);
      if (l1 == 0L) {
        a(2);
      }
      c(paramToServiceMsg.getUin(), localArrayList);
      localObject1 = new ArrayList(0);
      if (l1 == 0L)
      {
        if (paramFromServiceMsg.vTodayFavoriteInfos != null)
        {
          localObject2 = paramFromServiceMsg.vTodayFavoriteInfos.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((ArrayList)localObject1).add(Long.valueOf(((UserProfile)((Iterator)localObject2).next()).lEctID));
          }
        }
        b((List)localObject1);
      }
      int i1 = paramFromServiceMsg.iMaxFriendFavoriteCount;
      int i2 = paramFromServiceMsg.iMaxStrangerFavoriteCount;
      new StringBuilder().append(paramToServiceMsg.extraData.getLong("targetUin")).append("").toString();
      a(6, true, new Object[] { paramObject, paramBundle, localArrayList, localObject1, Integer.valueOf(i1), Integer.valueOf(i2) });
      DatingUtil.a("handleReqVoterList", new Object[] { localArrayList });
      return;
    }
    paramToServiceMsg = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    a(6, false, new Object[] { paramToServiceMsg, paramBundle, a(2, 7) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l1 = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = bool2;
        bool2 = false;
        continue;
      }
      if (!bool2) {
        bool1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
      }
      a(38, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespAddFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramObject = paramToServiceMsg.extraData.getByteArray("filekey");
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        Card localCard = localFriendsManager.b(paramToServiceMsg.getUin());
        localCard.uin = paramToServiceMsg.getUin();
        if (paramFromServiceMsg.uFaceTimeStamp > localCard.uFaceTimeStamp)
        {
          localCard.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
          localCard.addHeadPortrait((byte[])paramObject);
        }
        localCard.iFaceNum += 1;
        localFriendsManager.a(localCard);
        ProfileCardUtil.a((byte[])paramObject);
        a(11, true, new Object[] { localCard, paramBundle });
        return;
      }
      paramBundle.putInt("retCode", paramFromServiceMsg.stHeader.iReplyCode);
      a(11, false, paramBundle);
      return;
    }
    a(11, false, paramBundle);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_searchable", true);
      if (!bool1) {
        break label148;
      }
    }
    label148:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
        a(39, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    long l1 = paramToServiceMsg.extraData.getLong("uin");
    int i1 = paramToServiceMsg.extraData.getInt("timestamp");
    paramToServiceMsg = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(String.valueOf(Long.valueOf(l1)));
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespFaceInfo)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        if ((i1 != 0) && (paramFromServiceMsg.uFaceTimeStamp == paramToServiceMsg.uFaceTimeStamp)) {
          break label177;
        }
        paramToServiceMsg.iFaceNum = paramFromServiceMsg.iFaceNum;
        paramToServiceMsg.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
        paramToServiceMsg.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
      }
    }
    label177:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(paramToServiceMsg);
      a(10, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
      return;
      a(10, false, paramToServiceMsg);
      return;
      a(10, false, paramToServiceMsg);
      return;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i1;
    Object localObject;
    boolean bool3;
    int i2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      i1 = 64536;
      localObject = null;
      bool3 = paramToServiceMsg.extraData.getBoolean("key_is_nearby_people_card", false);
      if (bool1) {
        i2 = i1;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label1050;
        }
        i2 = i1;
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label1050;
        }
        i2 = i1;
        i1 = paramFromServiceMsg.uint32_result.get();
        if (i1 != 0) {
          break label1044;
        }
        bool1 = true;
        StringBuilder localStringBuilder;
        boolean bool2;
        String[] arrayOfString;
        bool1 = false;
      }
      catch (Exception paramFromServiceMsg)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("CardHandler", 2, "handleSetDetailInfo, ret = " + i1 + ", isNearbyPeopleCard = " + bool3);
            if ((i1 == 0) && (!bool3))
            {
              i2 = i1;
              paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
              i2 = i1;
              paramFromServiceMsg = ((FriendsManager)paramObject).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
              try
              {
                if (paramToServiceMsg.extraData.containsKey("nick"))
                {
                  paramFromServiceMsg.strNick = paramToServiceMsg.extraData.getString("nick");
                  ((FriendsManager)paramObject).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFromServiceMsg.strNick);
                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
                if (paramToServiceMsg.extraData.containsKey("sex"))
                {
                  paramFromServiceMsg.shGender = ((short)paramToServiceMsg.extraData.getByte("sex"));
                  localObject = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
                  if (localObject != null) {
                    ((NearbyCardManager)localObject).b(paramFromServiceMsg.shGender);
                  }
                }
                if (paramToServiceMsg.extraData.containsKey("birthday"))
                {
                  paramFromServiceMsg.lBirthday = paramToServiceMsg.extraData.getInt("birthday");
                  paramFromServiceMsg.age = ((byte)paramToServiceMsg.extraData.getInt("age"));
                  paramFromServiceMsg.constellation = paramToServiceMsg.extraData.getInt("key_constellation");
                  localObject = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
                  if (localObject != null) {
                    ((NearbyCardManager)localObject).a(paramFromServiceMsg.age);
                  }
                }
                if (paramToServiceMsg.extraData.containsKey("profession")) {
                  paramFromServiceMsg.iProfession = paramToServiceMsg.extraData.getInt("profession");
                }
                if (paramToServiceMsg.extraData.containsKey("company")) {
                  paramFromServiceMsg.strCompany = paramToServiceMsg.extraData.getString("company");
                }
                if (paramToServiceMsg.extraData.containsKey("college")) {
                  paramFromServiceMsg.strSchool = paramToServiceMsg.extraData.getString("college");
                }
                try
                {
                  NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_school_name", paramFromServiceMsg.strSchool);
                  if (!paramToServiceMsg.extraData.containsKey("location")) {
                    continue;
                  }
                  localObject = paramToServiceMsg.extraData.getStringArray("location");
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(localObject[0]).append("-").append(localObject[1]).append("-").append(localObject[2]).append("-").append(localObject[3]);
                  paramFromServiceMsg.strLocationCodes = localStringBuilder.toString();
                  paramFromServiceMsg.strLocationDesc = paramToServiceMsg.extraData.getString("locationo_desc");
                  localObject = paramToServiceMsg.extraData.getStringArray("location_name");
                  if ((localObject == null) || (localObject.length != 4)) {
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  localStringBuilder = new StringBuilder("nameArray: ");
                  i2 = 0;
                  if (i2 >= 4) {
                    continue;
                  }
                  localStringBuilder.append(localObject[i2]).append(" ");
                  i2 += 1;
                  continue;
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                  continue;
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
              }
              catch (Exception paramObject)
              {
                paramToServiceMsg = paramFromServiceMsg;
                paramFromServiceMsg = (FromServiceMsg)paramObject;
              }
              QLog.d("CardHandler", 2, "handleGetDetailInfo", paramFromServiceMsg);
              bool2 = false;
              i2 = i1;
              if (!bool3) {
                a(31, bool2, new Object[] { Integer.valueOf(i2), paramToServiceMsg });
              }
              return;
              QLog.d("CardHandler", 2, localStringBuilder.toString());
              paramFromServiceMsg.strCountry = localException[0];
              paramFromServiceMsg.strProvince = localException[1];
              paramFromServiceMsg.strCity = localException[2];
              if (paramToServiceMsg.extraData.containsKey("hometown"))
              {
                arrayOfString = paramToServiceMsg.extraData.getStringArray("hometown");
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(arrayOfString[0]).append("-").append(arrayOfString[1]).append("-").append(arrayOfString[2]).append("-").append(arrayOfString[3]);
                paramFromServiceMsg.strHometownCodes = localStringBuilder.toString();
                paramFromServiceMsg.strHometownDesc = paramToServiceMsg.extraData.getString("hometown_desc");
              }
              if (paramToServiceMsg.extraData.containsKey("email")) {
                paramFromServiceMsg.strEmail = paramToServiceMsg.extraData.getString("email");
              }
              if (paramToServiceMsg.extraData.containsKey("personalNote")) {
                paramFromServiceMsg.strPersonalNote = paramToServiceMsg.extraData.getString("personalNote");
              }
              ((FriendsManager)paramObject).a(paramFromServiceMsg);
              paramToServiceMsg = paramFromServiceMsg;
              bool2 = bool1;
              i2 = i1;
              continue;
              bool2 = bool1;
              paramToServiceMsg = arrayOfString;
              i2 = i1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              paramToServiceMsg = new StringBuilder().append("setDetailInfo fail : ");
              if (paramFromServiceMsg != null)
              {
                i2 = paramFromServiceMsg.getResultCode();
                QLog.w("CardHandler", 2, i2);
                bool2 = bool1;
                paramToServiceMsg = arrayOfString;
                i2 = i1;
                continue;
              }
              i2 = -1;
              continue;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg = null;
              i1 = i2;
              continue;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = null;
          continue;
          paramToServiceMsg = null;
          continue;
          continue;
        }
      }
      break;
      label1044:
      bool1 = false;
      continue;
      label1050:
      bool1 = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespGetCardSwitch)paramObject;
      long l1 = paramFromServiceMsg.uCloseNeighborVote;
      long l2 = paramFromServiceMsg.uCloseTimeGateVote;
      paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
      if (l1 == 0L)
      {
        bool = true;
        ((Card)paramObject).setZanShowFlag(bool);
        paramFromServiceMsg.a((Card)paramObject);
        paramFromServiceMsg = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
        paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367841) + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (l2 != 0L) {
          break label194;
        }
      }
      label194:
      for (boolean bool = true;; bool = false)
      {
        paramFromServiceMsg.putBoolean((String)paramObject, bool).commit();
        paramBundle.putLong("uCloseNeighborVote", l1);
        paramBundle.putLong("uColseTimeEntityManager", l2);
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        a(33, true, paramBundle);
        return;
        bool = false;
        break;
      }
    }
    paramBundle.putString("uin", paramToServiceMsg.getUin());
    a(33, false, paramBundle);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i5;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    int i2;
    int i3;
    int i1;
    label248:
    int i4;
    int i6;
    label324:
    Object localObject11;
    Object localObject12;
    label661:
    Object localObject10;
    label2829:
    label2960:
    label3090:
    label3433:
    int i8;
    label3542:
    Object localObject8;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      if (bool1)
      {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
            break label6773;
          }
          localLong = Long.valueOf(Utils.a(localByteBuffer.getInt()));
          localByteBuffer.get();
          int i7 = localByteBuffer.getShort();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetDetailInfo, request success, tlvCount = " + i7);
          }
          i5 = 0;
          localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          localCard = localFriendsManager.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
          paramFromServiceMsg = "0";
          paramObject = "0";
          localObject1 = "0";
          localObject2 = "0";
          localObject3 = "0";
          localObject4 = "0";
          localObject5 = "0";
          localObject6 = "0";
          i2 = 0;
          i3 = 0;
          try
          {
            localApolloManager = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
            localApolloBaseInfo = localApolloManager.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
            i1 = 0;
            if ((!localByteBuffer.hasRemaining()) || (i5 >= i7)) {
              break label6438;
            }
            i4 = localByteBuffer.getShort();
            i6 = localByteBuffer.getShort();
            if (!QLog.isColorLevel()) {
              break label6936;
            }
            QLog.d("CardHandler", 2, "handleGetDetailInfo, TLV type: " + i4 + ",legnth: " + i6);
          }
          catch (Exception paramObject)
          {
            paramFromServiceMsg = localCard;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "invalid type: " + i4);
          }
          localByteBuffer.position(localByteBuffer.position() + i6);
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            ByteBuffer localByteBuffer;
            Long localLong;
            FriendsManager localFriendsManager;
            Card localCard;
            ApolloManager localApolloManager;
            ApolloBaseInfo localApolloBaseInfo;
            Object localObject7;
            Object localObject9;
            label5235:
            label5358:
            paramFromServiceMsg = null;
            continue;
            i1 = 64425;
          }
          i4 = i2;
          localObject8 = localObject2;
          localObject10 = localObject1;
          localObject11 = paramObject;
          localObject12 = paramFromServiceMsg;
          i2 = i3;
          i3 = i4;
          paramFromServiceMsg = (FromServiceMsg)localObject6;
          paramObject = localObject5;
          localObject1 = localObject4;
          localObject2 = localObject3;
          localObject3 = localObject8;
          localObject4 = localObject10;
          localObject5 = localObject11;
          localObject6 = localObject12;
          break label7391;
        }
        localObject7 = new byte[i6];
        localByteBuffer.get((byte[])localObject7);
        localCard.strNick = new String((byte[])localObject7);
        if (!QLog.isColorLevel()) {
          break label7335;
        }
        QLog.d("CardHandler", 2, "strNick = " + localCard.strNick);
        i4 = i2;
        localObject7 = localObject2;
        localObject9 = localObject1;
        localObject11 = paramObject;
        localObject12 = paramFromServiceMsg;
        i2 = i3;
        i3 = i4;
        paramFromServiceMsg = (FromServiceMsg)localObject6;
        paramObject = localObject5;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject3 = localObject7;
        localObject4 = localObject9;
        localObject5 = localObject11;
        localObject6 = localObject12;
        break label7391;
        i4 = localByteBuffer.get();
        if (i4 == 1) {
          localCard.shGender = 0;
        }
        while (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "shGender = " + localCard.shGender);
          i4 = i2;
          localObject7 = localObject2;
          localObject9 = localObject1;
          localObject11 = paramObject;
          localObject12 = paramFromServiceMsg;
          i2 = i3;
          i3 = i4;
          paramFromServiceMsg = (FromServiceMsg)localObject6;
          paramObject = localObject5;
          localObject1 = localObject4;
          localObject2 = localObject3;
          localObject3 = localObject7;
          localObject4 = localObject9;
          localObject5 = localObject11;
          localObject6 = localObject12;
          break label7391;
          if (i4 == 2)
          {
            localCard.shGender = 1;
            continue;
            bool2 = false;
            paramToServiceMsg = paramFromServiceMsg;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("CardHandler", 2, "handleGetDetailInfo", (Throwable)paramObject);
              bool1 = bool2;
              paramToServiceMsg = paramFromServiceMsg;
            }
            a(20, bool1, paramToServiceMsg);
          }
          else
          {
            localCard.shGender = -1;
            continue;
            i4 = localByteBuffer.getInt();
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, "profession = " + i4);
            }
            if (NearbyProfileUtil.a(i4))
            {
              localCard.iProfession = i4;
              i4 = i2;
              localObject7 = localObject2;
              localObject9 = localObject1;
              localObject11 = paramObject;
              localObject12 = paramFromServiceMsg;
              i2 = i3;
              i3 = i4;
              paramFromServiceMsg = (FromServiceMsg)localObject6;
              paramObject = localObject5;
              localObject1 = localObject4;
              localObject2 = localObject3;
              localObject3 = localObject7;
              localObject4 = localObject9;
              localObject5 = localObject11;
              localObject6 = localObject12;
              break label7391;
            }
            localCard.iProfession = -1;
            i4 = i2;
            localObject7 = localObject2;
            localObject9 = localObject1;
            localObject11 = paramObject;
            localObject12 = paramFromServiceMsg;
            i2 = i3;
            i3 = i4;
            paramFromServiceMsg = (FromServiceMsg)localObject6;
            paramObject = localObject5;
            localObject1 = localObject4;
            localObject2 = localObject3;
            localObject3 = localObject7;
            localObject4 = localObject9;
            localObject5 = localObject11;
            localObject6 = localObject12;
            break label7391;
            localCard.lBirthday = localByteBuffer.getInt();
            if (localCard.lBirthday == 0L) {
              localCard.constellation = 0;
            }
            while (QLog.isColorLevel())
            {
              QLog.d("CardHandler", 2, "birth = " + localCard.lBirthday + ", constellation = " + localCard.constellation);
              i4 = i2;
              localObject7 = localObject2;
              localObject9 = localObject1;
              localObject11 = paramObject;
              localObject12 = paramFromServiceMsg;
              i2 = i3;
              i3 = i4;
              paramFromServiceMsg = (FromServiceMsg)localObject6;
              paramObject = localObject5;
              localObject1 = localObject4;
              localObject2 = localObject3;
              localObject3 = localObject7;
              localObject4 = localObject9;
              localObject5 = localObject11;
              localObject6 = localObject12;
              break label7391;
              localCard.constellation = Utils.a((int)((localCard.lBirthday & 0xFF00) >> 8), (int)(localCard.lBirthday & 0xFF));
              continue;
              localObject7 = new byte[i6];
              localByteBuffer.get((byte[])localObject7);
              localObject7 = new String((byte[])localObject7);
              localCard.strCompany = ((String)localObject7);
              if (QLog.isColorLevel())
              {
                QLog.d("CardHandler", 2, "company = " + (String)localObject7);
                i4 = i2;
                localObject7 = localObject2;
                localObject9 = localObject1;
                localObject11 = paramObject;
                localObject12 = paramFromServiceMsg;
                i2 = i3;
                i3 = i4;
                paramFromServiceMsg = (FromServiceMsg)localObject6;
                paramObject = localObject5;
                localObject1 = localObject4;
                localObject2 = localObject3;
                localObject3 = localObject7;
                localObject4 = localObject9;
                localObject5 = localObject11;
                localObject6 = localObject12;
                break label7391;
                i3 = localByteBuffer.getInt();
                i4 = localByteBuffer.getInt();
                i6 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "hometown, countryId " + i3 + ", provinceId " + i4 + ", cityId " + i6);
                }
                localObject7 = ConditionSearchManager.a(i3);
                localObject9 = ConditionSearchManager.a(i4);
                localObject11 = ConditionSearchManager.a(i6);
                i4 = 1;
                paramFromServiceMsg = (FromServiceMsg)localObject6;
                paramObject = localObject5;
                localObject1 = localObject4;
                localObject4 = localObject2;
                localObject5 = localObject11;
                i3 = i2;
                i2 = i4;
                localObject2 = localObject3;
                localObject3 = localObject4;
                localObject4 = localObject5;
                localObject5 = localObject9;
                localObject6 = localObject7;
                break label7391;
                i3 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "hometown, districtId " + i3);
                }
                localObject12 = ConditionSearchManager.a(i3);
                localObject7 = localObject1;
                localObject9 = paramObject;
                localObject11 = paramFromServiceMsg;
                paramObject = localObject5;
                localObject1 = localObject4;
                localObject2 = localObject3;
                localObject3 = localObject12;
                i3 = i2;
                paramFromServiceMsg = (FromServiceMsg)localObject6;
                i2 = 1;
                localObject4 = localObject7;
                localObject5 = localObject9;
                localObject6 = localObject11;
                break label7391;
                i2 = localByteBuffer.getInt();
                i4 = localByteBuffer.getInt();
                i6 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "location, countryId " + i2 + ", provinceId " + i4 + ", cityId " + i6);
                }
                localObject9 = ConditionSearchManager.a(i2);
                localObject11 = ConditionSearchManager.a(i4);
                localObject12 = ConditionSearchManager.a(i6);
                localObject3 = localObject2;
                localObject4 = localObject1;
                localObject5 = paramObject;
                localObject7 = paramFromServiceMsg;
                paramFromServiceMsg = (FromServiceMsg)localObject6;
                paramObject = localObject12;
                i4 = 1;
                i2 = i3;
                i3 = i4;
                localObject1 = localObject11;
                localObject2 = localObject9;
                localObject6 = localObject7;
                break label7391;
                i2 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "location, districtId " + i2);
                }
                localObject12 = ConditionSearchManager.a(i2);
                localObject6 = localObject2;
                localObject7 = localObject1;
                localObject9 = paramObject;
                localObject11 = paramFromServiceMsg;
                i4 = 1;
                i2 = i3;
                i3 = i4;
                paramFromServiceMsg = (FromServiceMsg)localObject12;
                paramObject = localObject5;
                localObject1 = localObject4;
                localObject2 = localObject3;
                localObject3 = localObject6;
                localObject4 = localObject7;
                localObject5 = localObject9;
                localObject6 = localObject11;
                break label7391;
                localObject7 = new byte[i6];
                localByteBuffer.get((byte[])localObject7);
                localObject7 = new String((byte[])localObject7);
                localCard.strEmail = ((String)localObject7);
                if (QLog.isColorLevel())
                {
                  QLog.d("CardHandler", 2, "email = " + (String)localObject7);
                  i4 = i2;
                  localObject7 = localObject2;
                  localObject9 = localObject1;
                  localObject11 = paramObject;
                  localObject12 = paramFromServiceMsg;
                  i2 = i3;
                  i3 = i4;
                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                  paramObject = localObject5;
                  localObject1 = localObject4;
                  localObject2 = localObject3;
                  localObject3 = localObject7;
                  localObject4 = localObject9;
                  localObject5 = localObject11;
                  localObject6 = localObject12;
                  break label7391;
                  localObject7 = new byte[i6];
                  localByteBuffer.get((byte[])localObject7);
                  localObject7 = new String((byte[])localObject7);
                  localCard.strPersonalNote = ((String)localObject7);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("CardHandler", 2, "personal note = " + (String)localObject7);
                    i4 = i2;
                    localObject7 = localObject2;
                    localObject9 = localObject1;
                    localObject11 = paramObject;
                    localObject12 = paramFromServiceMsg;
                    i2 = i3;
                    i3 = i4;
                    paramFromServiceMsg = (FromServiceMsg)localObject6;
                    paramObject = localObject5;
                    localObject1 = localObject4;
                    localObject2 = localObject3;
                    localObject3 = localObject7;
                    localObject4 = localObject9;
                    localObject5 = localObject11;
                    localObject6 = localObject12;
                    break label7391;
                    localObject7 = new byte[i6];
                    localByteBuffer.get((byte[])localObject7);
                    localObject7 = new String((byte[])localObject7);
                    localCard.strSchool = ((String)localObject7);
                    try
                    {
                      NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_school_name", localObject7);
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d("CardHandler", 2, "school = " + (String)localObject7);
                      i4 = i2;
                      localObject7 = localObject2;
                      localObject9 = localObject1;
                      localObject11 = paramObject;
                      localObject12 = paramFromServiceMsg;
                      i2 = i3;
                      i3 = i4;
                      paramFromServiceMsg = (FromServiceMsg)localObject6;
                      paramObject = localObject5;
                      localObject1 = localObject4;
                      localObject2 = localObject3;
                      localObject3 = localObject7;
                      localObject4 = localObject9;
                      localObject5 = localObject11;
                      localObject6 = localObject12;
                    }
                    catch (Exception localException)
                    {
                      for (;;)
                      {
                        localException.printStackTrace();
                      }
                    }
                    localCard.age = localByteBuffer.get();
                    localCard.shAge = ((short)localCard.age);
                    if (QLog.isColorLevel())
                    {
                      QLog.d("CardHandler", 2, "age = " + localCard.age);
                      i4 = i2;
                      localObject7 = localObject2;
                      localObject10 = localObject1;
                      localObject11 = paramObject;
                      localObject12 = paramFromServiceMsg;
                      i2 = i3;
                      i3 = i4;
                      paramFromServiceMsg = (FromServiceMsg)localObject6;
                      paramObject = localObject5;
                      localObject1 = localObject4;
                      localObject2 = localObject3;
                      localObject3 = localObject7;
                      localObject4 = localObject10;
                      localObject5 = localObject11;
                      localObject6 = localObject12;
                      break label7391;
                      localCard.constellation = localByteBuffer.get();
                      if (QLog.isColorLevel())
                      {
                        QLog.d("CardHandler", 2, "constellation = " + localCard.constellation);
                        i4 = i2;
                        localObject7 = localObject2;
                        localObject10 = localObject1;
                        localObject11 = paramObject;
                        localObject12 = paramFromServiceMsg;
                        i2 = i3;
                        i3 = i4;
                        paramFromServiceMsg = (FromServiceMsg)localObject6;
                        paramObject = localObject5;
                        localObject1 = localObject4;
                        localObject2 = localObject3;
                        localObject3 = localObject7;
                        localObject4 = localObject10;
                        localObject5 = localObject11;
                        localObject6 = localObject12;
                        break label7391;
                        i4 = localByteBuffer.getShort();
                        i6 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1);
                        if (QLog.isColorLevel()) {
                          QLog.i("CardHandler", 2, "handleGetDetalInfo nearbyprofile local is :" + i6 + " server is: " + i4);
                        }
                        if ((i6 != i4) && (i6 != 1))
                        {
                          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_people_profile_ok_new", i4).commit();
                          i4 = i2;
                          localObject7 = localObject2;
                          localObject10 = localObject1;
                          localObject11 = paramObject;
                          localObject12 = paramFromServiceMsg;
                          i2 = i3;
                          i3 = i4;
                          paramFromServiceMsg = (FromServiceMsg)localObject6;
                          paramObject = localObject5;
                          localObject1 = localObject4;
                          localObject2 = localObject3;
                          localObject3 = localObject7;
                          localObject4 = localObject10;
                          localObject5 = localObject11;
                          localObject6 = localObject12;
                          break label7391;
                          i4 = localByteBuffer.getShort();
                          i6 = ((Integer)NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue();
                          if (QLog.isColorLevel()) {
                            QLog.i("CardHandler", 2, "handleGetDetalInfo hasNearbyAvatarFlag local is :" + i6 + " server is: " + i4);
                          }
                          if ((i6 != i4) && (i6 != 1))
                          {
                            NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(i4));
                            i4 = i2;
                            localObject7 = localObject2;
                            localObject10 = localObject1;
                            localObject11 = paramObject;
                            localObject12 = paramFromServiceMsg;
                            i2 = i3;
                            i3 = i4;
                            paramFromServiceMsg = (FromServiceMsg)localObject6;
                            paramObject = localObject5;
                            localObject1 = localObject4;
                            localObject2 = localObject3;
                            localObject3 = localObject7;
                            localObject4 = localObject10;
                            localObject5 = localObject11;
                            localObject6 = localObject12;
                            break label7391;
                            i4 = localByteBuffer.getShort();
                            i6 = ((Integer)NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue();
                            if (QLog.isColorLevel()) {
                              QLog.i("CardHandler", 2, "handleGetDetailInfo qq avatar type local is: " + i6 + " server is: " + i4);
                            }
                            if (i6 != i4)
                            {
                              NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(i4));
                              i4 = i2;
                              localObject7 = localObject2;
                              localObject10 = localObject1;
                              localObject11 = paramObject;
                              localObject12 = paramFromServiceMsg;
                              i2 = i3;
                              i3 = i4;
                              paramFromServiceMsg = (FromServiceMsg)localObject6;
                              paramObject = localObject5;
                              localObject1 = localObject4;
                              localObject2 = localObject3;
                              localObject3 = localObject7;
                              localObject4 = localObject10;
                              localObject5 = localObject11;
                              localObject6 = localObject12;
                              break label7391;
                              i4 = localByteBuffer.getShort();
                              if (QLog.isColorLevel()) {
                                QLog.i("CardHandler", 2, "handleGetDetialInfo is showNearbyGuide: " + i4);
                              }
                              localObject7 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
                              if (i4 != 1) {
                                break label7462;
                              }
                              bool2 = true;
                              NearbySPUtil.a((String)localObject7, "nearby_need_show_guide", Boolean.valueOf(bool2));
                              i4 = i2;
                              localObject7 = localObject2;
                              localObject10 = localObject1;
                              localObject11 = paramObject;
                              localObject12 = paramFromServiceMsg;
                              i2 = i3;
                              i3 = i4;
                              paramFromServiceMsg = (FromServiceMsg)localObject6;
                              paramObject = localObject5;
                              localObject1 = localObject4;
                              localObject2 = localObject3;
                              localObject3 = localObject7;
                              localObject4 = localObject10;
                              localObject5 = localObject11;
                              localObject6 = localObject12;
                              break label7391;
                              i4 = localByteBuffer.getShort();
                              if (QLog.isColorLevel()) {
                                QLog.i("CardHandler", 2, "handleGetDetialInfo isNovice: " + i4);
                              }
                              localObject7 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
                              if (i4 != 1) {
                                break label7468;
                              }
                              bool2 = true;
                              NearbySPUtil.a((String)localObject7, "is_nearby_novice", Boolean.valueOf(bool2));
                              i4 = i2;
                              localObject7 = localObject2;
                              localObject10 = localObject1;
                              localObject11 = paramObject;
                              localObject12 = paramFromServiceMsg;
                              i2 = i3;
                              i3 = i4;
                              paramFromServiceMsg = (FromServiceMsg)localObject6;
                              paramObject = localObject5;
                              localObject1 = localObject4;
                              localObject2 = localObject3;
                              localObject3 = localObject7;
                              localObject4 = localObject10;
                              localObject5 = localObject11;
                              localObject6 = localObject12;
                              break label7391;
                              boolean bool3 = false;
                              if (2 == i6)
                              {
                                boolean bool4 = SettingCloneUtil.readValue(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), localLong.toString(), null, "qqsetting_pcactive_key", false);
                                localObject7 = new byte[i6];
                                localByteBuffer.get((byte[])localObject7);
                                if (Utils.a((byte[])localObject7, 0) != 0) {
                                  break label7474;
                                }
                                bool2 = false;
                                bool3 = bool2;
                                if (bool4 != bool2)
                                {
                                  if (localByteBuffer.getShort() == 0) {
                                    SettingCloneUtil.writeValue(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), localLong.toString(), null, "qqsetting_pcactive_key", bool2);
                                  }
                                  localObject7 = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
                                  ((Intent)localObject7).putExtra("pcActive", bool2);
                                  ((Intent)localObject7).putExtra("uin", localLong.toString());
                                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast((Intent)localObject7);
                                  bool3 = bool2;
                                }
                              }
                              if (QLog.isColorLevel())
                              {
                                QLog.d("PCActiveState", 2, "Get PCActiveState=" + bool3);
                                i4 = i2;
                                localObject7 = localObject2;
                                localObject10 = localObject1;
                                localObject11 = paramObject;
                                localObject12 = paramFromServiceMsg;
                                i2 = i3;
                                i3 = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject6;
                                paramObject = localObject5;
                                localObject1 = localObject4;
                                localObject2 = localObject3;
                                localObject3 = localObject7;
                                localObject4 = localObject10;
                                localObject5 = localObject11;
                                localObject6 = localObject12;
                                break label7391;
                                i4 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetalInfo server dating symbol is :" + i4);
                                }
                                if (i4 == 1)
                                {
                                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  i4 = localByteBuffer.getShort();
                                  if (!QLog.isColorLevel()) {
                                    break label7480;
                                  }
                                  QLog.i("CardHandler", 2, "handleGetDetalInfo server calltab visible is :" + i4);
                                  break label7480;
                                  i6 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
                                  i8 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
                                  if (i8 != 0) {
                                    break label7497;
                                  }
                                  localObject7 = new Integer[7];
                                  localObject7[3] = Integer.valueOf(i4);
                                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((Integer[])localObject7);
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  b(bool2, false);
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_interest = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_music = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_recent_activity = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_star = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_joined_troop = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_now = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_ktv = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_eat = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_reader = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_radio = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  localCard.switch_comic = localByteBuffer.getShort();
                                  i4 = i2;
                                  localObject7 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject7;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  i4 = localByteBuffer.getShort();
                                  QLog.i("smartdevice", 1, "got device bind flag:" + i4);
                                  try
                                  {
                                    ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(i4);
                                    i4 = i2;
                                    localObject7 = localObject2;
                                    localObject10 = localObject1;
                                    localObject11 = paramObject;
                                    localObject12 = paramFromServiceMsg;
                                    i2 = i3;
                                    i3 = i4;
                                    paramFromServiceMsg = (FromServiceMsg)localObject6;
                                    paramObject = localObject5;
                                    localObject1 = localObject4;
                                    localObject2 = localObject3;
                                    localObject3 = localObject7;
                                    localObject4 = localObject10;
                                    localObject5 = localObject11;
                                    localObject6 = localObject12;
                                  }
                                  catch (Error localError)
                                  {
                                    i4 = i2;
                                    localObject8 = localObject2;
                                    localObject10 = localObject1;
                                    localObject11 = paramObject;
                                    localObject12 = paramFromServiceMsg;
                                    i2 = i3;
                                    i3 = i4;
                                    paramFromServiceMsg = (FromServiceMsg)localObject6;
                                    paramObject = localObject5;
                                    localObject1 = localObject4;
                                    localObject2 = localObject3;
                                    localObject3 = localObject8;
                                    localObject4 = localObject10;
                                    localObject5 = localObject11;
                                    localObject6 = localObject12;
                                  }
                                  i4 = localByteBuffer.getShort();
                                  if (QLog.isColorLevel()) {
                                    QLog.i("CardHandler", 2, "handleGetDetalInfo server has antilost bind symbol is :" + i4);
                                  }
                                  ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).b(i4);
                                  i4 = i2;
                                  localObject8 = localObject2;
                                  localObject10 = localObject1;
                                  localObject11 = paramObject;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i3;
                                  i3 = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                                  paramObject = localObject5;
                                  localObject1 = localObject4;
                                  localObject2 = localObject3;
                                  localObject3 = localObject8;
                                  localObject4 = localObject10;
                                  localObject5 = localObject11;
                                  localObject6 = localObject12;
                                  break label7391;
                                  i4 = localByteBuffer.getShort();
                                  localObject8 = (MessageRoamManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91);
                                  if (localObject8 != null) {
                                    ((MessageRoamManager)localObject8).c(i4);
                                  }
                                  if (QLog.isColorLevel())
                                  {
                                    QLog.i("CardHandler", 2, "handleGetDetalInfo authMode is :" + i4);
                                    i4 = i2;
                                    localObject8 = localObject2;
                                    localObject10 = localObject1;
                                    localObject11 = paramObject;
                                    localObject12 = paramFromServiceMsg;
                                    i2 = i3;
                                    i3 = i4;
                                    paramFromServiceMsg = (FromServiceMsg)localObject6;
                                    paramObject = localObject5;
                                    localObject1 = localObject4;
                                    localObject2 = localObject3;
                                    localObject3 = localObject8;
                                    localObject4 = localObject10;
                                    localObject5 = localObject11;
                                    localObject6 = localObject12;
                                    break label7391;
                                    short s1 = localByteBuffer.getShort();
                                    if (QLog.isColorLevel()) {
                                      QLog.i(LocalRedTouchManager.jdField_a_of_type_JavaLangString, 2, "handleGetDetalInfo unreadFlag is :" + s1);
                                    }
                                    localObject8 = (LocalRedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
                                    if (localObject8 != null)
                                    {
                                      ((LocalRedTouchManager)localObject8).a(s1);
                                      i4 = i2;
                                      localObject8 = localObject2;
                                      localObject10 = localObject1;
                                      localObject11 = paramObject;
                                      localObject12 = paramFromServiceMsg;
                                      i2 = i3;
                                      i3 = i4;
                                      paramFromServiceMsg = (FromServiceMsg)localObject6;
                                      paramObject = localObject5;
                                      localObject1 = localObject4;
                                      localObject2 = localObject3;
                                      localObject3 = localObject8;
                                      localObject4 = localObject10;
                                      localObject5 = localObject11;
                                      localObject6 = localObject12;
                                      break label7391;
                                      i4 = localByteBuffer.getInt();
                                      if (String.valueOf(localLong).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))
                                      {
                                        ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(i4, false);
                                        i4 = i2;
                                        localObject8 = localObject2;
                                        localObject10 = localObject1;
                                        localObject11 = paramObject;
                                        localObject12 = paramFromServiceMsg;
                                        i2 = i3;
                                        i3 = i4;
                                        paramFromServiceMsg = (FromServiceMsg)localObject6;
                                        paramObject = localObject5;
                                        localObject1 = localObject4;
                                        localObject2 = localObject3;
                                        localObject3 = localObject8;
                                        localObject4 = localObject10;
                                        localObject5 = localObject11;
                                        localObject6 = localObject12;
                                        break label7391;
                                        localObject8 = new byte[i6];
                                        localByteBuffer.get((byte[])localObject8);
                                        localObject8 = new String((byte[])localObject8);
                                        if ((!TextUtils.isEmpty((CharSequence)localObject8)) && (String.valueOf(localLong).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())))
                                        {
                                          localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject8, (byte)-1);
                                          if (QLog.isColorLevel())
                                          {
                                            QLog.d("CardHandler", 2, "handleGetDetalInfo saveDateNickByUin: " + (String)localObject8);
                                            i4 = i2;
                                            localObject8 = localObject2;
                                            localObject10 = localObject1;
                                            localObject11 = paramObject;
                                            localObject12 = paramFromServiceMsg;
                                            i2 = i3;
                                            i3 = i4;
                                            paramFromServiceMsg = (FromServiceMsg)localObject6;
                                            paramObject = localObject5;
                                            localObject1 = localObject4;
                                            localObject2 = localObject3;
                                            localObject3 = localObject8;
                                            localObject4 = localObject10;
                                            localObject5 = localObject11;
                                            localObject6 = localObject12;
                                            break label7391;
                                            i4 = localByteBuffer.getShort();
                                            if (QLog.isColorLevel()) {
                                              QLog.i("CardHandler", 2, "handleGetDetalInfo nearbyAuthFlag:" + i4);
                                            }
                                            localObject8 = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
                                            localObject8 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
                                            if (i4 <= 0) {
                                              break label7527;
                                            }
                                            bool2 = true;
                                            HotChatManager.a((AppInterface)localObject8, bool2);
                                            i4 = i2;
                                            localObject8 = localObject2;
                                            localObject10 = localObject1;
                                            localObject11 = paramObject;
                                            localObject12 = paramFromServiceMsg;
                                            i2 = i3;
                                            i3 = i4;
                                            paramFromServiceMsg = (FromServiceMsg)localObject6;
                                            paramObject = localObject5;
                                            localObject1 = localObject4;
                                            localObject2 = localObject3;
                                            localObject3 = localObject8;
                                            localObject4 = localObject10;
                                            localObject5 = localObject11;
                                            localObject6 = localObject12;
                                            break label7391;
                                            i4 = localByteBuffer.getShort();
                                            if (QLog.isColorLevel()) {
                                              QLog.i("CardHandler", 2, "handleGetDetalInfo freshnews_notify_flag:" + i4);
                                            }
                                            localObject8 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
                                            if (i4 != 0) {
                                              break label7533;
                                            }
                                            bool2 = true;
                                            ((NearbyProxy)localObject8).b(bool2);
                                            i4 = i2;
                                            localObject8 = localObject2;
                                            localObject10 = localObject1;
                                            localObject11 = paramObject;
                                            localObject12 = paramFromServiceMsg;
                                            i2 = i3;
                                            i3 = i4;
                                            paramFromServiceMsg = (FromServiceMsg)localObject6;
                                            paramObject = localObject5;
                                            localObject1 = localObject4;
                                            localObject2 = localObject3;
                                            localObject3 = localObject8;
                                            localObject4 = localObject10;
                                            localObject5 = localObject11;
                                            localObject6 = localObject12;
                                            break label7391;
                                            i4 = localByteBuffer.getShort();
                                            if (QLog.isColorLevel()) {
                                              QLog.i("CardHandler", 2, "handleGetDetalInfo torch_bearer_flag:" + i4);
                                            }
                                            localObject8 = (OlympicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
                                            ((OlympicManager)localObject8).a(i4);
                                            ((OlympicManager)localObject8).a();
                                            if (i4 == 1)
                                            {
                                              ((OlympicHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(94)).a(1);
                                              i4 = i2;
                                              localObject8 = localObject2;
                                              localObject10 = localObject1;
                                              localObject11 = paramObject;
                                              localObject12 = paramFromServiceMsg;
                                              i2 = i3;
                                              i3 = i4;
                                              paramFromServiceMsg = (FromServiceMsg)localObject6;
                                              paramObject = localObject5;
                                              localObject1 = localObject4;
                                              localObject2 = localObject3;
                                              localObject3 = localObject8;
                                              localObject4 = localObject10;
                                              localObject5 = localObject11;
                                              localObject6 = localObject12;
                                              break label7391;
                                              i4 = localByteBuffer.getShort();
                                              if (QLog.isColorLevel()) {
                                                QLog.i("CardHandler", 2, "handleGetDetalInfo torch_bearer_switch:" + i4);
                                              }
                                              localObject8 = (OlympicManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
                                              if (i4 != 0) {
                                                break label7539;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label6438:
    label6773:
    label6910:
    label6917:
    label6936:
    label7335:
    label7391:
    label7462:
    label7468:
    label7474:
    label7480:
    label7497:
    label7527:
    label7533:
    label7539:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((OlympicManager)localObject8).a("olympic_flag_setting", bool2);
      i4 = i2;
      localObject8 = localObject2;
      localObject10 = localObject1;
      localObject11 = paramObject;
      localObject12 = paramFromServiceMsg;
      i2 = i3;
      i3 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject8;
      localObject4 = localObject10;
      localObject5 = localObject11;
      localObject6 = localObject12;
      break label7391;
      i6 = localByteBuffer.getShort();
      if (i6 != localApolloBaseInfo.apolloVipFlag) {
        localApolloBaseInfo.apolloVipFlag = i6;
      }
      for (i4 = 1;; i4 = i1)
      {
        i1 = i4;
        if (QLog.isColorLevel())
        {
          QLog.i("CardHandler", 2, "handleGetDetalInfo apollo vip flag: " + i6);
          i6 = i2;
          localObject8 = localObject2;
          localObject10 = localObject1;
          localObject11 = paramObject;
          localObject12 = paramFromServiceMsg;
          i1 = i4;
          i2 = i3;
          i3 = i6;
          paramFromServiceMsg = (FromServiceMsg)localObject6;
          paramObject = localObject5;
          localObject1 = localObject4;
          localObject2 = localObject3;
          localObject3 = localObject8;
          localObject4 = localObject10;
          localObject5 = localObject11;
          localObject6 = localObject12;
          break label7391;
          i6 = localByteBuffer.getShort();
          if (i6 == localApolloBaseInfo.apolloVipLevel) {
            break label6917;
          }
          localApolloBaseInfo.apolloVipLevel = i6;
        }
        for (i4 = 1;; i4 = i1)
        {
          i1 = i4;
          long l1;
          if (QLog.isColorLevel())
          {
            QLog.i("CardHandler", 2, "handleGetDetalInfo apollo vip level: " + i6);
            i6 = i2;
            localObject8 = localObject2;
            localObject10 = localObject1;
            localObject11 = paramObject;
            localObject12 = paramFromServiceMsg;
            i1 = i4;
            i2 = i3;
            i3 = i6;
            paramFromServiceMsg = (FromServiceMsg)localObject6;
            paramObject = localObject5;
            localObject1 = localObject4;
            localObject2 = localObject3;
            localObject3 = localObject8;
            localObject4 = localObject10;
            localObject5 = localObject11;
            localObject6 = localObject12;
            break label7391;
            i6 = localByteBuffer.getShort();
            if (i6 != localApolloBaseInfo.apolloStatus)
            {
              localApolloBaseInfo.apolloStatus = i6;
              i4 = 1;
              if ((!TextUtils.isEmpty(localApolloBaseInfo.uin)) && (localApolloBaseInfo.uin.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
                ApolloActionManager.a().e = i6;
              }
              localObject8 = (VasExtensionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
              i1 = i4;
              if (localObject8 != null)
              {
                ((VasExtensionHandler)localObject8).a(3, true, new com.tencent.util.Pair(localApolloBaseInfo.uin, Integer.valueOf(i6)));
                i1 = i4;
              }
            }
            i4 = i1;
            i1 = i4;
            if (QLog.isColorLevel())
            {
              QLog.i("CardHandler", 2, "handleGetDetalInfo apollo status flag: " + i6);
              i6 = i2;
              localObject8 = localObject2;
              localObject10 = localObject1;
              localObject11 = paramObject;
              localObject12 = paramFromServiceMsg;
              i1 = i4;
              i2 = i3;
              i3 = i6;
              paramFromServiceMsg = (FromServiceMsg)localObject6;
              paramObject = localObject5;
              localObject1 = localObject4;
              localObject2 = localObject3;
              localObject3 = localObject8;
              localObject4 = localObject10;
              localObject5 = localObject11;
              localObject6 = localObject12;
              break label7391;
              l1 = localByteBuffer.getInt();
              if (l1 == localApolloBaseInfo.apolloServerTS) {
                break label6910;
              }
              localApolloBaseInfo.apolloServerTS = l1;
            }
          }
          for (i4 = 1;; i4 = i1)
          {
            i1 = i4;
            if (QLog.isColorLevel())
            {
              QLog.i("CardHandler", 2, "handleGetDetalInfo apollo svr TS: " + l1 + ",local TS: " + localApolloBaseInfo.apolloServerTS);
              i6 = i2;
              localObject8 = localObject2;
              localObject10 = localObject1;
              localObject11 = paramObject;
              localObject12 = paramFromServiceMsg;
              i1 = i4;
              i2 = i3;
              i3 = i6;
              paramFromServiceMsg = (FromServiceMsg)localObject6;
              paramObject = localObject5;
              localObject1 = localObject4;
              localObject2 = localObject3;
              localObject3 = localObject8;
              localObject4 = localObject10;
              localObject5 = localObject11;
              localObject6 = localObject12;
              break label7391;
              i4 = localByteBuffer.getShort();
              if (i4 != ApolloManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
                localApolloManager.a(i4);
              }
              if (!QLog.isColorLevel()) {
                break label7335;
              }
              QLog.i("CardHandler", 2, "handleGetDetalInfo apollo white list: " + i4);
              i4 = i2;
              localObject8 = localObject2;
              localObject10 = localObject1;
              localObject11 = paramObject;
              localObject12 = paramFromServiceMsg;
              i2 = i3;
              i3 = i4;
              paramFromServiceMsg = (FromServiceMsg)localObject6;
              paramObject = localObject5;
              localObject1 = localObject4;
              localObject2 = localObject3;
              localObject3 = localObject8;
              localObject4 = localObject10;
              localObject5 = localObject11;
              localObject6 = localObject12;
              break label7391;
              if (i1 != 0) {
                localApolloManager.a(localApolloBaseInfo);
              }
              if ((ApolloManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (1 == localApolloBaseInfo.apolloStatus) && (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS))
              {
                localObject8 = new ArrayList(1);
                ((ArrayList)localObject8).add(Long.valueOf(localApolloBaseInfo.uin));
                localObject10 = (VasExtensionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
                if (localObject10 != null)
                {
                  ((VasExtensionHandler)localObject10).a((ArrayList)localObject8, "card");
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "handleGetDetailInfo update apollo user apolloDress uin: " + localApolloBaseInfo.uin);
                  }
                }
              }
              if (i2 != 0)
              {
                localObject8 = new StringBuilder();
                ((StringBuilder)localObject8).append((String)localObject3).append("-");
                ((StringBuilder)localObject8).append((String)localObject4).append("-");
                ((StringBuilder)localObject8).append((String)localObject5).append("-");
                ((StringBuilder)localObject8).append((String)localObject6);
                localCard.strLocationCodes = ((StringBuilder)localObject8).toString();
              }
              if (i3 != 0)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(paramFromServiceMsg).append("-");
                ((StringBuilder)localObject3).append((String)paramObject).append("-");
                ((StringBuilder)localObject3).append((String)localObject1).append("-");
                ((StringBuilder)localObject3).append((String)localObject2);
                localCard.strHometownCodes = ((StringBuilder)localObject3).toString();
              }
              localFriendsManager.a(localCard);
              if (((i2 != 0) || (i3 != 0)) && (paramToServiceMsg.extraData.getBoolean("reqFromDetailActivity"))) {
                ((ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).c();
              }
              paramToServiceMsg = localCard;
              break;
              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
              {
                i1 = paramFromServiceMsg.uint32_result.get();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "request error, ret " + i1);
                }
                paramToServiceMsg = null;
                bool1 = false;
                break;
              }
            }
          }
        }
      }
      paramToServiceMsg = null;
      break label661;
      switch (i4)
      {
      }
      break label324;
      do
      {
        i4 = i3;
        localObject8 = localObject6;
        localObject10 = localObject5;
        localObject11 = localObject4;
        localObject12 = localObject3;
        localObject6 = paramFromServiceMsg;
        localObject5 = paramObject;
        localObject4 = localObject1;
        localObject3 = localObject2;
        localObject2 = localObject12;
        localObject1 = localObject11;
        paramObject = localObject10;
        paramFromServiceMsg = (FromServiceMsg)localObject8;
        i3 = i2;
        i2 = i4;
        localObject8 = localObject6;
        localObject10 = localObject5;
        localObject11 = localObject4;
        localObject12 = localObject3;
        i4 = i3;
        i5 += 1;
        i3 = i2;
        i2 = i4;
        localObject6 = paramFromServiceMsg;
        localObject5 = paramObject;
        localObject4 = localObject1;
        localObject3 = localObject2;
        localObject2 = localObject12;
        localObject1 = localObject11;
        paramObject = localObject10;
        paramFromServiceMsg = (FromServiceMsg)localObject8;
        break label248;
        bool1 = false;
        break;
        bool2 = false;
        break label2829;
        bool2 = false;
        break label2960;
        bool2 = true;
        break label3090;
        if (i4 == 0)
        {
          i4 = 1;
          break label3433;
        }
        i4 = 0;
        break label3433;
      } while ((i8 != 1) || (i4 == i6));
      if (i6 == 0)
      {
        bool2 = false;
        break label3542;
      }
      bool2 = true;
      break label3542;
      bool2 = false;
      break label5235;
      bool2 = false;
      break label5358;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = (RespSetCardSwitch)paramObject;
      if (bool2)
      {
        l1 = ((RespSetCardSwitch)paramObject).uCloseNeighborVote;
        paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject = ((FriendsManager)paramObject).b(paramToServiceMsg.getUin());
        if (l1 == 0L)
        {
          bool1 = true;
          ((Card)localObject).setZanShowFlag(bool1);
          ((FriendsManager)paramObject).a((Card)localObject);
          if (l1 != 0L) {
            break label187;
          }
        }
        label187:
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.putBoolean("modify_switch_for_near_people", bool2);
          paramBundle.putBoolean("target_switch", bool1);
          paramBundle.putString("uin", paramToServiceMsg.getUin());
          a(34, true, paramBundle);
          if (bool2) {
            StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "CMD_REQ_SETCARDSWITCH", paramFromServiceMsg.isSuccess(), 0L, 0L, null, "response");
          }
          return;
          bool1 = false;
          break;
        }
      }
      if (((RespSetCardSwitch)paramObject).uCloseTimeGateVote == 0L) {}
      for (bool1 = true;; bool1 = false)
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367841) + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), bool1).commit();
        break;
      }
    }
    long l1 = paramToServiceMsg.extraData.getLong("target_value");
    paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    if (l1 == 0L)
    {
      bool1 = true;
      label297:
      if (((QQAppInterface)paramObject).a(bool2, bool1)) {
        break label405;
      }
      if (!bool2) {
        break label413;
      }
      paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject = ((FriendsManager)paramObject).b(paramToServiceMsg.getUin());
      if (l1 != 0L) {
        break label407;
      }
      bool1 = true;
      label346:
      ((Card)localObject).setZanShowFlag(bool1);
      ((FriendsManager)paramObject).a((Card)localObject);
    }
    label405:
    label407:
    label413:
    for (boolean bool1 = ((Card)localObject).isShowZan();; bool1 = ((SharedPreferences)localObject).getBoolean(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131367841) + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), false))
    {
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      paramBundle.putBoolean("current_switch", bool1);
      a(34, false, paramBundle);
      break;
      bool1 = false;
      break label297;
      break;
      bool1 = false;
      break label346;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      paramObject = (QZoneCover)localEntityManager.a(QZoneCover.class, str);
      paramToServiceMsg = (ToServiceMsg)paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZoneCover();
        paramToServiceMsg.uin = str;
      }
      paramToServiceMsg.updateQzoneCover(paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localEntityManager.a(paramToServiceMsg);
        localEntityManager.a();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      a(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      localEntityManager.a(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int i1 = paramToServiceMsg.extraData.getInt("eSubCmd");
    paramBundle.putInt("eSubCmd", i1);
    paramBundle.putByte("bIsSingle", paramToServiceMsg.extraData.getByte("bIsSingle"));
    paramBundle.putByteArray("vBackground", paramToServiceMsg.extraData.getByteArray("vBackground"));
    paramBundle.putByteArray("vReqSetTemplate", paramToServiceMsg.extraData.getByteArray("vReqSetTemplate"));
    switch (i1)
    {
    default: 
      i1 = 3;
      if (26 == i1) {
        a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      }
      paramBundle = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (paramFromServiceMsg.isSuccess()) {
        if (26 == i1)
        {
          paramObject = paramBundle.a(paramToServiceMsg.getUin());
          paramFromServiceMsg = (FromServiceMsg)paramObject;
          if (paramObject == null) {
            break label737;
          }
          ((Card)paramObject).vBackground = paramToServiceMsg.extraData.getByteArray("vBackground");
          paramBundle.a((Card)paramObject);
          paramToServiceMsg = (ToServiceMsg)paramObject;
        }
      }
      break;
    }
    label423:
    label737:
    label748:
    label905:
    label910:
    for (;;)
    {
      if (i1 != 41) {
        a(i1, true, paramToServiceMsg);
      }
      return;
      i1 = 24;
      break;
      i1 = 25;
      break;
      i1 = 26;
      break;
      i1 = 41;
      break;
      if (i1 == 25)
      {
        try
        {
          paramFromServiceMsg = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vTagsID"))).readObject();
          paramToServiceMsg = paramBundle.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
        }
        catch (Exception paramFromServiceMsg)
        {
          try
          {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramFromServiceMsg);
            paramToServiceMsg.setTagInfosByte(paramFromServiceMsg);
            paramBundle.a(paramToServiceMsg);
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              boolean bool;
              continue;
              paramFromServiceMsg = null;
              continue;
              paramFromServiceMsg = null;
              paramToServiceMsg = null;
            }
            paramToServiceMsg = null;
          }
          paramFromServiceMsg = paramFromServiceMsg;
          paramToServiceMsg = null;
        }
        paramFromServiceMsg.printStackTrace();
      }
      else if (i1 == 24)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramFromServiceMsg.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.extraData.getByte("bIsSingle"));
        paramToServiceMsg = paramFromServiceMsg.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      else if (i1 == 41)
      {
        if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespSetCard)))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard success : " + bool + ", data : " + paramObject);
          }
          if ((paramObject == null) || (!bool)) {
            break label910;
          }
          paramToServiceMsg = (RespSetCard)paramObject;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard RespSetCard : " + paramToServiceMsg.toString());
          }
          if ((paramToServiceMsg.stHeader == null) || (paramToServiceMsg.stHeader.iReplyCode != 0) || (paramToServiceMsg.vRespSetTemplate == null)) {
            break label910;
          }
          paramFromServiceMsg = (SSummaryCardRsp)a(paramToServiceMsg.vRespSetTemplate, "rsp", new SSummaryCardRsp());
          if (paramFromServiceMsg == null) {
            break label910;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard cardRsp res : " + paramFromServiceMsg.res);
          }
          if (paramFromServiceMsg.res != 0) {
            break label748;
          }
          paramToServiceMsg = paramBundle.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (paramToServiceMsg == null) {
            break label905;
          }
          paramToServiceMsg.lCurrentStyleId = paramFromServiceMsg.styleid;
          paramToServiceMsg.backgroundUrl = paramFromServiceMsg.bgurl;
          paramToServiceMsg.lCurrentBgId = paramFromServiceMsg.bgid;
          paramToServiceMsg.backgroundColor = paramFromServiceMsg.color;
          paramFromServiceMsg = paramFromServiceMsg.bgtype;
          if (paramFromServiceMsg != null) {
            paramToServiceMsg.setBgType(paramFromServiceMsg);
          }
          paramToServiceMsg.templateRet = 0;
          paramBundle.a(paramToServiceMsg);
          paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.edit().putBoolean("svip_profile_use_guide_shown_flag", false).commit();
          }
          paramFromServiceMsg = null;
        }
        for (;;)
        {
          if (paramToServiceMsg != null) {
            paramFromServiceMsg = paramToServiceMsg;
          }
          a(i1, true, paramFromServiceMsg);
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramFromServiceMsg;
          break;
          bool = false;
          break label423;
          paramToServiceMsg = "";
          if (!TextUtils.isEmpty(paramFromServiceMsg.emsg)) {
            paramToServiceMsg = paramFromServiceMsg.emsg;
          }
          paramFromServiceMsg = new android.util.Pair(Integer.valueOf(paramFromServiceMsg.res), paramToServiceMsg);
          paramToServiceMsg = null;
        }
        a(i1, false, paramBundle.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        if (QLog.isColorLevel()) {
          QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        }
        ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1000277, "[资料卡]设置个性名片失败", true);
        return;
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = (String)paramToServiceMsg.getAttribute("uin");
    String str2 = (String)paramToServiceMsg.getAttribute("attachInfo");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_photo_wall_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_photo_wall_rsp)paramObject;
      localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      paramObject = (QZonePhotoWall)localEntityManager.a(QZonePhotoWall.class, str1);
      paramToServiceMsg = (ToServiceMsg)paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZonePhotoWall();
        paramToServiceMsg.uin = str1;
      }
      paramToServiceMsg.updateQzonePhotoWall(str2, paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localEntityManager.a(paramToServiceMsg);
        localEntityManager.a();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qzonephotowall", 2, "handleGetPhotoWall isSuc:" + bool);
      }
      a(69, bool, new Object[] { str2, paramToServiceMsg, str1 });
      return;
      localEntityManager.a(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel success : " + bool + ", data : " + paramObject);
      }
      if ((!bool) || (paramObject == null)) {
        break label210;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramBundle = paramFromServiceMsg.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramBundle.setLabelList(paramToServiceMsg.likes.label);
        paramFromServiceMsg.a(paramBundle);
      }
      a(52, true, paramObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    a(52, false, paramObject);
    return;
    label210:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    a(52, false, paramObject);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1000277, "[资料卡]设置标签失败", true);
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramFromServiceMsg = (String)paramToServiceMsg.getAttribute("uin");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("photo_id");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "handleDelPhotoWall isSuc:" + bool + " photoid:" + paramToServiceMsg);
    }
    a(70, bool, new Object[] { paramFromServiceMsg });
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    Card localCard;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike success : " + bool + ", data : " + paramObject);
      }
      paramBundle = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localCard = paramBundle.b(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
      long l1 = paramToServiceMsg.extraData.getLong("labelId");
      if ((!bool) || (paramObject == null)) {
        break label254;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        localCard.setLabelList(paramToServiceMsg.likes.label);
        paramBundle.a(localCard);
      }
      a(53, true, new Object[] { localCard, Long.valueOf(Long.valueOf(l1).longValue()) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    a(53, false, localCard);
    return;
    label254:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    a(53, false, localCard);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1000277, "[资料卡]设置标签失败", true);
  }
  
  /* Error */
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 13
    //   3: iconst_0
    //   4: istore 15
    //   6: iconst_0
    //   7: istore 16
    //   9: iconst_0
    //   10: istore 14
    //   12: aload_2
    //   13: invokevirtual 953	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +472 -> 488
    //   19: aload_3
    //   20: ifnull +468 -> 488
    //   23: iconst_1
    //   24: istore 7
    //   26: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc_w 745
    //   35: iconst_2
    //   36: new 270	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1792
    //   46: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 7
    //   51: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 7
    //   62: istore 8
    //   64: iload 14
    //   66: istore 10
    //   68: iload 7
    //   70: ifeq +343 -> 413
    //   73: iload 7
    //   75: istore 12
    //   77: iload 7
    //   79: istore 9
    //   81: iload 16
    //   83: istore 11
    //   85: new 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: dup
    //   89: invokespecial 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   92: aload_3
    //   93: checkcast 954	[B
    //   96: checkcast 954	[B
    //   99: invokevirtual 958	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +387 -> 494
    //   110: iload 7
    //   112: istore 12
    //   114: iload 7
    //   116: istore 9
    //   118: iload 16
    //   120: istore 11
    //   122: aload_2
    //   123: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +365 -> 494
    //   132: iconst_1
    //   133: istore 7
    //   135: iload 7
    //   137: istore 12
    //   139: iload 7
    //   141: istore 9
    //   143: iload 16
    //   145: istore 11
    //   147: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +43 -> 193
    //   153: iload 7
    //   155: istore 12
    //   157: iload 7
    //   159: istore 9
    //   161: iload 16
    //   163: istore 11
    //   165: ldc_w 745
    //   168: iconst_2
    //   169: new 270	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1794
    //   179: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 7
    //   184: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload 7
    //   195: istore 8
    //   197: iload 14
    //   199: istore 10
    //   201: iload 7
    //   203: ifeq +210 -> 413
    //   206: iload 7
    //   208: istore 8
    //   210: iload 14
    //   212: istore 10
    //   214: iload 7
    //   216: istore 12
    //   218: iload 7
    //   220: istore 9
    //   222: iload 16
    //   224: istore 11
    //   226: aload_2
    //   227: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   230: invokevirtual 1795	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   233: ifeq +180 -> 413
    //   236: iload 7
    //   238: istore 8
    //   240: iload 14
    //   242: istore 10
    //   244: iload 7
    //   246: istore 12
    //   248: iload 7
    //   250: istore 9
    //   252: iload 16
    //   254: istore 11
    //   256: aload_2
    //   257: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   260: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   263: ifnull +150 -> 413
    //   266: iload 7
    //   268: istore 12
    //   270: iload 7
    //   272: istore 9
    //   274: iload 16
    //   276: istore 11
    //   278: aload_2
    //   279: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   282: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   285: invokevirtual 964	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   288: invokestatic 968	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   291: astore_2
    //   292: iload 7
    //   294: istore 12
    //   296: iload 7
    //   298: istore 9
    //   300: iload 16
    //   302: istore 11
    //   304: aload_2
    //   305: invokevirtual 970	java/nio/ByteBuffer:getInt	()I
    //   308: istore 4
    //   310: iload 4
    //   312: i2l
    //   313: lstore 5
    //   315: iload 4
    //   317: ifge +12 -> 329
    //   320: iload 4
    //   322: ldc_w 1796
    //   325: iand
    //   326: i2l
    //   327: lstore 5
    //   329: iload 7
    //   331: istore 12
    //   333: iload 7
    //   335: istore 9
    //   337: iload 16
    //   339: istore 11
    //   341: aload_2
    //   342: invokevirtual 973	java/nio/ByteBuffer:get	()B
    //   345: pop
    //   346: iload 7
    //   348: istore 8
    //   350: iload 14
    //   352: istore 10
    //   354: iload 7
    //   356: istore 12
    //   358: iload 7
    //   360: istore 9
    //   362: iload 16
    //   364: istore 11
    //   366: aload_2
    //   367: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   370: invokestatic 1799	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   373: invokevirtual 636	java/lang/Short:shortValue	()S
    //   376: iconst_1
    //   377: if_icmpne +36 -> 413
    //   380: iload 7
    //   382: istore 12
    //   384: iload 7
    //   386: istore 9
    //   388: iload 16
    //   390: istore 11
    //   392: aload_2
    //   393: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   396: istore 4
    //   398: iload 4
    //   400: sipush 40494
    //   403: if_icmpeq +97 -> 500
    //   406: iconst_0
    //   407: istore 8
    //   409: iload 14
    //   411: istore 10
    //   413: iload 8
    //   415: istore 9
    //   417: iload 10
    //   419: istore 11
    //   421: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +50 -> 474
    //   427: ldc_w 745
    //   430: iconst_2
    //   431: new 270	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 1794
    //   441: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 8
    //   446: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   449: ldc_w 1801
    //   452: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload 10
    //   457: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: iload 10
    //   468: istore 11
    //   470: iload 8
    //   472: istore 9
    //   474: aload_0
    //   475: bipush 54
    //   477: iload 9
    //   479: iload 11
    //   481: invokestatic 984	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   484: invokevirtual 569	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   487: return
    //   488: iconst_0
    //   489: istore 7
    //   491: goto -465 -> 26
    //   494: iconst_0
    //   495: istore 7
    //   497: goto -362 -> 135
    //   500: iload 7
    //   502: istore 12
    //   504: iload 7
    //   506: istore 9
    //   508: iload 16
    //   510: istore 11
    //   512: aload_2
    //   513: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   516: istore 4
    //   518: iload 4
    //   520: iconst_2
    //   521: if_icmpne +123 -> 644
    //   524: iload 7
    //   526: istore 12
    //   528: iload 7
    //   530: istore 9
    //   532: iload 16
    //   534: istore 11
    //   536: iload 4
    //   538: newarray <illegal type>
    //   540: astore_3
    //   541: iload 7
    //   543: istore 12
    //   545: iload 7
    //   547: istore 9
    //   549: iload 16
    //   551: istore 11
    //   553: aload_2
    //   554: aload_3
    //   555: invokevirtual 1226	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   558: pop
    //   559: iload 7
    //   561: istore 12
    //   563: iload 7
    //   565: istore 9
    //   567: iload 16
    //   569: istore 11
    //   571: aload_3
    //   572: iconst_0
    //   573: invokestatic 1328	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   576: istore 4
    //   578: iload 4
    //   580: ifne +32 -> 612
    //   583: iconst_0
    //   584: istore 8
    //   586: aload_2
    //   587: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   590: istore 4
    //   592: iload 4
    //   594: ifeq +24 -> 618
    //   597: iload 13
    //   599: istore 7
    //   601: iload 8
    //   603: istore 10
    //   605: iload 7
    //   607: istore 8
    //   609: goto -196 -> 413
    //   612: iconst_1
    //   613: istore 8
    //   615: goto -29 -> 586
    //   618: aload_0
    //   619: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   622: invokevirtual 1181	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   625: aload_1
    //   626: invokevirtual 817	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   629: aconst_null
    //   630: ldc_w 1319
    //   633: iload 8
    //   635: invokestatic 1332	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   638: iconst_1
    //   639: istore 7
    //   641: goto -40 -> 601
    //   644: iconst_0
    //   645: istore 8
    //   647: iload 14
    //   649: istore 10
    //   651: goto -238 -> 413
    //   654: astore_1
    //   655: iload 15
    //   657: istore 8
    //   659: iload 12
    //   661: istore 7
    //   663: iload 7
    //   665: istore 9
    //   667: iload 8
    //   669: istore 11
    //   671: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq +22 -> 696
    //   677: iload 7
    //   679: istore 9
    //   681: iload 8
    //   683: istore 11
    //   685: ldc_w 745
    //   688: iconst_2
    //   689: ldc_w 1803
    //   692: aload_1
    //   693: invokestatic 1134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   696: iload 7
    //   698: istore 9
    //   700: iload 8
    //   702: istore 11
    //   704: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq -233 -> 474
    //   710: ldc_w 745
    //   713: iconst_2
    //   714: new 270	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 1794
    //   724: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: iload 7
    //   729: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   732: ldc_w 1801
    //   735: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: iload 8
    //   740: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   743: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: iload 7
    //   751: istore 9
    //   753: iload 8
    //   755: istore 11
    //   757: goto -283 -> 474
    //   760: astore_1
    //   761: iload 9
    //   763: istore 7
    //   765: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq +42 -> 810
    //   771: ldc_w 745
    //   774: iconst_2
    //   775: new 270	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 1794
    //   785: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: iload 7
    //   790: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   793: ldc_w 1801
    //   796: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: iload 11
    //   801: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   804: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: aload_1
    //   811: athrow
    //   812: astore_1
    //   813: iload 8
    //   815: istore 11
    //   817: goto -52 -> 765
    //   820: astore_1
    //   821: iconst_1
    //   822: istore 7
    //   824: iload 8
    //   826: istore 11
    //   828: goto -63 -> 765
    //   831: astore_1
    //   832: goto -169 -> 663
    //   835: astore_1
    //   836: iconst_1
    //   837: istore 7
    //   839: goto -176 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	CardHandler
    //   0	842	1	paramToServiceMsg	ToServiceMsg
    //   0	842	2	paramFromServiceMsg	FromServiceMsg
    //   0	842	3	paramObject	Object
    //   308	285	4	i1	int
    //   313	15	5	l1	long
    //   24	814	7	bool1	boolean
    //   62	763	8	bool2	boolean
    //   79	683	9	bool3	boolean
    //   66	584	10	bool4	boolean
    //   83	744	11	bool5	boolean
    //   75	585	12	bool6	boolean
    //   1	597	13	bool7	boolean
    //   10	638	14	bool8	boolean
    //   4	652	15	bool9	boolean
    //   7	561	16	bool10	boolean
    // Exception table:
    //   from	to	target	type
    //   85	106	654	java/lang/Exception
    //   122	132	654	java/lang/Exception
    //   147	153	654	java/lang/Exception
    //   165	193	654	java/lang/Exception
    //   226	236	654	java/lang/Exception
    //   256	266	654	java/lang/Exception
    //   278	292	654	java/lang/Exception
    //   304	310	654	java/lang/Exception
    //   341	346	654	java/lang/Exception
    //   366	380	654	java/lang/Exception
    //   392	398	654	java/lang/Exception
    //   512	518	654	java/lang/Exception
    //   536	541	654	java/lang/Exception
    //   553	559	654	java/lang/Exception
    //   571	578	654	java/lang/Exception
    //   85	106	760	finally
    //   122	132	760	finally
    //   147	153	760	finally
    //   165	193	760	finally
    //   226	236	760	finally
    //   256	266	760	finally
    //   278	292	760	finally
    //   304	310	760	finally
    //   341	346	760	finally
    //   366	380	760	finally
    //   392	398	760	finally
    //   512	518	760	finally
    //   536	541	760	finally
    //   553	559	760	finally
    //   571	578	760	finally
    //   671	677	760	finally
    //   685	696	760	finally
    //   586	592	812	finally
    //   618	638	820	finally
    //   586	592	831	java/lang/Exception
    //   618	638	835	java/lang/Exception
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYMakeFriendsCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramBundle = paramToServiceMsg.b((String)paramObject);
        paramBundle.uin = ((String)paramObject);
        paramBundle.strNick = paramFromServiceMsg.stMakeFriendsCard.strNick;
        paramBundle.shGender = paramFromServiceMsg.stMakeFriendsCard.shGender;
        paramBundle.shAge = paramFromServiceMsg.stMakeFriendsCard.shAge;
        paramBundle.nFaceID = paramFromServiceMsg.stMakeFriendsCard.nFaceID;
        paramBundle.strCertificationInfo = paramFromServiceMsg.stMakeFriendsCard.strCertificationInfo;
        paramBundle.shType = paramFromServiceMsg.stMakeFriendsCard.stIntro.shType;
        paramBundle.vContent = paramFromServiceMsg.stMakeFriendsCard.stIntro.vContent;
        paramBundle.vQQFaceID = paramFromServiceMsg.stMakeFriendsCard.vQQFaceID;
        paramBundle.bWeiboInfo = paramFromServiceMsg.bWeiboInfo;
        paramBundle.bQzoneInfo = paramFromServiceMsg.bQzoneInfo;
        paramBundle.nSameFriendsNum = paramFromServiceMsg.nSameFriendsNum;
        paramBundle.strCompanySame = paramFromServiceMsg.strCompany;
        paramBundle.strSchoolSame = paramFromServiceMsg.strSchool;
        paramBundle.bSingle = paramFromServiceMsg.stMakeFriendsCard.bSingle;
        paramBundle.lVisitCount = paramFromServiceMsg.stMakeFriendsCard.lVisitCount;
        if ((i1 == 0) || (paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp > paramBundle.uFaceTimeStamp))
        {
          paramBundle.uFaceTimeStamp = paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp;
          paramBundle.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        if (paramFromServiceMsg.stMakeFriendsCard.lVoteCount > paramBundle.lVoteCount) {
          paramBundle.lVoteCount = paramFromServiceMsg.stMakeFriendsCard.lVoteCount;
        }
        paramObject = paramFromServiceMsg.stMakeFriendsCard.vTags;
        if ((paramObject != null) && (((ArrayList)paramObject).size() > 0))
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((ArrayList)paramObject);
          paramBundle.setTagInfosByte(paramObject);
        }
        paramBundle.eUserIdentityType = ((byte)paramFromServiceMsg.stMakeFriendsCard.eUserIdentityType);
        paramBundle.vBackground = paramFromServiceMsg.stMakeFriendsCard.vBackground;
        paramBundle.bVoted = paramFromServiceMsg.bVoted;
        paramBundle.iFaceNum = paramFromServiceMsg.stMakeFriendsCard.iFaceNum;
        paramBundle.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramBundle.iQQLevel = paramFromServiceMsg.stMakeFriendsCard.iQQLevel;
        paramToServiceMsg.a(paramBundle);
        paramToServiceMsg.a(paramBundle.uin, (short)paramBundle.nFaceID, paramBundle.strNick, paramBundle.strSign);
        a(1, true, paramBundle);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  private void m()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        a(71, false, new Object[] { "" });
        return;
      }
      String str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (TextUtils.isEmpty(str1))
      {
        a(71, false, new Object[] { "" });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "uploadPhotoWall filePath:" + str2);
    }
    this.n = str2;
    ??? = new PhotoWallUploadTask();
    ((PhotoWallUploadTask)???).flowId = ((int)System.currentTimeMillis() / 1000);
    ((PhotoWallUploadTask)???).iLoginType = 6;
    ((PhotoWallUploadTask)???).sRefer = "mqq";
    ((PhotoWallUploadTask)???).iUin = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((PhotoWallUploadTask)???).vLoginData = VipUploadUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    ((PhotoWallUploadTask)???).op = 1;
    ((PhotoWallUploadTask)???).source = 1;
    ((PhotoWallUploadTask)???).uploadTaskCallback = new put(this);
    ((PhotoWallUploadTask)???).uploadFilePath = str2;
    ((PhotoWallUploadTask)???).md5 = VipUploadUtils.a(str2);
    ((PhotoWallUploadTask)???).autoRotate = true;
    if (!IUploadService.UploadServiceCreator.getInstance().isInitialized()) {
      IUploadService.UploadServiceCreator.getInstance().init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), new puu(this, Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())), null, null, new UploadEnv());
    }
    IUploadService.UploadServiceCreator.getInstance().upload((AbstractUploadTask)???);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    String str;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState success=" + bool1);
      }
      paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131371675);
      str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      bool3 = bool1;
      if (!bool1) {
        break label610;
      }
      bool2 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject == null) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool4 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool1);
        }
        bool3 = bool1;
        if (!bool1) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        int i1 = ByteBuffer.wrap(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray()).getInt();
        long l1 = i1;
        if (i1 < 0) {
          l1 = i1 & 0x7FFFFFFF | 0x80000000;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1))) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool1 = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = true;
        bool3 = bool1;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool4 = bool2;
          bool3 = bool1;
        }
      }
      catch (Exception paramObject)
      {
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool2;
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState ex", (Throwable)paramObject);
        if (!QLog.isColorLevel()) {
          break label600;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = false;
        bool4 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool4 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      a(55, bool4, new Object[] { Boolean.valueOf(bool3), paramFromServiceMsg, str });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
      continue;
      label600:
      bool3 = false;
      bool4 = bool2;
      continue;
      label610:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() , resp.getResultCode() = " + paramFromServiceMsg.getResultCode());
    }
    long l1 = paramToServiceMsg.extraData.getLong("pttcenter_targetuin");
    int i2 = paramToServiceMsg.extraData.getInt("pttcenter_voice_optype");
    int i1 = 9006;
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    boolean bool1;
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespVoiceManage)))
    {
      bool1 = true;
      if (!bool1) {}
    }
    else
    {
      try
      {
        localRespHead = (SummaryCard.RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder().append("handleVoiceManager() respHead.iResult = ");
          if (localRespHead == null) {
            break label501;
          }
          paramBundle = Integer.valueOf(localRespHead.iResult);
          label160:
          QLog.d("Q.profilecard.SummaryCard", 2, paramBundle);
        }
        if (localRespHead != null) {
          break label507;
        }
        bool1 = false;
        i1 = 9045;
        localStringBuilder1.append("|wupbuf: ").append(HexUtil.a(paramFromServiceMsg.getWupBuffer()));
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          SummaryCard.RespHead localRespHead;
          label209:
          short s1;
          label377:
          boolean bool2;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.SummaryCard", 2, paramBundle.toString());
          }
          bool1 = false;
          i1 = 9045;
          localStringBuilder1.append("|exception: ").append(paramBundle.toString()).append("|wufbuf: ").append(HexUtil.a(paramFromServiceMsg.getWupBuffer()));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() lUin = " + l1 + ", eOptype = " + i2 + ", success = " + bool1);
      }
      if (!bool1) {
        break label741;
      }
      paramBundle = (RespVoiceManage)paramObject;
      if (l1 > 0L)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramObject = paramFromServiceMsg.b(String.valueOf(l1));
        if (paramBundle.eOpType != 1) {
          break label650;
        }
        paramBundle = paramToServiceMsg.extraData.getString("pttcenter_filekey");
        s1 = paramToServiceMsg.extraData.getShort("pttcenter_shDuration");
        ((Card)paramObject).strVoiceFilekey = paramBundle;
        ((Card)paramObject).shDuration = s1;
        ((Card)paramObject).bRead = 0;
        ((Card)paramObject).strUrl = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "上传成功");
        }
        bool2 = paramFromServiceMsg.a((Card)paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "更新结果  bRet = " + bool2);
        }
        a(35, true, new Object[] { String.valueOf(l1), Integer.valueOf(i2), paramObject });
      }
    }
    for (;;)
    {
      if (i2 == 1) {
        ProfileCardUtil.a(String.valueOf(l1), 0, bool1, paramToServiceMsg.extraData.getString("pttcenter_filekey"), "0", ProfileCardUtil.a(), 0, i1, 0L, localStringBuilder1.toString(), "");
      }
      return;
      bool1 = false;
      break;
      label501:
      paramBundle = null;
      break label160;
      label507:
      if (localRespHead.iResult != 0)
      {
        localStringBuilder1.append("|iResult: ").append(localRespHead.iResult);
        bool1 = false;
        i1 = 9007;
        break label209;
      }
      bool1 = true;
      break label209;
      i1 = 9311;
      localStringBuilder1.append("|resultcode: ").append(paramFromServiceMsg.getResultCode()).append("|reason: ").append(MessageHandler.a(paramFromServiceMsg));
      break label209;
      label650:
      if (paramBundle.eOpType == 2)
      {
        ((Card)paramObject).strVoiceFilekey = "";
        ((Card)paramObject).shDuration = 0;
        ((Card)paramObject).bRead = 0;
        ((Card)paramObject).strUrl = null;
        if (!QLog.isColorLevel()) {
          break label377;
        }
        QLog.d("Q.profilecard.SummaryCard", 2, "删除成功");
        break label377;
      }
      if (paramBundle.eOpType != 3) {
        break label377;
      }
      if (((Card)paramObject).bRead != 1) {
        ((Card)paramObject).bRead = 1;
      }
      if (!QLog.isColorLevel()) {
        break label377;
      }
      QLog.d("Q.profilecard.SummaryCard", 2, "已读标识设置成功");
      break label377;
      label741:
      a(35, false, new Object[] { String.valueOf(l1), Integer.valueOf(i2), null });
    }
  }
  
  /* Error */
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: aload_2
    //   4: invokevirtual 953	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +419 -> 426
    //   10: aload_3
    //   11: ifnull +415 -> 426
    //   14: iconst_1
    //   15: istore 7
    //   17: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 745
    //   26: iconst_2
    //   27: new 270	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 2086
    //   37: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 7
    //   42: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: bipush 50
    //   57: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   60: checkcast 552	com/tencent/mobileqq/app/FriendsManager
    //   63: astore_1
    //   64: aload_1
    //   65: aload_0
    //   66: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   72: invokevirtual 819	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   75: astore_2
    //   76: iload 7
    //   78: istore 10
    //   80: iload 7
    //   82: ifeq +636 -> 718
    //   85: iload 7
    //   87: istore 8
    //   89: iload 7
    //   91: istore 9
    //   93: new 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: dup
    //   97: invokespecial 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   100: aload_3
    //   101: checkcast 954	[B
    //   104: checkcast 954	[B
    //   107: invokevirtual 958	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: checkcast 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +317 -> 432
    //   118: iload 7
    //   120: istore 8
    //   122: iload 7
    //   124: istore 9
    //   126: aload_3
    //   127: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: ifne +299 -> 432
    //   136: iconst_1
    //   137: istore 7
    //   139: iload 7
    //   141: istore 8
    //   143: iload 7
    //   145: istore 9
    //   147: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +39 -> 189
    //   153: iload 7
    //   155: istore 8
    //   157: iload 7
    //   159: istore 9
    //   161: ldc_w 745
    //   164: iconst_2
    //   165: new 270	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 2088
    //   175: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 7
    //   180: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iload 7
    //   191: istore 10
    //   193: iload 7
    //   195: ifeq +523 -> 718
    //   198: iload 7
    //   200: istore 8
    //   202: iload 7
    //   204: istore 9
    //   206: iload 7
    //   208: istore 10
    //   210: aload_3
    //   211: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   214: invokevirtual 1795	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   217: ifeq +501 -> 718
    //   220: iload 7
    //   222: istore 8
    //   224: iload 7
    //   226: istore 9
    //   228: iload 7
    //   230: istore 10
    //   232: aload_3
    //   233: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   239: ifnull +479 -> 718
    //   242: iload 7
    //   244: istore 8
    //   246: iload 7
    //   248: istore 9
    //   250: aload_3
    //   251: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 964	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   260: invokestatic 968	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   263: astore_3
    //   264: iload 7
    //   266: istore 8
    //   268: iload 7
    //   270: istore 9
    //   272: aload_3
    //   273: invokevirtual 970	java/nio/ByteBuffer:getInt	()I
    //   276: pop
    //   277: iload 7
    //   279: istore 8
    //   281: iload 7
    //   283: istore 9
    //   285: aload_3
    //   286: invokevirtual 973	java/nio/ByteBuffer:get	()B
    //   289: pop
    //   290: iload 7
    //   292: istore 8
    //   294: iload 7
    //   296: istore 9
    //   298: iload 7
    //   300: istore 10
    //   302: aload_3
    //   303: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   306: invokestatic 1799	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   309: invokevirtual 636	java/lang/Short:shortValue	()S
    //   312: iconst_1
    //   313: if_icmpne +405 -> 718
    //   316: iload 7
    //   318: istore 8
    //   320: iload 7
    //   322: istore 9
    //   324: aload_3
    //   325: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   328: istore 5
    //   330: iload 7
    //   332: istore 8
    //   334: iload 7
    //   336: istore 9
    //   338: aload_0
    //   339: getfield 310	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_Short	S
    //   342: istore 6
    //   344: iload 5
    //   346: iload 6
    //   348: if_icmpeq +90 -> 438
    //   351: iload 11
    //   353: istore 8
    //   355: iload 8
    //   357: istore 9
    //   359: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +48 -> 410
    //   365: ldc_w 745
    //   368: iconst_2
    //   369: new 270	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 2088
    //   379: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 8
    //   384: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: ldc_w 1801
    //   390: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: getfield 2091	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   397: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   400: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iload 8
    //   408: istore 9
    //   410: aload_0
    //   411: bipush 44
    //   413: iload 9
    //   415: aload_2
    //   416: getfield 2091	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   419: invokestatic 984	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   422: invokevirtual 569	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   425: return
    //   426: iconst_0
    //   427: istore 7
    //   429: goto -412 -> 17
    //   432: iconst_0
    //   433: istore 7
    //   435: goto -296 -> 139
    //   438: iload 7
    //   440: istore 8
    //   442: iload 7
    //   444: istore 9
    //   446: aload_3
    //   447: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   450: istore 5
    //   452: iload 11
    //   454: istore 8
    //   456: iload 5
    //   458: iconst_2
    //   459: if_icmpne -104 -> 355
    //   462: iload 7
    //   464: istore 8
    //   466: iload 7
    //   468: istore 9
    //   470: iload 5
    //   472: newarray <illegal type>
    //   474: astore 4
    //   476: iload 7
    //   478: istore 8
    //   480: iload 7
    //   482: istore 9
    //   484: aload_3
    //   485: aload 4
    //   487: invokevirtual 1226	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   490: pop
    //   491: iload 7
    //   493: istore 8
    //   495: iload 7
    //   497: istore 9
    //   499: aload 4
    //   501: iconst_0
    //   502: invokestatic 1328	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   505: ifne +55 -> 560
    //   508: iconst_0
    //   509: istore 10
    //   511: iload 7
    //   513: istore 8
    //   515: iload 7
    //   517: istore 9
    //   519: aload_2
    //   520: iload 10
    //   522: putfield 2091	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   525: iload 7
    //   527: istore 8
    //   529: iload 7
    //   531: istore 9
    //   533: aload_3
    //   534: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   537: istore 5
    //   539: iload 11
    //   541: istore 8
    //   543: iload 5
    //   545: ifne -190 -> 355
    //   548: aload_1
    //   549: aload_2
    //   550: invokevirtual 566	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   553: pop
    //   554: iconst_1
    //   555: istore 8
    //   557: goto -202 -> 355
    //   560: iconst_1
    //   561: istore 10
    //   563: goto -52 -> 511
    //   566: astore_1
    //   567: iload 8
    //   569: istore 7
    //   571: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +14 -> 588
    //   577: ldc_w 745
    //   580: iconst_2
    //   581: ldc_w 2093
    //   584: aload_1
    //   585: invokestatic 1134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   588: iload 7
    //   590: istore 9
    //   592: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq -185 -> 410
    //   598: ldc_w 745
    //   601: iconst_2
    //   602: new 270	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 2088
    //   612: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: iload 7
    //   617: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   620: ldc_w 1801
    //   623: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_2
    //   627: getfield 2091	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   630: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   633: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: iload 7
    //   641: istore 9
    //   643: goto -233 -> 410
    //   646: astore_1
    //   647: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +44 -> 694
    //   653: ldc_w 745
    //   656: iconst_2
    //   657: new 270	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 2088
    //   667: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: iload 9
    //   672: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: ldc_w 1801
    //   678: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_2
    //   682: getfield 2091	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   685: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   688: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: aload_1
    //   695: athrow
    //   696: astore_1
    //   697: iconst_1
    //   698: istore 9
    //   700: goto -53 -> 647
    //   703: astore_1
    //   704: iload 7
    //   706: istore 9
    //   708: goto -61 -> 647
    //   711: astore_1
    //   712: iconst_1
    //   713: istore 7
    //   715: goto -144 -> 571
    //   718: iload 10
    //   720: istore 8
    //   722: goto -367 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	CardHandler
    //   0	725	1	paramToServiceMsg	ToServiceMsg
    //   0	725	2	paramFromServiceMsg	FromServiceMsg
    //   0	725	3	paramObject	Object
    //   474	26	4	arrayOfByte	byte[]
    //   328	216	5	i1	int
    //   342	7	6	i2	int
    //   15	699	7	bool1	boolean
    //   87	634	8	bool2	boolean
    //   91	616	9	bool3	boolean
    //   78	641	10	bool4	boolean
    //   1	539	11	bool5	boolean
    // Exception table:
    //   from	to	target	type
    //   93	114	566	java/lang/Exception
    //   126	136	566	java/lang/Exception
    //   147	153	566	java/lang/Exception
    //   161	189	566	java/lang/Exception
    //   210	220	566	java/lang/Exception
    //   232	242	566	java/lang/Exception
    //   250	264	566	java/lang/Exception
    //   272	277	566	java/lang/Exception
    //   285	290	566	java/lang/Exception
    //   302	316	566	java/lang/Exception
    //   324	330	566	java/lang/Exception
    //   338	344	566	java/lang/Exception
    //   446	452	566	java/lang/Exception
    //   470	476	566	java/lang/Exception
    //   484	491	566	java/lang/Exception
    //   499	508	566	java/lang/Exception
    //   519	525	566	java/lang/Exception
    //   533	539	566	java/lang/Exception
    //   93	114	646	finally
    //   126	136	646	finally
    //   147	153	646	finally
    //   161	189	646	finally
    //   210	220	646	finally
    //   232	242	646	finally
    //   250	264	646	finally
    //   272	277	646	finally
    //   285	290	646	finally
    //   302	316	646	finally
    //   324	330	646	finally
    //   338	344	646	finally
    //   446	452	646	finally
    //   470	476	646	finally
    //   484	491	646	finally
    //   499	508	646	finally
    //   519	525	646	finally
    //   533	539	646	finally
    //   548	554	696	finally
    //   571	588	703	finally
    //   548	554	711	java/lang/Exception
  }
  
  /* Error */
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc_w 2003
    //   9: iconst_2
    //   10: new 270	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 2097
    //   20: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 814	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   27: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: invokestatic 743	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   39: ifeq +4655 -> 4694
    //   42: invokestatic 1914	java/lang/System:currentTimeMillis	()J
    //   45: lstore 16
    //   47: aconst_null
    //   48: astore 4
    //   50: aload_2
    //   51: invokevirtual 953	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   54: ifeq +328 -> 382
    //   57: aload_3
    //   58: instanceof 2099
    //   61: ifeq +321 -> 382
    //   64: iconst_1
    //   65: istore 11
    //   67: iload 11
    //   69: ifeq +4620 -> 4689
    //   72: aload_0
    //   73: aload_2
    //   74: invokevirtual 2015	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   77: ldc_w 2017
    //   80: new 2019	SummaryCard/RespHead
    //   83: dup
    //   84: invokespecial 2020	SummaryCard/RespHead:<init>	()V
    //   87: invokevirtual 1651	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 2019	SummaryCard/RespHead
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +293 -> 388
    //   98: aload_2
    //   99: getfield 2025	SummaryCard/RespHead:iResult	I
    //   102: ifne +286 -> 388
    //   105: iconst_1
    //   106: istore 11
    //   108: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +44 -> 155
    //   114: new 270	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 2101
    //   124: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: astore 6
    //   129: aload_2
    //   130: ifnonnull +264 -> 394
    //   133: ldc_w 2103
    //   136: astore 4
    //   138: ldc_w 2003
    //   141: iconst_2
    //   142: aload 6
    //   144: aload 4
    //   146: invokevirtual 883	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_1
    //   156: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   159: ldc_w 524
    //   162: invokevirtual 696	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   165: lstore 18
    //   167: aload_1
    //   168: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   171: ldc_w 2105
    //   174: invokevirtual 527	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 4
    //   179: aload_1
    //   180: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   183: ldc_w 2107
    //   186: invokevirtual 702	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   189: istore 13
    //   191: iload 11
    //   193: ifeq +4420 -> 4613
    //   196: aload_0
    //   197: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   200: bipush 50
    //   202: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   205: checkcast 552	com/tencent/mobileqq/app/FriendsManager
    //   208: astore 8
    //   210: aload_0
    //   211: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: bipush 51
    //   216: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   219: checkcast 2109	com/tencent/mobileqq/app/TroopManager
    //   222: astore 7
    //   224: aload_3
    //   225: checkcast 2099	SummaryCard/RespSummaryCard
    //   228: astore 6
    //   230: lload 18
    //   232: lconst_0
    //   233: lcmp
    //   234: ifgt +209 -> 443
    //   237: iload 13
    //   239: bipush 41
    //   241: if_icmpeq +202 -> 443
    //   244: iload 13
    //   246: bipush 6
    //   248: if_icmpeq +195 -> 443
    //   251: iload 13
    //   253: bipush 45
    //   255: if_icmpeq +188 -> 443
    //   258: aload 8
    //   260: aload 4
    //   262: invokevirtual 2112	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ContactCard;
    //   265: astore_1
    //   266: aload_1
    //   267: aload 6
    //   269: getfield 2115	SummaryCard/RespSummaryCard:bAge	B
    //   272: putfield 2118	com/tencent/mobileqq/data/ContactCard:bAge	B
    //   275: aload_1
    //   276: aload 6
    //   278: getfield 2121	SummaryCard/RespSummaryCard:bSex	B
    //   281: putfield 2122	com/tencent/mobileqq/data/ContactCard:bSex	B
    //   284: aload_1
    //   285: aload 6
    //   287: getfield 2123	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   290: putfield 2126	com/tencent/mobileqq/data/ContactCard:nickName	Ljava/lang/String;
    //   293: aload_1
    //   294: aload 6
    //   296: getfield 2127	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   299: putfield 2128	com/tencent/mobileqq/data/ContactCard:strProvince	Ljava/lang/String;
    //   302: aload_1
    //   303: aload 6
    //   305: getfield 2129	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   308: putfield 2130	com/tencent/mobileqq/data/ContactCard:strCountry	Ljava/lang/String;
    //   311: aload_1
    //   312: aload 6
    //   314: getfield 2131	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   317: putfield 2132	com/tencent/mobileqq/data/ContactCard:strCity	Ljava/lang/String;
    //   320: aload_1
    //   321: aload 6
    //   323: getfield 2135	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   326: putfield 2136	com/tencent/mobileqq/data/ContactCard:strContactName	Ljava/lang/String;
    //   329: aload 8
    //   331: aload_1
    //   332: invokevirtual 2139	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ContactCard;)Z
    //   335: pop
    //   336: aload_0
    //   337: iconst_1
    //   338: iconst_1
    //   339: aload_1
    //   340: invokevirtual 569	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   343: invokestatic 743	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   346: ifeq +35 -> 381
    //   349: ldc_w 2003
    //   352: iconst_4
    //   353: new 270	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 2141
    //   363: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokestatic 1914	java/lang/System:currentTimeMillis	()J
    //   369: lload 16
    //   371: lsub
    //   372: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: return
    //   382: iconst_0
    //   383: istore 11
    //   385: goto -318 -> 67
    //   388: iconst_0
    //   389: istore 11
    //   391: goto -283 -> 108
    //   394: aload_2
    //   395: getfield 2025	SummaryCard/RespHead:iResult	I
    //   398: istore 12
    //   400: iload 12
    //   402: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   405: astore 4
    //   407: goto -269 -> 138
    //   410: astore 6
    //   412: aload 4
    //   414: astore_2
    //   415: aload 6
    //   417: astore 4
    //   419: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +15 -> 437
    //   425: ldc_w 2003
    //   428: iconst_2
    //   429: aload 4
    //   431: invokevirtual 2067	java/lang/Exception:toString	()Ljava/lang/String;
    //   434: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: iconst_0
    //   438: istore 11
    //   440: goto -285 -> 155
    //   443: aload_1
    //   444: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   447: ldc_w 2143
    //   450: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   453: iconst_1
    //   454: if_icmpeq -73 -> 381
    //   457: lload 18
    //   459: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   462: astore 9
    //   464: aload 8
    //   466: aload 9
    //   468: invokevirtual 819	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   471: astore 4
    //   473: aload 4
    //   475: aload 6
    //   477: getfield 2146	SummaryCard/RespSummaryCard:iLevel	I
    //   480: putfield 1894	com/tencent/mobileqq/data/Card:iQQLevel	I
    //   483: aload 4
    //   485: aload 6
    //   487: getfield 2123	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   490: putfield 1065	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   493: aload 4
    //   495: aload 6
    //   497: getfield 2121	SummaryCard/RespSummaryCard:bSex	B
    //   500: i2s
    //   501: putfield 1079	com/tencent/mobileqq/data/Card:shGender	S
    //   504: aload 4
    //   506: aload 6
    //   508: getfield 2115	SummaryCard/RespSummaryCard:bAge	B
    //   511: i2s
    //   512: putfield 1277	com/tencent/mobileqq/data/Card:shAge	S
    //   515: aload 4
    //   517: aload 6
    //   519: getfield 2115	SummaryCard/RespSummaryCard:bAge	B
    //   522: putfield 1088	com/tencent/mobileqq/data/Card:age	B
    //   525: aload 4
    //   527: aload 6
    //   529: getfield 2149	SummaryCard/RespSummaryCard:iFace	I
    //   532: putfield 1822	com/tencent/mobileqq/data/Card:nFaceID	I
    //   535: aload 4
    //   537: aload 6
    //   539: getfield 2150	SummaryCard/RespSummaryCard:strSign	Ljava/lang/String;
    //   542: putfield 1897	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   545: aload 4
    //   547: aload 6
    //   549: getfield 2131	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   552: putfield 1143	com/tencent/mobileqq/data/Card:strCity	Ljava/lang/String;
    //   555: aload 4
    //   557: aload 6
    //   559: getfield 2127	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   562: putfield 1140	com/tencent/mobileqq/data/Card:strProvince	Ljava/lang/String;
    //   565: aload 4
    //   567: aload 6
    //   569: getfield 2129	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   572: putfield 1137	com/tencent/mobileqq/data/Card:strCountry	Ljava/lang/String;
    //   575: aload 4
    //   577: aload 6
    //   579: getfield 2153	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   582: putfield 2156	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   585: aload 4
    //   587: aload 6
    //   589: getfield 2159	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   592: putfield 1007	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   595: aload 4
    //   597: aload 6
    //   599: getfield 2162	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   602: putfield 2165	com/tencent/mobileqq/data/Card:strTroopName	Ljava/lang/String;
    //   605: aload 4
    //   607: aload 6
    //   609: getfield 2168	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   612: putfield 2171	com/tencent/mobileqq/data/Card:strTroopNick	Ljava/lang/String;
    //   615: aload 4
    //   617: aload 6
    //   619: getfield 2174	SummaryCard/RespSummaryCard:strMobile	Ljava/lang/String;
    //   622: putfield 2175	com/tencent/mobileqq/data/Card:strMobile	Ljava/lang/String;
    //   625: aload 4
    //   627: aload 6
    //   629: getfield 2135	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   632: putfield 2176	com/tencent/mobileqq/data/Card:strContactName	Ljava/lang/String;
    //   635: aload 4
    //   637: aload 6
    //   639: getfield 2179	SummaryCard/RespSummaryCard:strStatus	Ljava/lang/String;
    //   642: putfield 2180	com/tencent/mobileqq/data/Card:strStatus	Ljava/lang/String;
    //   645: aload 4
    //   647: aload 6
    //   649: getfield 2183	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   652: putfield 2184	com/tencent/mobileqq/data/Card:strAutoRemark	Ljava/lang/String;
    //   655: aload 4
    //   657: aload 6
    //   659: getfield 2187	SummaryCard/RespSummaryCard:vSeed	[B
    //   662: putfield 2188	com/tencent/mobileqq/data/Card:vSeed	[B
    //   665: aload 4
    //   667: aload 6
    //   669: getfield 2191	SummaryCard/RespSummaryCard:iVoteCount	I
    //   672: i2l
    //   673: putfield 1872	com/tencent/mobileqq/data/Card:lVisitCount	J
    //   676: aload 4
    //   678: aload 6
    //   680: getfield 2194	SummaryCard/RespSummaryCard:uQQMasterLoginDays	J
    //   683: putfield 2197	com/tencent/mobileqq/data/Card:lQQMasterLogindays	J
    //   686: aload 4
    //   688: iload 13
    //   690: putfield 2199	com/tencent/mobileqq/data/Card:favoriteSource	I
    //   693: aload 4
    //   695: aload 6
    //   697: getfield 2202	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   700: putfield 2203	com/tencent/mobileqq/data/Card:strVoteLimitedNotice	Ljava/lang/String;
    //   703: aload 4
    //   705: aload 6
    //   707: getfield 2206	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   710: putfield 2207	com/tencent/mobileqq/data/Card:bHaveVotedCnt	S
    //   713: aload 4
    //   715: aload 6
    //   717: getfield 2208	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   720: putfield 740	com/tencent/mobileqq/data/Card:bAvailVoteCnt	S
    //   723: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   726: ifeq +61 -> 787
    //   729: ldc 97
    //   731: iconst_2
    //   732: new 270	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   739: ldc_w 2210
    //   742: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload 6
    //   747: getfield 2202	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   750: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc_w 2212
    //   756: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload 6
    //   761: getfield 2206	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   764: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   767: ldc_w 2214
    //   770: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: aload 6
    //   775: getfield 2208	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   778: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: aload 6
    //   789: getfield 2218	SummaryCard/RespSummaryCard:stQCallInfo	LSummaryCard/QCallInfo;
    //   792: astore_3
    //   793: aload_3
    //   794: ifnull +1442 -> 2236
    //   797: aload_3
    //   798: getfield 2223	SummaryCard/QCallInfo:bStatus	I
    //   801: iconst_1
    //   802: if_icmpne +1413 -> 2215
    //   805: aload 4
    //   807: iconst_1
    //   808: putfield 2226	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   811: aload 4
    //   813: aload_3
    //   814: getfield 2227	SummaryCard/QCallInfo:strNick	Ljava/lang/String;
    //   817: putfield 2230	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   820: aload 4
    //   822: aload_3
    //   823: getfield 2233	SummaryCard/QCallInfo:uQCallId	J
    //   826: invokestatic 2236	com/tencent/mobileqq/utils/StringUtil:a	(J)Ljava/lang/String;
    //   829: putfield 2239	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   832: invokestatic 743	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   835: ifeq +75 -> 910
    //   838: ldc_w 2241
    //   841: iconst_4
    //   842: new 270	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   849: ldc_w 2243
    //   852: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload 4
    //   857: getfield 2226	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   860: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   863: ldc_w 2245
    //   866: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: aload 4
    //   871: getfield 2230	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   874: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: ldc_w 2247
    //   880: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload_3
    //   884: getfield 2223	SummaryCard/QCallInfo:bStatus	I
    //   887: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: ldc_w 2249
    //   893: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 4
    //   898: getfield 2239	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   901: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: aload 9
    //   912: aload_0
    //   913: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   916: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   919: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   922: ifeq +38 -> 960
    //   925: aload_0
    //   926: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   929: bipush 105
    //   931: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   934: checkcast 1081	com/tencent/mobileqq/nearby/NearbyCardManager
    //   937: astore_3
    //   938: aload_3
    //   939: ifnull +21 -> 960
    //   942: aload_3
    //   943: aload 6
    //   945: getfield 2121	SummaryCard/RespSummaryCard:bSex	B
    //   948: invokevirtual 1083	com/tencent/mobileqq/nearby/NearbyCardManager:b	(I)V
    //   951: aload_3
    //   952: aload 6
    //   954: getfield 2115	SummaryCard/RespSummaryCard:bAge	B
    //   957: invokevirtual 1092	com/tencent/mobileqq/nearby/NearbyCardManager:a	(I)V
    //   960: aload_1
    //   961: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   964: ldc_w 2107
    //   967: invokevirtual 702	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   970: bipush 37
    //   972: if_icmpne +18 -> 990
    //   975: aload 4
    //   977: aload_1
    //   978: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   981: ldc_w 2105
    //   984: invokevirtual 527	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   987: putfield 2252	com/tencent/mobileqq/data/Card:encId	Ljava/lang/String;
    //   990: aload_2
    //   991: ifnull +12 -> 1003
    //   994: aload 4
    //   996: aload_2
    //   997: getfield 2255	SummaryCard/RespHead:vCookies	[B
    //   1000: putfield 2256	com/tencent/mobileqq/data/Card:vCookies	[B
    //   1003: aload 6
    //   1005: getfield 2259	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1008: ifne +1247 -> 2255
    //   1011: aload 4
    //   1013: iconst_1
    //   1014: putfield 563	com/tencent/mobileqq/data/Card:bVoted	B
    //   1017: aload 4
    //   1019: aload 6
    //   1021: getfield 2262	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1024: l2i
    //   1025: putfield 2264	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   1028: aload 9
    //   1030: aload_0
    //   1031: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1034: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1037: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1040: ifeq +1254 -> 2294
    //   1043: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1046: ifeq +48 -> 1094
    //   1049: ldc_w 2003
    //   1052: iconst_2
    //   1053: new 270	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   1060: ldc_w 2266
    //   1063: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: aload 6
    //   1068: getfield 2191	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1071: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1074: ldc_w 2268
    //   1077: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: aload 6
    //   1082: getfield 2271	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1085: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1088: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1091: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1094: aload 4
    //   1096: aload 6
    //   1098: getfield 2191	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1101: i2l
    //   1102: putfield 560	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1105: aload 4
    //   1107: aload 6
    //   1109: getfield 2271	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1112: putfield 2274	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1115: aload_0
    //   1116: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1119: invokevirtual 1104	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1122: aload 4
    //   1124: getfield 560	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1127: aload 4
    //   1129: getfield 2274	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1132: invokestatic 2277	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   1135: pop
    //   1136: aload_0
    //   1137: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1140: invokevirtual 1042	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   1143: invokevirtual 1048	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1146: astore 10
    //   1148: aload 10
    //   1150: ldc_w 2279
    //   1153: ldc_w 2281
    //   1156: iconst_1
    //   1157: anewarray 422	java/lang/String
    //   1160: dup
    //   1161: iconst_0
    //   1162: aload 9
    //   1164: aastore
    //   1165: invokevirtual 2284	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   1168: checkcast 2279	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1171: astore_3
    //   1172: aload_3
    //   1173: astore_2
    //   1174: aload_3
    //   1175: ifnonnull +11 -> 1186
    //   1178: new 2279	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1181: dup
    //   1182: invokespecial 2285	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   1185: astore_2
    //   1186: aload_2
    //   1187: aload 4
    //   1189: getfield 560	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1192: l2i
    //   1193: putfield 2288	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1196: aload_2
    //   1197: aload 4
    //   1199: getfield 2274	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1202: putfield 2291	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1205: aload_2
    //   1206: invokevirtual 2292	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1209: sipush 1000
    //   1212: if_icmpne +1052 -> 2264
    //   1215: aload 10
    //   1217: aload_2
    //   1218: invokevirtual 2294	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   1221: aload 10
    //   1223: invokevirtual 1590	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1226: aload 6
    //   1228: getfield 2262	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1231: ldc2_w 2295
    //   1234: land
    //   1235: lconst_0
    //   1236: lcmp
    //   1237: ifne +1081 -> 2318
    //   1240: iconst_0
    //   1241: istore 20
    //   1243: aload 4
    //   1245: iload 20
    //   1247: invokevirtual 1171	com/tencent/mobileqq/data/Card:setZanShowFlag	(Z)V
    //   1250: aload 6
    //   1252: getfield 2262	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1255: lconst_1
    //   1256: land
    //   1257: lconst_0
    //   1258: lcmp
    //   1259: ifne +1065 -> 2324
    //   1262: iconst_0
    //   1263: istore 20
    //   1265: aload 4
    //   1267: iload 20
    //   1269: invokevirtual 2299	com/tencent/mobileqq/data/Card:setFeedsShowFlag	(Z)V
    //   1272: aload 6
    //   1274: getfield 2262	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1277: ldc2_w 2300
    //   1280: land
    //   1281: lconst_0
    //   1282: lcmp
    //   1283: ifne +1047 -> 2330
    //   1286: iconst_0
    //   1287: istore 20
    //   1289: aload 4
    //   1291: iload 20
    //   1293: invokevirtual 2304	com/tencent/mobileqq/data/Card:setPhotoShowFlag	(Z)V
    //   1296: aload 6
    //   1298: getfield 2307	SummaryCard/RespSummaryCard:lCacheControl	J
    //   1301: lconst_0
    //   1302: lcmp
    //   1303: ifne +1033 -> 2336
    //   1306: iconst_0
    //   1307: istore 20
    //   1309: aload 4
    //   1311: iload 20
    //   1313: invokevirtual 2310	com/tencent/mobileqq/data/Card:setPhotoUseCacheFlag	(Z)V
    //   1316: aload 6
    //   1318: getfield 2262	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1321: ldc2_w 2311
    //   1324: land
    //   1325: lconst_0
    //   1326: lcmp
    //   1327: ifne +1015 -> 2342
    //   1330: iconst_0
    //   1331: istore 20
    //   1333: aload 4
    //   1335: iload 20
    //   1337: invokevirtual 2315	com/tencent/mobileqq/data/Card:setXManFlag	(Z)V
    //   1340: aload 4
    //   1342: aload 6
    //   1344: getfield 2318	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   1347: putfield 2319	com/tencent/mobileqq/data/Card:strQzoneFeedsDesc	Ljava/lang/String;
    //   1350: aload 4
    //   1352: aload 6
    //   1354: getfield 2322	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   1357: putfield 2323	com/tencent/mobileqq/data/Card:strSpaceName	Ljava/lang/String;
    //   1360: aload 4
    //   1362: invokevirtual 2326	com/tencent/mobileqq/data/Card:isPhotoUseCache	()Z
    //   1365: ifne +34 -> 1399
    //   1368: aload 4
    //   1370: getfield 2329	com/tencent/mobileqq/data/Card:qzonePhotoList	Ljava/util/ArrayList;
    //   1373: invokevirtual 2330	java/util/ArrayList:clear	()V
    //   1376: aload 6
    //   1378: getfield 2334	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1381: astore_2
    //   1382: aload_2
    //   1383: ifnull +16 -> 1399
    //   1386: aload_2
    //   1387: getfield 2339	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1390: ifnull +9 -> 1399
    //   1393: aload 4
    //   1395: aload_2
    //   1396: invokevirtual 2343	com/tencent/mobileqq/data/Card:addQzonePhotoList	(LSummaryCard/AlbumInfo;)V
    //   1399: aload 4
    //   1401: aload 6
    //   1403: getfield 2344	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   1406: invokevirtual 2348	com/tencent/mobileqq/data/Card:setVipInfo	(LQQService/VipBaseInfo;)V
    //   1409: aload_1
    //   1410: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1413: ldc_w 2350
    //   1416: invokevirtual 696	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1419: lstore 18
    //   1421: lconst_1
    //   1422: lload 18
    //   1424: land
    //   1425: lconst_0
    //   1426: lcmp
    //   1427: ifeq +71 -> 1498
    //   1430: aload 4
    //   1432: aload 6
    //   1434: getfield 2353	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1437: putfield 2354	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1440: aload 4
    //   1442: getfield 2354	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1445: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1448: ifeq +10 -> 1458
    //   1451: aload 4
    //   1453: aload 9
    //   1455: putfield 2354	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1458: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1461: ifeq +37 -> 1498
    //   1464: ldc_w 2003
    //   1467: iconst_2
    //   1468: new 270	java/lang/StringBuilder
    //   1471: dup
    //   1472: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   1475: ldc_w 2356
    //   1478: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: aload 6
    //   1483: getfield 2353	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1486: invokestatic 2358	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1489: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1495: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1498: ldc2_w 2359
    //   1501: lload 18
    //   1503: land
    //   1504: lconst_0
    //   1505: lcmp
    //   1506: ifeq +13 -> 1519
    //   1509: aload 4
    //   1511: aload 6
    //   1513: getfield 2363	SummaryCard/RespSummaryCard:uAccelerateMultiple	J
    //   1516: putfield 2364	com/tencent/mobileqq/data/Card:uAccelerateMultiple	J
    //   1519: ldc2_w 2295
    //   1522: lload 18
    //   1524: land
    //   1525: lconst_0
    //   1526: lcmp
    //   1527: ifeq +23 -> 1550
    //   1530: aload 4
    //   1532: aload 6
    //   1534: getfield 2365	SummaryCard/RespSummaryCard:vRichSign	[B
    //   1537: putfield 2366	com/tencent/mobileqq/data/Card:vRichSign	[B
    //   1540: aload 4
    //   1542: aload 6
    //   1544: getfield 2369	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   1547: putfield 2372	com/tencent/mobileqq/data/Card:lSignModifyTime	J
    //   1550: aload 6
    //   1552: getfield 2375	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1555: ifnull +30 -> 1585
    //   1558: aload 4
    //   1560: aload_0
    //   1561: aload 6
    //   1563: getfield 2375	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1566: ldc_w 2377
    //   1569: new 2379	GameCenter/RespLastGameInfo
    //   1572: dup
    //   1573: invokespecial 2380	GameCenter/RespLastGameInfo:<init>	()V
    //   1576: invokevirtual 1651	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1579: checkcast 2379	GameCenter/RespLastGameInfo
    //   1582: invokevirtual 2384	com/tencent/mobileqq/data/Card:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1585: ldc2_w 2385
    //   1588: lload 18
    //   1590: land
    //   1591: lconst_0
    //   1592: lcmp
    //   1593: ifeq +54 -> 1647
    //   1596: new 694	java/util/HashMap
    //   1599: dup
    //   1600: invokespecial 695	java/util/HashMap:<init>	()V
    //   1603: astore_2
    //   1604: aload 6
    //   1606: getfield 2389	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   1609: ifnull +739 -> 2348
    //   1612: aload_0
    //   1613: aload 6
    //   1615: getfield 2389	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   1618: ldc_w 1645
    //   1621: new 1647	SummaryCardTaf/SSummaryCardRsp
    //   1624: dup
    //   1625: invokespecial 1648	SummaryCardTaf/SSummaryCardRsp:<init>	()V
    //   1628: invokevirtual 1651	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1631: checkcast 1647	SummaryCardTaf/SSummaryCardRsp
    //   1634: astore_2
    //   1635: aload 4
    //   1637: aload_0
    //   1638: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1641: aload 9
    //   1643: aload_2
    //   1644: invokevirtual 2393	com/tencent/mobileqq/data/Card:updateCardTemplate	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;LSummaryCardTaf/SSummaryCardRsp;)V
    //   1647: ldc2_w 2394
    //   1650: lload 18
    //   1652: land
    //   1653: lconst_0
    //   1654: lcmp
    //   1655: ifeq +50 -> 1705
    //   1658: aload 4
    //   1660: aload 6
    //   1662: getfield 2398	SummaryCard/RespSummaryCard:lUserFlag	J
    //   1665: putfield 2399	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   1668: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1671: ifeq +34 -> 1705
    //   1674: ldc_w 2003
    //   1677: iconst_2
    //   1678: new 270	java/lang/StringBuilder
    //   1681: dup
    //   1682: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   1685: ldc_w 2401
    //   1688: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: aload 4
    //   1693: getfield 2399	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   1696: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1699: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1702: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1705: ldc2_w 2311
    //   1708: lload 18
    //   1710: land
    //   1711: lconst_0
    //   1712: lcmp
    //   1713: ifeq +74 -> 1787
    //   1716: aload 4
    //   1718: aload 6
    //   1720: getfield 2404	SummaryCard/RespSummaryCard:uLoginDays	J
    //   1723: putfield 2407	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   1726: aload 4
    //   1728: aload 6
    //   1730: getfield 2410	SummaryCard/RespSummaryCard:strLoginDesc	Ljava/lang/String;
    //   1733: putfield 2413	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   1736: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1739: ifeq +48 -> 1787
    //   1742: ldc_w 2003
    //   1745: iconst_2
    //   1746: new 270	java/lang/StringBuilder
    //   1749: dup
    //   1750: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   1753: ldc_w 2415
    //   1756: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: aload 4
    //   1761: getfield 2407	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   1764: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1767: ldc_w 2417
    //   1770: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1773: aload 4
    //   1775: getfield 2413	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   1778: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1787: aload 6
    //   1789: getfield 2421	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   1792: ifnull +89 -> 1881
    //   1795: aload 4
    //   1797: aload 6
    //   1799: getfield 2421	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   1802: getfield 2426	SummaryCard/TNowBroadcastInfo:iFlag	I
    //   1805: putfield 2429	com/tencent/mobileqq/data/Card:mNowShowFlag	I
    //   1808: aload 4
    //   1810: aload 6
    //   1812: getfield 2421	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   1815: getfield 2432	SummaryCard/TNowBroadcastInfo:strIconURL	Ljava/lang/String;
    //   1818: putfield 2435	com/tencent/mobileqq/data/Card:mNowShowIconUrl	Ljava/lang/String;
    //   1821: aload 4
    //   1823: aload 6
    //   1825: getfield 2421	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   1828: getfield 2438	SummaryCard/TNowBroadcastInfo:strHrefURL	Ljava/lang/String;
    //   1831: putfield 2441	com/tencent/mobileqq/data/Card:mNowShowJumpUrl	Ljava/lang/String;
    //   1834: aload 4
    //   1836: getfield 2429	com/tencent/mobileqq/data/Card:mNowShowFlag	I
    //   1839: iconst_1
    //   1840: if_icmpne +41 -> 1881
    //   1843: aload_0
    //   1844: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1847: ldc_w 2443
    //   1850: ldc_w 2445
    //   1853: ldc_w 410
    //   1856: ldc_w 2447
    //   1859: ldc_w 2449
    //   1862: iconst_0
    //   1863: iconst_0
    //   1864: aload 4
    //   1866: getfield 750	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1869: ldc_w 410
    //   1872: ldc_w 410
    //   1875: ldc_w 410
    //   1878: invokestatic 2454	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1881: aload 6
    //   1883: getfield 2458	SummaryCard/RespSummaryCard:stCoverInfo	LSummaryCard/TCoverInfo;
    //   1886: ifnull +16 -> 1902
    //   1889: aload 4
    //   1891: aload 6
    //   1893: getfield 2458	SummaryCard/RespSummaryCard:stCoverInfo	LSummaryCard/TCoverInfo;
    //   1896: getfield 2463	SummaryCard/TCoverInfo:vTagInfo	[B
    //   1899: putfield 2466	com/tencent/mobileqq/data/Card:vCoverInfo	[B
    //   1902: aload 6
    //   1904: getfield 2469	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   1907: ifnull +172 -> 2079
    //   1910: aload 6
    //   1912: getfield 2469	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   1915: invokevirtual 2475	QQService/VipBaseInfo:getMOpenInfo	()Ljava/util/Map;
    //   1918: astore_2
    //   1919: aload_2
    //   1920: ifnull +159 -> 2079
    //   1923: aload_2
    //   1924: bipush 101
    //   1926: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1929: invokeinterface 2480 2 0
    //   1934: checkcast 2482	QQService/VipOpenInfo
    //   1937: astore_3
    //   1938: aload_3
    //   1939: getfield 2485	QQService/VipOpenInfo:bOpen	Z
    //   1942: ifeq +24 -> 1966
    //   1945: aload 4
    //   1947: iconst_1
    //   1948: putfield 2488	com/tencent/mobileqq/data/Card:isRedDiamond	Z
    //   1951: aload_3
    //   1952: getfield 2491	QQService/VipOpenInfo:iVipFlag	I
    //   1955: iconst_1
    //   1956: iand
    //   1957: ifle +9 -> 1966
    //   1960: aload 4
    //   1962: iconst_1
    //   1963: putfield 2494	com/tencent/mobileqq/data/Card:isSuperRedDiamond	Z
    //   1966: aload 4
    //   1968: aload_3
    //   1969: getfield 2497	QQService/VipOpenInfo:iVipLevel	I
    //   1972: putfield 2500	com/tencent/mobileqq/data/Card:redLevel	I
    //   1975: aload_2
    //   1976: bipush 102
    //   1978: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1981: invokeinterface 2480 2 0
    //   1986: checkcast 2482	QQService/VipOpenInfo
    //   1989: astore_3
    //   1990: aload_3
    //   1991: getfield 2485	QQService/VipOpenInfo:bOpen	Z
    //   1994: ifeq +24 -> 2018
    //   1997: aload 4
    //   1999: iconst_1
    //   2000: putfield 2503	com/tencent/mobileqq/data/Card:isYellowDiamond	Z
    //   2003: aload_3
    //   2004: getfield 2491	QQService/VipOpenInfo:iVipFlag	I
    //   2007: iconst_1
    //   2008: iand
    //   2009: ifle +9 -> 2018
    //   2012: aload 4
    //   2014: iconst_1
    //   2015: putfield 2506	com/tencent/mobileqq/data/Card:isSuperYellowDiamond	Z
    //   2018: aload 4
    //   2020: aload_3
    //   2021: getfield 2497	QQService/VipOpenInfo:iVipLevel	I
    //   2024: putfield 2509	com/tencent/mobileqq/data/Card:yellowLevel	I
    //   2027: aload_2
    //   2028: bipush 103
    //   2030: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2033: invokeinterface 2480 2 0
    //   2038: checkcast 2482	QQService/VipOpenInfo
    //   2041: astore_2
    //   2042: aload_2
    //   2043: getfield 2485	QQService/VipOpenInfo:bOpen	Z
    //   2046: ifeq +24 -> 2070
    //   2049: aload 4
    //   2051: iconst_1
    //   2052: putfield 2512	com/tencent/mobileqq/data/Card:isGreenDiamond	Z
    //   2055: aload_2
    //   2056: getfield 2491	QQService/VipOpenInfo:iVipFlag	I
    //   2059: iconst_1
    //   2060: iand
    //   2061: ifle +9 -> 2070
    //   2064: aload 4
    //   2066: iconst_1
    //   2067: putfield 2515	com/tencent/mobileqq/data/Card:isSuperGreenDiamond	Z
    //   2070: aload 4
    //   2072: aload_2
    //   2073: getfield 2497	QQService/VipOpenInfo:iVipLevel	I
    //   2076: putfield 2518	com/tencent/mobileqq/data/Card:greenLevel	I
    //   2079: aload 6
    //   2081: getfield 2522	SummaryCard/RespSummaryCard:stPrivInfo	LQQService/PrivilegeBaseInfo;
    //   2084: ifnull +49 -> 2133
    //   2087: aload 6
    //   2089: getfield 2522	SummaryCard/RespSummaryCard:stPrivInfo	LQQService/PrivilegeBaseInfo;
    //   2092: astore_2
    //   2093: aload_2
    //   2094: ifnull +39 -> 2133
    //   2097: aload 4
    //   2099: aload_2
    //   2100: getfield 2527	QQService/PrivilegeBaseInfo:strMsg	Ljava/lang/String;
    //   2103: putfield 2530	com/tencent/mobileqq/data/Card:privilegePromptStr	Ljava/lang/String;
    //   2106: aload 4
    //   2108: aload_2
    //   2109: getfield 2533	QQService/PrivilegeBaseInfo:strJumpUrl	Ljava/lang/String;
    //   2112: putfield 2536	com/tencent/mobileqq/data/Card:privilegeJumpUrl	Ljava/lang/String;
    //   2115: aload 4
    //   2117: aload_2
    //   2118: getfield 2539	QQService/PrivilegeBaseInfo:vOpenPriv	Ljava/util/ArrayList;
    //   2121: invokevirtual 2542	com/tencent/mobileqq/data/Card:savePrivilegeOpenedInfo	(Ljava/util/List;)V
    //   2124: aload 4
    //   2126: aload_2
    //   2127: getfield 2545	QQService/PrivilegeBaseInfo:vClosePriv	Ljava/util/ArrayList;
    //   2130: invokevirtual 2548	com/tencent/mobileqq/data/Card:savePrivilegeClosedInfo	(Ljava/util/List;)V
    //   2133: new 303	java/util/ArrayList
    //   2136: dup
    //   2137: invokespecial 304	java/util/ArrayList:<init>	()V
    //   2140: astore_2
    //   2141: aload 6
    //   2143: getfield 2551	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2146: ifnull +553 -> 2699
    //   2149: aload 6
    //   2151: getfield 2551	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2154: invokevirtual 807	java/util/ArrayList:size	()I
    //   2157: ifle +542 -> 2699
    //   2160: iconst_0
    //   2161: istore 11
    //   2163: iload 11
    //   2165: aload 6
    //   2167: getfield 2551	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2170: invokevirtual 807	java/util/ArrayList:size	()I
    //   2173: if_icmpge +526 -> 2699
    //   2176: aload 6
    //   2178: getfield 2551	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2181: iload 11
    //   2183: invokevirtual 808	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2186: checkcast 954	[B
    //   2189: astore 10
    //   2191: aload 10
    //   2193: ifnonnull +195 -> 2388
    //   2196: iconst_0
    //   2197: istore 12
    //   2199: iload 12
    //   2201: bipush 10
    //   2203: if_icmpgt +193 -> 2396
    //   2206: iload 11
    //   2208: iconst_1
    //   2209: iadd
    //   2210: istore 11
    //   2212: goto -49 -> 2163
    //   2215: aload 4
    //   2217: iconst_0
    //   2218: putfield 2226	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   2221: aload 4
    //   2223: aconst_null
    //   2224: putfield 2230	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   2227: aload 4
    //   2229: aconst_null
    //   2230: putfield 2239	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   2233: goto -1401 -> 832
    //   2236: invokestatic 743	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2239: ifeq -1329 -> 910
    //   2242: ldc_w 2241
    //   2245: iconst_4
    //   2246: ldc_w 2553
    //   2249: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2252: goto -1342 -> 910
    //   2255: aload 4
    //   2257: iconst_0
    //   2258: putfield 563	com/tencent/mobileqq/data/Card:bVoted	B
    //   2261: goto -1244 -> 1017
    //   2264: aload_2
    //   2265: invokevirtual 2292	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2268: sipush 1001
    //   2271: if_icmpeq +13 -> 2284
    //   2274: aload_2
    //   2275: invokevirtual 2292	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2278: sipush 1002
    //   2281: if_icmpne -1060 -> 1221
    //   2284: aload 10
    //   2286: aload_2
    //   2287: invokevirtual 1053	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   2290: pop
    //   2291: goto -1070 -> 1221
    //   2294: aload 4
    //   2296: aload 6
    //   2298: getfield 2191	SummaryCard/RespSummaryCard:iVoteCount	I
    //   2301: i2l
    //   2302: putfield 560	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2305: aload 4
    //   2307: aload 6
    //   2309: getfield 2271	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   2312: putfield 2274	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2315: goto -1089 -> 1226
    //   2318: iconst_1
    //   2319: istore 20
    //   2321: goto -1078 -> 1243
    //   2324: iconst_1
    //   2325: istore 20
    //   2327: goto -1062 -> 1265
    //   2330: iconst_1
    //   2331: istore 20
    //   2333: goto -1044 -> 1289
    //   2336: iconst_1
    //   2337: istore 20
    //   2339: goto -1030 -> 1309
    //   2342: iconst_1
    //   2343: istore 20
    //   2345: goto -1012 -> 1333
    //   2348: aload_2
    //   2349: ldc_w 717
    //   2352: ldc_w 2555
    //   2355: invokevirtual 722	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2358: pop
    //   2359: aload_0
    //   2360: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2363: invokevirtual 725	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2366: invokestatic 730	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2369: aload 9
    //   2371: ldc_w 2557
    //   2374: iconst_0
    //   2375: lconst_0
    //   2376: lconst_0
    //   2377: aconst_null
    //   2378: ldc_w 410
    //   2381: iconst_0
    //   2382: invokevirtual 737	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2385: goto -738 -> 1647
    //   2388: aload 10
    //   2390: arraylength
    //   2391: istore 12
    //   2393: goto -194 -> 2199
    //   2396: aload 10
    //   2398: iconst_1
    //   2399: invokestatic 2562	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2402: l2i
    //   2403: istore 14
    //   2405: aload 10
    //   2407: iconst_5
    //   2408: invokestatic 2562	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2411: l2i
    //   2412: istore 15
    //   2414: iload 14
    //   2416: ifle -210 -> 2206
    //   2419: iload 14
    //   2421: bipush 9
    //   2423: iadd
    //   2424: iload 12
    //   2426: if_icmpge -220 -> 2206
    //   2429: iload 14
    //   2431: newarray <illegal type>
    //   2433: astore_3
    //   2434: aload_3
    //   2435: iconst_0
    //   2436: aload 10
    //   2438: bipush 9
    //   2440: iload 14
    //   2442: invokestatic 2565	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   2445: new 2567	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2448: dup
    //   2449: invokespecial 2568	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2452: astore 10
    //   2454: aload 10
    //   2456: aload_3
    //   2457: invokevirtual 2569	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2460: pop
    //   2461: aload 10
    //   2463: getfield 2572	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2466: invokevirtual 2575	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2469: istore 12
    //   2471: iload 12
    //   2473: ifne +106 -> 2579
    //   2476: new 2577	com/tencent/mobileqq/profile/ProfileBusiEntry
    //   2479: dup
    //   2480: invokespecial 2578	com/tencent/mobileqq/profile/ProfileBusiEntry:<init>	()V
    //   2483: astore_3
    //   2484: aload_3
    //   2485: aload 10
    //   2487: getfield 2581	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2490: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2493: putfield 2583	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_Int	I
    //   2496: aload 10
    //   2498: getfield 2587	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2501: ifnull +167 -> 2668
    //   2504: aload_3
    //   2505: aload 10
    //   2507: getfield 2587	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2510: getfield 2592	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2513: invokevirtual 2596	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2516: putfield 2597	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2519: aload_3
    //   2520: aload 10
    //   2522: getfield 2587	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2525: getfield 2600	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2528: invokevirtual 2596	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2531: putfield 2601	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2534: aload_3
    //   2535: aload 10
    //   2537: getfield 2587	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2540: getfield 2604	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2543: invokevirtual 2596	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2546: putfield 2605	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2549: aload_3
    //   2550: aload 10
    //   2552: getfield 2587	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2555: getfield 2608	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2558: invokevirtual 2596	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2561: putfield 2610	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   2564: aload_3
    //   2565: invokevirtual 2612	com/tencent/mobileqq/profile/ProfileBusiEntry:a	()Z
    //   2568: ifne +11 -> 2579
    //   2571: aload_2
    //   2572: aload_3
    //   2573: invokeinterface 2613 2 0
    //   2578: pop
    //   2579: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2582: ifeq -376 -> 2206
    //   2585: ldc_w 2003
    //   2588: iconst_2
    //   2589: new 270	java/lang/StringBuilder
    //   2592: dup
    //   2593: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   2596: ldc_w 2615
    //   2599: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2602: aload 10
    //   2604: getfield 2581	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2607: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2610: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2613: ldc_w 2617
    //   2616: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2619: iload 12
    //   2621: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2624: ldc_w 2619
    //   2627: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2630: aload 10
    //   2632: getfield 2622	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2635: invokevirtual 883	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2638: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2641: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2644: goto -438 -> 2206
    //   2647: astore_3
    //   2648: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2651: ifeq -445 -> 2206
    //   2654: ldc_w 2003
    //   2657: iconst_2
    //   2658: aload_3
    //   2659: invokevirtual 2067	java/lang/Exception:toString	()Ljava/lang/String;
    //   2662: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2665: goto -459 -> 2206
    //   2668: aload_3
    //   2669: ldc_w 410
    //   2672: putfield 2597	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2675: aload_3
    //   2676: ldc_w 410
    //   2679: putfield 2601	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2682: aload_3
    //   2683: ldc_w 410
    //   2686: putfield 2605	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2689: aload_3
    //   2690: ldc_w 410
    //   2693: putfield 2610	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   2696: goto -132 -> 2564
    //   2699: aload 4
    //   2701: aload_2
    //   2702: invokevirtual 2625	com/tencent/mobileqq/data/Card:saveBusiEntrys	(Ljava/util/List;)V
    //   2705: aload 4
    //   2707: getfield 2399	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2710: ldc2_w 2394
    //   2713: land
    //   2714: lconst_0
    //   2715: lcmp
    //   2716: ifeq +1579 -> 4295
    //   2719: aload 4
    //   2721: iconst_1
    //   2722: putfield 2628	com/tencent/mobileqq/data/Card:allowClick	Z
    //   2725: aload 9
    //   2727: aload_0
    //   2728: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2731: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2734: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2737: ifne +23 -> 2760
    //   2740: aload 4
    //   2742: getfield 2399	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2745: ldc2_w 2311
    //   2748: land
    //   2749: lconst_0
    //   2750: lcmp
    //   2751: ifeq +1553 -> 4304
    //   2754: aload 4
    //   2756: iconst_1
    //   2757: putfield 2091	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   2760: aload 6
    //   2762: getfield 2632	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   2765: ifnull +230 -> 2995
    //   2768: aload 6
    //   2770: getfield 2632	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   2773: getfield 2637	SummaryCard/TVideoHeadInfo:iBasicFlag	I
    //   2776: iconst_1
    //   2777: if_icmpne +1536 -> 4313
    //   2780: iconst_1
    //   2781: istore 20
    //   2783: aload 4
    //   2785: iload 20
    //   2787: putfield 2640	com/tencent/mobileqq/data/Card:videoHeadFlag	Z
    //   2790: new 2642	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody
    //   2793: dup
    //   2794: invokespecial 2643	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:<init>	()V
    //   2797: astore_2
    //   2798: aload 4
    //   2800: getfield 2640	com/tencent/mobileqq/data/Card:videoHeadFlag	Z
    //   2803: ifeq +27 -> 2830
    //   2806: aload 6
    //   2808: getfield 2632	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   2811: getfield 2646	SummaryCard/TVideoHeadInfo:vMsg	[B
    //   2814: ifnull +16 -> 2830
    //   2817: aload_2
    //   2818: aload 6
    //   2820: getfield 2632	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   2823: getfield 2646	SummaryCard/TVideoHeadInfo:vMsg	[B
    //   2826: invokevirtual 2647	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2829: pop
    //   2830: aload_2
    //   2831: getfield 2651	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:rpt_msg_uin_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2834: invokevirtual 2654	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2837: ifeq +158 -> 2995
    //   2840: aload_2
    //   2841: getfield 2651	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:rpt_msg_uin_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2844: invokevirtual 2657	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2847: astore_2
    //   2848: aload_2
    //   2849: ifnull +146 -> 2995
    //   2852: aload_2
    //   2853: invokeinterface 456 1 0
    //   2858: ifle +137 -> 2995
    //   2861: aload_2
    //   2862: iconst_0
    //   2863: invokeinterface 460 2 0
    //   2868: checkcast 2659	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo
    //   2871: astore_2
    //   2872: aload_2
    //   2873: getfield 2662	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo:rpt_msg_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2876: invokevirtual 2654	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2879: ifeq +116 -> 2995
    //   2882: aload_2
    //   2883: getfield 2662	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo:rpt_msg_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2886: invokevirtual 2657	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2889: astore_2
    //   2890: aload_2
    //   2891: ifnull +104 -> 2995
    //   2894: aload_2
    //   2895: invokeinterface 621 1 0
    //   2900: astore_2
    //   2901: aload_2
    //   2902: invokeinterface 626 1 0
    //   2907: ifeq +88 -> 2995
    //   2910: aload_2
    //   2911: invokeinterface 630 1 0
    //   2916: checkcast 2664	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo
    //   2919: astore_3
    //   2920: aload_3
    //   2921: getfield 2667	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2924: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2927: bipush 17
    //   2929: if_icmpne -28 -> 2901
    //   2932: aload_3
    //   2933: getfield 2670	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo:rpt_videoheadlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2936: invokevirtual 2657	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2939: astore_2
    //   2940: aload_2
    //   2941: ifnull +54 -> 2995
    //   2944: aload_2
    //   2945: invokeinterface 621 1 0
    //   2950: astore_2
    //   2951: aload_2
    //   2952: invokeinterface 626 1 0
    //   2957: ifeq +38 -> 2995
    //   2960: aload_2
    //   2961: invokeinterface 630 1 0
    //   2966: checkcast 2672	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo
    //   2969: astore_3
    //   2970: aload_3
    //   2971: getfield 2675	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo:uint32_video_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2974: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2977: sipush 640
    //   2980: if_icmpne -29 -> 2951
    //   2983: aload 4
    //   2985: aload_3
    //   2986: getfield 2678	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo:str_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2989: invokevirtual 2596	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2992: putfield 2681	com/tencent/mobileqq/data/Card:videoHeadUrl	Ljava/lang/String;
    //   2995: aload 6
    //   2997: getfield 2685	SummaryCard/RespSummaryCard:stOlympicInfo	LSummaryCard/OlympicInfo;
    //   3000: ifnull +1327 -> 4327
    //   3003: aload 6
    //   3005: getfield 2685	SummaryCard/RespSummaryCard:stOlympicInfo	LSummaryCard/OlympicInfo;
    //   3008: getfield 2690	SummaryCard/OlympicInfo:iTorch	I
    //   3011: ifle +1316 -> 4327
    //   3014: aload 4
    //   3016: iconst_1
    //   3017: putfield 2693	com/tencent/mobileqq/data/Card:olympicTorch	B
    //   3020: aload_0
    //   3021: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3024: sipush 166
    //   3027: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3030: checkcast 1455	com/tencent/mobileqq/olympic/OlympicManager
    //   3033: invokevirtual 2696	com/tencent/mobileqq/olympic/OlympicManager:a	()Lcom/tencent/mobileqq/olympic/OlympicTorchManager;
    //   3036: astore_2
    //   3037: aload 4
    //   3039: getfield 2693	com/tencent/mobileqq/data/Card:olympicTorch	B
    //   3042: iconst_1
    //   3043: if_icmpne +1293 -> 4336
    //   3046: iconst_1
    //   3047: istore 20
    //   3049: aload_2
    //   3050: aload 9
    //   3052: iload 20
    //   3054: invokestatic 1914	java/lang/System:currentTimeMillis	()J
    //   3057: invokevirtual 2701	com/tencent/mobileqq/olympic/OlympicTorchManager:a	(Ljava/lang/String;ZJ)V
    //   3060: aload 8
    //   3062: aload 4
    //   3064: invokevirtual 566	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   3067: pop
    //   3068: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3071: ifeq +94 -> 3165
    //   3074: new 270	java/lang/StringBuilder
    //   3077: dup
    //   3078: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   3081: astore_2
    //   3082: aload_2
    //   3083: ldc_w 2415
    //   3086: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3089: aload 4
    //   3091: getfield 2407	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   3094: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3097: ldc_w 2703
    //   3100: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: aload 4
    //   3105: getfield 2413	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   3108: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3111: ldc_w 2705
    //   3114: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3117: aload 4
    //   3119: getfield 2628	com/tencent/mobileqq/data/Card:allowClick	Z
    //   3122: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3125: ldc_w 2707
    //   3128: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3131: aload 4
    //   3133: getfield 2091	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   3136: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3139: ldc_w 2709
    //   3142: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3145: aload 4
    //   3147: getfield 2264	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   3150: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3153: pop
    //   3154: ldc_w 2003
    //   3157: iconst_2
    //   3158: aload_2
    //   3159: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3162: invokestatic 758	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3165: aload_0
    //   3166: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3169: bipush 34
    //   3171: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3174: checkcast 2711	com/tencent/mobileqq/app/CircleManager
    //   3177: aload 4
    //   3179: invokevirtual 2714	com/tencent/mobileqq/app/CircleManager:a	(Lcom/tencent/mobileqq/data/Card;)V
    //   3182: aload 8
    //   3184: aload 9
    //   3186: invokevirtual 2717	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   3189: astore_2
    //   3190: aload_2
    //   3191: ifnonnull +1495 -> 4686
    //   3194: new 2719	com/tencent/mobileqq/data/ExtensionInfo
    //   3197: dup
    //   3198: invokespecial 2720	com/tencent/mobileqq/data/ExtensionInfo:<init>	()V
    //   3201: astore_2
    //   3202: aload_2
    //   3203: aload 9
    //   3205: putfield 2721	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   3208: aload_2
    //   3209: aload 6
    //   3211: getfield 2724	SummaryCard/RespSummaryCard:ulFaceAddonId	J
    //   3214: putfield 2727	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   3217: aload_2
    //   3218: invokestatic 1914	java/lang/System:currentTimeMillis	()J
    //   3221: putfield 2729	com/tencent/mobileqq/data/ExtensionInfo:timestamp	J
    //   3224: aload_0
    //   3225: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3228: sipush 152
    //   3231: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3234: checkcast 1206	com/tencent/mobileqq/apollo/ApolloManager
    //   3237: astore_3
    //   3238: aload 6
    //   3240: getfield 2733	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   3243: ifnull +1138 -> 4381
    //   3246: aload_3
    //   3247: aload 9
    //   3249: invokevirtual 1209	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   3252: astore 10
    //   3254: aload 10
    //   3256: aload 6
    //   3258: getfield 2733	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   3261: getfield 2738	SummaryCard/QQApolloInfo:uVipFlag	J
    //   3264: l2i
    //   3265: putfield 1472	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipFlag	I
    //   3268: aload 10
    //   3270: aload 6
    //   3272: getfield 2733	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   3275: getfield 2741	SummaryCard/QQApolloInfo:uVipLevel	J
    //   3278: l2i
    //   3279: putfield 1477	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipLevel	I
    //   3282: aload 10
    //   3284: aload 6
    //   3286: getfield 2733	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   3289: getfield 2744	SummaryCard/QQApolloInfo:uUserFlag	J
    //   3292: l2i
    //   3293: putfield 1482	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   3296: aload 10
    //   3298: aload 6
    //   3300: getfield 2733	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   3303: getfield 2747	SummaryCard/QQApolloInfo:uTimestamp	J
    //   3306: putfield 1503	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   3309: aload_3
    //   3310: aload 10
    //   3312: invokevirtual 1516	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/data/ApolloBaseInfo;)V
    //   3315: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3318: ifeq +100 -> 3418
    //   3321: ldc 97
    //   3323: iconst_2
    //   3324: new 270	java/lang/StringBuilder
    //   3327: dup
    //   3328: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   3331: ldc_w 2749
    //   3334: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3337: aload 9
    //   3339: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3342: ldc_w 2751
    //   3345: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3348: aload 10
    //   3350: getfield 1472	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipFlag	I
    //   3353: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3356: ldc_w 2753
    //   3359: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3362: aload 10
    //   3364: getfield 1477	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipLevel	I
    //   3367: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3370: ldc_w 2755
    //   3373: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3376: aload 10
    //   3378: getfield 1482	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   3381: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3384: ldc_w 2757
    //   3387: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3390: aload 10
    //   3392: getfield 1503	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   3395: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3398: ldc_w 2759
    //   3401: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3404: aload 10
    //   3406: getfield 1522	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   3409: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3412: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3415: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3418: aload 10
    //   3420: getfield 1503	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   3423: aload 10
    //   3425: getfield 1522	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   3428: lcmp
    //   3429: ifeq +91 -> 3520
    //   3432: aload_0
    //   3433: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3436: bipush 71
    //   3438: invokevirtual 1071	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3441: checkcast 1492	com/tencent/mobileqq/vas/VasExtensionHandler
    //   3444: astore_3
    //   3445: aload_3
    //   3446: ifnull +74 -> 3520
    //   3449: new 303	java/util/ArrayList
    //   3452: dup
    //   3453: iconst_1
    //   3454: invokespecial 865	java/util/ArrayList:<init>	(I)V
    //   3457: astore 10
    //   3459: aload 10
    //   3461: aload 9
    //   3463: invokestatic 606	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   3466: invokestatic 938	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3469: invokevirtual 802	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3472: pop
    //   3473: aload_3
    //   3474: aload 10
    //   3476: ldc_w 2761
    //   3479: invokevirtual 1530	com/tencent/mobileqq/vas/VasExtensionHandler:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   3482: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3485: ifeq +35 -> 3520
    //   3488: ldc 97
    //   3490: iconst_2
    //   3491: new 270	java/lang/StringBuilder
    //   3494: dup
    //   3495: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   3498: ldc_w 2763
    //   3501: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3504: aload 9
    //   3506: iconst_0
    //   3507: iconst_4
    //   3508: invokevirtual 2767	java/lang/String:substring	(II)Ljava/lang/String;
    //   3511: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3514: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3517: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3520: aload 8
    //   3522: aload 9
    //   3524: invokevirtual 2770	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   3527: astore 10
    //   3529: aload 10
    //   3531: aload 4
    //   3533: getfield 1897	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   3536: putfield 2775	com/tencent/mobileqq/data/Friends:signature	Ljava/lang/String;
    //   3539: aload 10
    //   3541: aload 4
    //   3543: getfield 1065	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   3546: putfield 2778	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   3549: aload 10
    //   3551: aload 4
    //   3553: getfield 2156	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   3556: putfield 2781	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   3559: lconst_1
    //   3560: lload 18
    //   3562: land
    //   3563: lconst_0
    //   3564: lcmp
    //   3565: ifeq +834 -> 4399
    //   3568: aload 4
    //   3570: getfield 2354	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   3573: astore_3
    //   3574: aload 10
    //   3576: aload_3
    //   3577: putfield 2784	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   3580: aload 4
    //   3582: getfield 1079	com/tencent/mobileqq/data/Card:shGender	S
    //   3585: ifne +823 -> 4408
    //   3588: iconst_1
    //   3589: istore 5
    //   3591: aload 10
    //   3593: iload 5
    //   3595: putfield 2787	com/tencent/mobileqq/data/Friends:gender	B
    //   3598: aload 10
    //   3600: aload 4
    //   3602: getfield 1088	com/tencent/mobileqq/data/Card:age	B
    //   3605: putfield 2789	com/tencent/mobileqq/data/Friends:age	I
    //   3608: ldc2_w 2295
    //   3611: lload 18
    //   3613: land
    //   3614: lconst_0
    //   3615: lcmp
    //   3616: ifeq +47 -> 3663
    //   3619: aload_2
    //   3620: getfield 2792	com/tencent/mobileqq/data/ExtensionInfo:richTime	J
    //   3623: aload 6
    //   3625: getfield 2369	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   3628: lcmp
    //   3629: ifeq +34 -> 3663
    //   3632: aload_2
    //   3633: aload 6
    //   3635: getfield 2365	SummaryCard/RespSummaryCard:vRichSign	[B
    //   3638: aload 6
    //   3640: getfield 2369	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   3643: invokevirtual 2796	com/tencent/mobileqq/data/ExtensionInfo:setRichBuffer	([BJ)V
    //   3646: aload_2
    //   3647: aload_0
    //   3648: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3651: aload 9
    //   3653: aload_2
    //   3654: invokevirtual 2800	com/tencent/mobileqq/data/ExtensionInfo:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   3657: invokestatic 2805	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/richstatus/RichStatus;)Z
    //   3660: putfield 2808	com/tencent/mobileqq/data/ExtensionInfo:isAdded2C2C	Z
    //   3663: aload 8
    //   3665: aload_2
    //   3666: invokevirtual 2811	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   3669: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3672: ifeq +43 -> 3715
    //   3675: ldc 97
    //   3677: iconst_2
    //   3678: new 270	java/lang/StringBuilder
    //   3681: dup
    //   3682: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   3685: ldc_w 2813
    //   3688: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3691: aload 9
    //   3693: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: ldc_w 2815
    //   3699: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3702: aload_2
    //   3703: getfield 2727	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   3706: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3709: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3712: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3715: aload 6
    //   3717: getfield 2344	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   3720: ifnull +99 -> 3819
    //   3723: aload 10
    //   3725: aload 6
    //   3727: getfield 2344	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   3730: getstatic 2821	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   3733: invokevirtual 2824	QQService/EVIPSPEC:value	()I
    //   3736: aload 10
    //   3738: getfield 2827	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   3741: invokestatic 2832	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   3744: putfield 2827	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   3747: aload 10
    //   3749: aload 6
    //   3751: getfield 2344	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   3754: getstatic 2835	QQService/EVIPSPEC:E_SP_SUPERQQ	LQQService/EVIPSPEC;
    //   3757: invokevirtual 2824	QQService/EVIPSPEC:value	()I
    //   3760: aload 10
    //   3762: getfield 2838	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   3765: invokestatic 2832	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   3768: putfield 2838	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   3771: aload 10
    //   3773: aload 6
    //   3775: getfield 2344	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   3778: getstatic 2841	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   3781: invokevirtual 2824	QQService/EVIPSPEC:value	()I
    //   3784: aload 10
    //   3786: getfield 2844	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   3789: invokestatic 2832	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   3792: putfield 2844	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   3795: aload 10
    //   3797: aload 6
    //   3799: getfield 2344	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   3802: getstatic 2847	QQService/EVIPSPEC:E_SP_QQVIDEO_HOLLYWOOD	LQQService/EVIPSPEC;
    //   3805: invokevirtual 2824	QQService/EVIPSPEC:value	()I
    //   3808: aload 10
    //   3810: getfield 2850	com/tencent/mobileqq/data/Friends:hollywoodVipInfo	I
    //   3813: invokestatic 2832	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   3816: putfield 2850	com/tencent/mobileqq/data/Friends:hollywoodVipInfo	I
    //   3819: ldc2_w 2394
    //   3822: lload 18
    //   3824: land
    //   3825: lconst_0
    //   3826: lcmp
    //   3827: ifeq +28 -> 3855
    //   3830: aload 4
    //   3832: getfield 2399	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   3835: lconst_1
    //   3836: land
    //   3837: lconst_0
    //   3838: lcmp
    //   3839: ifeq +590 -> 4429
    //   3842: aload 10
    //   3844: aload 10
    //   3846: getfield 2853	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   3849: iconst_1
    //   3850: ior
    //   3851: i2b
    //   3852: putfield 2853	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   3855: aload 8
    //   3857: aload 10
    //   3859: invokevirtual 2856	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   3862: aload_0
    //   3863: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3866: bipush 10
    //   3868: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3871: checkcast 2858	com/tencent/mobileqq/model/PhoneContactManager
    //   3874: astore_2
    //   3875: aload_2
    //   3876: ifnull +23 -> 3899
    //   3879: aload_2
    //   3880: aload 10
    //   3882: getfield 2859	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   3885: invokeinterface 2862 2 0
    //   3890: ifnull +9 -> 3899
    //   3893: aload_2
    //   3894: invokeinterface 2864 1 0
    //   3899: aload_1
    //   3900: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   3903: ldc_w 2866
    //   3906: lconst_0
    //   3907: invokevirtual 906	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   3910: lstore 18
    //   3912: lload 18
    //   3914: lconst_0
    //   3915: lcmp
    //   3916: ifle +128 -> 4044
    //   3919: iload 13
    //   3921: iconst_2
    //   3922: if_icmpeq +16 -> 3938
    //   3925: iload 13
    //   3927: iconst_5
    //   3928: if_icmpeq +10 -> 3938
    //   3931: iload 13
    //   3933: bipush 7
    //   3935: if_icmpne +537 -> 4472
    //   3938: aload 7
    //   3940: lload 18
    //   3942: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3945: invokevirtual 2869	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   3948: astore_1
    //   3949: aload_1
    //   3950: ifnull +94 -> 4044
    //   3953: aload_1
    //   3954: getfield 2874	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   3957: ifnull +489 -> 4446
    //   3960: aload_1
    //   3961: getfield 2874	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   3964: aload 6
    //   3966: getfield 2162	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   3969: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3972: ifne +18 -> 3990
    //   3975: aload_1
    //   3976: aload 6
    //   3978: getfield 2162	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   3981: putfield 2874	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   3984: aload 7
    //   3986: aload_1
    //   3987: invokevirtual 2877	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   3990: aload_0
    //   3991: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3994: bipush 51
    //   3996: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3999: checkcast 2109	com/tencent/mobileqq/app/TroopManager
    //   4002: lload 18
    //   4004: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4007: aload 6
    //   4009: getfield 2880	SummaryCard/RespSummaryCard:lUIN	J
    //   4012: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4015: aload 6
    //   4017: getfield 2168	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   4020: bipush -100
    //   4022: aload 6
    //   4024: getfield 2123	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   4027: aconst_null
    //   4028: bipush -100
    //   4030: bipush -100
    //   4032: bipush -100
    //   4034: ldc2_w 2881
    //   4037: ldc2_w 2881
    //   4040: invokevirtual 2885	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   4043: pop
    //   4044: aload 6
    //   4046: getfield 2889	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   4049: ifnull +42 -> 4091
    //   4052: aload 4
    //   4054: aload 6
    //   4056: getfield 2889	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   4059: getfield 2894	SummaryCard/AddFrdSrcInfo:strSrcName	Ljava/lang/String;
    //   4062: putfield 2897	com/tencent/mobileqq/data/Card:addSrcName	Ljava/lang/String;
    //   4065: aload 4
    //   4067: aload 6
    //   4069: getfield 2889	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   4072: getfield 2900	SummaryCard/AddFrdSrcInfo:uSrcId	J
    //   4075: putfield 2903	com/tencent/mobileqq/data/Card:addSrcId	J
    //   4078: aload 4
    //   4080: aload 6
    //   4082: getfield 2889	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   4085: getfield 2906	SummaryCard/AddFrdSrcInfo:uSubSrcId	J
    //   4088: putfield 2909	com/tencent/mobileqq/data/Card:addSubSrcId	J
    //   4091: aload 6
    //   4093: getfield 2913	SummaryCard/RespSummaryCard:stBindPhoneInfo	LSummaryCard/BindPhoneInfo;
    //   4096: ifnull +16 -> 4112
    //   4099: aload 4
    //   4101: aload 6
    //   4103: getfield 2913	SummaryCard/RespSummaryCard:stBindPhoneInfo	LSummaryCard/BindPhoneInfo;
    //   4106: getfield 2918	SummaryCard/BindPhoneInfo:strName	Ljava/lang/String;
    //   4109: putfield 2921	com/tencent/mobileqq/data/Card:bindPhoneInfo	Ljava/lang/String;
    //   4112: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4115: ifeq +76 -> 4191
    //   4118: ldc_w 2923
    //   4121: iconst_2
    //   4122: new 270	java/lang/StringBuilder
    //   4125: dup
    //   4126: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   4129: ldc_w 2925
    //   4132: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4135: aload 4
    //   4137: getfield 2897	com/tencent/mobileqq/data/Card:addSrcName	Ljava/lang/String;
    //   4140: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4143: ldc_w 2927
    //   4146: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4149: aload 4
    //   4151: getfield 2903	com/tencent/mobileqq/data/Card:addSrcId	J
    //   4154: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4157: ldc_w 2929
    //   4160: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4163: aload 4
    //   4165: getfield 2909	com/tencent/mobileqq/data/Card:addSubSrcId	J
    //   4168: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4171: ldc_w 2931
    //   4174: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4177: aload 4
    //   4179: getfield 2921	com/tencent/mobileqq/data/Card:bindPhoneInfo	Ljava/lang/String;
    //   4182: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4185: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4188: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4191: aload 6
    //   4193: getfield 2934	SummaryCard/RespSummaryCard:vVisitingCardInfo	[B
    //   4196: ifnull +88 -> 4284
    //   4199: aload 4
    //   4201: aload 6
    //   4203: getfield 2934	SummaryCard/RespSummaryCard:vVisitingCardInfo	[B
    //   4206: putfield 2937	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   4209: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4212: ifeq +72 -> 4284
    //   4215: new 2939	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo
    //   4218: dup
    //   4219: invokespecial 2940	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:<init>	()V
    //   4222: astore_2
    //   4223: new 2942	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   4226: dup
    //   4227: invokespecial 2943	com/tencent/mobileqq/businessCard/data/BusinessCard:<init>	()V
    //   4230: astore_1
    //   4231: aload 4
    //   4233: getfield 2937	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   4236: ifnull +364 -> 4600
    //   4239: aload_2
    //   4240: aload 4
    //   4242: getfield 2937	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   4245: invokevirtual 2944	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4248: pop
    //   4249: aload_1
    //   4250: aload_2
    //   4251: invokestatic 2949	com/tencent/mobileqq/businessCard/BusinessCardServlet:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;Ltencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo;)V
    //   4254: ldc_w 2923
    //   4257: iconst_2
    //   4258: new 270	java/lang/StringBuilder
    //   4261: dup
    //   4262: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   4265: ldc_w 2951
    //   4268: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4271: aload_1
    //   4272: invokevirtual 2952	com/tencent/mobileqq/businessCard/data/BusinessCard:toString	()Ljava/lang/String;
    //   4275: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4278: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4281: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4284: aload_0
    //   4285: iconst_1
    //   4286: iconst_1
    //   4287: aload 4
    //   4289: invokevirtual 569	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   4292: goto -3949 -> 343
    //   4295: aload 4
    //   4297: iconst_0
    //   4298: putfield 2628	com/tencent/mobileqq/data/Card:allowClick	Z
    //   4301: goto -1576 -> 2725
    //   4304: aload 4
    //   4306: iconst_0
    //   4307: putfield 2091	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   4310: goto -1550 -> 2760
    //   4313: iconst_0
    //   4314: istore 20
    //   4316: goto -1533 -> 2783
    //   4319: astore_3
    //   4320: aload_3
    //   4321: invokevirtual 2953	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   4324: goto -1494 -> 2830
    //   4327: aload 4
    //   4329: iconst_0
    //   4330: putfield 2693	com/tencent/mobileqq/data/Card:olympicTorch	B
    //   4333: goto -1313 -> 3020
    //   4336: iconst_0
    //   4337: istore 20
    //   4339: goto -1290 -> 3049
    //   4342: astore_3
    //   4343: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4346: ifeq -826 -> 3520
    //   4349: ldc 97
    //   4351: iconst_2
    //   4352: new 270	java/lang/StringBuilder
    //   4355: dup
    //   4356: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   4359: ldc_w 2763
    //   4362: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4365: aload_3
    //   4366: invokevirtual 989	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4369: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4372: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4375: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4378: goto -858 -> 3520
    //   4381: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4384: ifeq -864 -> 3520
    //   4387: ldc 97
    //   4389: iconst_2
    //   4390: ldc_w 2955
    //   4393: invokestatic 1711	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4396: goto -876 -> 3520
    //   4399: aload 10
    //   4401: getfield 2784	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   4404: astore_3
    //   4405: goto -831 -> 3574
    //   4408: aload 4
    //   4410: getfield 1079	com/tencent/mobileqq/data/Card:shGender	S
    //   4413: iconst_1
    //   4414: if_icmpne +9 -> 4423
    //   4417: iconst_2
    //   4418: istore 5
    //   4420: goto -829 -> 3591
    //   4423: iconst_0
    //   4424: istore 5
    //   4426: goto -835 -> 3591
    //   4429: aload 10
    //   4431: aload 10
    //   4433: getfield 2853	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   4436: bipush -2
    //   4438: iand
    //   4439: i2b
    //   4440: putfield 2853	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   4443: goto -588 -> 3855
    //   4446: aload 6
    //   4448: getfield 2162	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   4451: ifnull -461 -> 3990
    //   4454: aload_1
    //   4455: aload 6
    //   4457: getfield 2162	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   4460: putfield 2874	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   4463: aload 7
    //   4465: aload_1
    //   4466: invokevirtual 2877	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   4469: goto -479 -> 3990
    //   4472: iload 13
    //   4474: iconst_4
    //   4475: if_icmpne -431 -> 4044
    //   4478: aload_0
    //   4479: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4482: bipush 52
    //   4484: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4487: checkcast 2957	com/tencent/mobileqq/app/DiscussionManager
    //   4490: astore_1
    //   4491: aload_1
    //   4492: lload 18
    //   4494: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4497: aload 9
    //   4499: invokevirtual 2960	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   4502: astore_2
    //   4503: aload_2
    //   4504: ifnull -460 -> 4044
    //   4507: aload_2
    //   4508: aload 6
    //   4510: getfield 2123	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   4513: putfield 2965	com/tencent/mobileqq/data/DiscussionMemberInfo:memberName	Ljava/lang/String;
    //   4516: aload 6
    //   4518: getfield 2183	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4521: ifnull +61 -> 4582
    //   4524: aload 6
    //   4526: getfield 2183	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4529: invokevirtual 2968	java/lang/String:length	()I
    //   4532: ifle +50 -> 4582
    //   4535: aload 6
    //   4537: getfield 2183	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4540: aload_2
    //   4541: getfield 2971	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   4544: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4547: ifne +35 -> 4582
    //   4550: aload_2
    //   4551: aload 6
    //   4553: getfield 2183	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4556: putfield 2971	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   4559: aload 6
    //   4561: getfield 2183	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4564: aload 6
    //   4566: getfield 2123	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   4569: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4572: ifeq +18 -> 4590
    //   4575: aload_2
    //   4576: ldc2_w 2972
    //   4579: putfield 2976	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   4582: aload_1
    //   4583: aload_2
    //   4584: invokevirtual 2979	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   4587: goto -543 -> 4044
    //   4590: aload_2
    //   4591: ldc2_w 2980
    //   4594: putfield 2976	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   4597: goto -15 -> 4582
    //   4600: ldc_w 2923
    //   4603: iconst_2
    //   4604: ldc_w 2983
    //   4607: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4610: goto -326 -> 4284
    //   4613: aload_1
    //   4614: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4617: ldc_w 2143
    //   4620: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   4623: iconst_1
    //   4624: if_icmpne +24 -> 4648
    //   4627: aload_0
    //   4628: bipush 51
    //   4630: iconst_0
    //   4631: aconst_null
    //   4632: aload_1
    //   4633: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4636: ldc_w 2985
    //   4639: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   4642: invokevirtual 2988	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;Z)V
    //   4645: goto -4302 -> 343
    //   4648: lload 18
    //   4650: lconst_0
    //   4651: lcmp
    //   4652: ifgt +16 -> 4668
    //   4655: aload 4
    //   4657: astore_1
    //   4658: aload_0
    //   4659: iconst_1
    //   4660: iconst_0
    //   4661: aload_1
    //   4662: invokevirtual 569	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   4665: goto -4322 -> 343
    //   4668: lload 18
    //   4670: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4673: astore_1
    //   4674: goto -16 -> 4658
    //   4677: astore_2
    //   4678: goto -424 -> 4254
    //   4681: astore 4
    //   4683: goto -4264 -> 419
    //   4686: goto -1478 -> 3208
    //   4689: aconst_null
    //   4690: astore_2
    //   4691: goto -4536 -> 155
    //   4694: lconst_0
    //   4695: lstore 16
    //   4697: goto -4650 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4700	0	this	CardHandler
    //   0	4700	1	paramToServiceMsg	ToServiceMsg
    //   0	4700	2	paramFromServiceMsg	FromServiceMsg
    //   0	4700	3	paramObject	Object
    //   0	4700	4	paramBundle	Bundle
    //   3589	836	5	b1	byte
    //   127	195	6	localObject1	Object
    //   410	4155	6	localException	Exception
    //   222	4242	7	localTroopManager	TroopManager
    //   208	3648	8	localFriendsManager	FriendsManager
    //   462	4036	9	str	String
    //   1146	3286	10	localObject2	Object
    //   65	2146	11	i1	int
    //   398	2222	12	i2	int
    //   189	4287	13	i3	int
    //   2403	38	14	i4	int
    //   2412	1	15	i5	int
    //   45	4651	16	l1	long
    //   165	4504	18	l2	long
    //   1241	3097	20	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   72	94	410	java/lang/Exception
    //   2454	2471	2647	java/lang/Exception
    //   2476	2564	2647	java/lang/Exception
    //   2564	2579	2647	java/lang/Exception
    //   2579	2644	2647	java/lang/Exception
    //   2668	2696	2647	java/lang/Exception
    //   2817	2830	4319	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3449	3520	4342	java/lang/Exception
    //   4239	4254	4677	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   98	105	4681	java/lang/Exception
    //   108	129	4681	java/lang/Exception
    //   138	155	4681	java/lang/Exception
    //   394	400	4681	java/lang/Exception
  }
  
  /* Error */
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 953	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +480 -> 484
    //   7: aload_3
    //   8: ifnull +476 -> 484
    //   11: iconst_1
    //   12: istore 7
    //   14: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 745
    //   23: iconst_2
    //   24: new 270	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 2990
    //   34: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 7
    //   39: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: bipush 50
    //   54: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   57: checkcast 552	com/tencent/mobileqq/app/FriendsManager
    //   60: astore 4
    //   62: aload 4
    //   64: aload_0
    //   65: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   71: invokevirtual 819	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   74: astore_2
    //   75: iload 7
    //   77: istore 10
    //   79: iload 7
    //   81: ifeq +758 -> 839
    //   84: iload 7
    //   86: istore 8
    //   88: iload 7
    //   90: istore 9
    //   92: new 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: aload_3
    //   100: checkcast 954	[B
    //   103: checkcast 954	[B
    //   106: invokevirtual 958	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   109: checkcast 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +376 -> 490
    //   117: iload 7
    //   119: istore 8
    //   121: iload 7
    //   123: istore 9
    //   125: aload_1
    //   126: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: ifne +358 -> 490
    //   135: iconst_1
    //   136: istore 7
    //   138: iload 7
    //   140: istore 8
    //   142: iload 7
    //   144: istore 9
    //   146: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +39 -> 188
    //   152: iload 7
    //   154: istore 8
    //   156: iload 7
    //   158: istore 9
    //   160: ldc_w 745
    //   163: iconst_2
    //   164: new 270	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 2992
    //   174: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload 7
    //   179: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iload 7
    //   190: istore 10
    //   192: iload 7
    //   194: ifeq +645 -> 839
    //   197: iload 7
    //   199: istore 8
    //   201: iload 7
    //   203: istore 9
    //   205: iload 7
    //   207: istore 10
    //   209: aload_1
    //   210: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 1795	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   216: ifeq +623 -> 839
    //   219: iload 7
    //   221: istore 8
    //   223: iload 7
    //   225: istore 9
    //   227: iload 7
    //   229: istore 10
    //   231: aload_1
    //   232: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: ifnull +601 -> 839
    //   241: iload 7
    //   243: istore 8
    //   245: iload 7
    //   247: istore 9
    //   249: aload_1
    //   250: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   253: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 964	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   259: invokestatic 968	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   262: astore_1
    //   263: iload 7
    //   265: istore 8
    //   267: iload 7
    //   269: istore 9
    //   271: aload_1
    //   272: invokevirtual 970	java/nio/ByteBuffer:getInt	()I
    //   275: pop
    //   276: iload 7
    //   278: istore 8
    //   280: iload 7
    //   282: istore 9
    //   284: aload_1
    //   285: invokevirtual 973	java/nio/ByteBuffer:get	()B
    //   288: pop
    //   289: iload 7
    //   291: istore 8
    //   293: iload 7
    //   295: istore 9
    //   297: iload 7
    //   299: istore 10
    //   301: aload_1
    //   302: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   305: invokestatic 1799	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   308: invokevirtual 636	java/lang/Short:shortValue	()S
    //   311: iconst_1
    //   312: if_icmpne +527 -> 839
    //   315: iload 7
    //   317: istore 8
    //   319: iload 7
    //   321: istore 9
    //   323: aload_1
    //   324: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   327: istore 5
    //   329: iload 7
    //   331: istore 8
    //   333: iload 7
    //   335: istore 9
    //   337: aload_0
    //   338: getfield 312	com/tencent/mobileqq/app/CardHandler:jdField_c_of_type_Short	S
    //   341: istore 6
    //   343: iload 5
    //   345: iload 6
    //   347: if_icmpeq +149 -> 496
    //   350: iconst_0
    //   351: istore 7
    //   353: iload 7
    //   355: istore 8
    //   357: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +48 -> 408
    //   363: ldc_w 745
    //   366: iconst_2
    //   367: new 270	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 2992
    //   377: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: iload 7
    //   382: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   385: ldc_w 1801
    //   388: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_2
    //   392: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   395: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   398: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: iload 7
    //   406: istore 8
    //   408: aload_2
    //   409: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   412: ifeq +396 -> 808
    //   415: aload 4
    //   417: iconst_1
    //   418: putfield 2997	com/tencent/mobileqq/app/FriendsManager:h	I
    //   421: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +44 -> 468
    //   427: ldc_w 2999
    //   430: iconst_2
    //   431: new 270	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 2992
    //   441: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 8
    //   446: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   449: ldc_w 3001
    //   452: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_2
    //   456: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   459: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   462: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload_0
    //   469: bipush 72
    //   471: iload 8
    //   473: aload_2
    //   474: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   477: invokestatic 984	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   480: invokevirtual 569	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   483: return
    //   484: iconst_0
    //   485: istore 7
    //   487: goto -473 -> 14
    //   490: iconst_0
    //   491: istore 7
    //   493: goto -355 -> 138
    //   496: iload 7
    //   498: istore 8
    //   500: iload 7
    //   502: istore 9
    //   504: aload_1
    //   505: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   508: istore 5
    //   510: iload 5
    //   512: iconst_2
    //   513: if_icmpne +159 -> 672
    //   516: iload 7
    //   518: istore 8
    //   520: iload 7
    //   522: istore 9
    //   524: iload 5
    //   526: newarray <illegal type>
    //   528: astore_3
    //   529: iload 7
    //   531: istore 8
    //   533: iload 7
    //   535: istore 9
    //   537: aload_1
    //   538: aload_3
    //   539: invokevirtual 1226	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   542: pop
    //   543: iload 7
    //   545: istore 8
    //   547: iload 7
    //   549: istore 9
    //   551: aload_3
    //   552: iconst_0
    //   553: invokestatic 1328	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   556: ifne +97 -> 653
    //   559: iconst_0
    //   560: istore 10
    //   562: iload 7
    //   564: istore 8
    //   566: iload 7
    //   568: istore 9
    //   570: aload_2
    //   571: iload 10
    //   573: putfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   576: iload 7
    //   578: istore 8
    //   580: iload 7
    //   582: istore 9
    //   584: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +41 -> 628
    //   590: iload 7
    //   592: istore 8
    //   594: iload 7
    //   596: istore 9
    //   598: ldc_w 2999
    //   601: iconst_2
    //   602: new 270	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 3003
    //   612: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_2
    //   616: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   619: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   622: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: iload 7
    //   630: istore 8
    //   632: iload 7
    //   634: istore 9
    //   636: aload_1
    //   637: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   640: istore 5
    //   642: iload 5
    //   644: ifeq +15 -> 659
    //   647: iconst_0
    //   648: istore 7
    //   650: goto -297 -> 353
    //   653: iconst_1
    //   654: istore 10
    //   656: goto -94 -> 562
    //   659: aload 4
    //   661: aload_2
    //   662: invokevirtual 566	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   665: pop
    //   666: iconst_1
    //   667: istore 7
    //   669: goto -316 -> 353
    //   672: iconst_0
    //   673: istore 7
    //   675: goto -322 -> 353
    //   678: astore_1
    //   679: iload 8
    //   681: istore 7
    //   683: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq +14 -> 700
    //   689: ldc_w 745
    //   692: iconst_2
    //   693: ldc_w 3005
    //   696: aload_1
    //   697: invokestatic 1134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   700: iload 7
    //   702: istore 8
    //   704: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq -299 -> 408
    //   710: ldc_w 745
    //   713: iconst_2
    //   714: new 270	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 2992
    //   724: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: iload 7
    //   729: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   732: ldc_w 1801
    //   735: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: aload_2
    //   739: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   742: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   745: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: iload 7
    //   753: istore 8
    //   755: goto -347 -> 408
    //   758: astore_1
    //   759: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   762: ifeq +44 -> 806
    //   765: ldc_w 745
    //   768: iconst_2
    //   769: new 270	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   776: ldc_w 2992
    //   779: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: iload 9
    //   784: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   787: ldc_w 1801
    //   790: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload_2
    //   794: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   797: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   800: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: aload_1
    //   807: athrow
    //   808: aload 4
    //   810: iconst_0
    //   811: putfield 2997	com/tencent/mobileqq/app/FriendsManager:h	I
    //   814: goto -393 -> 421
    //   817: astore_1
    //   818: iconst_1
    //   819: istore 9
    //   821: goto -62 -> 759
    //   824: astore_1
    //   825: iload 7
    //   827: istore 9
    //   829: goto -70 -> 759
    //   832: astore_1
    //   833: iconst_1
    //   834: istore 7
    //   836: goto -153 -> 683
    //   839: iload 10
    //   841: istore 7
    //   843: goto -490 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	846	0	this	CardHandler
    //   0	846	1	paramToServiceMsg	ToServiceMsg
    //   0	846	2	paramFromServiceMsg	FromServiceMsg
    //   0	846	3	paramObject	Object
    //   60	749	4	localFriendsManager	FriendsManager
    //   327	316	5	i1	int
    //   341	7	6	i2	int
    //   12	830	7	bool1	boolean
    //   86	668	8	bool2	boolean
    //   90	738	9	bool3	boolean
    //   77	763	10	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   92	113	678	java/lang/Exception
    //   125	135	678	java/lang/Exception
    //   146	152	678	java/lang/Exception
    //   160	188	678	java/lang/Exception
    //   209	219	678	java/lang/Exception
    //   231	241	678	java/lang/Exception
    //   249	263	678	java/lang/Exception
    //   271	276	678	java/lang/Exception
    //   284	289	678	java/lang/Exception
    //   301	315	678	java/lang/Exception
    //   323	329	678	java/lang/Exception
    //   337	343	678	java/lang/Exception
    //   504	510	678	java/lang/Exception
    //   524	529	678	java/lang/Exception
    //   537	543	678	java/lang/Exception
    //   551	559	678	java/lang/Exception
    //   570	576	678	java/lang/Exception
    //   584	590	678	java/lang/Exception
    //   598	628	678	java/lang/Exception
    //   636	642	678	java/lang/Exception
    //   92	113	758	finally
    //   125	135	758	finally
    //   146	152	758	finally
    //   160	188	758	finally
    //   209	219	758	finally
    //   231	241	758	finally
    //   249	263	758	finally
    //   271	276	758	finally
    //   284	289	758	finally
    //   301	315	758	finally
    //   323	329	758	finally
    //   337	343	758	finally
    //   504	510	758	finally
    //   524	529	758	finally
    //   537	543	758	finally
    //   551	559	758	finally
    //   570	576	758	finally
    //   584	590	758	finally
    //   598	628	758	finally
    //   636	642	758	finally
    //   659	666	817	finally
    //   683	700	824	finally
    //   659	666	832	java/lang/Exception
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("filekey");
    paramBundle.putByteArray("fileKey", arrayOfByte);
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      RespDelFace localRespDelFace = (RespDelFace)paramObject;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg.getUin());
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      paramObject = localFriendsManager.a(paramToServiceMsg.getUin());
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      if (paramObject == null)
      {
        paramFromServiceMsg = new Card();
        paramFromServiceMsg.uin = paramToServiceMsg.getUin();
      }
      paramBundle.putInt("result", localRespDelFace.stHeader.iReplyCode);
      switch (localRespDelFace.stHeader.iReplyCode)
      {
      }
      for (;;)
      {
        localFriendsManager.a(paramFromServiceMsg);
        return;
        if (localRespDelFace.uFaceTimeStamp > paramFromServiceMsg.uFaceTimeStamp) {
          paramFromServiceMsg.uFaceTimeStamp = localRespDelFace.uFaceTimeStamp;
        }
        paramFromServiceMsg.removePortrait(arrayOfByte);
        a(12, true, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        a(12, false, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        a(12, false, new Object[] { paramBundle, paramFromServiceMsg });
      }
    }
    paramBundle.putInt("result", -1);
    a(12, false, new Object[] { paramBundle, ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin()) });
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label607;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1);
        }
        bool4 = bool1;
        if (!bool1) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        i1 = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (i1 >= 0) {
          continue;
        }
        l1 = i1 + 4294967296L;
        bool2 = bool1;
        bool3 = bool1;
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        bool2 = bool1;
        bool3 = bool1;
        ((Card)paramObject).allowPeopleSee = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.a((Card)paramObject);
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          int i1;
          long l1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      a(45, bool3, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l1 = i1;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label607:
      bool1 = bool4;
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespGetFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        long l1 = paramToServiceMsg.extraData.getLong("lNextMid");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("lUin");
        paramBundle.putString("lUin", paramToServiceMsg);
        paramBundle.putLong("nextMid", l1);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramObject = paramFromServiceMsg.vFaceInfo;
        paramFromServiceMsg = new ArrayList();
        int i1 = 0;
        while (i1 < ((ArrayList)paramObject).size())
        {
          paramFromServiceMsg.add(HexUtil.a(((FaceInfo)((ArrayList)paramObject).get(i1)).vFaceID));
          i1 += 1;
        }
        paramBundle.putStringArrayList("hexFaceInfo", paramFromServiceMsg);
        paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramToServiceMsg = ((FriendsManager)paramObject).a(paramToServiceMsg);
        i1 = paramToServiceMsg.getLocalPicKeysCount();
        if ((paramToServiceMsg != null) && (l1 == i1) && (i1 < paramToServiceMsg.getPicCountInAlbum()))
        {
          paramToServiceMsg.appendPortrait(paramFromServiceMsg);
          ((FriendsManager)paramObject).a(paramToServiceMsg);
        }
        a(27, true, paramBundle);
        return;
      }
      paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
      paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
      paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
      paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
      a(27, false, paramBundle);
      return;
    }
    paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
    paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
    paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
    paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
    a(27, false, paramBundle);
  }
  
  /* Error */
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 12
    //   3: iconst_1
    //   4: istore 13
    //   6: iconst_1
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 953	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +562 -> 575
    //   16: aload_3
    //   17: ifnull +558 -> 575
    //   20: iconst_1
    //   21: istore 7
    //   23: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 745
    //   32: iconst_2
    //   33: new 270	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 3055
    //   43: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 7
    //   48: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 7
    //   59: istore 10
    //   61: iload 7
    //   63: ifeq +716 -> 779
    //   66: iload 7
    //   68: istore 8
    //   70: iload 7
    //   72: istore 9
    //   74: new 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 954	[B
    //   85: checkcast 954	[B
    //   88: invokevirtual 958	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +485 -> 581
    //   99: iload 7
    //   101: istore 8
    //   103: iload 7
    //   105: istore 9
    //   107: aload_2
    //   108: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: ifne +467 -> 581
    //   117: iconst_1
    //   118: istore 7
    //   120: iload 7
    //   122: istore 8
    //   124: iload 7
    //   126: istore 9
    //   128: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +39 -> 170
    //   134: iload 7
    //   136: istore 8
    //   138: iload 7
    //   140: istore 9
    //   142: ldc_w 745
    //   145: iconst_2
    //   146: new 270	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 3057
    //   156: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 7
    //   161: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iload 7
    //   172: istore 10
    //   174: iload 7
    //   176: ifeq +603 -> 779
    //   179: iload 7
    //   181: istore 8
    //   183: iload 7
    //   185: istore 9
    //   187: iload 7
    //   189: istore 10
    //   191: aload_2
    //   192: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   195: invokevirtual 1795	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   198: ifeq +581 -> 779
    //   201: iload 7
    //   203: istore 8
    //   205: iload 7
    //   207: istore 9
    //   209: iload 7
    //   211: istore 10
    //   213: aload_2
    //   214: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +559 -> 779
    //   223: iload 7
    //   225: istore 8
    //   227: iload 7
    //   229: istore 9
    //   231: aload_2
    //   232: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 964	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   241: invokestatic 968	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 970	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: ifge +336 -> 587
    //   254: iload 4
    //   256: i2l
    //   257: ldc2_w 3023
    //   260: ladd
    //   261: lstore 5
    //   263: iload 7
    //   265: istore 8
    //   267: iload 7
    //   269: istore 9
    //   271: aload_0
    //   272: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   278: lload 5
    //   280: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   283: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +419 -> 705
    //   289: iload 7
    //   291: istore 8
    //   293: iload 7
    //   295: istore 9
    //   297: aload_0
    //   298: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   301: bipush 50
    //   303: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   306: checkcast 552	com/tencent/mobileqq/app/FriendsManager
    //   309: astore_2
    //   310: iload 7
    //   312: istore 8
    //   314: iload 7
    //   316: istore 9
    //   318: aload_2
    //   319: aload_0
    //   320: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   323: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   326: invokevirtual 819	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   329: astore_3
    //   330: iload 7
    //   332: istore 8
    //   334: iload 7
    //   336: istore 9
    //   338: aload_3
    //   339: aload_1
    //   340: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   343: ldc_w 1999
    //   346: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   349: putfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   352: iload 7
    //   354: istore 8
    //   356: iload 7
    //   358: istore 9
    //   360: aload_2
    //   361: aload_3
    //   362: invokevirtual 566	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   365: pop
    //   366: iload 13
    //   368: istore 8
    //   370: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +37 -> 410
    //   376: iload 13
    //   378: istore 8
    //   380: ldc_w 2999
    //   383: iconst_2
    //   384: new 270	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 3059
    //   394: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_3
    //   398: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   401: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: iload 13
    //   412: istore 8
    //   414: aload_3
    //   415: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   418: ifeq +177 -> 595
    //   421: iload 13
    //   423: istore 8
    //   425: aload_2
    //   426: iconst_1
    //   427: putfield 2997	com/tencent/mobileqq/app/FriendsManager:h	I
    //   430: iload 11
    //   432: istore 7
    //   434: iload 7
    //   436: istore 8
    //   438: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq +54 -> 495
    //   444: ldc_w 745
    //   447: iconst_2
    //   448: new 270	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 3057
    //   458: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: iload 7
    //   463: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   466: ldc_w 1801
    //   469: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_1
    //   473: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   476: ldc_w 1999
    //   479: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   482: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   485: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: iload 7
    //   493: istore 8
    //   495: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq +67 -> 565
    //   501: aload_0
    //   502: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   505: bipush 50
    //   507: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   510: checkcast 552	com/tencent/mobileqq/app/FriendsManager
    //   513: aload_0
    //   514: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   517: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   520: invokevirtual 819	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   523: astore_1
    //   524: ldc_w 2999
    //   527: iconst_2
    //   528: new 270	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 3059
    //   538: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_1
    //   542: getfield 2995	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   545: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   548: ldc_w 3061
    //   551: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: iload 8
    //   556: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   559: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload_0
    //   566: bipush 73
    //   568: iload 8
    //   570: aconst_null
    //   571: invokevirtual 569	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   574: return
    //   575: iconst_0
    //   576: istore 7
    //   578: goto -555 -> 23
    //   581: iconst_0
    //   582: istore 7
    //   584: goto -464 -> 120
    //   587: iload 4
    //   589: i2l
    //   590: lstore 5
    //   592: goto -329 -> 263
    //   595: iload 13
    //   597: istore 8
    //   599: aload_2
    //   600: iconst_0
    //   601: putfield 2997	com/tencent/mobileqq/app/FriendsManager:h	I
    //   604: iload 11
    //   606: istore 7
    //   608: goto -174 -> 434
    //   611: astore_2
    //   612: iload 12
    //   614: istore 7
    //   616: iload 7
    //   618: istore 8
    //   620: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +18 -> 641
    //   626: iload 7
    //   628: istore 8
    //   630: ldc_w 745
    //   633: iconst_2
    //   634: ldc_w 3063
    //   637: aload_2
    //   638: invokestatic 1134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   641: iload 7
    //   643: istore 8
    //   645: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq -153 -> 495
    //   651: ldc_w 745
    //   654: iconst_2
    //   655: new 270	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 3057
    //   665: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: iload 7
    //   670: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: ldc_w 1801
    //   676: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload_1
    //   680: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   683: ldc_w 1999
    //   686: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   689: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   692: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: iload 7
    //   700: istore 8
    //   702: goto -207 -> 495
    //   705: iconst_0
    //   706: istore 7
    //   708: goto -274 -> 434
    //   711: astore_2
    //   712: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   715: ifeq +50 -> 765
    //   718: ldc_w 745
    //   721: iconst_2
    //   722: new 270	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 3057
    //   732: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: iload 8
    //   737: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   740: ldc_w 1801
    //   743: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload_1
    //   747: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   750: ldc_w 1999
    //   753: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   756: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   759: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_2
    //   766: athrow
    //   767: astore_2
    //   768: goto -56 -> 712
    //   771: astore_2
    //   772: iload 9
    //   774: istore 7
    //   776: goto -160 -> 616
    //   779: iload 10
    //   781: istore 7
    //   783: goto -349 -> 434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	786	0	this	CardHandler
    //   0	786	1	paramToServiceMsg	ToServiceMsg
    //   0	786	2	paramFromServiceMsg	FromServiceMsg
    //   0	786	3	paramObject	Object
    //   247	341	4	i1	int
    //   261	330	5	l1	long
    //   21	761	7	bool1	boolean
    //   68	668	8	bool2	boolean
    //   72	701	9	bool3	boolean
    //   59	721	10	bool4	boolean
    //   7	598	11	bool5	boolean
    //   1	612	12	bool6	boolean
    //   4	592	13	bool7	boolean
    // Exception table:
    //   from	to	target	type
    //   370	376	611	java/lang/Exception
    //   380	410	611	java/lang/Exception
    //   414	421	611	java/lang/Exception
    //   425	430	611	java/lang/Exception
    //   599	604	611	java/lang/Exception
    //   74	95	711	finally
    //   107	117	711	finally
    //   128	134	711	finally
    //   142	170	711	finally
    //   191	201	711	finally
    //   213	223	711	finally
    //   231	249	711	finally
    //   271	289	711	finally
    //   297	310	711	finally
    //   318	330	711	finally
    //   338	352	711	finally
    //   360	366	711	finally
    //   370	376	767	finally
    //   380	410	767	finally
    //   414	421	767	finally
    //   425	430	767	finally
    //   599	604	767	finally
    //   620	626	767	finally
    //   630	641	767	finally
    //   74	95	771	java/lang/Exception
    //   107	117	771	java/lang/Exception
    //   128	134	771	java/lang/Exception
    //   142	170	771	java/lang/Exception
    //   191	201	771	java/lang/Exception
    //   213	223	771	java/lang/Exception
    //   231	249	771	java/lang/Exception
    //   271	289	771	java/lang/Exception
    //   297	310	771	java/lang/Exception
    //   318	330	771	java/lang/Exception
    //   338	352	771	java/lang/Exception
    //   360	366	771	java/lang/Exception
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject = (String)paramToServiceMsg.getAttribute("nickname");
    paramBundle = (Byte)paramToServiceMsg.getAttribute("gender");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("birthday");
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|resp.getResultCode = " + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof SetUserInfoResp)))
    {
      paramObject = (SetUserInfoResp)paramObject;
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|setUserInfoResp.result = " + ((SetUserInfoResp)paramObject).result);
      }
    }
    for (paramFromServiceMsg = (FromServiceMsg)paramObject;; paramFromServiceMsg = null)
    {
      paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 0))
      {
        String str = paramToServiceMsg.getUin();
        paramFromServiceMsg = ((FriendsManager)paramObject).a(paramToServiceMsg.getUin());
        Friends localFriends = ((FriendsManager)paramObject).c(str);
        if (localObject != null)
        {
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.strNick = ((String)localObject);
          }
          if (localFriends != null)
          {
            localFriends.name = ((String)localObject);
            ((FriendsManager)paramObject).a(localFriends);
          }
          if (Utils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), str)) {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + str, (String)localObject);
          }
        }
        if (paramBundle != null)
        {
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.shGender = ((short)paramBundle.byteValue());
          }
          if (Utils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), str))
          {
            localObject = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
            if (localObject != null) {
              ((NearbyCardManager)localObject).b(paramBundle.byteValue());
            }
          }
        }
        if ((localInteger != null) && (paramFromServiceMsg != null))
        {
          paramFromServiceMsg.lBirthday = localInteger.intValue();
          paramFromServiceMsg.shAge = ((short)ProfileUtil.a(localInteger.intValue()));
          paramFromServiceMsg.age = ((byte)paramFromServiceMsg.shAge);
          if (Utils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), str))
          {
            paramBundle = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
            if (paramBundle != null) {
              paramBundle.a(paramFromServiceMsg.age);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo()  age = " + paramFromServiceMsg.age);
          }
        }
        if (paramFromServiceMsg != null) {
          ((FriendsManager)paramObject).a(paramFromServiceMsg);
        }
        a(paramToServiceMsg, 31, true, paramFromServiceMsg);
        return;
      }
      a(paramToServiceMsg, 31, false, ((FriendsManager)paramObject).b(paramToServiceMsg.getUin()));
      return;
    }
  }
  
  /* Error */
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 953	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +409 -> 422
    //   16: aload_3
    //   17: ifnull +405 -> 422
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 745
    //   32: iconst_2
    //   33: new 270	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 3105
    //   43: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: bipush 84
    //   63: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   66: checkcast 3107	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   69: astore_1
    //   70: aload_1
    //   71: iconst_0
    //   72: invokevirtual 3109	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(Z)Z
    //   75: istore 6
    //   77: iload 5
    //   79: istore 9
    //   81: iload 5
    //   83: ifeq +608 -> 691
    //   86: iload 5
    //   88: istore 7
    //   90: iload 5
    //   92: istore 8
    //   94: new 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: dup
    //   98: invokespecial 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   101: aload_3
    //   102: checkcast 954	[B
    //   105: checkcast 954	[B
    //   108: invokevirtual 958	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +312 -> 428
    //   119: iload 5
    //   121: istore 7
    //   123: iload 5
    //   125: istore 8
    //   127: aload_2
    //   128: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: ifne +294 -> 428
    //   137: iconst_1
    //   138: istore 5
    //   140: iload 5
    //   142: istore 7
    //   144: iload 5
    //   146: istore 8
    //   148: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: iload 5
    //   156: istore 7
    //   158: iload 5
    //   160: istore 8
    //   162: ldc_w 745
    //   165: iconst_2
    //   166: new 270	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 3111
    //   176: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 5
    //   181: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 5
    //   192: istore 9
    //   194: iload 5
    //   196: ifeq +495 -> 691
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: iload 5
    //   209: istore 9
    //   211: aload_2
    //   212: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 1795	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   218: ifeq +473 -> 691
    //   221: iload 5
    //   223: istore 7
    //   225: iload 5
    //   227: istore 8
    //   229: iload 5
    //   231: istore 9
    //   233: aload_2
    //   234: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +451 -> 691
    //   243: iload 5
    //   245: istore 7
    //   247: iload 5
    //   249: istore 8
    //   251: aload_2
    //   252: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 964	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: invokestatic 968	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   264: astore_2
    //   265: iload 5
    //   267: istore 7
    //   269: iload 5
    //   271: istore 8
    //   273: aload_2
    //   274: invokevirtual 970	java/nio/ByteBuffer:getInt	()I
    //   277: pop
    //   278: iload 5
    //   280: istore 7
    //   282: iload 5
    //   284: istore 8
    //   286: aload_2
    //   287: invokevirtual 973	java/nio/ByteBuffer:get	()B
    //   290: pop
    //   291: iload 5
    //   293: istore 7
    //   295: iload 5
    //   297: istore 8
    //   299: iload 5
    //   301: istore 9
    //   303: aload_2
    //   304: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   307: invokestatic 1799	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   310: invokevirtual 636	java/lang/Short:shortValue	()S
    //   313: iconst_1
    //   314: if_icmpne +377 -> 691
    //   317: iload 5
    //   319: istore 7
    //   321: iload 5
    //   323: istore 8
    //   325: aload_2
    //   326: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   329: istore 4
    //   331: iload 4
    //   333: sipush 40505
    //   336: if_icmpeq +98 -> 434
    //   339: iload 6
    //   341: istore 5
    //   343: iload 11
    //   345: istore 6
    //   347: iload 5
    //   349: istore 7
    //   351: iload 6
    //   353: istore 8
    //   355: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +50 -> 408
    //   361: ldc_w 745
    //   364: iconst_2
    //   365: new 270	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 3111
    //   375: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 6
    //   380: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: ldc_w 1801
    //   386: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: iload 5
    //   391: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   394: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: iload 6
    //   402: istore 8
    //   404: iload 5
    //   406: istore 7
    //   408: aload_0
    //   409: bipush 58
    //   411: iload 8
    //   413: iload 7
    //   415: invokestatic 984	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   418: invokevirtual 569	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   421: return
    //   422: iconst_0
    //   423: istore 5
    //   425: goto -402 -> 23
    //   428: iconst_0
    //   429: istore 5
    //   431: goto -291 -> 140
    //   434: iload 5
    //   436: istore 7
    //   438: iload 5
    //   440: istore 8
    //   442: aload_2
    //   443: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   446: istore 4
    //   448: iload 4
    //   450: iconst_2
    //   451: if_icmpne +80 -> 531
    //   454: iload 5
    //   456: istore 7
    //   458: iload 5
    //   460: istore 8
    //   462: iload 4
    //   464: newarray <illegal type>
    //   466: astore_3
    //   467: iload 5
    //   469: istore 7
    //   471: iload 5
    //   473: istore 8
    //   475: aload_2
    //   476: aload_3
    //   477: invokevirtual 1226	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   480: pop
    //   481: iload 5
    //   483: istore 7
    //   485: iload 5
    //   487: istore 8
    //   489: aload_3
    //   490: iconst_0
    //   491: invokestatic 1328	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   494: istore 4
    //   496: iload 4
    //   498: ifne +215 -> 713
    //   501: iconst_1
    //   502: istore 6
    //   504: aload_2
    //   505: invokevirtual 1202	java/nio/ByteBuffer:getShort	()S
    //   508: ifeq +10 -> 518
    //   511: iload 12
    //   513: istore 7
    //   515: goto +187 -> 702
    //   518: aload_1
    //   519: iload 6
    //   521: iconst_0
    //   522: invokevirtual 3112	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(ZZ)V
    //   525: iconst_1
    //   526: istore 7
    //   528: goto +174 -> 702
    //   531: iload 6
    //   533: istore 5
    //   535: iload 11
    //   537: istore 6
    //   539: goto -192 -> 347
    //   542: astore_1
    //   543: iload 7
    //   545: istore 5
    //   547: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +14 -> 564
    //   553: ldc_w 745
    //   556: iconst_2
    //   557: ldc_w 3114
    //   560: aload_1
    //   561: invokestatic 1134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: iload 6
    //   566: istore 7
    //   568: iload 10
    //   570: istore 8
    //   572: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq -167 -> 408
    //   578: ldc_w 745
    //   581: iconst_2
    //   582: new 270	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 3111
    //   592: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iconst_0
    //   596: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   599: ldc_w 1801
    //   602: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: iload 6
    //   607: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   610: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: iload 6
    //   618: istore 7
    //   620: iload 10
    //   622: istore 8
    //   624: goto -216 -> 408
    //   627: astore_1
    //   628: iload 8
    //   630: istore 5
    //   632: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +42 -> 677
    //   638: ldc_w 745
    //   641: iconst_2
    //   642: new 270	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 3111
    //   652: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: iload 5
    //   657: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   660: ldc_w 1801
    //   663: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 6
    //   668: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_1
    //   678: athrow
    //   679: astore_1
    //   680: goto -48 -> 632
    //   683: astore_1
    //   684: goto -52 -> 632
    //   687: astore_1
    //   688: goto -141 -> 547
    //   691: iload 6
    //   693: istore 5
    //   695: iload 9
    //   697: istore 6
    //   699: goto -352 -> 347
    //   702: iload 6
    //   704: istore 5
    //   706: iload 7
    //   708: istore 6
    //   710: goto -363 -> 347
    //   713: iconst_0
    //   714: istore 6
    //   716: goto -212 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	CardHandler
    //   0	719	1	paramToServiceMsg	ToServiceMsg
    //   0	719	2	paramFromServiceMsg	FromServiceMsg
    //   0	719	3	paramObject	Object
    //   329	168	4	i1	int
    //   21	684	5	bool1	boolean
    //   75	640	6	bool2	boolean
    //   88	619	7	bool3	boolean
    //   92	537	8	bool4	boolean
    //   79	617	9	bool5	boolean
    //   1	620	10	bool6	boolean
    //   7	529	11	bool7	boolean
    //   4	508	12	bool8	boolean
    // Exception table:
    //   from	to	target	type
    //   94	115	542	java/lang/Exception
    //   127	137	542	java/lang/Exception
    //   148	154	542	java/lang/Exception
    //   162	190	542	java/lang/Exception
    //   211	221	542	java/lang/Exception
    //   233	243	542	java/lang/Exception
    //   251	265	542	java/lang/Exception
    //   273	278	542	java/lang/Exception
    //   286	291	542	java/lang/Exception
    //   303	317	542	java/lang/Exception
    //   325	331	542	java/lang/Exception
    //   442	448	542	java/lang/Exception
    //   462	467	542	java/lang/Exception
    //   475	481	542	java/lang/Exception
    //   489	496	542	java/lang/Exception
    //   94	115	627	finally
    //   127	137	627	finally
    //   148	154	627	finally
    //   162	190	627	finally
    //   211	221	627	finally
    //   233	243	627	finally
    //   251	265	627	finally
    //   273	278	627	finally
    //   286	291	627	finally
    //   303	317	627	finally
    //   325	331	627	finally
    //   442	448	627	finally
    //   462	467	627	finally
    //   475	481	627	finally
    //   489	496	627	finally
    //   504	511	679	finally
    //   518	525	679	finally
    //   547	564	683	finally
    //   504	511	687	java/lang/Exception
    //   518	525	687	java/lang/Exception
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject2 = null;
    localObject3 = null;
    localObject4 = null;
    bool4 = false;
    localObject1 = localObject2;
    bool1 = bool4;
    if (paramFromServiceMsg != null)
    {
      localObject1 = localObject2;
      bool1 = bool4;
      if (paramFromServiceMsg.isSuccess()) {
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = paramToServiceMsg.extraData;
        if (localObject2 == null) {
          continue;
        }
        localObject1 = localObject3;
        paramToServiceMsg = ((Bundle)localObject2).getString("targetUin");
        if (localObject2 == null) {
          continue;
        }
        localObject1 = localObject3;
        localObject2 = ((Bundle)localObject2).getString("selfUin");
        localObject1 = localObject3;
        paramBundle.putString("targetUin", paramToServiceMsg);
        localObject1 = localObject3;
        paramBundle.putString("selfUin", (String)localObject2);
        localObject1 = localObject3;
        paramBundle = new oidb_sso.OIDBSSOPkg();
        localObject1 = localObject3;
        paramObject = (byte[])paramObject;
        localObject1 = localObject3;
        paramFromServiceMsg = new StringBuilder().append("handle_oidb_0x5eb_17 ").append(paramFromServiceMsg.isSuccess()).append(", ");
        if (paramObject == null) {
          continue;
        }
        localObject1 = localObject3;
        i1 = paramObject.length;
        localObject1 = localObject3;
        QLog.d("Q.profilecard.", 1, i1);
        localObject1 = localObject3;
        paramBundle.mergeFrom((byte[])paramObject);
        localObject1 = localObject3;
        if (!paramBundle.uint32_result.has()) {
          continue;
        }
        localObject1 = localObject3;
        if (paramBundle.uint32_result.get() != 0) {
          continue;
        }
        localObject1 = localObject3;
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        localObject1 = localObject3;
        paramFromServiceMsg.mergeFrom(paramBundle.bytes_bodybuffer.get().toByteArray());
        localObject1 = localObject3;
        if (paramFromServiceMsg.rpt_msg_uin_data.size() <= 0) {
          continue;
        }
        localObject1 = localObject3;
        paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0);
        localObject1 = localObject3;
        if (paramFromServiceMsg.uint32_music_ring_visible.get() != 1) {
          continue;
        }
        bool1 = true;
        localObject1 = localObject3;
        if (paramFromServiceMsg.uint32_music_ring_autoplay.get() != 1) {
          continue;
        }
        bool2 = true;
        localObject1 = localObject3;
        if (paramFromServiceMsg.uint32_music_ring_redpoint.get() != 1) {
          continue;
        }
        bool3 = true;
        localObject1 = localObject3;
        if (TextUtils.isEmpty(paramToServiceMsg)) {
          continue;
        }
        localObject1 = localObject3;
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject1 = localObject3;
        paramToServiceMsg = paramFromServiceMsg.b(paramToServiceMsg);
        if (paramToServiceMsg == null) {
          continue;
        }
        localObject1 = paramToServiceMsg;
        paramToServiceMsg.visibleMusicPendant = bool1;
        localObject1 = paramToServiceMsg;
        paramToServiceMsg.autoPlayMusicPendant = bool2;
        localObject1 = paramToServiceMsg;
        paramToServiceMsg.showRedPointMusicPendant = bool3;
        localObject1 = paramToServiceMsg;
        paramFromServiceMsg.a(paramToServiceMsg);
      }
      catch (Throwable paramToServiceMsg)
      {
        int i1;
        boolean bool2;
        boolean bool3;
        QLog.e("Q.profilecard.", 1, "handleUpdateMusicPendant exception", paramToServiceMsg);
        bool1 = bool4;
        continue;
        localObject1 = localObject3;
        QLog.e("CardHandler", 1, "handleUpdateMusicPendant() targetUin is empty");
        paramToServiceMsg = null;
        continue;
        bool1 = false;
        localObject1 = localObject4;
        continue;
      }
      bool1 = true;
      localObject1 = paramToServiceMsg;
      a(63, bool1, localObject1);
      return;
      paramToServiceMsg = null;
      continue;
      localObject2 = null;
      continue;
      i1 = -1;
      continue;
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      bool3 = false;
      continue;
      localObject1 = paramToServiceMsg;
      QLog.e("CardHandler", 1, "handleUpdateMusicPendant() card is null!");
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool7 = true;
    boolean bool6 = false;
    boolean bool1;
    boolean bool2;
    boolean bool5;
    boolean bool4;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch success=" + bool1);
      }
      paramFromServiceMsg = (ActivateFriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(84);
      bool2 = paramFromServiceMsg.a(false);
      bool5 = bool1;
      if (!bool1) {
        break label661;
      }
      bool4 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject != null)
        {
          bool4 = bool1;
          bool3 = bool1;
          if (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get() == 0)
          {
            bool1 = true;
            bool4 = bool1;
            bool3 = bool1;
            if (QLog.isColorLevel())
            {
              bool4 = bool1;
              bool3 = bool1;
              QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool1);
            }
            bool5 = bool1;
            if (!bool1) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            l1 = Utils.a(ByteBuffer.wrap(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray()).getInt());
            bool4 = bool1;
            bool3 = bool1;
            if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1))) {
              continue;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = paramToServiceMsg.extraData.getBoolean("switch");
            bool3 = bool1;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l1;
        bool1 = bool4;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch ex", paramFromServiceMsg);
        }
        bool3 = bool2;
        bool1 = bool6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + false + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = bool2;
        bool1 = bool6;
        continue;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        }
      }
      try
      {
        paramFromServiceMsg.a(bool5, false);
        bool2 = bool5;
        bool1 = bool7;
        if (!QLog.isColorLevel()) {
          break label654;
        }
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = bool2;
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool5;
        continue;
        bool3 = bool2;
        continue;
      }
      a(57, bool1, Boolean.valueOf(bool3));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool4 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool4 = bool1;
        bool3 = bool1;
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch cur:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() + " dwUin:" + l1);
      }
      bool1 = false;
      continue;
      label654:
      label661:
      bool1 = bool5;
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = null;
    int i2 = 0;
    label287:
    label297:
    label300:
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = paramToServiceMsg.extraData.getString("targetUin");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
        paramBundle.putString("targetUin", (String)localObject);
        paramBundle.putString("selfUin", paramToServiceMsg);
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          localObject = paramFromServiceMsg.getWupBuffer();
          paramToServiceMsg = "";
          if (localObject != null) {
            paramToServiceMsg = new String(paramFromServiceMsg.getWupBuffer()).toString();
          }
          paramToServiceMsg = new JSONObject(paramToServiceMsg);
          if ((paramToServiceMsg.has("code")) && (paramToServiceMsg.getInt("code") == 0))
          {
            if (!paramToServiceMsg.has("ringlist")) {
              break label297;
            }
            paramFromServiceMsg = paramToServiceMsg.getJSONArray("ringlist");
            break label287;
            QLog.e("Q.profilecard.", 1, "handleMusicPendantSongList Get Song count:" + i1);
            paramObject = new SongInfo[i1];
            paramToServiceMsg = (ToServiceMsg)paramObject;
            if (i2 < i1)
            {
              paramObject[i2] = a(paramFromServiceMsg.getJSONObject(i2));
              i2 += 1;
              continue;
              i1 = paramFromServiceMsg.length();
              continue;
            }
          }
          else
          {
            QLog.e("Q.profilecard.", 1, "handleMusicPendantSongList responseString:" + paramToServiceMsg.getString("msg"));
            paramToServiceMsg = (ToServiceMsg)paramObject;
          }
          paramBundle.putSerializable("songList", paramToServiceMsg);
          a(64, true, paramBundle);
        }
        else
        {
          a(64, false, paramBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("CardHandler", 1, "MusicGeneWebViewPlugin.convertJSonObject2MusicGeneSongInfo exception", paramToServiceMsg);
        return;
      }
      for (;;)
      {
        if (paramFromServiceMsg != null) {
          break label300;
        }
        i1 = 0;
        break;
        paramFromServiceMsg = null;
      }
    }
  }
  
  /* Error */
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: aload_2
    //   4: invokevirtual 953	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +397 -> 404
    //   10: aload_3
    //   11: ifnull +393 -> 404
    //   14: iconst_1
    //   15: istore 7
    //   17: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 745
    //   26: iconst_2
    //   27: new 270	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 3200
    //   37: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 7
    //   42: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 1181	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 1993
    //   61: invokevirtual 1186	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   72: pop
    //   73: iload 7
    //   75: istore 10
    //   77: iload 7
    //   79: ifeq +566 -> 645
    //   82: iload 7
    //   84: istore 8
    //   86: iload 7
    //   88: istore 9
    //   90: new 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: dup
    //   94: invokespecial 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   97: aload_3
    //   98: checkcast 954	[B
    //   101: checkcast 954	[B
    //   104: invokevirtual 958	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: checkcast 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +298 -> 410
    //   115: iload 7
    //   117: istore 8
    //   119: iload 7
    //   121: istore 9
    //   123: aload_2
    //   124: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: ifne +280 -> 410
    //   133: iconst_1
    //   134: istore 7
    //   136: iload 7
    //   138: istore 8
    //   140: iload 7
    //   142: istore 9
    //   144: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +39 -> 186
    //   150: iload 7
    //   152: istore 8
    //   154: iload 7
    //   156: istore 9
    //   158: ldc_w 745
    //   161: iconst_2
    //   162: new 270	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 3202
    //   172: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 7
    //   177: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 7
    //   188: istore 10
    //   190: iload 7
    //   192: ifeq +453 -> 645
    //   195: iload 7
    //   197: istore 8
    //   199: iload 7
    //   201: istore 9
    //   203: iload 7
    //   205: istore 10
    //   207: aload_2
    //   208: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 1795	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +431 -> 645
    //   217: iload 7
    //   219: istore 8
    //   221: iload 7
    //   223: istore 9
    //   225: iload 7
    //   227: istore 10
    //   229: aload_2
    //   230: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: ifnull +409 -> 645
    //   239: iload 7
    //   241: istore 8
    //   243: iload 7
    //   245: istore 9
    //   247: aload_2
    //   248: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   254: invokevirtual 964	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   257: invokestatic 968	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   260: invokevirtual 970	java/nio/ByteBuffer:getInt	()I
    //   263: istore 4
    //   265: iload 4
    //   267: i2l
    //   268: lstore 5
    //   270: iload 4
    //   272: ifge +16 -> 288
    //   275: iload 4
    //   277: ldc_w 1796
    //   280: iand
    //   281: i2l
    //   282: ldc2_w 1996
    //   285: lor
    //   286: lstore 5
    //   288: iload 7
    //   290: istore 8
    //   292: iload 7
    //   294: istore 9
    //   296: aload_0
    //   297: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   300: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   303: lload 5
    //   305: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: istore 7
    //   313: iload 7
    //   315: ifeq +101 -> 416
    //   318: aload_1
    //   319: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   322: ldc_w 3204
    //   325: invokevirtual 2043	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   328: istore 4
    //   330: aload_0
    //   331: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: bipush 51
    //   336: invokevirtual 1071	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   339: checkcast 1412	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   342: iload 4
    //   344: invokevirtual 1416	com/tencent/device/devicemgr/SmartDeviceProxyMgr:b	(I)V
    //   347: iconst_1
    //   348: istore 7
    //   350: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +50 -> 403
    //   356: ldc_w 745
    //   359: iconst_2
    //   360: new 270	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 3202
    //   370: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload 7
    //   375: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   378: ldc_w 1801
    //   381: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   388: ldc_w 3204
    //   391: invokevirtual 2043	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   394: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: return
    //   404: iconst_0
    //   405: istore 7
    //   407: goto -390 -> 17
    //   410: iconst_0
    //   411: istore 7
    //   413: goto -277 -> 136
    //   416: iload 11
    //   418: istore 7
    //   420: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq -73 -> 350
    //   426: ldc_w 745
    //   429: iconst_2
    //   430: new 270	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 3206
    //   440: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: lload 5
    //   445: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: ldc_w 752
    //   451: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   458: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   461: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: iload 11
    //   472: istore 7
    //   474: goto -124 -> 350
    //   477: astore_2
    //   478: iconst_0
    //   479: istore 7
    //   481: iload 7
    //   483: istore 8
    //   485: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +18 -> 506
    //   491: iload 7
    //   493: istore 8
    //   495: ldc_w 745
    //   498: iconst_2
    //   499: ldc_w 3208
    //   502: aload_2
    //   503: invokestatic 1134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   506: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq -106 -> 403
    //   512: ldc_w 745
    //   515: iconst_2
    //   516: new 270	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   523: ldc_w 3202
    //   526: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: iload 7
    //   531: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   534: ldc_w 1801
    //   537: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_1
    //   541: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   544: ldc_w 3204
    //   547: invokevirtual 2043	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   550: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   553: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: return
    //   560: astore_2
    //   561: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +50 -> 614
    //   567: ldc_w 745
    //   570: iconst_2
    //   571: new 270	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   578: ldc_w 3202
    //   581: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: iload 8
    //   586: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   589: ldc_w 1801
    //   592: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_1
    //   596: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   599: ldc_w 3204
    //   602: invokevirtual 2043	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   605: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   608: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aload_2
    //   615: athrow
    //   616: astore_2
    //   617: iconst_1
    //   618: istore 8
    //   620: goto -59 -> 561
    //   623: astore_2
    //   624: iconst_0
    //   625: istore 8
    //   627: goto -66 -> 561
    //   630: astore_2
    //   631: iload 9
    //   633: istore 7
    //   635: goto -154 -> 481
    //   638: astore_2
    //   639: iconst_1
    //   640: istore 7
    //   642: goto -161 -> 481
    //   645: iload 10
    //   647: istore 7
    //   649: goto -299 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	CardHandler
    //   0	652	1	paramToServiceMsg	ToServiceMsg
    //   0	652	2	paramFromServiceMsg	FromServiceMsg
    //   0	652	3	paramObject	Object
    //   263	80	4	i1	int
    //   268	176	5	l1	long
    //   15	633	7	bool1	boolean
    //   84	542	8	bool2	boolean
    //   88	544	9	bool3	boolean
    //   75	571	10	bool4	boolean
    //   1	470	11	bool5	boolean
    // Exception table:
    //   from	to	target	type
    //   420	470	477	java/lang/Exception
    //   90	111	560	finally
    //   123	133	560	finally
    //   144	150	560	finally
    //   158	186	560	finally
    //   207	217	560	finally
    //   229	239	560	finally
    //   247	265	560	finally
    //   296	313	560	finally
    //   485	491	560	finally
    //   495	506	560	finally
    //   318	347	616	finally
    //   420	470	623	finally
    //   90	111	630	java/lang/Exception
    //   123	133	630	java/lang/Exception
    //   144	150	630	java/lang/Exception
    //   158	186	630	java/lang/Exception
    //   207	217	630	java/lang/Exception
    //   229	239	630	java/lang/Exception
    //   247	265	630	java/lang/Exception
    //   296	313	630	java/lang/Exception
    //   318	347	638	java/lang/Exception
  }
  
  /* Error */
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 953	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +372 -> 379
    //   10: aload_3
    //   11: ifnull +368 -> 379
    //   14: iconst_1
    //   15: istore 7
    //   17: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 745
    //   26: iconst_2
    //   27: new 270	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 3210
    //   37: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 7
    //   42: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 1181	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 1993
    //   61: invokevirtual 1186	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   72: pop
    //   73: iload 7
    //   75: ifeq +465 -> 540
    //   78: iload 7
    //   80: istore 8
    //   82: iload 7
    //   84: istore 9
    //   86: new 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   89: dup
    //   90: invokespecial 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   93: aload_3
    //   94: checkcast 954	[B
    //   97: checkcast 954	[B
    //   100: invokevirtual 958	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 578	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +277 -> 385
    //   111: iload 7
    //   113: istore 8
    //   115: iload 7
    //   117: istore 9
    //   119: aload_2
    //   120: getfield 592	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 960	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: ifne +259 -> 385
    //   129: iconst_1
    //   130: istore 7
    //   132: iload 7
    //   134: istore 8
    //   136: iload 7
    //   138: istore 9
    //   140: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +39 -> 182
    //   146: iload 7
    //   148: istore 8
    //   150: iload 7
    //   152: istore 9
    //   154: ldc_w 745
    //   157: iconst_2
    //   158: new 270	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 3212
    //   168: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload 7
    //   173: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   176: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iload 7
    //   184: ifeq +426 -> 610
    //   187: iload 7
    //   189: istore 8
    //   191: iload 7
    //   193: istore 9
    //   195: aload_2
    //   196: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 1795	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   202: ifeq +408 -> 610
    //   205: iload 7
    //   207: istore 8
    //   209: iload 7
    //   211: istore 9
    //   213: aload_2
    //   214: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +390 -> 610
    //   223: iload 7
    //   225: istore 8
    //   227: iload 7
    //   229: istore 9
    //   231: aload_2
    //   232: getfield 640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 963	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 964	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   241: invokestatic 968	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 970	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: i2l
    //   252: lstore 5
    //   254: iload 4
    //   256: ifge +16 -> 272
    //   259: iload 4
    //   261: ldc_w 1796
    //   264: iand
    //   265: i2l
    //   266: ldc2_w 1996
    //   269: lor
    //   270: lstore 5
    //   272: iload 7
    //   274: istore 8
    //   276: iload 7
    //   278: istore 9
    //   280: aload_1
    //   281: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   284: ldc_w 1999
    //   287: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   290: istore 11
    //   292: iload 7
    //   294: istore 8
    //   296: iload 7
    //   298: istore 9
    //   300: aload_0
    //   301: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   304: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   307: lload 5
    //   309: invokestatic 732	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: istore 7
    //   317: iload 7
    //   319: ifeq +72 -> 391
    //   322: iconst_1
    //   323: istore 7
    //   325: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +50 -> 378
    //   331: ldc_w 745
    //   334: iconst_2
    //   335: new 270	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 3212
    //   345: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload 7
    //   350: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   353: ldc_w 1801
    //   356: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   363: ldc_w 1999
    //   366: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   369: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   372: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: iconst_0
    //   380: istore 7
    //   382: goto -365 -> 17
    //   385: iconst_0
    //   386: istore 7
    //   388: goto -256 -> 132
    //   391: iload 11
    //   393: ifne +3 -> 396
    //   396: iload 10
    //   398: istore 7
    //   400: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq -78 -> 325
    //   406: ldc_w 745
    //   409: iconst_2
    //   410: new 270	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 3214
    //   420: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: lload 5
    //   425: invokevirtual 755	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: ldc_w 752
    //   431: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   441: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: iload 10
    //   452: istore 7
    //   454: goto -129 -> 325
    //   457: astore_2
    //   458: iconst_0
    //   459: istore 9
    //   461: iload 9
    //   463: istore 8
    //   465: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +18 -> 486
    //   471: iload 9
    //   473: istore 8
    //   475: ldc_w 745
    //   478: iconst_2
    //   479: ldc_w 3216
    //   482: aload_2
    //   483: invokestatic 1134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -111 -> 378
    //   492: ldc_w 745
    //   495: iconst_2
    //   496: new 270	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 3212
    //   506: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: iload 9
    //   511: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: ldc_w 1801
    //   517: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_1
    //   521: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   524: ldc_w 1999
    //   527: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   530: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: return
    //   540: goto -215 -> 325
    //   543: astore_2
    //   544: invokestatic 766	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +50 -> 597
    //   550: ldc_w 745
    //   553: iconst_2
    //   554: new 270	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 3212
    //   564: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: iload 8
    //   569: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   572: ldc_w 1801
    //   575: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: getfield 522	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   582: ldc_w 1999
    //   585: invokevirtual 692	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   588: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   591: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 890	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: aload_2
    //   598: athrow
    //   599: astore_2
    //   600: iconst_0
    //   601: istore 8
    //   603: goto -59 -> 544
    //   606: astore_2
    //   607: goto -146 -> 461
    //   610: goto -285 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	CardHandler
    //   0	613	1	paramToServiceMsg	ToServiceMsg
    //   0	613	2	paramFromServiceMsg	FromServiceMsg
    //   0	613	3	paramObject	Object
    //   247	18	4	i1	int
    //   252	172	5	l1	long
    //   15	438	7	bool1	boolean
    //   80	522	8	bool2	boolean
    //   84	426	9	bool3	boolean
    //   1	450	10	bool4	boolean
    //   290	102	11	bool5	boolean
    // Exception table:
    //   from	to	target	type
    //   400	450	457	java/lang/Exception
    //   86	107	543	finally
    //   119	129	543	finally
    //   140	146	543	finally
    //   154	182	543	finally
    //   195	205	543	finally
    //   213	223	543	finally
    //   231	249	543	finally
    //   280	292	543	finally
    //   300	317	543	finally
    //   465	471	543	finally
    //   475	486	543	finally
    //   400	450	599	finally
    //   86	107	606	java/lang/Exception
    //   119	129	606	java/lang/Exception
    //   140	146	606	java/lang/Exception
    //   154	182	606	java/lang/Exception
    //   195	205	606	java/lang/Exception
    //   213	223	606	java/lang/Exception
    //   231	249	606	java/lang/Exception
    //   280	292	606	java/lang/Exception
    //   300	317	606	java/lang/Exception
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt success=" + bool1);
      }
      localObject2 = null;
      localObject3 = null;
      localObject1 = null;
      paramFromServiceMsg = null;
      if (!bool1) {
        break label497;
      }
    }
    int i2;
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject != null)
        {
          i2 = ((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get();
          if (i2 == 0) {
            bool1 = true;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l1;
        label300:
        label497:
        paramObject = localObject1;
        continue;
        bool2 = bool1;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt result=" + bool1);
        }
        if ((!bool1) || (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramObject = ByteBuffer.wrap(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray());
        l1 = Utils.a(((ByteBuffer)paramObject).getInt());
        ((ByteBuffer)paramObject).get();
        if (Short.valueOf(((ByteBuffer)paramObject).getShort()).shortValue() != 1) {
          continue;
        }
        i2 = ((ByteBuffer)paramObject).getShort();
        if (i2 != 40410)
        {
          paramToServiceMsg = paramFromServiceMsg;
          a(68, bool2, paramToServiceMsg);
          return;
          bool1 = false;
          break;
          bool1 = false;
          continue;
        }
        i2 = ((ByteBuffer)paramObject).getShort();
        if (i2 != 2) {
          continue;
        }
        paramFromServiceMsg = new byte[i2];
        ((ByteBuffer)paramObject).get(paramFromServiceMsg);
        i2 = Utils.a(paramFromServiceMsg, 0);
        if (((ByteBuffer)paramObject).getShort() == 0) {
          break label567;
        }
        paramToServiceMsg = null;
        bool2 = bool3;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramObject = localObject1;
        continue;
      }
      bool2 = paramToServiceMsg.extraData.getBoolean("isQidianSimple", false);
      paramToServiceMsg = new BmqqAccountType(String.valueOf(Long.valueOf(l1)), i1);
      try
      {
        paramFromServiceMsg = (QidianManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(164);
        paramFromServiceMsg.a(paramToServiceMsg);
        if ((i1 == 1) && (bool2)) {
          paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getBaseContext(), paramToServiceMsg);
        } else {
          paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getBaseContext(), paramToServiceMsg);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramObject = paramToServiceMsg;
      }
      paramFromServiceMsg.printStackTrace();
      bool2 = bool1;
      paramToServiceMsg = (ToServiceMsg)paramObject;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt exception: " + paramFromServiceMsg.getMessage());
        bool2 = bool1;
        paramToServiceMsg = (ToServiceMsg)paramObject;
        continue;
        paramToServiceMsg = (ToServiceMsg)localObject2;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt uint32_result false");
          paramToServiceMsg = (ToServiceMsg)localObject2;
          bool2 = bool1;
          continue;
          bool2 = bool1;
          paramToServiceMsg = (ToServiceMsg)localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt isSuccess: " + bool1);
            bool2 = bool1;
            paramToServiceMsg = (ToServiceMsg)localObject3;
          }
        }
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramToServiceMsg;
      break;
      label567:
      if (i2 == 0) {
        break label300;
      }
      i1 = 1;
      break label300;
      bool2 = true;
    }
  }
  
  protected Class a()
  {
    return CardObserver.class;
  }
  
  public ArrayList a(int paramInt1, int paramInt2)
  {
    for (Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();; localObject1 = null)
    {
      label152:
      try
      {
        localObject2 = (ArrayList)((EntityManager)localObject1).a(CardProfile.class, true, "type=?", new String[] { String.valueOf(paramInt1) }, null, null, "lTime desc", String.valueOf(paramInt2));
        ((EntityManager)localObject1).a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localException.printStackTrace();
          ((EntityManager)localObject1).a();
          if (0 != 0) {
            break;
          }
          localObject1 = new ArrayList(0);
        }
      }
      finally
      {
        ((EntityManager)localObject1).a();
        if (0 != 0) {
          break label152;
        }
        new ArrayList(0);
      }
      paramInt1 = 0;
      while (paramInt1 < ((ArrayList)localObject1).size())
      {
        localObject2 = (CardProfile)((ArrayList)localObject1).get(paramInt1);
        ((CardProfile)localObject2).updateTime(((CardProfile)localObject2).lTime);
        paramInt1 += 1;
      }
      return (ArrayList)localObject1;
    }
  }
  
  public void a()
  {
    a(a("MCardSvc.ReqGetCardSwitch"));
  }
  
  public void a(byte paramByte, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setSelfGender|gender = " + paramByte);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("gender", Byte.valueOf(paramByte));
    a(paramCardObserver);
  }
  
  public void a(int paramInt)
  {
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.a().a();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete from ");
      localStringBuilder.append(((CardProfile)CardProfile.class.newInstance()).getTableName());
      localStringBuilder.append(" where ");
      localStringBuilder.append("type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(";");
      localEntityManager.b(localStringBuilder.toString());
      localEntityManager.a().c();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, localException.getMessage(), localException);
      }
      return;
    }
    finally
    {
      localEntityManager.a().b();
      localEntityManager.a();
    }
  }
  
  public void a(int paramInt, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setBirthday|birthday = " + paramInt);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("birthday", Integer.valueOf(paramInt));
    a(paramCardObserver);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func getShoppingCardInfo begins, seqNo:" + paramInt + ",shoppingUin:" + paramString1 + ",uin:" + paramString2);
    }
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("6.5.5,3,2880");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(paramInt);
    try
    {
      localGetPublicAccountDetailInfoRequest.luin.set(Long.parseLong(paramString1));
      paramString1 = a("PubAccountSvc.get_detail_info");
      paramString1.putWupBuffer(localGetPublicAccountDetailInfoRequest.toByteArray());
      paramString1.addAttribute("uin", paramString2);
      b(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      for (;;) {}
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqVote");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "MCardSvc.ReqPicSafetyCheck");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("lToUIN", paramLong2);
    localToServiceMsg.extraData.putLong("friendUin", paramLong2);
    localToServiceMsg.extraData.putInt("iScene", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, "reqFavorite|" + paramLong2 + ",voteNum|" + paramInt2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, CardHandler.NowOnliveGallayCallback paramNowOnliveGallayCallback)
  {
    NowLiveGallary.ReqBody localReqBody = new NowLiveGallary.ReqBody();
    localReqBody.req_uin.set(paramLong);
    ProtoUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramNowOnliveGallayCallback, localReqBody.toByteArray(), "ilive.photo_wall");
  }
  
  public void a(PushVoteIncreaseInfo paramPushVoteIncreaseInfo, String paramString1, String paramString2)
  {
    Visitor localVisitor = (Visitor)paramPushVoteIncreaseInfo.vVoterList.get(0);
    MessageRecord localMessageRecord = MessageRecordFactory.a(64536);
    localMessageRecord.frienduin = AppConstants.ao;
    localMessageRecord.istroop = 0;
    localMessageRecord.senderuin = String.valueOf(localVisitor.lUIN);
    localMessageRecord.extraflag = paramPushVoteIncreaseInfo.iIncrement;
    localMessageRecord.time = (System.currentTimeMillis() / 1000L);
    ThreadManager.a(new pur(this, paramPushVoteIncreaseInfo.iIncrement, paramPushVoteIncreaseInfo.vVoterList), 8, null, false);
    try
    {
      Object localObject1 = new String(localVisitor.vecNick, "UTF8");
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() == 0) {
        localObject2 = String.valueOf(localVisitor.lUIN);
      }
      if (1 == paramPushVoteIncreaseInfo.iIncrement)
      {
        localMessageRecord.msg = String.format(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369222), new Object[] { localObject2 });
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, paramString1);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
        ((Bundle)localObject1).putString("sender", paramString2);
        ((Bundle)localObject1).putString("voteeUin", paramString1);
        ((Bundle)localObject1).putString("uin", paramString1);
        a(28, true, new Object[] { ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()), localObject1 });
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.w("accost", 2, "last voter's name. unsupported encoding.");
        }
        String str = "";
        continue;
        localMessageRecord.msg = String.format(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369223), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
      }
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(QQAppInterface paramQQAppInterface, TransProcessorHandler paramTransProcessorHandler)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.a();
    }
    paramTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramTransProcessorHandler);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "addCoverTransCallback");
    }
  }
  
  public void a(TransProcessorHandler paramTransProcessorHandler)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b(paramTransProcessorHandler);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "removeCoverTransCallback");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("friendUin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFromServiceMsg.getUin();
    }
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    localObject2 = new Bundle();
                    ((Bundle)localObject2).putString("uin", (String)localObject1);
                    if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      n(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      m(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      l(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      i(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("SummaryCard.SetLabel".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      j(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("SummaryCard.LikeIt".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      k(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      g(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      h(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqVote".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      b(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      d(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      c(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqFaceInfo".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      f(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqAddFace".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      e(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqUpdateIntro".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
                      {
                        if (((RespUpdateIntro)paramObject).stHeader.iReplyCode == 0)
                        {
                          a(9, true, ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin()));
                          return;
                        }
                        a(9, false, localObject2);
                        return;
                      }
                      a(9, false, localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      o(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if ("ProfileService.getGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      if (paramFromServiceMsg.getResultCode() == 1000)
                      {
                        a(17, true, ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin()));
                        return;
                      }
                      a(17, false, localObject2);
                      return;
                    }
                    if ("ProfileService.SetUserInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      q(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                    if (!"AccostSvc.ClientMsg".equals(paramFromServiceMsg.getServiceCmd())) {
                      break;
                    }
                  } while (paramFromServiceMsg.getResultCode() != 1000);
                  paramToServiceMsg = (RespClientMsg)paramFromServiceMsg.getAttribute("result");
                } while ((paramToServiceMsg == null) || (1 != paramToServiceMsg.stMsg.eAccostType));
                a(22, true, localObject2);
                return;
                if ("AccostSvc.SvrMsg".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  if (paramFromServiceMsg.getResultCode() == 1000) {}
                  for (boolean bool = true;; bool = false)
                  {
                    a(29, bool, localObject2);
                    return;
                  }
                }
                if ("MobileQQ.SendPortraitDownloadVerifyCode".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  paramToServiceMsg = paramFromServiceMsg.extraData.getString("filekey");
                  ((Bundle)localObject2).putString("filekey", paramToServiceMsg);
                  if ((paramToServiceMsg != null) && (!"".equals(paramToServiceMsg)))
                  {
                    a(21, true, localObject2);
                    return;
                  }
                  a(21, false, localObject2);
                  return;
                }
                if ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  ((Bundle)localObject2).putString("uin", String.valueOf(paramToServiceMsg.extraData.getLong("lToUIN")));
                  if (paramFromServiceMsg.getResultCode() == 1000)
                  {
                    a(23, true, localObject2);
                    return;
                  }
                  a(23, false, localObject2);
                  return;
                }
                if ("MCardSvc.ReqGetFace".equals(paramFromServiceMsg.getServiceCmd()))
                {
                  p(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                  return;
                }
              } while ("PttCenterSvr.ReqBody".equals(paramFromServiceMsg.getServiceCmd()));
              if ("OidbSvc.0x490_100".equals(paramFromServiceMsg.getServiceCmd()))
              {
                e(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if ("OidbSvc.0x491_100".equals(paramFromServiceMsg.getServiceCmd()))
              {
                f(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
              {
                i(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if ("SQQzoneSvc.getPhotoWall".equals(paramFromServiceMsg.getServiceCmd()))
              {
                j(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if ("SQQzoneSvc.delPhotoWall".equals(paramFromServiceMsg.getServiceCmd()))
              {
                k(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (!"OidbSvc.0x480_9".equals(paramFromServiceMsg.getServiceCmd())) {
                break;
              }
            } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
            if (paramToServiceMsg.extraData.getBoolean("isGetLoginDays", false))
            {
              n(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
            {
              l(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (paramToServiceMsg.extraData.getBoolean("isGetActivateFriend", false))
            {
              r(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (paramToServiceMsg.extraData.getBoolean("isQidianExt", false))
            {
              v(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (paramToServiceMsg.extraData.getBoolean("isGetCalReactive", false))
            {
              o(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            h(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
            if (!"OidbSvc.0x4ff_9".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
          } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
          if (paramToServiceMsg.extraData.getBoolean("isSetLoginDays", false))
          {
            p(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
          {
            m(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getBoolean("isSetActivateFriend", false))
          {
            s(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getBoolean("calltabstate", false))
          {
            u(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getBoolean("isGetAntiLost"))
          {
            t(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getBoolean("isSetCalReactiveDays", false))
          {
            q(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        } while ("OidbSvc.0x5ea_2".equals(paramFromServiceMsg.getServiceCmd()));
        if ("OidbSvc.0x5eb_17".equals(paramFromServiceMsg.getServiceCmd()))
        {
          r(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
          return;
        }
        if ("QQMusicVipRingSvr.getringlist".equals(paramFromServiceMsg.getServiceCmd()))
        {
          s(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
          return;
        }
      } while ("OidbSvc.0x4ff_58".equals(paramFromServiceMsg.getServiceCmd()));
      if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("PubAccountSvc.get_detail_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"SQQShopFolderSvc.GetAcctBindPuin".equals(paramFromServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func getShoppingIsBind begins, curUin:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
      localSQQSHPClientReq.cuinlist.set(localArrayList);
      paramString = a("SQQShopFolderSvc.GetAcctBindPuin");
      paramString.putWupBuffer(localSQQSHPClientReq.toByteArray());
      b(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "func getShoppingIsBind ends");
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("CardHandler", 2, "func getShoppingIsBind ends,errInfo:" + paramString.getMessage());
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonecover.", 2, "getQzoneCover");
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.getCover");
    localToServiceMsg.addAttribute("uin", paramString);
    localToServiceMsg.addAttribute("flag", Integer.valueOf(paramInt));
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, byte paramByte, ArrayList paramArrayList1, byte[] paramArrayOfByte1, ArrayList paramArrayList2, ArrayList paramArrayList3, byte[] paramArrayOfByte2)
  {
    paramString = a("MCardSvc.ReqSetCard");
    paramString.extraData.putInt("eSubCmd", paramInt);
    paramString.extraData.putByte("bIsSingle", paramByte);
    paramString.extraData.putByteArray("vBackground", paramArrayOfByte1);
    paramString.extraData.putByteArray("vReqSetTemplate", paramArrayOfByte2);
    try
    {
      paramArrayOfByte1 = new ByteArrayOutputStream();
      paramArrayOfByte2 = new ObjectOutputStream(paramArrayOfByte1);
      paramArrayOfByte2.writeObject(paramArrayList1);
      paramArrayOfByte2.flush();
      paramString.extraData.putByteArray("vTagsID", paramArrayOfByte1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList2);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vDelTags", paramArrayList1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList3);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vAddTags", paramArrayList1.toByteArray());
      a(paramString);
      return;
    }
    catch (IOException paramArrayList1)
    {
      for (;;)
      {
        paramArrayList1.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("Q.profilecard.", 1, "modifyMusicPendantSettings " + paramInt1 + ":" + paramInt2);
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(58);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(13);
      localByteBuffer.putInt(Utils.a(Long.parseLong(paramString))).put((byte)0).putShort((short)1).putShort((short)paramInt1).putShort((short)2).putShort((short)paramInt2);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
      paramString = a("OidbSvc.0x4ff_58");
      paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
      paramString.setTimeout(30000L);
      b(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("Q.profilecard.", 1, "modifyMusicPendantSettings ex", paramString);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqGetFace");
    localToServiceMsg.extraData.putString("lUin", paramString);
    localToServiceMsg.extraData.putLong("lNextMid", paramLong);
    localToServiceMsg.extraData.putInt("iPageSize", paramInt);
    localToServiceMsg.extraData.putByteArray("strCookie", paramArrayOfByte);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "deleteLbsPortrait() uin = " + paramString);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqDelFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    localToServiceMsg.extraData.putLong("timestamp", paramLong);
    localToServiceMsg.extraData.putString("touin", paramString);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(localToServiceMsg);
  }
  
  public void a(String paramString, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setSelfNickname|nickName = " + paramString);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("nickname", paramString);
    a(paramCardObserver);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "getQzonePhotoWall uin:" + paramString1);
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.getPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("attachInfo", paramString2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqHYMakeFriendsCard");
    paramString1.extraData.putString("friendUin", paramString2);
    paramString1.extraData.putByte("bReqType", paramByte);
    paramString1.extraData.putInt("uFaceTimeStamp", paramInt);
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2)
  {
    a(paramString1, paramString2, paramInt1, paramLong1, paramByte, paramLong2, paramLong3, paramArrayOfByte1, paramString3, paramLong4, paramInt2, paramArrayOfByte2, 0L, false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
      paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      paramString1.extraData.putLong("selfUin", l1);
      paramString1.extraData.putLong("targetUin", l2);
      paramString1.extraData.putInt("comeFromType", paramInt1);
      paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
      paramString1.extraData.putByte("isFriend", paramByte);
      paramString1.extraData.putLong("troopCode", paramLong2);
      paramString1.extraData.putLong("troopUin", paramLong3);
      paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
      paramString1.extraData.putString("strSearchName", paramString3);
      paramString1.extraData.putLong("lGetControl", paramLong4);
      paramString1.extraData.putInt("EAddFriendSource", paramInt2);
      paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
      paramString1.extraData.putLong("tinyId", paramLong5);
      paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean);
      a(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "getSummayCard", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "delQzonePhotoWall");
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.delPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("photo_id", paramString2);
    localToServiceMsg.addAttribute("photo_time", Long.valueOf(paramLong));
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVoterList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.LikeIt");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("destUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("labelId", paramLong.longValue());
    a(localToServiceMsg);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "isQidianExt");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)40410));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isQidianExt", true);
      localBundle.putBoolean("isQidianSimple", paramBoolean);
      a(localArrayList, localBundle, paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "isQidianExt ex", paramString);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "uploadPhotoWall size:" + paramArrayList.size());
    }
    m();
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)paramList.next()).labelId);
      }
      paramList = a("SummaryCard.SetLabel");
      paramList.extraData.putSerializable("labels", (Serializable)localArrayList);
      a(paramList);
    }
  }
  
  public void a(Oidb_0x66b.ReqBody paramReqBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getSimpleNearbyMyTabCard");
    }
    paramReqBody = a("OidbSvc.0x66b", 1643, 0, paramReqBody.toByteArray());
    paramReqBody.extraData.putBoolean("req_pb_protocol_flag", true);
    paramReqBody.extraData.putBoolean("simpleMytabCard", true);
    a(paramReqBody);
  }
  
  public void a(short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setAntilostState open=" + paramShort);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(13);
      ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))).put((byte)0).putShort((short)1).putShort((short)40336).putShort((short)2).putShort(paramShort);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = a("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putShort("open", paramShort);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("isGetAntiLost", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "setAntilostState ex", localException);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i1 = 0;
    }
    ((ByteBuffer)localObject).put((byte)i1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x491_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_searchable", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "uploadAvatarResult|isSuc = " + paramBoolean);
    }
    String str = ProfileCardUtil.b();
    ProfileCardUtil.a(null);
    EntityManager localEntityManager;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject2 = (Setting)localEntityManager.a(Setting.class, paramString);
      if (localObject2 != null) {
        break label286;
      }
      localObject1 = new Setting();
      ((Setting)localObject1).uin = paramString;
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).bUsrType = 1;
      ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
      ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
      localEntityManager.a((Entity)localObject1);
    }
    for (;;)
    {
      localEntityManager.a();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((Setting)localObject1);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        FileUtils.d((String)localObject1);
      }
      localObject2 = ProfileCardUtil.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        FileUtils.d((String)localObject2);
      }
      ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        ImageUtil.a(null, str, (String)localObject1, 100, 100);
        FileUtils.d(str, (String)localObject2);
      }
      if (!TextUtils.isEmpty(str)) {
        FileUtils.d(str);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", paramString);
      a(8, paramBoolean, localObject1);
      return;
      label286:
      localObject1 = localObject2;
      if (((Setting)localObject2).bHeadType == 0)
      {
        ((Setting)localObject2).bHeadType = 1;
        ((Setting)localObject2).updateTimestamp = System.currentTimeMillis();
        ((Setting)localObject2).headImgTimestamp = (((Setting)localObject2).updateTimestamp / 1000L);
        localEntityManager.a((Entity)localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ToServiceMsg localToServiceMsg = a("MCardSvc.ReqSetCardSwitch");
    localToServiceMsg.extraData.putBoolean("modify_switch_for_near_people", paramBoolean1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramBoolean2) {}
    for (long l1 = 0L;; l1 = 1L)
    {
      localBundle.putLong("target_value", l1);
      a(localToServiceMsg);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqAddFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localToServiceMsg.extraData.putInt("timestamp", paramInt);
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    a(localToServiceMsg);
  }
  
  public void a(int[] paramArrayOfInt, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setCity");
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("city", paramArrayOfInt);
    a(paramCardObserver);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.ReqSummaryCard");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.ReqVoiceManage");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqHYMakeFriendsCard");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqSetCard");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.SetLabel");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.LikeIt");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqGetCardSwitch");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqSetCardSwitch");
      this.jdField_b_of_type_JavaUtilSet.add("VisitorSvc.ReqVote");
      this.jdField_b_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_b_of_type_JavaUtilSet.add("VisitorSvc.ReqGetVoterList");
      this.jdField_b_of_type_JavaUtilSet.add("VisitorSvc.ReqGetFavoriteList");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqFaceInfo");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqAddFace");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqUpdateIntro");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqDelFace");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.getGroupInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.GetSglUsrFullInfo");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.SetUserInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.ClientMsg");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.SvrMsg");
      this.jdField_b_of_type_JavaUtilSet.add("MobileQQ.SendPortraitDownloadVerifyCode");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqPicSafetyCheck");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqGetFace");
      this.jdField_b_of_type_JavaUtilSet.add("PttCenterSvr.ReqBody");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x490_100");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x491_100");
      this.jdField_b_of_type_JavaUtilSet.add("SQQzoneSvc.getCover");
      this.jdField_b_of_type_JavaUtilSet.add("SQQzoneSvc.getPhotoWall");
      this.jdField_b_of_type_JavaUtilSet.add("SQQzoneSvc.delPhotoWall");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x480_9");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5ea_2");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5ea_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5ea_4");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_17");
      this.jdField_b_of_type_JavaUtilSet.add("QQMusicVipRingSvr.getringlist");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_58");
      this.jdField_b_of_type_JavaUtilSet.add("PubAccountSvc.get_detail_info");
      this.jdField_b_of_type_JavaUtilSet.add("SQQShopFolderSvc.GetAcctBindPuin");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x66b");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b(int paramInt)
  {
    NearbyCmdHelper.a(this, paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new pus(this, paramBundle));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo begins, data:" + paramObject + ",res:" + paramFromServiceMsg);
    }
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label92;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo, NOT success.");
      return;
    }
    label92:
    paramToServiceMsg = new qqshop.SQQSHPClientRsp();
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i1 = paramToServiceMsg.retcode.get();
        if (i1 != 0) {
          break label367;
        }
        paramToServiceMsg = paramToServiceMsg.bindlist.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
          break label401;
        }
        l1 = ((qqshop.SQQSHPAccoutRelation)paramToServiceMsg.get(0)).puin.get();
        l2 = ((qqshop.SQQSHPAccoutRelation)paramToServiceMsg.get(0)).binduin.get();
        paramFromServiceMsg = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(l2));
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null)
        {
          paramToServiceMsg = new ProfileShoppingPhotoInfo();
          paramToServiceMsg.seqNo = 0;
          paramToServiceMsg.uin = Long.toString(l2);
          paramToServiceMsg.setStatus(1000);
        }
        paramToServiceMsg.bindShoppingNo = Long.toString(l1);
        ProfileShoppingPhotoInfo.savePhotoInfo2DB(paramToServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        a(67, true, new Object[] { Integer.valueOf(paramToServiceMsg.seqNo), Long.valueOf(l1), Long.valueOf(l2) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, pUin:" + l1 + ",bindUin:" + l2);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, errInfo:" + paramToServiceMsg.getMessage());
      return;
      label367:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, retCode:" + i1);
      return;
      label401:
      long l1 = 0L;
      long l2 = 0L;
    }
  }
  
  public void b(String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.i = paramString;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    localTransferRequest.jdField_a_of_type_Long = 0L;
    localTransferRequest.b = 35;
    localTransferRequest.jdField_a_of_type_JavaLangString = "actProfileCoverPicUpload";
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(localTransferRequest);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    long l1 = 0L;
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramString2);
        ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l1));
        ((oidb_0x5eb.ReqBody)localObject).uint32_req_music_ring_visible.set(1);
        ((oidb_0x5eb.ReqBody)localObject).uint32_req_music_ring_autoplay.set(1);
        ((oidb_0x5eb.ReqBody)localObject).uint32_req_music_ring_redpoint.set(1);
        localObject = a("OidbSvc.0x5eb_17", 1515, 17, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
        ((ToServiceMsg)localObject).extraData.putString("targetUin", paramString2);
        ((ToServiceMsg)localObject).extraData.putString("selfUin", paramString1);
        b((ToServiceMsg)localObject);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("Q.profilecard.", 1, "sendRequestUpdateMusicPendant() error", paramString1);
        return;
      }
      QLog.w("Q.profilecard.", 1, "sendRequestUpdateMusicPendant() targetUin is empty!");
    }
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetFavoriteList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  /* Error */
  protected void b(String paramString, List paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +82 -> 83
    //   4: aload_2
    //   5: invokeinterface 456 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 544	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 1042	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   20: invokevirtual 1048	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 3291	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 3294	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   35: aload_2
    //   36: invokeinterface 621 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 626 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 630 1 0
    //   58: checkcast 892	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 2294	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 1130	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 3291	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   76: invokevirtual 3312	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   79: aload_1
    //   80: invokevirtual 1590	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 3291	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   88: invokevirtual 3311	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   91: aload_1
    //   92: invokevirtual 3291	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   95: invokevirtual 3312	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   98: aload_1
    //   99: invokevirtual 1590	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 3291	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   108: invokevirtual 3312	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   111: aload_1
    //   112: invokevirtual 1590	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	CardHandler
    //   0	117	1	paramString	String
    //   0	117	2	paramList	List
    // Exception table:
    //   from	to	target	type
    //   28	42	67	java/lang/Exception
    //   42	64	67	java/lang/Exception
    //   84	91	67	java/lang/Exception
    //   28	42	103	finally
    //   42	64	103	finally
    //   68	72	103	finally
    //   84	91	103	finally
  }
  
  public void b(List paramList)
  {
    FileUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f() + "_todayVoters", paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    short s1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setPCActiveState OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort((short)40494).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isGetLoginDays", false);
          ((ToServiceMsg)localObject).extraData.putBoolean("pcActiveState", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setPCActiveState ex", localException);
      }
      s1 = 0;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setCallTabState open=" + paramBoolean1);
    }
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "00000");
        int i2 = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(19);
        long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean1 == true)
        {
          s1 = 0;
          ByteBuffer localByteBuffer = ((ByteBuffer)localObject2).putInt(Utils.a(l1)).put((byte)0).putShort((short)2).putShort((short)40319).putShort((short)2).putShort(s1).putShort((short)42060).putShort((short)2);
          if (i2 >= 2) {
            continue;
          }
          localByteBuffer.putShort((short)i1);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean1);
          ((ToServiceMsg)localObject2).extraData.putBoolean("calltabstate", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        short s1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setCallTabState ex", localException);
      }
      s1 = 1;
      continue;
      i1 = 1;
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo begins, data:" + paramObject + ",res:" + paramFromServiceMsg);
    }
    if ((paramFromServiceMsg == null) || (paramObject == null)) {}
    label92:
    String str2;
    do
    {
      for (;;)
      {
        return;
        if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label92;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CardHandler", 2, "func handleShoppingCardInfo, NOT success.");
          return;
        }
        paramFromServiceMsg = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          i1 = ((mobileqq_mp.RetInfo)paramFromServiceMsg.ret_info.get()).ret_code.get();
          if ((i1 != 0) || (!paramFromServiceMsg.name.has()) || (!paramFromServiceMsg.unified_account_descrpition.has())) {
            break label536;
          }
          paramObject = paramFromServiceMsg.name.get();
          str2 = paramFromServiceMsg.unified_account_descrpition.get();
          if ((!TextUtils.isEmpty((CharSequence)paramObject)) && (!TextUtils.isEmpty(str2))) {
            break label256;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, data is nullll.");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, errInfo:" + paramToServiceMsg.getMessage() + ",response.unified_account_descrpition.has():" + paramFromServiceMsg.unified_account_descrpition.has());
    return;
    label256:
    int i1 = paramFromServiceMsg.certified_grade.get();
    int i2 = paramFromServiceMsg.account_flag.get();
    int i3 = paramFromServiceMsg.follow_type.get();
    List localList = ProfileShoppingPhotoInfo.parseShoppingPhotoJson(str2);
    String str1 = (String)paramToServiceMsg.getAttribute("uin");
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo, ready to notify UI. shopName:" + (String)paramObject + ",certifiedGrade:" + i1 + ",uin:" + str1 + ",accountFlag:" + i2 + "followType:" + i3 + ",picJson:" + str2 + ",picList.size:" + localList.size());
    }
    a(66, true, new Object[] { paramObject, localList, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i1) });
    paramToServiceMsg = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1);
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = new ProfileShoppingPhotoInfo();
      paramToServiceMsg.uin = str1;
      paramToServiceMsg.setStatus(1000);
    }
    for (;;)
    {
      paramToServiceMsg.certifiedGrade = i1;
      paramToServiceMsg.accountFlag = i2;
      paramToServiceMsg.followType = i3;
      paramToServiceMsg.seqNo = paramFromServiceMsg.seqno.get();
      paramToServiceMsg.shopName = ((String)paramObject);
      paramToServiceMsg.picByteData = ProfileShoppingPhotoInfo.converPhoto2RawData(localList);
      ProfileShoppingPhotoInfo.savePhotoInfo2DB(paramToServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      label536:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, errCode:" + i1 + ",no data is obtained.");
      return;
    }
  }
  
  public void c(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "retry upload size:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " path:" + this.n);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!TextUtils.isEmpty(this.n)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.n);
      }
      m();
      return;
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "QQMusicVipRingSvr.getringlist");
    localToServiceMsg.extraData.putString("targetUin", paramString2);
    localToServiceMsg.extraData.putString("selfUin", paramString1);
    paramString1 = "pn=0" + "&idx=0";
    paramString1 = paramString1 + "&len=1000";
    localToServiceMsg.putWupBuffer((paramString1 + "&uin=" + paramString2).getBytes());
    b(localToServiceMsg);
  }
  
  public void c(List paramList)
  {
    Object localObject = FileUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f() + "_todayVoters");
    if ((localObject != null) && ((localObject instanceof ArrayList)))
    {
      localObject = (List)localObject;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        paramList.addAll((Collection)localObject);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    short s1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setLoginDaysSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetLoginDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
      }
      s1 = 0;
    }
  }
  
  public void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)20037));
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)40319));
    localArrayList.add(Short.valueOf((short)41782));
    localArrayList.add(Short.valueOf((short)40556));
    localArrayList.add(Short.valueOf((short)41813));
    localArrayList.add(Short.valueOf((short)27055));
    localArrayList.add(Short.valueOf((short)41760));
    localArrayList.add(Short.valueOf((short)42048));
    localArrayList.add(Short.valueOf((short)27034));
    localArrayList.add(Short.valueOf((short)41783));
    localArrayList.add(Short.valueOf((short)40336));
    localArrayList.add(Short.valueOf((short)42003));
    localArrayList.add(Short.valueOf((short)41999));
    localArrayList.add(Short.valueOf((short)42980));
    localArrayList.add(Short.valueOf((short)27059));
    localArrayList.add(Short.valueOf((short)40517));
    localArrayList.add(Short.valueOf((short)41993));
    localArrayList.add(Short.valueOf((short)42051));
    localArrayList.add(Short.valueOf((short)40525));
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1) != 1) {
      localArrayList.add(Short.valueOf((short)40496));
    }
    if (((Integer)NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue() != 1) {
      localArrayList.add(Short.valueOf((short)41987));
    }
    localArrayList.add(Short.valueOf((short)41998));
    localArrayList.add(Short.valueOf((short)40494));
    localArrayList.add(Short.valueOf((short)42034));
    a(localArrayList, null);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetSimpleNearbyMyTab, result=" + i1);
    }
    if (i1 == 0)
    {
      if (paramToServiceMsg.stPansocialInfo.has())
      {
        i1 = ((Oidb_0x66b.RspPansocialInfo)paramToServiceMsg.stPansocialInfo.get()).uint32_charmlevel.get();
        ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(i1);
      }
      return;
    }
    a(65, false, null);
  }
  
  public void d(boolean paramBoolean)
  {
    short s1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setCalReactiveSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort(this.jdField_c_of_type_Short).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetCalReactiveDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setCalReactiveSwitch ex", localException);
      }
      s1 = 0;
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)27037));
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)24008));
    localArrayList.add(Short.valueOf((short)24002));
    localArrayList.add(Short.valueOf((short)20043));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)20011));
    localArrayList.add(Short.valueOf((short)20019));
    localArrayList.add(Short.valueOf((short)20021));
    localArrayList.add(Short.valueOf((short)20037));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("reqFromDetailActivity", true);
    a(localArrayList, localBundle);
  }
  
  public void e(boolean paramBoolean)
  {
    short s1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort((short)40505).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetActivateFriend", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch ex", localException);
      }
      s1 = 1;
    }
  }
  
  public void f()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject = ByteBuffer.allocate(29);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)11);
    ((ByteBuffer)localObject).putShort((short)40313);
    ((ByteBuffer)localObject).putShort((short)40314);
    ((ByteBuffer)localObject).putShort((short)40315);
    ((ByteBuffer)localObject).putShort((short)40316);
    ((ByteBuffer)localObject).putShort((short)40317);
    ((ByteBuffer)localObject).putShort((short)40318);
    ((ByteBuffer)localObject).putShort((short)40320);
    ((ByteBuffer)localObject).putShort((short)41981);
    ((ByteBuffer)localObject).putShort((short)40335);
    ((ByteBuffer)localObject).putShort((short)40527);
    ((ByteBuffer)localObject).putShort((short)40526);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x480_9");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
    b((ToServiceMsg)localObject);
  }
  
  public void h()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getPCActiveState");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)40494));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("pcActiveState", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getPCActiveState ex", localException);
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.jdField_b_of_type_Short));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetLoginDays", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getCalReactiveSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.jdField_c_of_type_Short));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetCalReactive", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getCalReactiveSwitch ex", localException);
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getActivateFriendSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)40505));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetActivateFriend", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getActivateFriendSwitch ex", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\CardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */