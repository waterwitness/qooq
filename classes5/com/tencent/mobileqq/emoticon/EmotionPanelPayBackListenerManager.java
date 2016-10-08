package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class EmotionPanelPayBackListenerManager
{
  private static EmotionPanelPayBackListenerManager jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private EmotionPanelPayBackListenerManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static EmotionPanelPayBackListenerManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager = new EmotionPanelPayBackListenerManager();
      }
      return jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListenerManager;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmotionPanelPayBackListener localEmotionPanelPayBackListener = (EmotionPanelPayBackListener)((WeakReference)localIterator.next()).get();
        if (localEmotionPanelPayBackListener != null) {
          localEmotionPanelPayBackListener.a(paramInt);
        }
      }
    }
  }
  
  public void a(EmotionPanelPayBackListener paramEmotionPanelPayBackListener)
  {
    if (paramEmotionPanelPayBackListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmotionPanelPayBackListener) {
          return;
        }
      }
    }
    paramEmotionPanelPayBackListener = new WeakReference(paramEmotionPanelPayBackListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramEmotionPanelPayBackListener);
  }
  
  public void b(EmotionPanelPayBackListener paramEmotionPanelPayBackListener)
  {
    if (paramEmotionPanelPayBackListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmotionPanelPayBackListener) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticon\EmotionPanelPayBackListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */