import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import java.io.File;
import java.util.List;
import tencent.im.group.nearbybanner.nearbybanner.BannerInfo;
import tencent.im.group.nearbybanner.nearbybanner.Banners;

public class vew
  implements BusinessObserver
{
  public vew(NearbyTroopsView paramNearbyTroopsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler == null) {
      break label10;
    }
    for (;;)
    {
      label10:
      return;
      if (paramInt == 16)
      {
        paramObject = ((Bundle)paramObject).getByteArray("data");
        if (paramObject == null) {
          break;
        }
        Object localObject = new nearbybanner.Banners();
        try
        {
          ((nearbybanner.Banners)localObject).mergeFrom((byte[])paramObject);
          if (((nearbybanner.Banners)localObject).rpt_banner_info.has())
          {
            paramObject = ((nearbybanner.Banners)localObject).rpt_banner_info.get();
            if (((List)paramObject).size() != 0)
            {
              this.a.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo = ((nearbybanner.BannerInfo)((List)paramObject).get(0));
              if ((this.a.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo != null) && (this.a.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.bytes_img_url.has()))
              {
                paramObject = this.a.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.bytes_img_url.get().toStringUtf8();
                localObject = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("NearByTroop", 4);
                if (TextUtils.isEmpty(((SharedPreferences)localObject).getString("banner_url", null)))
                {
                  ((SharedPreferences)localObject).edit().putString("banner_url", (String)paramObject).commit();
                  ThreadManager.a(new Thread(this.a.jdField_a_of_type_JavaLangRunnable), 5, null, true);
                  return;
                }
              }
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          this.a.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo = null;
          return;
        }
      }
    }
    if (!new File(NearbyTroopsView.c).exists())
    {
      ThreadManager.a(new Thread(this.a.jdField_a_of_type_JavaLangRunnable), 5, null, true);
      return;
    }
    try
    {
      paramObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)paramObject).inJustDecodeBounds = true;
      paramObject = BitmapFactory.decodeFile(NearbyTroopsView.c, (BitmapFactory.Options)paramObject);
      if (paramObject != null)
      {
        paramObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.obtainMessage(10, paramObject);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendMessage((Message)paramObject);
        return;
      }
      ThreadManager.a(new Thread(this.a.jdField_a_of_type_JavaLangRunnable), 5, null, true);
      return;
    }
    catch (OutOfMemoryError paramObject) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */