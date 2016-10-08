import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import java.util.HashMap;

class twn
  implements Runnable
{
  twn(twm paramtwm, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_Twm.a.a.get("map_key_face");
    if ((localImageView != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
      localImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */