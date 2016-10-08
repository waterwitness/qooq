import android.media.MediaMetadataRetriever;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaDatabaseHelper;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class orb
  implements Runnable
{
  public orb(MediaScanner paramMediaScanner, WeakReference paramWeakReference1, WeakReference paramWeakReference2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      MediaScanner.OnMediaScannerListener localOnMediaScannerListener = (MediaScanner.OnMediaScannerListener)this.b.get();
      if (localLocalMediaInfo != null)
      {
        if (localOnMediaScannerListener == null) {
          return;
        }
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(localLocalMediaInfo.a);
        localLocalMediaInfo.e = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
        localOnMediaScannerListener.a(this.jdField_a_of_type_Int, localLocalMediaInfo);
        MediaScanner.a(MediaScanner.a(BaseApplicationImpl.getContext())).a(localLocalMediaInfo.a, localLocalMediaInfo.e);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(MediaScanner.a, 2, "queryMediaInfoDuration() error=" + localException.getMessage());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */