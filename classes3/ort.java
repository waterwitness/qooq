import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.onSelectionChangeListener;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ort
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public ort(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.g) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
    long l;
    do
    {
      return;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Orv.a(this.jdField_a_of_type_Int);
      i = localLocalMediaInfo.jdField_b_of_type_Int;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.C) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.o == 9501) && (i == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.c.size() >= 1))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "最多只能选择1张图片", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.r);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        return;
      }
      if ((i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.c.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Long < 1000L);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "最多只能选择" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n + "张图片", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.r);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Long = l;
    return;
    boolean bool;
    label246:
    String str;
    Object localObject;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.jdField_b_of_type_Int = i;
      if (localLocalMediaInfo.jdField_b_of_type_Int != 1) {
        break label690;
      }
      bool = true;
      str = localLocalMediaInfo.jdField_a_of_type_JavaLangString;
      paramView = PresendPicMgr.a();
      if (!bool) {
        break label696;
      }
      localObject = MimeHelper.a(localLocalMediaInfo.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.D) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
        ((PhotoListActivity)localObject).t += 1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.t == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.c.add(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.d.add(localLocalMediaInfo.jdField_a_of_type_JavaLangInteger);
      if (paramView != null) {
        paramView.a(str, 1007, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent().getIntExtra("entrance", 0));
      }
      StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent(), "param_totalSelNum");
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      localObject = (LinkedHashMap)AlbumUtil.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.m);
      paramView = (View)localObject;
      if (localObject == null)
      {
        paramView = new LinkedHashMap();
        AlbumUtil.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.m, paramView);
      }
      paramView.put(str, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s()));
      paramView = AlbumUtil.c;
      if (!paramView.containsKey(str)) {
        paramView.put(str, new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.m, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.l));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity$onSelectionChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity$onSelectionChangeListener.a(bool, localLocalMediaInfo);
      }
      PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_Int, bool);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.p == 2) && (new File(localLocalMediaInfo.jdField_a_of_type_JavaLangString).length() > 19922944L))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getResources().getString(2131370138), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.r);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.p = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.g();
      }
      bool = PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b.setChecked(bool);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.e();
      return;
      i = 1;
      break;
      label690:
      bool = false;
      break label246;
      label696:
      localObject = MimeHelper.a(localLocalMediaInfo.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.D) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
        ((PhotoListActivity)localObject).t -= 1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.t == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.c.remove(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.d.remove(localLocalMediaInfo.jdField_a_of_type_JavaLangInteger);
      if (paramView != null) {
        paramView.b(str, 1013);
      }
      StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent(), "param_cancelSelNum");
      paramView = (HashMap)AlbumUtil.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.m);
      if (paramView != null) {
        paramView.remove(str);
      }
      paramView = AlbumUtil.c;
      if (paramView.containsKey(str)) {
        paramView.remove(str);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */