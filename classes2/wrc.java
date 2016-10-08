import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.FriendChooser.GridViewAdapter;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class wrc
  implements ImageLoader.ImageLoadListener
{
  public wrc(FriendChooser.GridViewAdapter paramGridViewAdapter, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */