import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class wgd
  implements MediaPlayer.OnErrorListener
{
  public wgd(int paramInt, VipFunCallMediaListener paramVipFunCallMediaListener, VideoView paramVideoView, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "playing onError what=" + paramInt1 + ", extra=" + paramInt2 + ", funcallid=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener.a(paramInt1, paramInt2, this.jdField_a_of_type_Int);
    }
    paramMediaPlayer = VipFunCallManager.a(null, this.jdField_a_of_type_Int, 7, null);
    if (TextUtils.isEmpty(paramMediaPlayer)) {}
    label159:
    RelativeLayout localRelativeLayout;
    do
    {
      for (;;)
      {
        return true;
        if (new File(paramMediaPlayer).exists())
        {
          paramMediaPlayer = BitmapManager.a(paramMediaPlayer);
          if (paramMediaPlayer != null) {}
          for (paramMediaPlayer = new BitmapDrawable(paramMediaPlayer); (paramMediaPlayer != null) && (this.jdField_a_of_type_AndroidWidgetVideoView != null); paramMediaPlayer = null)
          {
            if (this.jdField_a_of_type_Boolean != true) {
              break label159;
            }
            this.jdField_a_of_type_AndroidWidgetVideoView.setBackgroundDrawable(paramMediaPlayer);
            return true;
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetVideoView.setVisibility(8);
      localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetVideoView.getParent();
    } while (localRelativeLayout == null);
    localRelativeLayout.setBackgroundDrawable(paramMediaPlayer);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */