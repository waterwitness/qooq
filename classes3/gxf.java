import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gxf
  implements Runnable
{
  gxf(gxe paramgxe, gxh paramgxh, VideoController.GAudioFriends paramGAudioFriends)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Gxh.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Gxe.a(String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_Long));
      if (this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_Gxe.a.a.a().postDelayed(new gxg(this), 1000L);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Gxh.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */