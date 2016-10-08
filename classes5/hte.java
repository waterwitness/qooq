import android.view.ViewGroup;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class hte
  implements Runnable
{
  hte(htd paramhtd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l1 = this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    long l2 = this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    if (this.a.a.jdField_a_of_type_AndroidWidgetSeekBar == null) {
      this.a.a.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.a.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298795));
    }
    if (this.a.a.jdField_a_of_type_AndroidWidgetSeekBar != null)
    {
      if (l2 != 0L) {
        break label129;
      }
      this.a.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    }
    for (;;)
    {
      this.a.a.a(false);
      this.a.a.e = true;
      return;
      label129:
      this.a.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(l1 / l2 * 100.0D));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */