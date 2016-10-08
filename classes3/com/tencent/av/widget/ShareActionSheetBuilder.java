package com.tencent.av.widget;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import hcg;
import mqq.app.BaseActivity;

public class ShareActionSheetBuilder
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "LinkShareDialogBuilder";
  public static final int b = 3;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 4;
  private BaseActivity jdField_a_of_type_MqqAppBaseActivity;
  
  public ShareActionSheetBuilder(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBaseActivity;
  }
  
  public ActionSheet a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2130905086, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837524));
    localGridView.setAdapter(new hcg(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localActionSheet.a(localGridView);
    localActionSheet.d(2131367262);
    return localActionSheet;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\ShareActionSheetBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */