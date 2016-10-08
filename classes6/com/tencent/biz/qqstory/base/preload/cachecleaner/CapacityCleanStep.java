package com.tencent.biz.qqstory.base.preload.cachecleaner;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ihq;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CapacityCleanStep
  extends AbsCleanStep
{
  protected static final int a = 400;
  protected static final int b = 50;
  protected static final String b = "CapacityCleanStep";
  
  public CapacityCleanStep(boolean paramBoolean)
  {
    super(paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String[] paramArrayOfString)
  {
    int k = paramArrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str = paramArrayOfString[i];
      if (a(str)) {}
      for (;;)
      {
        i += 1;
        break;
        File[] arrayOfFile = new File(str).listFiles();
        ArrayList localArrayList = new ArrayList();
        int m = arrayOfFile.length;
        int j = 0;
        while (j < m)
        {
          localArrayList.add(new ihq(this, arrayOfFile[j]));
          j += 1;
        }
        Collections.sort(localArrayList);
        m = localArrayList.size();
        j = 0;
        while (j < m)
        {
          if (j % 150 == 0) {}
          try
          {
            Thread.sleep(100L);
            if ((j % 20 == 0) && (a(str))) {
              return;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
            a(((ihq)localArrayList.get(j)).a);
            j += 1;
          }
        }
      }
    }
    super.b(paramArrayOfString);
  }
  
  public boolean a(String paramString)
  {
    paramString = new File(paramString).listFiles();
    if (paramString == null) {}
    int i;
    do
    {
      do
      {
        return true;
        i = paramString.length;
        SLog.b("CapacityCleanStep", "file size = " + i);
        if (!this.a) {
          break;
        }
      } while (i <= 50);
      return false;
    } while (i <= 400);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\cachecleaner\CapacityCleanStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */