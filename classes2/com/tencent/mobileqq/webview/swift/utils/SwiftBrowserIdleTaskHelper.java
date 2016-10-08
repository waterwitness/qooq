package com.tencent.mobileqq.webview.swift.utils;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import wjq;

public class SwiftBrowserIdleTaskHelper
{
  public static final int a = 1;
  private static SwiftBrowserIdleTaskHelper jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper;
  private static final String jdField_a_of_type_JavaLangString = "SwiftBrowserIdleTaskHelper";
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  public static final int b = 2;
  private final MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new wjq(this);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static SwiftBrowserIdleTaskHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper == null) {
        jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper = new SwiftBrowserIdleTaskHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper;
    }
    finally {}
  }
  
  public void a(SwiftBrowserIdleTaskHelper.IdleTask paramIdleTask)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((SwiftBrowserIdleTaskHelper.IdleTask)localIterator.next()).d != paramIdleTask.d);
    }
    do
    {
      return;
      jdField_a_of_type_JavaUtilArrayList.add(paramIdleTask);
    } while ((jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_Boolean = true;
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public boolean a(int paramInt)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SwiftBrowserIdleTaskHelper.IdleTask localIdleTask = (SwiftBrowserIdleTaskHelper.IdleTask)localIterator.next();
      if (localIdleTask.d == paramInt)
      {
        jdField_a_of_type_JavaUtilArrayList.remove(localIdleTask);
        return true;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\utils\SwiftBrowserIdleTaskHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */