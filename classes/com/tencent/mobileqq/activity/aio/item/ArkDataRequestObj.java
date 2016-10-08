package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.ark.ark.ArgumentsWrapper;
import com.tencent.ark.ark.RuntimeClassCallbackWrapper;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import nil;
import nll;
import noj;

public class ArkDataRequestObj
  implements ark.RuntimeClassCallbackWrapper, nll
{
  private ark.VariantWrapper jdField_a_of_type_ComTencentArkArk$VariantWrapper;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private nil jdField_a_of_type_Nil;
  
  public ArkDataRequestObj(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = paramString.indexOf("://");
    } while (i < 0);
    return paramString.substring(0, i);
  }
  
  private void a(ark.VariantWrapper paramVariantWrapper)
  {
    if (this.jdField_a_of_type_ComTencentArkArk$VariantWrapper != null)
    {
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.Reset();
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = null;
    }
    if (paramVariantWrapper != null) {
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = paramVariantWrapper.Copy();
    }
  }
  
  private boolean a(ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    b();
    if (paramArgumentsWrapper.GetCount() < 2L) {}
    do
    {
      String str;
      do
      {
        do
        {
          paramVariantWrapper.SetBool(false);
          return true;
          paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(1L).GetString();
        } while (TextUtils.isEmpty(paramArgumentsWrapper));
        str = a(paramArgumentsWrapper);
      } while ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("sso")));
      this.jdField_a_of_type_Nil = new noj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (!this.jdField_a_of_type_Nil.a(paramArgumentsWrapper));
    paramVariantWrapper.SetBool(true);
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Nil != null)
    {
      this.jdField_a_of_type_Nil.a(null);
      this.jdField_a_of_type_Nil.a();
      this.jdField_a_of_type_Nil = null;
    }
  }
  
  private boolean b(ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    b();
    paramVariantWrapper.SetBool(true);
    return true;
  }
  
  private boolean c(ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (paramArgumentsWrapper.GetCount() < 3L) {}
    String str;
    do
    {
      paramVariantWrapper.SetBool(false);
      return true;
      str = paramArgumentsWrapper.GetArgument(1L).GetString();
      paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(2L);
    } while ((TextUtils.isEmpty(str)) || (paramArgumentsWrapper == null) || (!paramArgumentsWrapper.IsFunction()) || (!str.equals("OnComplete")));
    a(paramArgumentsWrapper);
    paramVariantWrapper.SetBool(true);
    return true;
  }
  
  private boolean d(ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (paramArgumentsWrapper.GetCount() < 2L) {}
    do
    {
      paramVariantWrapper.SetBool(false);
      return true;
      paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(1L).GetString();
    } while ((TextUtils.isEmpty(paramArgumentsWrapper)) || (!paramArgumentsWrapper.equals("OnComplete")));
    a(null);
    paramVariantWrapper.SetBool(true);
    return true;
  }
  
  private boolean e(ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((this.jdField_a_of_type_Nil == null) || (paramArgumentsWrapper.GetCount() < 2L)) {}
    do
    {
      paramVariantWrapper.SetBool(false);
      return true;
      paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(1L);
    } while (paramArgumentsWrapper == null);
    if (paramArgumentsWrapper.GetType() == 1) {
      paramArgumentsWrapper = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Nil.a(this);
      if (!this.jdField_a_of_type_Nil.b(paramArgumentsWrapper)) {
        break;
      }
      paramVariantWrapper.SetBool(true);
      return true;
      if (paramArgumentsWrapper.GetType() == 5)
      {
        paramArgumentsWrapper = paramArgumentsWrapper.GetString();
      }
      else
      {
        if (!paramArgumentsWrapper.IsArray()) {
          break;
        }
        paramArgumentsWrapper = paramArgumentsWrapper.GetTableAsJsonString();
      }
    }
  }
  
  private boolean f(ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    int j = 0;
    if ((this.jdField_a_of_type_Nil == null) || (paramArgumentsWrapper.GetCount() < 2L))
    {
      paramVariantWrapper.SetBool(false);
      return true;
    }
    paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(1L);
    int i;
    if (paramArgumentsWrapper == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < 0) {
        i = j;
      }
      for (;;)
      {
        this.jdField_a_of_type_Nil.a(i);
        paramVariantWrapper.SetBool(true);
        return true;
        if (paramArgumentsWrapper.GetType() == 3)
        {
          i = paramArgumentsWrapper.GetInt();
          break;
        }
        if (paramArgumentsWrapper.GetType() != 4) {
          break label100;
        }
        i = (int)paramArgumentsWrapper.GetDouble();
        break;
      }
      label100:
      i = 0;
    }
  }
  
  private boolean g(ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Nil == null) || (paramArgumentsWrapper.GetCount() < 1L))
    {
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (this.jdField_a_of_type_Nil.a() == 0) {
      bool = true;
    }
    paramVariantWrapper.SetBool(bool);
    return true;
  }
  
  private boolean h(ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((this.jdField_a_of_type_Nil == null) || (paramArgumentsWrapper.GetCount() < 2L)) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              paramVariantWrapper.SetNull();
              return true;
            } while (this.jdField_a_of_type_Nil.a() != 0);
            str = this.jdField_a_of_type_Nil.a();
          } while (str == null);
          paramArgumentsWrapper = paramArgumentsWrapper.GetArgument(1L).GetString();
        } while (TextUtils.isEmpty(paramArgumentsWrapper));
        if (!paramArgumentsWrapper.equals("text")) {
          break;
        }
        paramArgumentsWrapper = str;
        if (str == null) {
          paramArgumentsWrapper = "";
        }
      } while (!paramVariantWrapper.SetString(paramArgumentsWrapper));
      return true;
    } while ((!paramArgumentsWrapper.equals("json")) || (!paramVariantWrapper.SetTableAsJsonString(str)));
    return true;
  }
  
  public boolean Destruct()
  {
    b();
    a(null);
    return true;
  }
  
  public boolean HasMethod(String paramString)
  {
    return (paramString.equals("Open")) || (paramString.equals("Abort")) || (paramString.equals("AttachEvent")) || (paramString.equals("DetachEvent")) || (paramString.equals("Send")) || (paramString.equals("SetTimeout")) || (paramString.equals("IsSuccess")) || (paramString.equals("GetData"));
  }
  
  public boolean Invoke(String paramString, ark.ArgumentsWrapper paramArgumentsWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (paramString.equals("Open")) {
        return a(paramArgumentsWrapper, paramVariantWrapper);
      }
      if (paramString.equals("Abort")) {
        return b(paramArgumentsWrapper, paramVariantWrapper);
      }
      if (paramString.equals("AttachEvent")) {
        return c(paramArgumentsWrapper, paramVariantWrapper);
      }
      if (paramString.equals("DetachEvent")) {
        return d(paramArgumentsWrapper, paramVariantWrapper);
      }
      if (paramString.equals("Send")) {
        return e(paramArgumentsWrapper, paramVariantWrapper);
      }
      if (paramString.equals("SetTimeout")) {
        return f(paramArgumentsWrapper, paramVariantWrapper);
      }
      if (paramString.equals("IsSuccess")) {
        return g(paramArgumentsWrapper, paramVariantWrapper);
      }
    } while (!paramString.equals("GetData"));
    return h(paramArgumentsWrapper, paramVariantWrapper);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Nil == null) {}
    while ((this.jdField_a_of_type_ComTencentArkArk$VariantWrapper == null) || (!this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.IsFunction())) {
      return;
    }
    ark.ArgumentsWrapper localArgumentsWrapper = ark.ArgumentsWrapper.Create();
    ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.Create();
    this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.InvokeDefault(localArgumentsWrapper, localVariantWrapper);
    localVariantWrapper.Reset();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ArkDataRequestObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */