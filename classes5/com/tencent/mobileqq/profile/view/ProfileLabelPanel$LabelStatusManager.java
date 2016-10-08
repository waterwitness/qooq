package com.tencent.mobileqq.profile.view;

import android.widget.ToggleButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import java.util.HashMap;
import java.util.Map;

public class ProfileLabelPanel$LabelStatusManager
{
  private Map a;
  
  public ProfileLabelPanel$LabelStatusManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new HashMap();
  }
  
  public ToggleButton a(ProfileLabelInfo paramProfileLabelInfo)
  {
    return (ToggleButton)this.a.get(paramProfileLabelInfo);
  }
  
  public Map a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
  {
    if (!a(paramProfileLabelInfo)) {
      this.a.put(paramProfileLabelInfo, paramToggleButton);
    }
  }
  
  public boolean a(ProfileLabelInfo paramProfileLabelInfo)
  {
    return this.a.get(paramProfileLabelInfo) != null;
  }
  
  public void b(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
  {
    if (a(paramProfileLabelInfo)) {
      this.a.remove(paramProfileLabelInfo);
    }
  }
  
  public void c(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
  {
    if (paramProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_NORMAL) {
      a(paramProfileLabelInfo, paramToggleButton);
    }
    for (;;)
    {
      paramProfileLabelInfo.toggleStatus();
      paramToggleButton.toggle();
      return;
      if (paramProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
        b(paramProfileLabelInfo, paramToggleButton);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\ProfileLabelPanel$LabelStatusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */