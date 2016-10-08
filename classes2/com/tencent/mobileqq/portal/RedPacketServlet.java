package com.tencent.mobileqq.portal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageRespInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.new_year_2014.PackData.Pack;
import tencent.im.new_year_2014.PackServer.GetNewPackReq;
import tencent.im.new_year_2014.PackServer.GetNewPackResp;
import tencent.im.new_year_2014.PackServer.PkgReq;
import tencent.im.new_year_2014.PackServer.PkgResp;
import tencent.im.new_year_2014.Unisso.UniSsoServerReq;
import tencent.im.new_year_2014.Unisso.UniSsoServerRsp;
import tencent.im.new_year_ranking.PackRanking.PkgReq;
import tencent.im.new_year_ranking.PackRanking.PkgResp;
import tencent.im.new_year_ranking.PackRanking.QueryRankingReq;
import tencent.im.new_year_ranking.PackRanking.QueryRankingResp;
import tencent.im.new_year_ranking.PackRanking.RankingElem;
import tencent.im.new_year_ranking.PackRanking.RankingInfo;
import tencent.im.new_year_report.PackReport.PkgReq;
import tencent.im.new_year_report.PackReport.Report;
import tencent.im.new_year_report.PackReport.ReportElem;
import tuk;

public class RedPacketServlet
  extends ProtoServlet
{
  private static final int A = 4;
  protected static final String A = "k_cache";
  private static final int jdField_B_of_type_Int = 5;
  private static final String jdField_B_of_type_JavaLangString = "k_cmd";
  private static final int jdField_C_of_type_Int = 6;
  private static final String jdField_C_of_type_JavaLangString = "k_retry";
  private static int jdField_D_of_type_Int = 0;
  private static final String jdField_D_of_type_JavaLangString = "k_sso_id";
  private static final String E = "k_sso_data";
  private static final String F = "k_new_page";
  private static final String G = "k_uin";
  private static final String H = "k_busi";
  private static final String I = "k_id";
  private static final String J = "k_offset";
  private static final String K = "k_version";
  private static final String L = "k_cookie";
  private static final String M = "k_buff";
  private static final String N = "k_opt";
  private static final String O = "k_count";
  private static final String P = "k_b_list";
  private static final String Q = "k_b_ing";
  private static final String R = "ConfigurationService.ReqReportConfig";
  private static final String S = "NY2015.get_new_pack";
  private static final String T = "ConfigurationService.ReqGetConfigByPage";
  private static final String U = "NewYearReport.pack_report";
  private static final String V = "NewYearReport.pack_ranking";
  protected static final int d = 1;
  protected static final int e = 2;
  protected static final int f = 3;
  protected static final int g = 6;
  protected static final int h = 7;
  public static final String h = "PortalManager.Servlet";
  protected static final int i = 8;
  public static final String i = "key_seq";
  public static final int j = 0;
  protected static final String j = "k_id";
  public static final int k = 1;
  protected static final String k = "k_g_uin";
  public static final int l = 2;
  protected static final String l = "k_g_type";
  public static final int m = 3;
  public static final String m = "k_result";
  public static final int n = 4;
  protected static final String n = "k_query_by_web";
  public static final int o = 2;
  protected static final String o = "k_url";
  public static final int p = 0;
  protected static final String p = "k_code";
  public static final int q = 1;
  protected static final String q = "k_msg";
  public static final int r = 5;
  protected static final String r = "k_type";
  private static final int s = 2;
  protected static final String s = "k_s_time";
  private static final int t = -1;
  protected static final String t = "k_e_ctr";
  private static final int u = 4;
  protected static final String u = "k_h_ctr";
  private static final int v = 1;
  protected static final String v = "k_c_ctr";
  private static final int w = 0;
  protected static final String w = "k_b_d";
  private static final int x = 1;
  protected static final String x = "k_money";
  private static final int y = 2;
  protected static final String y = "k_r_type";
  private static final int z = 3;
  protected static final String z = "k_s_follow";
  
  public RedPacketServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt6 < 2) || (!NetworkUtil.h(BaseApplicationImpl.a))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "reportConfig, " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramInt5);
    }
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("k_type", paramInt1);
    localNewIntent.putExtra("k_version", paramInt2);
    localNewIntent.putExtra("k_id", paramInt3);
    localNewIntent.putExtra("k_opt", paramInt4);
    localNewIntent.putExtra("k_code", paramInt5);
    getAppRuntime().startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, paramInt, 0, 0, null, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "requestResult, reqType " + paramInt3 + ", reqNumber " + paramInt2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 8);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("k_type", paramInt1);
    localNewIntent.putExtra("k_count", paramInt2);
    localNewIntent.putExtra("key_seq", paramInt4);
    localNewIntent.putExtra("k_r_type", paramInt3);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "getConfig, " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramArrayOfByte1 + ", " + paramArrayOfByte2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_offset", paramInt2);
    localNewIntent.putExtra("k_id", paramInt3);
    localNewIntent.putExtra("k_version", paramInt1);
    localNewIntent.putExtra("k_cookie", paramArrayOfByte1);
    localNewIntent.putExtra("k_buff", paramArrayOfByte2);
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localNewIntent.putExtra("k_new_page", bool);
      paramAppRuntime.startServlet(localNewIntent);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, ArrayList paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "reportBrashCount, " + paramBundle);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 7);
    localNewIntent.putExtra("k_id", paramInt);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("k_b_ing", paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("k_b_list", paramArrayList);
    localBundle.putAll(paramBundle);
    localNewIntent.putExtras(localBundle);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte['Ā'];
      for (;;)
      {
        int i1 = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i1);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "requestResult, " + paramInt);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_id", paramInt);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i2 = paramIntent.getIntExtra("k_cmd", -1);
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "onReceive, cmd = " + i2);
    }
    int i3 = paramIntent.getIntExtra("k_retry", 0);
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1;
    if (bool2)
    {
      Object localObject1 = WupUtil.b(paramFromServiceMsg.getWupBuffer());
      switch (i2)
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        paramFromServiceMsg = null;
        bool1 = bool2;
      case 1: 
      case 2: 
        for (;;)
        {
          if ((!bool1) && (i3 < 2))
          {
            paramIntent.putExtra("k_retry", i3 + 1);
            if (i2 == 7)
            {
              ThreadManager.b().postDelayed(new tuk(this, paramIntent), 60000L);
              return;
            }
          }
          try
          {
            paramFromServiceMsg = new Bundle();
            try
            {
              i1 = paramIntent.getIntExtra("k_id", -1);
              localObject3 = new Unisso.UniSsoServerRsp();
              ((Unisso.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject1);
              l1 = ((Unisso.UniSsoServerRsp)localObject3).ret.get();
              if (QLog.isColorLevel()) {
                QLog.d("PortalManager.Servlet", 2, "onReceive, result = " + l1);
              }
              if (l1 != 0L) {
                break label585;
              }
              localObject1 = new PackServer.PkgResp();
              ((PackServer.PkgResp)localObject1).mergeFrom(((Unisso.UniSsoServerRsp)localObject3).rspdata.get().toByteArray());
              i4 = ((PackServer.PkgResp)localObject1).errcode.get();
              paramFromServiceMsg.putInt("k_code", i4);
              paramFromServiceMsg.putInt("k_id", i1);
              if ((((PackServer.PkgResp)localObject1).grab_interval.has()) || (((PackServer.PkgResp)localObject1).report_active_interval.has()) || (((PackServer.PkgResp)localObject1).report_normal_interval.has()))
              {
                localObject3 = (PortalManager)((QQAppInterface)getAppRuntime()).getManager(78);
                if (localObject3 != null)
                {
                  if (!((PackServer.PkgResp)localObject1).grab_interval.has()) {
                    break label2214;
                  }
                  l1 = ((PackServer.PkgResp)localObject1).grab_interval.get();
                  label379:
                  if (!((PackServer.PkgResp)localObject1).report_active_interval.has()) {
                    break label2222;
                  }
                  l2 = ((PackServer.PkgResp)localObject1).report_active_interval.get();
                  label399:
                  if (!((PackServer.PkgResp)localObject1).report_normal_interval.has()) {
                    break label2230;
                  }
                  l3 = ((PackServer.PkgResp)localObject1).report_normal_interval.get();
                  label419:
                  ((PortalManager)localObject3).a(l1, l2, l3);
                }
              }
              if (i4 != 0) {
                break label2207;
              }
              localObject1 = (PackServer.GetNewPackResp)((PackServer.PkgResp)localObject1).get_new_pack.get();
              localObject3 = (PackData.Pack)((PackServer.GetNewPackResp)localObject1).data.get();
              paramFromServiceMsg.putInt("k_busi", ((PackData.Pack)localObject3).business.get());
              paramFromServiceMsg.putInt("k_type", ((PackData.Pack)localObject3).type.get());
              paramFromServiceMsg.putBoolean("k_s_follow", ((PackServer.GetNewPackResp)localObject1).follow.get());
              switch (((PackData.Pack)localObject3).type.get())
              {
              case 1: 
                paramFromServiceMsg.putInt("k_money", ((PackData.Pack)localObject3).money.get());
              }
            }
            catch (Throwable localThrowable1) {}
          }
          catch (Throwable localThrowable3)
          {
            for (;;)
            {
              int i1;
              Object localObject3;
              long l1;
              int i4;
              long l2;
              long l3;
              label546:
              Object localObject4;
              Object localObject5;
              paramFromServiceMsg = null;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager.Servlet", 2, "", localThrowable1);
          }
          bool1 = false;
          continue;
          paramFromServiceMsg.putString("k_url", ((PackData.Pack)localObject3).url.get());
          break label2207;
          label585:
          bool1 = true;
          paramFromServiceMsg.putInt("k_type", -1);
          break label2211;
          localObject4 = (PortalManager)((QQAppInterface)getAppRuntime()).getManager(78);
          localObject5 = new ConfigurationService.RespGetConfigByPage();
          ((ConfigurationService.RespGetConfigByPage)localObject5).mergeFrom(localThrowable1);
          i1 = ((ConfigurationService.RespGetConfigByPage)localObject5).result.get();
          paramFromServiceMsg = new Bundle();
          if (i1 != 0) {
            bool1 = false;
          }
        }
      }
    }
    for (;;)
    {
      int i5;
      Object localObject6;
      Object localObject2;
      Object localObject7;
      label2207:
      try
      {
        ((PortalManager)localObject4).c();
        paramFromServiceMsg.putInt("k_code", 3);
        a(1002, 0, 0, 1, i1, i3);
        continue;
        if (((ConfigurationService.RespGetConfigByPage)localObject5).type.get() != 1002)
        {
          a(1002, 0, 0, 1, 3, i3);
          bool1 = false;
        }
        else
        {
          i1 = paramIntent.getIntExtra("k_version", -1);
          i4 = ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).version.get();
          i5 = paramIntent.getIntExtra("k_offset", 0);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PortalManager.Servlet", 1, "onReceive, " + i5 + ", " + i1 + ", " + i4);
          continue;
          ((PortalManager)localObject4).c();
          paramFromServiceMsg.putInt("k_code", 3);
          localObject6 = (ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get();
          localObject2 = paramIntent.getByteArrayExtra("k_buff");
          localObject3 = ((ConfigurationService.RespGetConfigByPage)localObject5).content.get().toByteArray();
          if (localObject2 == null) {
            break label2272;
          }
          i1 = localObject2.length;
          localObject7 = new ByteArrayBuffer(i1 + localObject3.length);
          if (localObject2 != null) {
            ((ByteArrayBuffer)localObject7).append((byte[])localObject2, 0, localObject2.length);
          }
          ((ByteArrayBuffer)localObject7).append((byte[])localObject3, 0, localObject3.length);
          localObject3 = ((ByteArrayBuffer)localObject7).buffer();
          i1 = ((ConfigurationService.PageRespInfo)localObject6).next_offset.get();
          if (i1 == -1)
          {
            localObject2 = ((ConfigurationService.PageRespInfo)localObject6).md5.get();
            localObject7 = PortalUtils.a((byte[])localObject3);
            i1 = ((ConfigurationService.PageRespInfo)localObject6).total_size.get();
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager.Servlet", 1, "onReceive, " + i1 + ", " + (String)localObject2 + ", " + (String)localObject7);
            }
            bool1 = bool2;
            if (i1 != 0) {
              if (TextUtils.equals((CharSequence)localObject7, (CharSequence)localObject2))
              {
                localObject2 = localObject3;
                if (((ConfigurationService.PageRespInfo)localObject6).compress.get() == 1) {
                  localObject2 = a((byte[])localObject3);
                }
                if (localObject2 == null)
                {
                  a(1002, i4, ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get(), 1, 4, 2);
                  bool1 = bool2;
                }
                else
                {
                  localObject3 = null;
                  if (((ConfigurationService.RespGetConfigByPage)localObject5).delay_time.has()) {
                    localObject3 = (ArrayList)((ConfigurationService.RespGetConfigByPage)localObject5).delay_time.get();
                  }
                  localObject2 = PortalManager.a(new String((byte[])localObject2, "utf-8"), i4, (ArrayList)localObject3);
                  if (localObject2 == null)
                  {
                    a(1002, i4, ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get(), 1, 5, i3);
                    bool1 = false;
                  }
                  else
                  {
                    a(1002, i4, ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get(), 1, 0, 2);
                    localObject2 = ((PortalManager)localObject4).a((PortalManager.RedPacketConfig)localObject2);
                    paramFromServiceMsg.putInt("k_code", 4);
                    paramFromServiceMsg.putSerializable("k_cache", (Serializable)localObject2);
                    bool1 = bool2;
                  }
                }
              }
              else
              {
                bool1 = false;
                a(1002, i4, ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get(), 1, 6, i3);
              }
            }
          }
          else
          {
            if (i1 == 0) {
              break label2278;
            }
            a(getAppRuntime(), i4, ((ConfigurationService.PageRespInfo)localObject6).next_offset.get(), ((ConfigurationService.PageRespInfo)localObject6).task_id.get(), ((ConfigurationService.PageRespInfo)localObject6).cookies.get().toByteArray(), (byte[])localObject3);
            return;
            ((PortalManager)localObject4).a(null);
            paramFromServiceMsg.putInt("k_code", 2);
            bool1 = bool2;
            continue;
            bool1 = true;
            paramFromServiceMsg = new Bundle();
            break;
            paramFromServiceMsg = new Bundle();
            bool1 = bool2;
            break;
            paramFromServiceMsg = new Bundle();
          }
        }
      }
      catch (Throwable localThrowable2) {}
      try
      {
        localObject3 = new Unisso.UniSsoServerRsp();
        ((Unisso.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject2);
        localObject5 = new PackRanking.PkgResp();
        ((PackRanking.PkgResp)localObject5).mergeFrom(((Unisso.UniSsoServerRsp)localObject3).rspdata.get().toByteArray());
        i1 = ((PackRanking.PkgResp)localObject5).retcode.get();
        paramFromServiceMsg.putInt("k_code", i1);
        paramFromServiceMsg.putInt("key_seq", paramIntent.getIntExtra("key_seq", -1));
        paramFromServiceMsg.putInt("k_r_type", paramIntent.getIntExtra("k_r_type", -1));
        if (i1 == 0)
        {
          localObject4 = (QQAppInterface)getAppRuntime();
          localObject3 = null;
          localObject2 = null;
          localObject5 = (PackRanking.QueryRankingResp)((PackRanking.PkgResp)localObject5).query_ranking.get();
          if (((PackRanking.QueryRankingResp)localObject5).rank_swipe.has()) {
            localObject3 = (PackRanking.RankingInfo)((PackRanking.QueryRankingResp)localObject5).rank_swipe.get();
          }
          if (((PackRanking.QueryRankingResp)localObject5).rank_combo.has()) {
            localObject2 = (PackRanking.RankingInfo)((PackRanking.QueryRankingResp)localObject5).rank_combo.get();
          }
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("errorCode", i1);
          localObject6 = getAppRuntime().getAccount();
          Object localObject8;
          if (localObject3 != null)
          {
            localObject7 = new JSONObject();
            ((JSONObject)localObject7).put("key", PortalUtils.a((String)localObject6, ((PackRanking.RankingInfo)localObject3).uin.get()));
            ((JSONObject)localObject7).put("ranking", ((PackRanking.RankingInfo)localObject3).ranking.get());
            ((JSONObject)localObject7).put("count", ((PackRanking.RankingInfo)localObject3).count.get());
            ((JSONObject)localObject7).put("nick", ((QQAppInterface)localObject4).b());
            ((JSONObject)localObject5).put("totalHead", localObject7);
            if (((PackRanking.RankingInfo)localObject3).elems.has())
            {
              localObject7 = ((PackRanking.RankingInfo)localObject3).elems.get();
              if (((List)localObject7).size() > 0)
              {
                localObject3 = new JSONArray();
                localObject7 = ((List)localObject7).iterator();
                i1 = 0;
                if (((Iterator)localObject7).hasNext())
                {
                  localObject8 = (PackRanking.RankingElem)((Iterator)localObject7).next();
                  i1 += 1;
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put("key", PortalUtils.a((String)localObject6, ((PackRanking.RankingElem)localObject8).uin.get()));
                  localJSONObject.put("ranking", i1);
                  localJSONObject.put("count", ((PackRanking.RankingElem)localObject8).count.get());
                  localJSONObject.put("nick", ContactUtils.k((QQAppInterface)localObject4, String.valueOf(((PackRanking.RankingElem)localObject8).uin.get())));
                  ((JSONArray)localObject3).put(localJSONObject);
                  continue;
                }
                ((JSONObject)localObject5).put("totalList", localObject3);
              }
            }
          }
          if (localObject2 != null)
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("key", PortalUtils.a((String)localObject6, ((PackRanking.RankingInfo)localObject2).uin.get()));
            ((JSONObject)localObject3).put("ranking", ((PackRanking.RankingInfo)localObject2).ranking.get());
            ((JSONObject)localObject3).put("count", ((PackRanking.RankingInfo)localObject2).count.get());
            ((JSONObject)localObject3).put("nick", ((QQAppInterface)localObject4).b());
            ((JSONObject)localObject5).put("comboHead", localObject3);
            if (((PackRanking.RankingInfo)localObject2).elems.has())
            {
              localObject3 = ((PackRanking.RankingInfo)localObject2).elems.get();
              if (((List)localObject3).size() > 0)
              {
                localObject2 = new JSONArray();
                localObject3 = ((List)localObject3).iterator();
                i1 = 0;
                if (((Iterator)localObject3).hasNext())
                {
                  localObject7 = (PackRanking.RankingElem)((Iterator)localObject3).next();
                  i1 += 1;
                  localObject8 = new JSONObject();
                  ((JSONObject)localObject8).put("key", PortalUtils.a((String)localObject6, ((PackRanking.RankingElem)localObject7).uin.get()));
                  ((JSONObject)localObject8).put("ranking", i1);
                  ((JSONObject)localObject8).put("count", ((PackRanking.RankingElem)localObject7).count.get());
                  ((JSONObject)localObject8).put("nick", ContactUtils.k((QQAppInterface)localObject4, String.valueOf(((PackRanking.RankingElem)localObject7).uin.get())));
                  ((JSONArray)localObject2).put(localObject8);
                  continue;
                }
                ((JSONObject)localObject5).put("comboList", localObject2);
              }
            }
          }
          paramFromServiceMsg.putString("k_result", ((JSONObject)localObject5).toString());
          bool1 = bool2;
          break;
          if (i2 == 2) {
            a(1002, 0, 0, 1, 1, i3);
          }
          paramFromServiceMsg = null;
          bool1 = bool2;
          break;
          getAppRuntime().startServlet((NewIntent)paramIntent);
          return;
          localObject2 = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            localObject2 = new Bundle();
          }
          notifyObserver(paramIntent, i2, bool1, (Bundle)localObject2, PortalManager.class);
          return;
        }
        bool1 = bool2;
      }
      catch (Throwable localThrowable4) {}
      bool1 = bool2;
      label2211:
      break;
      label2214:
      l1 = -1L;
      break label379;
      label2222:
      l2 = -1L;
      break label399;
      label2230:
      l3 = -1L;
      break label419;
      break;
      if ((i5 != 0) || (i1 == i4)) {
        if ((i5 != 0) && (i1 == i4))
        {
          continue;
          break label546;
          label2272:
          i1 = 0;
          continue;
          label2278:
          bool1 = false;
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i1 = paramIntent.getIntExtra("k_cmd", -1);
    int i2 = paramIntent.getIntExtra("k_retry", 0);
    boolean bool = paramIntent.getBooleanExtra("k_new_page", false);
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    if ((i2 == 0) || (bool))
    {
      localObject1 = localObject4;
      localObject2 = localObject3;
      switch (i1)
      {
      default: 
        localObject2 = localObject3;
        localObject1 = localObject4;
      case 3: 
      case 5: 
      case 6: 
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject2 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (!bool)
          {
            paramIntent.putExtra("k_sso_id", (String)localObject2);
            paramIntent.putExtra("k_sso_data", (byte[])localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.Servlet", 2, "onSend, " + i1 + ", " + i2 + ", " + bool + ", " + (String)localObject4 + ", " + localObject3);
      }
      if ((localObject4 != null) && (localObject3 != null))
      {
        paramPacket.setSSOCommand((String)localObject4);
        paramPacket.putSendData((byte[])localObject3);
      }
      do
      {
        do
        {
          return;
          localObject1 = new Unisso.UniSsoServerReq();
          localObject2 = new PackServer.PkgReq();
          ((PackServer.PkgReq)localObject2).cmdtype.set(1);
          ((PackServer.PkgReq)localObject2).net_type.set(NetworkUtil.a(BaseApplicationImpl.a));
          localObject3 = paramIntent.getStringExtra("k_uin");
          i3 = D + 1;
          D = i3;
          int i4 = paramIntent.getIntExtra("k_id", -1);
          ((PackServer.PkgReq)localObject2).uin.set(Long.parseLong((String)localObject3));
          ((PackServer.PkgReq)localObject2).from_id.set(1);
          localObject4 = new PackServer.GetNewPackReq();
          ((PackServer.GetNewPackReq)localObject4).promotion_id.set(i4);
          ((PackServer.GetNewPackReq)localObject4).seq.set(i3);
          ((PackServer.GetNewPackReq)localObject4).signature.set(ByteStringMicro.copyFrom(((String)localObject3 + i4 + i3).getBytes()));
          ((PackServer.PkgReq)localObject2).get_new_pack.set((MessageMicro)localObject4);
          ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackServer.PkgReq)localObject2).toByteArray()));
          localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
          localObject2 = "NY2015.get_new_pack";
          paramIntent.putExtra("k_retry", 2);
          break;
          i3 = paramIntent.getIntExtra("k_id", 0);
          i4 = paramIntent.getIntExtra("k_offset", 0);
          int i5 = paramIntent.getIntExtra("k_version", 0);
          localObject2 = paramIntent.getByteArrayExtra("k_cookie");
          localObject1 = new ConfigurationService.ReqGetConfigByPage();
          localObject3 = new ConfigurationService.PageReqInfo();
          ((ConfigurationService.PageReqInfo)localObject3).task_id.set(i3);
          ((ConfigurationService.PageReqInfo)localObject3).offset.set(i4);
          ((ConfigurationService.PageReqInfo)localObject3).version.set(i5);
          if (localObject2 != null) {
            ((ConfigurationService.PageReqInfo)localObject3).cookies.set(ByteStringMicro.copyFrom((byte[])localObject2));
          }
          ((ConfigurationService.ReqGetConfigByPage)localObject1).page_info.set((MessageMicro)localObject3);
          localObject2 = new ConfigurationService.DeviceInfo();
          localObject3 = new ConfigurationService.Screen();
          ((ConfigurationService.Screen)localObject3).setHasFlag(true);
          ((ConfigurationService.Screen)localObject3).model.set("");
          ((ConfigurationService.Screen)localObject3).width.set((int)DeviceInfoUtil.f());
          ((ConfigurationService.Screen)localObject3).height.set((int)DeviceInfoUtil.g());
          ((ConfigurationService.Screen)localObject3).dpi.set(DeviceInfoUtil.d());
          ((ConfigurationService.Screen)localObject3).multi_touch.set(DeviceInfoUtil.c());
          ((ConfigurationService.DeviceInfo)localObject2).setHasFlag(true);
          ((ConfigurationService.DeviceInfo)localObject2).screen = ((ConfigurationService.Screen)localObject3);
          ((ConfigurationService.ReqGetConfigByPage)localObject1).device_info.set((MessageMicro)localObject2);
          ((ConfigurationService.ReqGetConfigByPage)localObject1).type.set(1002);
          localObject1 = WupUtil.a(((ConfigurationService.ReqGetConfigByPage)localObject1).toByteArray());
          localObject2 = "ConfigurationService.ReqGetConfigByPage";
          break;
          localObject1 = new ConfigurationService.ReqReportConfig();
          localObject2 = new ConfigurationService.ReportConfig();
          ((ConfigurationService.ReportConfig)localObject2).type.set(paramIntent.getIntExtra("k_type", -1));
          ((ConfigurationService.ReportConfig)localObject2).task_id.set(paramIntent.getIntExtra("k_id", -1));
          ((ConfigurationService.ReportConfig)localObject2).version.set(paramIntent.getIntExtra("k_version", -1));
          ((ConfigurationService.ReportConfig)localObject2).report_type.set(paramIntent.getIntExtra("k_opt", -1));
          ((ConfigurationService.ReportConfig)localObject2).result.set(paramIntent.getIntExtra("k_code", -1));
          ((ConfigurationService.ReqReportConfig)localObject1).config_list.add((MessageMicro)localObject2);
          localObject2 = "ConfigurationService.ReqReportConfig";
          localObject1 = WupUtil.a(((ConfigurationService.ReqReportConfig)localObject1).toByteArray());
          paramIntent.putExtra("k_retry", 2);
          break;
          localObject1 = new Unisso.UniSsoServerReq();
          localObject2 = new PackReport.PkgReq();
          ((PackReport.PkgReq)localObject2).promotion_id.set(paramIntent.getIntExtra("k_id", -1));
          ((PackReport.PkgReq)localObject2).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
          long l2 = paramIntent.getLongExtra("key_seq", -1L);
          l1 = l2;
          if (l2 == -1L)
          {
            l1 = NetConnInfoCenter.getServerTimeMillis();
            paramIntent.putExtra("key_seq", l1);
          }
          ((PackReport.PkgReq)localObject2).seq.set(l1);
          localObject3 = paramIntent.getExtras();
        } while (localObject3 == null);
        localObject5 = (ArrayList)((Bundle)localObject3).getSerializable("k_b_list");
      } while (localObject5 == null);
      localObject4 = new ArrayList();
      PackReport.Report localReport = new PackReport.Report();
      Object localObject5 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        RedPacketServlet.BrashReportItem localBrashReportItem = (RedPacketServlet.BrashReportItem)((Iterator)localObject5).next();
        PackReport.ReportElem localReportElem = new PackReport.ReportElem();
        localReportElem.count.set(localBrashReportItem.count);
        localReportElem.timestamp.set(localBrashReportItem.time);
        localReport.elems.add(localReportElem);
      }
      localObject5 = localReport.id;
      if (paramIntent.getBooleanExtra("k_b_ing", false)) {}
      for (long l1 = 200L;; l1 = 100L)
      {
        ((PBUInt64Field)localObject5).set(l1);
        ((ArrayList)localObject4).add(localReport);
        if (((Bundle)localObject3).containsKey("k_e_ctr"))
        {
          localReport = new PackReport.Report();
          localReport.id.set(300L);
          localObject5 = new PackReport.ReportElem();
          ((PackReport.ReportElem)localObject5).count.set(((Bundle)localObject3).getInt("k_e_ctr"));
          ((PackReport.ReportElem)localObject5).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
          localReport.elems.add((MessageMicro)localObject5);
          ((ArrayList)localObject4).add(localReport);
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager.Servlet", 2, "onSend, report EMPTY_COUNTER , elem.count = " + ((PackReport.ReportElem)localObject5).count.get());
          }
        }
        if (((Bundle)localObject3).containsKey("k_h_ctr"))
        {
          localReport = new PackReport.Report();
          localReport.id.set(400L);
          localObject5 = new PackReport.ReportElem();
          ((PackReport.ReportElem)localObject5).count.set(((Bundle)localObject3).getInt("k_h_ctr"));
          ((PackReport.ReportElem)localObject5).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
          localReport.elems.add((MessageMicro)localObject5);
          ((ArrayList)localObject4).add(localReport);
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager.Servlet", 2, "onSend, report HIT_COUNTER , elem.count = " + ((PackReport.ReportElem)localObject5).count.get());
          }
        }
        if (((Bundle)localObject3).containsKey("k_c_ctr"))
        {
          localReport = new PackReport.Report();
          localReport.id.set(500L);
          localObject5 = new PackReport.ReportElem();
          ((PackReport.ReportElem)localObject5).count.set(((Bundle)localObject3).getInt("k_c_ctr"));
          ((PackReport.ReportElem)localObject5).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
          localReport.elems.add((MessageMicro)localObject5);
          ((ArrayList)localObject4).add(localReport);
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager.Servlet", 2, "onSend, report reportContinuous , elem.count = " + ((PackReport.ReportElem)localObject5).count.get());
          }
        }
        ((PackReport.PkgReq)localObject2).report.set((List)localObject4);
        ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackReport.PkgReq)localObject2).toByteArray()));
        localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
        localObject2 = "NewYearReport.pack_report";
        paramIntent.putExtra("k_retry", 2);
        break;
      }
      localObject1 = new Unisso.UniSsoServerReq();
      localObject2 = new PackRanking.PkgReq();
      ((PackRanking.PkgReq)localObject2).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
      ((PackRanking.PkgReq)localObject2).cmdtype.set(1);
      localObject3 = new PackRanking.QueryRankingReq();
      int i3 = paramIntent.getIntExtra("k_type", 3);
      ((PackRanking.QueryRankingReq)localObject3).flag.set(i3);
      i3 = paramIntent.getIntExtra("k_count", 200);
      ((PackRanking.QueryRankingReq)localObject3).num.set(i3);
      ((PackRanking.PkgReq)localObject2).query_ranking.set((MessageMicro)localObject3);
      ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackRanking.PkgReq)localObject2).toByteArray()));
      localObject1 = WupUtil.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
      localObject2 = "NewYearReport.pack_ranking";
      paramIntent.putExtra("k_retry", 2);
      break;
      localObject4 = paramIntent.getStringExtra("k_sso_id");
      localObject3 = paramIntent.getByteArrayExtra("k_sso_data");
      paramIntent.putExtra("k_new_page", false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\RedPacketServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */