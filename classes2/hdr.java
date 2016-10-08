import com.tencent.bitapp.BitAppViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class hdr
  implements Runnable
{
  hdr(hdp paramhdp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 0;
    int i = j;
    if (this.a.a.a != null)
    {
      i = j;
      if (this.a.a.a.getVisibility() == 0) {
        i = 1;
      }
    }
    if (i == 0) {}
    while (!QLog.isColorLevel()) {
      try
      {
        this.a.a.b();
        this.a.a.k();
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localException.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.d("RNEarlyDOwnloadListener", 4, "show thumbnails crash: " + localException.getMessage());
        return;
      }
    }
    QLog.d("RNEarlyDOwnloadListener", 4, "it's show thumbnaile now, so need't show again");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */