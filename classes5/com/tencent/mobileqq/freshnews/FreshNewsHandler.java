package com.tencent.mobileqq.freshnews;

import EncounterSvc.UserDetailLocalInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.Cell;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.FeedComment;
import appoint.define.appoint_define.FeedContent;
import appoint.define.appoint_define.FeedEvent;
import appoint.define.appoint_define.FeedInfo;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.PublisherInfo;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import appoint.define.appoint_define.UserFeed;
import appoint.define.appoint_define.Wifi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import sqe;
import sqg;
import tencent.im.oidb.cmd0x5fc.ReqBody;
import tencent.im.oidb.cmd0x5fc.RspBody;
import tencent.im.oidb.cmd0x9ce.oidb_0x9ce.ReqBody;
import tencent.im.oidb.cmd0x9ce.oidb_0x9ce.RspBody;
import tencent.im.oidb.cmd0x9cf.oidb_0x9cf.ReqBody;
import tencent.im.oidb.cmd0x9cf.oidb_0x9cf.RspBody;
import tencent.im.oidb.cmd0x9cf.oidb_0x9cf.UserLocation;
import tencent.im.oidb.cmd0x9d0.oidb_0x9d0.ReqBody;
import tencent.im.oidb.cmd0x9d0.oidb_0x9d0.RspBody;
import tencent.im.oidb.cmd0x9d1.oidb_0x9d1.ReqBody;
import tencent.im.oidb.cmd0x9d1.oidb_0x9d1.RspBody;
import tencent.im.oidb.cmd0x9d2.oidb_0x9d2.ReqBody;
import tencent.im.oidb.cmd0x9d2.oidb_0x9d2.RspBody;
import tencent.im.oidb.cmd0x9d3.oidb_0x9d3.ReqBody;
import tencent.im.oidb.cmd0x9d3.oidb_0x9d3.RspBody;
import tencent.im.oidb.cmd0x9d4.oidb_0x9d4.ReqBody;
import tencent.im.oidb.cmd0x9d4.oidb_0x9d4.RspBody;
import tencent.im.oidb.cmd0x9d5.oidb_0x9d5.ReqBody;
import tencent.im.oidb.cmd0x9d5.oidb_0x9d5.RspBody;
import tencent.im.oidb.cmd0x9d6.oidb_0x9d6.ReqBody;
import tencent.im.oidb.cmd0x9d6.oidb_0x9d6.RspBody;
import tencent.im.oidb.cmd0x9da.cmd0x9da.ReqBody;
import tencent.im.oidb.cmd0x9da.cmd0x9da.RspBody;

public class FreshNewsHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = "OidbSvc.0x9ce";
  public static final int b = 1;
  public static final String b = "OidbSvc.0x9cf";
  public static final int c = 2;
  public static final String c = "OidbSvc.0x9d2";
  public static final int d = 10;
  public static final String d = "OidbSvc.0x9d6";
  public static final int e = 11;
  public static final String e = "OidbSvc.0x9d0";
  public static final int f = 20;
  public static final String f = "OidbSvc.0x5fc";
  public static final int g = 21;
  public static final String g = "OidbSvc.0x9d1";
  public static final int h = 22;
  public static final String h = "OidbSvc.0x9d3";
  public static final int i = 23;
  public static final String i = "OidbSvc.0x9d4";
  public static final int j = 24;
  public static final String j = "OidbSvc.0x9d5";
  public static final int k = 25;
  public static final String k = "detail_id";
  public static final String l = "get_detail_from";
  public static final String m = "feed_comment_id";
  public static final String n = "OidbSvc.0x5eb_41993";
  public static final String o = "OidbSvc.0x4ff_41993";
  public static final String p = "OidbSvc.0x9da";
  private static final String q = "FreshNewsHandler";
  public NearbyAppInterface a;
  
  public FreshNewsHandler(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramNearbyAppInterface;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    FreshNewsInfo localFreshNewsInfo = new FreshNewsInfo();
    oidb_0x9d1.RspBody localRspBody = new oidb_0x9d1.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    long l1 = 0L;
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("detail_id");
    if (i1 == 0) {
      if (!localRspBody.uint64_tinyid.has()) {
        break label295;
      }
    }
    label295:
    for (l1 = localRspBody.uint64_tinyid.get();; l1 = 0L)
    {
      if (localRspBody.msg_feeds.has()) {
        FreshNewsUtil.a(localFreshNewsInfo, (appoint_define.UserFeed)localRspBody.msg_feeds.get());
      }
      paramToServiceMsg = (FreshNewsManager)this.a.getManager(211);
      paramToServiceMsg.a(localFreshNewsInfo.feedId, localFreshNewsInfo.praiseCount);
      paramToServiceMsg.b(localFreshNewsInfo.feedId, localFreshNewsInfo.commentCount);
      paramObject = localFreshNewsInfo.feedId;
      if (localFreshNewsInfo.praiseFlag == 1)
      {
        bool = true;
        paramToServiceMsg.a((String)paramObject, bool);
        bool = true;
        paramToServiceMsg = null;
      }
      for (;;)
      {
        a(20, bool, new Object[] { paramFromServiceMsg, localFreshNewsInfo, paramToServiceMsg, Integer.valueOf(i1), Long.valueOf(l1) });
        if (QLog.isColorLevel()) {
          QLog.d("FreshNewsHandler", 2, "result:" + i1 + " isSuccess:" + bool + "feedId = " + paramFromServiceMsg);
        }
        return;
        bool = false;
        break;
        if (localRspBody.str_error_tips.has()) {
          paramToServiceMsg = localRspBody.str_error_tips.get();
        } else {
          paramToServiceMsg = null;
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str1 = paramToServiceMsg.extraData.getString("detail_id");
    String str2 = paramToServiceMsg.extraData.getString("feed_comment_id");
    oidb_0x9d3.RspBody localRspBody = new oidb_0x9d3.RspBody();
    int i3 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool = false;
    paramFromServiceMsg = null;
    paramToServiceMsg = null;
    int i2 = 0;
    int i1 = 0;
    if (i3 == 0)
    {
      bool = true;
      if (localRspBody.rpt_msg_comment.has()) {
        paramToServiceMsg = FreshNewsComment.a(localRspBody.rpt_msg_comment.get());
      }
      i2 = i1;
      if (localRspBody.uint32_fetch_old_over.has()) {
        i2 = localRspBody.uint32_fetch_old_over.get();
      }
      if (!localRspBody.uint32_fetch_new_over.has()) {
        break label321;
      }
      i1 = localRspBody.uint32_fetch_new_over.get();
    }
    for (;;)
    {
      a(21, bool, new Object[] { str1, str2, paramToServiceMsg, Integer.valueOf(i2), Integer.valueOf(i1), paramFromServiceMsg });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FreshNewsHandler", 2, "handleFreshNewsComments.isSuccess:" + bool + ",result=" + i3 + ",strErrorTip = " + paramFromServiceMsg + ",feed id =" + str1 + ",refcomment id = " + str2 + ",fetch_old_over = " + i2 + ",fetch_new_over" + i1);
      return;
      if (localRspBody.str_error_tips.has())
      {
        paramFromServiceMsg = localRspBody.str_error_tips.get();
        paramToServiceMsg = null;
        i1 = 0;
      }
      else
      {
        paramToServiceMsg = null;
        i1 = 0;
        continue;
        label321:
        i1 = 0;
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("detail_id");
    oidb_0x9d4.RspBody localRspBody = new oidb_0x9d4.RspBody();
    int i3 = a(paramFromServiceMsg, paramObject, localRspBody);
    if (i3 == 0) {
      if (!localRspBody.rpt_msg_comment.has()) {
        break label322;
      }
    }
    label322:
    for (paramToServiceMsg = FreshNewsComment.a(localRspBody.rpt_msg_comment.get());; paramToServiceMsg = null)
    {
      if (localRspBody.uint32_clear_cache_flag.has()) {}
      for (int i1 = localRspBody.uint32_clear_cache_flag.get();; i1 = 0)
      {
        if (localRspBody.uint32_comment_count.has()) {}
        for (int i2 = localRspBody.uint32_comment_count.get();; i2 = 0)
        {
          paramFromServiceMsg = (FreshNewsManager)this.a.getManager(211);
          paramFromServiceMsg.b(str, i2);
          paramFromServiceMsg.a(str, null, null);
          paramObject = null;
          boolean bool = true;
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = (ToServiceMsg)paramObject;
          for (;;)
          {
            a(22, bool, new Object[] { str, paramFromServiceMsg, Integer.valueOf(i2), Integer.valueOf(i1), paramToServiceMsg });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("FreshNewsHandler", 2, "handlePublishFreshNewsComment.result:" + i3 + " ,isSuccess:" + bool + ",totalCommentCounts =" + i2 + ",clearCacheFlag = " + i1);
            return;
            if (localRspBody.str_error_tips.has())
            {
              paramToServiceMsg = localRspBody.str_error_tips.get();
              i1 = 0;
              i2 = 0;
              bool = false;
              paramFromServiceMsg = (FromServiceMsg)localObject;
            }
            else
            {
              i1 = 0;
              i2 = 0;
              paramToServiceMsg = null;
              bool = false;
              paramFromServiceMsg = (FromServiceMsg)localObject;
            }
          }
        }
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("ismore");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("isPullToRefresh");
    Object localObject2 = new oidb_0x9cf.RspBody();
    int i2 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    ArrayList localArrayList = new ArrayList(20);
    Object localObject1 = Boolean.valueOf(false);
    if (i2 == 0) {
      if (!((oidb_0x9cf.RspBody)localObject2).bytes_cookie.has()) {
        break label622;
      }
    }
    label622:
    for (paramFromServiceMsg = ((oidb_0x9cf.RspBody)localObject2).bytes_cookie.get().toByteArray();; paramFromServiceMsg = null)
    {
      paramObject = localObject1;
      if (((oidb_0x9cf.RspBody)localObject2).uint32_completed.has())
      {
        paramObject = localObject1;
        if (((oidb_0x9cf.RspBody)localObject2).uint32_completed.get() == 1) {
          paramObject = Boolean.valueOf(true);
        }
      }
      if (((oidb_0x9cf.RspBody)localObject2).rpt_msg_feeds.has()) {}
      for (localObject1 = ((oidb_0x9cf.RspBody)localObject2).rpt_msg_feeds.get();; localObject1 = null)
      {
        if (localObject1 != null)
        {
          int i1 = 0;
          while (i1 < ((List)localObject1).size())
          {
            localObject2 = new FreshNewsInfo();
            FreshNewsUtil.a((FreshNewsInfo)localObject2, (appoint_define.UserFeed)((List)localObject1).get(i1));
            localArrayList.add(localObject2);
            i1 += 1;
          }
        }
        localObject1 = (FreshNewsManager)this.a.getManager(211);
        if (!bool2)
        {
          ((FreshNewsManager)localObject1).a(localArrayList, 1, true);
          ((FreshNewsManager)localObject1).e();
        }
        if (!((Boolean)paramObject).booleanValue())
        {
          bool1 = true;
          ((FreshNewsManager)localObject1).a(localArrayList, paramFromServiceMsg, bool1);
          localObject2 = null;
          bool1 = true;
          localObject1 = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)localObject2;
        }
        for (;;)
        {
          a(0, bool1, new Object[] { paramFromServiceMsg, localObject1, localArrayList, paramObject, Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          HashMap localHashMap = new HashMap();
          localObject2 = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            localObject2 = "0";
          }
          localHashMap.put("param_FailCode", localObject2);
          localHashMap.put("param_NetType", String.valueOf(NetworkUtil.a(BaseApplication.getContext())));
          localHashMap.put("param_DeviceType", String.valueOf(StatisticConstants.a()));
          long l1 = paramToServiceMsg.extraData.getLong("request_start_time");
          l1 = SystemClock.uptimeMillis() - l1;
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(b(), "actGetFreshNewsFeed", bool1, l1, 0L, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("FreshNewsHandler", 2, "handleGetFeed result:" + i2 + " isSuccess:" + bool1 + ", complete:" + paramObject + ",cookie=" + localObject1 + ",isMore=" + bool2 + ",requestDuration:" + l1 + ",isPullToRefresh:" + bool3);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("FreshNewsHandler", 4, "handleGetFeedList:" + localArrayList);
          }
          return;
          bool1 = false;
          break;
          if ((localObject2 != null) && (((oidb_0x9cf.RspBody)localObject2).str_error_tips.has()))
          {
            paramFromServiceMsg = ((oidb_0x9cf.RspBody)localObject2).str_error_tips.get();
            paramObject = localObject1;
            localObject1 = null;
          }
          else
          {
            paramObject = localObject1;
            localObject1 = null;
            paramFromServiceMsg = null;
          }
        }
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      return;
    }
    oidb_0x9d6.RspBody localRspBody = new oidb_0x9d6.RspBody();
    int i2 = a(paramFromServiceMsg, paramObject, localRspBody);
    if (i2 == 0) {
      if (!localRspBody.uint32_praise_count.has()) {
        break label228;
      }
    }
    label81:
    label174:
    label226:
    label228:
    for (int i1 = localRspBody.uint32_praise_count.get();; i1 = 0)
    {
      boolean bool1;
      if (paramToServiceMsg.extraData == null)
      {
        bool1 = true;
        if (paramToServiceMsg.extraData != null) {
          break label174;
        }
        paramToServiceMsg = "";
        a(2, true, new Object[] { paramToServiceMsg, Integer.valueOf(i1), Boolean.valueOf(bool1) });
        bool1 = true;
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label226;
        }
        QLog.d("FreshNewsHandler", 2, "handleLikeFeed. result=" + i2 + ", isSuccess:" + bool1);
        return;
        bool1 = paramToServiceMsg.extraData.getBoolean("operation");
        break;
        paramToServiceMsg = paramToServiceMsg.extraData.getString("feed_id");
        break label81;
        bool1 = bool2;
        if (localRspBody != null)
        {
          bool1 = bool2;
          if (localRspBody.str_error_tips.has())
          {
            localRspBody.str_error_tips.get();
            bool1 = bool2;
          }
        }
      }
      break;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("feedid");
    paramToServiceMsg = new oidb_0x9d2.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    boolean bool;
    if (i1 == 0)
    {
      paramToServiceMsg = (FreshNewsManager)this.a.getManager(211);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(str);
      }
      paramToServiceMsg = null;
      bool = true;
    }
    for (;;)
    {
      a(1, bool, new Object[] { str, paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsHandler", 2, "handleDeleteFeed result:" + i1 + " isSuccess:" + bool + ", errTip=" + paramToServiceMsg);
      }
      return;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.str_error_tips.has()))
      {
        paramToServiceMsg = paramToServiceMsg.str_error_tips.get();
        bool = false;
      }
      else
      {
        paramToServiceMsg = null;
        bool = false;
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    oidb_0x9d0.RspBody localRspBody = new oidb_0x9d0.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isFirst");
    int i2 = paramToServiceMsg.extraData.getInt("mode");
    paramFromServiceMsg = null;
    ArrayList localArrayList = new ArrayList();
    paramObject = Boolean.valueOf(false);
    if (i1 == 0) {
      if (!localRspBody.bytes_cookie.has()) {
        break label508;
      }
    }
    label508:
    for (paramFromServiceMsg = localRspBody.bytes_cookie.get().toByteArray();; paramFromServiceMsg = null)
    {
      paramToServiceMsg = (ToServiceMsg)paramObject;
      if (localRspBody.uint32_completed.has())
      {
        paramToServiceMsg = (ToServiceMsg)paramObject;
        if (localRspBody.uint32_completed.get() == 1) {
          paramToServiceMsg = Boolean.valueOf(true);
        }
      }
      if (localRspBody.rpt_msg_feeds.has()) {}
      for (Object localObject = localRspBody.rpt_msg_feeds.get();; localObject = null)
      {
        if (localRspBody.msg_user_info.has()) {}
        for (paramObject = (appoint_define.PublisherInfo)localRspBody.msg_user_info.get();; paramObject = null)
        {
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              appoint_define.FeedInfo localFeedInfo = (appoint_define.FeedInfo)((Iterator)localObject).next();
              FreshNewsInfo localFreshNewsInfo = new FreshNewsInfo();
              FreshNewsUtil.a(localFreshNewsInfo, localFeedInfo, (appoint_define.PublisherInfo)paramObject, i2);
              localArrayList.add(localFreshNewsInfo);
            }
          }
          paramObject = (FreshNewsManager)this.a.getManager(211);
          if (i2 == 10)
          {
            if (bool2)
            {
              ((FreshNewsManager)paramObject).a(localArrayList, 3, true);
              ((FreshNewsManager)paramObject).f();
            }
            if (!paramToServiceMsg.booleanValue())
            {
              bool1 = true;
              ((FreshNewsManager)paramObject).b(localArrayList, paramFromServiceMsg, bool1);
              bool1 = true;
              localObject = null;
              paramObject = paramToServiceMsg;
              paramToServiceMsg = (ToServiceMsg)localObject;
            }
          }
          for (;;)
          {
            a(10, bool1, new Object[] { paramToServiceMsg, paramFromServiceMsg, localArrayList, paramObject, Boolean.valueOf(bool2) });
            if (QLog.isColorLevel()) {
              QLog.d("freshnews", 2, "handleUserFreshNews, result:" + i1 + " isSuccess:" + bool1 + ", errTips:" + paramToServiceMsg + ",complete:" + localRspBody.uint32_completed.get() + ",cookie:" + paramFromServiceMsg);
            }
            return;
            bool1 = false;
            break;
            if (bool2) {
              ((FreshNewsManager)paramObject).g();
            }
            if (!paramToServiceMsg.booleanValue()) {}
            for (bool1 = true;; bool1 = false)
            {
              ((FreshNewsManager)paramObject).c(localArrayList, paramFromServiceMsg, bool1);
              break;
            }
            if ((localRspBody != null) && (localRspBody.str_error_tips.has())) {
              paramToServiceMsg = localRspBody.str_error_tips.get();
            } else {
              paramToServiceMsg = null;
            }
          }
        }
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    cmd0x5fc.RspBody localRspBody = new cmd0x5fc.RspBody();
    int i3 = a(paramFromServiceMsg, paramObject, localRspBody);
    long l1 = -1L;
    List localList = null;
    ArrayList localArrayList = new ArrayList();
    if (i3 == 0) {
      if (!localRspBody.uint64_max_fresh_event_id.has()) {
        break label875;
      }
    }
    label861:
    label875:
    for (l1 = localRspBody.uint64_max_fresh_event_id.get();; l1 = -1L)
    {
      if (localRspBody.rpt_msg_feed_event_list.has()) {}
      for (localList = localRspBody.rpt_msg_feed_event_list.get();; localList = null)
      {
        FreshNewsManager localFreshNewsManager = (FreshNewsManager)this.a.getManager(211);
        if (localList != null)
        {
          if (!localFreshNewsManager.d())
          {
            localFreshNewsManager.a(new sqe(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
            return;
          }
          int i1 = localList.size() - 1;
          if (i1 >= 0)
          {
            paramObject = (appoint_define.FeedEvent)localList.get(i1);
            if (4 == ((appoint_define.FeedEvent)paramObject).uint32_eventtype.get())
            {
              long l2 = ((appoint_define.FeedEvent)paramObject).uint64_cancel_event_id.get();
              int i2 = i1 - 1;
              while (i2 >= 0)
              {
                if (l2 == ((appoint_define.FeedEvent)localList.get(i2)).uint64_event_id.get()) {
                  localList.remove(i2);
                }
                i2 -= 1;
              }
              localFreshNewsManager.g(l2);
            }
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder(256);
                paramFromServiceMsg.append("-----------------------------------\n");
                paramFromServiceMsg.append("eventId=").append(((appoint_define.FeedEvent)paramObject).uint64_event_id.get()).append("\n");
                paramFromServiceMsg.append("eventType=").append(((appoint_define.FeedEvent)paramObject).uint32_eventtype.get()).append("\n");
                paramFromServiceMsg.append("eventTime=").append(((appoint_define.FeedEvent)paramObject).uint32_time.get()).append("\n");
                paramFromServiceMsg.append("eventTips=").append(((appoint_define.FeedEvent)paramObject).str_event_tips.get()).append("\n");
                if (((appoint_define.FeedEvent)paramObject).msg_user_info.has())
                {
                  appoint_define.StrangerInfo localStrangerInfo = (appoint_define.StrangerInfo)((appoint_define.FeedEvent)paramObject).msg_user_info.get();
                  if (localStrangerInfo != null)
                  {
                    paramFromServiceMsg.append("pubNickname=").append(localStrangerInfo.bytes_nickname.get().toStringUtf8()).append("\n");
                    paramFromServiceMsg.append("pubTinyid=").append(localStrangerInfo.uint64_tinyid.get()).append("\n");
                  }
                }
                if (((appoint_define.FeedEvent)paramObject).msg_feed_info.has())
                {
                  paramObject = (appoint_define.FeedInfo)((appoint_define.FeedEvent)paramObject).msg_feed_info.get();
                  if (paramObject != null)
                  {
                    paramFromServiceMsg.append("feedid=").append(((appoint_define.FeedInfo)paramObject).str_feed_id.get()).append("\n");
                    if (((appoint_define.FeedInfo)paramObject).msg_feed_content.has())
                    {
                      paramObject = (appoint_define.FeedContent)((appoint_define.FeedInfo)paramObject).msg_feed_content.get();
                      if ((paramObject != null) && (((appoint_define.FeedContent)paramObject).rpt_str_pic_url.has()) && (((appoint_define.FeedContent)paramObject).rpt_str_pic_url.get() != null)) {
                        paramFromServiceMsg.append("picUrl=").append((String)((appoint_define.FeedContent)paramObject).rpt_str_pic_url.get().get(0)).append("\n");
                      }
                    }
                  }
                }
                paramFromServiceMsg.append("-----------------------------------");
                QLog.i("FreshNewsHandler", 2, paramFromServiceMsg.toString());
              }
              i1 -= 1;
              break;
              paramFromServiceMsg = new FreshNewsNotify();
              FreshNewsUtil.a(paramFromServiceMsg, (appoint_define.FeedEvent)paramObject);
              localArrayList.add(paramFromServiceMsg);
            }
          }
        }
        localFreshNewsManager.a(localArrayList);
        paramFromServiceMsg = new ArrayList();
        paramObject = localArrayList.iterator();
        while (((Iterator)paramObject).hasNext()) {
          paramFromServiceMsg.add(Long.valueOf(((FreshNewsNotify)((Iterator)paramObject).next()).eventId));
        }
        localFreshNewsManager.a(paramFromServiceMsg);
        paramObject = localList;
        paramFromServiceMsg = null;
        bool = true;
        for (;;)
        {
          if (paramToServiceMsg.extraData.getBoolean("needUpdateUI", true)) {
            a(11, bool, new Object[] { paramFromServiceMsg, Long.valueOf(l1), localArrayList });
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          paramFromServiceMsg = new StringBuilder().append("handleGetFreshNewsNotify  result:").append(i3).append(", isSuccess:").append(bool).append(", maxid=").append(localRspBody.uint64_max_event_id.get()).append(", eventSize=");
          if (paramObject == null) {}
          for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(((List)paramObject).size()))
          {
            QLog.i("FreshNewsHandler", 2, paramToServiceMsg);
            return;
            if ((localRspBody == null) || (!localRspBody.str_error_tips.has())) {
              break label861;
            }
            paramFromServiceMsg = localRspBody.str_error_tips.get();
            paramObject = localList;
            break;
          }
          paramFromServiceMsg = null;
          paramObject = localList;
        }
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0x9ce.RspBody localRspBody = new oidb_0x9ce.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      bool = true;
      this.a.a().f();
      a(24, bool, localRspBody.msg_feed_info);
      paramObject = new HashMap();
      if (!localRspBody.str_error_tips.has()) {
        break label230;
      }
    }
    label230:
    for (paramFromServiceMsg = localRspBody.str_error_tips.get();; paramFromServiceMsg = "0")
    {
      ((HashMap)paramObject).put("param_FailCode", paramFromServiceMsg);
      ((HashMap)paramObject).put("param_NetType", String.valueOf(NetworkUtil.a(BaseApplication.getContext())));
      ((HashMap)paramObject).put("param_DeviceType", String.valueOf(StatisticConstants.a()));
      long l1 = paramToServiceMsg.extraData.getLong("request_start_time");
      l1 = SystemClock.uptimeMillis() - l1;
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(b(), "actPublishFreshNews", bool, l1, 0L, (HashMap)paramObject, "");
      if (QLog.isColorLevel()) {
        QLog.i("FreshNewsHandler", 2, "handlePublishFreshNews, result=" + i1 + ",duration=" + l1);
      }
      return;
      bool = false;
      ThreadManager.c().post(new sqg(this, localRspBody));
      break;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(25, false, new Object[] { "data error." });
      if (QLog.isDevelopLevel()) {
        QLog.i("FreshNewsHandler", 4, "handleGetTopicList: req and res is null.");
      }
      return;
    }
    boolean bool;
    Object localObject;
    label93:
    int i1;
    if (paramToServiceMsg.extraData == null)
    {
      bool = false;
      localObject = new cmd0x9da.RspBody();
      if (a(paramFromServiceMsg, paramObject, (MessageMicro)localObject) != 0) {
        break label405;
      }
      if (!((cmd0x9da.RspBody)localObject).bytes_cookie.has()) {
        break label235;
      }
      paramToServiceMsg = ((cmd0x9da.RspBody)localObject).bytes_cookie.get().toByteArray();
      if (!((cmd0x9da.RspBody)localObject).uint32_completed.has()) {
        break label240;
      }
      i1 = ((cmd0x9da.RspBody)localObject).uint32_completed.get();
      label114:
      if (!((cmd0x9da.RspBody)localObject).rpt_msg_feeds.has()) {
        break label246;
      }
    }
    label235:
    label240:
    label246:
    for (paramFromServiceMsg = ((cmd0x9da.RspBody)localObject).rpt_msg_feeds.get();; paramFromServiceMsg = null)
    {
      if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty())) {
        break label251;
      }
      a(25, true, new Object[] { null, Integer.valueOf(i1), paramToServiceMsg, null, Boolean.valueOf(bool) });
      NearbyUtils.a(NearbyTopicFeedActivity.a, "handle_oidb_0x9da", new Object[] { null, Integer.valueOf(i1), paramToServiceMsg, null });
      return;
      bool = paramToServiceMsg.extraData.getBoolean("is_refresh");
      break;
      paramToServiceMsg = null;
      break label93;
      i1 = -1;
      break label114;
    }
    label251:
    int i3 = paramFromServiceMsg.size();
    paramObject = new ArrayList(i3);
    int i2 = 0;
    if (i2 < i3)
    {
      localObject = (appoint_define.UserFeed)paramFromServiceMsg.get(i2);
      if (localObject == null) {}
      for (;;)
      {
        i2 += 1;
        break;
        FreshNewsInfo localFreshNewsInfo = new FreshNewsInfo();
        FreshNewsUtil.a(localFreshNewsInfo, (appoint_define.UserFeed)localObject);
        ((ArrayList)paramObject).add(localFreshNewsInfo);
      }
    }
    a(25, true, new Object[] { paramObject, Integer.valueOf(i1), paramToServiceMsg, null, Boolean.valueOf(bool) });
    NearbyUtils.a(NearbyTopicFeedActivity.a, "handle_oidb_0x9da", new Object[] { paramObject, Integer.valueOf(i1), paramToServiceMsg, null });
    return;
    label405:
    if (((cmd0x9da.RspBody)localObject).str_error_tips.has()) {}
    for (paramToServiceMsg = ((cmd0x9da.RspBody)localObject).str_error_tips.get();; paramToServiceMsg = "")
    {
      a(25, false, new Object[] { null, Integer.valueOf(-1), null, paramToServiceMsg, Boolean.valueOf(bool) });
      NearbyUtils.a(NearbyTopicFeedActivity.a, "handle_oidb_0x9da", new Object[] { null, Integer.valueOf(-1), null, paramToServiceMsg });
      return;
    }
  }
  
  public appoint_define.LBSInfo a()
  {
    appoint_define.LBSInfo localLBSInfo = null;
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a == 0.0D) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b == 0.0D))
    {
      SosoInterface.a(60000L, getClass().getSimpleName());
      localObject1 = SosoInterface.a();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localLBSInfo = new appoint_define.LBSInfo();
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
        {
          localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new appoint_define.Wifi();
              ((appoint_define.Wifi)localObject4).uint64_mac.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long);
              ((appoint_define.Wifi)localObject4).int32_rssi.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int);
              localLBSInfo.rpt_msg_wifis.add((MessageMicro)localObject4);
            }
          }
        }
        if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new appoint_define.Cell();
              ((appoint_define.Cell)localObject4).int32_cellid.set(((SosoInterface.SosoCell)localObject3).d);
              ((appoint_define.Cell)localObject4).int32_lac.set(((SosoInterface.SosoCell)localObject3).c);
              ((appoint_define.Cell)localObject4).int32_rssi.set(((SosoInterface.SosoCell)localObject3).e);
              ((appoint_define.Cell)localObject4).int32_mcc.set(((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int);
              ((appoint_define.Cell)localObject4).int32_mnc.set(((SosoInterface.SosoCell)localObject3).b);
              localLBSInfo.rpt_msg_cells.add((MessageMicro)localObject4);
            }
          }
        }
        if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)
        {
          localObject2 = new appoint_define.GPS();
          ((appoint_define.GPS)localObject2).int32_lon.set((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D));
          ((appoint_define.GPS)localObject2).int32_lat.set((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D));
          ((appoint_define.GPS)localObject2).int32_type.set(0);
          localLBSInfo.msg_gps.set((MessageMicro)localObject2);
          localObject1 = localLBSInfo;
        }
      }
      else
      {
        do
        {
          return (appoint_define.LBSInfo)localObject1;
          localObject1 = localLBSInfo;
        } while (!QLog.isColorLevel());
        QLog.d("FreshNewsHandler", 2, "lbsinfo is null..");
        return null;
      }
      return localLBSInfo;
    }
  }
  
  protected Class a()
  {
    return FreshNewsObserver.class;
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FreshNewsHandler", 4, "getTopicList: id: " + paramLong + " count: " + paramInt);
    }
    cmd0x9da.ReqBody localReqBody = new cmd0x9da.ReqBody();
    localReqBody.uint64_topic_id.set(paramLong);
    localReqBody.uint32_feed_num.set(paramInt);
    if (paramArrayOfByte != null) {
      localReqBody.bytes_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramArrayOfByte = a("OidbSvc.0x9da", 2522, 0, localReqBody.toByteArray());
    paramArrayOfByte.extraData.putBoolean("is_refresh", paramBoolean);
    b(paramArrayOfByte);
  }
  
  public void a(FreshNewsInfo paramFreshNewsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsHandler", 2, "publishFreshNews");
    }
    if ((paramFreshNewsInfo == null) || (paramFreshNewsInfo.photoUrls == null) || (paramFreshNewsInfo.photoUrls.size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsHandler", 2, "publishFreshNews, photoUrls=" + paramFreshNewsInfo.photoUrls.toString() + ", content=" + paramFreshNewsInfo.feedContent);
    }
    Object localObject2 = new appoint_define.Elem();
    ((appoint_define.Elem)localObject2).str_content.set(paramFreshNewsInfo.feedContent);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localObject2);
    localObject2 = new appoint_define.RichText();
    ((appoint_define.RichText)localObject2).rpt_msg_elems.set((List)localObject1);
    localObject1 = new appoint_define.FeedContent();
    ((appoint_define.FeedContent)localObject1).msg_text.set((MessageMicro)localObject2);
    ((appoint_define.FeedContent)localObject1).rpt_str_pic_url.set(paramFreshNewsInfo.photoUrls);
    localObject2 = new oidb_0x9ce.ReqBody();
    ((oidb_0x9ce.ReqBody)localObject2).msg_feed_content.set((MessageMicro)localObject1);
    localObject1 = LbsUtils.a(getClass().getSimpleName());
    if (localObject1 != null) {
      ((oidb_0x9ce.ReqBody)localObject2).msg_lbs_info.set((MessageMicro)localObject1);
    }
    int i1 = 0;
    if (paramFreshNewsInfo.topicInfo != null)
    {
      ((oidb_0x9ce.ReqBody)localObject2).uint64_topic_id.set(paramFreshNewsInfo.topicInfo.jdField_a_of_type_Long);
      i1 = 7;
    }
    paramFreshNewsInfo = a("OidbSvc.0x9ce", 2510, i1, ((oidb_0x9ce.ReqBody)localObject2).toByteArray());
    paramFreshNewsInfo.extraData.putLong("request_start_time", SystemClock.uptimeMillis());
    b(paramFreshNewsInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!a(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FreshNewsHandler", 2, "cmdfilter error = " + str);
      return;
      if ("OidbSvc.0x9cf".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9d6".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9d2".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9d0".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5fc".equals(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9ce".equals(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9d4".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9d5".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9d1".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9d3".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9da".equals(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9d3".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x9da".equals(str));
    l(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      Object localObject = new oidb_0x9d5.ReqBody();
      ((oidb_0x9d5.ReqBody)localObject).str_feed_id.set(paramString1);
      ((oidb_0x9d5.ReqBody)localObject).str_comment_id.set(paramString2);
      localObject = a("OidbSvc.0x9d5", 2517, 0, ((oidb_0x9d5.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("detail_id", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("feed_comment_id", paramString2);
      b((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("FreshNewsHandler", 2, "deleteComment.feed_id= " + paramString1 + "comment_id=" + paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsHandler", 2, "performLike feedId = " + paramString + ", like=" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new oidb_0x9d6.ReqBody();
    ((oidb_0x9d6.ReqBody)localObject).str_feed_id.set(paramString);
    PBUInt32Field localPBUInt32Field = ((oidb_0x9d6.ReqBody)localObject).uint32_operation;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      localPBUInt32Field.set(i1);
      localObject = a("OidbSvc.0x9d6", 2518, 0, ((oidb_0x9d6.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("operation", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putString("feed_id", paramString);
      b((ToServiceMsg)localObject);
      return;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FreshNewsHandler", 2, "getFreshNewsNotify:lastId=" + paramLong1 + " , readId=" + paramLong2 + ", fetchCount=" + paramInt + ", needUpdateUI=" + paramBoolean);
    }
    Object localObject = new cmd0x5fc.ReqBody();
    ((cmd0x5fc.ReqBody)localObject).uint64_last_feed_event_id.set(paramLong1);
    ((cmd0x5fc.ReqBody)localObject).uint64_read_feed_event_id.set(paramLong2);
    ((cmd0x5fc.ReqBody)localObject).uint32_fetch_feed_event_count.set(paramInt);
    localObject = a("OidbSvc.0x5fc", 1532, 0, ((cmd0x5fc.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("needUpdateUI", paramBoolean);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("OidbSvc.0x9cf");
      this.b.add("OidbSvc.0x9d6");
      this.b.add("OidbSvc.0x9d2");
      this.b.add("OidbSvc.0x9d0");
      this.b.add("OidbSvc.0x5fc");
      this.b.add("OidbSvc.0x9ce");
      this.b.add("OidbSvc.0x9d4");
      this.b.add("OidbSvc.0x9d5");
      this.b.add("OidbSvc.0x9d1");
      this.b.add("OidbSvc.0x5eb_41993");
      this.b.add("OidbSvc.0x4ff_41993");
      this.b.add("OidbSvc.0x9d3");
      this.b.add("OidbSvc.0x9da");
    }
    return !this.b.contains(paramString);
  }
  
  public boolean a(String paramString1, appoint_define.FeedComment paramFeedComment, int paramInt, String paramString2)
  {
    if ((paramFeedComment == null) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    Object localObject = new oidb_0x9d4.ReqBody();
    ((oidb_0x9d4.ReqBody)localObject).str_feed_id.set(paramString1);
    ((oidb_0x9d4.ReqBody)localObject).msg_comment.set(paramFeedComment);
    ((oidb_0x9d4.ReqBody)localObject).uint32_max_fetch_count.set(paramInt);
    ((oidb_0x9d4.ReqBody)localObject).str_last_comment_id.set(paramString2);
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x9d4", 2516, 0, ((oidb_0x9d4.ReqBody)localObject).toByteArray());
    localToServiceMsg.extraData.putString("detail_id", paramString1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramFeedComment.msg_reply_info.has())
    {
      localObject = paramFeedComment.msg_reply_info.str_comment_id.get();
      localBundle.putString("beReplyedCommentId", (String)localObject);
      if (!paramFeedComment.msg_content.has()) {
        break label250;
      }
      paramFeedComment = FreshNewsUtil.a((appoint_define.RichText)paramFeedComment.msg_content.get());
      localToServiceMsg.extraData.putString("commentContent", paramFeedComment);
    }
    for (;;)
    {
      b(localToServiceMsg);
      ((FreshNewsManager)this.a.getManager(211)).b(System.currentTimeMillis());
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsHandler", 2, "publishFreshNewsComment.feed_id= " + paramString1 + ",max_tetch_count=" + paramInt + ",last_comment_id = " + paramString2);
      }
      return true;
      localObject = "";
      break;
      label250:
      localToServiceMsg.extraData.putString("commentContent", "");
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsHandler", 2, "getFreshNewsComments.feed_id= " + paramString1 + "refcomment_id=" + paramString2 + ",fetch_old_count=" + paramInt1 + ",fetch_new_count=" + paramInt2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = new oidb_0x9d3.ReqBody();
    ((oidb_0x9d3.ReqBody)localObject).str_feed_id.set(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      ((oidb_0x9d3.ReqBody)localObject).str_comment_id.set(paramString2);
    }
    ((oidb_0x9d3.ReqBody)localObject).uint32_fetch_old_count.set(paramInt1);
    ((oidb_0x9d3.ReqBody)localObject).uint32_fetch_new_count.set(paramInt2);
    localObject = a("OidbSvc.0x9d3", 2515, 0, ((oidb_0x9d3.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("detail_id", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("feed_comment_id", paramString2);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a(paramString, paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getUserFreshNews:uinOrTinyId= ").append(paramString).append(" , cookies = ");
      if (paramArrayOfByte != null) {
        break label176;
      }
      localObject = "null";
      QLog.d("FreshNews", 2, localObject + "useUin=" + paramBoolean);
    }
    for (;;)
    {
      long l1;
      try
      {
        l1 = Long.parseLong(paramString);
        paramString = new oidb_0x9d0.ReqBody();
        if (!paramBoolean) {
          break label231;
        }
        paramString.uint64_req_uin.set(l1);
        if (paramArrayOfByte != null) {
          paramString.bytes_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        }
        paramString.uint32_feed_num.set(paramInt1);
        paramString = a("OidbSvc.0x9d0", 2512, 0, paramString.toByteArray());
        localObject = paramString.extraData;
        if (paramArrayOfByte != null) {
          break label243;
        }
        paramBoolean = true;
        ((Bundle)localObject).putBoolean("isFirst", paramBoolean);
        paramString.extraData.putInt("mode", paramInt2);
        b(paramString);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        label176:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FreshNews", 2, "getUserFreshNews:Parsing tinyid error:uinOrTinyId= " + paramString + " ,msg:" + paramArrayOfByte.getMessage());
        return false;
      }
      localObject = paramArrayOfByte;
      break;
      label231:
      paramString.uint64_req_uid.set(l1);
      continue;
      label243:
      paramBoolean = false;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsHandler", 2, "getFreshNewsFeeds cookies = " + paramArrayOfByte);
    }
    Object localObject2 = a();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsHandler", 2, "getFreshNewsFeeds lbsinfo is null..");
      }
      return false;
    }
    Object localObject1 = new oidb_0x9cf.ReqBody();
    ((oidb_0x9cf.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    if (paramArrayOfByte != null) {
      ((oidb_0x9cf.ReqBody)localObject1).bytes_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    if (this.a != null)
    {
      localObject2 = this.a.a;
      if (localObject2 != null)
      {
        oidb_0x9cf.UserLocation localUserLocation = new oidb_0x9cf.UserLocation();
        localUserLocation.strCity.set(((UserDetailLocalInfo)localObject2).strCity);
        localUserLocation.strProvince.set(((UserDetailLocalInfo)localObject2).strProvince);
        ((oidb_0x9cf.ReqBody)localObject1).msg_location.set(localUserLocation);
        if (QLog.isColorLevel()) {
          QLog.d("FreshNewsHandler", 2, "getFreshNewsFeeds(), userLocation, strCity=" + localUserLocation.strCity.get() + ", strProvince=" + localUserLocation.strProvince.get());
        }
      }
    }
    localObject1 = a("OidbSvc.0x9cf", 2511, 0, ((oidb_0x9cf.ReqBody)localObject1).toByteArray());
    if (paramArrayOfByte == null) {
      ((ToServiceMsg)localObject1).extraData.putBoolean("ismore", false);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject1).extraData.putLong("request_start_time", SystemClock.uptimeMillis());
      ((ToServiceMsg)localObject1).extraData.putBoolean("isPullToRefresh", paramBoolean);
      b((ToServiceMsg)localObject1);
      return true;
      ((ToServiceMsg)localObject1).extraData.putBoolean("ismore", true);
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str1 = paramToServiceMsg.extraData.getString("detail_id");
    String str2 = paramToServiceMsg.extraData.getString("feed_comment_id");
    paramToServiceMsg = new oidb_0x9d5.RspBody();
    int i3 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    boolean bool1 = false;
    boolean bool2 = false;
    paramFromServiceMsg = null;
    int i2 = 0;
    int i1 = 0;
    if (i3 == 0)
    {
      bool1 = true;
      bool2 = true;
      if (paramToServiceMsg.uint32_comment_count.has()) {
        i1 = paramToServiceMsg.uint32_comment_count.get();
      }
      i2 = i1;
      if (!paramToServiceMsg.str_comment_count_info.has()) {
        break label284;
      }
      paramToServiceMsg = paramToServiceMsg.str_comment_count_info.get();
      bool1 = bool2;
    }
    for (;;)
    {
      a(23, bool1, new Object[] { str1, str2, Integer.valueOf(i1), paramToServiceMsg, paramFromServiceMsg });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FreshNewsHandler", 2, "handleDeleteComment.result:" + i3 + " isSuccess:" + bool1 + "feed id = " + str1 + "comment id = " + str2 + "commentCount =" + i1 + "str_comment_count_info = " + paramToServiceMsg + ",strErrorTip=" + paramFromServiceMsg);
      return;
      if (paramToServiceMsg.str_error_tips.has())
      {
        paramFromServiceMsg = paramToServiceMsg.str_error_tips.get();
        i1 = 0;
        paramToServiceMsg = "";
        bool1 = bool2;
      }
      else
      {
        label284:
        i1 = i2;
        paramToServiceMsg = "";
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsHandler", 2, "getFreshNewsDetail.feedid = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = new oidb_0x9d1.ReqBody();
    ((oidb_0x9d1.ReqBody)localObject).str_feed_id.set(paramString);
    localObject = a("OidbSvc.0x9d1", 2513, 0, ((oidb_0x9d1.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("detail_id", paramString);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsHandler", 2, "deleteFeed.feeid = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = new oidb_0x9d2.ReqBody();
    ((oidb_0x9d2.ReqBody)localObject).str_feed_id.set(paramString);
    localObject = a("OidbSvc.0x9d2", 2514, 0, ((oidb_0x9d2.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("feedid", paramString);
    b((ToServiceMsg)localObject);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */