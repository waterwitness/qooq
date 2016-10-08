import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.preload.FileDownloader;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class itd
  implements Runnable
{
  public itd(StoryListPresenter paramStoryListPresenter, StoryVideoItem paramStoryVideoItem, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2 = QQStoryConstant.t;
    Object localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid + ".mp4";
    String str = (String)localObject2 + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid + ".png";
    localObject2 = new File((String)localObject2);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath == null) {
      if (new File((String)localObject1).exists())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath = ((String)localObject1);
        i = -99999;
      }
    }
    for (;;)
    {
      int j;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isMaskVideo()) && ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath == null) || (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isNativeloadMask()))) {
        if (new File(str).exists())
        {
          this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath = str;
          j = -99999;
        }
      }
      for (;;)
      {
        if (((i != 0) && (i != -99999)) || ((j != 0) && (j != -99999)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.jdField_a_of_type_AndroidOsHandler.obtainMessage(4).sendToTarget();
          localObject1 = "下载失败，错误码: " + i + " | " + j;
          ToastUtil.a().a((String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.e("FFmepg", 2, (String)localObject1 + " | , vid: " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
          }
          return;
          i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoUrl, (String)localObject1, 0L);
          if (i == 0)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath = ((String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.w("FFmepg", 2, "下载视频成功：" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoUrl);
            }
          }
          break;
          int k = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getDownloadMaskUrl(), str, 0L);
          j = k;
          if (k != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath = str;
          j = k;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("FFmepg", 2, "下载水印成功：" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getDownloadMaskUrl());
          j = k;
          continue;
        }
        ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
        ((Message)localObject1).obj = this.jdField_a_of_type_JavaUtilArrayList;
        ((Message)localObject1).sendToTarget();
        return;
        j = -99999;
      }
      i = -99999;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */