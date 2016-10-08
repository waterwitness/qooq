package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class ReadInJoyXListView$UICallBack
  implements Handler.Callback
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ReadInJoyXListView$UICallBack(ReadInJoyXListView paramReadInJoyXListView1, ReadInJoyXListView paramReadInJoyXListView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInJoyXListView2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((ReadInJoyXListView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d();
      return true;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoyXListView$UICallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */