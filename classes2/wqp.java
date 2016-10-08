import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class wqp
  implements Runnable
{
  public wqp(BindGroupConfirmActivity paramBindGroupConfirmActivity, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */