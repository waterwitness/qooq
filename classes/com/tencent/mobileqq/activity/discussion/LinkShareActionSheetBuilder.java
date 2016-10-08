package com.tencent.mobileqq.activity.discussion;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import oks;

public class LinkShareActionSheetBuilder
{
  public static final int a = 3;
  public static final int b = 2;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 4;
  public static final int f = 5;
  private BaseActivity a;
  
  public LinkShareActionSheetBuilder(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBaseActivity;
  }
  
  public ActionSheet a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2130905086, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837524));
    localGridView.setAdapter(new oks(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localActionSheet.a(localGridView);
    localActionSheet.d(2131367262);
    return localActionSheet;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\discussion\LinkShareActionSheetBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */