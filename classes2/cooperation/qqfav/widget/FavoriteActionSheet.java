package cooperation.qqfav.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import ygt;
import ygu;

public class FavoriteActionSheet
  implements View.OnClickListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "qqfav.FavoriteActionSheet";
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  public static final int g = 64;
  public ActionSheet a;
  public FavoriteActionSheet.Actions a;
  public List a;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public boolean a;
  public List b;
  int h;
  int i;
  
  public FavoriteActionSheet(Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_Boolean = false;
    this.h = 1;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
    this.i = -1;
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    this.h = paramInt1;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = paramActions;
    this.i = paramInt2;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(paramActivity, null));
    if ((this.h & 0x10) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131368747, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(16));
    }
    if ((this.h & 0x20) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131366026, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(32));
    }
    if ((this.h & 0x40) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131366044, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(64));
    }
    if ((this.h & 0x1) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131369281, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    }
    if ((this.h & 0x2) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131364463, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
    }
    if ((this.h & 0x4) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131365886, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
    }
    if ((this.h & 0x8) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131362834, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ygt(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new ygu(this));
  }
  
  private void b()
  {
    QfavReport.a(this.jdField_a_of_type_MqqAppAppRuntime, "User_Forward", this.i, 0, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        break label44;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
      return;
      label44:
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString, 5);
    this.b.add(paramString);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqfav\widget\FavoriteActionSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */