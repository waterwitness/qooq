import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class pzb
  implements Runnable
{
  public pzb(IndividualRedPacketManager paramIndividualRedPacketManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 100;
    String str = "font";
    Object localObject1 = str;
    try
    {
      Object localObject3 = new File(IndividualRedPacketManager.h);
      localObject1 = str;
      int i;
      if (((File)localObject3).exists())
      {
        localObject1 = str;
        File[] arrayOfFile1 = ((File)localObject3).listFiles();
        if (arrayOfFile1 != null)
        {
          localObject1 = str;
          if (arrayOfFile1.length > 150)
          {
            localObject1 = str;
            Arrays.sort(arrayOfFile1, this.a.jdField_a_of_type_JavaUtilComparator);
            i = 100;
            for (;;)
            {
              localObject1 = str;
              if (i < arrayOfFile1.length)
              {
                localObject1 = str;
                localObject3 = this.a.jdField_a_of_type_JavaUtilLinkedList;
                localObject1 = str;
                try
                {
                  this.a.jdField_a_of_type_JavaUtilLinkedList.add(arrayOfFile1[i].getAbsolutePath());
                  localObject1 = new File(arrayOfFile1[i].getParent() + File.separator + System.currentTimeMillis());
                  arrayOfFile1[i].renameTo((File)localObject1);
                  ((File)localObject1).delete();
                  this.a.jdField_a_of_type_JavaUtilLinkedList.remove(arrayOfFile1[i].getAbsolutePath());
                  i += 1;
                }
                finally
                {
                  localObject1 = str;
                }
              }
            }
          }
        }
      }
      Object localObject2;
      File[] arrayOfFile2;
      File[] arrayOfFile3;
      File[] arrayOfFile4;
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.e(IndividualRedPacketManager.b(), 2, "eliminateImageCache error: " + localException2.getMessage());
      }
      do
      {
        do
        {
          do
          {
            try
            {
              localObject2 = new HashMap();
              ((HashMap)localObject2).put("param_FailCode", localObject1);
              StatisticCollector.a(BaseApplicationImpl.a.getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.a.a()).getAccount(), "RedpacketClearCacheError", false, 1L, 0L, (HashMap)localObject2, "", false);
              return;
            }
            catch (Exception localException1) {}
            localObject2 = "aio";
            localObject1 = localObject2;
            localObject3 = new File(IndividualRedPacketManager.i);
            localObject1 = localObject2;
            if (((File)localObject3).exists())
            {
              localObject1 = localObject2;
              arrayOfFile2 = ((File)localObject3).listFiles();
              if (arrayOfFile2 != null)
              {
                localObject1 = localObject2;
                if (arrayOfFile2.length > 150)
                {
                  localObject1 = localObject2;
                  Arrays.sort(arrayOfFile2, this.a.jdField_a_of_type_JavaUtilComparator);
                  i = 100;
                  for (;;)
                  {
                    localObject1 = localObject2;
                    if (i < arrayOfFile2.length)
                    {
                      localObject1 = localObject2;
                      localObject3 = this.a.jdField_a_of_type_JavaUtilLinkedList;
                      localObject1 = localObject2;
                      try
                      {
                        this.a.jdField_a_of_type_JavaUtilLinkedList.add(arrayOfFile2[i].getAbsolutePath());
                        localObject1 = new File(arrayOfFile2[i].getParent() + File.separator + System.currentTimeMillis());
                        arrayOfFile2[i].renameTo((File)localObject1);
                        ((File)localObject1).delete();
                        this.a.jdField_a_of_type_JavaUtilLinkedList.remove(arrayOfFile2[i].getAbsolutePath());
                        i += 1;
                      }
                      finally
                      {
                        localObject1 = localObject2;
                      }
                    }
                  }
                }
              }
            }
            localObject2 = "tp";
            localObject1 = localObject2;
            localObject3 = new File(IndividualRedPacketManager.j);
            localObject1 = localObject2;
            if (((File)localObject3).exists())
            {
              localObject1 = localObject2;
              arrayOfFile3 = ((File)localObject3).listFiles();
              if (arrayOfFile3 != null)
              {
                localObject1 = localObject2;
                if (arrayOfFile3.length > 150)
                {
                  localObject1 = localObject2;
                  Arrays.sort(arrayOfFile3, this.a.jdField_a_of_type_JavaUtilComparator);
                  i = 100;
                  for (;;)
                  {
                    localObject1 = localObject2;
                    if (i < arrayOfFile3.length)
                    {
                      localObject1 = localObject2;
                      localObject3 = this.a.jdField_a_of_type_JavaUtilLinkedList;
                      localObject1 = localObject2;
                      try
                      {
                        this.a.jdField_a_of_type_JavaUtilLinkedList.add(arrayOfFile3[i].getAbsolutePath());
                        localObject1 = new File(arrayOfFile3[i].getParent() + File.separator + System.currentTimeMillis());
                        arrayOfFile3[i].renameTo((File)localObject1);
                        ((File)localObject1).delete();
                        this.a.jdField_a_of_type_JavaUtilLinkedList.remove(arrayOfFile3[i].getAbsolutePath());
                        i += 1;
                      }
                      finally
                      {
                        localObject1 = localObject2;
                      }
                    }
                  }
                }
              }
            }
            localObject2 = "send";
            localObject1 = localObject2;
            localObject3 = new File(IndividualRedPacketManager.k);
            localObject1 = localObject2;
          } while (!((File)localObject3).exists());
          localObject1 = localObject2;
          arrayOfFile4 = ((File)localObject3).listFiles();
        } while (arrayOfFile4 == null);
        localObject1 = localObject2;
      } while (arrayOfFile4.length <= 150);
      localObject1 = localObject2;
      Arrays.sort(arrayOfFile4, this.a.jdField_a_of_type_JavaUtilComparator);
      i = j;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= arrayOfFile4.length) {
          break;
        }
        localObject1 = localObject2;
        localObject3 = this.a.jdField_a_of_type_JavaUtilLinkedList;
        localObject1 = localObject2;
        try
        {
          this.a.jdField_a_of_type_JavaUtilLinkedList.add(arrayOfFile4[i].getAbsolutePath());
          localObject1 = new File(arrayOfFile4[i].getParent() + File.separator + System.currentTimeMillis());
          arrayOfFile4[i].renameTo((File)localObject1);
          ((File)localObject1).delete();
          this.a.jdField_a_of_type_JavaUtilLinkedList.remove(arrayOfFile4[i].getAbsolutePath());
          i += 1;
        }
        finally
        {
          localObject1 = localObject2;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */