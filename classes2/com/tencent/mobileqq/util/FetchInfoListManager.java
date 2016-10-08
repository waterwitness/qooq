package com.tencent.mobileqq.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import vyi;

public class FetchInfoListManager
{
  private static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 30000L;
  private static final String jdField_a_of_type_JavaLangString = FetchInfoListManager.class.getSimpleName();
  private static final int jdField_b_of_type_Int = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FetchInfoListManager.FetchInfoListener jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener;
  private FetchInfoReq jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private LinkedList jdField_b_of_type_JavaUtilLinkedList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FetchInfoListManager(FetchInfoListManager.FetchInfoListener paramFetchInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener = paramFetchInfoListener;
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq = new FetchInfoReq();
    this.jdField_a_of_type_AndroidOsHandler = new vyi(this, Looper.getMainLooper());
  }
  
  private boolean a(FetchInfoReq paramFetchInfoReq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        boolean bool3 = this.jdField_a_of_type_JavaUtilLinkedList.contains(paramFetchInfoReq);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramFetchInfoReq)
    {
      paramFetchInfoReq.printStackTrace();
    }
    return false;
  }
  
  private void b()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {}
    for (;;)
    {
      return;
      try
      {
        if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
        {
          localObject1 = (FetchInfoReq)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
          if (QLog.isColorLevel())
          {
            String str = jdField_a_of_type_JavaLangString;
            if (localObject1 != null)
            {
              localObject2 = ((FetchInfoReq)localObject1).toString();
              QLog.d(str, 2, StringUtil.a(new Object[] { "doFetchInfo()", localObject2 }));
            }
          }
          else
          {
            if ((localObject1 != null) && (!b((FetchInfoReq)localObject1)))
            {
              if (this.b == null) {
                this.b = new LinkedList();
              }
              this.b.add(localObject1);
              localObject2 = Message.obtain();
              ((Message)localObject2).what = 2;
              ((Message)localObject2).obj = localObject1;
              this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, 30000L);
              if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener != null) {
                this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener.a((FetchInfoReq)localObject1);
              }
            }
            if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
              continue;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
            return;
          }
        }
      }
      catch (NoSuchElementException localNoSuchElementException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, localNoSuchElementException.toString());
            localObject1 = localObject2;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, localException.toString());
            localObject1 = localObject2;
            continue;
            localObject2 = "req is null";
            continue;
            localObject1 = null;
          }
        }
      }
    }
  }
  
  private boolean b(FetchInfoReq paramFetchInfoReq)
  {
    return (this.b != null) && (this.b.contains(paramFetchInfoReq));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq.a(paramInt, paramString1, paramString2, paramObject, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, StringUtil.a(new Object[] { "addToNeedFetchInfoList()", this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq.toString() }));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq.a()) {}
    do
    {
      return;
      if ((!a(this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq)) && (!b(this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, StringUtil.a(new Object[] { "addToNeedFetchInfoList()", this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq.toString(), "已经在队列中了" }));
    return;
    if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
      this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    }
    paramString1 = new FetchInfoReq(paramInt, paramString1, paramString2, paramObject, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramString1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    FetchInfoReq localFetchInfoReq = new FetchInfoReq();
    localFetchInfoReq.a(paramInt, paramString1, paramString2, paramObject, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, StringUtil.a(new Object[] { "dealFetchedInfo()", localFetchInfoReq.toString(), Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilLinkedList != null)) {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(localFetchInfoReq);
    }
    if (this.b != null) {
      this.b.remove(localFetchInfoReq);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, localFetchInfoReq);
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)) && ((this.b == null) || (this.b.size() == 0));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FetchInfoListManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */