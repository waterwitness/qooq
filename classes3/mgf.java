import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.data.ApolloRedTouchInfo;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class mgf
  implements IRenderCallback, OnApolloViewListener
{
  private long jdField_a_of_type_Long;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public mgf(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQSettingMe);
  }
  
  public void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 2000L) {}
    QQSettingMe localQQSettingMe;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Long = l;
          localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localQQSettingMe == null) || (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null));
        if (paramInt != 0) {
          break;
        }
      } while ((!localQQSettingMe.jdField_e_of_type_Boolean) || (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo == null));
      if (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.c == 0)
      {
        ApolloUtil.a(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, "drawer");
        localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "apollo redtouch clean bubtext=" + localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.a + " and ts = " + localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_b_of_type_Int);
        }
        ((RedTouchManager)localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35)).b(String.valueOf("103100.103200"));
        VipUtils.a(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotClear", 0, 0, new String[] { localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.d });
        return;
      }
      if (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.c == 1) {}
      for (localObject1 = ApolloConstant.N;; localObject1 = localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_b_of_type_JavaLangString)
      {
        localObject2 = new Intent(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        VasWebviewUtil.openQQBrowserActivity(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1, -1L, (Intent)localObject2, false, -1);
        break;
      }
    } while (1 != paramInt);
    label304:
    boolean bool;
    label364:
    int i;
    if (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
    {
      paramInt = 1;
      localObject1 = new Intent();
      localObject2 = localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((Intent)localObject1).putExtra("extra_key_box_uin", (String)localObject2);
      ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + (String)localObject2);
      if (paramInt == 0) {
        break label486;
      }
      bool = true;
      ((Intent)localObject1).putExtra("extra_key_open_box", bool);
      ((Intent)localObject1).putExtra("extra_key_box_from", "drawer");
      ApolloUtil.a(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject1, "drawer");
      localObject2 = localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = localQQSettingMe.f;
      if (paramInt == 0) {
        break label492;
      }
    }
    label486:
    label492:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "drawer_clk", i, 0, new String[] { localObject1, "0", "drawer" });
      if (paramInt == 0) {
        break;
      }
      VipUtils.a(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
      localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      return;
      paramInt = 0;
      break label304;
      bool = false;
      break label364;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQSettingMe == null) {}
    QQAppInterface localQQAppInterface;
    ApolloTextureView localApolloTextureView;
    do
    {
      do
      {
        return;
        localQQAppInterface = localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localApolloTextureView = localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
      } while ((localQQAppInterface == null) || (localApolloTextureView == null) || (localQQAppInterface.a() == null));
      localObject = localQQAppInterface.a().getResources();
      long l1 = Math.min(DeviceInfoUtil.g(), DeviceInfoUtil.f());
      long l2 = Math.max(DeviceInfoUtil.g(), DeviceInfoUtil.f());
      paramInt1 = (int)((l1 - ((Resources)localObject).getDimensionPixelSize(2131493298) - AIOUtils.a(160.0F, (Resources)localObject)) / 2L);
      localQQSettingMe.jdField_a_of_type_Float = ((localApolloTextureView.getWidth() - paramInt1) / DeviceInfoUtil.a());
      localQQSettingMe.jdField_b_of_type_Float = 15.0F;
      float f = (float)(l2 >> 2) / 368.0F;
      if (l2 != DeviceInfoUtil.i()) {
        QLog.e("QQSettingRedesign", 1, "DeviceInfoUtil.getPortraitHeight():" + DeviceInfoUtil.i() + " height:" + l2);
      }
      localApolloTextureView.a().a(1, localQQSettingMe.jdField_e_of_type_Int, f, localQQSettingMe.jdField_a_of_type_Float, localQQSettingMe.jdField_b_of_type_Float);
      ApolloActionManager.a().b();
      if ((localQQSettingMe.jdField_e_of_type_Int > 0) && (localQQSettingMe.jdField_a_of_type_ArrayOfInt != null)) {
        localApolloTextureView.a().a(1, localQQSettingMe.jdField_a_of_type_ArrayOfInt, null);
      }
      localApolloTextureView.a().a(1000L);
    } while ((!this.jdField_a_of_type_Boolean) || (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null));
    Object localObject = ApolloActionTask.a(5, localQQSettingMe.jdField_e_of_type_Int, true);
    if (localApolloTextureView.a().a(1, 5, ApolloActionManager.a().b() + 1000000, localObject[0], localObject[1]) == 0)
    {
      localObject = localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0);
      if (((SharedPreferences)localObject).getBoolean(localQQAppInterface.getAccount() + "apollo_settingme_first_enter", true))
      {
        ApolloActionManager.a().a.set(2);
        localApolloTextureView.a().b(2, 1, localQQSettingMe.jdField_e_of_type_Int, "点我吧~", localQQAppInterface.a());
        ((SharedPreferences)localObject).edit().putBoolean(localQQAppInterface.getAccount() + "apollo_settingme_first_enter", false).commit();
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localQQSettingMe == null) || (localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "taskId->" + paramInt1 + " errCode->" + paramInt2 + " roleName->" + paramString);
      }
      localQQSettingMe.d = true;
      localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(0L);
      if (!localQQSettingMe.jdField_e_of_type_Boolean) {
        localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
      }
    } while (localQQSettingMe.jdField_b_of_type_Boolean);
    localQQSettingMe.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramString == null) || (paramString.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null)) {
      return;
    }
    paramString.d = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */