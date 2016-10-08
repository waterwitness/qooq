package com.tencent.mobileqq.rn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;

public class RCTAvatar
  extends ImageView
{
  protected static final String a;
  public int a;
  public boolean a;
  protected int b;
  public String b;
  public boolean b;
  protected int c;
  protected String c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = RCTAvatar.class.getSimpleName();
  }
  
  public RCTAvatar(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Int = 202;
    this.jdField_c_of_type_JavaLangString = "";
    setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  private void b()
  {
    QAvatarHelper.a().b(this);
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    setImageDrawable(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      b();
    }
    super.onDraw(paramCanvas);
  }
  
  public void setHeadId(String paramString)
  {
    if (!NearbyUtils.a(this.jdField_c_of_type_JavaLangString, paramString))
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      a();
    }
  }
  
  public void setHeadIdType(int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      a();
    }
  }
  
  public void setHeadShape(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      a();
    }
  }
  
  public void setImageDrawable(String paramString, Drawable paramDrawable)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      setImageDrawable(paramDrawable);
      return;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    localStringBuilder.append("[").append(this.jdField_a_of_type_Int).append(",").append(this.jdField_c_of_type_JavaLangString).append(",").append(this.jdField_b_of_type_JavaLangString).append(",").append(this.jdField_a_of_type_Boolean).append(",").append(this.jdField_b_of_type_Boolean).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\RCTAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */