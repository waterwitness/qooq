package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LebaIconDownloader;
import com.tencent.mobileqq.activity.LebaIconDownloader.DownloadListenerAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountConfigUtil$PublicAccountConfigFolder
{
  int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public PublicAccountConfigUtil$PublicAccountConfigFolder(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.c = "";
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramContext.getString(paramInt2);
    this.b = "";
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(paramInt3);
      this.c = a(paramInt1);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;) {}
    }
  }
  
  public PublicAccountConfigUtil$PublicAccountConfigFolder(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.c = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = a(paramInt);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = PublicAccountConfigUtil.a(paramContext, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder mId: " + this.jdField_a_of_type_Int + " | mName: " + this.jdField_a_of_type_JavaLangString + " | mIconUrl: " + this.b + " | mUin : " + this.c);
    }
    if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c)))
    {
      paramString1 = LebaIconDownloader.b(paramContext, paramString2);
      if (paramString1 != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString1;
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      LebaIconDownloader.a(paramQQAppInterface, paramContext, paramString2, new LebaIconDownloader.DownloadListenerAdapter(paramContext, new PublicAccountConfigUtil.PublicAccountDownloadListener(this, paramQQAppInterface, this.c), new Object[0]));
      return;
    }
    QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder mIconUrl is empty");
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return String.valueOf(7210);
    case 2: 
      return String.valueOf(AppConstants.aZ);
    }
    return String.valueOf(AppConstants.ba);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PublicAccountConfigUtil$PublicAccountConfigFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */