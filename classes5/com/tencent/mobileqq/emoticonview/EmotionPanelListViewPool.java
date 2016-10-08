package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmotionPanelListViewPool
{
  private static EmotionPanelListViewPool jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool;
  public static final String a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = EmotionPanelListViewPool.class.getSimpleName();
  }
  
  public static EmotionPanelListViewPool a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool = new EmotionPanelListViewPool();
      }
      return jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewPool;
    }
    finally {}
  }
  
  public EmotionPanelListView a(Context paramContext)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      paramContext = (EmotionPanelListView)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (QLog.isColorLevel()) {
        Log.d(jdField_a_of_type_JavaLangString, "from listview pool and poolSize = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      return paramContext;
    }
    return new EmotionPanelListView(paramContext);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      Log.d(jdField_a_of_type_JavaLangString, "destory");
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView)
  {
    if (paramEmotionPanelListView == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(paramEmotionPanelListView);
      }
      while (QLog.isColorLevel())
      {
        Log.d(jdField_a_of_type_JavaLangString, "relase listview");
        return;
        if (!this.jdField_a_of_type_JavaUtilList.contains(paramEmotionPanelListView)) {
          this.jdField_a_of_type_JavaUtilList.add(0, paramEmotionPanelListView);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPanelListViewPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */