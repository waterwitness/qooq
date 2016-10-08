package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReportInfo;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReqBody;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.RspBody;

public class UserOperationModule
  extends ReadInJoyEngineModule
{
  private static final String a = ArticleInfoModule.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UserOperationModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  public UserOperationModule(EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(null, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private ToServiceMsg a(List paramList)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReportInfo localReportInfo = (ReportInfo)paramList.next();
        oidb_cmd0x64e.ReportInfo localReportInfo1 = new oidb_cmd0x64e.ReportInfo();
        localReportInfo1.uint64_uin.set(localReportInfo.mUin);
        localReportInfo1.uint32_source.set(localReportInfo.mSource);
        if (localReportInfo.mSourceArticleId != -1L) {
          localReportInfo1.uint64_source_article_id.set(localReportInfo.mSourceArticleId);
        }
        if (localReportInfo.mChannelId != -1) {
          localReportInfo1.uint32_channel_id.set(localReportInfo.mChannelId);
        }
        if (localReportInfo.mAlgorithmId != -1) {
          localReportInfo1.uint32_algorithm_id.set(localReportInfo.mAlgorithmId);
        }
        if (localReportInfo.mStrategyId != -1) {
          localReportInfo1.uint32_strategy_id.set(localReportInfo.mStrategyId);
        }
        localReportInfo1.enum_operation.set(localReportInfo.mOperation);
        if ((localReportInfo.mOperation == 9) && (localReportInfo.mReadTimeLength != -1)) {
          localReportInfo1.uint32_read_time_length.set(localReportInfo.mReadTimeLength);
        }
        if ((localReportInfo.mOperation == 12) && (localReportInfo.mPlayTimeLength != -1)) {
          localReportInfo1.uint32_play_time_length.set(localReportInfo.mPlayTimeLength);
        }
        if (!TextUtils.isEmpty(localReportInfo.mCollectUrl)) {
          localReportInfo1.bytes_collect_url.set(ByteStringMicro.copyFromUtf8(localReportInfo.mCollectUrl));
        }
        if (!TextUtils.isEmpty(localReportInfo.mInnerId)) {
          localReportInfo1.bytes_inner_id.set(ByteStringMicro.copyFromUtf8(localReportInfo.mInnerId));
        }
        if (localReportInfo.mOpSource >= 0) {
          localReportInfo1.enum_op_source.set(localReportInfo.mOpSource);
        }
        if (localReportInfo.mServerContext != null) {
          localReportInfo1.server_context.set(ByteStringMicro.copyFrom(localReportInfo.mServerContext));
        }
        localArrayList.add(localReportInfo1);
      }
    }
    localReqBody.rpt_report_info.set(localArrayList);
    return ReadInJoyOidbHelper.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x64e.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleUserOperationReport, result=" + i);
    }
  }
  
  public void a() {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x64e")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(List paramList)
  {
    a(a(paramList));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\model\UserOperationModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */