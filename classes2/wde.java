import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.RandomAccessFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class wde
  implements Runnable
{
  public wde(RandomAccessFileManager paramRandomAccessFileManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(1000L);
        synchronized (RandomAccessFileManager.a(this.a))
        {
          if (!RandomAccessFileManager.a(this.a).isEmpty()) {}
        }
        Object localObject3;
        synchronized (RandomAccessFileManager.b(this.a))
        {
          RandomAccessFileManager.a(this.a, null);
          return;
          String[] arrayOfString = new String[RandomAccessFileManager.a(this.a).size()];
          ??? = RandomAccessFileManager.a(this.a).keySet().iterator();
          int i = 0;
          while (((Iterator)???).hasNext())
          {
            arrayOfString[i] = ((String)((Iterator)???).next());
            i += 1;
          }
          if (j < i)
          {
            localwdf2 = (wdf)RandomAccessFileManager.a(this.a).get(arrayOfString[j]);
            wdf localwdf1;
            for (??? = localwdf2.jdField_b_of_type_Wdf;; localObject3 = localwdf1)
            {
              localwdf1 = ((wdf)???).jdField_b_of_type_Wdf;
              if (((wdf)???).jdField_a_of_type_Int != 0) {
                break;
              }
              long l1 = System.currentTimeMillis();
              long l2 = ((wdf)???).jdField_b_of_type_Long;
              if (l1 - l2 <= 1000L) {
                break;
              }
              try
              {
                ((wdf)???).jdField_a_of_type_JavaIoRandomAccessFile.close();
                if (QLog.isColorLevel()) {
                  QLog.d("AppleMojiHandler", 2, "file " + arrayOfString[j] + "[" + ((wdf)???).jdField_a_of_type_Long + "]" + " close by Thread:" + Thread.currentThread().getId());
                }
                RandomAccessFileManager.a(this.a, localwdf2, (wdf)???, arrayOfString[j], RandomAccessFileManager.a(this.a));
              }
              catch (IOException localIOException)
              {
                for (;;)
                {
                  localIOException.printStackTrace();
                }
              }
              localObject2 = finally;
              throw ((Throwable)localObject2);
            }
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        wdf localwdf2;
        continue;
        int j = 0;
        continue;
        if (localwdf2 == localInterruptedException) {
          j += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */