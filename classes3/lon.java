import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class lon
  implements SoundPool.OnLoadCompleteListener
{
  public lon(H5MagicPlayerActivity paramH5MagicPlayerActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityH5MagicPlayerActivity.jdField_a_of_type_AndroidMediaSoundPool.play(paramInt1, 1.0F, 1.0F, 0, this.jdField_a_of_type_ComTencentMobileqqActivityH5MagicPlayerActivity.jdField_a_of_type_Int - 1, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */