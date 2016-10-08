import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class nvl
  implements Runnable
{
  public nvl(PhotoListPanel paramPhotoListPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = SystemClock.uptimeMillis();
    List localList = AlbumUtil.c(this.a.jdField_a_of_type_AndroidAppActivity, "$RecentAlbumId", null, 100, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "get album medias cost: " + (SystemClock.uptimeMillis() - l));
    }
    if (localList == null)
    {
      PhotoListPanel.g = 0;
      this.a.jdField_a_of_type_AndroidOsHandler.post(new nvm(this));
      return;
    }
    int m = localList.size();
    this.a.b = new ArrayList(localList.size());
    PhotoListPanel.g = m;
    int k = 0;
    int j = 0;
    if (k < m)
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localList.get(k);
      if (localLocalMediaInfo.jdField_a_of_type_JavaLangString == null) {}
      for (;;)
      {
        k += 1;
        break;
        int n = AlbumUtil.a(localLocalMediaInfo);
        int i;
        if (n == 0)
        {
          this.a.b.add(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
          i = j;
        }
        for (;;)
        {
          localLocalMediaInfo.jdField_a_of_type_JavaLangInteger = Integer.valueOf(k - i);
          if ((localLocalMediaInfo.jdField_a_of_type_Int != 90) && (localLocalMediaInfo.jdField_a_of_type_Int != 270)) {
            break label316;
          }
          localLocalMediaInfo.f = this.a.c;
          localLocalMediaInfo.g = 0;
          j = i;
          if (localLocalMediaInfo.i <= 0) {
            break;
          }
          j = i;
          if (localLocalMediaInfo.j <= 0) {
            break;
          }
          FlowThumbDecoder.a(localLocalMediaInfo, localLocalMediaInfo.i, localLocalMediaInfo.j);
          j = localLocalMediaInfo.f;
          localLocalMediaInfo.f = localLocalMediaInfo.g;
          localLocalMediaInfo.g = j;
          j = i;
          break;
          i = j;
          if (n == 1) {
            i = j + 1;
          }
        }
        label316:
        localLocalMediaInfo.f = 0;
        localLocalMediaInfo.g = this.a.c;
        j = i;
        if (localLocalMediaInfo.i > 0)
        {
          j = i;
          if (localLocalMediaInfo.j > 0)
          {
            FlowThumbDecoder.a(localLocalMediaInfo, localLocalMediaInfo.i, localLocalMediaInfo.j);
            j = i;
          }
        }
      }
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new nvn(this, localList));
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.b(localList);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */