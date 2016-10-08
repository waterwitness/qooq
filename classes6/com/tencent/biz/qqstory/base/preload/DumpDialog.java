package com.tencent.biz.qqstory.base.preload;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ihc;
import ihf;
import java.util.ArrayList;
import java.util.List;

public class DumpDialog
  extends Dialog
  implements View.OnClickListener
{
  public ListView a;
  public TextView a;
  public ihc a;
  public ihf a;
  public List a;
  public TextView b;
  
  public DumpDialog(Context paramContext)
  {
    super(paramContext, 2131558944);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Ihf = new ihf(this, null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    super.requestWindowFeature(1);
    a(paramContext);
    ((PreloadDownloaderManager)SuperManager.a(6)).a(this.jdField_a_of_type_Ihf);
    setCancelable(true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130904477, null);
    super.setContentView(paramContext);
    WindowManager.LayoutParams localLayoutParams = super.getWindow().getAttributes();
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.windowAnimations = 16973824;
    localLayoutParams.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131300184));
    this.b = ((TextView)paramContext.findViewById(2131302867));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)paramContext.findViewById(2131300958));
    this.jdField_a_of_type_Ihc = new ihc(this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Ihc);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300184: 
      dismiss();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ihc.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\DumpDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */