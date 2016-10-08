import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class sgu
  implements Runnable
{
  sgu(sgt paramsgt, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Sgt.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_Sgt.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_Sgt.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */