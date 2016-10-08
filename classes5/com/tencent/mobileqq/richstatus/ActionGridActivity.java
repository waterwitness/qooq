package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import uha;
import uhb;

public class ActionGridActivity
  extends IphoneTitleBarActivity
  implements IActionListener, IIconListener, AdapterView.OnItemClickListener
{
  private static final int jdField_a_of_type_Int = 80;
  public static final String a;
  private static final int b = 100;
  private ActionInfo jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private GridListView jdField_a_of_type_ComTencentMobileqqWidgetGridListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private uha jdField_a_of_type_Uha;
  private int c;
  private int d;
  private int e = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ActionGridActivity.class.getSimpleName();
  }
  
  private void a()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.c = (localDisplayMetrics.widthPixels / this.e);
    this.d = ((int)(localDisplayMetrics.density * 100.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setNumColumns(this.e);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSpacing(0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSize(this.c, this.d);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 100)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.i, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Uha.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int i;
    if ((paramInt2 == 201) && (paramBitmap != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.a();
      paramInt2 = 0;
    }
    for (;;)
    {
      if (paramInt2 < i)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.a(paramInt2);
        if (localObject != null) {}
      }
      else
      {
        return;
      }
      Object localObject = (uhb)((View)localObject).getTag();
      if (((uhb)localObject).jdField_a_of_type_Int == paramInt1)
      {
        ((uhb)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
        return;
      }
      paramInt2 += 1;
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ActionInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView = new Intent();
    paramView.putExtra("k_action_id", paramAdapterView.i);
    paramView.putExtra("k_action_text", paramAdapterView.d);
    setResult(-1, paramView);
    ReportController.b(this.app, "CliOper", "", "", "0X8006988", "0X8006988", 0, 0, Integer.toString(paramAdapterView.i), "", "", "");
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130905017);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    int i = getIntent().getIntExtra("k_action_id", 0);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(i);
    if ((i == 0) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo == null))
    {
      finish();
      return false;
    }
    setTitle(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.c);
    if (AppSetting.j) {
      this.leftView.setContentDescription(this.leftView.getText() + "按钮");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131305048));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnItemClickListener(this);
    i = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionInfo.i, this.jdField_a_of_type_JavaUtilArrayList);
    if (i != 100) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(1);
    this.jdField_a_of_type_Uha = new uha(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_Uha);
    a();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    if (ThemeUtil.isInNightMode(this.app))
    {
      paramBundle = new View(this);
      paramBundle.setBackgroundColor(1996488704);
      addContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    super.doOnDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richstatus\ActionGridActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */