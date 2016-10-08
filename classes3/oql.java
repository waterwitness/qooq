import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;

public class oql
  implements Runnable
{
  public oql(AlbumListAdapter paramAlbumListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogTag.a();
    QQAlbumInfo localQQAlbumInfo = this.a.c(this.a.jdField_a_of_type_AndroidAppActivity, 210, 100, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
    this.a.b(localQQAlbumInfo);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.b()))
    {
      localQQAlbumInfo = this.a.a(this.a.jdField_a_of_type_AndroidAppActivity);
      this.a.d(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumListAdapter", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    LogTag.a("PEAK", "queryRecentBucket");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */