package com.tencent.mobileqq.activity.bless;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class BlessWording
  extends Entity
{
  private String editingWording;
  @unique
  public String wording;
  
  public BlessWording() {}
  
  public BlessWording(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.wording = paramString;
  }
  
  public String getEditingWording()
  {
    return this.editingWording;
  }
  
  public boolean hasEditingWording()
  {
    return !TextUtils.isEmpty(this.editingWording);
  }
  
  public void setEditingWording(String paramString)
  {
    this.editingWording = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessWording.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */