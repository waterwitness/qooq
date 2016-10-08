import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.IOException;

class izm
{
  izm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  izc a(String[] paramArrayOfString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Process localProcess = a(paramArrayOfString);
    if (localProcess != null) {}
    for (;;)
    {
      try
      {
        int i = localProcess.waitFor();
        localObject1 = Integer.valueOf(i);
        localObject3 = null;
      }
      catch (InterruptedException localInterruptedException1)
      {
        SLog.c(FFmpeg.a, "Interrupt exception", localInterruptedException1);
        izn.a(localProcess);
        localObject2 = localObject3;
        localObject3 = paramArrayOfString;
        continue;
      }
      finally
      {
        izn.a(localProcess);
      }
      paramArrayOfString = (String[])localObject2;
      Object localObject2 = localObject3;
    }
  }
  
  Process a(String[] paramArrayOfString)
  {
    try
    {
      Process localProcess = Runtime.getRuntime().exec(paramArrayOfString);
      return localProcess;
    }
    catch (IOException localIOException)
    {
      SLog.c(FFmpeg.a, "Exception while trying to run: " + paramArrayOfString, localIOException);
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */