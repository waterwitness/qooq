package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.qphone.base.util.QLog;
import rbm;

public class MessageProgressTextView
  extends TextView
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "ProgressTextView";
  private MessageProgressTextView.ProgressListener jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener;
  private BaseTransProcessor jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
  private boolean jdField_a_of_type_Boolean;
  public rbm b;
  int c;
  public boolean c;
  int d;
  public boolean d;
  int e;
  
  public MessageProgressTextView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.e = 0;
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.e = 0;
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.e = 0;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor == null) {}
    label222:
    do
    {
      int i;
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.d() < 100) && (paramInt1 >= 100)) {
          i = 100;
        }
        do
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a(i);
          paramInt1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.g(), 0);
          long l = 25L;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.g() < 0) {
            l = 1000L;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.d() > paramInt1) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProgressTextView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a() + " processor " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
          }
          setProgress(i);
          if (this.b != null) {
            break;
          }
          this.b = new rbm(this, i, paramInt2);
          postDelayed(this.b, l);
          return;
          i = paramInt1;
        } while (paramInt1 < 100);
        this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = null;
        return;
      } while (paramInt2 == 1);
      this.b.b(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProgressTextView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a() + " processor " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
      }
    } while (paramInt1 < this.e);
    setProgress(paramInt1);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener.a();
    }
    return 0;
  }
  
  public MessageProgressTextView.ProgressListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressTextView", 2, "updateProgress processor:" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.d(), 1);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressTextView", 2, "updateToFinish processor:" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.d();
      int j = Math.max(1, (100 - i) / 10);
      if (QLog.isColorLevel()) {
        QLog.d("ProgressTextView", 2, "updateToFinish addProgress:" + j + ",currentProgress:" + i);
      }
      a(i, j);
    }
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.c = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void setProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor == paramBaseTransProcessor) {
      return;
    }
    if (this.b != null)
    {
      removeCallbacks(this.b);
      this.b = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = paramBaseTransProcessor;
  }
  
  public void setProgress(int paramInt)
  {
    this.e = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener.a(paramInt);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
      setText(paramInt + "%");
    }
    for (;;)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setLevel((100 - paramInt) * 100);
        if (((localDrawable instanceof AIOSendMask)) && (!this.jdField_d_of_type_Boolean)) {
          ((AIOSendMask)localDrawable).a(this.c, this.jdField_d_of_type_Int);
        }
      }
      return;
      setText("");
    }
  }
  
  public void setProgressListener(MessageProgressTextView.ProgressListener paramProgressListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener = paramProgressListener;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\customviews\MessageProgressTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */