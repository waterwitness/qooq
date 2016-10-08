import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troopgift.GiftBitmapAnimaionCache;
import com.tencent.mobileqq.troopgift.SendFlowerSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class thu
  implements Runnable
{
  thu(tht paramtht, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView == null) || (this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.getVisibility() == 8)) {
      if (QLog.isColorLevel()) {
        QLog.d(NearbyFlowerAnimationController.jdField_a_of_type_JavaLangString, 2, "SendFlowerSurfaceView null or gone");
      }
    }
    Object localObject;
    int i2;
    int n;
    do
    {
      do
      {
        return;
        if (((NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController) != null) || (NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController) != null)) && ((NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController) == null) || (NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).jdField_a_of_type_AndroidContentContext))) && ((NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController) == null) || (!(NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) || (SplashActivity.c == 2))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(NearbyFlowerAnimationController.jdField_a_of_type_JavaLangString, 2, "chatFragment not chat");
      return;
      this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.b();
      this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.setResource(this.jdField_a_of_type_AndroidGraphicsBitmap, this.b, this.c, this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache);
      localObject = this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache.a();
      i2 = localObject[0];
      n = localObject[1];
      if ((i2 != 0) && (n != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(NearbyFlowerAnimationController.jdField_a_of_type_JavaLangString, 2, "originX=0 or originY=0");
      }
    } while (NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController) == null);
    NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).a();
    NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController, null);
    return;
    int i3 = NearbyFlowerUtil.a(NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).a());
    int i6 = (int)NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).a().getResources().getDimension(2131493587);
    int m = (int)DeviceInfoUtil.j();
    int i1 = (int)DeviceInfoUtil.k() - i3;
    if ((NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).d == 0) || (NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).e == 0))
    {
      NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).d = m;
      NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).e = (i1 - i6);
    }
    int j = n * m / i2;
    int k;
    if (j > i1)
    {
      k = m * i1 / j;
      j = i1;
    }
    for (;;)
    {
      int i = NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).g * i1 / 100 - j / 2;
      if (i < 0) {
        i = 0;
      }
      label785:
      label929:
      label1142:
      label1238:
      for (;;)
      {
        int i7 = (m - k) / 2;
        int i4 = NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).f * j / 100;
        int i5 = DisplayUtil.a(NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).a(), 35.0F);
        i5 = DisplayUtil.a(NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).a(), 20.0F) + (i5 + i4);
        if ((i5 + i6 > j) && (i5 + i6 < i1)) {
          j = i5 + i6;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(NearbyFlowerAnimationController.jdField_a_of_type_JavaLangString, 2, "showFlowerAnimation deviceWidth:" + m + ", deviceHeight:" + i1 + ", titleBarHeight: " + i3 + ", realWidth: " + k + ", realHeight: " + j + ", originX: " + i2 + ", originY: " + n);
          }
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).width = k;
          ((RelativeLayout.LayoutParams)localObject).height = j;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = i7;
          ((RelativeLayout.LayoutParams)localObject).topMargin = (i + i3);
          this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          localObject = DeviceInfoUtil.h();
          if ((localObject != null) && ((((String)localObject).contains("Xiaomi")) || (((String)localObject).contains("xiaomi")))) {}
          for (m = 1;; m = 0)
          {
            if (m != 0)
            {
              n = 2;
              localObject = new WindowManager.LayoutParams(-1, -1, n, 131112, -2);
              if ((m != 0) && (Build.VERSION.SDK_INT >= 19)) {
                ((WindowManager.LayoutParams)localObject).flags |= 0x4000000;
              }
              ((WindowManager.LayoutParams)localObject).gravity = 51;
              ((WindowManager.LayoutParams)localObject).x = 0;
              ((WindowManager.LayoutParams)localObject).y = 0;
              if ("4".equals(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage.version)) {
                break label1142;
              }
              m = i1 / 4;
              n = DisplayUtil.a(NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).a(), 30.0F);
              RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
              localLayoutParams.topMargin = (m - i - n);
              this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
            }
            try
            {
              NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).removeViewImmediate(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_AndroidWidgetRelativeLayout);
              try
              {
                NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).addView(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
                this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.setVisibility(0);
                this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftSendFlowerSurfaceView.setHeadPositionY(k, j, (float)(k * 1.0D / i2), i4);
                this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerMessage, i5 + i3);
                ReportController.b(NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController), "CliOper", "", "", "0X8006138", "0X8006138", 0, 0, "", "", "", "");
                return;
                if (i + j <= i1) {
                  break label1238;
                }
                i = i1 - j;
                break;
                n = 2003;
                break label785;
                if (m == 0) {
                  break label929;
                }
                ((WindowManager.LayoutParams)localObject).type = 2005;
              }
              catch (Throwable localThrowable2)
              {
                for (;;)
                {
                  ((WindowManager.LayoutParams)localObject).type = 2003;
                  try
                  {
                    NearbyFlowerAnimationController.a(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController).addView(this.jdField_a_of_type_Tht.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
                    if (QLog.isColorLevel()) {
                      QLog.d(NearbyFlowerAnimationController.jdField_a_of_type_JavaLangString, 2, "mWindowManager.addView error! change typte to TYPE_SYSTEM_ALERT", localThrowable2);
                    }
                  }
                  catch (Throwable localThrowable1)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        localThrowable1.printStackTrace();
                      }
                    }
                  }
                }
              }
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
          }
        }
      }
      k = m;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */