import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileOutputStream;
import tencent.im.group.nearbybanner.nearbybanner.BannerInfo;

public class vev
  implements Runnable
{
  public vev(NearbyTroopsView paramNearbyTroopsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = this.a.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.bytes_img_url.get().toStringUtf8();
    try
    {
      localObject1 = HttpUtil.a(BaseApplication.getContext(), (String)localObject1, "GET", null, null);
      if (localObject1 != null)
      {
        Bitmap localBitmap = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        if (localBitmap != null)
        {
          Object localObject2 = new File(NearbyTroopsView.c);
          if (!((File)localObject2).exists())
          {
            ((File)localObject2).getParentFile().mkdirs();
            ((File)localObject2).createNewFile();
          }
          localObject2 = new FileOutputStream((File)localObject2);
          ((FileOutputStream)localObject2).write((byte[])localObject1);
          ((FileOutputStream)localObject2).flush();
          ((FileOutputStream)localObject2).close();
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler != null)
          {
            localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.obtainMessage(10, localBitmap);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendMessage((Message)localObject1);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */