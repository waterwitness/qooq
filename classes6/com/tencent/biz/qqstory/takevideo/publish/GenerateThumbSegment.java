package com.tencent.biz.qqstory.takevideo.publish;

import android.app.Activity;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.lang.ref.WeakReference;

public class GenerateThumbSegment
  extends JobSegment
  implements VideoProcessListener
{
  private static final String jdField_a_of_type_JavaLangString = "GenerateThumbSegment";
  private GenerateContext jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext;
  
  public GenerateThumbSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    SLog.b("GenerateThumbSegment", "start generate thumb ...");
    this.a = paramGenerateContext;
    paramJobContext = paramGenerateContext.a();
    new GenerateThumbTask((Activity)paramJobContext.jdField_a_of_type_JavaLangRefWeakReference.get(), this, paramJobContext.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, paramJobContext.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a, paramJobContext.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(), paramJobContext.jdField_a_of_type_Int, paramJobContext.jdField_a_of_type_Double, paramJobContext.b).execute(new Void[] { (Void)null });
  }
  
  public void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      SLog.b("GenerateThumbSegment", "generate thumb success ...");
      this.a.a(new GenerateThumbResult(paramString, paramArrayOfByte, paramInt1, paramInt2));
      super.notifyResult(this.a);
      return;
    }
    SLog.b("GenerateThumbSegment", "generate thumb failed ...");
    super.notifyError(new ErrorMessage(-1, "GenerateThumbTask error"));
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2, long paramLong) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateThumbSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */