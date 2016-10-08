import android.view.View;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;

public class nue
  implements AdapterView.OnItemClickListener
{
  public nue(AIOImageListScene paramAIOImageListScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject1)) {}
    label291:
    label303:
    label314:
    label441:
    label470:
    label618:
    for (;;)
    {
      return;
      localObject1 = (AIORichMediaInfo)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + AIOImageListScene.a(this.a).s() + " LastVisiblePosition " + AIOImageListScene.b(this.a).t());
      }
      Object localObject2;
      int i;
      if (AIOImageListScene.a(this.a))
      {
        localObject2 = ((AIORichMediaInfo)localObject1).a;
        if ((AIOFilePicData.class.isInstance(localObject2)) && (((AIOFilePicData)localObject2).a(20) == null) && (((AIOFilePicData)localObject2).a(18) == null) && (((AIOFilePicData)localObject2).a(16) == null))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path,onItemClick: " + paramInt);
          return;
        }
        i = this.a.a();
        if (i == 1)
        {
          if (AIOShortVideoData.class.isInstance(localObject2)) {
            QQToast.a(AIOImageListScene.n(this.a), "不能同时选择照片和视频", 0).a();
          }
        }
        else if (i == 2)
        {
          if (AIOImageData.class.isInstance(localObject2)) {
            QQToast.a(AIOImageListScene.o(this.a), "不能同时选择照片和视频", 0).a();
          }
        }
        else {
          if ((i == 0) && (!AIOImageData.class.isInstance(localObject2))) {
            break label441;
          }
        }
        if (((AIORichMediaInfo)localObject1).b() == 1)
        {
          i = 1;
          localObject2 = this.a;
          if (i != 0) {
            break label470;
          }
          ((AIOImageListScene)localObject2).a((AIORichMediaInfo)localObject1, bool, false);
          if (!this.a.a(paramView, (GalleryImage)localObject1)) {
            ((AbstractImageAdapter)paramAdapterView.a()).notifyDataSetChanged();
          }
          this.a.t();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label618;
        }
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + AIOImageListScene.e(this.a).s() + " LastVisiblePosition " + AIOImageListScene.f(this.a).t() + " SelectedIndex = " + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
        return;
        if ((AIOFilePicData.class.isInstance(localObject2)) || (!AIOShortVideoData.class.isInstance(localObject2))) {
          break label291;
        }
        break label291;
        i = 0;
        break label303;
        bool = false;
        break label314;
        if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
        {
          paramAdapterView = (AIOShortVideoData)((AIORichMediaInfo)localObject1).a;
          if (paramAdapterView.d == 0)
          {
            paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAdapterView.f);
            if (paramAdapterView == null) {
              break;
            }
            ShortVideoUtils.a(paramAdapterView, AIOImageListScene.p(this.a), this.a.x, paramAdapterView.frienduin);
            return;
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.e(paramInt);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(AIOImageListScene.c(this.a).s());
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c(AIOImageListScene.d(this.a).t());
        this.a.p();
        this.a.a("Multi_Pic_big", 1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */