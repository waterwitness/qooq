package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.HashMap;

public abstract class IContactSearchModel
  implements ISearchResultModel, Cloneable
{
  protected int a;
  protected long a;
  public QQAppInterface a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  public HashMap a;
  private long jdField_b_of_type_Long;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public IContactSearchModel(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long a()
  {
    QQMessageFacade.Message localMessage;
    if (this.jdField_b_of_type_Long == -1L)
    {
      localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(a(), b());
      if (localMessage == null) {
        break label47;
      }
    }
    label47:
    for (this.jdField_b_of_type_Long = localMessage.time;; this.jdField_b_of_type_Long = 0L) {
      return this.jdField_b_of_type_Long;
    }
  }
  
  protected abstract long a(String paramString);
  
  public CharSequence a()
  {
    String str = c();
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.equals(this.jdField_c_of_type_JavaLangString)) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, b())))
      {
        this.jdField_c_of_type_JavaLangString = str;
        this.jdField_a_of_type_JavaLangString = b();
        this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, b(), 6);
      }
      return this.jdField_a_of_type_JavaLangCharSequence;
    }
    this.jdField_c_of_type_JavaLangString = null;
    return "";
  }
  
  public abstract Object a();
  
  public abstract String a();
  
  public abstract int b();
  
  public final long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public final long b(String paramString)
  {
    long l2 = a(paramString);
    long l1 = l2;
    if (l2 != Long.MIN_VALUE)
    {
      l1 = l2;
      if (b()) {
        l1 = l2 + (this.jdField_a_of_type_Long << SearchConfigManager.contactSearchRecentBaseBit);
      }
    }
    this.jdField_c_of_type_Long = l1;
    return l1;
  }
  
  public CharSequence b()
  {
    String str = d();
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.equals(this.d)) || (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, b())))
      {
        this.d = str;
        this.jdField_b_of_type_JavaLangString = b();
        this.jdField_b_of_type_JavaLangCharSequence = SearchUtils.a(SearchUtils.a(str, b(), 6));
      }
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    this.d = null;
    return null;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public abstract String c();
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public abstract CharSequence d();
  
  public abstract String d();
  
  public CharSequence e()
  {
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\IContactSearchModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */