package com.facebook.react.modules.storage;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

public class AsyncStorageErrorUtil
{
  static WritableMap getDBError(@Nullable String paramString)
  {
    return getError(paramString, "Database Error");
  }
  
  static WritableMap getError(@Nullable String paramString1, String paramString2)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("message", paramString2);
    if (paramString1 != null) {
      localWritableMap.putString("key", paramString1);
    }
    return localWritableMap;
  }
  
  static WritableMap getInvalidKeyError(@Nullable String paramString)
  {
    return getError(paramString, "Invalid key");
  }
  
  static WritableMap getInvalidValueError(@Nullable String paramString)
  {
    return getError(paramString, "Invalid Value");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\storage\AsyncStorageErrorUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */