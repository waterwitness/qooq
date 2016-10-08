package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import sli;

public class ForwardQFavBatchOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardQFavBatchOption";
  public static final String g = "bSinglePicSelected";
  boolean g;
  
  public ForwardQFavBatchOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = false;
  }
  
  protected Bitmap a(String paramString)
  {
    if (this.g)
    {
      Bitmap localBitmap2 = BitmapManager.a(paramString, 100, 100);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null) {
        localBitmap1 = ImageUtil.a(localBitmap2, new File(paramString));
      }
      return localBitmap1;
    }
    return super.a(paramString);
  }
  
  public String a()
  {
    if (!this.g) {}
    for (this.c = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");; this.c = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardQFavBatchOption", 2, "DialogContent:mForwardText=" + this.c);
      }
      return this.c;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.g = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("bSinglePicSelected", false);
    if ((this.g) && (TextUtils.isEmpty(this.d))) {
      this.d = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_skip_confirm", false)) {
      p();
    }
    return true;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithEmo(this.c, this.jdField_a_of_type_Float);
    TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getMessageTextView();
    ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
    localLayoutParams.width = -1;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(17);
  }
  
  public String c()
  {
    if (!this.g) {
      return this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131366035);
    }
    return null;
  }
  
  protected void m()
  {
    if (this.g) {
      n();
    }
  }
  
  public void p()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject2 = new Intent();
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("needStartChatActivity", false);
    ((Intent)localObject2).putExtra("needStartChatActivity", bool);
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = AIOUtils.a((Intent)localObject2, null);
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    localObject1 = new Intent((Intent)localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i;
    ArrayList localArrayList;
    int j;
    label157:
    Object localObject3;
    MqqHandler localMqqHandler;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forwardFromAIO", false))
    {
      i = 2;
      localArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("bundleList");
      j = 0;
      if (j >= localArrayList.size()) {
        break label258;
      }
      localObject3 = (Bundle)localArrayList.get(j);
      if (localObject3 != null)
      {
        localMqqHandler = ThreadManager.c();
        localObject3 = new sli(this, (Bundle)localObject3, (String)localObject2, str2, str1, k, i, str3, (Intent)localObject1);
        if (j != 0) {
          break label247;
        }
      }
    }
    label247:
    for (long l = 200L;; l = j * 10)
    {
      localMqqHandler.postDelayed((Runnable)localObject3, l);
      j += 1;
      break label157;
      i = 1;
      break;
    }
    label258:
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_BatchForwardSendBtnClick", 0, 0, localArrayList.size());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardQFavBatchOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */