package com.tencent.biz.qqstory.base.preload.cachecleaner;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public abstract class AbsCleanStep
{
  protected static final String a = "AbsCleanStep";
  protected AbsCleanStep a;
  protected boolean a;
  
  public AbsCleanStep(boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public AbsCleanStep a(AbsCleanStep paramAbsCleanStep)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerAbsCleanStep = paramAbsCleanStep;
    return this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerAbsCleanStep;
  }
  
  public void a(File paramFile)
  {
    try
    {
      FileUtils.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      SLog.d("AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public abstract void a(String[] paramArrayOfString);
  
  public void b(String[] paramArrayOfString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerAbsCleanStep != null) {}
    try
    {
      Thread.sleep(100L);
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerAbsCleanStep.a(paramArrayOfString);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        SLog.e("AbsCleanStep", "sleep error ,InterruptedException");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\cachecleaner\AbsCleanStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */