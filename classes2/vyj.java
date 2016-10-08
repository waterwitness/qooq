import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.mobileqq.util.HbThemeConfigManager.HBThemeConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class vyj
  implements Runnable
{
  public vyj(HbThemeConfigManager paramHbThemeConfigManager, String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    int j;
    for (;;)
    {
      synchronized (HbThemeConfigManager.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("HbThemeConfigManager", 2, "update hbTheme config: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.clear();
        Object localObject1 = HbThemeConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject2 = new File((String)localObject1, "hbThemeConfig.cfg");
        boolean bool = ((File)localObject2).exists();
        if (!bool) {
          break label413;
        }
        try
        {
          Object localObject3 = FileUtils.b((File)localObject2);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = new String(Base64.decode((String)localObject3, 0));
            if (QLog.isColorLevel()) {
              QLog.d("HbThemeConfigManager", 2, "load local config:  " + (String)localObject3);
            }
            localObject3 = HbThemeConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3);
            if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.addAll((Collection)localObject3);
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("HbThemeConfigManager", 2, "load hbTheme config exception: " + localException.toString());
          continue;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label413;
        }
        ((File)localObject2).delete();
        if (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.isEmpty()) {
          break label410;
        }
        j = this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.size();
        if (i >= j) {
          break;
        }
        localObject1 = (HbThemeConfigManager.HBThemeConfig)this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.get(i);
        if (localObject1 == null)
        {
          i += 1;
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("HbThemeConfigManager", 2, "load local hbTheme config empty");
        }
      }
      PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str.b);
      PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str.c);
      PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.clear();
    if (QLog.isColorLevel()) {
      QLog.d("HbThemeConfigManager", 2, "当前配置为空，要删除旧配置信息和预下载的图片 ");
    }
    label410:
    return;
    label413:
    Object localObject2 = HbThemeConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    int k;
    HashSet localHashSet;
    HbThemeConfigManager.HBThemeConfig localHBThemeConfig1;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      k = ((List)localObject2).size();
      localHashSet = new HashSet(12);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.isEmpty()) {
        break label932;
      }
      int m = this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.size();
      i = 0;
      if (i < k)
      {
        localHBThemeConfig1 = (HbThemeConfigManager.HBThemeConfig)((List)localObject2).get(i);
        if (localHBThemeConfig1 != null) {
          break label917;
        }
        break label908;
        label521:
        if (j >= m) {
          break label908;
        }
        HbThemeConfigManager.HBThemeConfig localHBThemeConfig2 = (HbThemeConfigManager.HBThemeConfig)this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.get(j);
        if ((localHBThemeConfig2 == null) || (localHBThemeConfig1.a != localHBThemeConfig2.a)) {
          break label923;
        }
        if ((!TextUtils.isEmpty(localHBThemeConfig1.b)) && (!localHBThemeConfig1.b.equals(localHBThemeConfig2.b)))
        {
          PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHBThemeConfig2.b);
          localHashSet.add(localHBThemeConfig1.b);
        }
        if ((!TextUtils.isEmpty(localHBThemeConfig1.c)) && (!localHBThemeConfig1.c.equals(localHBThemeConfig2.c)))
        {
          PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHBThemeConfig2.c);
          localHashSet.add(localHBThemeConfig1.c);
        }
        if ((TextUtils.isEmpty(localHBThemeConfig1.d)) || (localHBThemeConfig1.d.equals(localHBThemeConfig2.d))) {
          break label923;
        }
        PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHBThemeConfig2.d);
        localHashSet.add(localHBThemeConfig1.d);
        break label923;
      }
    }
    for (;;)
    {
      if (i < k)
      {
        localHBThemeConfig1 = (HbThemeConfigManager.HBThemeConfig)((List)localObject2).get(i);
        if (localHBThemeConfig1 != null)
        {
          if (!TextUtils.isEmpty(localHBThemeConfig1.b)) {
            localHashSet.add(localHBThemeConfig1.b);
          }
          if (!TextUtils.isEmpty(localHBThemeConfig1.c)) {
            localHashSet.add(localHBThemeConfig1.c);
          }
          if (!TextUtils.isEmpty(localHBThemeConfig1.d)) {
            localHashSet.add(localHBThemeConfig1.d);
          }
        }
      }
      else
      {
        if (!localHashSet.isEmpty()) {
          PreloadImgManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHashSet);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.clear();
        this.jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager.a.addAll((Collection)localObject2);
        FileUtils.a(str, "hbThemeConfig.cfg", Base64.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 0));
        return;
        label908:
        i += 1;
        break;
        label917:
        j = 0;
        break label521;
        label923:
        j += 1;
        break label521;
        label932:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */