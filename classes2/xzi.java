import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BTakePhotoActivity;

public class xzi
  extends SurfaceView
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  
  public xzi(C2BTakePhotoActivity paramC2BTakePhotoActivity, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(new xzj(this, paramC2BTakePhotoActivity));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */