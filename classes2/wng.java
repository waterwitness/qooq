import android.os.Handler;
import com.tencent.mobileqq.app.CardHandler.NowOnliveGallayCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NowShowVideoInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary.RspBody.PhotoInfo;

public class wng
  extends CardHandler.NowOnliveGallayCallback
{
  public wng(PhotoWallView paramPhotoWallView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoWallView", 2, "onGetNowOnliveGallay error:" + paramInt);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoWallView", 2, "onGetNowOnliveGallay size:" + paramList.size());
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      Object localObject = (NowLiveGallary.RspBody.PhotoInfo)paramList.get(paramInt);
      localObject = new NowShowVideoInfo(((NowLiveGallary.RspBody.PhotoInfo)localObject).cover.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject).video.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject).timestamp.get());
      this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramInt += 1;
    }
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      ReportController.b((QQAppInterface)this.b.get(), "dc00899", "NOW", "", "qq_zlk", "replay_exp", 0, 0, this.a.jdField_a_of_type_JavaLangString, "", "", "");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */