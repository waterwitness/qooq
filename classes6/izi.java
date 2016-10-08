import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;

public class izi
  extends AsyncTask
{
  public final long a;
  public Context a;
  public final FFmpegExecuteResponseCallback a;
  public final izm a;
  public Boolean a;
  public Process a;
  public StringBuilder a;
  public boolean a;
  public final String[] a;
  public long b;
  
  public izi(Context paramContext, String[] paramArrayOfString, long paramLong, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    this.jdField_a_of_type_Izm = new izm();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  private void a()
  {
    for (;;)
    {
      if (!izn.a(this.jdField_a_of_type_JavaLangProcess))
      {
        if ((this.jdField_a_of_type_Long != Long.MAX_VALUE) && (SystemClock.uptimeMillis() > this.b + this.jdField_a_of_type_Long)) {
          throw new TimeoutException("FFmpeg timed out");
        }
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.jdField_a_of_type_JavaLangProcess.getInputStream()));
          for (;;)
          {
            String str = localBufferedReader.readLine();
            if (str == null) {
              break;
            }
            if (isCancelled()) {
              return;
            }
            this.jdField_a_of_type_JavaLangStringBuilder.append(str).append("\n");
            publishProgress(new String[] { str });
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  protected izc a(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = izn.a(new File(izl.a(this.jdField_a_of_type_AndroidContentContext)));
      }
      this.jdField_a_of_type_JavaLangProcess = this.jdField_a_of_type_Izm.a(this.jdField_a_of_type_ArrayOfJavaLangString);
      if (this.jdField_a_of_type_JavaLangProcess == null)
      {
        paramVarArgs = izc.a();
        return paramVarArgs;
      }
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        paramVarArgs = new StringBuilder();
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        while (i < j)
        {
          paramVarArgs.append(arrayOfString[i]);
          paramVarArgs.append(' ');
          i += 1;
        }
        publishProgress(new String[] { paramVarArgs.toString() });
      }
      a();
      paramVarArgs = izc.a(this.jdField_a_of_type_JavaLangProcess);
      return paramVarArgs;
    }
    catch (TimeoutException paramVarArgs)
    {
      SLog.c(FFmpeg.jdField_a_of_type_JavaLangString, "FFmpeg timed out", paramVarArgs);
      paramVarArgs = new izc(false, paramVarArgs.getMessage());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      SLog.c(FFmpeg.jdField_a_of_type_JavaLangString, "Error running FFmpeg", paramVarArgs);
      return izc.a();
    }
    finally
    {
      izn.a(this.jdField_a_of_type_JavaLangProcess);
    }
  }
  
  protected void a(izc paramizc)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramizc.jdField_a_of_type_JavaLangString);
      if (!paramizc.jdField_a_of_type_Boolean) {
        break label56;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a(paramizc.jdField_a_of_type_Boolean);
      return;
      label56:
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.b(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  protected void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null) && (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.c(paramVarArgs[0]);
    }
  }
  
  public boolean a()
  {
    return izn.a(this.jdField_a_of_type_JavaLangProcess);
  }
  
  protected void onPreExecute()
  {
    this.b = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */