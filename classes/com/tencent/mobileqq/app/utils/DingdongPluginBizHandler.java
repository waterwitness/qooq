package com.tencent.mobileqq.app.utils;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.ContentElement;
import com.trunk.Qworkflow.Qworkflow.Notification;
import com.trunk.Qworkflow.Qworkflow.Observer;
import com.trunk.Qworkflow.Qworkflow.RemindTimer;
import com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.UserSource;
import com.trunk.Qworkflow.Qworkflow.Workflow;
import com.trunk.Qworkflow.Qworkflow.WorkflowContent;
import cooperation.dingdong.DingdongPluginDataFactory;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qog;
import qoh;
import tencent.im.oidb.cmd0x4f2.oidb_0x4f2.ReqBody;
import tencent.im.oidb.cmd0x4f2.oidb_0x4f2.RspBody;
import tencent.im.oidb.cmd0x508.oidb_0x508.ReqBody;
import tencent.im.oidb.cmd0x508.oidb_0x508.RspBody;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.AppNoticeInfo;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.GetAppNoticeRsp;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.GetOfficeNoticeRsp;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.NoticeInfo;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.ReqBody;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.RspBody;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdRsp;
import tencent.im.oidb.cmd0x589.oidb_0x589.ReqBody;
import tencent.im.oidb.cmd0x589.oidb_0x589.RspBody;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleByIDReq;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleByIDRsp;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleResult;
import tencent.im.oidb.cmd0x592.oidb_0x592.ReqBody;
import tencent.im.oidb.cmd0x592.oidb_0x592.RspBody;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.DecreaseUnreadMailCountReq;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.GetUnreadMailCountRsp;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.ReqBody;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.RspBody;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.UnreadMailCountInfo;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetLatestNodeInfoReq;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetLatestNodeInfoRsp;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.LiteMailBrief;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ReqBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ResultMsg;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.RspBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.SourceID;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.UnreadMailCountInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f.SourceID;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.LiteMailIndexInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.SourceID;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.StateChangeNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.UnreadMailCountChanged;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.UnreadMailCountInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.PbOfficeNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x9c.SubMsgType0x9c.MsgBody;

public class DingdongPluginBizHandler
  extends BusinessHandler
{
  private static final int a = 1;
  public static final String a = "DingdongPluginBizHandler";
  private static final int b = 3;
  public static final String b = "OidbSvc.0x8f6_1";
  public static final String c = "OidbSvc.0x51d_1";
  public static final String d = "OidbSvc.0x51d_2";
  public static final String e = "OidbSvc.0x508_1";
  public static final String f = "OidbSvc.0x508_2";
  public static final String g = "OidbSvc.0x4f2";
  public static final String h = "OidbSvc.0x8f9_13";
  public static final String i = "OidbSvc.0x589";
  public static final String j = "OidbSvc.0x592";
  private static final String k = "OidbSvc.0x8f6_1_subCmd";
  private static final String l = "OidbSvc.0x8f9_13_subCmd";
  private static final String m = "ReqSeq";
  
  public DingdongPluginBizHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private DingdongPluginBizObserver.ScheduleMoreSummaryData a(long paramLong, oidb_0x592.GetScheduleResult paramGetScheduleResult)
  {
    if (paramGetScheduleResult.msg_schedule.has()) {}
    for (Object localObject1 = (Qworkflow.Workflow)paramGetScheduleResult.msg_schedule.get(); localObject1 == null; localObject1 = null) {
      return null;
    }
    DingdongPluginBizObserver.ScheduleMoreSummaryData localScheduleMoreSummaryData = new DingdongPluginBizObserver.ScheduleMoreSummaryData();
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
    if (((Qworkflow.Workflow)localObject1).bytes_workflow_id.has()) {
      localScheduleSummaryData.id = ((Qworkflow.Workflow)localObject1).bytes_workflow_id.get().toStringUtf8();
    }
    if (((Qworkflow.Workflow)localObject1).uint64_author_uin.has()) {
      localScheduleSummaryData.authorUin = Long.toString(((Qworkflow.Workflow)localObject1).uint64_author_uin.get());
    }
    Object localObject4;
    Object localObject3;
    if (((Qworkflow.Workflow)localObject1).msg_workflow_content.has())
    {
      if (((Qworkflow.Workflow)localObject1).msg_workflow_content.bytes_title.has()) {
        localScheduleSummaryData.title = ((Qworkflow.Workflow)localObject1).msg_workflow_content.bytes_title.get().toStringUtf8();
      }
      if (((Qworkflow.Workflow)localObject1).msg_workflow_content.rpt_content_list.has())
      {
        localObject2 = ((Qworkflow.Workflow)localObject1).msg_workflow_content.rpt_content_list.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Qworkflow.ContentElement)((Iterator)localObject2).next();
          if ((((Qworkflow.ContentElement)localObject4).bytes_userdef.has()) && (((Qworkflow.ContentElement)localObject4).rpt_text_list.has()) && (((Qworkflow.Text)((Qworkflow.ContentElement)localObject4).rpt_text_list.get(0)).bytes_content.has()))
          {
            localObject3 = ((Qworkflow.Text)((Qworkflow.ContentElement)localObject4).rpt_text_list.get(0)).bytes_content.get().toStringUtf8();
            localObject4 = ((Qworkflow.ContentElement)localObject4).bytes_userdef.get().toStringUtf8();
            if ("loc".equals(localObject4)) {
              localScheduleSummaryData.location = ((String)localObject3);
            } else if ("mark".equals(localObject4)) {
              localScheduleSummaryData.mark = ((String)localObject3);
            }
          }
        }
      }
    }
    if (((Qworkflow.Workflow)localObject1).msg_remind_timer.has())
    {
      localScheduleSummaryData.beginTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint64_start_time.get();
      localScheduleSummaryData.endTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint64_end_time.get();
      if (((Qworkflow.Workflow)localObject1).msg_remind_timer.uint32_remind_flag.get() != 0) {
        localScheduleSummaryData.offsetTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint32_remind_offset.get();
      }
    }
    Object localObject2 = new ArrayList();
    if (((Qworkflow.Workflow)localObject1).rpt_msg_observers.has())
    {
      localObject1 = ((Qworkflow.Workflow)localObject1).rpt_msg_observers.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Qworkflow.Observer)((Iterator)localObject1).next();
        if (((Qworkflow.Observer)localObject3).msg_observer_source.has())
        {
          localObject4 = new DingdongPluginBizObserver.ConcernUinData();
          ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_a_of_type_JavaLangString = String.valueOf(((Qworkflow.Observer)localObject3).uint64_uin.get());
          ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_b_of_type_JavaLangString = String.valueOf(((Qworkflow.Observer)localObject3).msg_observer_source.uint64_source_code.get());
          switch (((Qworkflow.Observer)localObject3).msg_observer_source.enum_source_type.get())
          {
          }
          for (;;)
          {
            ((ArrayList)localObject2).add(localObject4);
            break;
            ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_a_of_type_Int = 3;
            continue;
            ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_a_of_type_Int = 2;
            continue;
            ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_a_of_type_Int = 1;
          }
        }
      }
    }
    localScheduleSummaryData.specialFlag = paramGetScheduleResult.uint32_result.get();
    localScheduleMoreSummaryData.jdField_a_of_type_Long = paramLong;
    localScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData = localScheduleSummaryData;
    localScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
    return localScheduleMoreSummaryData;
  }
  
  private String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    c();
    Object localObject = new Qworkflow.Notification();
    for (;;)
    {
      try
      {
        ((Qworkflow.Notification)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (Qworkflow.ScheduleChangeNotification)((Qworkflow.Notification)localObject).msg_schedule_change.get();
        if (1 != paramArrayOfByte.enum_change_type.get()) {
          break label175;
        }
        localObject = new DingdongPluginBizObserver.ScheduleNotificationData();
        ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData = DingdongPluginDataFactory.a((Qworkflow.Text)paramArrayOfByte.msg_summary.get());
        if (((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData != null)
        {
          ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData.id = paramArrayOfByte.bytes_workflow_id.get().toStringUtf8();
          ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData.authorUin = String.valueOf(paramArrayOfByte.uint64_author_uin.get());
          DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
          if (paramArrayOfByte.uint32_remind_bell_switch.get() != 1) {
            break label234;
          }
          paramBoolean = true;
          localScheduleSummaryData.hasAlarm = paramBoolean;
          if (((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_Int == 0)
          {
            paramBoolean = true;
            super.a(10, paramBoolean, localObject);
            break label232;
          }
        }
        else
        {
          ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_Int = -1;
          continue;
        }
        paramBoolean = false;
      }
      catch (Exception paramArrayOfByte)
      {
        return paramArrayOfByte.toString();
      }
      continue;
      label175:
      localObject = new DingdongPluginBizObserver.ScheduleChangeNotifyData();
      ((DingdongPluginBizObserver.ScheduleChangeNotifyData)localObject).jdField_a_of_type_Int = 0;
      ((DingdongPluginBizObserver.ScheduleChangeNotifyData)localObject).jdField_a_of_type_JavaLangString = paramArrayOfByte.bytes_workflow_id.get().toStringUtf8();
      ((DingdongPluginBizObserver.ScheduleChangeNotifyData)localObject).jdField_a_of_type_Long = paramArrayOfByte.uint64_author_uin.get();
      ((DingdongPluginBizObserver.ScheduleChangeNotifyData)localObject).jdField_b_of_type_Int = paramArrayOfByte.enum_change_type.get();
      super.a(9, true, localObject);
      label232:
      return null;
      label234:
      paramBoolean = false;
    }
  }
  
  private void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int n = 0;
    label7:
    int i1;
    if (n < paramList.size())
    {
      Object localObject = (oidb_0x51d.AppNoticeInfo)paramList.get(n);
      long l1 = ((oidb_0x51d.AppNoticeInfo)localObject).opt_uint64_appdid.get();
      localObject = (oidb_0x51d.NoticeInfo)((oidb_0x51d.AppNoticeInfo)localObject).opt_msg_app_notice.get();
      i1 = ((oidb_0x51d.NoticeInfo)localObject).opt_uint32_notice_count.get();
      ((oidb_0x51d.NoticeInfo)localObject).opt_uint32_notice_version.get();
      if (l1 != 1800000002L) {}
    }
    for (n = 1;; n = 0)
    {
      if (n != 0)
      {
        if (i1 <= 0) {
          break;
        }
        OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + this.b.getLongAccountUin(), true);
        a(5, true, null);
        ((DingdongPluginManager)this.b.getManager(114)).a(i1);
        return;
        n += 1;
        break label7;
      }
      OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + this.b.getLongAccountUin(), false);
      a(5, true, null);
      return;
      i1 = 0;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int n = paramFromServiceMsg.getResultCode();
    Object localObject = new oidb_0x589.RspBody();
    int i1;
    if (1000 == n)
    {
      i1 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      n = i1;
      if (i1 == 0) {
        break label407;
      }
      QLog.e("DingdongPluginBizHandler", 1, "0x589 respond oidb error:retCode[" + i1 + "].");
      n = i1;
    }
    for (;;)
    {
      paramFromServiceMsg = new DingdongPluginBizObserver.GetOpenIdNotifyData();
      paramFromServiceMsg.jdField_a_of_type_Long = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
      if (n != 0) {
        break label485;
      }
      try
      {
        paramToServiceMsg = ((oidb_0x589.RspBody)localObject).rpt_msg_open_id.get();
        paramFromServiceMsg.jdField_b_of_type_Long = ((oidb_0x589.RspBody)localObject).uint64_app_id.get();
        paramFromServiceMsg.jdField_b_of_type_Int = paramToServiceMsg.size();
        paramObject = new DingdongPluginBizObserver.GetOpenIdNotifyData.GetOpenIdData[paramFromServiceMsg.jdField_b_of_type_Int];
        i1 = 0;
        for (;;)
        {
          if (i1 < paramFromServiceMsg.jdField_b_of_type_Int)
          {
            localObject = (oidb_0x589.GetUserOpenIdRsp)paramToServiceMsg.get(i1);
            paramObject[i1] = new DingdongPluginBizObserver.GetOpenIdNotifyData.GetOpenIdData();
            paramObject[i1].jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData = new DingdongPluginBizObserver.GetOpenIdNotifyData.ReqData();
            paramObject[i1].jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Int = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint32_req_flag.get();
            paramObject[i1].jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Long = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint64_req_uin.get();
            paramObject[i1].jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_b_of_type_Long = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint64_req_host_uin.get();
            paramObject[i1].jdField_a_of_type_Int = ((oidb_0x589.GetUserOpenIdRsp)localObject).uint32_result.get();
            paramObject[i1].jdField_a_of_type_JavaLangString = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_open_id.get().toStringUtf8();
            paramObject[i1].jdField_b_of_type_JavaLangString = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_group_open_id.get().toStringUtf8();
            paramObject[i1].jdField_c_of_type_JavaLangString = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_discuss_open_id.get().toStringUtf8();
            paramObject[i1].jdField_d_of_type_JavaLangString = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_token.get().toStringUtf8();
            i1 += 1;
            continue;
            QLog.e("DingdongPluginBizHandler", 1, "0x589 respond msf error:retCode[" + n + "],errMsg[" + paramFromServiceMsg.getBusinessFailMsg() + "]");
            label407:
            break;
          }
        }
        paramFromServiceMsg.jdField_a_of_type_ArrayOfComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$GetOpenIdData = ((DingdongPluginBizObserver.GetOpenIdNotifyData.GetOpenIdData[])paramObject);
        paramFromServiceMsg.jdField_a_of_type_Int = 1;
      }
      catch (NullPointerException paramToServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.jdField_a_of_type_Int = -1;
          QLog.e("DingdongPluginBizHandler", 1, "0x589 handleRsp nullPointer error:[" + paramToServiceMsg.toString() + "]");
          n = -1;
        }
      }
    }
    if (n == 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.a(6, bool, paramFromServiceMsg);
      return;
      label485:
      paramFromServiceMsg.jdField_a_of_type_Int = -1;
      break;
    }
  }
  
  private void c()
  {
    if (!OfficeCenterSharedPref.a().a("officecenter_always_show_flag", false)) {
      OfficeCenterSharedPref.a().b("officecenter_always_show_flag", true);
    }
    a(13, true, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int n = paramFromServiceMsg.getResultCode();
    oidb_0x508.RspBody localRspBody = new oidb_0x508.RspBody();
    if (1000 == n)
    {
      n = a(paramFromServiceMsg, paramObject, localRspBody);
      if (n == 0)
      {
        int i1 = localRspBody.opt_uint32_result.get();
        n = i1;
        if (i1 == 0) {
          break label293;
        }
        QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond biz error: retCode[" + i1 + "].");
        n = i1;
        paramFromServiceMsg = new DingdongPluginBizObserver.GetAppListData();
        paramFromServiceMsg.jdField_a_of_type_Long = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
        if (n != 0) {
          break label296;
        }
        paramFromServiceMsg.jdField_a_of_type_Int = localRspBody.opt_uint32_result.get();
        paramFromServiceMsg.jdField_a_of_type_JavaLangString = localRspBody.opt_bytes_errinfo.get().toStringUtf8();
        paramFromServiceMsg.jdField_b_of_type_Long = localRspBody.opt_uint64_update_seq.get();
        paramToServiceMsg = localRspBody.rpt_uint64_appid_list.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramToServiceMsg.size());
          paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList.addAll(paramToServiceMsg);
        }
        label206:
        if (n != 0) {
          break label304;
        }
      }
    }
    label293:
    label296:
    label304:
    for (boolean bool = true;; bool = false)
    {
      super.a(11, bool, paramFromServiceMsg);
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond oidb error: retCode[" + n + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond msf error: retCode[" + n + "].");
      break;
      paramFromServiceMsg.jdField_a_of_type_Int = -1;
      break label206;
    }
  }
  
  private void d()
  {
    oidb_0x508.ReqBody localReqBody = new oidb_0x508.ReqBody();
    localReqBody.rpt_uint64_update_seq.set(0L);
    localReqBody.setHasFlag(true);
    super.b(super.a("OidbSvc.0x508_1", 1288, 1, localReqBody.toByteArray()));
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int n = paramFromServiceMsg.getResultCode();
    oidb_0x4f2.RspBody localRspBody = new oidb_0x4f2.RspBody();
    if (1000 == n)
    {
      n = a(paramFromServiceMsg, paramObject, localRspBody);
      if (n == 0)
      {
        int i1 = localRspBody.opt_uint32_result.get();
        n = i1;
        if (i1 == 0) {
          break label293;
        }
        QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond biz error: retCode[" + i1 + "].");
        n = i1;
        paramFromServiceMsg = new DingdongPluginBizObserver.SetAppListData();
        paramFromServiceMsg.jdField_a_of_type_Long = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
        if (n != 0) {
          break label296;
        }
        paramFromServiceMsg.jdField_a_of_type_Int = localRspBody.opt_uint32_result.get();
        paramFromServiceMsg.jdField_a_of_type_JavaLangString = localRspBody.opt_bytes_errinfo.get().toStringUtf8();
        paramFromServiceMsg.jdField_b_of_type_Long = localRspBody.opt_uint64_update_seq.get();
        paramToServiceMsg = localRspBody.rpt_uint64_appid_list.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramToServiceMsg.size());
          paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList.addAll(paramToServiceMsg);
        }
        label206:
        if (n != 0) {
          break label304;
        }
      }
    }
    label293:
    label296:
    label304:
    for (boolean bool = true;; bool = false)
    {
      super.a(12, bool, paramFromServiceMsg);
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond oidb error: retCode[" + n + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond msf error: retCode[" + n + "].");
      break;
      paramFromServiceMsg.jdField_a_of_type_Int = -1;
      break label206;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int n = paramFromServiceMsg.getResultCode();
    int i2 = ((Integer)paramToServiceMsg.getAttribute("OidbSvc.0x8f6_1_subCmd")).intValue();
    paramToServiceMsg = new oidb_cmd0x8f6.RspBody();
    if (1000 == n)
    {
      n = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (n == 0)
      {
        int i1 = paramToServiceMsg.uint32_result.get();
        n = i1;
        if (i1 != 0)
        {
          QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond biz error:subCmd[" + i2 + "],retCode[" + i1 + "].");
          n = i1;
        }
        switch (i2)
        {
        }
      }
    }
    label362:
    do
    {
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond oidb error:subCmd[" + i2 + "],retCode[" + n + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond msf error:subCmd[" + i2 + "],retCode[" + n + "].");
      break;
      paramFromServiceMsg = new DingdongPluginBizObserver.UnreadNumUpdateData();
      if (n == 0) {}
      for (;;)
      {
        try
        {
          paramToServiceMsg = (oidb_cmd0x8f6.UnreadMailCountInfo)((oidb_cmd0x8f6.GetUnreadMailCountRsp)paramToServiceMsg.msg_get_umc.get()).msg_unread.get();
          paramFromServiceMsg.jdField_b_of_type_Int = paramToServiceMsg.uint32_unread_count.get();
          paramFromServiceMsg.jdField_c_of_type_Int = paramToServiceMsg.uint32_data_version.get();
          if (paramFromServiceMsg.jdField_a_of_type_Int != 0) {
            break label362;
          }
          bool = true;
          super.a(1, bool, paramFromServiceMsg);
          return;
        }
        catch (NullPointerException paramToServiceMsg)
        {
          QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond biz package error:subCmd[0x1],errMsg[" + paramToServiceMsg.toString() + "].");
          paramFromServiceMsg.jdField_a_of_type_Int = -1;
          continue;
        }
        paramFromServiceMsg.jdField_a_of_type_Int = n;
        continue;
        boolean bool = false;
      }
    } while (n != 0);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int n = paramFromServiceMsg.getResultCode();
    int i2 = ((Integer)paramToServiceMsg.getAttribute("OidbSvc.0x8f9_13_subCmd")).intValue();
    paramToServiceMsg = new oidb_0x8f9.RspBody();
    if (1000 == n)
    {
      n = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (n != 0) {}
    }
    for (;;)
    {
      try
      {
        int i1 = paramToServiceMsg.msg_result_msg.uint32_result.get();
        n = i1;
        if (i1 != 0)
        {
          n = i1;
          paramFromServiceMsg = paramToServiceMsg.msg_result_msg.bytes_err_msg.get().toStringUtf8();
          n = i1;
          QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond biz package error -> subCmd" + i2 + "retCode[" + i1 + "],errMsg[" + paramFromServiceMsg + "].");
          n = i1;
        }
      }
      catch (NullPointerException paramFromServiceMsg)
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond biz package error -> subCmd" + i2 + "retCode[" + n + "],errMsg[" + paramFromServiceMsg.toString() + "].");
        n = -1;
        continue;
      }
      switch (i2)
      {
      default: 
        return;
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond oidb package error -> subCmd" + i2 + "retCode[" + n + "].");
        continue;
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond msf error -> subCmd" + i2 + "retCode[" + n + "].");
      }
    }
    paramFromServiceMsg = new DingdongPluginBizObserver.NodeUpdateData();
    if (n == 0) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg.jdField_a_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.uint32_result.get();
        if (132 == paramFromServiceMsg.jdField_a_of_type_Int)
        {
          paramFromServiceMsg.jdField_a_of_type_Int = 0;
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$LastMsgUpdateData = new DingdongPluginBizObserver.LastMsgUpdateData();
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData = new DingdongPluginBizObserver.UnreadNumUpdateData();
          if (QLog.isColorLevel()) {
            QLog.i("DingdongPluginBizHandler", 2, "0x8f9_13 respond no feed data.");
          }
          if (paramFromServiceMsg.jdField_a_of_type_Int != 0) {
            break label847;
          }
          bool = true;
          super.a(2, bool, paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.jdField_a_of_type_Int == 0)
        {
          paramObject = new DingdongPluginBizObserver.LastMsgUpdateData();
          if (paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.has())
          {
            ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_a_of_type_JavaLangString = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.bytes_feeds_id.get().toStringUtf8();
            ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_c_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint32_last_modify_time.get();
            ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_b_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.msg_source_id.uint32_source_type.get();
            ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_b_of_type_JavaLangString = String.valueOf(paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.msg_source_id.uint64_source_code.get());
            ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_c_of_type_JavaLangString = String.valueOf(paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint64_author_uin.get());
            ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_d_of_type_JavaLangString = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.bytes_feeds_summary.get().toStringUtf8();
            if (1 == paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint32_summary_truncate_flag.get()) {
              ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_d_of_type_JavaLangString = (((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_d_of_type_JavaLangString.substring(0, ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject).jdField_d_of_type_JavaLangString.length() - 1) + "...");
            }
          }
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$LastMsgUpdateData = ((DingdongPluginBizObserver.LastMsgUpdateData)paramObject);
          if (!paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.has()) {
            continue;
          }
          paramObject = new DingdongPluginBizObserver.UnreadNumUpdateData();
          ((DingdongPluginBizObserver.UnreadNumUpdateData)paramObject).jdField_b_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.uint32_unread_count.get();
          ((DingdongPluginBizObserver.UnreadNumUpdateData)paramObject).jdField_c_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.uint32_data_version.get();
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData = ((DingdongPluginBizObserver.UnreadNumUpdateData)paramObject);
          continue;
        }
      }
      catch (NullPointerException paramToServiceMsg)
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_13 respond biz error:errMsg[" + paramToServiceMsg.toString() + "].");
        paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData = null;
        paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$LastMsgUpdateData = null;
        paramFromServiceMsg.jdField_a_of_type_Int = -1;
        continue;
      }
      if (paramToServiceMsg.msg_rsp_get_latest_node_info.bytes_err_msg.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.msg_rsp_get_latest_node_info.bytes_err_msg.get().toStringUtf8();; paramToServiceMsg = "serveUnknownError")
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_13 respond biz error -> retCode[" + paramFromServiceMsg.jdField_a_of_type_Int + ",errMsg[" + paramToServiceMsg + "].");
        break;
      }
      paramFromServiceMsg.jdField_a_of_type_Int = n;
      continue;
      label847:
      boolean bool = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int n = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x508.RspBody();
    if (1000 == n)
    {
      n = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (n == 0)
      {
        n = paramToServiceMsg.opt_uint32_result.get();
        if (n != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond biz error: retCode[" + n + "].");
        }
      }
    }
    for (;;)
    {
      new qog(this, paramToServiceMsg).execute(new Void[] { null, null, null });
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond oidb error: retCode[" + n + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond msf error: retCode[" + n + "].");
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int n = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x51d.RspBody();
    if (1000 == n)
    {
      n = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (n == 0)
      {
        n = paramToServiceMsg.opt_uint32_result.get();
        if (n != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond biz error: retCode[" + n + "].");
        }
      }
    }
    for (;;)
    {
      if (paramToServiceMsg.opt_msg_office_notice_rsp.has())
      {
        paramToServiceMsg = (oidb_0x51d.GetOfficeNoticeRsp)paramToServiceMsg.opt_msg_office_notice_rsp.get();
        if (paramToServiceMsg.opt_msg_office_notice.has())
        {
          paramToServiceMsg = (oidb_0x51d.NoticeInfo)paramToServiceMsg.opt_msg_office_notice.get();
          n = paramToServiceMsg.opt_uint32_notice_count.get();
          int i1 = paramToServiceMsg.opt_uint32_notice_version.get();
          QLog.e("DingdongPluginBizHandler", 4, "handleRspMsg_0x51d_1 cnt: " + n + " ver: " + i1);
          if (n > 0)
          {
            OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + this.b.getLongAccountUin(), true);
            OfficeCenterSharedPref.a().a("officecenter_red_point_cnt_" + this.b.getLongAccountUin(), n);
            OfficeCenterSharedPref.a().a("officecenter_red_point_ver_" + this.b.getLongAccountUin(), i1);
            a(5, true, null);
          }
        }
      }
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond oidb error: retCode[" + n + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond msf error: retCode[" + n + "].");
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int n = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x51d.RspBody();
    if (1000 == n)
    {
      n = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (n == 0)
      {
        n = paramToServiceMsg.opt_uint32_result.get();
        if (n != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond biz error: retCode[" + n + "].");
        }
      }
    }
    for (;;)
    {
      if (paramToServiceMsg.opt_msg_app_notice_rsp.has())
      {
        paramToServiceMsg = (oidb_0x51d.GetAppNoticeRsp)paramToServiceMsg.opt_msg_app_notice_rsp.get();
        if (paramToServiceMsg.has()) {
          a(paramToServiceMsg.rpt_msg_app_notice.get());
        }
      }
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond oidb error: retCode[" + n + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond msf error: retCode[" + n + "].");
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = null;
    int n = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg.getResultCode();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    if (1000 == n)
    {
      try
      {
        localOIDBSSOPkg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        n = localOIDBSSOPkg.uint32_result.get();
        if (n != 0)
        {
          paramFromServiceMsg = localOIDBSSOPkg.str_error_msg.get();
          QLog.e("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]" + paramToServiceMsg.getServiceCmd() + "." + localOIDBSSOPkg.uint32_service_type.get() + " ssoPkg biz return error(" + n + ") -> " + paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          try
          {
            paramFromServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            paramFromServiceMsg = (oidb_0x592.GetScheduleByIDRsp)paramFromServiceMsg.msg_get_schedule_by_id_rsp.get();
            if (paramFromServiceMsg != null) {
              break;
            }
            n = -1;
            l1 = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
            if (n != 0) {
              break label469;
            }
            if (QLog.isColorLevel()) {
              QLog.i("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]0x592.FETCH_DETAIL rsp success.]" + ",serviceType = " + i1 + ", seq = " + l1);
            }
            paramToServiceMsg = a(l1, (oidb_0x592.GetScheduleResult)paramFromServiceMsg.msg_schedule_result.get());
            if (paramToServiceMsg == null) {
              break label557;
            }
            a(14, true, paramToServiceMsg);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            int i1;
            QLog.e("DingdongPluginBizHandler", 1, "reqSeq[" + paramToServiceMsg + "]0x592." + i1 + " decode pkg error -> " + paramFromServiceMsg.toString());
            return;
          }
          paramFromServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg.toString();
          QLog.e("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]" + paramToServiceMsg.getServiceCmd() + " decode ssoPkg error -> " + paramFromServiceMsg.toString());
        }
      }
      i1 = localOIDBSSOPkg.uint32_service_type.get();
      paramFromServiceMsg = new oidb_0x592.RspBody();
    }
    long l1;
    for (;;)
    {
      QLog.e("DingdongPluginBizHandler", 2, "0x592 respond msf error: retCode[" + n + "].");
      break;
      n = paramFromServiceMsg.uint32_result.get();
    }
    label469:
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.bytes_error_msg.has())) {}
    for (paramFromServiceMsg = paramFromServiceMsg.bytes_error_msg.get().toStringUtf8();; paramFromServiceMsg = null)
    {
      QLog.e("DingdongPluginBizHandler", 1, "reqSeq[" + paramToServiceMsg + "]0x592.FETCH_DETAIL rsp error retCode:" + n + ",retMsg:" + paramFromServiceMsg + ", seq = " + l1);
      paramToServiceMsg = (ToServiceMsg)paramObject;
      break;
      label557:
      ((DingdongPluginManager)this.b.getManager(114)).a(l1);
      return;
    }
  }
  
  public Class a()
  {
    return DingdongPluginBizObserver.class;
  }
  
  public void a()
  {
    oidb_0x51d.ReqBody localReqBody = new oidb_0x51d.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.opt_uint64_handled_uin.set(this.b.getLongAccountUin());
    super.b(super.a("OidbSvc.0x51d_1", 1309, 1, localReqBody.toByteArray()));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_cmd0x8f6.ReqBody();
    ((oidb_cmd0x8f6.ReqBody)localObject).uint32_subcmd.set(2);
    oidb_cmd0x8f6.DecreaseUnreadMailCountReq localDecreaseUnreadMailCountReq = new oidb_cmd0x8f6.DecreaseUnreadMailCountReq();
    localDecreaseUnreadMailCountReq.uint32_type.set(1);
    localDecreaseUnreadMailCountReq.uint32_amount.set(paramInt1);
    localDecreaseUnreadMailCountReq.uint32_data_version.set(paramInt2);
    ((oidb_cmd0x8f6.ReqBody)localObject).msg_dec_umc.set(localDecreaseUnreadMailCountReq, true);
    localObject = super.a("OidbSvc.0x8f6_1", 2294, 1, ((oidb_cmd0x8f6.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("OidbSvc.0x8f6_1_subCmd", Integer.valueOf(2));
    super.b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong)
  {
    oidb_0x51d.ReqBody localReqBody = new oidb_0x51d.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.opt_uint64_handled_uin.set(this.b.getLongAccountUin());
    if (paramLong > 0L) {
      localReqBody.opt_uint64_office_appid.set(paramLong);
    }
    super.b(super.a("OidbSvc.0x51d_2", 1309, 2, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong1, long paramLong2, List paramList)
  {
    if (paramList != null)
    {
      oidb_0x589.ReqBody localReqBody = new oidb_0x589.ReqBody();
      localReqBody.setHasFlag(true);
      localReqBody.uint64_app_id.set(paramLong2);
      localReqBody.rpt_msg_user_id.addAll(paramList);
      paramList = super.a("OidbSvc.0x589", 1417, 1, localReqBody.toByteArray());
      paramList.addAttribute("ReqSeq", Long.valueOf(paramLong1));
      paramList.setTimeout(20000L);
      super.b(paramList);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginBizHandler", 2, "getScheduleDetail workFlowId = " + paramString + " req =" + paramLong + ",serviceType = " + 3);
    }
    oidb_0x592.GetScheduleByIDReq localGetScheduleByIDReq = new oidb_0x592.GetScheduleByIDReq();
    localGetScheduleByIDReq.bytes_workflow_id.set(ByteStringMicro.copyFrom(paramString.getBytes()), true);
    paramString = new oidb_0x592.ReqBody();
    paramString.msg_appid.setHasFlag(true);
    paramString.msg_appid.uint64_appid.set(1800000002L);
    paramString.msg_appid.uint32_type.set(3);
    paramString.msg_get_schedule_by_id_req.set(localGetScheduleByIDReq, true);
    paramString = super.a("OidbSvc.0x592", 1426, 3, paramString.toByteArray());
    paramString.addAttribute("ReqSeq", Long.valueOf(paramLong));
    paramString.setTimeout(20000L);
    super.b(paramString);
  }
  
  public void a(long paramLong, List paramList)
  {
    if (paramList != null)
    {
      oidb_0x4f2.ReqBody localReqBody = new oidb_0x4f2.ReqBody();
      localReqBody.rpt_uint64_appid_list.set(paramList);
      localReqBody.setHasFlag(true);
      paramList = super.a("OidbSvc.0x4f2", 1266, 1, localReqBody.toByteArray());
      paramList.addAttribute("ReqSeq", Long.valueOf(paramLong));
      paramList.setTimeout(20000L);
      super.b(paramList);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0x8f6_1".equals(str)) {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0x8f9_13".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x51d_1".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x51d_2".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x508_1".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x589".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x508_2".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f2".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x592".equals(str));
    j(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(submsgtype0x8f.MsgBody paramMsgBody)
  {
    DingdongPluginBizObserver.FeedConfirmNotifyData localFeedConfirmNotifyData = new DingdongPluginBizObserver.FeedConfirmNotifyData();
    try
    {
      localFeedConfirmNotifyData.jdField_a_of_type_JavaLangString = paramMsgBody.bytes_feeds_id.get().toStringUtf8();
      localFeedConfirmNotifyData.jdField_b_of_type_Int = paramMsgBody.msg_source_id.uint32_source_type.get();
      localFeedConfirmNotifyData.jdField_b_of_type_JavaLangString = String.valueOf(paramMsgBody.msg_source_id.uint64_source_code.get());
      localFeedConfirmNotifyData.jdField_d_of_type_JavaLangString = String.valueOf(paramMsgBody.uint64_author_uin.get());
      localFeedConfirmNotifyData.jdField_c_of_type_JavaLangString = String.valueOf(paramMsgBody.uint64_confirm_uin.get());
      localFeedConfirmNotifyData.jdField_d_of_type_Int = paramMsgBody.enum_msg_type.get();
      if (localFeedConfirmNotifyData.jdField_a_of_type_Int == 0)
      {
        bool = true;
        super.a(4, bool, localFeedConfirmNotifyData);
        return;
      }
    }
    catch (NullPointerException paramMsgBody)
    {
      for (;;)
      {
        localFeedConfirmNotifyData.jdField_a_of_type_Int = -1;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public void a(submsgtype0x93.MsgBody paramMsgBody)
  {
    boolean bool = true;
    int n = paramMsgBody.uint32_msg_type.get();
    if (QLog.isColorLevel()) {
      QLog.i("DingdongPluginBizHandler", 2, "handlePushMsg_0x210_0x93:msgType[" + n + "].");
    }
    switch (n)
    {
    default: 
      return;
    case 1: 
      localObject = new DingdongPluginBizObserver.UnreadNumUpdateData();
      try
      {
        ((DingdongPluginBizObserver.UnreadNumUpdateData)localObject).jdField_b_of_type_Int = paramMsgBody.msg_umc_changed.msg_umc.uint32_unread_count.get();
        ((DingdongPluginBizObserver.UnreadNumUpdateData)localObject).jdField_c_of_type_Int = paramMsgBody.msg_umc_changed.msg_umc.uint32_data_version.get();
        if (((DingdongPluginBizObserver.UnreadNumUpdateData)localObject).jdField_a_of_type_Int == 0)
        {
          bool = true;
          super.a(1, bool, localObject);
          return;
        }
      }
      catch (NullPointerException paramMsgBody)
      {
        for (;;)
        {
          QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x93_0x1 error:nullPointer[" + paramMsgBody.toString() + "].");
          ((DingdongPluginBizObserver.UnreadNumUpdateData)localObject).jdField_a_of_type_Int = -1;
          continue;
          bool = false;
        }
      }
    }
    Object localObject = new DingdongPluginBizObserver.FeedStateUpdateData();
    try
    {
      ((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_d_of_type_Int = paramMsgBody.msg_state_changed.enum_msg_type.get();
      ((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_b_of_type_Int = paramMsgBody.msg_state_changed.msg_source_id.uint32_source_type.get();
      ((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_b_of_type_JavaLangString = String.valueOf(paramMsgBody.msg_state_changed.msg_source_id.uint64_source_code.get());
      ((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_a_of_type_JavaLangString = paramMsgBody.msg_state_changed.bytes_feeds_id.get().toStringUtf8();
      ((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_c_of_type_JavaLangString = String.valueOf(paramMsgBody.msg_state_changed.uint64_req_uin.get());
      paramMsgBody = paramMsgBody.msg_state_changed.rpt_msg_lite_mail_index.get();
      if ((paramMsgBody != null) && (paramMsgBody.size() > 0))
      {
        ((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        paramMsgBody = paramMsgBody.iterator();
        while (paramMsgBody.hasNext())
        {
          submsgtype0x93.LiteMailIndexInfo localLiteMailIndexInfo = (submsgtype0x93.LiteMailIndexInfo)paramMsgBody.next();
          DingdongPluginBizObserver.TempLiteMailIndexInfo localTempLiteMailIndexInfo = new DingdongPluginBizObserver.TempLiteMailIndexInfo();
          localTempLiteMailIndexInfo.jdField_a_of_type_JavaLangString = localLiteMailIndexInfo.bytes_feeds_id.get().toStringUtf8();
          localTempLiteMailIndexInfo.jdField_a_of_type_Int = localLiteMailIndexInfo.msg_source_id.uint32_source_type.get();
          localTempLiteMailIndexInfo.jdField_a_of_type_Long = localLiteMailIndexInfo.msg_source_id.uint64_source_code.get();
          ((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_a_of_type_JavaUtilArrayList.add(localTempLiteMailIndexInfo);
        }
      }
      if (((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_a_of_type_Int != 0) {}
    }
    catch (NullPointerException paramMsgBody)
    {
      ((DingdongPluginBizObserver.FeedStateUpdateData)localObject).jdField_a_of_type_Int = -1;
      QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x93_0x2 error:nullPointer[" + paramMsgBody.toString() + "].");
    }
    for (;;)
    {
      super.a(3, bool, localObject);
      return;
      bool = false;
    }
  }
  
  public void a(SubMsgType0x9b.MsgBody paramMsgBody)
  {
    c();
    int n = paramMsgBody.uint32_main_type.get();
    String str = paramMsgBody.bytes_workflow_id.get().toStringUtf8();
    boolean bool = OfficeCenterSharedPref.a().a("officecenter_mark_leave_activity", true);
    if (n == 1) {
      if (!bool)
      {
        paramMsgBody = new Intent();
        paramMsgBody.putExtra("reqCode", 4);
        paramMsgBody.putExtra("serviceType", n);
        DingdongPluginHelper.a(2, paramMsgBody);
      }
    }
    for (;;)
    {
      return;
      if (n == 2)
      {
        SubMsgType0x9b.PbOfficeNotify localPbOfficeNotify = new SubMsgType0x9b.PbOfficeNotify();
        paramMsgBody = paramMsgBody.bytes_ext_msg.get().toByteArray();
        try
        {
          localPbOfficeNotify.mergeFrom(paramMsgBody);
          int i1 = localPbOfficeNotify.opt_uint32_myoffice_flag.get();
          paramMsgBody = localPbOfficeNotify.rpt_uint64_appid.get();
          QLog.i("DingdongPluginBizHandler", 4, "0x210_0x9b push msg, serviceType: " + n + " workId: " + str + " flag: " + i1 + " id list: " + paramMsgBody.toString());
          if ((i1 == 1) && (bool)) {
            a();
          }
          if (paramMsgBody.size() > 0)
          {
            paramMsgBody = new Intent();
            paramMsgBody.putExtra("reqCode", 4);
            paramMsgBody.putExtra("serviceType", n);
            paramMsgBody.putExtra("hasAppNotice", true);
            DingdongPluginHelper.a(2, paramMsgBody);
            a(0L);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsgBody)
        {
          paramMsgBody.printStackTrace();
        }
      }
    }
  }
  
  public void a(SubMsgType0x9b.MsgBody paramMsgBody, boolean paramBoolean)
  {
    long l1 = paramMsgBody.uint64_app_id.get();
    if (QLog.isColorLevel()) {
      QLog.i("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b. appid = " + l1 + "  beoffline = " + paramBoolean);
    }
    if (1800000000L == l1) {
      a(paramMsgBody);
    }
    do
    {
      do
      {
        return;
      } while ((1800000002L != l1) || (!paramMsgBody.uint32_main_type.has()) || (!paramMsgBody.uint32_sub_type.has()) || (paramMsgBody.uint32_main_type.get() != 100) || (paramMsgBody.uint32_sub_type.get() != 1));
      paramMsgBody = a(paramMsgBody.bytes_ext_msg.get().toByteArray(), paramBoolean);
    } while (paramMsgBody == null);
    QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b.100 error(-1):" + paramMsgBody + ".");
  }
  
  public void a(SubMsgType0x9c.MsgBody paramMsgBody, boolean paramBoolean)
  {
    switch (paramMsgBody.uint32_main_type.get())
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMsgBody.uint32_sub_type.get() != 1);
      paramMsgBody = a(paramMsgBody.bytes_ext_msg.get().toByteArray(), paramBoolean);
    } while (paramMsgBody == null);
    QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b.100 error(-1):" + paramMsgBody + ".");
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new oidb_0x8f9.ReqBody();
    oidb_0x8f9.GetLatestNodeInfoReq localGetLatestNodeInfoReq = new oidb_0x8f9.GetLatestNodeInfoReq();
    localGetLatestNodeInfoReq.uint32_node_type.set(1);
    PBUInt32Field localPBUInt32Field = localGetLatestNodeInfoReq.uint32_unread_count_flag;
    if (paramBoolean) {}
    for (int n = 0;; n = 1)
    {
      localPBUInt32Field.set(n);
      ((oidb_0x8f9.ReqBody)localObject).msg_req_get_latest_node_info.set(localGetLatestNodeInfoReq, true);
      localObject = super.a("OidbSvc.0x8f9_13", 2297, 13, ((oidb_0x8f9.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("OidbSvc.0x8f9_13_subCmd", Integer.valueOf(1));
      super.b((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void b()
  {
    new qoh(this).execute(new Void[] { null, null, null });
  }
  
  public void b(long paramLong)
  {
    Object localObject = new oidb_0x508.ReqBody();
    ((oidb_0x508.ReqBody)localObject).rpt_uint64_update_seq.set(0L);
    ((oidb_0x508.ReqBody)localObject).setHasFlag(true);
    localObject = super.a("OidbSvc.0x508_2", 1288, 1, ((oidb_0x508.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("ReqSeq", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).setTimeout(20000L);
    super.b((ToServiceMsg)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\utils\DingdongPluginBizHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */