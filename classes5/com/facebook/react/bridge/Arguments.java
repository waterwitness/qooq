package com.facebook.react.bridge;

import android.os.Bundle;
import com.facebook.common.logging.FLog;
import com.tencent.bitapp.pre.binder.server.proxy.jni.WritableNativeArray;
import com.tencent.bitapp.pre.binder.server.proxy.jni.WritableNativeMap;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

public class Arguments
{
  public static final String TAG = "Arguments";
  
  public static WritableArray createArray()
  {
    return new WritableNativeArray();
  }
  
  public static WritableMap createMap()
  {
    return new WritableNativeMap();
  }
  
  public static WritableArray fromArray(Object paramObject)
  {
    WritableArray localWritableArray = createArray();
    int j;
    int i;
    if ((paramObject instanceof String[]))
    {
      paramObject = (String[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localWritableArray.pushString(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramObject = (Bundle[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localWritableArray.pushMap(fromBundle2Map(paramObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localWritableArray.pushInt(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localWritableArray.pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (double[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localWritableArray.pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof long[]))
    {
      paramObject = (long[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localWritableArray.pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (boolean[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localWritableArray.pushBoolean(paramObject[i]);
        i += 1;
      }
    }
    if (FLog.isLoggable(3)) {
      throw new IllegalArgumentException("Unknown array type " + paramObject.getClass());
    }
    if (FLog.isLoggable(6)) {
      FLog.e("Arguments", "fromArray", new Object[] { "Unknown array type " + paramObject.getClass() });
    }
    return localWritableArray;
  }
  
  public static WritableNativeArray fromBundle2Array(Bundle paramBundle)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    if (paramBundle == null) {}
    int i;
    do
    {
      do
      {
        int j;
        do
        {
          return localWritableNativeArray;
          j = paramBundle.size() / 2;
          i = 0;
        } while (i >= j);
        localObject1 = String.valueOf(i);
      } while (!paramBundle.containsKey((String)localObject1));
      localObject2 = "type_" + (String)localObject1;
    } while (!paramBundle.containsKey((String)localObject2));
    Object localObject2 = ReadableType.valueOf(paramBundle.getString((String)localObject2, ""));
    Object localObject1 = paramBundle.get((String)localObject1);
    switch (localObject2)
    {
    default: 
      if (FLog.isLoggable(3)) {
        throw new IllegalArgumentException("Could not convert object with i: " + i + ".");
      }
      break;
    case ???: 
      localWritableNativeArray.pushNull();
    }
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 == null)
      {
        localWritableNativeArray.pushBoolean(false);
      }
      else if ((localObject1 instanceof Boolean))
      {
        localWritableNativeArray.pushBoolean(((Boolean)localObject1).booleanValue());
        continue;
        if (localObject1 == null)
        {
          localWritableNativeArray.pushInt(0);
        }
        else if ((localObject1 instanceof Integer))
        {
          localWritableNativeArray.pushInt(((Integer)localObject1).intValue());
        }
        else if ((localObject1 instanceof Double))
        {
          localWritableNativeArray.pushDouble(((Double)localObject1).doubleValue());
          continue;
          if (localObject1 == null)
          {
            localWritableNativeArray.pushDouble(0.0D);
          }
          else if ((localObject1 instanceof Double))
          {
            localWritableNativeArray.pushDouble(((Double)localObject1).doubleValue());
            continue;
            if (localObject1 == null)
            {
              localWritableNativeArray.pushString(null);
            }
            else if ((localObject1 instanceof String))
            {
              localWritableNativeArray.pushString((String)localObject1);
              continue;
              if (localObject1 == null)
              {
                localWritableNativeArray.pushMap(createMap());
              }
              else if ((localObject1 instanceof Bundle))
              {
                localWritableNativeArray.pushMap(fromBundle2Map((Bundle)localObject1));
              }
              else if (FLog.isLoggable(6))
              {
                FLog.e("Arguments", "fromBundle2Array error map ", new Object[] { localObject1.getClass() });
                continue;
                if (localObject1 == null)
                {
                  localWritableNativeArray.pushArray(createArray());
                }
                else if ((localObject1 instanceof Bundle))
                {
                  localWritableNativeArray.pushArray(fromBundle2Array((Bundle)localObject1));
                }
                else if (localObject1.getClass().isArray())
                {
                  localWritableNativeArray.pushArray(fromArray(localObject1));
                }
                else if (FLog.isLoggable(6))
                {
                  FLog.e("Arguments", "fromBundle2Array error array ", new Object[] { localObject1.getClass() });
                  continue;
                  if (FLog.isLoggable(6)) {
                    FLog.e("Arguments", "fromBundle2Array", new Object[] { "Could not convert object with i: " + i + "." });
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static WritableMap fromBundle2Map(Bundle paramBundle)
  {
    WritableMap localWritableMap = createMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (localObject == null)
      {
        localWritableMap.putNull(str);
      }
      else if (localObject.getClass().isArray())
      {
        localWritableMap.putArray(str, fromArray(localObject));
      }
      else if ((localObject instanceof String))
      {
        localWritableMap.putString(str, (String)localObject);
      }
      else if ((localObject instanceof Boolean))
      {
        localWritableMap.putBoolean(str, ((Boolean)localObject).booleanValue());
      }
      else if ((localObject instanceof Byte))
      {
        localWritableMap.putInt(str, ((Byte)localObject).intValue());
      }
      else if ((localObject instanceof Short))
      {
        localWritableMap.putInt(str, ((Short)localObject).intValue());
      }
      else if ((localObject instanceof Character))
      {
        localWritableMap.putInt(str, ((Character)localObject).charValue());
      }
      else if ((localObject instanceof Integer))
      {
        localWritableMap.putInt(str, ((Integer)localObject).intValue());
      }
      else if ((localObject instanceof Double))
      {
        localWritableMap.putDouble(str, ((Double)localObject).doubleValue());
      }
      else if ((localObject instanceof Long))
      {
        localWritableMap.putDouble(str, ((Long)localObject).doubleValue());
      }
      else if ((localObject instanceof Float))
      {
        localWritableMap.putDouble(str, ((Float)localObject).doubleValue());
      }
      else if ((localObject instanceof Bundle))
      {
        localWritableMap.putMap(str, fromBundle2Map((Bundle)localObject));
      }
      else
      {
        if (FLog.isLoggable(3)) {
          throw new IllegalArgumentException("Could not convert " + localObject.getClass());
        }
        if (FLog.isLoggable(6)) {
          FLog.e("Arguments", "fromBundle2Map", new Object[] { "Could not convert " + localObject.getClass() });
        }
      }
    }
    return localWritableMap;
  }
  
  public static WritableNativeArray fromJavaArgs(Object[] paramArrayOfObject)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    int i;
    int j;
    label18:
    Object localObject;
    if (paramArrayOfObject == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return localWritableNativeArray;
      }
      localObject = paramArrayOfObject[j];
      if (localObject != null) {
        break label54;
      }
      localWritableNativeArray.pushNull();
    }
    for (;;)
    {
      j += 1;
      break label18;
      i = paramArrayOfObject.length;
      break;
      label54:
      Class localClass = localObject.getClass();
      if (localClass == Boolean.class)
      {
        localWritableNativeArray.pushBoolean(((Boolean)localObject).booleanValue());
      }
      else if (localClass == Integer.class)
      {
        localWritableNativeArray.pushInt(((Integer)localObject).intValue());
      }
      else if (localClass == Double.class)
      {
        localWritableNativeArray.pushDouble(((Double)localObject).doubleValue());
      }
      else if (localClass == Float.class)
      {
        localWritableNativeArray.pushDouble(((Float)localObject).doubleValue());
      }
      else if (localClass == String.class)
      {
        localWritableNativeArray.pushString(localObject.toString());
      }
      else if (localClass == WritableNativeMap.class)
      {
        localWritableNativeArray.pushMap((WritableNativeMap)localObject);
      }
      else if (localClass == WritableNativeArray.class)
      {
        localWritableNativeArray.pushArray((WritableNativeArray)localObject);
      }
      else if (localClass.isArray())
      {
        localWritableNativeArray.pushArray(fromArray(localObject));
      }
      else
      {
        if (FLog.isLoggable(3)) {
          throw new RuntimeException("Cannot convert argument of type " + localClass);
        }
        if (FLog.isLoggable(6)) {
          FLog.e("Arguments", "fromJavaArgs", new Object[] { "Cannot convert argument of type " + localClass });
        }
      }
    }
    return localWritableNativeArray;
  }
  
  public static Bundle toBundle(ReadableArray paramReadableArray)
  {
    Bundle localBundle = new Bundle();
    if (paramReadableArray == null) {}
    int j;
    int i;
    do
    {
      do
      {
        return localBundle;
        j = paramReadableArray.size();
      } while (j <= 0);
      i = 0;
    } while (i >= j);
    String str1 = i + "";
    String str2 = "type_" + str1;
    ReadableType localReadableType = paramReadableArray.getType(i);
    localBundle.putString(str2, localReadableType.toString());
    switch (localReadableType)
    {
    default: 
      throw new IllegalArgumentException("Could not convert object with i: " + i + ", type is: " + localReadableType);
    case ???: 
      localBundle.putString(str1, null);
    }
    for (;;)
    {
      i += 1;
      break;
      localBundle.putBoolean(str1, paramReadableArray.getBoolean(i));
      continue;
      double d = paramReadableArray.getDouble(i);
      if ((d > 2.147483647E9D) || (d < -2.147483648E9D))
      {
        localBundle.putDouble(str1, d);
      }
      else
      {
        localBundle.putInt(str1, paramReadableArray.getInt(i));
        continue;
        localBundle.putDouble(str1, paramReadableArray.getDouble(i));
        continue;
        localBundle.putString(str1, paramReadableArray.getString(i));
        continue;
        localBundle.putBundle(str1, toBundle(paramReadableArray.getMap(i)));
        continue;
        localBundle.putBundle(str1, toBundle(paramReadableArray.getArray(i)));
      }
    }
  }
  
  @Nullable
  public static Bundle toBundle(@Nullable ReadableMap paramReadableMap)
  {
    Bundle localBundle = new Bundle();
    if (paramReadableMap == null) {}
    for (;;)
    {
      return localBundle;
      ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
      if (localReadableMapKeySetIterator.hasNextKey()) {
        while (localReadableMapKeySetIterator.hasNextKey())
        {
          String str = localReadableMapKeySetIterator.nextKey();
          ReadableType localReadableType = paramReadableMap.getType(str);
          switch (localReadableType)
          {
          default: 
            throw new IllegalArgumentException("Could not convert object with key: " + str + ".");
          case ???: 
            localBundle.putString(str, null);
            break;
          case ???: 
            localBundle.putBoolean(str, paramReadableMap.getBoolean(str));
            break;
          case ???: 
            double d;
            try
            {
              d = paramReadableMap.getDouble(str);
              if ((d <= -2.147483648E9D) || (d >= 2.147483647E9D)) {
                break label231;
              }
              localBundle.putInt(str, (int)d);
            }
            catch (Exception localException) {}
            if (FLog.isLoggable(4))
            {
              FLog.i("Arguments", "int64 -> int32 may cause errors, be careful. ", localException);
              continue;
              localBundle.putDouble(localException, d);
            }
            break;
          case ???: 
            localBundle.putDouble(localException, paramReadableMap.getDouble(localException));
            break;
          case ???: 
            localBundle.putString(localException, paramReadableMap.getString(localException));
            break;
          case ???: 
            localBundle.putBundle(localException, toBundle(paramReadableMap.getMap(localException)));
            break;
          case ???: 
            label231:
            localBundle.putBundle(localException, toBundle(paramReadableMap.getArray(localException)));
          }
        }
      }
    }
  }
  
  public static Bundle toBundle(Object[] paramArrayOfObject)
  {
    Bundle localBundle = new Bundle();
    if (paramArrayOfObject == null) {}
    int j;
    do
    {
      return localBundle;
      j = paramArrayOfObject.length;
    } while (j <= 0);
    int i = 0;
    label26:
    String str1;
    String str2;
    Object localObject;
    Class localClass;
    if (i < j)
    {
      str1 = i + "";
      str2 = "type_" + str1;
      localObject = paramArrayOfObject[i];
      if (localObject != null) {
        break label120;
      }
      localClass = null;
      label88:
      if (localObject != null) {
        break label129;
      }
      localBundle.putString(str2, ReadableType.Null.toString());
      localBundle.putString(str1, null);
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label120:
      localClass = localObject.getClass();
      break label88;
      label129:
      if (localClass == Boolean.class)
      {
        localBundle.putString(str2, ReadableType.Boolean.toString());
        localBundle.putBoolean(str1, ((Boolean)localObject).booleanValue());
      }
      else if (localClass == Long.class)
      {
        localBundle.putString(str2, ReadableType.Number.toString());
        localBundle.putDouble(str1, ((Long)localObject).doubleValue());
      }
      else if (localClass == Integer.class)
      {
        localBundle.putString(str2, ReadableType.Number.toString());
        localBundle.putInt(str1, ((Integer)localObject).intValue());
      }
      else if (localClass == Double.class)
      {
        localBundle.putString(str2, ReadableType.Double.toString());
        localBundle.putDouble(str1, ((Double)localObject).doubleValue());
      }
      else if (localClass == Float.class)
      {
        localBundle.putString(str2, ReadableType.Double.toString());
        localBundle.putDouble(str1, ((Float)localObject).doubleValue());
      }
      else if (localClass == String.class)
      {
        localBundle.putString(str2, ReadableType.String.toString());
        localBundle.putString(str1, (String)localObject);
      }
      else if (localClass == WritableNativeMap.class)
      {
        localBundle.putString(str2, ReadableType.Map.toString());
        localBundle.putBundle(str1, toBundle((ReadableMap)localObject));
      }
      else
      {
        if (localClass != WritableNativeArray.class) {
          break label399;
        }
        localBundle.putString(str2, ReadableType.Array.toString());
        localBundle.putBundle(str1, toBundle((ReadableArray)localObject));
      }
    }
    label399:
    throw new RuntimeException("Cannot convert argument of type " + localClass);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\Arguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */