package com.tencent.biz.qqstory.base.preload.cachecleaner;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class TimeCleanStep
  extends AbsCleanStep
{
  protected static final long a = 86400000L;
  
  public TimeCleanStep(boolean paramBoolean)
  {
    super(paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String[] paramArrayOfString)
  {
    int k = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        File[] arrayOfFile = new File(paramArrayOfString[i]).listFiles();
        if (arrayOfFile == null)
        {
          i += 1;
        }
        else
        {
          long l = System.currentTimeMillis();
          int m = arrayOfFile.length;
          int j = 0;
          while (j < m)
          {
            if (j % 150 == 0) {}
            try
            {
              Thread.sleep(100L);
              File localFile = arrayOfFile[j];
              if (l - localFile.lastModified() > 86400000L) {
                a(localFile);
              }
              j += 1;
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
      }
    }
    super.b(paramArrayOfString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\cachecleaner\TimeCleanStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */