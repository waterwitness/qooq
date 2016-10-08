import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class uth
  implements Runnable
{
  public uth(TCProgressBar paramTCProgressBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    utd localutd;
    if (this.a.e == 3)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new uth(this.a), this.a.h);
      localutd = this.a.jdField_a_of_type_Utd;
      if (this.a.jdField_a_of_type_Utd.e) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      localutd.e = bool;
      this.a.invalidate();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */