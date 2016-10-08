package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vas.IndividuationManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import pvj;
import pvk;
import pvl;
import pvm;

public class ClubContentUpdateHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "ClubContentUpdateHandler";
  public static final int b = 2;
  public static final String b = "ClubContentUpdate.Req";
  public static final int c = 3;
  public static final String c = "last_pull_club_content_update_time";
  public static final int d = 4;
  public static final int e = 6;
  public static final int f = 7;
  public static final int g = 8;
  public static final int h = 9;
  public static final int i = 10;
  public static final int j = 105;
  public static final int k = 11;
  public static final int l = 18;
  public static final int m = 112;
  public static final int n = 201;
  public static final int o = 202;
  public static final int p = 203;
  public static final int q = 301;
  public static final int r = 104;
  public static final int s = 113;
  public static final int t = 302;
  public static final int u = 401;
  public static final int v = 5;
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  
  ClubContentUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new pvm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected static ClubContentUpdateInfoPb.ReqAppInfo a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramTaskInfo.f);
    localReqItemInfo.uint_version.set(ClubContentJsonTask.a(paramQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.e));
    localArrayList.add(localReqItemInfo);
    paramQQAppInterface = new ClubContentUpdateInfoPb.ReqAppInfo();
    paramQQAppInterface.uint_appid.set(paramInt);
    paramQQAppInterface.rpt_msg_reqiteminfo.set(localArrayList);
    paramQQAppInterface.setHasFlag(true);
    return paramQQAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramString, paramInt1, "", paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "small emotion has update info.");
    }
    ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + paramString, paramInt1);
  }
  
  private void a(int paramInt, ClubContentJsonTask.TaskInfo paramTaskInfo)
  {
    if (Math.abs(paramInt - ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.e)) > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "New version json found!");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null) {
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46));
      }
      File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.b);
      Bundle localBundle = new Bundle();
      localBundle.putInt("version", paramInt);
      localBundle.putString("json_name", paramTaskInfo.e);
      paramTaskInfo = new DownloadTask(paramTaskInfo.c, localFile);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramTaskInfo, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject1 = paramQQAppInterface.a();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("6.5.5.2880");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("individuation_mainpage_config2");
    int i1 = paramQQAppInterface.getApplication().getSharedPreferences("clubContentVersion", 0).getInt("IndividuationConfigJsonVersion4", 0);
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i1);
    localArrayList2.add(localObject2);
    localObject2 = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).uint_appid.set(302);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).rpt_msg_reqiteminfo.set(localArrayList2);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).setHasFlag(true);
    localArrayList1.add(localObject2);
    localReqBody.rpt_msg_reqappinfo.set(localArrayList1);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "checkUpdateIndividuationMainpage, localVersion=" + i1);
    }
    localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
    paramQQAppInterface.a((ToServiceMsg)localObject1);
  }
  
  private void a(BubbleManager paramBubbleManager, JSONArray paramJSONArray, String paramString, int paramInt)
  {
    try
    {
      int i2 = Integer.parseInt(paramString.substring(paramString.indexOf("_") + 1));
      int i1;
      if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
        i1 = 0;
      }
      for (;;)
      {
        if (i1 < paramJSONArray.length())
        {
          paramString = paramJSONArray.getJSONObject(i1);
          if ((paramString.getInt("id") == i2) && (paramInt > paramString.getInt("version"))) {
            paramBubbleManager.a(i2, "version.json");
          }
        }
        else
        {
          return;
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception paramBubbleManager)
    {
      paramBubbleManager.printStackTrace();
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, Map paramMap, boolean paramBoolean)
  {
    if (paramString1.equals(ClubContentJsonTask.e.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEmoticonWordingTask!");
      }
      a(paramInt1, ClubContentJsonTask.e, paramBoolean);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramString1.equals(ClubContentJsonTask.a.f)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEPPromotionTask!");
            }
            paramInt2 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.a.e);
          } while (paramInt1 <= paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
          ClubContentJsonTask.a(MobileQQ.getContext(), ClubContentJsonTask.a.e, paramInt2);
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("recommendEmotion_sp_name", 0);
          ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a();
          paramString1.edit().putLong("last_get_recommendemotion_time_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), System.currentTimeMillis()).commit();
          return;
          if (!paramString1.equals(ClubContentJsonTask.f.f)) {
            break;
          }
          paramInt2 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.f.e);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEmoticonKeywordTask! version: " + paramInt1 + " , localVersion: " + paramInt2);
          }
        } while (paramInt1 <= paramInt2);
        ClubContentJsonTask.f.c = IndividuationUrlHelper.a("emoticonKeyword");
        ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.f, paramInt1, true);
        return;
        if (!paramString1.contains("_json")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, name.contains(EmosmConstant.EMOTICON_JSON_UPDATE_REQUEST_SUFFIX!");
        }
      } while (!EmoticonUtils.a(paramInt2));
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b(paramString1.replace("_json", "").trim(), paramInt1, paramString2, paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, update emoji package!");
      }
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramString1, paramInt1, paramString2, paramInt2);
      paramMap.put(paramString1, Integer.valueOf(paramInt2));
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentUpdateHandler", 2, "emotion has update info.");
  }
  
  private void a(String paramString, int paramInt, JSONArray paramJSONArray, AvatarPendantManager paramAvatarPendantManager, HashMap paramHashMap)
  {
    int i1 = 0;
    try
    {
      while (i1 < paramJSONArray.length())
      {
        paramAvatarPendantManager = paramJSONArray.getJSONObject(i1);
        if ((paramAvatarPendantManager.getString("id").equals(paramString)) && (paramInt > paramAvatarPendantManager.getInt("version"))) {
          paramHashMap.put(paramString, Integer.valueOf(paramInt));
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a(int paramInt, ClubContentJsonTask.TaskInfo paramTaskInfo, boolean paramBoolean)
  {
    int i1 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.e);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "updateResJson name = " + paramTaskInfo.f + " localVersion = " + i1 + " version = " + paramInt);
    }
    if (paramInt > i1)
    {
      ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTaskInfo, paramInt, paramBoolean);
      return true;
    }
    return false;
  }
  
  private void b() {}
  
  private void b(int paramInt)
  {
    try
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("clubContentVersion", 0).getInt("IndividuationConfigJsonVersion4", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "checkIndividMainPageJson, localVersion=" + i1 + ", version=" + paramInt);
      }
      IndividuationManager localIndividuationManager = (IndividuationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106);
      if ((paramInt > i1) || (!localIndividuationManager.a())) {
        localIndividuationManager.a(paramInt);
      }
      return;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject = paramQQAppInterface.a();
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("6.5.5.2880");
      localReqBody.uint_uin.set(Long.parseLong((String)localObject));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(a(paramQQAppInterface, ClubContentJsonTask.m, 4));
      localReqBody.rpt_msg_reqappinfo.set(localArrayList);
      localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "ClubContentUpdate.Req");
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.a((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("ClubContentUpdateHandler", 2, "checkUpdateAvatarPendantMarket go");
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject1 = paramQQAppInterface.a();
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("6.5.5.2880");
      localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
      ArrayList localArrayList1 = new ArrayList();
      int i1 = paramQQAppInterface.a().getSharedPreferences("sigResUpt", 0).getInt("sigTplCfgVer", 0);
      ArrayList localArrayList2 = new ArrayList();
      Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("signature_json");
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i1);
      localArrayList2.add(localObject2);
      localObject2 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).uint_appid.set(8);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).rpt_msg_reqiteminfo.set(localArrayList2);
      localArrayList1.add(localObject2);
      localReqBody.rpt_msg_reqappinfo.set(localArrayList1);
      localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "ClubContentUpdate.Req");
      ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.a((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i("ClubContentUpdateHandler", 2, "checkUpdateSigTpl called.");
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject1 = paramQQAppInterface.a();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("6.5.5.2880");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
    int i1 = ClubContentJsonTask.a();
    Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("action_android_json_v3");
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i1);
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(201);
    localReqAppInfo.rpt_msg_reqiteminfo.add((MessageMicro)localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localReqAppInfo);
    localReqBody.rpt_msg_reqappinfo.set((List)localObject2);
    localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
    paramQQAppInterface.a((ToServiceMsg)localObject1);
    QLog.i("ClubContentUpdateHandler", 1, "checkApolloPanelJsonVer local ver: " + i1);
  }
  
  private void o(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleGetIndividuationUrlsResponse, name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      if (str1.equals(ClubContentJsonTask.b.f)) {
        a(i1, ClubContentJsonTask.b, false);
      }
    }
  }
  
  private void p(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handlePersonalCard, name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      if (str1.equals(ClubContentJsonTask.c.f)) {
        a(i1, ClubContentJsonTask.c, false);
      }
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    Object localObject = ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a();
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "localBubbles-length" + ((JSONArray)localObject).length());
    }
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int i1 = 0;
      for (;;)
      {
        if (i1 >= ((JSONArray)localObject).length()) {
          break label223;
        }
        try
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
          ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set("bubble_" + localJSONObject.getString("id"));
          localReqItemInfo.uint_version.set(localJSONObject.getInt("version"));
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "bubble_name:" + localJSONObject.getString("id") + " bubble_version:" + localJSONObject.getInt("version"));
          }
          localArrayList.add(localReqItemInfo);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        i1 += 1;
      }
    }
    label223:
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(2);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return (ClubContentUpdateInfoPb.ReqAppInfo)localObject;
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a(ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramTaskInfo.f);
    localReqItemInfo.uint_version.set(ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.e));
    localArrayList.add(localReqItemInfo);
    paramTaskInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    paramTaskInfo.uint_appid.set(paramInt);
    paramTaskInfo.rpt_msg_reqiteminfo.set(localArrayList);
    paramTaskInfo.setHasFlag(true);
    return paramTaskInfo;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("6.5.5.2880");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(c());
    localArrayList.add(b());
    localArrayList.add(d());
    localArrayList.add(b(ClubContentJsonTask.d, 7));
    localArrayList.add(b(ClubContentJsonTask.f, 1));
    localArrayList.add(a());
    localArrayList.add(b(ClubContentJsonTask.h, 3));
    localArrayList.add(b(ClubContentJsonTask.o, 18));
    localArrayList.add(e());
    localArrayList.add(a(ClubContentJsonTask.i, 105));
    localArrayList.add(b(ClubContentJsonTask.j, 11));
    localArrayList.add(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.m, 4));
    localArrayList.add(b(ClubContentJsonTask.c, 301));
    localArrayList.add(b(ClubContentJsonTask.b, 401));
    Object localObject2 = (IndividualRedPacketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
    if ((localObject2 != null) && (((IndividualRedPacketManager)localObject2).b()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "getCommonUpdateReqInfo_RedPacket.");
      }
      localArrayList.add(b(ClubContentJsonTask.k, 112));
    }
    int i1;
    if (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
    {
      i1 = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
      if (1 == i1)
      {
        localObject2 = f();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
        localObject2 = g();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
    }
    for (;;)
    {
      localArrayList.add(b(ClubContentJsonTask.l, 113));
      localArrayList.add(b(ClubContentJsonTask.n, 5));
      localReqBody.rpt_msg_reqappinfo.set(localArrayList);
      localReqBody.setHasFlag(true);
      localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "ClubContentUpdate.Req");
      ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
      b((ToServiceMsg)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - l1) + "ms");
      }
      return;
      QLog.d("ClubContentUpdateHandler", 1, "apollo status: " + i1);
      continue;
      if (FileUtil.a(ApolloUtil.c)) {
        ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      QLog.d("ClubContentUpdateHandler", 1, "ApolloFunc close...");
    }
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("sigResUpt", 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    if (paramInt > ((SharedPreferences)localObject).getInt("sigTplCfgVerTemp", 0))
    {
      localEditor.putBoolean("sigTplUptFlag", true);
      localEditor.putInt("sigTplCfgVerTemp", paramInt);
      if (Build.VERSION.SDK_INT > 8) {
        break label97;
      }
      localEditor.commit();
    }
    for (;;)
    {
      localObject = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
      if (localObject != null) {
        ((SignatureManager)localObject).a(false, false);
      }
      return;
      label97:
      localEditor.apply();
    }
  }
  
  public void a(Context paramContext)
  {
    int i1 = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getString("qvip_res_push_cfg_txt.", "");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).getJSONArray("data");
        if (i1 >= ((JSONArray)localObject).length()) {
          continue;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
        String str = localJSONObject.getString("filename");
        if (!ClubContentJsonTask.i.b.equals(str)) {
          break label173;
        }
        localObject = localJSONObject.getString("version");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        i1 = Integer.parseInt((String)localObject);
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label172;
        }
        QLog.e("ClubContentUpdateHandler", 2, "Parse QVIP_RES_PUSH_CFG_TXT failed:" + paramContext.toString());
        return;
        i1 = -1;
        if (i1 != -1) {
          continue;
        }
      }
      if (ClubContentJsonTask.a(paramContext, ClubContentJsonTask.i.e) != i1)
      {
        a(i1, ClubContentJsonTask.i);
        return;
      }
      label172:
      return;
      label173:
      i1 += 1;
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 10
    //   8: iconst_2
    //   9: ldc_w 730
    //   12: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   19: iload_3
    //   20: ldc -94
    //   22: invokestatic 735	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;ILjava/lang/String;)V
    //   25: invokestatic 698	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: ldc_w 700
    //   31: iconst_0
    //   32: invokevirtual 410	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   35: invokeinterface 421 1 0
    //   40: ldc_w 702
    //   43: aload_2
    //   44: invokeinterface 738 3 0
    //   49: invokeinterface 440 1 0
    //   54: pop
    //   55: new 371	org/json/JSONObject
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 707	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   63: ldc_w 709
    //   66: invokevirtual 713	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   69: astore_2
    //   70: iconst_0
    //   71: istore 8
    //   73: aload_2
    //   74: invokevirtual 363	org/json/JSONArray:length	()I
    //   77: istore 9
    //   79: iload 8
    //   81: iload 9
    //   83: if_icmpge +1301 -> 1384
    //   86: aload_2
    //   87: iload 8
    //   89: invokevirtual 367	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   92: astore 4
    //   94: aload 4
    //   96: ldc -31
    //   98: invokevirtual 373	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   101: istore 9
    //   103: aload 4
    //   105: ldc_w 369
    //   108: invokevirtual 373	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   111: istore 10
    //   113: aload 4
    //   115: ldc_w 715
    //   118: invokevirtual 496	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 4
    //   123: aload 4
    //   125: ifnonnull +1260 -> 1385
    //   128: return
    //   129: getstatic 621	com/tencent/mobileqq/vas/ClubContentJsonTask:i	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   132: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   135: aload 4
    //   137: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifeq +1403 -> 1543
    //   143: aload_0
    //   144: iload 9
    //   146: getstatic 621	com/tencent/mobileqq/vas/ClubContentJsonTask:i	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   149: invokespecial 722	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;)V
    //   152: goto +1391 -> 1543
    //   155: aload_1
    //   156: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   159: invokevirtual 118	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   162: new 178	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   169: ldc -75
    //   171: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 4
    //   176: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 125	com/tencent/mobileqq/vas/ClubContentJsonTask:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   185: istore 10
    //   187: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +52 -> 242
    //   193: ldc 10
    //   195: iconst_4
    //   196: new 178	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 740
    //   206: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 4
    //   211: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 742
    //   217: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: iload 9
    //   222: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: ldc_w 744
    //   228: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload 10
    //   233: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: iload 10
    //   244: iload 9
    //   246: if_icmpge -117 -> 129
    //   249: aload_0
    //   250: iload 9
    //   252: iconst_1
    //   253: aload 4
    //   255: invokespecial 746	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(IILjava/lang/String;)V
    //   258: goto -129 -> 129
    //   261: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +12 -> 276
    //   267: ldc 10
    //   269: iconst_2
    //   270: ldc_w 748
    //   273: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: aload 4
    //   279: iload 9
    //   281: ldc -94
    //   283: iconst_1
    //   284: new 498	java/util/HashMap
    //   287: dup
    //   288: invokespecial 749	java/util/HashMap:<init>	()V
    //   291: iconst_1
    //   292: invokespecial 751	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(Ljava/lang/String;ILjava/lang/String;ILjava/util/Map;Z)V
    //   295: goto -166 -> 129
    //   298: aload_1
    //   299: bipush 43
    //   301: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   304: checkcast 377	com/tencent/mobileqq/bubble/BubbleManager
    //   307: astore 5
    //   309: aload_0
    //   310: aload 5
    //   312: aload 5
    //   314: invokevirtual 591	com/tencent/mobileqq/bubble/BubbleManager:a	()Lorg/json/JSONArray;
    //   317: aload 4
    //   319: iload 9
    //   321: invokespecial 753	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(Lcom/tencent/mobileqq/bubble/BubbleManager;Lorg/json/JSONArray;Ljava/lang/String;I)V
    //   324: goto -195 -> 129
    //   327: aload 4
    //   329: getstatic 615	com/tencent/mobileqq/vas/ClubContentJsonTask:h	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   332: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   335: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq -209 -> 129
    //   341: aload_0
    //   342: iload 9
    //   344: getstatic 615	com/tencent/mobileqq/vas/ClubContentJsonTask:h	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   347: iconst_1
    //   348: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   351: pop
    //   352: goto -223 -> 129
    //   355: aload 4
    //   357: getstatic 617	com/tencent/mobileqq/vas/ClubContentJsonTask:o	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   360: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   363: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq -237 -> 129
    //   369: aload_0
    //   370: iload 9
    //   372: getstatic 617	com/tencent/mobileqq/vas/ClubContentJsonTask:o	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   375: iconst_1
    //   376: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   379: pop
    //   380: goto -251 -> 129
    //   383: aload_1
    //   384: bipush 45
    //   386: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   389: checkcast 755	com/tencent/mobileqq/vas/AvatarPendantManager
    //   392: astore 5
    //   394: aload 5
    //   396: invokevirtual 757	com/tencent/mobileqq/vas/AvatarPendantManager:b	()Lorg/json/JSONArray;
    //   399: astore 6
    //   401: new 498	java/util/HashMap
    //   404: dup
    //   405: invokespecial 749	java/util/HashMap:<init>	()V
    //   408: astore 7
    //   410: aload_0
    //   411: aload 4
    //   413: iload 9
    //   415: aload 6
    //   417: aload 5
    //   419: aload 7
    //   421: invokespecial 759	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(Ljava/lang/String;ILorg/json/JSONArray;Lcom/tencent/mobileqq/vas/AvatarPendantManager;Ljava/util/HashMap;)V
    //   424: aload 5
    //   426: aload 7
    //   428: aconst_null
    //   429: invokevirtual 762	com/tencent/mobileqq/vas/AvatarPendantManager:a	(Ljava/util/HashMap;Ljava/util/ArrayList;)V
    //   432: goto -303 -> 129
    //   435: aload 4
    //   437: getstatic 517	com/tencent/mobileqq/vas/ClubContentJsonTask:m	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   440: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   443: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   446: ifeq -317 -> 129
    //   449: aload_0
    //   450: iload 9
    //   452: getstatic 517	com/tencent/mobileqq/vas/ClubContentJsonTask:m	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   455: iconst_1
    //   456: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   459: pop
    //   460: getstatic 765	com/tencent/mobileqq/utils/AvatarPendantUtil:b	Ljava/lang/String;
    //   463: invokestatic 769	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   466: new 178	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   473: getstatic 774	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   476: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc_w 776
    //   482: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 769	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   491: goto -362 -> 129
    //   494: getstatic 609	com/tencent/mobileqq/vas/ClubContentJsonTask:d	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   497: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   500: aload 4
    //   502: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   505: ifeq -376 -> 129
    //   508: aload_0
    //   509: iload 9
    //   511: getstatic 609	com/tencent/mobileqq/vas/ClubContentJsonTask:d	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   514: iconst_1
    //   515: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   518: pop
    //   519: goto -390 -> 129
    //   522: ldc 10
    //   524: iconst_1
    //   525: new 178	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 778
    //   535: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 4
    //   540: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: ldc_w 780
    //   546: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: iload 9
    //   551: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload_1
    //   561: sipush 152
    //   564: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   567: checkcast 635	com/tencent/mobileqq/apollo/ApolloManager
    //   570: astore 5
    //   572: aload_1
    //   573: invokevirtual 405	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   576: invokestatic 638	com/tencent/mobileqq/apollo/ApolloManager:a	(Landroid/content/Context;)Z
    //   579: ifeq +43 -> 622
    //   582: aload 5
    //   584: ifnull +38 -> 622
    //   587: iconst_1
    //   588: aload 5
    //   590: aload_1
    //   591: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   594: invokevirtual 640	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)I
    //   597: if_icmpne +25 -> 622
    //   600: ldc_w 533
    //   603: aload 4
    //   605: invokestatic 783	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   608: ifeq -479 -> 129
    //   611: aload_0
    //   612: aload 4
    //   614: iload 9
    //   616: invokevirtual 785	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(Ljava/lang/String;I)V
    //   619: goto -490 -> 129
    //   622: ldc 10
    //   624: iconst_1
    //   625: new 178	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 778
    //   635: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload 4
    //   640: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: ldc_w 780
    //   646: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: iload 9
    //   651: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   654: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: goto -531 -> 129
    //   663: ldc 10
    //   665: iconst_1
    //   666: new 178	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   673: ldc_w 787
    //   676: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload 4
    //   681: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: ldc_w 789
    //   687: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: iload 9
    //   692: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: aload_1
    //   702: sipush 152
    //   705: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   708: checkcast 635	com/tencent/mobileqq/apollo/ApolloManager
    //   711: astore 5
    //   713: aload_1
    //   714: invokevirtual 405	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   717: invokestatic 638	com/tencent/mobileqq/apollo/ApolloManager:a	(Landroid/content/Context;)Z
    //   720: ifeq +141 -> 861
    //   723: aload 5
    //   725: ifnull +136 -> 861
    //   728: iconst_1
    //   729: aload 5
    //   731: aload_1
    //   732: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   735: invokevirtual 640	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)I
    //   738: if_icmpne +123 -> 861
    //   741: aload 4
    //   743: invokestatic 357	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   746: istore 10
    //   748: aload 5
    //   750: iconst_1
    //   751: iload 10
    //   753: invokevirtual 792	com/tencent/mobileqq/apollo/ApolloManager:a	(II)J
    //   756: ldc2_w 793
    //   759: ldiv
    //   760: lstore 11
    //   762: lload 11
    //   764: iload 9
    //   766: i2l
    //   767: lcmp
    //   768: ifeq -639 -> 129
    //   771: aload_1
    //   772: aload_1
    //   773: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   776: aconst_null
    //   777: iload 10
    //   779: aconst_null
    //   780: iconst_m1
    //   781: iconst_m1
    //   782: iconst_1
    //   783: invokestatic 799	com/tencent/mobileqq/apollo/store/ApolloResDownloader:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;I[IIIZ)V
    //   786: ldc 10
    //   788: iconst_1
    //   789: new 178	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   796: ldc_w 801
    //   799: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload 4
    //   804: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: ldc_w 803
    //   810: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: lload 11
    //   815: invokevirtual 656	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   818: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   824: goto -695 -> 129
    //   827: astore 5
    //   829: ldc 10
    //   831: iconst_2
    //   832: new 178	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   839: ldc_w 805
    //   842: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload 4
    //   847: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: aload 5
    //   855: invokestatic 808	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   858: goto -729 -> 129
    //   861: ldc 10
    //   863: iconst_1
    //   864: ldc_w 810
    //   867: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   870: goto -741 -> 129
    //   873: ldc 10
    //   875: iconst_1
    //   876: new 178	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   883: ldc_w 812
    //   886: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload 4
    //   891: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: ldc_w 789
    //   897: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: iload 9
    //   902: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   905: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: aload_1
    //   912: sipush 152
    //   915: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   918: checkcast 635	com/tencent/mobileqq/apollo/ApolloManager
    //   921: astore 5
    //   923: aload_1
    //   924: invokevirtual 405	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   927: invokestatic 638	com/tencent/mobileqq/apollo/ApolloManager:a	(Landroid/content/Context;)Z
    //   930: ifeq -801 -> 129
    //   933: aload 5
    //   935: ifnull -806 -> 129
    //   938: iconst_1
    //   939: aload 5
    //   941: aload_1
    //   942: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   945: invokevirtual 640	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)I
    //   948: if_icmpne -819 -> 129
    //   951: aload 4
    //   953: invokestatic 357	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   956: istore 10
    //   958: aload 5
    //   960: iconst_2
    //   961: iload 10
    //   963: invokevirtual 792	com/tencent/mobileqq/apollo/ApolloManager:a	(II)J
    //   966: ldc2_w 793
    //   969: ldiv
    //   970: lstore 11
    //   972: lload 11
    //   974: iload 9
    //   976: i2l
    //   977: lcmp
    //   978: ifeq -849 -> 129
    //   981: aload_1
    //   982: aload_1
    //   983: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   986: aconst_null
    //   987: iconst_m1
    //   988: iconst_1
    //   989: newarray <illegal type>
    //   991: dup
    //   992: iconst_0
    //   993: iload 10
    //   995: iastore
    //   996: iconst_m1
    //   997: iconst_m1
    //   998: iconst_1
    //   999: invokestatic 814	com/tencent/mobileqq/apollo/store/ApolloResDownloader:b	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;I[IIIZ)V
    //   1002: ldc 10
    //   1004: iconst_1
    //   1005: new 178	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   1012: ldc_w 816
    //   1015: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: iload 10
    //   1020: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1023: ldc_w 803
    //   1026: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: lload 11
    //   1031: invokevirtual 656	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: goto -911 -> 129
    //   1043: astore 5
    //   1045: ldc 10
    //   1047: iconst_2
    //   1048: new 178	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   1055: ldc_w 818
    //   1058: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload 4
    //   1063: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: aload 5
    //   1071: invokestatic 808	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1074: goto -945 -> 129
    //   1077: getstatic 633	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1080: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   1083: aload 4
    //   1085: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1088: ifeq -959 -> 129
    //   1091: aload_0
    //   1092: iload 9
    //   1094: getstatic 633	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1097: iconst_0
    //   1098: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   1101: pop
    //   1102: goto -973 -> 129
    //   1105: getstatic 587	com/tencent/mobileqq/vas/ClubContentJsonTask:c	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1108: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   1111: aload 4
    //   1113: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1116: ifeq -987 -> 129
    //   1119: aload_0
    //   1120: iload 9
    //   1122: getstatic 587	com/tencent/mobileqq/vas/ClubContentJsonTask:c	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1125: iconst_1
    //   1126: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   1129: pop
    //   1130: goto -1001 -> 129
    //   1133: getstatic 583	com/tencent/mobileqq/vas/ClubContentJsonTask:b	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1136: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   1139: aload 4
    //   1141: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1144: ifeq -1015 -> 129
    //   1147: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1150: ifeq +12 -> 1162
    //   1153: ldc 10
    //   1155: iconst_2
    //   1156: ldc_w 820
    //   1159: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1162: aload_0
    //   1163: iload 9
    //   1165: getstatic 583	com/tencent/mobileqq/vas/ClubContentJsonTask:b	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1168: iconst_1
    //   1169: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   1172: pop
    //   1173: goto -1044 -> 129
    //   1176: getstatic 646	com/tencent/mobileqq/vas/ClubContentJsonTask:l	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1179: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   1182: aload 4
    //   1184: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1187: ifeq -1058 -> 129
    //   1190: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1193: ifeq +12 -> 1205
    //   1196: ldc 10
    //   1198: iconst_2
    //   1199: ldc_w 822
    //   1202: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1205: aload_0
    //   1206: iload 9
    //   1208: getstatic 646	com/tencent/mobileqq/vas/ClubContentJsonTask:l	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1211: iconst_1
    //   1212: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   1215: pop
    //   1216: goto -1087 -> 129
    //   1219: getstatic 648	com/tencent/mobileqq/vas/ClubContentJsonTask:n	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1222: getfield 96	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:f	Ljava/lang/String;
    //   1225: aload 4
    //   1227: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1230: ifeq -1101 -> 129
    //   1233: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1236: ifeq +12 -> 1248
    //   1239: ldc 10
    //   1241: iconst_2
    //   1242: ldc_w 824
    //   1245: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1248: aload_0
    //   1249: iload 9
    //   1251: getstatic 648	com/tencent/mobileqq/vas/ClubContentJsonTask:n	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1254: iconst_1
    //   1255: invokespecial 395	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(ILcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Z
    //   1258: pop
    //   1259: goto -1130 -> 129
    //   1262: ldc_w 527
    //   1265: aload 4
    //   1267: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1270: ifeq -1141 -> 129
    //   1273: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1276: ifeq +12 -> 1288
    //   1279: ldc 10
    //   1281: iconst_2
    //   1282: ldc_w 826
    //   1285: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1288: aload_0
    //   1289: iload 9
    //   1291: invokevirtual 827	com/tencent/mobileqq/app/ClubContentUpdateHandler:a	(I)V
    //   1294: goto -1165 -> 129
    //   1297: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1300: ifeq +30 -> 1330
    //   1303: ldc 10
    //   1305: iconst_2
    //   1306: new 178	java/lang/StringBuilder
    //   1309: dup
    //   1310: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   1313: ldc_w 829
    //   1316: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: aload 4
    //   1321: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1330: aload 4
    //   1332: ldc_w 287
    //   1335: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1338: ifeq -1209 -> 129
    //   1341: aload_0
    //   1342: iload 9
    //   1344: invokespecial 831	com/tencent/mobileqq/app/ClubContentUpdateHandler:b	(I)V
    //   1347: goto -1218 -> 129
    //   1350: astore_1
    //   1351: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1354: ifeq +30 -> 1384
    //   1357: ldc 10
    //   1359: iconst_2
    //   1360: new 178	java/lang/StringBuilder
    //   1363: dup
    //   1364: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   1367: ldc_w 833
    //   1370: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: iload_3
    //   1374: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1377: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1380: aload_1
    //   1381: invokestatic 835	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1384: return
    //   1385: iload 10
    //   1387: lookupswitch	default:+153->1540, 1:+-1126->261, 2:+-1089->298, 3:+-1060->327, 4:+-952->435, 5:+-168->1219, 7:+-893->494, 8:+-125->1262, 9:+-1004->383, 10:+-1232->155, 18:+-1032->355, 112:+-310->1077, 113:+-211->1176, 201:+-865->522, 202:+-724->663, 203:+-514->873, 301:+-282->1105, 302:+-90->1297, 401:+-254->1133
    //   1540: goto -1411 -> 129
    //   1543: iload 8
    //   1545: iconst_1
    //   1546: iadd
    //   1547: istore 8
    //   1549: goto -1476 -> 73
    //   1552: astore 4
    //   1554: goto -11 -> 1543
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1557	0	this	ClubContentUpdateHandler
    //   0	1557	1	paramQQAppInterface	QQAppInterface
    //   0	1557	2	paramString	String
    //   0	1557	3	paramInt	int
    //   92	1239	4	localObject1	Object
    //   1552	1	4	localException1	Exception
    //   307	442	5	localObject2	Object
    //   827	27	5	localException2	Exception
    //   921	38	5	localApolloManager	ApolloManager
    //   1043	27	5	localException3	Exception
    //   399	17	6	localJSONArray	JSONArray
    //   408	19	7	localHashMap	HashMap
    //   71	1477	8	i1	int
    //   77	1266	9	i2	int
    //   111	1275	10	i3	int
    //   760	270	11	l1	long
    // Exception table:
    //   from	to	target	type
    //   663	723	827	java/lang/Exception
    //   728	762	827	java/lang/Exception
    //   771	824	827	java/lang/Exception
    //   861	870	827	java/lang/Exception
    //   873	933	1043	java/lang/Exception
    //   938	972	1043	java/lang/Exception
    //   981	1040	1043	java/lang/Exception
    //   55	70	1350	java/lang/Exception
    //   73	79	1350	java/lang/Exception
    //   86	123	1552	java/lang/Exception
    //   129	152	1552	java/lang/Exception
    //   155	242	1552	java/lang/Exception
    //   249	258	1552	java/lang/Exception
    //   261	276	1552	java/lang/Exception
    //   276	295	1552	java/lang/Exception
    //   298	324	1552	java/lang/Exception
    //   327	352	1552	java/lang/Exception
    //   355	380	1552	java/lang/Exception
    //   383	432	1552	java/lang/Exception
    //   435	491	1552	java/lang/Exception
    //   494	519	1552	java/lang/Exception
    //   522	582	1552	java/lang/Exception
    //   587	619	1552	java/lang/Exception
    //   622	660	1552	java/lang/Exception
    //   829	858	1552	java/lang/Exception
    //   1045	1074	1552	java/lang/Exception
    //   1077	1102	1552	java/lang/Exception
    //   1105	1130	1552	java/lang/Exception
    //   1133	1162	1552	java/lang/Exception
    //   1162	1173	1552	java/lang/Exception
    //   1176	1205	1552	java/lang/Exception
    //   1205	1216	1552	java/lang/Exception
    //   1219	1248	1552	java/lang/Exception
    //   1248	1259	1552	java/lang/Exception
    //   1262	1288	1552	java/lang/Exception
    //   1288	1294	1552	java/lang/Exception
    //   1297	1330	1552	java/lang/Exception
    //   1330	1347	1552	java/lang/Exception
  }
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    int i1;
    String str;
    int i2;
    if ((paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.rpt_msg_rspiteminfo.get().get(0);
      paramRspAppInfo = localRspItemInfo.str_name.get();
      i1 = localRspItemInfo.uint_version.get();
      str = localRspItemInfo.str_extend.get();
      i2 = localRspItemInfo.uint_update_flag.get();
      if (1 != (i2 & 0x1)) {
        break label158;
      }
      ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(true, "12h update...");
    }
    for (;;)
    {
      QLog.i("ClubContentUpdateHandler", 1, "apollo panel json: " + paramRspAppInfo + ", ver: " + i1 + ", updateFlag: " + i2 + ", extStr: " + str);
      return;
      try
      {
        label158:
        int i3 = ClubContentJsonTask.a();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getInt("apollo_json_version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0) == i3) {
          continue;
        }
        ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a();
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.e("ClubContentUpdateHandler", 2, "apollo json error" + localThrowable.toString());
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ClubContentUpdate.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "onReceive called.");
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ThreadManager.a().post(new pvj(this, paramInt, paramString));
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
  {
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "SmallEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag);
        }
        if ((localEmoticonPackage.jobType == 4) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.b(localEmoticonPackage.updateFlag)))
        {
          ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
        }
      }
    }
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(10);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return (ClubContentUpdateInfoPb.ReqAppInfo)localObject;
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b(ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramTaskInfo.f);
    localReqItemInfo.uint_version.set(ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramTaskInfo.e));
    localArrayList.add(localReqItemInfo);
    paramTaskInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    paramTaskInfo.uint_appid.set(paramInt);
    paramTaskInfo.rpt_msg_reqiteminfo.set(localArrayList);
    paramTaskInfo.setHasFlag(true);
    return paramTaskInfo;
  }
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if ((paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      paramRspAppInfo = paramRspAppInfo.rpt_msg_rspiteminfo.get().iterator();
      while (paramRspAppInfo.hasNext())
      {
        ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
        try
        {
          int i1 = Integer.parseInt(localRspItemInfo.str_name.get());
          int i2 = localRspItemInfo.uint_version.get();
          String str = localRspItemInfo.str_extend.get();
          int i3 = localRspItemInfo.uint_update_flag.get();
          if ((i3 & 0x1) == 1) {
            ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, i1, null, -1, -1, true);
          }
          QLog.i("ClubContentUpdateHandler", 1, "apollo role: " + i1 + ", ver: " + i2 + ", updateFlag: " + i3 + ", extStr: " + str);
        }
        catch (Exception localException)
        {
          QLog.e("ClubContentUpdateHandler", 1, "handleApolloRoleResponse role id: " + localRspItemInfo.str_name.get(), localException);
        }
      }
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramFromServiceMsg.isSuccess())
    {
      i1 = i2;
      if (paramObject != null) {
        i1 = 1;
      }
    }
    if (i1 != 0) {
      paramToServiceMsg = new ClubContentUpdateInfoPb.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.int_result.get() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          b();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label617;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 1: 
          i(paramFromServiceMsg);
          break;
        case 10: 
          h(paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      continue;
      j(paramFromServiceMsg);
      continue;
      k(paramFromServiceMsg);
      continue;
      paramFromServiceMsg = ((ArrayList)paramFromServiceMsg.rpt_msg_rspiteminfo.get()).iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (ClubContentUpdateInfoPb.RspItemInfo)paramFromServiceMsg.next();
        String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)paramObject).str_name.get();
        i1 = ((ClubContentUpdateInfoPb.RspItemInfo)paramObject).uint_version.get();
        String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)paramObject).str_extend.get();
        i2 = ((ClubContentUpdateInfoPb.RspItemInfo)paramObject).uint_update_flag.get();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "changeVoid Respone: name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
        }
        if (str1.equals(ClubContentJsonTask.o.f)) {
          a(i1, ClubContentJsonTask.o, false);
        }
      }
      continue;
      g(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      n(paramFromServiceMsg);
      continue;
      e(paramFromServiceMsg);
      continue;
      g(paramFromServiceMsg);
      continue;
      o(paramFromServiceMsg);
      continue;
      f(paramFromServiceMsg);
      continue;
      l(paramFromServiceMsg);
      continue;
      p(paramFromServiceMsg);
      continue;
      a(paramFromServiceMsg);
      continue;
      b(paramFromServiceMsg);
      continue;
      d(paramFromServiceMsg);
      continue;
      m(paramFromServiceMsg);
      continue;
      g(paramFromServiceMsg);
      continue;
      label617:
      return;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a();
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i1;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "BigEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        }
        if ((localEmoticonPackage.jobType == 0) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.b(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i1 = localEmoticonPackage.jsonVersion;
          if (i1 != 0) {
            break label367;
          }
          i1 = localEmoticonPackage.localVersion;
        }
      }
    }
    label367:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i1);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(ClubContentJsonTask.e.f);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.e.e));
      localArrayList.add(localObject);
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return (ClubContentUpdateInfoPb.ReqAppInfo)localObject;
    }
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = paramRspAppInfo.rpt_msg_rspiteminfo.get().iterator();
    while (paramRspAppInfo.hasNext())
    {
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      int i2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      if (str1.equals("signature_json"))
      {
        if (1 == (i2 & 0x1))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("sigResUpt", 0).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("sigTplUptFlag", true);
          ((SharedPreferences.Editor)localObject).putInt("sigTplCfgVerTemp", i1);
          if (Build.VERSION.SDK_INT > 8) {
            break label234;
          }
          ((SharedPreferences.Editor)localObject).commit();
        }
        for (;;)
        {
          localObject = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
          if (localObject == null) {
            break;
          }
          ((SignatureManager)localObject).a(false, false);
          break;
          label234:
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo d()
  {
    Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a();
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i1;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        QLog.d("ClubContentUpdateHandler", 2, "MagicEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        if ((localEmoticonPackage.jobType == 3) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.b(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i1 = localEmoticonPackage.jsonVersion;
          if (i1 != 0) {
            break label309;
          }
          i1 = localEmoticonPackage.localVersion;
        }
      }
    }
    label309:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i1);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return (ClubContentUpdateInfoPb.ReqAppInfo)localObject;
    }
  }
  
  protected void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleUrlInterceptJSONResponse name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      if (str1.equals(ClubContentJsonTask.l.f)) {
        a(i1, ClubContentJsonTask.l, false);
      }
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo e()
  {
    Object localObject = ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).b();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int i1 = 0;
      for (;;)
      {
        if (i1 < ((JSONArray)localObject).length()) {
          try
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
            ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
            localReqItemInfo.str_name.set(localJSONObject.getString("id"));
            localReqItemInfo.uint_version.set(localJSONObject.getInt("version"));
            localArrayList.add(localReqItemInfo);
            i1 += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(9);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return (ClubContentUpdateInfoPb.ReqAppInfo)localObject;
  }
  
  protected void e(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    paramRspAppInfo = new StringBuilder(((ArrayList)localObject).size() * 64);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)((Iterator)localObject).next();
      String str1 = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        paramRspAppInfo.append("name=").append(str1).append(", version=").append(i1).append(", updateFlag=").append(i2).append(", extStr=").append(str2);
      }
      if ((str1.equals(ClubContentJsonTask.i.f)) && (i1 > ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.i.e))) {
        a(i1, ClubContentJsonTask.i);
      }
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramRspAppInfo.toString()))) {
      QLog.d("ClubContentUpdateHandler", 2, paramRspAppInfo.toString());
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo f()
  {
    int i1 = ClubContentJsonTask.a();
    QLog.i("ClubContentUpdateHandler", 1, "getApolloPanelReqInfo ver: " + i1);
    if (i1 == 0)
    {
      ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(true, "login : local ver==0");
      return null;
    }
    ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(false, "login : check action");
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set("action_android_json_v3");
    localReqItemInfo.uint_version.set(i1);
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(201);
    localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo);
    return localReqAppInfo;
  }
  
  protected void f(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      if (str1.equals(ClubContentJsonTask.m.f)) {
        a(i1, ClubContentJsonTask.m, false);
      }
    }
  }
  
  public ClubContentUpdateInfoPb.ReqAppInfo g()
  {
    Object localObject1 = new SparseArray(8);
    Object localObject2 = new File(ApolloConstant.k, "/def/role/0/config.json");
    if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {}
    for (;;)
    {
      try
      {
        long l1 = new JSONObject(FileUtils.a((File)localObject2)).optLong("version");
        ((SparseArray)localObject1).put(0, Long.valueOf(l1));
        QLog.i("ClubContentUpdateHandler", 1, "getApolloRoleReqInfo roleId: 0, ver: " + l1 / 1000L);
        localObject2 = new File(ApolloConstant.n);
        if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory())) {
          ((File)localObject2).listFiles(new pvk(this, (SparseArray)localObject1));
        }
        localObject2 = new ArrayList();
        int i1 = 0;
        if (i1 >= ((SparseArray)localObject1).size()) {
          break;
        }
        ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
        int i2 = ((SparseArray)localObject1).keyAt(i1);
        localReqItemInfo.str_name.set(i2 + "");
        localReqItemInfo.uint_version.set((int)(((Long)((SparseArray)localObject1).get(i2)).longValue() / 1000L));
        ((ArrayList)localObject2).add(localReqItemInfo);
        i1 += 1;
        continue;
      }
      catch (Exception localException)
      {
        QLog.e("ClubContentUpdateHandler", 1, "getApolloRoleReqInfo roleId:0", localException);
        ((SparseArray)localObject1).put(0, Long.valueOf(0L));
        continue;
      }
      QLog.e("ClubContentUpdateHandler", 1, "getApolloRoleReqInfo not find role 0 config");
      ((SparseArray)localObject1).put(0, Long.valueOf(0L));
    }
    if (localException.size() > 0)
    {
      localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(202);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.addAll(localException);
      return (ClubContentUpdateInfoPb.ReqAppInfo)localObject1;
    }
    return null;
  }
  
  protected void g(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      if (!TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
        }
        if (str1.equals(ClubContentJsonTask.d.f))
        {
          if (i1 > ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.d.e)) {
            ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.d, i1, false);
          }
        }
        else if (str1.equals(ClubContentJsonTask.j.f))
        {
          if (i1 > ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.j.e)) {
            ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.j, i1, false);
          }
        }
        else if (str1.equals(ClubContentJsonTask.n.f))
        {
          i2 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.n.e);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "FontInfoList_json remoteVersion = " + i1 + " localVersion = " + i2);
          }
          if (i1 > i2) {
            ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.n, i1, false);
          }
        }
      }
    }
  }
  
  protected void h(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse begins");
    }
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      int i3 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + str);
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + str + ",updateFlag:" + i2 + ",version" + i1 + ",localVersion:" + i3);
      }
      if (i3 < i1) {
        a(i1, i2, str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse ends");
    }
  }
  
  protected void i(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    QLog.d("ClubContentUpdateHandler", 2, "handleEmosmResponse begins");
    paramRspAppInfo = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramRspAppInfo.iterator();
    while (localIterator.hasNext())
    {
      paramRspAppInfo = (ClubContentUpdateInfoPb.RspItemInfo)localIterator.next();
      String str1 = paramRspAppInfo.str_name.get();
      int i1 = paramRspAppInfo.uint_version.get();
      String str2 = paramRspAppInfo.str_extend.get();
      int i2 = paramRspAppInfo.uint_update_flag.get();
      String[] arrayOfString = str2.split("\\|\\|");
      paramRspAppInfo = "";
      if (arrayOfString.length > 0) {
        paramRspAppInfo = arrayOfString[0];
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i1 + ", tip=" + paramRspAppInfo + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      a(str1, i1, paramRspAppInfo, i2, localHashMap, false);
    }
  }
  
  protected void j(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    paramRspAppInfo = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    JSONArray localJSONArray = paramRspAppInfo.a();
    StringBuilder localStringBuilder = new StringBuilder("handleBubbleResponse:");
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)((Iterator)localObject).next();
      String str = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      localStringBuilder.append(";name = ").append(str).append(",version = ").append(i1);
      a(paramRspAppInfo, localJSONArray, str, i1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, localStringBuilder.toString());
    }
  }
  
  protected void k(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      if (str1.equals(ClubContentJsonTask.h.f)) {
        a(i1, ClubContentJsonTask.h, false);
      }
    }
  }
  
  protected void l(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      Object localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      int i1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      int i2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleIRedPacketResponse, name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      if (str1.equals(ClubContentJsonTask.k.f))
      {
        if (!a(i1, ClubContentJsonTask.k, false)) {
          ThreadManager.a(new pvl(this), 2, null, true);
        }
        localObject = (QQAppInterface)BaseApplicationImpl.a.a();
        if (localObject != null) {
          ((IndividualRedPacketManager)((QQAppInterface)localObject).getManager(130)).c();
        }
      }
    }
  }
  
  protected void m(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i1 = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int i2 = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleIndividuationMainpageConfigResponse, name=" + str1 + ", version=" + i1 + ", updateFlag=" + i2 + ",extStr=" + str2);
      }
      if (str1.equals("individuation_mainpage_config2")) {
        b(i1);
      }
    }
  }
  
  protected void n(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if ((paramRspAppInfo != null) && (paramRspAppInfo.rpt_msg_rspiteminfo.get() != null)) {}
    for (paramRspAppInfo = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();; paramRspAppInfo = null)
    {
      if (paramRspAppInfo == null) {}
      AvatarPendantManager localAvatarPendantManager;
      do
      {
        return;
        localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
        localObject1 = localAvatarPendantManager.a();
      } while ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0));
      HashMap localHashMap = new HashMap();
      paramRspAppInfo = paramRspAppInfo.iterator();
      Object localObject2;
      int i1;
      while (paramRspAppInfo.hasNext())
      {
        localObject2 = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
        String str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).str_name.get();
        i1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject2).uint_version.get();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "name=" + str + ", version=" + i1);
        }
        a(str, i1, (JSONArray)localObject1, localAvatarPendantManager, localHashMap);
      }
      paramRspAppInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("individuation_predownload_resource_config", 0);
      Object localObject1 = paramRspAppInfo.getString("pendant_id_list", null);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramRspAppInfo.edit().remove("pendant_id_list").commit();
        localObject2 = ((String)localObject1).split(",");
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          localObject1 = new ArrayList(localObject2.length);
          int i2 = localObject2.length;
          i1 = 0;
          for (;;)
          {
            paramRspAppInfo = (ClubContentUpdateInfoPb.RspAppInfo)localObject1;
            if (i1 >= i2) {
              break;
            }
            ((ArrayList)localObject1).add(localObject2[i1]);
            i1 += 1;
          }
        }
      }
      paramRspAppInfo = null;
      localAvatarPendantManager.a(localHashMap, paramRspAppInfo);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ClubContentUpdateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */