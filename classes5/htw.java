import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.biz.pubaccount.ecshopassit.EcShopRecommendView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;

public class htw
  extends EcShopObserver
{
  public htw(EcShopAssistantActivity paramEcShopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    boolean bool;
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof List)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantActivity", 2, "on Get RecommendList Finish,isSuccess = " + paramBoolean + "isNeedshow = " + bool + "is rich ad show:" + this.a.f);
      }
      if ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof String))) {
        break label192;
      }
      EcShopAssistantActivity.a(this.a).b();
      localEcShopAssistantActivity = this.a;
      localIntent = new Intent(localEcShopAssistantActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)paramObject);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localEcShopAssistantActivity.startActivity(localIntent);
      this.a.overridePendingTransition(2130968585, 0);
      ReportController.b(this.a.app, "CliOper", "", "", "Shop_newuser", "Pv_shopnewuserpage", 0, 0, "", "", "", "");
    }
    label192:
    while ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof List)))
    {
      EcShopAssistantActivity localEcShopAssistantActivity;
      Intent localIntent;
      return;
      bool = false;
      break;
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView.b((List)paramObject);
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof List)))
    {
      paramObject = (List)paramObject;
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager != null) {}
    }
    else
    {
      return;
    }
    List localList = this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a();
    int i;
    int j;
    if (localList == null)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (j >= ((List)paramObject).size()) {
        break label339;
      }
      qqshop.SQQSHPAccoutRelation localSQQSHPAccoutRelation = (qqshop.SQQSHPAccoutRelation)((List)paramObject).get(j);
      if (!localSQQSHPAccoutRelation.puin.has()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EcShopAssistantActivity", 2, "bindInfo puin:" + localSQQSHPAccoutRelation.puin.get() + ",uin:" + localSQQSHPAccoutRelation.binduin.get());
      }
      int k = 0;
      label144:
      if (k < i)
      {
        EcShopData localEcShopData = (EcShopData)localList.get(k);
        if (localEcShopData == null) {}
        for (;;)
        {
          k += 1;
          break label144;
          i = localList.size();
          break;
          if ((localEcShopData.mUin != null) && (localEcShopData.mUin.equals(String.valueOf(localSQQSHPAccoutRelation.puin.get()))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EcShopAssistantActivity", 2, "info.binduin:" + localSQQSHPAccoutRelation.binduin.get() + ",pad.bindUin:" + localSQQSHPAccoutRelation.binduin.get() + ",distance:" + localSQQSHPAccoutRelation.distance.get());
            }
            localEcShopData.bindUin = localSQQSHPAccoutRelation.binduin.get();
            localEcShopData.mDistance = localSQQSHPAccoutRelation.distance.get();
            this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(localEcShopData);
          }
        }
      }
      j += 1;
    }
    label339:
    EcShopAssistantActivity.a(this.a);
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcShopAssistantActivity", 2, "Ecshop reddot push receive!");
    }
    paramObject = EcShopAssistantActivity.a(this.a);
    if (((SharedPreferences)paramObject).getBoolean("folder_reddot", false)) {
      ((SharedPreferences)paramObject).edit().putBoolean("folder_reddot", false).commit();
    }
    this.a.c();
  }
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof String)))
    {
      paramObject = String.valueOf(paramObject);
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantActivity", 2, "get nearby recommend shop uin = " + (String)paramObject);
      }
      EcShopAssistantActivity.d = (String)paramObject;
      localObject = EcShopAssistantActivity.a(this.a).edit();
      ((SharedPreferences.Editor)localObject).putString("recommed_shop_uin", (String)paramObject);
      ((SharedPreferences.Editor)localObject).commit();
      if (this.a.jdField_b_of_type_AndroidWidgetImageView != null) {
        break label92;
      }
    }
    label92:
    while (TextUtils.isEmpty((CharSequence)paramObject)) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.a, this.a.app);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.a);
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, (String)paramObject);
    if (localObject == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a((String)paramObject, 1, true);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838582);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramObject = AnimationUtils.loadAnimation(this.a, 2130968768);
      ((Animation)paramObject).setAnimationListener(new htx(this));
      localObject = AnimationUtils.loadAnimation(this.a, 2130968767);
      this.a.jdField_b_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)paramObject);
      this.a.jdField_b_of_type_Boolean = true;
      return;
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
  }
  
  protected void f(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantActivity", 2, "get rich msg refresh imgs");
      }
      EcShopAssistantActivity.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */