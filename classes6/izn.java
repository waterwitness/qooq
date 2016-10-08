import android.os.AsyncTask;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class izn
{
  static int a;
  
  izn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  static int a()
  {
    if (a == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new izo());
      if (arrayOfFile == null) {
        return 1;
      }
      a = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a = 1;
      }
    }
    return a;
  }
  
  static String a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramInputStream = localStringBuilder.toString();
    }
    catch (IOException paramInputStream)
    {
      SLog.c(FFmpeg.a, "error converting input stream to string", paramInputStream);
      return null;
    }
    return paramInputStream;
  }
  
  public static void a(izi paramizi)
  {
    if ((paramizi != null) && (!paramizi.a()))
    {
      if (paramizi.a != null)
      {
        paramizi.a.destroy();
        paramizi.a = null;
      }
      if (!paramizi.isCancelled()) {
        paramizi.cancel(true);
      }
    }
  }
  
  static void a(Process paramProcess)
  {
    if (paramProcess != null) {
      paramProcess.destroy();
    }
  }
  
  static boolean a(AsyncTask paramAsyncTask)
  {
    return (paramAsyncTask != null) && (!paramAsyncTask.isCancelled()) && (paramAsyncTask.cancel(true));
  }
  
  public static boolean a(File paramFile)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFile == null) || (!paramFile.exists())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramFile.canExecute());
      bool1 = bool2;
    } while (paramFile.setExecutable(true));
    return false;
  }
  
  static boolean a(Process paramProcess)
  {
    if (paramProcess == null) {}
    for (;;)
    {
      return true;
      try
      {
        paramProcess.exitValue();
        if (QLog.isColorLevel())
        {
          QLog.e("FFmepg", 2, "isProcessCompleted: true  in  process.exitValue()");
          return true;
        }
      }
      catch (IllegalThreadStateException paramProcess)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FFmepg", 2, "IllegalThreadStateException e");
        }
      }
    }
    return false;
  }
  
  public static Object[] a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    int i = paramArrayOfObject1.length;
    int j = paramArrayOfObject2.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject1.getClass().getComponentType(), i + j);
    System.arraycopy(paramArrayOfObject1, 0, arrayOfObject, 0, i);
    System.arraycopy(paramArrayOfObject2, 0, arrayOfObject, i, j);
    return arrayOfObject;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */