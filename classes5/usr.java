import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoDownload;
import com.tencent.mobileqq.shortvideo.util.PtvSoDownLoadManager;
import com.tencent.mobileqq.widget.QQToast;

public final class usr
  implements VideoEnvironment.ShortVideoDownload
{
  private VideoEnvironment.ShortVideoDownload jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload;
  private boolean jdField_a_of_type_Boolean;
  
  private usr(VideoEnvironment.ShortVideoDownload paramShortVideoDownload, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload = paramShortVideoDownload;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), "短视频插件下载失败", 0).a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload.b(-1);
      return;
    }
    if (!PtvSoDownLoadManager.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload.b(101);
      PtvSoDownLoadManager.a(false);
      return;
    }
    PtvSoDownLoadManager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload.b(-3);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload.b(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (usr)paramObject;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload != null) {
          break;
        }
      } while (((usr)paramObject).jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload == null);
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload.equals(((usr)paramObject).jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload));
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */