package sm;

import android.os.Process;

final class bb
  implements Runnable
{
  public void run()
  {
    try
    {
      Thread.sleep(2000L);
      Process.killProcess(Process.myPid());
      System.exit(0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */