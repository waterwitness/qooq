package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

class VasCommonJsPlugin$JsDebugDialog
  extends Dialog
{
  TextView textView;
  
  public VasCommonJsPlugin$JsDebugDialog(VasCommonJsPlugin paramVasCommonJsPlugin, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.getWindow().setFlags(1024, 1024);
    super.requestWindowFeature(1);
    paramVasCommonJsPlugin = new RelativeLayout(paramContext);
    paramVasCommonJsPlugin.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ScrollView localScrollView = new ScrollView(paramContext);
    localScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.textView = new TextView(paramContext);
    this.textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localScrollView.addView(this.textView);
    paramVasCommonJsPlugin.addView(localScrollView);
    super.setContentView(paramVasCommonJsPlugin);
  }
  
  public void dismiss()
  {
    this.textView.setText("");
    super.dismiss();
  }
  
  public void log(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.textView.setText("");
    String str = (String)this.textView.getText();
    Iterator localIterator = paramList.iterator();
    for (paramList = str; localIterator.hasNext(); paramList = paramList + "log:" + str + "\n") {
      str = (String)localIterator.next();
    }
    this.textView.setText(paramList);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasCommonJsPlugin$JsDebugDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */