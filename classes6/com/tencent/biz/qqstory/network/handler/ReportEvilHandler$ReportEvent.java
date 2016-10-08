package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReportEvilHandler$ReportEvent
  extends BaseEvent
{
  public final int a;
  public final String a;
  
  public ReportEvilHandler$ReportEvent(ReportEvilHandler paramReportEvilHandler, ErrorMessage paramErrorMessage, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\ReportEvilHandler$ReportEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */