package com.dataline.util;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class DatalineFilesAdapter$ItemHolder
  implements Cloneable
{
  int jdField_a_of_type_Int;
  public Button a;
  public ImageView a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public DLFileInfo a;
  public AsyncImageView a;
  public WaitTextView a;
  public ProgressBar b;
  public TextView b;
  public TextView c;
  
  public DatalineFilesAdapter$ItemHolder(DatalineFilesAdapter paramDatalineFilesAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProgressBar a()
  {
    return this.b;
  }
  
  public void a(ProgressBar paramProgressBar)
  {
    this.b = paramProgressBar;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("DatalineFilesAdapter", 2, "ItemHolder clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\DatalineFilesAdapter$ItemHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */