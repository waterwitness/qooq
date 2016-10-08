package com.facebook.react.modules.systeminfo;

import android.os.Build.VERSION;
import com.facebook.react.bridge.BaseJavaModule;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class AndroidInfoModule
  extends BaseJavaModule
{
  @Nullable
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Version", Integer.valueOf(Build.VERSION.SDK_INT));
    return localHashMap;
  }
  
  public String getName()
  {
    return "AndroidConstants";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\systeminfo\AndroidInfoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */