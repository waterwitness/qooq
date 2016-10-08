import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kci
  implements Runnable
{
  kci(kch paramkch)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.b)
    {
      QFindBLEScanMgr.a(this.a.a, System.currentTimeMillis());
      QFindBLEScanMgr.a(this.a.a, true);
      return;
    }
    QFindBLEScanMgr.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */