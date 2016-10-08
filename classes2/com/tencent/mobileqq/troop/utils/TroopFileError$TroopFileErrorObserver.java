package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class TroopFileError$TroopFileErrorObserver
  extends BizTroopObserver
{
  public int a;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileError.TroopFileErrorFilter jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorFilter;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public TroopFileError$TroopFileErrorObserver(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  public TroopFileError$TroopFileErrorObserver(Context paramContext, TroopFileError.TroopFileErrorFilter paramTroopFileErrorFilter, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorFilter = paramTroopFileErrorFilter;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof TroopFileError.SimpleErrorInfo))) {}
    Context localContext;
    do
    {
      return;
      paramObject = (TroopFileError.SimpleErrorInfo)paramObject;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localContext == null);
    TroopFileError.a((TroopFileError.SimpleErrorInfo)paramObject, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileError$TroopFileErrorObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */