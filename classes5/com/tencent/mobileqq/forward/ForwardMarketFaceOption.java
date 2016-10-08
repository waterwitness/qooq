package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import slf;

public class ForwardMarketFaceOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardMarketFaceOption";
  
  public ForwardMarketFaceOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  protected void a(QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardMarketFaceOption", 2, "updateImageView:setDialogPreviewImage");
    }
    Object localObject = MarketFaceItemBuilder.a;
    if (localObject == null) {
      return;
    }
    localObject = ((PicEmoticonInfo)localObject).a("fromAIO", false);
    ((URLDrawable)localObject).setBounds(ImageUtil.a((Drawable)localObject, 36, 100, this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new slf(this, paramQQCustomDialog, (URLDrawable)localObject));
  }
  
  protected boolean c()
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardMarketFaceOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */