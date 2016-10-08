package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import pdz;

public class RMVideoThumbGenMgr
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  RMVideoThumbGenMgr.ThumbGenItem jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem;
  private Object jdField_a_of_type_JavaLangObject;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public RMVideoThumbGenMgr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  int a(RMVideoThumbGenMgr.ThumbGenItem paramThumbGenItem, boolean paramBoolean)
  {
    int i = 1;
    if (paramThumbGenItem == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramThumbGenItem.jdField_a_of_type_Boolean = true;
        j = paramThumbGenItem.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramThumbGenItem.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          FileUtils.d(paramThumbGenItem.jdField_c_of_type_JavaLangString);
          paramThumbGenItem.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramThumbGenItem.jdField_b_of_type_JavaLangString == null);
    FileUtils.d(paramThumbGenItem.jdField_b_of_type_JavaLangString);
    paramThumbGenItem.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public RMVideoThumbGenMgr.ThumbGenItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  public void b()
  {
    RMVideoThumbGenMgr.ThumbGenItem localThumbGenItem = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localThumbGenItem = (RMVideoThumbGenMgr.ThumbGenItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localThumbGenItem == null) || (a(localThumbGenItem, localThumbGenItem.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localThumbGenItem);
      return;
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    RMVideoThumbGenMgr.ThumbGenItem localThumbGenItem = new RMVideoThumbGenMgr.ThumbGenItem(this);
    localThumbGenItem.jdField_a_of_type_Boolean = false;
    localThumbGenItem.jdField_a_of_type_JavaLangString = paramString;
    localThumbGenItem.jdField_a_of_type_Int = paramInt1;
    localThumbGenItem.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localThumbGenItem.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localThumbGenItem.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem = localThumbGenItem;
    localThumbGenItem.jdField_a_of_type_Pdz.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem = localThumbGenItem;
    localThumbGenItem.jdField_a_of_type_Pdz.execute(new Void[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\state\RMVideoThumbGenMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */