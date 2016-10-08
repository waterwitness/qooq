import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hgr
  extends Thread
{
  hgr(hgq paramhgq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (hgp.b(this.a.a) == 1) {}
    for (;;)
    {
      try
      {
        Thread.sleep(5000L);
        hgp.b(this.a.a);
        return;
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
        continue;
      }
      try
      {
        Thread.sleep(10000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */