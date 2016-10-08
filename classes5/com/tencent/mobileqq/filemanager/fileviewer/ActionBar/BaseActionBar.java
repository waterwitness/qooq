package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import sdw;
import sdx;
import sdy;
import sdz;
import sea;
import seb;
import sec;

public class BaseActionBar
{
  public LinearLayout a;
  public BaseActionBar.IActionBarClickEvent a;
  public HorizontalListViewAdapter a;
  public ActionSheet a;
  ArrayList a;
  ArrayList b;
  protected View c;
  ArrayList c;
  
  public BaseActionBar(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131300922);
  }
  
  protected void H_() {}
  
  public Button a(int paramInt)
  {
    if (((paramInt >= 3) || (paramInt < 0)) && (QLog.isDevelopLevel())) {
      throw new IndexOutOfBoundsException();
    }
    Button localButton = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localButton == null) {
        QLog.e("BaseActinBar<FileAssistant>", 1, "addActionBar getButton index is[" + paramInt + "]");
      }
      return localButton;
      localButton = (Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131300923);
      continue;
      localButton = (Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131300924);
      continue;
      localButton = (Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131300925);
    }
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    Button localButton = a(paramInt);
    if (localButton == null) {
      return;
    }
    localButton.setText(paramString);
    localButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Button localButton = a(paramInt);
    if (localButton == null) {}
    do
    {
      return;
      localButton.setEnabled(paramBoolean);
    } while (paramBoolean);
    localButton.setBackgroundResource(2130843110);
    localButton.setTextColor(-3355444);
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    ActionBar localActionBar = new ActionBar();
    localActionBar.a(new sdz(this, paramOnClickListener));
    localActionBar.a(paramContext, paramInt1, paramInt2);
    localActionBar.a(paramString);
    this.jdField_a_of_type_JavaUtilArrayList.add(localActionBar);
  }
  
  public void a(Context paramContext, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    ActionBar localActionBar = new ActionBar();
    localActionBar.a(new seb(this, paramOnClickListener));
    localActionBar.a(paramContext, paramDrawable1, paramDrawable2);
    localActionBar.a(paramString);
    this.b.add(localActionBar);
  }
  
  public void a(BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = paramIActionBarClickEvent;
  }
  
  public void a(Object paramObject) {}
  
  public ArrayList b()
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    return this.b;
  }
  
  public void b(Activity paramActivity)
  {
    a(2, "更多", new sdx(this, paramActivity));
    if (b().size() == 0)
    {
      a(2).setEnabled(false);
      a(2).setBackgroundResource(2130843110);
      a(2).setTextColor(-3355444);
      return;
    }
    a(2).setEnabled(true);
  }
  
  public void b(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ActionBar)((Iterator)localObject).next()).a().equalsIgnoreCase(paramString)) {
        return;
      }
    }
    localObject = new ActionBar();
    ((ActionBar)localObject).a(new sea(this, paramOnClickListener));
    ((ActionBar)localObject).a(paramContext, paramInt1, paramInt2);
    ((ActionBar)localObject).a(paramString);
    this.b.add(localObject);
  }
  
  public ArrayList c()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList == null) {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    }
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public void c(Activity paramActivity)
  {
    a(1, "转发", new sdw(this, paramActivity));
  }
  
  public void c(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_c_of_type_JavaUtilArrayList == null) {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    }
    ActionBar localActionBar = new ActionBar();
    localActionBar.a(new sec(this, paramOnClickListener));
    localActionBar.a(paramContext, paramInt1, paramInt2);
    localActionBar.a(paramString);
    this.jdField_c_of_type_JavaUtilArrayList.add(localActionBar);
  }
  
  public void d(Activity paramActivity)
  {
    a(0, "用其他应用打开", new sdy(this, paramActivity));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\BaseActionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */