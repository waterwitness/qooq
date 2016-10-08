package com.tencent.biz.qqstory.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RecommendItem;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetInfoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetMediaStory;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetRecommendList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetSearchFeedList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetStory;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetStoryList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetVideoInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqReport;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqSubscription;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetInfoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetMediaStory;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetRecommendList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetSearchFeedList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetStory;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetStoryList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetVideoInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspReport;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspSubscription;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.VideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqForbidStory;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetForbiddenList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetForbiddenStates;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspForbidStory;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetForbiddenList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetForbiddenStates;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfoExt;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.model.VideoInfo;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QQStoryHandler
  extends BusinessHandler
{
  public static final int a = 1001;
  public static final String a = "QQStoryHandler";
  public static final int b = 1002;
  public static final String b = "reqFromQQStoryHandler";
  public static final int c = 1003;
  public static final String c = "StorySvc.video_config_get";
  public static final int d = 1004;
  public static final String d = "StorySvc.video_config_set";
  public static final int e = 1005;
  public static final String e = "StorySvc.video_get_user_mask_list";
  public static final int f = 1006;
  public static final String f = "StorySvc.video_set_user_mask";
  public static final int g = 1007;
  public static final String g = "StorySvc.video_get_user_mask_states";
  public static final int h = 1008;
  public static final String h = "StorySvc.video_show_video_list";
  public static final int i = 1009;
  public static final String i = "StorySvc.pgc_subscribe_media_list";
  public static final int j = 1010;
  public static final String j = "StorySvc.pgc_subscribe_recommend_list";
  public static final int k = 1011;
  public static final String k = "StorySvc.pgc_subscribe_operation";
  public static final int l = 1012;
  public static final String l = "StorySvc.pgc_person_page";
  public static final int m = 1013;
  public static final String m = "StorySvc.pgc_person_content";
  public static final int n = 1014;
  public static final String n = "StorySvc.pgc_search_feedlist_get";
  public static final int o = 1015;
  public static final String o = "StorySvc.pgc_story_detail";
  public static final int p = 10100;
  public static final String p = "StorySvc.get_pgc_story_url";
  public static final int q = 10101;
  public static final String q = "StorySvc.pgc_client_report";
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public static final int u = 1;
  public static final int v = 2;
  public static final int w = 3;
  public static final int x = 4;
  byte[] a;
  
  public QQStoryHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
  {
    int i2 = 0;
    int i1 = 0;
    if (a(paramObject)) {}
    label482:
    label483:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new qqstory_pgc.RspGetRecommendList();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (qqstory_pgc.ErrorInfo)paramFromServiceMsg.result.get();
        if (paramToServiceMsg.error_code.get() == 0)
        {
          i4 = paramFromServiceMsg.seq.get();
          paramToServiceMsg = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180);
          i1 = paramToServiceMsg.a("StorySvc.pgc_subscribe_recommend_list");
          if ((i4 == i1) && (paramBoolean))
          {
            if (!QLog.isColorLevel()) {
              break label482;
            }
            QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetSubscribeRecommendList no need update. seq is " + i1);
            return;
          }
          Object localObject1 = paramFromServiceMsg.recommend_storys.get();
          paramFromServiceMsg = new ArrayList();
          i1 = 0;
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = RecommendItem.a((qqstory_pgc.RecommendItem)((Iterator)localObject1).next());
            if ((localObject2 == null) || (!((RecommendItem)localObject2).a()))
            {
              int i3 = 1;
              localObject2 = "QQStoryHandler handleGetSubscribeRecommendList item=" + localObject2;
              i1 = i3;
              if (!paramBoolean) {
                break label483;
              }
              QQStoryManager.a((String)localObject2);
              i1 = i3;
              break label483;
            }
            paramFromServiceMsg.add(localObject2);
            break label483;
          }
          if (i1 != 0)
          {
            StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { "StorySvc.pgc_subscribe_recommend_list" });
            a(1008, true, new Object[] { Integer.valueOf(i4), paramFromServiceMsg });
            if (!paramBoolean) {}
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        int i4;
        i1 = i2;
        paramToServiceMsg.printStackTrace();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetSubscribeRecommendList error_code=" + paramToServiceMsg.error_code.get());
        }
        i1 = 0;
        continue;
      }
      try
      {
        paramToServiceMsg.a("StorySvc.pgc_subscribe_recommend_list", i4, (byte[])paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetSubscribeRecommendList isSuccess=" + true + " seq:" + i4 + " recommendItemList:" + paramFromServiceMsg);
        }
        i1 = 1;
        if (i1 != 0) {
          break label482;
        }
        a(1008, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i1 = 1;
        continue;
      }
      StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { "StorySvc.pgc_subscribe_recommend_list" });
      continue;
      return;
    }
  }
  
  private void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2)
  {
    qqstory_pgc.ReqReport localReqReport = new qqstory_pgc.ReqReport();
    localReqReport.story_id.set(ByteStringMicro.copyFromUtf8(paramString1), true);
    localReqReport.type.set(paramInt1, true);
    localReqReport.uid.set(paramLong, true);
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localReqReport.union_id.set(ByteStringMicro.copyFromUtf8(str), true);
    localReqReport.operation.set(paramInt2, true);
    paramString2 = a("StorySvc.pgc_client_report");
    paramString2.putWupBuffer(localReqReport.toByteArray());
    b(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler report storyId=" + paramString1 + " userType=" + paramInt1 + " uid=" + paramLong + " unionId=" + str + " operation=" + paramInt2);
    }
  }
  
  public static boolean a(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof byte[])) && (((byte[])paramObject).length > 0);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
  {
    int i2 = 0;
    int i1 = 0;
    if (a(paramObject)) {}
    label494:
    label495:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new qqstory_pgc.RspGetMediaStory();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (qqstory_pgc.ErrorInfo)paramFromServiceMsg.result.get();
        if (paramToServiceMsg.error_code.get() == 0)
        {
          i3 = paramFromServiceMsg.seq.get();
          paramToServiceMsg = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180);
          i1 = paramToServiceMsg.a("StorySvc.pgc_subscribe_media_list");
          if ((i3 == i1) && (paramBoolean))
          {
            if (!QLog.isColorLevel()) {
              break label494;
            }
            QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetMediaStoryList no need update. seq is " + i1 + " needCache=" + paramBoolean);
            return;
          }
          Object localObject = paramFromServiceMsg.media_storys.get();
          paramFromServiceMsg = new ArrayList();
          i1 = 0;
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            RecommendItem localRecommendItem = RecommendItem.a((qqstory_pgc.RecommendItem)((Iterator)localObject).next());
            if ((localRecommendItem == null) || (!localRecommendItem.a()))
            {
              i1 = 1;
              QQStoryManager.a("QQStoryHandler handleGetMediaStoryList item=" + localRecommendItem);
              break label495;
            }
            paramFromServiceMsg.add(localRecommendItem);
            break label495;
          }
          if (i1 != 0)
          {
            StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { "StorySvc.pgc_subscribe_media_list" });
            a(1007, true, new Object[] { Integer.valueOf(i3), paramFromServiceMsg });
            if (!paramBoolean) {}
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        int i3;
        i1 = i2;
        paramToServiceMsg.printStackTrace();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetMediaStoryList error_code=" + paramToServiceMsg.error_code.get());
        }
        i1 = 0;
        continue;
      }
      try
      {
        StoryReportor.a("recommend", "exp", 0, 0, new String[0]);
        paramToServiceMsg.a("StorySvc.pgc_subscribe_media_list", i3, (byte[])paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetMediaStoryList isSuccess=" + true + " seq:" + i3 + " result:" + paramFromServiceMsg);
        }
        i1 = 1;
        if (i1 != 0) {
          break label494;
        }
        a(1007, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i1 = 1;
        continue;
      }
      StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { "StorySvc.pgc_subscribe_media_list" });
      continue;
      return;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    if (paramObject != null) {
      paramToServiceMsg = new qqstory_service.RspSetConfig();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.result.error_code.get() == 0)
        {
          a(1004, true, null);
          if (i1 == 0) {
            a(1004, false, null);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      i1 = 0;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QQStoryManager localQQStoryManager;
    boolean bool2;
    boolean bool1;
    int i1;
    if (paramObject != null)
    {
      localQQStoryManager = (QQStoryManager)this.b.getManager(180);
      bool2 = paramToServiceMsg.extraData.getBoolean("isNotAllowed");
      bool1 = paramToServiceMsg.extraData.getBoolean("isFirst");
      i1 = paramToServiceMsg.extraData.getInt("count");
      if (bool1)
      {
        paramToServiceMsg = localQQStoryManager.a(bool2);
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg = paramToServiceMsg.iterator();
          while (paramToServiceMsg.hasNext()) {
            localQQStoryManager.a((QQStoryUserInfo)paramToServiceMsg.next(), bool2);
          }
        }
      }
      paramToServiceMsg = new qqstory_service.RspGetForbiddenList();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.result.error_code.get() == 0)
        {
          if (paramToServiceMsg.is_end.get() == 0) {
            break label418;
          }
          bool1 = true;
          paramObject = paramToServiceMsg.next_cookie.get().toByteArray();
          if ((paramObject == null) || (paramObject.length == 0)) {
            break label528;
          }
          paramToServiceMsg = paramToServiceMsg.user_list.get();
          if (paramToServiceMsg.size() >= i1) {
            break label525;
          }
          bool1 = true;
          Iterator localIterator = paramToServiceMsg.iterator();
          if (!localIterator.hasNext()) {
            break label471;
          }
          qqstory_struct.UserInfo localUserInfo = (qqstory_struct.UserInfo)localIterator.next();
          String str = localUserInfo.uid.get() + "";
          paramFromServiceMsg = localQQStoryManager.a(str);
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new QQStoryUserInfo();
            localQQStoryManager.jdField_a_of_type_JavaUtilHashMap.put(str, paramToServiceMsg);
          }
          paramToServiceMsg.uin = (localUserInfo.uid.get() + "");
          paramToServiceMsg.setNick(ContactUtils.l(this.b, paramToServiceMsg.uin));
          if (!bool2) {
            break label424;
          }
          paramToServiceMsg.isAllowed = 1;
          if (!localQQStoryManager.b.contains(paramToServiceMsg)) {
            localQQStoryManager.b.add(paramToServiceMsg);
          }
          if (paramToServiceMsg.getStatus() != 1000) {
            break label458;
          }
          localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramToServiceMsg);
          continue;
        }
        if (i1 != 0) {
          break label417;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        i1 = 0;
      }
      a(1001, false, null);
      label417:
      return;
      label418:
      bool1 = false;
      continue;
      label424:
      if (!localQQStoryManager.jdField_a_of_type_JavaUtilList.contains(paramToServiceMsg)) {
        localQQStoryManager.jdField_a_of_type_JavaUtilList.add(paramToServiceMsg);
      }
      paramToServiceMsg.isInterested = 1;
      continue;
      label458:
      localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramToServiceMsg);
      continue;
      label471:
      if (bool2) {}
      for (paramToServiceMsg = localQQStoryManager.b;; paramToServiceMsg = localQQStoryManager.jdField_a_of_type_JavaUtilList)
      {
        a(1001, true, new Object[] { paramToServiceMsg, paramObject, Boolean.valueOf(bool1) });
        i1 = 1;
        break;
      }
      label525:
      continue;
      label528:
      bool1 = true;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("reqUin");
    QQStoryManager localQQStoryManager;
    if (paramObject != null)
    {
      localQQStoryManager = (QQStoryManager)this.b.getManager(180);
      paramToServiceMsg = new qqstory_service.RspGetForbiddenStates();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.result.error_code.get() == 0))
      {
        paramFromServiceMsg = localQQStoryManager.a(str);
        paramToServiceMsg = paramToServiceMsg.user_list.get();
        if (paramToServiceMsg.size() > 0)
        {
          paramToServiceMsg = (qqstory_struct.UserInfo)paramToServiceMsg.get(0);
          i1 = paramToServiceMsg.ext.his_story_forbidden.get();
          int i2 = paramToServiceMsg.ext.my_story_forbidden.get();
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new QQStoryUserInfo();
            paramToServiceMsg.uin = str;
            paramToServiceMsg.setNick(ContactUtils.l(this.b, str));
            localQQStoryManager.jdField_a_of_type_JavaUtilHashMap.put(str, paramToServiceMsg);
            paramToServiceMsg.isAllowed = i2;
            paramToServiceMsg.isInterested = i1;
            if (paramToServiceMsg.getStatus() == 1000)
            {
              localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramToServiceMsg);
              a(1005, true, paramToServiceMsg);
              i1 = 1;
              if (i1 == 0) {
                a(1005, true, null);
              }
              return;
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = null;
        continue;
        localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramToServiceMsg);
        continue;
        paramToServiceMsg = paramFromServiceMsg;
        continue;
        int i1 = 0;
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        paramToServiceMsg = new qqstory_service.RspGetUserVideoList();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (qqstory_struct.ErrorInfo)paramToServiceMsg.result.get();
        paramFromServiceMsg = paramToServiceMsg.video_list.get();
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramToServiceMsg.add(((qqstory_struct.StoryVideoDes)paramFromServiceMsg.next()).video_cover.get().toStringUtf8());
          continue;
          i1 = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
    for (;;)
    {
      if (i1 == 0) {
        a(1006, false, null);
      }
      return;
      a(1006, true, paramToServiceMsg);
      int i1 = 1;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, true);
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 1;
    if (a(paramObject)) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new qqstory_pgc.RspGetInfoCard();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (qqstory_pgc.ErrorInfo)paramToServiceMsg.result.get();
        if ((paramFromServiceMsg.error_code.get() == 0) && (paramToServiceMsg.user.has()))
        {
          paramToServiceMsg = UserInfo.convertFrom((qqstory_pgc.UserInfo)paramToServiceMsg.user.get());
          if ((paramToServiceMsg != null) && (paramToServiceMsg.checkData())) {
            break label306;
          }
          QQStoryManager.a("QQStoryHandler handleGetPGCUserInfoCard user=" + null);
          i1 = 1;
          paramToServiceMsg = null;
          if (i1 != 0)
          {
            StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { "StorySvc.pgc_person_page" });
            a(1009, true, paramToServiceMsg);
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i1 = 0;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetPGCUserInfoCard isSuccess=" + true + " user:" + paramToServiceMsg);
        }
        i1 = 1;
        if (i1 == 0) {
          a(1009, false, null);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          i1 = i2;
        }
      }
      StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { "StorySvc.pgc_person_page" });
      continue;
      paramToServiceMsg.printStackTrace();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetPGCUserInfoCard error_code=" + paramFromServiceMsg.error_code.get() + " user:" + paramToServiceMsg.user.get());
      }
      int i1 = 0;
      continue;
      label306:
      i1 = 0;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 0;
    i1 = 0;
    if (a(paramObject)) {}
    for (;;)
    {
      int i3;
      try
      {
        paramToServiceMsg = new qqstory_pgc.RspGetStory();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i3 = ((qqstory_pgc.ErrorInfo)paramToServiceMsg.result.get()).error_code.get();
        if (i3 == 0)
        {
          paramFromServiceMsg = Story.convertFrom((qqstory_pgc.StoryInfo)paramToServiceMsg.story_info.get());
          i1 = 0;
          if (paramFromServiceMsg != null)
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (paramFromServiceMsg.checkData()) {}
          }
          else
          {
            i1 = 1;
            QQStoryManager.a("QQStoryHandler handleGetStory story=" + paramFromServiceMsg);
            paramToServiceMsg = null;
          }
          if (i1 != 0)
          {
            StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { "StorySvc.pgc_story_detail" });
            a(1013, true, new Object[] { Integer.valueOf(i3), paramToServiceMsg });
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i1 = i2;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetStory isSuccess=" + true + " story:" + paramToServiceMsg + " errorCode:" + i3);
        }
        i1 = 1;
        if (i1 == 0) {
          a(1013, false, null);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          i1 = 1;
        }
      }
      StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { "StorySvc.pgc_story_detail" });
      continue;
      paramToServiceMsg.printStackTrace();
      continue;
      a(1013, true, new Object[] { Integer.valueOf(i3), null });
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetStory isSuccess=" + true + " errorCode:" + i3);
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i3 = 1;
    int i2 = 1;
    if (a(paramObject)) {}
    int i1;
    label344:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new qqstory_pgc.RspGetVideoInfoList();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (qqstory_pgc.ErrorInfo)paramToServiceMsg.result.get();
        if ((paramFromServiceMsg.error_code.get() == 0) && (paramToServiceMsg.video_info_list.has()))
        {
          paramFromServiceMsg = paramToServiceMsg.video_info_list.get();
          paramToServiceMsg = new ArrayList();
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          i1 = 0;
          if (paramFromServiceMsg.hasNext())
          {
            paramObject = VideoInfo.a((qqstory_pgc.VideoInfo)paramFromServiceMsg.next());
            if ((paramObject == null) || (!((VideoInfo)paramObject).a()))
            {
              QQStoryManager.a("QQStoryHandler handleGetUrlByVid info=" + paramObject);
              i1 = 1;
              break label344;
            }
            paramToServiceMsg.add(paramObject);
            break label344;
          }
          if (i1 != 0)
          {
            StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { "StorySvc.get_pgc_story_url" });
            a(1014, true, paramToServiceMsg);
            i1 = i2;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i1 = 0;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetUrlByVid isSuccess=" + true + " videoInfos:" + paramToServiceMsg);
          i1 = i2;
        }
        if (i1 == 0) {
          a(1014, false, null);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          i1 = i3;
        }
      }
      StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { "StorySvc.get_pgc_story_url" });
      continue;
      paramToServiceMsg.printStackTrace();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetUrlByVid error_code=" + paramFromServiceMsg.error_code.get());
      }
      i1 = 0;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    int i3 = 0;
    int i2;
    label99:
    Object localObject;
    if (a(paramObject))
    {
      try
      {
        paramFromServiceMsg = new qqstory_pgc.RspGetSearchFeedList();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (qqstory_pgc.ErrorInfo)paramFromServiceMsg.result.get();
        if (paramToServiceMsg.error_code.get() != 0) {
          break label470;
        }
        if (!paramFromServiceMsg.result_type.has()) {
          break label524;
        }
        i2 = paramFromServiceMsg.result_type.get();
        paramToServiceMsg = paramFromServiceMsg.feed_list.get();
        paramObject = new ArrayList();
        i1 = 0;
        paramToServiceMsg = paramToServiceMsg.iterator();
        if (paramToServiceMsg.hasNext())
        {
          localObject = UserInfo.convertFrom((qqstory_pgc.UserInfo)paramToServiceMsg.next());
          if ((localObject == null) || (!((UserInfo)localObject).checkData()))
          {
            i1 = 1;
            QQStoryManager.a("QQStoryHandler handleGetPGCSearchFeedList user=" + localObject);
            break label521;
          }
          ((List)paramObject).add(localObject);
          break label521;
        }
        if (i1 == 0) {
          break label331;
        }
        StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { "StorySvc.pgc_search_feedlist_get" });
        if (!paramFromServiceMsg.is_end.has()) {
          break label542;
        }
        i1 = paramFromServiceMsg.is_end.get();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        label222:
        i1 = i3;
      }
      if (!paramFromServiceMsg.next_cookie.has()) {
        break label554;
      }
    }
    label331:
    label470:
    label521:
    label524:
    label542:
    label548:
    label554:
    for (paramToServiceMsg = paramFromServiceMsg.next_cookie.get().toStringUtf8();; paramToServiceMsg = null)
    {
      localObject = new ArrayList();
      if (paramFromServiceMsg.key_word_list.has())
      {
        paramFromServiceMsg = paramFromServiceMsg.key_word_list.get().iterator();
        while (paramFromServiceMsg.hasNext()) {
          ((List)localObject).add(((ByteStringMicro)paramFromServiceMsg.next()).toStringUtf8());
        }
      }
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        if (i1 == 0) {
          a(1010, false, null);
        }
        return;
        StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { "StorySvc.pgc_search_feedlist_get" });
        break;
        a(1010, true, new Object[] { Integer.valueOf(i2), paramObject, Boolean.valueOf(bool), paramToServiceMsg, localObject });
        i2 = 1;
        for (i1 = i2;; i1 = 0)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetPGCSearchFeedList isSuccess=" + true + " userInfoList:" + paramObject + " isEnd:" + bool + " nextCookie:" + paramToServiceMsg);
              i1 = i2;
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            i1 = 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetPGCSearchFeedList error_code=" + paramToServiceMsg.error_code.get());
          }
        }
      }
      break label99;
      i2 = 2;
      break;
      for (;;)
      {
        if (i1 != 1) {
          break label548;
        }
        bool = true;
        break;
        i1 = 0;
      }
      boolean bool = false;
      break label222;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    i2 = 0;
    i1 = 0;
    if (a(paramObject)) {}
    try
    {
      paramToServiceMsg = new qqstory_pgc.RspGetStoryList();
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = (qqstory_pgc.ErrorInfo)paramToServiceMsg.result.get();
      if (paramFromServiceMsg.error_code.get() != 0) {
        break label391;
      }
      paramObject = paramToServiceMsg.result_storys.get();
      paramFromServiceMsg = new ArrayList();
      i1 = 0;
      paramObject = ((List)paramObject).iterator();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        Story localStory;
        label203:
        label224:
        label326:
        i1 = i2;
        paramToServiceMsg.printStackTrace();
        continue;
        i1 = 0;
        while (i1 != 1)
        {
          bool = false;
          break label203;
          paramToServiceMsg = null;
          break label224;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetPGCContentStoryList error_code=" + paramFromServiceMsg.error_code.get());
          }
          i1 = 0;
          break label326;
          break;
        }
        boolean bool = true;
      }
    }
    if (((Iterator)paramObject).hasNext())
    {
      localStory = Story.convertFrom((qqstory_pgc.StoryInfo)((Iterator)paramObject).next());
      if ((localStory != null) && (!localStory.checkData()))
      {
        i1 = 1;
        QQStoryManager.a("QQStoryHandler handleGetPGCContentStoryList item=" + localStory);
      }
      else
      {
        paramFromServiceMsg.add(localStory);
      }
    }
    else
    {
      if (i1 != 0) {
        StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { "StorySvc.pgc_person_content" });
      }
      for (;;)
      {
        if (!paramToServiceMsg.is_end.has()) {
          break label374;
        }
        i1 = paramToServiceMsg.is_end.get();
        break label445;
        if (!paramToServiceMsg.next_cookie.has()) {
          break label386;
        }
        paramToServiceMsg = paramToServiceMsg.next_cookie.get().toStringUtf8();
        a(1012, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool), paramToServiceMsg });
        i2 = 1;
        i1 = i2;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetPGCContentStoryList isSuccess=" + true + " storyList:" + paramFromServiceMsg + " isEnd:" + bool + " nextCookie:" + paramToServiceMsg);
            i1 = i2;
          }
          if (i1 == 0) {
            a(1012, false, null);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;)
          {
            i1 = 1;
          }
        }
        StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { "StorySvc.pgc_person_content" });
      }
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    int i2 = paramToServiceMsg.extraData.getInt("userType", 0);
    paramToServiceMsg = paramToServiceMsg.extraData.getString("unionId");
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = Integer.valueOf(i2);
    paramFromServiceMsg[1] = paramToServiceMsg;
    if (a(paramObject)) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new qqstory_pgc.RspSubscription();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = (qqstory_pgc.ErrorInfo)paramToServiceMsg.result.get();
        if (((qqstory_pgc.ErrorInfo)paramObject).error_code.get() == 0) {
          if (paramToServiceMsg.is_subscribe.get() == 1)
          {
            bool = true;
            paramFromServiceMsg[2] = Boolean.valueOf(bool);
            a(1011, true, paramFromServiceMsg);
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        boolean bool;
        i1 = 0;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetSubscribeOperation isSuccess=" + true + " isSubscribe:" + bool);
        }
        i1 = 1;
        if (i1 == 0)
        {
          paramFromServiceMsg[2] = null;
          a(1011, false, paramFromServiceMsg);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;) {}
      }
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetSubscribeOperation error_code=" + ((qqstory_pgc.ErrorInfo)paramObject).error_code.get());
      }
      i1 = 0;
      continue;
      paramToServiceMsg.printStackTrace();
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject, true);
  }
  
  protected Class a()
  {
    return QQStoryObserver.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryHandler", 2, "getNowTabIsOpen begin...");
    }
    try
    {
      long l1 = Long.parseLong(this.b.getAccount());
      Object localObject = new byte[9];
      PkgTools.a((byte[])localObject, 0, l1);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 42060);
      localObject = a("OidbSvc.0x480_9", 1152, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromQQStoryHandler", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.dating", 2, "send_oidb_0x480_9 error", localException);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryHandler", 2, "setNowTabIsOpen value=" + paramInt);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      long l1 = Long.parseLong(this.b.a());
      short s1 = (short)paramInt;
      Object localObject = new byte[19];
      PkgTools.a((byte[])localObject, 0, l1);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)2);
      PkgTools.a((byte[])localObject, 7, 42060);
      PkgTools.a((byte[])localObject, 9, (short)2);
      PkgTools.a((byte[])localObject, 11, s1);
      PkgTools.a((byte[])localObject, 13, 40319);
      PkgTools.a((byte[])localObject, 15, (short)2);
      PkgTools.a((byte[])localObject, 17, (short)1);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = a("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromQQStoryHandler", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QQStoryHandler", 2, "setNowTabIsOpen ex", localException);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    qqstory_pgc.ReqGetInfoCard localReqGetInfoCard = new qqstory_pgc.ReqGetInfoCard();
    localReqGetInfoCard.type.set(paramInt, true);
    if (!TextUtils.isEmpty(paramString)) {
      localReqGetInfoCard.union_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    }
    ToServiceMsg localToServiceMsg = a("StorySvc.pgc_person_page");
    localToServiceMsg.putWupBuffer(localReqGetInfoCard.toByteArray());
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getPGCInfoCard type=" + paramInt + " unionId=" + paramString);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    qqstory_pgc.ReqSubscription localReqSubscription = new qqstory_pgc.ReqSubscription();
    localReqSubscription.type.set(paramInt1, true);
    if (!TextUtils.isEmpty(paramString)) {
      localReqSubscription.union_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    }
    localReqSubscription.operation.set(paramInt2, true);
    localReqSubscription.from.set(paramInt3, true);
    ToServiceMsg localToServiceMsg = a("StorySvc.pgc_subscribe_operation");
    localToServiceMsg.extraData.putInt("userType", paramInt1);
    localToServiceMsg.extraData.putString("unionId", paramString);
    localToServiceMsg.putWupBuffer(localReqSubscription.toByteArray());
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getSubscribeOperation type=" + paramInt1 + " unionId=" + paramString + " operation=" + paramInt2);
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    qqstory_pgc.ReqGetStoryList localReqGetStoryList = new qqstory_pgc.ReqGetStoryList();
    localReqGetStoryList.type.set(paramInt1, true);
    if (!TextUtils.isEmpty(paramString1)) {
      localReqGetStoryList.union_id.set(ByteStringMicro.copyFromUtf8(paramString1), true);
    }
    localReqGetStoryList.count.set(paramInt2, true);
    localReqGetStoryList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramString2), true);
    ToServiceMsg localToServiceMsg = a("StorySvc.pgc_person_content");
    localToServiceMsg.putWupBuffer(localReqGetStoryList.toByteArray());
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getStoryContentList type=" + paramInt1 + " unionId=" + paramString1 + " count=" + paramInt2 + " startCookie=" + paramString2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = ((QQStoryManager)this.b.getManager(180)).a("StorySvc.pgc_subscribe_recommend_list");
      if (localObject != null) {
        a(null, null, localObject, false);
      }
    }
    Object localObject = new qqstory_pgc.ReqGetRecommendList();
    ((qqstory_pgc.ReqGetRecommendList)localObject).seq.set(paramInt, true);
    ToServiceMsg localToServiceMsg = a("StorySvc.pgc_subscribe_recommend_list");
    localToServiceMsg.putWupBuffer(((qqstory_pgc.ReqGetRecommendList)localObject).toByteArray());
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getSubscribeRecommendList seq=" + paramInt + " useCache=" + paramBoolean);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    String str = ((UserManager)SuperManager.a(2)).a(paramLong);
    qqstory_service.ReqGetUserVideoList localReqGetUserVideoList = new qqstory_service.ReqGetUserVideoList();
    localReqGetUserVideoList.uid.set(paramLong);
    localReqGetUserVideoList.union_id.set(ByteStringMicro.copyFromUtf8(str));
    localReqGetUserVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqGetUserVideoList.count.set(paramInt1);
    localReqGetUserVideoList.pull_type.set(paramInt2);
    paramString = a("StorySvc.video_show_video_list");
    paramString.putWupBuffer(localReqGetUserVideoList.toByteArray());
    paramString.extraData.putLong("uid", paramLong);
    b(paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("StorySvc.video_config_get".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      do
      {
        do
        {
          return;
          if ("StorySvc.video_config_set".equals(str))
          {
            f(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.video_get_user_mask_list".equals(str))
          {
            g(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.video_set_user_mask".equals(str))
          {
            d(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.video_get_user_mask_states".equals(str))
          {
            h(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.video_show_video_list".equals(str))
          {
            i(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.pgc_subscribe_media_list".equals(str))
          {
            q(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.pgc_subscribe_recommend_list".equals(str))
          {
            j(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.pgc_person_page".equals(str))
          {
            k(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.pgc_search_feedlist_get".equals(str))
          {
            n(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.pgc_subscribe_operation".equals(str))
          {
            p(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.pgc_person_content".equals(str))
          {
            o(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("StorySvc.pgc_story_detail".equals(str))
          {
            l(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (!"OidbSvc.0x480_9".equals(str)) {
            break;
          }
        } while (!paramToServiceMsg.extraData.getBoolean("reqFromQQStoryHandler"));
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if (!"OidbSvc.0x4ff_9".equals(str)) {
          break;
        }
      } while ((!paramToServiceMsg.extraData.getBoolean("reqFromQQStoryHandler")) || (!QLog.isColorLevel()));
      QLog.d("QQStoryHandler", 2, "CMD_SET_DETAIL_INFO : ");
      return;
      if ("StorySvc.get_pgc_story_url".equals(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"StorySvc.pgc_client_report".equals(str));
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    qqstory_service.ReqGetForbiddenStates localReqGetForbiddenStates = new qqstory_service.ReqGetForbiddenStates();
    Object localObject = new ArrayList();
    try
    {
      ((List)localObject).add(Long.valueOf(Long.parseLong(paramString)));
      localReqGetForbiddenStates.uid_list.set((List)localObject);
      localObject = a("StorySvc.video_get_user_mask_states");
      ((ToServiceMsg)localObject).putWupBuffer(localReqGetForbiddenStates.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("reqUin", paramString);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a(paramString1, paramInt1, 0L, paramString2, paramInt2);
  }
  
  public void a(String paramString, List paramList)
  {
    qqstory_pgc.ReqGetSearchFeedList localReqGetSearchFeedList = new qqstory_pgc.ReqGetSearchFeedList();
    localReqGetSearchFeedList.key_word.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqGetSearchFeedList.type_list.set(paramList);
    paramList = a("StorySvc.pgc_search_feedlist_get");
    paramList.putWupBuffer(localReqGetSearchFeedList.toByteArray());
    b(paramList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getPGCSearchFeedList keyword=" + paramString);
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 1;
    qqstory_service.ReqForbidStory localReqForbidStory = new qqstory_service.ReqForbidStory();
    Object localObject = localReqForbidStory.forbid_my_story;
    if (paramBoolean1)
    {
      i1 = 1;
      ((PBUInt32Field)localObject).set(i1);
      localObject = localReqForbidStory.forbidden;
      if (!paramBoolean2) {
        break label127;
      }
    }
    label127:
    for (int i1 = i2;; i1 = 0)
    {
      ((PBUInt32Field)localObject).set(i1);
      localObject = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          ((List)localObject).add(Long.valueOf(Long.parseLong(str)));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i1 = 0;
      break;
    }
    localReqForbidStory.uid_list.set((List)localObject);
    localObject = a("StorySvc.video_set_user_mask");
    ((ToServiceMsg)localObject).putWupBuffer(localReqForbidStory.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("isNotAllowed", paramBoolean1);
    ((ToServiceMsg)localObject).extraData.putBoolean("isAdd", paramBoolean2);
    ((ToServiceMsg)localObject).extraData.putStringArrayList("uins", paramArrayList);
    b((ToServiceMsg)localObject);
  }
  
  public void a(List paramList)
  {
    qqstory_pgc.ReqGetVideoInfoList localReqGetVideoInfoList = new qqstory_pgc.ReqGetVideoInfoList();
    Object localObject = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(ByteStringMicro.copyFromUtf8((String)localIterator.next()));
    }
    localReqGetVideoInfoList.vid_list.set((List)localObject);
    localReqGetVideoInfoList.platform.set(3, true);
    localObject = a("StorySvc.get_pgc_story_url");
    ((ToServiceMsg)localObject).putWupBuffer(localReqGetVideoInfoList.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getUrlByVid vidList=" + paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (QQStoryManager)this.b.getManager(180);
    int i1 = ((QQStoryManager)localObject).a("StorySvc.pgc_subscribe_media_list");
    if (paramBoolean)
    {
      localObject = ((QQStoryManager)localObject).a("StorySvc.pgc_subscribe_media_list");
      if (localObject != null) {
        b(null, null, localObject, false);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getMediaStoryList seq=" + i1 + " useCache:" + paramBoolean);
    }
    localObject = new qqstory_pgc.ReqGetMediaStory();
    ((qqstory_pgc.ReqGetMediaStory)localObject).seq.set(i1, true);
    ToServiceMsg localToServiceMsg = a("StorySvc.pgc_subscribe_media_list");
    localToServiceMsg.putWupBuffer(((qqstory_pgc.ReqGetMediaStory)localObject).toByteArray());
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getMediaStoryList useCache=" + paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject1 = new qqstory_service.ReqGetForbiddenList();
    if (paramArrayOfByte != null) {
      ((qqstory_service.ReqGetForbiddenList)localObject1).start_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((qqstory_service.ReqGetForbiddenList)localObject1).count.set(paramInt);
    Object localObject2 = ((qqstory_service.ReqGetForbiddenList)localObject1).forbid_my_story;
    int i1;
    if (paramBoolean)
    {
      i1 = 1;
      ((PBUInt32Field)localObject2).set(i1);
      localObject2 = a("StorySvc.video_get_user_mask_list");
      ((ToServiceMsg)localObject2).putWupBuffer(((qqstory_service.ReqGetForbiddenList)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putBoolean("isNotAllowed", paramBoolean);
      localObject1 = ((ToServiceMsg)localObject2).extraData;
      if (paramArrayOfByte != null) {
        break label136;
      }
    }
    label136:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Bundle)localObject1).putBoolean("isFirst", paramBoolean);
      ((ToServiceMsg)localObject2).extraData.putInt("count", paramInt);
      b((ToServiceMsg)localObject2);
      return;
      i1 = 0;
      break;
    }
  }
  
  public void a(String... paramVarArgs)
  {
    a(Arrays.asList(paramVarArgs));
  }
  
  public void b()
  {
    qqstory_service.ReqGetConfig localReqGetConfig = new qqstory_service.ReqGetConfig();
    ToServiceMsg localToServiceMsg = a("StorySvc.video_config_get");
    localToServiceMsg.putWupBuffer(localReqGetConfig.toByteArray());
    b(localToServiceMsg);
  }
  
  public void b(int paramInt)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    Object localObject = new qqstory_struct.UserConfig();
    ((qqstory_struct.UserConfig)localObject).config_key.set(ByteStringMicro.copyFromUtf8("netType"));
    ((qqstory_struct.UserConfig)localObject).config_value.set(paramInt);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localReqSetConfig.user_config.set(localArrayList);
    localObject = a("StorySvc.video_config_set");
    ((ToServiceMsg)localObject).putWupBuffer(localReqSetConfig.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i1;
      int i3;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramFromServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
          break label606;
        }
        i1 = paramToServiceMsg.uint32_result.get();
        if (i1 != 0) {
          break label572;
        }
        long l1 = paramFromServiceMsg.getInt();
        paramFromServiceMsg.get();
        i2 = paramFromServiceMsg.getShort();
        if (!QLog.isColorLevel()) {
          break label612;
        }
        QLog.d("QQStoryHandler", 2, "handleNowTabIsOpen, request success, tlvCount = " + i2 + " uin:" + Long.valueOf(l1));
      }
      catch (Exception paramToServiceMsg)
      {
        int i2;
        int i4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QQStoryHandler", 2, "handleNowTabIsOpen exception: " + paramToServiceMsg.getMessage());
        return;
      }
      if ((paramFromServiceMsg.hasRemaining()) && (i1 < i2))
      {
        i3 = paramFromServiceMsg.getShort();
        i4 = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.d("QQStoryHandler", 2, "handleNowTabIsOpen, TLV type: " + i3 + ",legnth: " + i4);
        }
        if (i3 != 42060) {
          break label536;
        }
        i1 = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.i("QQStoryHandler", 2, "handleNowTabIsOpen nowTabOpenStatus is :" + i1);
        }
        if (i1 != 0) {}
      }
      else
      {
        return;
      }
      i1 -= 1;
      try
      {
        paramToServiceMsg = this.a.a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.a.a(), "00000");
        char c1 = paramToServiceMsg.charAt(2);
        if (paramToServiceMsg.charAt(0) == '1')
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.w("handleNowTabIsOpen", 2, "isOpen = " + i1 + "   plan=" + c1 + "   isLocalChanged=" + bool);
          }
          if (bool) {
            break label499;
          }
          paramToServiceMsg = new Integer[5];
          paramToServiceMsg[0] = Integer.valueOf(1);
          paramToServiceMsg[3] = Integer.valueOf(i1);
          this.b.a().a(paramToServiceMsg, false);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("handleNowTabIsOpen", 2, "" + paramToServiceMsg.getMessage(), paramToServiceMsg);
        return;
      }
      boolean bool = false;
      continue;
      label499:
      a(Integer.valueOf("" + paramToServiceMsg.charAt(3)).intValue() + 1);
      return;
      label536:
      if (QLog.isColorLevel())
      {
        QLog.i("QQStoryHandler", 2, "handleNowTabIsOpen TLV error T: " + i3);
        break label618;
        label572:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QQStoryHandler", 2, "handleNowTabIsOpen pkg_result: " + i1);
        return;
        label606:
        i1 = -1;
        continue;
        label612:
        i1 = 0;
        continue;
      }
      label618:
      i1 += 1;
    }
  }
  
  public void b(String paramString)
  {
    qqstory_pgc.ReqGetStory localReqGetStory = new qqstory_pgc.ReqGetStory();
    localReqGetStory.story_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    ToServiceMsg localToServiceMsg = a("StorySvc.pgc_story_detail");
    localToServiceMsg.putWupBuffer(localReqGetStory.toByteArray());
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler getStoryDetail storyId=" + paramString);
    }
  }
  
  public void c()
  {
    a(((QQStoryManager)this.b.getManager(180)).a("StorySvc.pgc_subscribe_recommend_list"), true);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null) {
      paramToServiceMsg = new qqstory_service.RspGetConfig();
    }
    label164:
    label182:
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.result.error_code.get() == 0) && (paramToServiceMsg.user_config.has()))
        {
          paramToServiceMsg = paramToServiceMsg.user_config.get().iterator();
          int i1 = 0;
          i2 = i1;
          if (!paramToServiceMsg.hasNext()) {
            break label164;
          }
          paramFromServiceMsg = (qqstory_struct.UserConfig)paramToServiceMsg.next();
          if (!"netType".equals(paramFromServiceMsg.config_key.get().toStringUtf8())) {
            break label182;
          }
          i1 = paramFromServiceMsg.config_value.get();
          a(1003, true, Integer.valueOf(i1));
          ((QQStoryManager)this.b.getManager(180)).a(i1);
          i1 = 1;
          continue;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg = null;
        continue;
      }
      int i2 = 0;
      if (i2 == 0) {
        a(1003, false, Integer.valueOf(-1));
      }
      return;
    }
  }
  
  public void d()
  {
    a(false);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isAdd");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isNotAllowed");
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("uins");
    Object localObject;
    if (paramObject != null)
    {
      paramFromServiceMsg = (QQStoryManager)this.b.getManager(180);
      localObject = new qqstory_service.RspForbidStory();
    }
    label202:
    label297:
    label309:
    label382:
    label416:
    for (;;)
    {
      try
      {
        ((qqstory_service.RspForbidStory)localObject).mergeFrom((byte[])paramObject);
        if (((qqstory_service.RspForbidStory)localObject).result.error_code.get() == 0)
        {
          paramObject = paramToServiceMsg.iterator();
          if (!((Iterator)paramObject).hasNext()) {
            break label382;
          }
          localObject = (String)((Iterator)paramObject).next();
          if (!bool1) {
            break label309;
          }
          paramToServiceMsg = paramFromServiceMsg.a((String)localObject);
          if (paramToServiceMsg != null) {
            break label416;
          }
          paramToServiceMsg = new QQStoryUserInfo();
          paramToServiceMsg.uin = ((String)localObject);
          paramToServiceMsg.setNick(ContactUtils.l(this.b, (String)localObject));
          paramFromServiceMsg.jdField_a_of_type_JavaUtilHashMap.put(localObject, paramToServiceMsg);
          if (bool2)
          {
            paramToServiceMsg.isAllowed = 1;
            if (!paramFromServiceMsg.b.contains(paramToServiceMsg)) {
              paramFromServiceMsg.b.add(paramToServiceMsg);
            }
            if (paramToServiceMsg.getStatus() != 1000) {
              break label297;
            }
            paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramToServiceMsg);
            continue;
          }
        }
        else
        {
          i1 = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      for (;;)
      {
        if (i1 == 0) {
          a(1002, false, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        }
        return;
        paramToServiceMsg.isInterested = 1;
        if (paramFromServiceMsg.jdField_a_of_type_JavaUtilList.contains(paramToServiceMsg)) {
          break label202;
        }
        paramFromServiceMsg.jdField_a_of_type_JavaUtilList.add(paramToServiceMsg);
        break label202;
        paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramToServiceMsg);
        break;
        paramToServiceMsg = paramFromServiceMsg.a((String)localObject);
        if (paramToServiceMsg == null) {
          break;
        }
        if (bool2)
        {
          paramToServiceMsg.isAllowed = 0;
          paramFromServiceMsg.b.remove(paramToServiceMsg);
        }
        for (;;)
        {
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramToServiceMsg);
          paramFromServiceMsg.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
          break;
          paramToServiceMsg.isInterested = 0;
          paramFromServiceMsg.jdField_a_of_type_JavaUtilList.remove(paramToServiceMsg);
        }
        a(1002, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        int i1 = 1;
      }
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    if (a(paramObject)) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new qqstory_pgc.RspReport();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (qqstory_pgc.ErrorInfo)paramToServiceMsg.result.get();
        if (paramToServiceMsg.error_code.get() == 0) {
          a(1015, true, new Object[] { Integer.valueOf(paramToServiceMsg.error_code.get()), paramToServiceMsg.error_desc.get().toStringUtf8() });
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i1 = 0;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetClientReport isSuccess=" + true);
        }
        i1 = 1;
        if (i1 == 0) {
          a(1015, false, null);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;) {}
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "QQStoryHandler handleGetClientReport error_code=" + paramToServiceMsg.error_code.get());
      }
      i1 = 0;
      continue;
      paramToServiceMsg.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\QQStoryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */