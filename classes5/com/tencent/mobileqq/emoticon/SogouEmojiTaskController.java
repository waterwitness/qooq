package com.tencent.mobileqq.emoticon;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import rjm;
import rjn;

public class SogouEmojiTaskController
{
  public static final String a;
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Map jdField_a_of_type_JavaUtilMap;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SogouEmojiTaskController.class.getSimpleName();
  }
  
  public SogouEmojiTaskController(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmojiTaskController begins");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    d();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmojiTaskController ends");
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func addTask begins, packId:" + paramString1 + ",exprId:" + paramString2);
    }
    rjn localrjn = new rjn();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    localrjn.jdField_a_of_type_JavaLangString = paramString1;
    localrjn.b = paramString2;
    localrjn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localrjn);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func addTask ends, mCurTaskId:" + this.jdField_a_of_type_Int);
    }
    b(2131370344);
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onDestroy begins");
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onDestroy ends");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func removeTask begins, taskId:" + paramInt + ",mEmojiTaskHashMap:" + this.jdField_a_of_type_JavaUtilMap);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func removeTask ends");
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func isTaskInMap begins, taskId:" + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      if ((rjn)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "func isTaskInMap ends, taskId:" + paramInt + ",exists=" + bool);
        }
        return bool;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func isTaskInMap ends, taskId:" + paramInt + " NOT exist, cause map is null.");
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func showProgressDialog begins, textResId:" + paramInt);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          continue;
        }
        c();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.jdField_a_of_type_AndroidAppProgressDialog.show();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func showProgressDialog ends, ERROR! msg:" + localThrowable.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func showProgressDialog ends");
      }
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 2131558973);
      this.jdField_a_of_type_AndroidAppProgressDialog.setOnDismissListener(new rjm(this));
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665));
    }
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func cancleProgressDailog begins");
    }
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func cancleProgressDailog ends");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticon\SogouEmojiTaskController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */