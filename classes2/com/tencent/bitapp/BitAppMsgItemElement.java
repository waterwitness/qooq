package com.tencent.bitapp;

import android.content.Context;
import android.os.Bundle;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.bitapp.view.BitAppViewCreateExcepton;
import com.tencent.bitapp.view.IBitAppBaseViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BitAppMsgItemElement
{
  private static final int jdField_a_of_type_Int = 20;
  private static final String jdField_a_of_type_JavaLangString = BitAppMsgItemElement.class.getSimpleName();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private int d = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BitAppMsgItemElement(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramInt3;
    try
    {
      new JSONObject(this.jdField_c_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        this.jdField_a_of_type_Boolean = true;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Could not parse data from: " + this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public BitAppBaseView a(Context paramContext, Bundle paramBundle, IBitAppBaseViewListener paramIBitAppBaseViewListener)
  {
    try
    {
      paramContext = new BitAppBaseView(paramContext, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_c_of_type_JavaLangString, paramBundle, paramIBitAppBaseViewListener, "");
      paramBundle.printStackTrace();
    }
    catch (BitAppViewCreateExcepton paramBundle)
    {
      try
      {
        paramContext.setIsInListView(true);
        return paramContext;
      }
      catch (BitAppViewCreateExcepton paramBundle)
      {
        for (;;) {}
      }
      paramBundle = paramBundle;
      paramContext = null;
    }
    return paramContext;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMsgItemElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */