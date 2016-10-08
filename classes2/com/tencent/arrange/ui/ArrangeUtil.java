package com.tencent.arrange.ui;

import com.tencent.arrange.op.MeetingInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;

public class ArrangeUtil
{
  public static final int a = 0;
  public static final int b = 1;
  
  public ArrangeUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MeetingInfo paramMeetingInfo, int paramInt)
  {
    String str1 = "";
    String str2 = paramQQAppInterface.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(60530);
    long l = MessageCache.a();
    if (paramInt == 0)
    {
      str1 = ContactUtils.i(paramQQAppInterface, paramMeetingInfo.getCreator_uin());
      str1 = str1 + "预约的QQ电话开始了";
      str1 = str1 + "\n时间：" + paramMeetingInfo.getFormatTime() + "\n主题：" + paramMeetingInfo.getIntroduction();
    }
    for (;;)
    {
      localMessageRecord.init(str2, paramMeetingInfo.getDiscuss_uin(), paramMeetingInfo.getCreator_uin(), str1, l, 60530, 3000, l);
      localMessageRecord.extStr = String.valueOf(paramMeetingInfo.getSeq());
      localMessageRecord.isread = true;
      paramQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
      return;
      if (paramInt == 1)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005578", "0X8005578", 0, 0, "", "", "", "");
        str1 = "预约的QQ电话无人参与，已自动结束。";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\arrange\ui\ArrangeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */