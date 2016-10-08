import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import mqq.app.MobileQQ;

public class ghv
  extends AsyncTask
{
  public ghv(AVNotifyCenter paramAVNotifyCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Bitmap a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.a.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    for (;;)
    {
      try
      {
        Object localObject = a(paramVarArgs);
        FileUtil.c((String)localObject);
        if (FileUtil.a((String)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.e("AVNotifyCenter", 2, "headurl file eixst!");
          }
          try
          {
            localObject = new BufferedInputStream(new FileInputStream((String)localObject));
            paramVarArgs = BitmapFactory.decodeStream((InputStream)localObject);
            ((BufferedInputStream)localObject).close();
            if (paramVarArgs == null) {
              break label196;
            }
            this.a.jdField_a_of_type_AndroidGraphicsBitmap = paramVarArgs;
            return paramVarArgs;
          }
          catch (OutOfMemoryError paramVarArgs)
          {
            paramVarArgs = null;
            continue;
          }
          catch (IOException paramVarArgs)
          {
            paramVarArgs = null;
            continue;
          }
          catch (Exception paramVarArgs)
          {
            paramVarArgs = null;
            continue;
          }
        }
        else
        {
          File localFile = new File((String)localObject);
          boolean bool = HttpDownloadUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramVarArgs, localFile);
          if (!bool) {
            break label206;
          }
          try
          {
            localObject = new BufferedInputStream(new FileInputStream((String)localObject));
            paramVarArgs = BitmapFactory.decodeStream((InputStream)localObject);
            ((BufferedInputStream)localObject).close();
          }
          catch (OutOfMemoryError paramVarArgs)
          {
            paramVarArgs = null;
          }
          catch (IOException paramVarArgs)
          {
            paramVarArgs = null;
          }
          catch (Exception paramVarArgs)
          {
            paramVarArgs = null;
          }
          continue;
        }
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      catch (Exception paramVarArgs)
      {
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = null;
        return null;
      }
      label196:
      return null;
      label206:
      paramVarArgs = null;
    }
  }
  
  public String a(String paramString)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(paramString) + ".png";
    if (QLog.isColorLevel()) {
      QLog.d("AVNotifyCenter", 2, "Gen Head Path : Url = " + paramString + "Path : " + str);
    }
    return str;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ghv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */