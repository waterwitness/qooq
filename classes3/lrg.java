import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class lrg
  implements Runnable
{
  public lrg(Leba paramLeba, oidb_0x791.RedDotInfo paramRedDotInfo, Drawable paramDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1;
    Object localObject3;
    if ((this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$RedDotInfo != null) && (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$RedDotInfo.str_face_url.has()) && (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$RedDotInfo.str_face_url.get() != null))
    {
      localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$RedDotInfo.str_face_url.get().toStringUtf8();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        int i = AIOUtils.a(31.0F, this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a());
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
      }
    }
    for (;;)
    {
      try
      {
        URLDrawable.getDrawable((String)localObject1, null).setDecodeHandler(URLDrawableDecodeHandler.a);
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = localObject1;
          if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$RedDotInfo != null)
          {
            localObject3 = localObject1;
            if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$RedDotInfo.uint64_cmd_uin.has()) {
              localObject3 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a, String.valueOf(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$RedDotInfo.uint64_cmd_uin.get()), (byte)3);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityLeba.b(new lrh(this, (Drawable)localObject3));
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "updateXingquBuluoRedFlag, run exception:" + localException.getStackTrace());
        }
      }
      Object localObject2 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */