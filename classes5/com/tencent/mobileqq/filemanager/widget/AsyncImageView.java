package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImageView
  extends URLImageView
{
  private int jdField_a_of_type_Int = 128;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int b = 128;
  
  public AsyncImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = paramFile.lastModified();
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l + "|1";
    if (paramBoolean1)
    {
      paramString = paramString + "|1";
      if (!paramBoolean2) {
        break label142;
      }
    }
    for (paramString = paramString + "|1";; paramString = paramString + "|0")
    {
      try
      {
        paramString = new URL("fileassistantimage", "", paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        label142:
        if (!QLog.isColorLevel()) {
          break label183;
        }
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
      paramString = paramString + "|0";
      break;
    }
    label183:
    return null;
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = paramFile.lastModified();
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l + "|1";
    if (paramBoolean1)
    {
      paramString = paramString + "|1";
      if (!paramBoolean2) {
        break label167;
      }
      paramString = paramString + "|1";
      label104:
      if (!paramBoolean3) {
        break label190;
      }
    }
    for (paramString = paramString + "|1";; paramString = paramString + "|0")
    {
      try
      {
        paramString = new URL("fileassistantimage", "", paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        label167:
        label190:
        if (!QLog.isColorLevel()) {
          break label231;
        }
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
      paramString = paramString + "|0";
      break;
      paramString = paramString + "|0";
      break label104;
    }
    label231:
    return null;
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public static URL b(String paramString, int paramInt1, int paramInt2, File paramFile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = 0L;
    if (paramFile != null) {
      l = paramFile.lastModified();
    }
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l + "|1";
    if (paramBoolean1)
    {
      paramString = paramString + "|1";
      if (!paramBoolean2) {
        break label174;
      }
      paramString = paramString + "|1";
      label111:
      if (!paramBoolean3) {
        break label197;
      }
    }
    for (paramString = paramString + "|1";; paramString = paramString + "|0")
    {
      try
      {
        paramString = new URL("fileassistantimage", "", paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        label174:
        label197:
        if (!QLog.isColorLevel()) {
          break label238;
        }
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
      paramString = paramString + "|0";
      break;
      paramString = paramString + "|0";
      break label111;
    }
    label238:
    return null;
  }
  
  public void setApkIconAsyncImage(String paramString)
  {
    if (paramString == null) {
      return;
    }
    File localFile = new File(paramString);
    if (localFile.exists()) {
      try
      {
        int i = getWidth();
        int j = getHeight();
        if ((i > 0) && (j > 0))
        {
          this.jdField_a_of_type_Int = i;
          this.b = j;
        }
        setAdjustViewBounds(false);
        setImageDrawable(URLDrawable.getDrawable(a(paramString, this.jdField_a_of_type_Int, this.b, localFile, false, true), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true));
        return;
      }
      catch (Exception paramString)
      {
        a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
    }
    a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setAsyncClipSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (paramInt2 > 0) {
      this.b = paramInt2;
    }
  }
  
  public void setAsyncImage(String paramString)
  {
    setAsyncImage(paramString, false);
  }
  
  public void setAsyncImage(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      File localFile = new File(paramString);
      if (!localFile.exists()) {
        break label97;
      }
      try
      {
        setAdjustViewBounds(false);
        paramString = a(paramString, this.jdField_a_of_type_Int, this.b, localFile, paramBoolean, false);
        if (paramString != null)
        {
          paramString = URLDrawable.getDrawable(paramString, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
          if (paramString == null)
          {
            a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
    }
    setImageDrawable(paramString);
    return;
    label97:
    a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
    setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\widget\AsyncImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */