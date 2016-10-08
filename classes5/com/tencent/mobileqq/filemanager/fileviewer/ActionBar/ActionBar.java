package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ActionBar
{
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private String jdField_a_of_type_JavaLangString;
  
  public ActionBar()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StateListDrawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    Drawable localDrawable = paramContext.getResources().getDrawable(paramInt1);
    paramContext = paramContext.getResources().getDrawable(paramInt2);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[0], localDrawable);
  }
  
  public void a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramDrawable2);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842910 }, paramDrawable1);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[0], paramDrawable1);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\ActionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */