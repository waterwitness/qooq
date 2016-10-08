import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.music.MusicComposeDialog;
import com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.widget.QQToast;

public class iyg
  extends Handler
{
  public iyg(MusicComposeDialog paramMusicComposeDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          this.a.b();
          if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter != null)
          {
            this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(MusicComposeDialog.jdField_a_of_type_JavaUtilArrayList);
            this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
          }
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(MusicComposeDialog.h);
          if (MusicComposeDialog.h == 0)
          {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
            return;
          }
          if ((MusicComposeDialog.h == 1) && (!this.a.jdField_b_of_type_Boolean))
          {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
            return;
          }
        } while (MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo == null);
        paramMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        paramMessage.obj = MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        paramMessage.arg1 = MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_g_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
        return;
        this.a.b();
        QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)paramMessage.obj;
        localQQStoryMusicInfo.i = ((int)ShortVideoUtils.a(localQQStoryMusicInfo.jdField_g_of_type_JavaLangString));
        localQQStoryMusicInfo.jdField_g_of_type_Int = paramMessage.arg1;
        if (localQQStoryMusicInfo.jdField_g_of_type_Int < 0) {
          localQQStoryMusicInfo.jdField_g_of_type_Int = 0;
        }
        if (localQQStoryMusicInfo.jdField_g_of_type_Int + this.a.i > localQQStoryMusicInfo.i) {
          localQQStoryMusicInfo.jdField_g_of_type_Int = 0;
        }
        localQQStoryMusicInfo.h = (localQQStoryMusicInfo.jdField_g_of_type_Int + this.a.i);
        MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = localQQStoryMusicInfo;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d(-1);
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(localQQStoryMusicInfo.b);
        this.a.a();
        this.a.a(true);
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(localQQStoryMusicInfo.i, this.a.i) + 500) / 1000);
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(localQQStoryMusicInfo.jdField_g_of_type_Int);
        this.a.b(MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_g_of_type_Int, MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.h);
      } while ((!this.a.c) || (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity == null) || (!this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.z));
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.q();
      this.a.c = false;
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.z = false;
      return;
    case 3: 
      this.a.b();
      MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = null;
      MusicComposeDialog.jdField_a_of_type_Boolean = true;
      VideoSourceHelper.nativeSetPlayAFMute(MusicComposeDialog.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前无任何音效");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 6: 
      this.a.b();
      MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = null;
      MusicComposeDialog.jdField_a_of_type_Boolean = false;
      VideoSourceHelper.nativeSetPlayAFMute(MusicComposeDialog.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d(1);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前为视频原声");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, paramMessage, 0).a();
      return;
    case 8: 
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setPlayedPosition(this.a.j);
      return;
    }
    if (this.a.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg1);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */