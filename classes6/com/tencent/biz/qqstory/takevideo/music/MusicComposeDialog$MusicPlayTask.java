package com.tencent.biz.qqstory.takevideo.music;

import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class MusicComposeDialog$MusicPlayTask
  extends TimerTask
{
  protected MusicComposeDialog$MusicPlayTask(MusicComposeDialog paramMusicComposeDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
    {
      MusicComposeDialog localMusicComposeDialog = this.a;
      localMusicComposeDialog.j += 1;
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "MusicPlayTask: mMusicPlayedPos = " + this.a.j);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\music\MusicComposeDialog$MusicPlayTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */