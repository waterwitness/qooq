import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class kpq
  implements Runnable
{
  public kpq(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (BaseChatPie.a(this.a).length() > 0) {
          BaseChatPie.a(this.a).delete(0, BaseChatPie.a(this.a).length());
        }
        localObject1 = new File("/data/data/com.tencent.mobileqq/files/crashinfo/");
        if ((localObject1 != null) && (!((File)localObject1).exists())) {
          ((File)localObject1).mkdirs();
        }
        localObject1 = ((File)localObject1).listFiles(new kpr(this));
        if ((localObject1 != null) && (localObject1.length > 0)) {
          continue;
        }
        BaseChatPie.h(this.a, 0);
      }
      catch (Exception localException)
      {
        Object localObject1;
        int j;
        Object localObject2;
        FileReader localFileReader;
        localException.printStackTrace();
        continue;
      }
      this.a.a.post(new kpt(this));
      return;
      BaseChatPie.h(this.a, localObject1.length);
      Arrays.sort((Object[])localObject1, new kps(this));
      j = localObject1.length;
      if (i < j)
      {
        localObject2 = localObject1[i];
        localFileReader = new FileReader((File)localObject2);
        localObject2 = new char[(int)((File)localObject2).length()];
        localFileReader.read((char[])localObject2);
        localObject2 = String.valueOf((char[])localObject2);
        BaseChatPie.a(this.a).append((String)localObject2).append("\n\n");
        localFileReader.close();
        i += 1;
      }
      else
      {
        localObject1 = new FileWriter("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt");
        ((FileWriter)localObject1).write(BaseChatPie.a(this.a).toString());
        ((FileWriter)localObject1).flush();
        ((FileWriter)localObject1).close();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */