package com.tencent.mobileqq.config.struct;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.config.Command;
import com.tencent.mobileqq.config.ConfigDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class ADMsg$TextBox
  extends ConfigDialog
{
  public ADMsg$TextBox(ADMsg paramADMsg, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ADMsg$TextBox(ADMsg paramADMsg, String paramString1, String paramString2, int paramInt)
  {
    super(BaseApplication.getContext());
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(Command paramCommand) {}
  
  public void a(ADMsg paramADMsg) {}
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.d;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\struct\ADMsg$TextBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */