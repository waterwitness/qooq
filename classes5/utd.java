import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class utd
  extends utf
{
  public utd(TCProgressBar paramTCProgressBar)
  {
    super(paramTCProgressBar);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.a.b.left = this.j;
    this.a.b.right = (this.j + this.k);
    this.a.a.setColor(this.a.q);
    paramCanvas.drawRect(this.a.b, this.a.a);
    super.a(paramCanvas);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\utd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */