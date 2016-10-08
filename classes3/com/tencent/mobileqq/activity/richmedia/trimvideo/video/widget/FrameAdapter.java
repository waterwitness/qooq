package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FrameAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "FrameAdapter";
  private FrameAdapter.DataSetChangeListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public FrameAdapter(FrameAdapter.DataSetChangeListener paramDataSetChangeListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener = paramDataSetChangeListener;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
  }
  
  public FramesProcessor.Frame a(int paramInt)
  {
    return (FramesProcessor.Frame)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      FramesProcessor.Frame localFrame = (FramesProcessor.Frame)localIterator.next();
      localFrame.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localFrame.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(FrameAdapter.DataSetChangeListener paramDataSetChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener = paramDataSetChangeListener;
  }
  
  public void a(FramesProcessor.Frame paramFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + paramFrame.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramFrame.jdField_a_of_type_Int), paramFrame);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter$DataSetChangeListener.a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\trimvideo\video\widget\FrameAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */