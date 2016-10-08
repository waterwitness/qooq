import android.graphics.Canvas;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;
import com.tencent.qphone.base.util.QLog;

public class utf
{
  public boolean d;
  public boolean e;
  public boolean f;
  public int j;
  public int k;
  
  utf(TCProgressBar paramTCProgressBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = true;
    this.e = true;
    this.f = false;
  }
  
  void a(Canvas paramCanvas)
  {
    this.f = false;
  }
  
  boolean a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "checkBounds,x = " + paramFloat + ",x_coord = " + this.j + ",x_coord + length = " + (this.j + this.k));
    }
    return (paramFloat > this.j) && (paramFloat < this.j + this.k);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\utf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */