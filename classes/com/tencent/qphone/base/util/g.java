package com.tencent.qphone.base.util;

import com.tencent.mobileqq.msf.core.f;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

final class g
  extends Thread
{
  g(int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = Calendar.getInstance();
    Object localObject3 = new SimpleDateFormat("yy.MM.dd.HH");
    Object localObject2 = ((SimpleDateFormat)localObject3).format(((Calendar)localObject1).getTime());
    ((Calendar)localObject1).add(11, -1);
    String str = ((SimpleDateFormat)localObject3).format(((Calendar)localObject1).getTime());
    File[] arrayOfFile = new File(QLog.access$600()).listFiles();
    int j;
    File localFile;
    int i;
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      localObject3 = new ArrayList();
      int k = arrayOfFile.length;
      j = 0;
      if (j < k)
      {
        localFile = arrayOfFile[j];
        localObject1 = localFile.getName();
        if (((String)localObject1).endsWith(".log"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 4);
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (((i != 0) && (((String)localObject1).endsWith((String)localObject2))) || (((String)localObject1).endsWith(str))) {
        ((ArrayList)localObject3).add(new QLog.a(localFile.getPath()));
      }
      j += 1;
      break;
      if (((String)localObject1).endsWith(".log.zip"))
      {
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 8);
        i = 1;
      }
      else
      {
        if (((String)localObject1).endsWith(".qlog"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          i = 1;
          continue;
          QLog.access$702(QLog.access$700().replace(":", "_"));
          localObject1 = QLog.access$600() + QLog.access$700() + ".zip";
          localObject2 = new File((String)localObject1);
          ((File)localObject2).delete();
          try
          {
            ((File)localObject2).createNewFile();
            f.a((ArrayList)localObject3, (String)localObject1);
            f.a(this.a, (String)localObject1, this.b, this.c);
            ((File)localObject2).delete();
            return;
          }
          catch (IOException localIOException)
          {
            QLog.d("MSF.D.QLog", 1, "doReportLogSelf exception " + localIOException);
            return;
          }
          catch (Throwable localThrowable)
          {
            QLog.d("MSF.D.QLog", 1, "doReportLogSelf error " + localThrowable);
            return;
          }
        }
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */